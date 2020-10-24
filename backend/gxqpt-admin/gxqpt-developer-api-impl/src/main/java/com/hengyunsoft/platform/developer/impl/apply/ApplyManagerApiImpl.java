package com.hengyunsoft.platform.developer.impl.apply;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.msg.BriefTpye;
import com.hengyunsoft.commons.msg.DeveloperBizType;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.RolePower;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RolePowerService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.developer.api.apply.ApplyManagerApi;
import com.hengyunsoft.platform.developer.api.apply.dto.*;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceModuleApply;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplyQueryDO;
import com.hengyunsoft.platform.developer.entity.core.po.DependRelation;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.impl.manager.ServiceModuleCommon;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.*;
import com.hengyunsoft.platform.developer.repository.core.service.DependRelationService;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleApplyService;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.search.queue.SearchQueueProducer;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Api(value = "API - ApplyManagerApiImpl", description = "获取我的任务列表")
@Slf4j
@RestController
@RequestMapping("applyManager")
public class ApplyManagerApiImpl implements ApplyManagerApi{

	@Autowired
	private ApplicationApplyService applicationApplyService;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
    private ServiceAssignModuleApplyService serviceAssignModuleApplyService;

	@Autowired
    private ServiceAssignModuleService serviceAssignModuleService;

	@Autowired
    private ServiceModuleApplyService serviceModuleApplyService;

	@Autowired
    private ServiceModuleService serviceModuleService;

	@Autowired
    private AssignRoleService assignRoleService;

	@Autowired
    private RoleService roleService;

    @Autowired
	private RolePowerService rolePowerService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    SearchQueueProducer searchQueueProducer;

    @Autowired
    ServiceResourceService serviceResourceService;

    @Autowired
    ServiceResourceDocService serviceResourceDocService;

    @Autowired
    DependRelationService dependRelationService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    @Autowired
    ServiceModuleCommon serviceModuleCommon;

    /*角色名称尾缀*/
    private static final String roleName = "管理员";
    /*角色编码*/
    private static final String roleCode = "app_admin";
    /*角色默认状态*/
    private static final Short roleStatus = 1;
    /*角色是否平台管理员*/
    private static final Boolean rolePt = false;
    /*角色只读状态*/
    private static final Boolean roleReadOnly = true;

//	@RequestMapping("getTask")
//	public Object getTask(String moduleId, String auditStatus, String taskType, String taskRole, Boolean auditApp2ModelAdd, ArrayList<String> appIds,Long applyUser) {
//
//		return applicationApplyService.queryMyTask(moduleId, auditStatus, appIds, taskType, taskRole, auditApp2ModelAdd,applyUser);
//	}


