package com.hengyunsoft.platform.search.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SearchException;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationResDTO;
import com.hengyunsoft.platform.search.api.AdminApi;
import com.hengyunsoft.platform.search.dto.OptCollection2AppDTO;
import com.hengyunsoft.platform.search.dto.OptCollectionDTO;
import com.hengyunsoft.platform.search.dto.OptCollstionListDTO;
import com.hengyunsoft.platform.search.entity.core.po.AppOptCollection;
import com.hengyunsoft.platform.search.entity.core.po.Collection;
import com.hengyunsoft.platform.search.entity.core.po.OptClollection;
import com.hengyunsoft.platform.search.repository.core.service.AppOptcollectionService;
import com.hengyunsoft.platform.search.repository.core.service.CollectionService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * com.hengyunsoft.platform.search.api.hystrix
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：集合管理api
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：新增基础接口
 */
@Api(value = "API - AdminApiHystrix.java", description = "集合管理api")
@RestController
@RequestMapping("adminModule")
@Slf4j
public class AdminApiImpl implements AdminApi {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private AppOptcollectionService appOptcollectionService;
    @Autowired
    private ApplicationApi applicationApi;

    /**
     * 描述：查看登录用户的所有集合
     * 参数：集合列表
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容： 新增
     */
    @RequestMapping(value = "showMyCollection", method = RequestMethod.GET)
    @Override
    public Result<OptCollstionListDTO> showMyCollection() {
        // Long adminId = BaseContextHandler.getAdminId();
        //得到用户管理的所有应用
        Result<List<ApplicationResDTO>> allAdminappRes = applicationApi.find();
        List<ApplicationResDTO> allAppAdmin = allAdminappRes.getData();

        //找到所有应用对应的集合权限返回
        List<OptCollectionDTO> optCollList = new ArrayList<>();
        Set<Long> hasColles = new HashSet<>();
        for (ApplicationResDTO ard : allAppAdmin) {
            List<OptClollection> allColls = collectionService.getAllOptByAppId(ard.getAppId());
            for (OptClollection optc : allColls) {
                if(hasColles.contains(optc.getCollectionId())){
                    break;
                }
                hasColles.add(optc.getCollectionId());

                OptCollectionDTO ocd = new OptCollectionDTO();
                ocd.setAppId(optc.getAppId());
                ocd.setAppName(getAppName(optc.getAppId()));
                ocd.setCollectionCode(optc.getCollectionCode());
                ocd.setCollectionId(optc.getCollectionId());
                ocd.setCollectionName(optc.getCollectionName());
                ocd.setCreateAppId(optc.getCreateAppId());
                ocd.setCreateAppName(getAppName(optc.getCreateAppId()));
                ocd.setId(optc.getId());
                ocd.setOpt(optc.getOpt());
                ocd.setUserId(optc.getCreateUserId());
                optCollList.add(ocd);
            }
        }
        OptCollstionListDTO optList = new OptCollstionListDTO();
        optList.setOptCollList(optCollList);
        return Result.success(optList);
    }

    /**
     * 描述：集合指派给需要查询的app
     * 参数：collectionId：集合id，appId：appid,opt:要赋予的权限(0,没有权限,1读，2写，3读写)
     * 返回值：成功或者失败
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：新增
     */
    @RequestMapping(value = "appointCollection2App", method = RequestMethod.POST)
    @Override
    @ApiResponses({
            @ApiResponse(code = 80021, message = "分配集合权限没有操作该集合的权限"),
            @ApiResponse(code = 80001, message = "appid不能为空"),
            @ApiResponse(code = 80022, message = "分配集合权限权限参数为空"),
            @ApiResponse(code = 80023, message = "分配集合权限该APP不存在"),
            @ApiResponse(code = 80024, message = "分配集合权限参数不能为空"),
            @ApiResponse(code = 80025, message = "分配集合集合ID参数不能为空"),
            @ApiResponse(code = 80026, message = "分配集合权限权限参数错误"),
    })
    public Result<Boolean> appointCollection2App(@RequestBody OptCollection2AppDTO optCollection2AppDTO) {
        BizAssert.assertNotNull(SearchException.SEARCH_ADMIN_APPOINT_DATA, optCollection2AppDTO);
        BizAssert.assertNotNull(SearchException.SEARCH_ADMIN_APPOINT_COLL_HAS_NOT, optCollection2AppDTO.getCollectionId());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_APPID, optCollection2AppDTO.getAppId());
        BizAssert.assertNotNull(SearchException.SEARCH_ADMIN_APPOINT_OPT_HST_NOT, optCollection2AppDTO.getOpt());

