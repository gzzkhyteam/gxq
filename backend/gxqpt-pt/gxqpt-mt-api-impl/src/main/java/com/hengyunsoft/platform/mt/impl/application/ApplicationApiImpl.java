package com.hengyunsoft.platform.mt.impl.application;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.application.dto.*;
import com.hengyunsoft.platform.mt.api.component.dto.AppComponentDTO;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.entity.app.po.ApplicationTemp;
import com.hengyunsoft.platform.mt.entity.app.po.EmpApplication;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterface;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterfaceTemp;
import com.hengyunsoft.platform.mt.entity.component.po.AppComponent;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationExample;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationTempExample;
import com.hengyunsoft.platform.mt.repository.app.service.ApplicationService;
import com.hengyunsoft.platform.mt.repository.app.service.ApplicationTempService;
import com.hengyunsoft.platform.mt.repository.app.service.impl.EmpApplicationServiceImpl;
import com.hengyunsoft.platform.mt.repository.component.service.AppCallInterfaceService;
import com.hengyunsoft.platform.mt.repository.component.service.AppCallInterfaceTempService;
import com.hengyunsoft.platform.mt.repository.component.service.AppComponentService;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.application
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：应用管理API
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：新增基础接口
 */
@Api(value = "API - ApplicationApiImpl.java", description = "应用管理API  ")
@RestController
@RequestMapping("appmanager")
@Slf4j
public class ApplicationApiImpl /*implements ApplicationApi*/ {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private AppCallInterfaceService appCallInterfaceService;
    @Autowired
    private EmpApplicationServiceImpl empApplicationService;
    @Autowired
    private AppComponentService appComponentService;
    @Autowired
    private ApplicationTempService applicationTempService;
    @Autowired
    private AppCallInterfaceTempService appCallInterfaceTempService;

    /**
     * 描述：创建
     * 参数：[dto]
     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
     * 修改人：gbl
     * 修改时间：2018/5/28
     * 修改内容：
     */

