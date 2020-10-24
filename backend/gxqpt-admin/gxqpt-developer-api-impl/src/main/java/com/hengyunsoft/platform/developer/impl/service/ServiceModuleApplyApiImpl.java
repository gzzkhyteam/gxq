package com.hengyunsoft.platform.developer.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.msg.BriefTpye;
import com.hengyunsoft.commons.msg.DeveloperBizType;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleApplyApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceModuleApply;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.impl.manager.ServiceModuleCommon;
import com.hengyunsoft.platform.developer.repository.apply.example.ServiceModuleApplyExample;
import com.hengyunsoft.platform.developer.repository.apply.service.*;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleApplyService;
import com.hengyunsoft.platform.developer.utils.CommonCanstants;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能申请管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/2
 * 修改内容：新增基础接口
 */
@Api(value = "API - ServiceModuleApplyApiImpl.java", description = "我的功能申请管理")
@RestController
@RequestMapping("serviceModuleApply")
@Slf4j
public class ServiceModuleApplyApiImpl implements ServiceModuleApplyApi {

    @Autowired
    ServiceModuleApplyService serviceModuleApplyService;

    @Autowired
    ServiceModuleService serviceModuleService;

    @Autowired
    ServiceAssignModuleApplyService assignModuleApplyService;

    @Autowired
    ServiceResourceService serviceResourceService;

    @Autowired
    ServiceResourceDocService serviceResourceDocService;

    @Autowired
    ServiceModuleCommon serviceModuleCommon;

    @Autowired
    ApplicationService applicationService;


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    /**
     * 功能启用
     */
    public static final String MODULE_START_USING = "startUsing";

    /**
     * 功能过时
     */
    public static final String MODULE_OUTMODED = "outmoded";

    /**
     * 功能取消过时
     */
    public static final String MODULE_CANCEL_OUTMODED = "cancelOutmoded";


    /**
     * 功能禁用
     */
    public static final String MODULE_STOP_USING = "stopUsing";

    /**
     * 启用状态 1、正常使用中
     */
    public static final Short START_USING_STATUS = 1;

    /**
     * 过时状态 10、已过时（有新版本取代）
     */
    public static final Short OUTMODED_STATUS = 10;

    /**
     * 禁用状态 20、停止使用
     */
    public static final Short STOP_USING_STATUS = 20;

    /**
     * 描述：新增我的功能申请Api
     * 参数：[ServiceModuleApplyRetDTO：我的功能申请实体]
     * 返回值：ServiceModuleApplyRetDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */

