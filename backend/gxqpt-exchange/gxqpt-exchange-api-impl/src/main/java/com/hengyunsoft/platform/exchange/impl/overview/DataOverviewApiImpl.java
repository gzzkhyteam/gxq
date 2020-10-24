package com.hengyunsoft.platform.exchange.impl.overview;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiReturnDataDTO;
import com.hengyunsoft.platform.exchange.api.overview.dto.ApiViewDTO;
import com.hengyunsoft.platform.exchange.api.overview.dto.DirOrgDTO;
import com.hengyunsoft.platform.exchange.api.overview.dto.DirViewDTO;
import com.hengyunsoft.platform.exchange.api.overview.dto.OrgDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenDataCountDTO;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.constant.ShareType;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiListDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareCountView;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataView;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnitWare;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgDO;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiCallExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiCallService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryWareService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitWareService;
import com.hengyunsoft.platform.exchange.repository.screen.service.DataOverviewService;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareJoinOrgService;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据概览
 *
 * @author wgj
 * @createTime 2018-01-25 10:49
 */
@RestController
@Slf4j
@RequestMapping("overview")
@Api(value = "数据概览", description = "数据概览，包含单位数据量，或按照领域，主题等查询")
public class DataOverviewApiImpl /*implements DataOverviewApi*/ {
    @Autowired
    IdGenerate<Long> idGenerate;
    @Autowired
    DataDirectoryWareService dataDirectoryWareService;
    @Autowired
    DataDirectoryService dataDirectoryService;
    @Autowired
    ShareJoinOrgService shareJoinOrgService;
    @Autowired
    ShareDataSetService shareDataSetService;
    @Autowired
    ShareDataApiService shareDataApiService;
    @Autowired
    ShareDataApiCallService shareDataApiCallService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    DataOverviewService dataOverviewService;
    @Autowired
    private ShareUnitWareService shareUnitWareService;
    @Autowired
    private CommonService commonService;

    /**
     * 查询首页统计数据
     * 包含接入部门，数据目录，数据集，API,访问量，调用次数
     *
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @ApiOperation(value = "查询首页统计数据", notes = "查询首页统计数据")
    @RequestMapping(value = "/getShareDataCount", method = RequestMethod.POST)
    
    public Result<ScreenDataCountDTO> getShareDataCount() {
        ScreenDataCountDTO countdto = new ScreenDataCountDTO();
        //接入部门
       // int joinOrgCount = shareJoinOrgService.count(new ShareJoinOrgExample());
        ShareDataDirectoryWareExample directoryWareExample = new ShareDataDirectoryWareExample();
        directoryWareExample.createCriteria().andParentIdEqualTo(ExchangeConstants.DIR_PARENT_ID);
        int joinOrgCount = dataDirectoryWareService.count(directoryWareExample);
        countdto.setJoinOrgCount(joinOrgCount);
        //数据目录
        ShareDataDirectoryWareExample example = new ShareDataDirectoryWareExample();
        example.createCriteria().andIsBottomEqualTo(ExchangeConstants.IS_BOTTOM_YES);
        int dirCount = dataDirectoryWareService.count(example);
        countdto.setDirectoryCount(dirCount);
        //数据集
        ShareDataSetExample setExample = new ShareDataSetExample();
        setExample.createCriteria().andStatusEqualTo(ExchangeConstants.DATA_SET_ON_SHELF);
        int setCount = shareDataSetService.count(setExample);
        countdto.setSetCount(setCount);
        //API数量
        ShareDataApiExample apiExample = new ShareDataApiExample();
        apiExample.createCriteria().andAuthStatusEqualTo(ExchangeConstants.API_AUTH_STATUS_PASS);
        int apiCount = shareDataApiService.count(apiExample);
        countdto.setApiCount(apiCount);
        //调用次数
        int callCount = shareDataApiCallService.count(new ShareDataApiCallExample());
        countdto.setCallCount(callCount);
        return Result.success(countdto);
    }

    /**
     * @return boolean
     * @todo 根据业务类型查询数据量
     * @Author wgj
     * @createtime 2018-4-22
     */
    @ApiOperation(value = "根据业务类型查询数据量", notes = "根据业务类型查询数据量")
    @RequestMapping(value = "/getBusDataList", method = RequestMethod.POST)
    