    @RequestMapping(value = "createAppFirst", method = RequestMethod.POST)
    @ApiOperation(value = "创建应用第一步", notes = "创建应用第一步")
    @ApiResponses({
            @ApiResponse(code = 90000, message = "创建应用第一步提交参数，不能为空"),
            @ApiResponse(code = 90002, message = "应用名称，不能为空"),
            @ApiResponse(code = 90003, message = "应用类型，不能为空"),
            @ApiResponse(code = 90004, message = "应用图标，不能为空"),
            @ApiResponse(code = 90006, message = "应用路径，不能为空"),
            @ApiResponse(code = 90007, message = "应用说明，不能为空"),
            @ApiResponse(code = 90008, message = "是否显示，不能为空"),
            @ApiResponse(code = 90010, message = "应用不存在"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = Application.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<Long> saveCreateAppFirst(@RequestBody CreateAppFirstReqDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_APPNAME, dto.getAppName());
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_APPTYPE, dto.getAppType());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_ICON, dto.getIconPath());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_PATH, dto.getAppPath());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_APPDESC, dto.getAppDesc());
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_ISSHOW, dto.getIsShow());

        ApplicationTemp app = null;
        //id不为空，是在编辑
        if (dto.getId() != null) {
            app = applicationTempService.getById(dto.getId());
            appCallInterfaceTempService.deleteByAppliId(dto.getId());
            if (app == null) {
                return Result.fail(MtExceptionCode.APP_NOT_EXIST);
            }
        }

        app = dozerUtils.map(dto, ApplicationTemp.class);

        Long userID = BaseContextHandler.getAdminId();
        app.setParentId(-1L);//-1表明是应用
        app.setState(2);//处于审核中
        if (dto.getId() != null) {
            app.setUpdateUser(userID);
            applicationTempService.updateByIdSelective(app);

            String unityId = getUnityId(userID);
            EmpApplication empApplication = new EmpApplication();
            empApplication.setApplicationId(app.getId());
            empApplication.setEmpId(unityId);
        } else {
            //根据当前app数量排序，排在最后
            if (dto.getAppOrder() == null) {
                ApplicationTempExample example = new ApplicationTempExample();
                int order = applicationTempService.count(example) + 1;
                app.setAppOrder(order);
            } else {
                app.setAppOrder(dto.getAppOrder());
            }

            app.setCreateUser(userID);
            app.setCreateEmp(getUnityId(userID));
            applicationTempService.saveSelective(app);

//            EmpApplication empApplication = new EmpApplication();
//            empApplication.setEmpId(getUnityId(userID));
//            empApplication.setApplicationId(app.getId());
//            empApplication.setCreateUser(userID);
//            empApplication.setUpdateUser(userID);
//            empApplicationService.saveSelective(empApplication);
        }
        //增加应用关联组件
        List<Long> componentIds = dto.getComponentIds();
        if (!ObjectUtils.isEmpty(componentIds)) {
            for (Long compId : componentIds) {
                AppCallInterfaceTemp appCallInterface = new AppCallInterfaceTemp();
                appCallInterface.setApplicationId(app.getId());
                appCallInterface.setComponentId(compId);
                appCallInterface.setCreateUser(userID);
                appCallInterface.setUpdateUser(userID);
                appCallInterfaceTempService.save(appCallInterface);
            }
        }
        return Result.success(app.getId());
    }

    /**
     * 描述：查询应用列表
     * 参数：[openApiReq]
     * 返回值：com.hengyunsoft.base.Result<com.github.pagehelper.PageInfo<com.hengyunsoft.platform.mt.api.application.dto.ApplicationDTO>>
     * 修改人：gbl
     * 修改时间：2018/5/28
     * 修改内容：
     */

    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ApiOperation(value = "查询应用列表", notes = "查询应用列表")
    @ApiResponses({
            @ApiResponse(code = 90011, message = "查询应用列表参数不能为空"),
    })
    public Result<PageInfo<ApplicationDTO>> getFind(@RequestBody OpenApiReq<QueryApplicationParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.APP_FIND_LIST, openApiReq);

        boolean isPtAdmin = true;
        boolean isFromApp = false;
        Map<String, Object> param = new HashMap<>();

        if (openApiReq.getData() != null) {
            param.put("appName", openApiReq.getData().getAppName());
            param.put("startCreateTime", openApiReq.getData().getStartCreateTime());
            param.put("endCreateTime", openApiReq.getData().getEndCreateTime());

            if (openApiReq.getData().getFromApp() != null && openApiReq.getData().getFromApp()) {//app端 要 设置显示的并且审核通过的
                param.put("isShow", 2);
                param.put("status", 3);
                isFromApp = true;
            }
        }
        //平台管理员查询索引，非平台管理员查询自己创建的,并且只有平台管理员才能审核
        if (!isPtAdmin) {
            Long userId = BaseContextHandler.getAdminId();
            param.put("createUser", userId);
        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApplicationDTO> list;
        if (isFromApp) {
            list = dozerUtils.mapPage(applicationService.findAppList(param), ApplicationDTO.class);
        } else {
            list = dozerUtils.mapPage(applicationTempService.findAppList(param), ApplicationDTO.class);
        }
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 描述：查找所有的应用
     * 参数：
     * 返回值：返回应用的id和名称
     * 修改人：gbl
     * 修改时间：2018/7/11
     * 修改内容：
     */

    @RequestMapping(value = "findAllApp", method = RequestMethod.POST)
    @ApiOperation(value = "查找所有的应用", notes = "查找所有的应用")
    public Result<List<AppIdAndNameDTO>> getFindAllApp() {
        ApplicationTempExample example = new ApplicationTempExample();
        ApplicationTempExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdLessThan(0L);
        criteria.andIsShowEqualTo(2);
        criteria.andStateEqualTo(3);
        example.setOrderByClause("app_order asc");
        List<ApplicationTemp> functions = applicationTempService.find(example);
        List<AppIdAndNameDTO> list = dozerUtils.mapList(functions, AppIdAndNameDTO.class);

        //加上app本身  id为-1，名称是其他
        AppIdAndNameDTO app = new AppIdAndNameDTO();
        app.setId(-1L);
        app.setAppName("其他");
        list.add(app);
        return Result.success(list);
    }

    /**
     * 描述：根据id查询应用详情
     * 参数：[id]
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.mt.api.application.dto.ApplicationDTO>
     * 修改人：gbl
     * 修改时间：2018/5/28
     * 修改内容：
     */

    @RequestMapping(value = "getAppBaseInfo", method = RequestMethod.POST)
    @ApiOperation(value = "根据id查询应用详情", notes = "根据id查询应用详情")
    @ApiResponses({
            @ApiResponse(code = 90001, message = "应用id，不能为空"),
            @ApiResponse(code = 90010, message = "应用不存在"),
    })
    public Result<AppInfoDTO> getAppBaseInfo(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_ID, id);
        AppInfoDTO res = new AppInfoDTO();

        ApplicationTemp auditApp = applicationTempService.getById(id);
        if (auditApp == null) {
            return Result.fail(MtExceptionCode.APP_NOT_EXIST);
        }
        Application currentApp = applicationService.getById(id);
        if (currentApp != null) {
            ApplicationDTO currentAppDTO = dozerUtils.map(currentApp, ApplicationDTO.class);
            res.setCurrent(currentAppDTO);

            List<AppComponent> appComponents = appComponentService.findByApplicationId(id);
            List<AppComponentDTO> componentDTOS = dozerUtils.mapList(appComponents, AppComponentDTO.class);
            currentAppDTO.setComponentList(componentDTOS);
        }
        ApplicationDTO auditAppDTO = dozerUtils.map(auditApp, ApplicationDTO.class);
        res.setAudit(auditAppDTO);
        List<AppComponent> appComponents = appComponentService.findByApplicationIdTemp(id);
        List<AppComponentDTO> componentDTOS = dozerUtils.mapList(appComponents, AppComponentDTO.class);
        auditAppDTO.setComponentList(componentDTOS);

        return Result.success(res);
    }


    /**
     * 描述：审核应用
     * 参数：[dto]
     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
     * 修改人：gbl
     * 修改时间：2018/5/28
     * 修改内容：
     */

    @RequestMapping(value = "auditApp", method = RequestMethod.POST)
    @ApiOperation(value = "审核应用", notes = "审核应用")
    @ApiResponses({
            @ApiResponse(code = 90012, message = "审核应用请求参数，不能为空"),
            @ApiResponse(code = 90013, message = "应用id，不能为空"),
            @ApiResponse(code = 90014, message = "审核状态(2通过,3驳回)，不能为空"),
            @ApiResponse(code = 90015, message = "审批内容，不能为空"),
            @ApiResponse(code = 90010, message = "应用不存在"),
            @ApiResponse(code = 90016, message = "你没有审核应用权限"),
    })
    public Result<Boolean> saveAuditApp(@RequestBody AuditAppReqDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.AUDITAPP_AUDITAPPREQDTO, dto);
        BizAssert.assertNotNull(MtExceptionCode.AUDITAPP_AUDITAPPREQDTO_ID, dto.getId());
        BizAssert.assertNotNull(MtExceptionCode.AUDITAPP_AUDITAPPREQDTO_STATE, dto.getState());
        BizAssert.assertNotEmpty(MtExceptionCode.AUDITAPP_AUDITAPPREQDTO_AUDITCONTENT, dto.getAuditContent());

        ApplicationTemp app = applicationTempService.getById(dto.getId());
        if (app == null) {
            return Result.fail(MtExceptionCode.APP_NOT_EXIST);
        }
        Long userID = BaseContextHandler.getAdminId();
        app.setState(dto.getState());
        app.setAuditContent(dto.getAuditContent());
        app.setAuditUser(userID);
        app.setAuditTime(new Date());
        app.setUpdateUser(userID);
        applicationTempService.updateByIdSelective(app);
        //通过临时表的数据覆盖正式表
        if (dto.getState() == 3) {
            Application oldApp = applicationService.getById(app.getId());
            Application current = dozerUtils.map(app, Application.class);
            if (oldApp == null) {
                applicationService.insertApp(current);
            } else {
                applicationService.updateByIdSelective(current);
            }

            //先删除一起的组件在保存现在的组件
            appCallInterfaceService.deleteByAppliId(app.getId());
            List<AppComponent> appComponents = appComponentService.findByApplicationIdTemp(app.getId());
            appComponents.forEach(ac -> {
                AppCallInterface ai = new AppCallInterface();
                ai.setApplicationId(app.getId());
                ai.setComponentId(ac.getId());
                appCallInterfaceService.saveSelective(ai);
            });
        }

        return Result.success(true);
    }

    /**
     * 描述：
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/14
     * 修改内容：
     */

    @RequestMapping(value = "createFunction", method = RequestMethod.POST)
    @ApiOperation(value = "创建功能", notes = "创建功能")
    @ApiResponses({
            @ApiResponse(code = 90020, message = "创建功能请求参数，不能为空"),
            //@ApiResponse(code = 90021,message = "功能id,编辑有id，新增无id，不能为空"),
            @ApiResponse(code = 90022, message = "功能名称，不能为空"),
            @ApiResponse(code = 90023, message = "功能的父id，不能为空"),
            @ApiResponse(code = 90024, message = "显示该功能的名称和提示的数量数据的接口，不能为空"),
            @ApiResponse(code = 90025, message = "功能路径，不能为空"),
            @ApiResponse(code = 90026, message = "功能说明，不能为空"),
            @ApiResponse(code = 90027, message = "是否显示(1:不显示 ,2:显示)，不能为空"),
    })
    public Result<Boolean> saveFunction(@RequestBody CreateFunctionReqDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_APPNAME, dto.getAppName());
        BizAssert.assertNotNull(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_PARENTID, dto.getParentId());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_SHOWURL, dto.getShowUrl());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_APPPATH, dto.getAppPath());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_APPDESC, dto.getAppDesc());
        BizAssert.assertNotNull(MtExceptionCode.CREATEFUNCTION_CREATEFUNCTIONREQDTO_ISSHOW, dto.getIsShow());

        ApplicationTemp parent = applicationTempService.getById(dto.getParentId());
        if (parent == null) {
            return Result.fail(MtExceptionCode.APP_NOT_EXIST);
        }
        if (parent.getState() != 3) {
            return Result.fail("只有审核通过的应用才能增加功能");
        }

        ApplicationTemp app = null;
        //id不为空，是在编辑
        if (dto.getId() != null) {
            app = applicationTempService.getById(dto.getId());
            if (app == null) {
                return Result.fail(MtExceptionCode.APP_NOT_EXIST);
            }
        }

        app = dozerUtils.map(dto, ApplicationTemp.class);
        Long userID = BaseContextHandler.getAdminId();
        if (dto.getId() != null) {
            app.setUpdateUser(userID);
            applicationService.updateByIdSelective(dozerUtils.map(app, Application.class));
            applicationTempService.updateByIdSelective(app);
        } else {
            //根据当前app数量排序，排在最后
            ApplicationExample example = new ApplicationExample();
            int order = applicationService.count(example) + 1;
            app.setAppOrder(order);
            app.setCreateUser(userID);
            app.setCreateEmp(getUnityId(userID));
            applicationTempService.saveSelective(app);
            applicationService.saveSelective(dozerUtils.map(app, Application.class));
        }
        return Result.success(true);
    }

    /**
     * 描述：根据指定应用下的功能列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/14
     * 修改内容：
     */

    @RequestMapping(value = "findFunctionListByAppId", method = RequestMethod.POST)
    @ApiOperation(value = "根据指定应用下的功能列表", notes = "根据指定应用下的功能列表")
    @ApiResponses({
            @ApiResponse(code = 90001, message = "应用id，不能为空"),
    })
    public Result<List<FunctionDTO>> getFunctionListByAppId(@RequestParam("appId") Long appId) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_ID, appId);
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(appId);

        List<Application> functions = applicationService.find(example);
        List<FunctionDTO> res = dozerUtils.mapList(functions, FunctionDTO.class);
        return Result.success(res);
    }

    /**
     * 描述：查询所有的功能列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/14
     * 修改内容：
     */

    @RequestMapping(value = "findAllFunctionList", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有的功能列表", notes = "查询所有的功能列表")
    public Result<List<FunctionDTO>> getAllFunctionList() {
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(null);
        list.add(2);
        criteria.andParentIdGreaterThan(0L).andIsShowIn(list);
        List<Application> functions = applicationService.find(example);
        List<FunctionDTO> res = dozerUtils.mapList(functions, FunctionDTO.class);
        return Result.success(res);
    }

    /**
     * 描述：查询功能详情
     * 参数：功能id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/14
     * 修改内容：
     */

    @RequestMapping(value = "getFunctionInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询功能详情", notes = "查询功能详情")
    @ApiResponses({
            @ApiResponse(code = 90001, message = "应用id，不能为空"),
            @ApiResponse(code = 90010, message = "应用不存在"),
    })
    public Result<FunctionDTO> getFunctionInfo(@RequestParam("funcId") Long funcId) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPP_CREATEAPPFIRSTREQDTO_ID, funcId);

        Application app = applicationService.getById(funcId);
        if (app == null) {
            return Result.fail(MtExceptionCode.APP_NOT_EXIST);
        }
        FunctionDTO res = dozerUtils.map(app, FunctionDTO.class);
        return Result.success(res);
    }

    /**
     * 得到单位id
     *
     * @param userId
     * @return
     */
    public String getUnityId(Long userId) {
//        Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(userId);
//        return orgDeptDutyInfo.getData().getOrgId();
        return UnityUtil.getUnityId(userId);
    }
}
