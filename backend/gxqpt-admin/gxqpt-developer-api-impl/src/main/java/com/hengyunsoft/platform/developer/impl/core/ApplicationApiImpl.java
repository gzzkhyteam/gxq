package com.hengyunsoft.platform.developer.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.dictionarytype.BaseDictionaryType;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.msg.BriefTpye;
import com.hengyunsoft.commons.msg.DeveloperBizType;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.core.domain.AssignRoleManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppQueryDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppRelationDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppRelationRetDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationDetailsDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationFiveSupportResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationLikeDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationSelectDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationUpdateDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.CountOrgApplicationDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.RequestAppNameDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.RequestApplicationDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ResponseApplicationDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplyAuditDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplySaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserResDTO;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationRelationDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.CountOrgApplicationDO;
import com.hengyunsoft.platform.developer.entity.core.po.DependRelation;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationApplyExample;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationApplyService;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.core.service.DependRelationService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "API - ApplicationApplyApiImpl", description = "应用/服务管理")
@RestController
@RequestMapping("/application")
@Slf4j
public class ApplicationApiImpl implements ApplicationApi {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationApplyService applicationApplyService;
    @Autowired
    private UserService userService;
    @Autowired
    private AssignRoleService assignRoleService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    DependRelationService dependRelationService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    /*角色名称尾缀*/
    private static final String ROLENAME = "管理员";
    /*角色编码*/
    private static final String ROLECODE = "app_admin";
    /*角色默认状态*/
    private static final Short ROLESTATUS = 1;
    /*角色是否平台管理员*/
    private static final Boolean ROLEPT = false;
    /*角色只读状态*/
    private static final Boolean ROLEREADONLY = false;
    /*应用启用状态*/
    private static final Boolean STATUS = true;

    /**
     * 描述:根据name查询应用
     *
     * @return
     * @date 2018/3/28 19:39
     */
    @Override
    @ApiOperation(value = "根据name查询应用", notes = "根据name查询应用")
    @ApiResponses({
            @ApiResponse(code = 57500, message = "应用名称不能为空"),
    })
    @RequestMapping(value = "/findAppListByName", method = RequestMethod.POST)
    public Result<List<AppQueryDTO>> findAppListByName(@RequestParam(value = "name") String name) {

        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.APPLICATION_NAME_NULL, name);

        //2.基础数据获取
        Long userId = BaseContextHandler.getAdminId();

        //3.数据查询
        List<Application> applications = applicationService.findAppListByNameAndUserId(name, userId);

        //4.转换
        List<AppQueryDTO> listApp = dozerUtils.mapList(applications, AppQueryDTO.class);