    public Result<PageInfo<DirOrgDTO>> getBusDataList(@RequestBody OpenApiReq<DirOrgDTO> openApiReq) {
        DirOrgDTO dir = openApiReq.getData();
        List<ShareCountView> list = null;
        //按照部门来统计
        if (dir.getBusCode().equals(ShareType.DIR_ORG_TYPE.getVal())) {
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            list = dataDirectoryWareService.getBusDataByOrg();
        } else {
            int level = GxqPtRoleUnits.DICT_TWO_LEVEL;
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            list = dataDirectoryWareService.getBusDataByBus(dir.getBusCode(), level);
        }
        List<DirOrgDTO> busView = dozerUtils.mapPage(list, DirOrgDTO.class);
        return Result.success(new PageInfo<>(busView));
    }

    /**
     * @param openApiReq 业务编码
     * @param openApiReq 分页参数
     * @return boolean
     * @todo根据业务类型查询元目录
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getBottomDirList", method = RequestMethod.POST)
    
    public Result<PageInfo<DirViewDTO>> getBottomDirList(@RequestBody OpenApiReq<DirOrgDTO> openApiReq) {
        DirOrgDTO dir = openApiReq.getData();
        List<ShareDataView> list = null;
        //如果是单位 则根据单位id查询对应元目录
        if (openApiReq.getData().getBusCode().equals(ShareType.DIR_ORG_TYPE.getVal())) {
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            list = dataDirectoryWareService.getBottomDirByUnit(dir.getUnitId(), dir.getSearchKey(), dir.getIndexNo());
        } else {//根据主题，领域，服务，行业等查询元目录
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            list = dataDirectoryWareService.getBottomDirByBuss(dir.getBusCode(), dir.getBusKey(), dir.getSearchKey(), dir.getIndexNo());
        }
        List<DirViewDTO> unitView = dozerUtils.mapPage(list, DirViewDTO.class);
        return Result.success(new PageInfo<>(unitView));
    }

    /**
     * @param id 元目录id
     * @return boolean
     * @todo根据元目录id查询详情
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getDirView", method = RequestMethod.GET)
    
    public Result<DirViewDTO> getDirView(@RequestParam String id) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        //获取单位Id
        String unitId = "";
        if (userId != null) {
            unitId = commonService.getOrgIdByUserId(userId);
        }
        ShareDataView view = dataDirectoryWareService.getDirViewById(id);

        //edit by zhaopengfei 判断登录单位是否为共享单位
        Integer shareUnit = 0;
        if (view.getUnitId().equals(unitId)) {
            shareUnit = 1;
        } else {
            ShareUnitWareExample shareUnitExample = new ShareUnitWareExample();
            shareUnitExample.createCriteria().andDirIdEqualTo(Long.valueOf(id)).andUnitIdEqualTo(unitId);
            List<ShareUnitWare> unitWares = shareUnitWareService.find(shareUnitExample);
            if (!ObjectUtils.isEmpty(unitWares) && unitWares.size() > 0) {
                shareUnit = 1;
            }
        }

        boolean setIsAudio = shareDataSetService.isAuditPass(view.getSetId());
        DirViewDTO dto = dozerUtils.map(view, DirViewDTO.class);
        dto.setShareUnit(shareUnit);
        dto.setDataSetIsAudio(setIsAudio);
        dto.setLoginUnitId(unitId);
        return Result.success(dto);
    }

    /**
     * @param openApiReq 元目录id
     * @todo 根据元目录id查询Api
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getApiList", method = RequestMethod.POST)
    
    public Result<PageInfo<ApiViewDTO>> getApiList(@RequestBody OpenApiReq<DirViewDTO> openApiReq) {
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataApiListDO> list = shareDataApiService.getApiList(openApiReq.getData().getId());
        List<ApiViewDTO> returnList = dozerUtils.mapPage(list, ApiViewDTO.class);
        return Result.success(new PageInfo<>(returnList));
    }

    /**
     * @todo 热门TOP10API
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getHostApi", method = RequestMethod.POST)
    
    public Result<List<ApiReturnDataDTO>> getHostApi() {
        List<ShareDataApiListDO> list = shareDataApiService.getHostApi();
        List<ApiReturnDataDTO> returnList = dozerUtils.mapPage(list, ApiReturnDataDTO.class);
        return Result.success(returnList);
    }

    /**
     * @todo 查询部门
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getOrgList", method = RequestMethod.POST)
    
    public Result<List<OrgDTO>> getOrgList() {
        List<OrgDO> list = dataOverviewService.getOrgList();
        List<OrgDTO> returnList = dozerUtils.mapPage(list, OrgDTO.class);
        return Result.success(returnList);
    }

    /**
     * @param id 元目录id
     * @return boolean
     * @todo 更新元目录的查看次数
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/updateSeeCount", method = RequestMethod.GET)
    
    public Result<Boolean> updateSeeCount(String id) {
        dataDirectoryWareService.updateSeeCount(id);
        dataDirectoryService.updateSeeCount(id);
        return Result.success(true);
    }

    /**
     * @param busCode 业务编码
     * @param unitId  单位id
     * @return boolean
     * @todo根据类型查询api量
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getApiSetCount", method = RequestMethod.GET)
    
    public Result<Map<String, Integer>> getApiSetCount(String busCode, String unitId) {
        Map<String, Integer> retMap = new HashMap<String, Integer>();
        if (busCode.equals(ShareType.DIR_ORG_TYPE.getVal())) {
            //API数量
            int apiCount = shareDataApiService.queryDirCanUseApiCount(unitId);
            retMap.put("apiCount", apiCount);
        } else {//根据主题，领域，服务，行业等查询数据集和api数量
            Map<String,Object> param = new HashMap<>();
            param.put("busCode",busCode);
            param.put("busKey",busCode);
            int apiCount = shareDataApiService.getApiCountByCode(param);
            retMap.put("apiCount", apiCount);
        }
        return Result.success(retMap);
    }

    /**
     * 描述：根据概览中基础库、主题库、专题库进行分类查询元目录
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/8/23
     * 修改内容：
     */
    @RequestMapping(value = "/getBottomDirListByType", method = RequestMethod.POST)
    