    @Override
    @ApiOperation(value = "新增我的功能申请", notes = "新增我的功能申请")
    @ApiResponses({
            @ApiResponse(code = 76000, message = "我的功能申请信息不能为空"),
            //@ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
            //@ApiResponse(code = 76002, message = "当前用户我的功能申请已经存在"),
            @ApiResponse(code = 76003, message = "我的功能申请API接口文档地址不能为空"),
           // @ApiResponse(code = 76004, message = "我的功能申请图标不能为空"),
            @ApiResponse(code = 76005, message = "我的功能申请应用ID不能为空"),
            //@ApiResponse(code = 76006, message = "我的功能申请资源ID不能为空"),
            @ApiResponse(code = 76007, message = "我的功能申请功能名字不能为空"),
            @ApiResponse(code = 76008, message = "我的功能申请功能类型不能为空"),
           // @ApiResponse(code = 76009, message = "我的功能申请功能状态不能为空"),
            @ApiResponse(code = 76010, message = "我的功能申请联系人邮箱不能为空"),
            @ApiResponse(code = 76011, message = "我的功能申请是否公有模块不能为空"),
            @ApiResponse(code = 76012, message = "我的功能申请是否公开模块不能为空"),
            @ApiResponse(code = 76013, message = "我的功能申请功能描述不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = ServiceModuleApply.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<ServiceModuleApplyRetDTO> save(@RequestBody ServiceModuleApplySaveDTO dto) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_NULL, dto);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_URL_NULL, dto.getApiSyncUrl());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_NAME_NULL, dto.getName());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_TYPE_NULL, dto.getModuleType());
        //BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_STATUS_NULL, String.valueOf(dto.getApplyStatus()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PERSON_EMAIL_NULL, dto.getEmail());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PUBLIC_IS_NULL, dto.getPublicIs().toString());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PUBLIC_LOOK_NULL, dto.getPublicLook().toString());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_DESC_NULL, dto.getDesc());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        Date date = new Date();

        //3.校验swagger地址的有效性
        String res = serviceModuleCommon.validateSwaggerUrl(dto.getApiSyncUrl());
        if(StringUtil.isNotEmpty(res)){
            return Result.fail(res);
        }

        //4、转换并赋初值
        ServiceModuleApply serviceModuleApply = dozerUtils.map(dto, ServiceModuleApply.class);
        serviceModuleApply.setCreateTime(date);
        serviceModuleApply.setUpdateTime(date);
        serviceModuleApply.setCreateUser(userId);
        serviceModuleApply.setUpdateUser(userId);
        serviceModuleApply.setApplyUser(userId);
        serviceModuleApply.setApplyUserName(name);
        serviceModuleApply.setApplyStatus(CommonCanstants.SERVICE_MODULE_APPLY_AUDITING_STATUS);

        //5、保存
        serviceModuleApply = serviceModuleApplyService.save(serviceModuleApply);

        msgQueueProducer.saveHandlerMsgToRole(builderBbsAllMainMsgDTO(serviceModuleApply), RoleService.application_admin_code, BaseContextHandler.getAppId());
        //6、返回
        return Result.success(dozerUtils.map(serviceModuleApply, ServiceModuleApplyRetDTO.class));
    }
    
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ServiceModuleApply serviceModuleApply) {
    	
    	BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
    	
    	bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
    	bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
    	bbsAllMainMsgDTO.setBizId(serviceModuleApply.getId().toString());
    	bbsAllMainMsgDTO.setBizType(DeveloperBizType.ADD_MODULE_AUDIT);
    	bbsAllMainMsgDTO.setBriefTpye(BriefTpye.WORK_AUDIT);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
    	bbsAllMainMsgDTO.setContent(serviceModuleApply.getApplyUserName() + "申请新增"+serviceModuleApply.getName()+"功能待审批。");
    	bbsAllMainMsgDTO.setTitle("申请新增"+serviceModuleApply.getName());
    	bbsAllMainMsgDTO.setDetailedType("module_add_apply");
    	bbsAllMainMsgDTO.setDetailedTypeDesc("新增功能申请");
    	bbsAllMainMsgDTO.setHandlerNeedIs(true);
    	bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
    	bbsAllMainMsgDTO.setHandlerParams("moduleName="+serviceModuleApply.getName());
    	bbsAllMainMsgDTO.setSenderName("系统自动通知");
		return bbsAllMainMsgDTO;
	}

    /**
     * 描述：我的功能申请审核Api
     * 参数：[ServiceModuleApplyAuditDTO：我的功能申请审核实体]
     * 返回值：ServiceModuleApplyAuditDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "我的功能申请审核", notes = "我的功能申请审核")
    @ApiResponses({
            @ApiResponse(code = 76000, message = "我的功能申请信息不能为空"),
            @ApiResponse(code = 76003, message = "我的功能申请API接口文档地址不能为空"),
            // @ApiResponse(code = 76004, message = "我的功能申请图标不能为空"),
            @ApiResponse(code = 76005, message = "我的功能申请应用ID不能为空"),
            @ApiResponse(code = 76007, message = "我的功能申请功能名字不能为空"),
            @ApiResponse(code = 76008, message = "我的功能申请功能类型不能为空"),
            @ApiResponse(code = 76009, message = "我的功能申请功能状态不能为空"),
            @ApiResponse(code = 76010, message = "我的功能申请联系人邮箱不能为空"),
            @ApiResponse(code = 76011, message = "我的功能申请是否公有模块不能为空"),
            @ApiResponse(code = 76012, message = "我的功能申请是否公开模块不能为空"),
            @ApiResponse(code = 76013, message = "我的功能申请功能描述不能为空"),
    })
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Result<Boolean> audit(@RequestBody ServiceModuleApplyAuditDTO dto) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_NULL, dto);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_URL_NULL, dto.getApiSyncUrl());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_NAME_NULL, dto.getName());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_TYPE_NULL, dto.getModuleType());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_STATUS_NULL, String.valueOf(dto.getApplyStatus()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PERSON_EMAIL_NULL, dto.getEmail());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PUBLIC_IS_NULL, dto.getPublicIs().toString());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_PUBLIC_LOOK_NULL, dto.getPublicLook().toString());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_DESC_NULL, dto.getDesc());

        //2.封装实体类
        ServiceModule serviceModule = new ServiceModule();
        serviceModule.setLogo(dto.getLogo());
        serviceModule.setName(dto.getName());
        serviceModule.setCode(dto.getCode());
        serviceModule.setDesc(dto.getDesc());
        serviceModule.setStatus(dto.getStatus());
        serviceModule.setEmail(dto.getEmail());
        serviceModule.setAppId(dto.getAppId());
        serviceModule.setModuleType(dto.getModuleType());
        serviceModule.setCreateUser(dto.getCreateUser());
        serviceModule.setCreateTime(dto.getCreateTime());
        serviceModule.setPublicIs(dto.getPublicIs());
        serviceModule.setPublicLook(dto.getPublicLook());
        serviceModule.setApiSyncUrl(dto.getApiSyncUrl());
        serviceModule.setResourceNum(dto.getResourceNum());
        serviceModule.setStopTime(dto.getStopTime());
        serviceModule.setAdviceModule(dto.getAdviceModule());
        serviceModule.setReduceCost(dto.getReduceCost());
        serviceModule.setReduceTime(dto.getReduceTime());
        
        ServiceModuleApply serviceModuleApply = new ServiceModuleApply();
        serviceModuleApply.setId(dto.getId());
        serviceModuleApply.setAuditUser(dto.getAuditUser());
        serviceModuleApply.setAuditUserName(dto.getAuditUserName());
        serviceModuleApply.setAuditDesc(dto.getAuditDesc());
        serviceModuleApply.setApplyStatus(dto.getApplyStatus());
        serviceModuleApply.setUpdateUser(dto.getUpdateUser());
        serviceModuleApply.setUpdateTime(dto.getUpdateTime());

        //3、保存功能
        serviceModule = serviceModuleService.save(serviceModule);

        //4、更新功能申请记录
        serviceModuleApply.setSuccessPassModuleId(serviceModule.getId());
        serviceModuleApplyService.updateByIdSelective(serviceModuleApply);

        //5,返回
        return Result.success(true);
    }


    /**
     * 描述：修改我的功能申请Api
     * 参数：ServiceModuleUpdateDTO
     * 返回值：String
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "修改我的功能申请", notes = "修改我的功能申请")
    @ApiResponses({
            @ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
            @ApiResponse(code = 76005, message = "我的功能申请应用ID不能为空"),
            @ApiResponse(code = 76003, message = "我的功能申请API接口文档地址不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<String> update(@RequestBody ServiceModuleUpdateDTO dto) {
        //1、验证
        String moduleId = dto.getId();
        String swaggerUrl = dto.getApiSyncUrl();
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, moduleId);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_URL_NULL, swaggerUrl);

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

       //3.swagger地址处理控制
        ServiceModule sm = serviceModuleService.getById(Long.parseLong(moduleId));
        if(!swaggerUrl.equals(sm.getApiSyncUrl())){
            //校验swagger地址的有效性
            String res = serviceModuleCommon.validateSwaggerUrl(swaggerUrl);
            if(StringUtil.isNotEmpty(res)){
                return Result.fail(res);
            }
            //存在swagger地址变化，需更新服务资源等信息
            serviceModuleCommon.updateSwaggerJsonStr(swaggerUrl,sm.getId(),dto.getAppId());
        }

        ServiceModule serviceModule = dozerUtils.map(dto, ServiceModule.class);
        serviceModule.setUpdateUser(userId);
        serviceModule.setUpdateTime(date);

        //4、修改
        serviceModuleService.update(serviceModule);
        return Result.success("true");
    }

    /**
     * 描述：我的功能申请禁用Api
     * 参数：id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "我的功能申请禁用", notes = "我的功能申请禁用")
    @ApiResponses({
            @ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
            @ApiResponse(code = 76009, message = "我的功能申请功能状态不能为空"),
    })
    @RequestMapping(value = "/forbidUse", method = RequestMethod.POST)
    public Result<Boolean> forbidUse(@RequestBody ServiceModuleForbidUseDTO dto) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, dto.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_MODULE_STATUS_NULL, dto.getStatus());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        ServiceModule serviceModule = dozerUtils.map(dto, ServiceModule.class);
        serviceModule.setUpdateUser(userId);
        serviceModule.setUpdateTime(date);

        //4、修改
        serviceModuleService.updateByIdSelective(serviceModule);
        return Result.success(true);
    }


    /**
     * 描述：我的功能混合逻辑操作Api
     * 参数：id
     * 返回值：String
     * 修改人：sunxiaoya
     * 修改时间：2018/8/29
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "我的功能混合逻辑操作", notes = "我的功能混合逻辑操作")
    @ApiResponses({
            @ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
            @ApiResponse(code = 76016, message = "我的功能混合操作类型不能为空"),
    })
    @RequestMapping(value = "/moduleMixHandle", method = RequestMethod.POST)
    public Result<String> updateModuleMixHandle(@RequestBody ServiceModuleMixHandleDTO dto) {

        //1.验证
        String resMsg = null;
        if (dto == null) {
            resMsg = "入参实体DTO不为空！！";
            return Result.fail(resMsg);
        }
        String bean = JSONUtils.toJsonString(dto);
        log.info("我的功能混合逻辑操作,DTO[{}]",bean);
        Long modId = dto.getId();
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, modId);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.MODULE_APPLY_MODULE_MIX_HANDLE_TYPE_NULL, dto.getMixHandleType());

        //2、基础数据获取
        ServiceModule sm = serviceModuleService.getById(modId);
        List<ServiceAssignModuleApply> smaList = assignModuleApplyService.getByModuleId(modId);
        List<String> roleAppIdList = new ArrayList<>();

        //去掉重复应用ID,应用重新申请功能情况处理
        if(smaList!=null){
            for(ServiceAssignModuleApply sli:smaList){
                if(!roleAppIdList.contains(sli.getAppId())){
                    roleAppIdList.add(sli.getAppId());
                }
            }
        }
        if (sm == null) {
            resMsg = "该模块不存在！！";
            return Result.fail(resMsg);
        }

        boolean isExistType = false;//是否存在正确混合类型
        if(MODULE_START_USING.equals(dto.getMixHandleType())||MODULE_CANCEL_OUTMODED.equals(dto.getMixHandleType())){

            //新增API索引
            isExistType = true;

            //校验swagger地址的有效性
            String res = serviceModuleCommon.validateSwaggerUrl(sm.getApiSyncUrl());
            if(StringUtil.isNotEmpty(res)){
                return Result.fail(res);
            }
            serviceModuleCommon.updateSwaggerJsonStr(sm.getApiSyncUrl(),sm.getId(),sm.getAppId());

            //新增帮助文档索引
            serviceModuleCommon.addServerModuleDocIndex(sm.getId());

            //可能存在一个功能被多个应用管理员申请情况
            if(roleAppIdList!=null){
                for(String roleAppId:roleAppIdList){
                    Application app = applicationService.getMsgByAppId(roleAppId);
                    if (app != null) {
                        //发送启用功能消息
                        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
                        bbsAllMainMsgDTO.setContent("您"+app.getName()+"应用申请调用的"+sm.getName()+"功能，已被重新启用，请知悉。");
                        bbsAllMainMsgDTO.setTitle("功能启用");
                        bbsAllMainMsgDTO.setDetailedType("module_start_using");
                        bbsAllMainMsgDTO.setDetailedTypeDesc("功能启用操作");
                        if(MODULE_CANCEL_OUTMODED.equals(dto.getMixHandleType())){
                            bbsAllMainMsgDTO.setContent("您"+app.getName()+"应用申请调用的"+sm.getName()+"功能，已取消过时，请知悉。");
                            bbsAllMainMsgDTO.setTitle("功能取消过时");
                            bbsAllMainMsgDTO.setDetailedType("module_cancel_outmoded");
                            bbsAllMainMsgDTO.setDetailedTypeDesc("功能取消过时");
                        }
                        bbsAllMainMsgDTO.setHandlerParams("moduleId="+sm.getId());
                        addSendMsg(bbsAllMainMsgDTO,modId,roleAppId);
                    }
                }
            }
            updateById(dto,START_USING_STATUS,sm.getId());
        }
        if(MODULE_OUTMODED.equals(dto.getMixHandleType())){
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            isExistType = true;

            //删除API索引
            serviceModuleCommon.deleteServiceResource(sm.getId());

            //删除帮助文档索引
            serviceModuleCommon.deleteServerModuleDocIndex(sm.getId());

            //可能存在一个功能被多个应用管理员申请情况
            if(roleAppIdList!=null){
                for(String roleAppId:roleAppIdList){
                    Application app = applicationService.getMsgByAppId(roleAppId);
                    if (app != null) {
                        //存在指定推荐功能
                        if(dto.getAdviseModuleId()!=null && StringUtil.isNotEmpty(dto.getAdviseModuleName())){
                            bbsAllMainMsgDTO.setContent("您"+app.getName()+"应用申请调用的"+sm.getName()+"功能，已标记过时，后期停用，推荐使用"+dto.getAdviseModuleName()+"功能，请及时调整。");
                            bbsAllMainMsgDTO.setHandlerParams("moduleId="+dto.getAdviseModuleId());
                        }else{
                            bbsAllMainMsgDTO.setContent("您"+app.getName()+"应用申请调用的"+sm.getName()+"功能，已标记过时，后期停用。");
                            bbsAllMainMsgDTO.setHandlerParams("moduleId="+sm.getId());
                        }
                        bbsAllMainMsgDTO.setTitle("功能过时");
                        bbsAllMainMsgDTO.setDetailedType("module_outmoded");
                        bbsAllMainMsgDTO.setDetailedTypeDesc("功能过时");
                        bbsAllMainMsgDTO.setHandlerParams("moduleId="+dto.getAdviseModuleId());
                        //发送启用功能消息
                        addSendMsg(bbsAllMainMsgDTO,modId,roleAppId);
                    }
                }
            }
            updateById(dto,OUTMODED_STATUS,dto.getAdviseModuleId());
        }
        if(MODULE_STOP_USING.equals(dto.getMixHandleType())){

            //删除API索引
            isExistType = true;
            serviceModuleCommon.deleteServiceResource(sm.getId());

            //删除帮助文档索引
            serviceModuleCommon.deleteServerModuleDocIndex(sm.getId());

            //可能存在一个功能被多个应用管理员申请情况
            if(roleAppIdList!=null){
                for(String roleAppId:roleAppIdList){
                    Application app = applicationService.getMsgByAppId(roleAppId);
                    if (app != null) {
                        //发送启用功能消息
                        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
                        bbsAllMainMsgDTO.setContent("您"+app.getName()+"应用申请调用的"+sm.getName()+"功能，已被停用，请及时调整。");
                        bbsAllMainMsgDTO.setTitle("功能禁用");
                        bbsAllMainMsgDTO.setDetailedType("module_stop_using");
                        bbsAllMainMsgDTO.setDetailedTypeDesc("功能禁用");
                        bbsAllMainMsgDTO.setHandlerParams("moduleId="+sm.getId());
                        addSendMsg(bbsAllMainMsgDTO,modId,roleAppId);
                    }
                }
            }
            updateById(dto,STOP_USING_STATUS,sm.getAdviceModule());
        }
        if(!isExistType){
            resMsg = "入参混合类型输入不正确！！";
        }
        return Result.success(resMsg);
    }

    /**
     * 发送操作功能变更消息
     * @param dto
     * @param id
     * @param roleAppId
     * @param
     */
    public void addSendMsg(BbsAllMainMsgDTO dto,Long id,String roleAppId){
        dto.setAppId(BaseContextHandler.getAppId());
        dto.setAppName(BaseContextHandler.getAppName());
        dto.setBizId(id.toString());
        dto.setBizType(DeveloperBizType.UP_MDL_RES_MSG);
        dto.setBriefTpye(BriefTpye.STATUS_CHANGE_MSG);
        dto.setClientFlag("gxqpt");
        dto.setSingleHandleIs(false);
        dto.setHandlerNeedIs(false);
        //跳转至功能帮助文档页面，未登录也可查看。
        dto.setHandlerUrl("/module/helpDoc");
        dto.setSenderName("系统自动通知");
        msgQueueProducer.saveLookMsgToRole(dto, RoleCode.APPLICATION_ADMIN_CODE, roleAppId);
    }

    /**
     * 更新模块信息
     * @param dto
     * @param status
     * @param AdviseModuleId
     */
    public void updateById(ServiceModuleMixHandleDTO dto,Short status,Long AdviseModuleId){
        ServiceModule serviceModule = new ServiceModule();
        serviceModule.setId(dto.getId());
        serviceModule.setStatus(status);
        serviceModule.setUpdateUser(BaseContextHandler.getAdminId());
        serviceModule.setUpdateTime(new Date());
        serviceModule.setAdviceModule(AdviseModuleId);
        serviceModuleService.updateByIdSelective(serviceModule);
    }

    /**
     * 描述：删除我的应用的功能申请Api
     * 参数：id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "删除我的应用的功能申请", notes = "删除我的应用的功能申请")
    @ApiResponses({
            @ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, id);

        //2.对资源进行删除
        serviceModuleService.deleteById(id);

        //3.返回
        return Result.success(true);
    }

    /**
     * 描述：根据id查询我的功能详情Api
     * 参数：id
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据id查询我的功能详情", notes = "根据id查询我的功能详情")
    @ApiResponses({
            @ApiResponse(code = 76001, message = "我的功能申请ID不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<ServiceModuleDTO> getById(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, id);

        //2、执行查询
        ServiceModuleApplyExample example = new ServiceModuleApplyExample();
        example.createCriteria().andSuccessPassModuleIdEqualTo(id);
        example.setOrderByClause("id asc");
        List<ServiceModuleApply> smaList = serviceModuleApplyService.find(example);

        if (smaList == null) {
            log.info("根据id[{}]查询我的功能申请记录为空！！",id);
            return Result.success(null);
        }

        if (smaList.isEmpty()) {
            log.info("根据申请功能ID[{}],查询成功模块ID无数据返回！！",id);
            return Result.fail("根据申请功能ID,查询成功模块ID无数据返回！！");
        }

        ServiceModule serviceModule = serviceModuleService.getById(id);
        if (serviceModule == null) {
            log.info("根据id[{}]查询我的功能模块无数据！！",id);
            return Result.success(null);
        }

        ServiceModuleDTO dto = dozerUtils.map(serviceModule, ServiceModuleDTO.class);
        dto.setApplyDesc(smaList.get(0).getApplyDesc());
        if(serviceModule.getAdviceModule()!=null&&!serviceModule.getAdviceModule().equals(id)){
            ServiceModule sm = serviceModuleService.getById(serviceModule.getAdviceModule());
            log.info("根据id[{}]查询我的功能建议模块",serviceModule.getAdviceModule());
            if(sm!=null){
                dto.setAdviceModuleName(sm.getName());
            }
        }

        //3、返回结果
        return Result.success(dto);
    }


    /**
     * 描述：根据appId查询我的功能列表Api
     * 参数：appId
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/12
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据appId查询我的功能列表", notes = "根据appId查询我的功能列表")
    @ApiResponses({
            @ApiResponse(code = 76005, message = "我的功能申请应用ID不能为空"),
    })
    @RequestMapping(value = "/getModuleList", method = RequestMethod.GET)
    public Result<List<ServiceModuleDTO>> getByAppId(@RequestParam("appId") String appId) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_APP_ID_NULL, appId);

        //2、根据appId查询我的功能列表
        List<ServiceModuleDTO> dto = dozerUtils.mapList(serviceModuleService.getByAppId(appId), ServiceModuleDTO.class);

        //3、返回
        return Result.success(dto);
    }


    /**
     * 描述：查询我的功能列表Api
     * 参数：
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "查询该用户下所有应用管理的所有功能", notes = "查询该用户下所有应用管理的所有功能")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<ServiceModuleDTO>> findList() {
        //1、获取基础信息
        Long userId = BaseContextHandler.getAdminId();

        //2、查询该用户下所有应用管理的所有功能
        List<ServiceModuleDTO> dto = dozerUtils.mapList(serviceModuleService.selectListByUserId(userId), ServiceModuleDTO.class);

        //3、返回
        return Result.success(dto);
    }

    /**
     * 描述：查询我的功能分页列表Api
     * 参数：pageNo,pageSize
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "查询我的功能分页列表", notes = "查询我的功能分页列表")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ServiceModuleDTO>> page(@RequestBody OpenApiReq<ServiceModulePageDTO> openApiReq) {
        //1.获取基础数据
        Long userId = openApiReq.getData().getUserId();

        //2.组装数据
        ServiceModuleExample example = new ServiceModuleExample();
        example.createCriteria().andCreateUserEqualTo(userId);
        example.setOrderByClause("id asc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询并返回
        return Result.success(new PageInfo<>(dozerUtils.mapPage(serviceModuleService.find(example), ServiceModuleDTO.class)));
    }

}