        if (optCollection2AppDTO.getOpt() < 0 || optCollection2AppDTO.getOpt() > 3) {
            BizAssert.fail(SearchException.SEARCH_ADMIN_APPOINT_OPT_ONT_RIGHT);
        }
        Collection collection = collectionService.getById(optCollection2AppDTO.getCollectionId());
        Long adminId = BaseContextHandler.getAdminId();
        if (collection.getCreateUserId() != adminId) {
            BizAssert.fail(SearchException.SEARCH_ADMIN_APPOINT_HAS_NOT_OPT);
        }

        Result<List<AppShowDto>> appIdList = applicationApi.findAppIdList(1L);
        boolean hasApp = false;
        for (AppShowDto asd : appIdList.getData()) {
            if (asd.getAppId().equals(optCollection2AppDTO.getAppId())) {
                hasApp = true;
                break;
            }
        }
        if (!hasApp) {
            BizAssert.fail(SearchException.SEARCH_ADMIN_APPOINT_APP_HAS_BOT);
        }
        AppOptCollection appOpt = new AppOptCollection();
        appOpt.setAppId(optCollection2AppDTO.getAppId());
        appOpt.setCollectionId(optCollection2AppDTO.getCollectionId());
        appOpt.setOpt(optCollection2AppDTO.getOpt());
        appOpt.setUpdateTime(new Date());
        appOptcollectionService.saveOrUpdate(appOpt);

        return Result.success(true);
    }

    /**
     * 描述：得到collectionIdd对应appid的权限
     * 参数：collectionId:集合id  appId:appId
     * 返回值：权限值
     * 修改人：gbl
     * 修改时间：2018/4/12
     * 修改内容：
     */
    @RequestMapping(value = "getColleAppIpOpt", method = RequestMethod.GET)
    @Override
    @ApiResponses({
            @ApiResponse(code = 80021, message = "集合id不能为空"),
            @ApiResponse(code = 80001, message = "appid不能为空"),
    })
    public Result<Integer> getColleAppIpOpt(Long collectionId, String appId) {
        BizAssert.assertNotNull(SearchException.SEARCH_ADMIN_COLLECTION_ID_NULL, collectionId);
        BizAssert.assertNotNull(SearchException.SEARCH_CREATE_APPID, appId);

        List<AppOptCollection> list = appOptcollectionService.getByAppIdAndCollectionid(collectionId, appId);
        if (list == null || list.size() == 0) {
            return Result.success(0);
        } else {
            return Result.success(list.get(0).getOpt());
        }
    }

    /**
     * 描述：查看拥有该集合权限的所有app
     * 参数：collectionId集合id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容： 新增
     */
    @RequestMapping(value = "showCollectionApp",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 80021, message = "集合id不能为空"),
    })
    public Result<OptCollstionListDTO> showCollectionApp(Long collectionId) {
        BizAssert.assertNotNull(SearchException.SEARCH_ADMIN_COLLECTION_ID_NULL, collectionId);
        //找到所有应用对应的集合权限返回
        List<OptCollectionDTO> optCollList = new ArrayList<>();
        List<AppOptCollection> byCollectionid = appOptcollectionService.getByCollectionid(collectionId);
        for (AppOptCollection optc : byCollectionid) {
            OptCollectionDTO ocd = new OptCollectionDTO();

            ocd.setAppId(optc.getAppId());
            ocd.setAppName(getAppName(optc.getAppId()));
            ocd.setCollectionId(optc.getCollectionId());
            ocd.setId(optc.getId());
            ocd.setOpt(optc.getOpt());
            optCollList.add(ocd);
        }
        OptCollstionListDTO optList = new OptCollstionListDTO();
        optList.setOptCollList(optCollList);
        return Result.success(optList);
    }

    private String getAppName(String appId) {
        Result<List<ApplicationResDTO>> listResult = applicationApi.find();
        List<ApplicationResDTO> data = listResult.getData();
        for (ApplicationResDTO app : data) {
            if (app.getAppId().equals(appId)) {
                return app.getName();
            }
        }
        return null;
    }
}