    public Result<PageInfo<DirViewDTO>> getBottomDirListByType(@RequestBody OpenApiReq<DirOrgDTO> openApiReq) {
        DirOrgDTO dir = openApiReq.getData();
        List<ShareDataView> list = null;
        //如果是单位 则根据单位id查询对应元目录
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        list = dataDirectoryWareService.getBottomDirByBuss(dir.getBusCode(), dir.getBusKey(), dir.getSearchKey(), dir.getIndexNo());
        List<DirViewDTO> unitView = dozerUtils.mapPage(list, DirViewDTO.class);
        return Result.success(new PageInfo<>(unitView));
    }

    /**
     * 描述：根据业务类型查询api总量
     * 参数：busCode 类型编码
     * 返回值：Map<String,Integer>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/24
     * 修改内容：
     */
    @RequestMapping(value = "/getApiCountByType", method = RequestMethod.GET)
    
    public Result<Map<String, Integer>> getApiCountByType(String busCode,String busKey) {
        Map<String, Integer> retMap = new HashMap<String, Integer>();
        Map<String, Object> param = new HashMap<>();
        param.put("busCode",busCode);
        param.put("busKey",busKey);
        int apiCount = shareDataApiService.getApiCountByCode(param);
        retMap.put("apiCount", apiCount);
        return Result.success(retMap);
    }

    /**
     * @todo 获取标签云数据
     * @Author zhaopengfei
     * @createtime 2019-4-11
     */
    @RequestMapping(value = "/getTagCloud", method = RequestMethod.POST)

    public Result<List<Map<String,Object>>> getTagCloud() {
        List<Map<String,Object>> list = shareDataApiService.getTagCloud();
        return Result.success(list);
    }


}
