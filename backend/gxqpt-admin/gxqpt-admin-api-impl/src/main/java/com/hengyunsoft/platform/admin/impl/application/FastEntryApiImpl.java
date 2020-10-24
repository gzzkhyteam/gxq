package com.hengyunsoft.platform.admin.impl.application;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.api.FastEntryApi;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryRankDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntrySaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryUpdateDTO;
import com.hengyunsoft.platform.admin.entity.application.po.FastEntry;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.FastEntryRankDO;
import com.hengyunsoft.platform.admin.repository.application.service.FastEntryService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.admin.impl.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：应用资源管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/3/28
 * 修改内容：新增基础接口
 */
@Api(value = "FastEntryApiImpl", description = "快捷入口管理")
@RestController
@RequestMapping("fastEntry")
@Slf4j
public class FastEntryApiImpl implements FastEntryApi {

    @Autowired
    FastEntryService fastEntryService;

    @Autowired
    private DozerUtils dozerUtils;


    /**
     * 描述：新增快捷入口
     * 参数：[resourceSaveDto：快捷入口新增实体]
     * 返回值：RoleSaveDto
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "新增快捷入口", notes = "新增快捷入口")
    @ApiResponses({
            @ApiResponse(code = 57005, message = "快捷入口应用Id不能为空"),
            @ApiResponse(code = 57000, message = "快捷入口信息不能为空"),
            @ApiResponse(code = 57006, message = "快捷入口资源ID不能为空"),
            @ApiResponse(code = 57003, message = "快捷入口地址不能为空"),
            //@ApiResponse(code = 57004, message = "快捷入口图标不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<FastEntrySaveDTO> save(@RequestBody FastEntrySaveDTO dto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_NULL, dto);
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_RESOURCE_ID_NULL, dto.getResourceId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.FSAT_ENTRY_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.FSAT_ENTRY_URL_NULL, dto.getUrl());
        //BizAssert.assertNotEmpty(AuthorityExceptionCode.FSAT_ENTRY_ICON_NULL, dto.getIcon());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、判断快捷入口唯一性
        //判断记录总数大于等于1，不允许继续添加
        /*FastEntryExample example = new FastEntryExample();
        example.createCriteria().andAppIdEqualTo(dto.getAppId())
                .andResourceIdEqualTo(dto.getResourceId())
                .andUserIdEqualTo(userId);
        example.setOrderByClause("userId desc");
        int count = fastEntryService.count(example);
        if (count>=1) {
            return Result.fail(AuthorityExceptionCode.RESOURCES_FSAT_ENTRY_EXIST);
        }*/

        //4、转换并赋初值
        FastEntry fastEntry = dozerUtils.map(dto, FastEntry.class);
        fastEntry.setCreateTime(date);
        fastEntry.setUpdateTime(date);
        fastEntry.setCreateUser(userId);
        fastEntry.setUpdateUser(userId);
        fastEntry.setUserId(userId);
        fastEntry.setDeleteStatus(DeleteStatus.UN_DELETE.getVal());
        fastEntry.setUserName(BaseContextHandler.getName());

        //5、保存
        fastEntry = fastEntryService.save(fastEntry);

        //6、返回
        return Result.success(dozerUtils.map(fastEntry, FastEntrySaveDTO.class));
    }

    /**
     * 描述：修改快捷入口
     * 参数：fastEntryUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "修改快捷入口", notes = "修改快捷入口")
    @ApiResponses({
            @ApiResponse(code = 57005, message = "快捷入口应用Id不能为空"),
            @ApiResponse(code = 57000, message = "快捷入口信息不能为空"),
            @ApiResponse(code = 57006, message = "快捷入口资源ID不能为空"),
            @ApiResponse(code = 57001, message = "快捷入口Id不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody FastEntryUpdateDTO dto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_NULL, dto);
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_RESOURCE_ID_NULL, dto.getResourceId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.FSAT_ENTRY_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.FSAT_ENTRY_ID_NULL, dto.getId());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //4、转换并赋初值
        FastEntry fastEntry = dozerUtils.map(dto, FastEntry.class);
        fastEntry.setUpdateUser(userId);
        fastEntry.setUpdateTime(date);

        //4、修改
        fastEntryService.update(fastEntry);
        return Result.success(true);
    }

    /**
     * 描述：删除快捷入口
     * 参数：快捷入口Id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "删除快捷入口", notes = "删除快捷入口")
    @ApiResponses({
            @ApiResponse(code = 57001, message = "快捷入口Id不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_ID_NULL, id);

        //2.对资源进行删除
        fastEntryService.deleteById(id);

        //3.返回
        return Result.success(true);
    }


    /**
     * 描述：根据id查询快捷入口Api
     * 参数：id
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取快捷入口", notes = "根据id查询快捷入口")
    @ApiResponses({
            @ApiResponse(code = 57001, message = "快捷入口id不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<FastEntryDTO> getById(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.FSAT_ENTRY_ID_NULL, id);

        //2、执行查询
        FastEntry fastEntry = fastEntryService.getById(id);
        if (fastEntry == null) {
            return Result.success(null);
        }
        FastEntryDTO dto = dozerUtils.map(fastEntry, FastEntryDTO.class);

        //3、返回结果
        return Result.success(dto);
    }


    /**
     * 描述：查询快捷入口Api
     * 参数：
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "查询快捷入口", notes = "查询快捷入口Api")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<FastEntryDTO>> findList() {
        //1、获取基础信息
        Long userId = BaseContextHandler.getAdminId();

        //2、查询该角色拥有的资源
        List<FastEntryDTO> dto = dozerUtils.mapList(fastEntryService.queryAppByUserId(userId), FastEntryDTO.class);

        //3、返回
        return Result.success(dto);
    }


    /**
     * 获取快捷入口排行榜
     * @param resultNum
     * @return
     */
    @Override
    @ApiOperation(value = "获取快捷入口排行榜", notes = "获取快捷入口排行榜")
    @ApiResponses({
    })
    @RequestMapping(value = "/getFastEntryRank", method = RequestMethod.GET)
    public Result<List<FastEntryRankDTO>> getFastEntryRank(@RequestParam("resultNum") Long resultNum) {

        //查询并返回
        if(resultNum == null){
            Result.fail("请输入需要返回排行数量！！");
        }
        List<FastEntryRankDO>  list = fastEntryService.getFastEntryRank(resultNum);
        List<FastEntryRankDTO>  FastEntryRankList = dozerUtils.mapList(list, FastEntryRankDTO.class);
        if(FastEntryRankList == null){
            return Result.success(FastEntryRankList);
        }
        FastEntryRankList.forEach((li) ->{
            if(StringUtils.isNotEmpty(li.getAppResourceName())){
                List<String> nameList = Arrays.asList(li.getAppResourceName().split("-"));
                if (nameList.size() > 1){
                    li.setAppResourceName(nameList.get(1));
                }
            }
        });
        return Result.success(FastEntryRankList);
    }
}