    @Override
    @ApiOperation(value = "获取我的任务列表", notes = "获取我的任务列表")
    @RequestMapping(value = "/listApply", method = RequestMethod.POST)
    public Result<PageInfo<ApplyDTO>> pageListApply(@RequestBody  OpenApiReq<ApplyQueryDTO> openApiReq) {

        ApplyQueryDTO queryDto = openApiReq.getData();
        Long loginUser = BaseContextHandler.getAdminId();
        //获取服务监控系统的appId   这个接口只有服务监控系统来查看
        String appId = BaseContextHandler.getAppId();

        //2.查询管理的应用集合
        List<ApplicationDO> adminApp = applicationService.findAppByAdmin(loginUser, null);

        List<String> adminAppIds = getAppIds(adminApp);
        List<String> queryAppIds = null;
        if(!StringUtils.isEmpty(queryDto.getAppId())) {

            if(adminAppIds.contains(queryDto.getAppId())) {
                queryAppIds = new ArrayList<>(1);
                queryAppIds.add(queryDto.getAppId());
            }
        } else {
            queryAppIds = adminAppIds;
        }

        //只有服务监控系统的管理员才有审批权限
        Boolean auditApp2ModelAdd = StringUtils.isEmpty(appId)?false:adminAppIds.contains(appId);

        List<ApplyQueryDO> applyQuery = applicationApplyService.queryMyTask(queryDto.getModuleName(),queryDto.getAppName(),queryDto.getModuleId(), queryDto.getAuditStatus(), queryAppIds, queryDto.getTaskType(), queryDto.getTaskRole(), auditApp2ModelAdd ,loginUser,openApiReq);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(applyQuery, ApplyDTO.class)));
    }

    @Override
    @ApiOperation(value = "获取我的任务列表中对应任务的详情", notes = "获取我的任务列表对应任务的详情")
    @ApiResponses({
            @ApiResponse(code = 58501, message = "类型的ID不能为空"),
            @ApiResponse(code = 58502, message = "任务类型不能为空"),
    })
    @RequestMapping(value = "/getApplyDetail", method = RequestMethod.POST)
    public Result<ApplyQueryDetailDTO> getApplyDetail(@RequestBody ApplyDetailDTO applyDetailDTO) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLYMANAGER_ID_NULL, applyDetailDTO.getId().toString());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLYMANAGER_TASKTYPE_NULL, applyDetailDTO.getTaskType());

        //根据taskType 查询对应的详情信息
        if(applyDetailDTO.getTaskType().contains("app")){
            //查询applicationapply详情
            ApplicationApply applicationApplies = applicationApplyService.getById(applyDetailDTO.getId());
            AppApplyDTO appApplyDTO = dozerUtils.map(applicationApplies, AppApplyDTO.class);

            //根据字典获取对应应用分类
            appApplyDTO.setAuditStatus(applicationApplies.getApplyStatus());
            appApplyDTO.setAppName(applicationApplies.getName());
            appApplyDTO.setTaskType(applyDetailDTO.getTaskType());
            return Result.success(appApplyDTO);

        }else if(applyDetailDTO.getTaskType().contains("module")){
            //查询service_module_apply对应详情
            ServiceModuleApply serviceModuleApply = serviceModuleApplyService.getById(applyDetailDTO.getId());
            AppModuleDTO appModuleDTO = dozerUtils.map(serviceModuleApply, AppModuleDTO.class);

            //查找对应应用类型名
            ModuleType moduleTypeMap = new ModuleType();
            moduleTypeMap.setModuleId(String.valueOf(serviceModuleApply.getId()));
            //根据字典获取对应功能分类型分类
            com.hengyunsoft.platform.admin.entity.base.po.Dictionary dictionary = dictionaryService.findByCode(serviceModuleApply.getModuleType());
            if(dictionary == null){
                return Result.fail("该功能没有对应的正确的功能类型");
            }
            moduleTypeMap.setModuleTypeName(dictionary.getName());
            moduleTypeMap.setModuleType(dictionary.getCode());
            appModuleDTO.setModuleTypeMap(moduleTypeMap);

            appModuleDTO.setAuditStatus(serviceModuleApply.getApplyStatus());
            ApplicationExample applicationEX = new ApplicationExample();
            applicationEX.createCriteria().andAppIdEqualTo(serviceModuleApply.getAppId());
            Application application = applicationService.getUnique(applicationEX);
            if(application == null){
                return Result.fail("该功能没有对应应用");
            }
            appModuleDTO.setAppName(application.getName());
            appModuleDTO.setModuleName(serviceModuleApply.getName());
            appModuleDTO.setTaskType(applyDetailDTO.getTaskType());
            return Result.success(appModuleDTO);
        }else if(applyDetailDTO.getTaskType().contains("assign")){
            //获取任务分配信息 service_assign_module_apply 的详情
            ServiceAssignModuleApply serviceAssignModuleApply = serviceAssignModuleApplyService.getById(applyDetailDTO.getId());
            AppAssignDTO appAssignDTO = dozerUtils.map(serviceAssignModuleApply, AppAssignDTO.class);
            appAssignDTO.setAuditStatus(serviceAssignModuleApply.getStatus());
            ApplicationExample ex = new ApplicationExample();
            ex.createCriteria().andAppIdEqualTo(serviceAssignModuleApply.getAppId());
            Application application = applicationService.getUnique(ex);
            if(application == null){
                return Result.fail("该调用功能没有对应应用");
            }
            appAssignDTO.setAppName(application.getName());

            ServiceModule serviceM = serviceModuleService.getById(serviceAssignModuleApply.getModuleId());

            if(serviceM == null){
                return Result.fail("该调用没有对应功能");
            }
            ModuleType moduleTypeMap = new ModuleType();
            moduleTypeMap.setModuleId(String.valueOf(serviceM.getId()));
            moduleTypeMap.setModuleTypeName(serviceM.getName());
            appAssignDTO.setModuleTypeMap(moduleTypeMap);
            appAssignDTO.setModuleName(serviceM.getName());
            appAssignDTO.setCode(serviceM.getCode());
            appAssignDTO.setTaskType(applyDetailDTO.getTaskType());
            return Result.success(appAssignDTO);
        }
        return null;
    }

    @Override
    @ApiOperation(value = "审批", notes = "审批")
    @ApiResponses({
            @ApiResponse(code = 58501, message = "类型的ID不能为空"),
            @ApiResponse(code = 58502, message = "任务类型不能为空"),
            //@ApiResponse(code = 58503, message = "批注不能为空"),
    })
    @RequestMapping(value = "/updateByAudit", method = RequestMethod.POST)
    public Result<String> updateByAudit(@RequestBody ApplyUpdateDTO applyUpdateDTO){
	    //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLYMANAGER_ID_NULL, applyUpdateDTO.getId().toString());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLYMANAGER_TASKTYPE_NULL, applyUpdateDTO.getTaskType());
        //BizAssert.assertNotEmpty(AuthorityExceptionCode. APPLYMANAGER_AUDITDESC_NULL, applyUpdateDTO.getAuditDesc());

        //根据taskType 查询对应的详情信息
        Boolean result = false;
        //应用审批
        if(applyUpdateDTO.getTaskType().equalsIgnoreCase("appAudit")){

            result = updateAppAudit(applyUpdateDTO);

         //功能审批
        }else if(applyUpdateDTO.getTaskType().equalsIgnoreCase("moduleAudit")){

            result = updateModuleAudit(applyUpdateDTO);

         //调用审批
        }else if(applyUpdateDTO.getTaskType().equalsIgnoreCase("assignAudit")){

            result = updateAssignAduit(applyUpdateDTO);

        }

        //结果状态返回
        if(result){
            return Result.success("审批成功");
        }
        return Result.fail("审批失败");
    }


    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ServiceAssignModuleApply serviceAssignModuleApply, boolean pass,String moduleName) {
    	BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
    	bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
    	bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
    	bbsAllMainMsgDTO.setBizId(serviceAssignModuleApply.getId().toString());
    	bbsAllMainMsgDTO.setBizType(DeveloperBizType.INVOKE_MODULE_AUDIT_RESULT);
    	bbsAllMainMsgDTO.setBriefTpye(BriefTpye.AUDIT_RESULT);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
    	if(pass) {
	    	bbsAllMainMsgDTO.setContent("您申请调用的"+moduleName+"功能已审批通过.");
	    	bbsAllMainMsgDTO.setTitle(moduleName+"功能调用审批通过");
    	} else {
	    	bbsAllMainMsgDTO.setContent("您申请调用的"+moduleName+"功能审批未通过.");
	    	bbsAllMainMsgDTO.setTitle(moduleName+"功能审批未通过");
    	}
    	bbsAllMainMsgDTO.setDetailedType("module_invoke");
    	bbsAllMainMsgDTO.setDetailedTypeDesc("功能调用审批结果");
    	bbsAllMainMsgDTO.setHandlerNeedIs(false);
    	bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
    	bbsAllMainMsgDTO.setHandlerParams("moduleName="+moduleName);
    	bbsAllMainMsgDTO.setSenderName("系统自动通知");
		return bbsAllMainMsgDTO;
	}

	private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ServiceModuleApply serviceModuleApply, boolean pass) {
    	BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
    	bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
    	bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
    	bbsAllMainMsgDTO.setBizId(serviceModuleApply.getId().toString());
    	bbsAllMainMsgDTO.setBizType(DeveloperBizType.ADD_MODULE_AUDIT_RESULT);
    	bbsAllMainMsgDTO.setBriefTpye(BriefTpye.AUDIT_RESULT);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
    	if(pass) {
	    	bbsAllMainMsgDTO.setContent("您申请新增的"+serviceModuleApply.getName()+"功能已审批通过.");
	    	bbsAllMainMsgDTO.setTitle(serviceModuleApply.getName()+"功能审批通过");
    	} else {
	    	bbsAllMainMsgDTO.setContent("您申请新增的"+serviceModuleApply.getName()+"功能审批未通过.");
	    	bbsAllMainMsgDTO.setTitle(serviceModuleApply.getName()+"功能审批未通过");
    	}
    	bbsAllMainMsgDTO.setDetailedType("module_add_apply");
    	bbsAllMainMsgDTO.setDetailedTypeDesc("功能新增审批结果");
    	bbsAllMainMsgDTO.setHandlerNeedIs(false);
    	bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
    	bbsAllMainMsgDTO.setHandlerParams("moduleName="+serviceModuleApply.getName());
    	bbsAllMainMsgDTO.setSenderName("系统自动通知");
		return bbsAllMainMsgDTO;
	}

	private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ApplicationApply applicationApply, boolean pass) {
    	
    	BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
    	
    	bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
    	bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
    	bbsAllMainMsgDTO.setBizId(applicationApply.getId().toString());
    	bbsAllMainMsgDTO.setBizType(DeveloperBizType.ADD_APP_AUDIT_RESULT);
    	bbsAllMainMsgDTO.setBriefTpye(BriefTpye.AUDIT_RESULT);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
    	if(pass) {
	    	bbsAllMainMsgDTO.setContent("您申请接入到一体化平台的"+applicationApply.getName()+"应用已审批通过.");
	    	bbsAllMainMsgDTO.setTitle(applicationApply.getName()+"审批通过");
    	} else {
	    	bbsAllMainMsgDTO.setContent("您申请接入到一体化平台的"+applicationApply.getName()+"应用审批未通过.");
	    	bbsAllMainMsgDTO.setTitle(applicationApply.getName()+"接入审批未通过");
    	}
    	bbsAllMainMsgDTO.setDetailedType("add_app");
    	bbsAllMainMsgDTO.setDetailedTypeDesc("新增应用审批结果");
    	bbsAllMainMsgDTO.setHandlerNeedIs(false);
    	bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
    	bbsAllMainMsgDTO.setHandlerParams("appName="+applicationApply.getName());
    	bbsAllMainMsgDTO.setSenderName("系统自动通知");
		return bbsAllMainMsgDTO;
	}

    /**
     * 应用审批
     * */
    public boolean updateAppAudit(ApplyUpdateDTO applyUpdateDTO){
        Boolean result =false;
        //审批applicationapply 基本信息设置
        ApplicationApply applicationApply = applicationApplyService.getById(applyUpdateDTO.getId());
        applicationApply.setAuditUserName(BaseContextHandler.getName());
        applicationApply.setAuditUser(BaseContextHandler.getAdminId());
        applicationApply.setAuditDesc(applyUpdateDTO.getAuditDesc());
        applicationApply.setUpdateUser(BaseContextHandler.getAdminId());
        applicationApply.setUpdateTime(new Date());

        //是否通过 1，待审核 2 通过 3.不通过
        List<Long> lookUserIds = new ArrayList<>(1);
        lookUserIds.add(applicationApply.getApplyUser());
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        if(applyUpdateDTO.getPassornot()){

            applicationApply.setApplyStatus((short)2);
            //添加管理员角色
            Role role = new Role();
            role.setAuthManageIs(false);
            role.setAppId(applicationApply.getAppId());
            role.setName(applicationApply.getName() + roleName);
            role.setCode(roleCode);
            role.setDesc(applicationApply.getName() + roleName);
            role.setStatus(roleStatus);
            role.setPtRole(rolePt);
            role.setReadonly(roleReadOnly);
            role.setUpdateUser(BaseContextHandler.getAdminId());
            role.setCreateUser(BaseContextHandler.getAdminId());
            role = roleService.save(role);

            //添加对应的正式应用
            Application application = dozerUtils.map(applicationApply, Application.class);
            application = applicationService.save(application);
            //表关联 申请成功后关联对应应用的ID
            applicationApply.setSuccessPassAppId(application.getId());

            //绑定申请人至管理员角色
            AssignRole assignRole = new AssignRole();
            assignRole.setUserId(applicationApply.getCreateUser());
            assignRole.setRoleId(role.getId());
            assignRole.setCreateUser(applicationApply.getCreateUser());
            assignRole.setCreateTime(new Date());
            assignRoleService.save(assignRole);

            //绑定角色的资源、应用权限  统称为角色的权力
            RolePower rolePower = new RolePower();
            Short bizType = 2;//业务类型 1资源    2应用
            rolePower.setBizId(application.getId());
            rolePower.setBizType(bizType);
            rolePower.setRoleId(role.getId());
            rolePower.setCreateUser(BaseContextHandler.getAdminId());
            rolePower.setCreateTime(new Date());
            rolePowerService.saveSelective(rolePower);
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(applicationApply,true);

        }else{
            applicationApply.setApplyStatus((short)3);
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(applicationApply,false);
        }

        int ret = applicationApplyService.updateByIdSelective(applicationApply);

        //更新消息为已处理
        UpdateBacklogReqDTO dto = new UpdateBacklogReqDTO();
        dto.setBizId(applicationApply.getId().toString());
        dto.setBizType(DeveloperBizType.ADD_APP_AUDIT);
        dto.setAppId(BaseContextHandler.getAppId());
        msgQueueProducer.updateBbsToHandleed(dto );

        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);

        if(ret > 0){
            result = true;
        }

        return result;
    }

    /**
     * 功能审批
     * */
    public  boolean updateModuleAudit(ApplyUpdateDTO applyUpdateDTO){
        Boolean result =false;
        //根据ID获取swagger地址
        ServiceModuleApply serviceModuleApply = serviceModuleApplyService.getById(applyUpdateDTO.getId());
        if(serviceModuleApply == null){
            return result;
        }
        //Long moduleId = serviceModuleApply.getId();
        String appId = serviceModuleApply.getAppId();
        String swaggerUrl = serviceModuleApply.getApiSyncUrl();

        //审批service_module_apply 基本信息设置
        serviceModuleApply.setAuditUserName(BaseContextHandler.getName());
        serviceModuleApply.setAuditUser(BaseContextHandler.getAdminId());
        serviceModuleApply.setAuditDesc(applyUpdateDTO.getAuditDesc());
        serviceModuleApply.setUpdateUser(BaseContextHandler.getAdminId());
        serviceModuleApply.setUpdateTime(new Date());

        //是否通过 1，待审核 2 通过 3.不通过
        List<Long> lookUserIds = new ArrayList<>(1);
        lookUserIds.add(serviceModuleApply.getApplyUser());
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        if(applyUpdateDTO.getPassornot()){
            serviceModuleApply.setApplyStatus((short)2);
            //添加对应的正式应用
            ServiceModule serviceModule = dozerUtils.map(serviceModuleApply, ServiceModule.class);
            ServiceModule sm = serviceModuleService.save(serviceModule);
            //表关联 功能申请成功后关联对应功能模块ID
            if(sm == null){
                return  result;
            }

            //处理swagger字符串 解析swagger，记录模块资源信息
            serviceModuleCommon.updateSwaggerJsonStr(swaggerUrl,sm.getId(),appId);

            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceModuleApply,true);
            serviceModuleApply.setSuccessPassModuleId(sm.getId());
        }else{
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceModuleApply,false);
            serviceModuleApply.setApplyStatus((short)3);
        }

        int ret = serviceModuleApplyService.updateByIdSelective(serviceModuleApply);
        //更新消息为已处理
        UpdateBacklogReqDTO dto = new UpdateBacklogReqDTO();
        dto.setBizId(serviceModuleApply.getId().toString());
        dto.setBizType(DeveloperBizType.ADD_MODULE_AUDIT);
        dto.setAppId(BaseContextHandler.getAppId());
        msgQueueProducer.updateBbsToHandleed(dto );

        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);

        if(ret > 0){
            result = true;
        }
        return result;

    }

    /**
     * 调用审批
     * */
    public boolean updateAssignAduit(ApplyUpdateDTO applyUpdateDTO){
        Boolean result = false;
        //审批 service_assign_module_apply 的详情 基本信息设置
        ServiceAssignModuleApply serviceAssignModuleApply = serviceAssignModuleApplyService.getById(applyUpdateDTO.getId());
        serviceAssignModuleApply.setAuditUserName(BaseContextHandler.getName());
        serviceAssignModuleApply.setAuditUser(BaseContextHandler.getAdminId());
        serviceAssignModuleApply.setAuditDesc(applyUpdateDTO.getAuditDesc());
        serviceAssignModuleApply.setUpdateUser(BaseContextHandler.getAdminId());
        serviceAssignModuleApply.setUpdateTime(new Date());

        //是否通过 1，待审核 2 通过 3.不通过
        List<Long> lookUserIds = new ArrayList<>(1);
        lookUserIds.add(serviceAssignModuleApply.getApplyUser());
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        if(applyUpdateDTO.getPassornot()){

            serviceAssignModuleApply.setStatus((short)2);
            //添加对应的正式应用
            //ServiceAssignModule serviceAssignModule = dozerUtils.map(serviceAssignModuleApply, ServiceAssignModule.class);
            ServiceAssignModule serviceAssignModule = new ServiceAssignModule();
            serviceAssignModule.setAppId(serviceAssignModuleApply.getAppId());
            serviceAssignModule.setCreateTime(serviceAssignModuleApply.getCreateTime());
            serviceAssignModule.setCreateUser(serviceAssignModuleApply.getCreateUser());
            serviceAssignModule.setModuleId(serviceAssignModuleApply.getModuleId());
            serviceAssignModule.setStatus(true);
            serviceAssignModule.setUpdateUser(serviceAssignModuleApply.getUpdateUser());
            serviceAssignModule.setUpdateTime(serviceAssignModuleApply.getUpdateTime());
            ServiceAssignModule serviceAssignModule1 = serviceAssignModuleService.save(serviceAssignModule);

            //保存数据到生产者消费者依赖关系2018-5-3
            String app_Id = serviceAssignModule.getAppId();
            ApplicationExample appExample = new ApplicationExample();
            appExample.createCriteria().andAppIdEqualTo(app_Id);
            Application application = applicationService.getUnique(appExample);
            ServiceModule module = serviceModuleService.getById(serviceAssignModule.getModuleId());
            //功能类型
            String type = "module";
            DependRelation dependRelation = new DependRelation();
            dependRelation.setConsumeType(type);
            dependRelation.setProducerType(type);
            dependRelation.setConsumeId(application.getId());
            dependRelation.setProducerId(serviceAssignModule.getModuleId());
            dependRelation.setProducerName(module.getName());
            dependRelation.setReduceTime(module.getReduceTime());
            dependRelation.setReduceCost(module.getReduceCost());
            dependRelation.setCreateUser(BaseContextHandler.getAdminId());
            dependRelation.setUpdateUser(dependRelation.getCreateUser());
            dependRelation.setCreateTime(new Date());
            dependRelation.setUpdateTime(new Date());
            dependRelationService.save(dependRelation);

            //表关联 功能调用申请成功后关联的功能调用的ID
            serviceAssignModuleApply.setServiceAssignModuleId(serviceAssignModule1.getId());
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceAssignModuleApply,true,module.getName());
        }else{
            serviceAssignModuleApply.setStatus((short)3);
            ServiceModule module = serviceModuleService.getById(serviceAssignModuleApply.getModuleId());
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceAssignModuleApply,false,module.getName());
        }

        int ret = serviceAssignModuleApplyService.updateByIdSelective(serviceAssignModuleApply);

        //更新消息为已处理
        UpdateBacklogReqDTO dto = new UpdateBacklogReqDTO();
        dto.setBizId(serviceAssignModuleApply.getId().toString());
        dto.setBizType(DeveloperBizType.INVOKE_MODULE_AUDIT);
        dto.setAppId(BaseContextHandler.getAppId());
        msgQueueProducer.updateBbsToHandleed(dto );

        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);

        if(ret > 0){
            result = true;
        }
        return result;
    }

    private List<String> getAppIds(List<ApplicationDO> adminApp) {

		if(CollectionUtils.isEmpty(adminApp)) {
			return Collections.EMPTY_LIST;
		}
		List<String> appIds = new ArrayList<>(adminApp.size());
		for (Application application : adminApp) {
			appIds.add(application.getAppId());
		}
		return appIds;
	}
}
