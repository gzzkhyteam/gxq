package com.hengyunsoft.platform.exchange.impl.system;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDbSourceDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDbSourceSaveDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDbSourceUpdateDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseDbSourceDTO;
import com.hengyunsoft.platform.exchange.entity.set.domain.DbSourceDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.DataBaseDescManager;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDbSourceService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * com.hengyunsoft.platform.exchange.impl.system
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据源 AIP管理
 * 修改人：wt
 * 修改时间：2018/4/23
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDictApiImpl.java", description = "数据源 AIP管理")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ShareDbSourceApiImpl /*implements ShareDbSourceApi */{

    @Autowired
    private ShareDbSourceService shareDbSourceService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private CommonService commonService;


    @Autowired
    private DataBaseDescManager dataBaseDescManager;




    /**
     * 描述：查询数据源列表
     * 参数：ShareRequestDbSourceDTO
     * 返回值：PageInfo<ShareResponseDbSourceDTO>
     * 修改人：wt
     * 修改时间：2018/7/23
     * 修改内容：平台管理员跟平台数据操作员取消查看全部
     */
    @RequestMapping(value = "/dbSource/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据源列表", notes = "查询数据源列表")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
    })
    
    public Result<PageInfo<ShareResponseDbSourceDTO>> findDbSource(@RequestBody OpenApiReq<ShareRequestDbSourceDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, openApiReq);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();
        String orgId = commonService.getOrgIdByUserId(adminId);
        log.info("ShareDbSourceApiImpl-find:adminId={},orgId={}",adminId,orgId);
        String sourceName = openApiReq.getData().getSourceName();
        String dbName = openApiReq.getData().getDbName();
        Integer dbType = openApiReq.getData().getDbType();
        String sysName = openApiReq.getData().getSysName();

        Map<Object,Object> param = new HashMap<Object,Object>();
        if(!StringUtils.isBlank(sourceName)){
            param.put("sourceName",sourceName);
        }
        if(!StringUtils.isBlank(dbName)){
            param.put("dbName",dbName);
        }
        if(!StringUtils.isBlank(sysName)){
            param.put("sysName",sysName);
        }
        if(dbType != 0){
            param.put("dbType",dbType);
        }
//        Boolean isPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
//        Boolean isPtAdminData = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_DATA_ROLE_CODE);
//        if(!(isPtAdmin || isPtAdminData)){
//            param.put("orgId",orgId);
//        }
        param.put("orgId",orgId);

        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<DbSourceDO> list = shareDbSourceService.queryDbSourceList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareResponseDbSourceDTO.class)));
    }

    /**
     * 描述：查询数据源对象
     * 参数：id
     * 返回值：ShareResponseDbSourceDTO
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/dbSource/getById", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据源对象", notes = "查询数据源对象")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    
    public Result<ShareResponseDbSourceDTO> getById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, id);
        DbSourceDO dbSourceDO = shareDbSourceService.getDbSourceById(id);
        return Result.success(dozerUtils.map(dbSourceDO,ShareResponseDbSourceDTO.class));
    }

    /**
     * 描述：保存数据源
     * 参数：ShareRequestDbSourceSaveDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/dbSource/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存数据源", notes = "保存数据源")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
    })
    @ValidatorStandard(
            {
                @Constraint(value = ShareDbSource.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    
    public Result<Boolean> saveDbSource(@RequestBody ShareRequestDbSourceSaveDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, dto);
        try {
            Long adminId = BaseContextHandler.getAdminId();
            String orgId = commonService.getOrgIdByUserId(adminId);
            log.info("ShareDbSourceApiImpl-find:adminId={},orgId={}",adminId,orgId);
            ShareDbSource shareDbSource = new ShareDbSource();
            shareDbSource.setUnitId(dto.getUnitId());
            shareDbSource.setOrgId(orgId);
            shareDbSource.setSourceName(dto.getSourceName());
            shareDbSource.setDbName(dto.getDbName());
            shareDbSource.setDbPort(dto.getDbPort());
            shareDbSource.setDbAddress(dto.getDbAddress());
            shareDbSource.setContType(dto.getContType());
            shareDbSource.setDbType(dto.getDbType());
            shareDbSource.setServerType(dto.getServerType());
            shareDbSource.setDbAccount(dto.getDbAccount());
            shareDbSource.setDbPassword(dto.getDbPassword());
            shareDbSource.setCreateTime(Calendar.getInstance().getTime());
            shareDbSource.setCreateUser(adminId);
            log.info("ShareDbSourceApiImpl-save:shareDbSource={}", JSON.toJSON(shareDbSource));
            Boolean isConn = dataBaseDescManager.testConnection(shareDbSource);
            if(isConn){
                shareDbSourceService.saveSelective(shareDbSource);
                return Result.success(true);
            }else{
                return Result.success(false,"无法建立数据库连接，请检查地址、用户名、密码");
            }
        } catch (Exception e) {
            log.error("ShareDbSourceApiImpl-save:Exception={}", e);
            return Result.success(false,"保存数据源发生异常");
        }

    }

    /**
     * 描述：删除数据源
     * 参数：id
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/dbSource/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除数据源", notes = "删除数据源")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    
    public Result<Boolean> deleteById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, id);
        try {
            shareDbSourceService.deleteById(id);
        } catch (Exception e) {
            log.error("ShareDbSourceApiImpl-delete:Exception={}", e);
            return Result.success(false,"删除数据源发生异常！");
        }
        return Result.success(true);
    }

    /**
     * 描述：更新数据源
     * 参数：ShareRequestDbSourceUpdateDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/dbSource/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新数据源", notes = "更新数据源")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    @ValidatorStandard(
            {
                @Constraint(value = ShareDbSource.class)
            }
    )
    
    public Result<Boolean> updateDbSource(@RequestBody ShareRequestDbSourceUpdateDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, dto.getId());
        try {
            Long adminId = BaseContextHandler.getAdminId();
            ShareDbSource shareDbSource = dozerUtils.map(dto,ShareDbSource.class);
            shareDbSource.setUnitId(dto.getUnitId());
            shareDbSource.setUpdateTime(Calendar.getInstance().getTime());
            shareDbSource.setUpdateUser(adminId);
            log.info("ShareDbSourceApiImpl-update:shareDbSource={}", JSON.toJSON(shareDbSource));
            Boolean isConn = dataBaseDescManager.testConnection(shareDbSource);
            if(isConn){
                shareDbSourceService.updateByIdSelective(shareDbSource);
                return Result.success(true);
            }else{
                return Result.success(false,"无法建立数据库连接，请检查地址、用户名、密码！");
            }
        } catch (Exception e) {
            log.error("ShareDbSourceApiImpl-update:Exception={}", e);
            return Result.success(false,"更新数据源发生异常！");
        }
    }
}