        return Result.success(listApp);
    }

    /**
     * 描述：获取当前登录用户所拥有应用
     * 参数：id：角色id;
     * 返回值：ResourceTreeDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取登录用户拥有应用", notes = "获取当前登录用户所用于用户")
    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public Result<List<AppShowDto>> findAppIdList(@RequestParam(value = "type", required = false) Long type) {
        //1、获取基础信息
        //type==1:只查应用;type==2:只查服务
        Long userId = BaseContextHandler.getAdminId();

        //2、查询该角色拥有的资源
        List<AppShowDto> appShowDtos = dozerUtils.mapList(applicationService.findAppByAdmin(userId, type), AppShowDto.class);

        //3、返回
        return Result.success(appShowDtos);
    }

    /**
     * 查询所有应用
     *
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "获取所有应用", notes = "获取所有应用")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationAllDTO>> findAll(@RequestBody OpenApiReq<ApplicationAllReqDTO> openApiReq) {
        //1.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询所有应用
        ApplicationExample example = new ApplicationExample();
        if (openApiReq.getData() != null && openApiReq.getData().getName() != null) {
            example.createCriteria().andNameLike(ApplicationExample.fullLike(openApiReq.getData().getName()));
        }
        example.setOrderByClause("order_no asc");
        List list = dozerUtils.mapPage(applicationService.find(example), ApplicationAllDTO.class);
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 查询所有应用(非分页)
     *
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "获取所有应用(非分页)", notes = "获取所有应用(非分页)")
    @RequestMapping(value = "/findAllList", method = RequestMethod.GET)
    @IgnoreToken
    public Result<List<ApplicationAllDTO>> findAllList() {

        //查询所有应用
        ApplicationExample example = new ApplicationExample();
        example.setOrderByClause("order_no asc");
        List list = dozerUtils.mapPage(applicationService.find(example), ApplicationAllDTO.class);
        return Result.success(list);
    }

    /**
     * 应用列表查询
     *
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "应用列表查询", notes = "应用列表查询")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Result<List<ApplicationResDTO>> find() {
        //1.获取必要信息
        Long id = BaseContextHandler.getAdminId();

        //2.查询并返回信息
        List<ApplicationResDTO> list = dozerUtils.mapList(applicationService.findAppByAdminEdit(id, null), ApplicationResDTO.class);
        return Result.success(list);
    }

    /**
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "应用模糊查询", notes = "应用模糊查询")
    @RequestMapping(value = "/findLike", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationResDTO>> findLike(@RequestBody OpenApiReq<ApplicationLikeDTO> openApiReq) {
        //1.查询条件
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andStatusEqualTo(STATUS)
                .andNameLike(ApplicationExample.fullLike(openApiReq.getData().getName()));

        //2.获取结果并转换
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils
                .mapList(applicationService.find(example), ApplicationResDTO.class)));
    }

    @Override
    @ApiOperation(value = "按应用类型模糊获取应用", notes = "按应用类型模糊获取应用")
    @RequestMapping(value = "/findByType", method = RequestMethod.GET)
    public Result<List<ApplicationSelectDTO>> findByType(@RequestParam(value = "type") Short type) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_TYPE_NULL, type);

        //2.设置条件
        ApplicationExample example = new ApplicationExample();
        Short[] shorts = {type, 3};

        //3.查询转换并返回
        example.createCriteria().andAppTypeIn(Arrays.asList(shorts));
        List<ApplicationSelectDTO> list = dozerUtils.mapList(applicationService.find(example), ApplicationSelectDTO.class);
        return Result.success(list);
    }

    @Override
    @ApiOperation(value = "根据应用类型查询所有应用", notes = "根据应用类型查询所有应用")
    @RequestMapping(value = "/findAppTypeAll", method = RequestMethod.GET)
    public Result<List<ApplicationSelectDTO>> findAppTypeAll(@RequestParam(value = "type") String type) {
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andTypeEqualTo(type);
        List list = dozerUtils.mapList(applicationService.find(example), ApplicationSelectDTO.class);
        return Result.success(list);
    }

    /**
     * 应用管理员查询
     *
     * @param openApiReq
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 76500, message = "应用/服务appid不能为空")
    })
    @ApiOperation(value = "应用管理员查询", notes = "应用管理员查询")
    @RequestMapping(value = "/pageAppManager", method = RequestMethod.POST)
    public Result<PageInfo<UserResDTO>> pageAppManager(@RequestBody OpenApiReq<UserManagerReqDTO> openApiReq) {
        //1.验证
        BizAssert.assertNotEmpty(DeveloperExceptionCode.APPLICATION_APPID_NULL, openApiReq.getData().getAppId());

        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询并转换
        List<UserResDTO> userRess = dozerUtils.mapPage(userService.findUserManagerByApp(openApiReq.getData().getAccount(),
                openApiReq.getData().getName() == null || openApiReq.getData().getName().equals("")
                        ? null : openApiReq.getData().getName(),
                openApiReq.getData().getAppId() == null || openApiReq.getData().getAppId().equals("")
                        ? null : openApiReq.getData().getAppId()), UserResDTO.class);
        return Result.success(new PageInfo<>(userRess));
    }

    /**
     * 应用管理员维护(取消关联)
     *
     * @param userId
     * @param appId
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空"),
            @ApiResponse(code = 76502, message = "应用/服务id不能为空")
    })
    @ApiOperation(value = "应用管理员维护(取消关联)", notes = "应用管理员维护(取消关联)")
    @RequestMapping(value = "/deleteAppManager", method = RequestMethod.DELETE)
    public Result<Boolean> deleteAppManager(@RequestParam(value = "userId") Long userId,
                                            @RequestParam(value = "appId") String appId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.APPLICATION_ID_NULL, appId);

        //2.执行DML操作
        if (assignRoleService.deleteAssignRoleByAppAndUser(userId, appId) > 0) {
            return Result.success(true);
        } else {
            return Result.fail("至少必须保留一个管理员！");
        }
    }

    /**
     * 应用管理员维护(关联)
     *
     * @param userId
     * @param appId
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空"),
            @ApiResponse(code = 76502, message = "应用/服务id不能为空")
    })
    @ApiOperation(value = "应用管理员维护(关联)", notes = "应用管理员维护(关联)")
    @RequestMapping(value = "/saveAppManager", method = RequestMethod.POST)
    public Result<Boolean> saveAppManager(@RequestParam(value = "userId") Long userId,
                                          @RequestParam(value = "appId") String appId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.APPLICATION_ID_NULL, appId);

        //2.封装PO
        AssignRoleManagerDO assignRole = new AssignRoleManagerDO();
        assignRole.setUserId(userId);
        assignRole.setAppId(appId);
        assignRole.setCreateUser(BaseContextHandler.getAdminId());
        assignRole.setCreateTime(new Date());
        assignRole.setId(assignRoleService.genId());

        //3.执行DML操作
        if (assignRoleService.insertAssignRoleByAppAndUser(assignRole) > 0) {
            return Result.success(true);
        }
        return Result.fail("失败,应用可能不存在管理角色");
    }

    /**
     * 应用详情查询
     *
     * @param id
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 76502, message = "应用/服务id不能为空")
    })
    @ApiOperation(value = "应用详情查询", notes = "应用详情查询")
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    public Result<ApplicationDetailsDTO> getDetails(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_ID_NULL, id);

        //2.查询并转换
        ApplicationDetailsDTO applicationDetails = dozerUtils.map(applicationService.getDetails(id),
                ApplicationDetailsDTO.class);
        return Result.success(applicationDetails);
    }

    /**
     * 应用信息修改
     *
     * @param applicationUpdate
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 76502, message = "应用/服务id不能为空"),
            @ApiResponse(code = 76501, message = "应用/服务的名称不能为空")
    })
    @ApiOperation(value = "应用信息修改", notes = "应用信息修改")
    @RequestMapping(value = "/updateApp", method = RequestMethod.PUT)
    @ValidatorStandard(
            {
                    @Constraint(value = Application.class)
            }
    )
    public Result<Boolean> updateApp(@RequestBody ApplicationUpdateDTO applicationUpdate) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_ID_NULL, applicationUpdate.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_NAME_NULL, applicationUpdate.getName());

        //2.设置修改基本信息
        Application po = dozerUtils.map(applicationUpdate, Application.class);
        po.setReduceCost(computerReduceCost(applicationUpdate.getReduceBuildCost(), applicationUpdate.getReduceProtectCost(), applicationUpdate.getReduceUseCost()));
        po.setUpdateUser(BaseContextHandler.getAdminId());
        po.setUpdateTime(new Date());

        //2.执行DML操作
        if (applicationService.updateByIdSelective(po) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 添加应用(申请栈)
     *
     * @param applicationApplySave
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空"),
            @ApiResponse(code = 76501, message = "应用/服务的名称不能为空"),
            @ApiResponse(code = 76506, message = "应用code不能为空")
    })
    @ApiOperation(value = "添加应用(申请栈)", notes = "添加应用(申请栈)")
    @RequestMapping(value = "/saveApply", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = ApplicationApply.class, groups = {Default.class, MustNoneNull.class})
            }
    )
    public Result<Boolean> saveApply(@RequestBody ApplicationApplySaveDTO applicationApplySave) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, applicationApplySave.getOrgId());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_NAME_NULL, applicationApplySave.getName());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_CODE_NULL, applicationApplySave.getCode());

        //2.转换
        ApplicationApply applicationApply = dozerUtils.map(applicationApplySave, ApplicationApply.class);

        //3.判断code唯一
        ApplicationApplyExample example = new ApplicationApplyExample();
        example.createCriteria().andCodeEqualTo(applicationApply.getCode());
        if (applicationApplyService.find(example).size()>0){
            return Result.fail("应用编码被占用");
        }


        //4.配置一些基本信息
        applicationApply.setReduceCost(computerReduceCost(applicationApply.getReduceBuildCost(), applicationApply.getReduceProtectCost(), applicationApply.getReduceUseCost()));
        applicationApply.setApplyStatus((short) 1);
        applicationApply.setStatus(true);
        applicationApply.setApplyUser(BaseContextHandler.getAdminId());
        applicationApply.setApplyUserName(BaseContextHandler.getName());
        applicationApply.setCreateUser(BaseContextHandler.getAdminId());
        applicationApply.setCreateTime(new Date());
        if (applicationApplyService.saveApp(applicationApply).getId() != null) {


            String errorMsg = msgQueueProducer.saveHandlerMsgToRole(builderBbsAllMainMsgDTO(applicationApply), RoleCode.APPLICATION_ADMIN_CODE, BaseContextHandler.getAppId());
            log.info("新增应用消息：" + errorMsg);
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ApplicationApply applicationApply) {

        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();

        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(applicationApply.getId().toString());
        bbsAllMainMsgDTO.setBizType(DeveloperBizType.ADD_APP_AUDIT);
        bbsAllMainMsgDTO.setBriefTpye(BriefTpye.WORK_AUDIT);

        bbsAllMainMsgDTO.setContent(applicationApply.getApplyUserName() + "申请" + applicationApply.getName() + "应用接入到一体化平台。");
        bbsAllMainMsgDTO.setTitle("申请" + applicationApply.getName() + "接入平台");

        bbsAllMainMsgDTO.setDetailedType("add_app_audit");
        bbsAllMainMsgDTO.setDetailedTypeDesc("新增应用申请");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
        bbsAllMainMsgDTO.setHandlerParams("appName=" + applicationApply.getName());
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    private Integer computerReduceCost(Integer reduceBuildCost, Integer reduceProtectCost, Integer reduceUseCost) {


        return reduceBuildCost + reduceProtectCost + reduceUseCost;
    }


    /**
     * 添加应用(审核栈)
     *
     * @param applicationApplyAudit
     * @return
     * @auther:wz
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 76503, message = "应用/服务申请id不能为空"),
            @ApiResponse(code = 76504, message = "应用/服务申请状态不能为空")
    })
    @ApiOperation(value = "添加应用(审核栈)", notes = "添加应用(审核栈)")
    @RequestMapping(value = "/saveApp", method = RequestMethod.POST)
    public Result<Boolean> saveApp(@RequestBody ApplicationApplyAuditDTO applicationApplyAudit) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_APPLY_ID_NULL, applicationApplyAudit.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_APPLY_APPSTATUS_NULL, applicationApplyAudit.getApplyStatus());

        //2.判断申请状态并处理对应的业务
        ApplicationApplyExample example = new ApplicationApplyExample();
        Date data = new Date();
        Long updateUser = BaseContextHandler.getAdminId();
        if (applicationApplyAudit.getApplyStatus() == 2) {
            //修改申请信息
            ApplicationApply vo = applicationApplyService.getById(applicationApplyAudit.getId());
            vo.setUpdateTime(data);
            vo.setUpdateUser(updateUser);
            vo.setAuditUser(updateUser);
            vo.setAuditUserName(BaseContextHandler.getName());
            vo.setApplyStatus(applicationApplyAudit.getApplyStatus());
            vo.setAuditDesc(applicationApplyAudit.getAuditDesc());
            vo.setStatus(true);

            //添加对应的正式应用
            Application application = dozerUtils.map(vo, Application.class);
            application = applicationService.save(application);

            //申请应用绑定对应正式应用
            vo.setSuccessPassAppId(application.getId());
            applicationApplyService.updateByIdSelective(vo);

            //添加管理员角色
            Role role = new Role();
            role.setAppId(application.getAppId());
            role.setName(application.getName() + ROLENAME);
            role.setCode(ROLECODE);
            role.setDesc(application.getName() + ROLENAME);
            role.setStatus(ROLESTATUS);
            role.setPtRole(ROLEPT);
            role.setReadonly(ROLEREADONLY);
            role.setAuthManageIs(false);
            role.setUpdateUser(updateUser);
            role.setCreateUser(updateUser);
            role = roleService.saveSelective(role);

            //绑定申请人至管理员角色
            AssignRole assignRole = new AssignRole();
            assignRole.setUserId(application.getCreateUser());
            assignRole.setRoleId(role.getId());
            assignRole.setCreateUser(updateUser);
            assignRole.setCreateTime(data);
            assignRole = assignRoleService.save(assignRole);
            Long id = assignRole.getId();
        } else if (applicationApplyAudit.getApplyStatus() == 3) {
            ApplicationApply vo = dozerUtils.map(applicationApplyAudit, ApplicationApply.class);
            vo.setUpdateTime(data);
            vo.setUpdateUser(BaseContextHandler.getAdminId());
            vo.setAuditUser(BaseContextHandler.getAdminId());
            vo.setAuditUserName(BaseContextHandler.getName());
            applicationApplyService.updateByIdSelective(vo);
        } else {
            return Result.fail("添加错误");
        }
        return Result.success(true);
    }

    /**
     * 查询应用之间依赖关系接口
     *
     * @return
     */
    @Override
    @ApiOperation(value = "查询应用之间依赖关系，分页，如果id存在则查询指定应用的依赖关系",
            notes = "查询应用之间依赖关系，分页，如果id存在则查询指定应用的依赖关系")
    @RequestMapping(value = "/getApplicationRelation", method = RequestMethod.POST)
    public Result<PageInfo<AppRelationRetDTO>> getApplicationRelation(@RequestBody OpenApiReq<AppQueryDTO> openApiReq) {
    	AppQueryDTO dto = openApiReq.getData();
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_ID_NULL, dto.getAppId());
        //1.查询所有应用
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        List<ApplicationRelationDO> list = applicationService.getApplicationRelation(Long.valueOf(dto.getAppId()),dto.getName());
        List<AppRelationRetDTO> returnList = dozerUtils.mapPage(list, AppRelationRetDTO.class);
        return Result.success(new PageInfo<>(returnList));
    }

    /**
     * 给指定应用添加相应的依赖
     *
     * @param appRelationDTO
     * @return
     */
    @Override
    @ApiOperation(value = "给指定应用添加相应的依赖", notes = "给指定应用添加相应的依赖")
    @ApiResponses({
            @ApiResponse(code = 76502, message = "应用/服务id不能为空"),
            @ApiResponse(code = 76509, message = "所依赖应用id不能为空"),
            @ApiResponse(code = 76508, message = "所依赖应用名称不能为空"),
    })
    @RequestMapping(value = "/saveApplicationRelation", method = RequestMethod.POST)
    public Result<String> saveApplicationRelation(AppRelationDTO appRelationDTO) {
        if (appRelationDTO.getId().equals(appRelationDTO.getProducerId())) {
            return Result.fail("不能进行自我依赖！");
        }
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_ID_NULL, appRelationDTO.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_PRODUCER_ID_NULL, appRelationDTO.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_PRODUCER_NAME_NULL, appRelationDTO.getId());
        //2.保存数据
        Application application = applicationService.getById(appRelationDTO.getProducerId());

        String type = "app";
        DependRelation dependRelation = new DependRelation();
        dependRelation.setConsumeType(type);
        dependRelation.setProducerType(type);
        dependRelation.setConsumeId(appRelationDTO.getId());
        dependRelation.setProducerId(appRelationDTO.getProducerId());
        dependRelation.setProducerName(appRelationDTO.getProducerName());
        dependRelation.setReduceTime(application.getReduceTime());
        dependRelation.setReduceCost(application.getReduceCost());
        dependRelation.setCreateUser(BaseContextHandler.getAdminId());
        dependRelation.setUpdateUser(dependRelation.getCreateUser());
        dependRelation.setCreateTime(new Date());
        dependRelation.setUpdateTime(new Date());
        DependRelation relation = dependRelationService.save(dependRelation);
        if (relation != null) {
            return Result.success("添加依赖成功！");
        }
        return Result.fail("添加依赖失败！");
    }


    /**
     * 删除指定应用的依赖
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "删除指定应用的依赖", notes = "删除指定应用的依赖")
    @ApiResponses({
            @ApiResponse(code = 76510, message = "依赖关系id不能为空"),
    })
    @RequestMapping(value = "/deleteAppRelation", method = RequestMethod.DELETE)
    public Result<String> deleteAppRelation(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_RELATION_ID_NULL, id);
        int result = dependRelationService.deleteById(id);
        if (result > 0) {
            return Result.success("删除依赖成功！");
        }
        return Result.fail("删除依赖失败！");
    }

    @Override
    @RequestMapping(value = "/findAppVisibleForSelf", method = RequestMethod.GET)
    //查询指定用户可见的应用列表
    @ApiOperation(value = "查询指定用户可见的应用列表", notes = "查询指定用户可见的应用列表")
    public Result<List<ApplicationResDTO>> findAppVisibleForSelf(@RequestParam(name = "type", required = false) Integer type) {

        Long userId = BaseContextHandler.getAdminId();
        List<Application> visibleApps = applicationService.findAppVisible(type, userId);
        List<ApplicationResDTO> returnList = dozerUtils.mapList(visibleApps, ApplicationResDTO.class);
        return Result.success(returnList);
    }

    @RequestMapping(value = "/pageAppVisibleForSelf", method = RequestMethod.POST)
    //查询指定用户可见的应用列表
    @ApiOperation(value = "查询指定用户可见的应用列表", notes = "查询指定用户可见的应用列表")
    public Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelf(@RequestBody OpenApiReq<Integer> openApiReq) {

        Long userId = BaseContextHandler.getAdminId();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<Application> visibleApps = applicationService.findAppVisible(openApiReq.getData(), userId);
//        List<ApplicationResDTO> returnList = dozerUtils.mapList(visibleApps, ApplicationResDTO.class);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(visibleApps, ApplicationResDTO.class)));
    }

    @Override
    @RequestMapping(value = "/pageAppVisibleForSelfName", method = RequestMethod.POST)
    @ApiOperation(value = "根据名称指定用户可见的应用列表", notes = "根据名称指定用户可见的应用列表")
    public Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelfName(@RequestBody OpenApiReq<RequestAppNameDTO> openApiReq) {
        Long userId = BaseContextHandler.getAdminId();
        String name = null;
        if (openApiReq.getData() != null) {
            name = openApiReq.getData().getName();
        }
        name = "-1".equals(name) ? null : name;//如果为-1 查询所有数据
        Integer type = openApiReq.getData().getType();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<Application> visibleApps = applicationService.findAppVisibleName(name, type, userId);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(visibleApps, ApplicationResDTO.class)));
    }

    @Override
    @RequestMapping(value = "/countOrgApplication", method = RequestMethod.GET)
    @ApiOperation(value = "统计查单位应用数量", notes = "统计查单位应用数量   查询是否启用的应用 null表示查询所有")
    public Result<List<CountOrgApplicationDTO>> countOrgApplication(Boolean status) {

        List<CountOrgApplicationDO> countOrgApplicationDOs = applicationService.countOrgApplication(status);

        List<CountOrgApplicationDTO> countOrgApplicationDTOs = dozerUtils.mapList(countOrgApplicationDOs, CountOrgApplicationDTO.class);
        return Result.success(countOrgApplicationDTOs);
    }

    @Override
    @RequestMapping(value = "/getAllUseableJryy", method = RequestMethod.GET)
    @AppToken
    @ApiOperation(value = "获取所有的正在使用的接入appid", notes = "获取所有的正在使用的接入appid")
    public Result<List<String>> getAllUseableJryy() {

        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andTypeEqualTo(ApplicationService.JRYY_TYPE_CODE).andStatusEqualTo(Boolean.TRUE);
        List<Application> applications = applicationService.find(example);
        if (CollectionUtils.isEmpty(applications)) {
            return Result.success(Collections.EMPTY_LIST);
        } else {
            List<String> jryyAppids = new ArrayList<>(applications.size());
            for (Application application : applications) {
                jryyAppids.add(application.getAppId());
            }
            return Result.success(jryyAppids);
        }
    }

    /**
     * 描述：运维系统根据appid集合查询应用列表
     * 参数：OpenApiReq<RequestApplicationDTO>
     * 返回值：PageInfo<ResponseApplicationDTO>
     * 修改人：wt
     * 修改时间：2018/7/19
     * 修改内容：
     */
    @RequestMapping(value = "/findByAppIdList", method = RequestMethod.POST)
    @ApiOperation(value = "根据appid集合查询应用列表", notes = "根据appid集合查询应用列表")
    @ApiResponses({
            @ApiResponse(code = 76500, message = "应用/服务appid不能为空"),
    })
    @Override
    public Result<PageInfo<ResponseApplicationDTO>> findByAppIdList(@RequestBody OpenApiReq<RequestApplicationDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(DeveloperExceptionCode.APPLICATION_APPID_NULL, openApiReq.getData());

        List<String> appIdList = openApiReq.getData().getAppIdList();
        String name = openApiReq.getData().getName();
        Short appType = openApiReq.getData().getAppType();
        String type = openApiReq.getData().getType();
        String provider = openApiReq.getData().getProvider();
        Map<String, Object> paramMap = new HashedMap<String, Object>();
        paramMap.put("appIdList", appIdList);
        paramMap.put("name", name);
        if (appType > 0) {
            paramMap.put("appType", appType);
        }
        if (!"-1".equals(type)) {
            paramMap.put("type", type);
        }
        paramMap.put("provider", provider);

        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApplicationDO> list = applicationService.findByAppIdList(paramMap);
        //装载当前应用管理员
        for (ApplicationDO applicationDO : list) {
            User user = userService.findUserManagerByAppId(applicationDO.getAppId());
            if (user != null) {
                applicationDO.setAppManager(user.getName());
                applicationDO.setAppManagerId(user.getId());
            }
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ResponseApplicationDTO.class)));
    }

    /**
     * 根据appid集合查询应用列表
     *
     * @return
     */
    @Override
    @RequestMapping(value = "/findFiveSupport", method = RequestMethod.GET)
    @ApiOperation(value = "根据appid集合查询应用列表", notes = "根据appid集合查询应用列表")
    public Result<Map<String, List<ApplicationFiveSupportResDTO>>> findFiveSupport() {
        //获取用户id
        Long userId = BaseContextHandler.getAdminId();

        //获取管理应用
        List<ApplicationFiveSupportResDTO> list = dozerUtils.mapList(applicationService
                .findAppVisible(null, userId), ApplicationFiveSupportResDTO.class);

        //查询字典application.type的内容
        List<Dictionary> dictionaries = dictionaryService.findByTypeCode(BaseDictionaryType.APPLICATION_TYPE);

        //进行五大类型分类 // hashmap不能排序呀，哥～
        Map<String, List<ApplicationFiveSupportResDTO>> map = new LinkedHashMap<>();
        dictionaries.forEach(obj -> {
            map.put(obj.getName(), (list.stream()
                    .filter(appObj -> appObj.getType() != null && appObj.getType().equals(obj.getCode()))
                    .collect(Collectors.toList())));
        });
        return Result.success(map);
    }

    @Override
    @ApiOperation(value = "获取指定应用的appSecret", notes = "获取指定应用的appSecret 由于安全性问题，在获取的时候会检查登录人是否是应用的管理员")
    @RequestMapping(value = "/getAppSecret", method = RequestMethod.GET)
    public Result<String> getAppSecret(String appId) {

        RoleExample applicationManagerRole = new RoleExample();
        applicationManagerRole.createCriteria().andAppIdEqualTo(appId).andCodeEqualTo(ROLECODE);
        Role role = roleService.getUnique(applicationManagerRole);
        if (role == null) {
            return Result.success(null);
        }

        AssignRoleExample assignRoleExample = new AssignRoleExample();
        Long loginUserId = BaseContextHandler.getAdminId();
        assignRoleExample.createCriteria().andRoleIdEqualTo(role.getId()).andUserIdEqualTo(loginUserId);
        boolean isInRole = assignRoleService.count(assignRoleExample) > 0;

        if (!isInRole) {
            return Result.success(null);
        }

        Application app = applicationService.getMsgByAppId(appId);

        return Result.success(app.getAppSecret());
    }

    @Override
    @ApiOperation(value = "获取应用信息通过应用appId", notes = "获取应用信息通过应用appId")
    @RequestMapping(value = "/getAppInforByAppId", method = RequestMethod.GET)
    @IgnoreToken
    public Result<ApplicationAllDTO> getAppInforByAppId(String appId) {

        //3.数据查询
        Application application = applicationService.getMsgByAppId(appId);

        //4.转换
        ApplicationAllDTO listApp = dozerUtils.map(application, ApplicationAllDTO.class);

        return Result.success(listApp);
    }

    /**
     * 获取应用根路径
     *
     * @param appId
     * @return
     */
    @Override
    @AppToken
    @ApiOperation(value = "获取应用根路径", notes = "获取应用根路径")
    @RequestMapping(value = "/getAppFullRootUrl", method = RequestMethod.GET)
    public Result<String> getAppFullRootUrl(@RequestParam(value = "appId") String appId) {

        Application application = applicationService.getMsgByAppId(appId);
        if (application == null) {
            return Result.success(null);
        }
        String fullRootPath = application.getFullRootPath();
        return Result.success(fullRootPath);
    }

    /**
     * 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
     *
     * @param type
     * @return
     */
    @Override
    @ApiOperation(value = "查询我所管理的所有启用的应用或服务", notes = "查询我所管理的所有启用的应用或服务(1：应用；2：服务)")
    @RequestMapping(value = "/findAppByAdminWithEnable", method = RequestMethod.GET)
    public Result<List<AppShowDto>> findAppByAdminWithEnable(@RequestParam(value = "type", required = false) Long type) {
        //1、获取基础信息
        //type==1:只查应用;type==2:只查服务
        Long userId = BaseContextHandler.getAdminId();

        //2、查询该角色拥有的资源
        List<AppShowDto> appShowDtos = dozerUtils.mapList(applicationService.findAppByAdminWithEnable(userId, type), AppShowDto.class);

        //3、返回
        return Result.success(appShowDtos);
    }

    /**
     * 根据是否平台管理员查询管理应用
     *
     * @param type
     * @return
     */
    @Override
    @ApiOperation(value = "根据是否平台管理员查询管理应用", notes = "根据是否平台管理员查询管理应用(1：应用；2：服务)")
    @RequestMapping(value = "/findAppByPower", method = RequestMethod.GET)
    public Result<List<ApplicationResDTO>> findAppByPower(@RequestParam(value = "type", required = false) Long type) {
        //初始化返回参数
        List<ApplicationResDTO> res = null;
        //判断是否平台管理员
        UserTokenExtInfo token = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        if (token.ptAdminIs()) {
            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andStatusEqualTo(STATUS);
            applicationExample.setOrderByClause(" order_no ");
            res = dozerUtils.mapList(applicationService.find(applicationExample), ApplicationResDTO.class);
        } else {
            res = dozerUtils.mapList(applicationService
                    .findAppByAdminWithEnable(BaseContextHandler.getAdminId(), type), ApplicationResDTO.class);
        }

        return Result.success(res);
    }

    /**
     * 应用列表查询(模糊)
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "应用列表查询(模糊)", notes = "应用列表查询(模糊)")
    @RequestMapping(value = "/findAllLike", method = RequestMethod.POST)
    public Result<List<ApplicationAllDTO>> findAllLike(@RequestBody ApplicationAllReqDTO dto) {
        //2.查询所有应用
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        if (dto.getName() != null) {
            criteria.andNameLike(ApplicationExample.fullLike(dto.getName()));
        }
        if (dto.getOrgName() != null) {
            criteria.andOrgNameLike(ApplicationExample.fullLike(dto.getOrgName()));
        }
        example.setOrderByClause("order_no asc");
        List list = dozerUtils.mapPage(applicationService.find(example), ApplicationAllDTO.class);
        return Result.success(list);
    }

    /**
     * 应用分页列表查询(模糊)
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "应用分页列表查询(模糊)", notes = "应用分页列表查询(模糊)")
    @RequestMapping(value = "/findAllLike/page", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationAllDTO>> PageAllLike(@RequestBody ApplicationAllReqDTO dto) {
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        if (dto.getName() != null) {
            criteria.andNameLike(ApplicationExample.fullLike(dto.getName()));
        }
        if (dto.getOrgName() != null) {
            criteria.andOrgNameLike(ApplicationExample.fullLike(dto.getOrgName()));
        }
        example.setOrderByClause("order_no asc");
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        List<ApplicationAllDTO> list = dozerUtils.mapPage(applicationService.find(example), ApplicationAllDTO.class);
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 根据是否pt管理员查询应用权限
     *
     * @param type
     * @return
     */
    @Override
    @ApiOperation(value = "获取登录用户拥有应用", notes = "获取当前登录用户所用于用户")
    @RequestMapping(value = "/findAppIdListByPt", method = RequestMethod.GET)
    public Result<List<AppShowDto>> findAppIdListByPt(@RequestParam(value = "type", required = false) Long type) {
        //1、获取基础信息
        //type==1:只查应用;type==2:只查服务
        Long userId = BaseContextHandler.getAdminId();

        //2、查询该角色拥有的资源
        List<AppShowDto> appShowDtos;
        UserTokenExtInfo token = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        if (token.ptAdminIs()) {
            ApplicationExample example = new ApplicationExample();
            ApplicationExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(EnableStatus.ENABLE.getVal());
            if (type != null) {
                List<Short> types = new ArrayList<>();
                types.add(Short.valueOf(type.toString()));
                types.add((short) 3);
                criteria.andAppTypeIn(types);
            }
            appShowDtos = dozerUtils.mapList(applicationService.find(example), AppShowDto.class);
        } else {
            appShowDtos = dozerUtils.mapList(applicationService.findAppByAdmin(userId, type), AppShowDto.class);
        }
        //3、返回
        return Result.success(appShowDtos);
    }
}
