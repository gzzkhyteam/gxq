package com.hengyunsoft.platform.developer.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.AssignModuleApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsumAssignModuleInfo;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsummerAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ServiceAssignModuleDO;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceAssignModuleExample;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleService;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 描述:消费模块实现类
 * @author chb
 * @date 2018/4/2 11:05
 * @return
 */
@Api(value = "API - AssignModuleImpl", description = "消费模块实现类")
@RestController
@RequestMapping("assignModule")
@Slf4j
public class AssignModuleImpl implements AssignModuleApi {

    @Autowired
    private ServiceAssignModuleService serviceAssignModuleService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ServiceModuleService serviceModuleService;

    /**
     *DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    /**
     *新建模块信息
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "新建模块信息", notes = "新建模块信息")
    @ApiResponses({
            @ApiResponse(code = 75005, message = "模块数据不能为空"),
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用不能为空"),
    })
    public Result<AssignModuleRetDTO> save(@RequestBody AssignModuleSaveDTO assignModuleSaveDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY,assignModuleSaveDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_ID,String.valueOf(assignModuleSaveDTO.getModuleId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,String.valueOf(assignModuleSaveDTO.getAppId()));
        //2.数据处理
        ServiceAssignModule assignModule = dozerUtils.map(assignModuleSaveDTO,ServiceAssignModule.class);
        assignModule.setCreateUser(BaseContextHandler.getAdminId());
        assignModule.setUpdateUser(BaseContextHandler.getAdminId());
        assignModule.setUpdateTime(new Date());
        assignModule.setCreateTime(new Date());

        //3.保存数据
        ServiceAssignModule result = serviceAssignModuleService.save(assignModule);
        return Result.success(dozerUtils.map(result,AssignModuleRetDTO.class));
    }

    /**
     *根据id获删除块信息
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获删除块信息", notes = "根据id获删除块信息")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<Boolean> deleteById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(id));
        //2.查询数据
        int result =  serviceAssignModuleService.deleteById(Long.valueOf(id));
        if(result>0){
            return Result.success(Boolean.TRUE);
        }
        return Result.fail("无此记录");
    }

    /**
     *根据id修改模块信息
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改模块信息", notes = "根据id修改模块信息")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
            @ApiResponse(code = 75005, message = "模块数据不能为空"),
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用不能为空"),
    })
    public Result<AssignModuleRetDTO> updateById(@RequestBody AssignModuleUpdateDTO assignModuleUpdateDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY,assignModuleUpdateDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(assignModuleUpdateDTO.getId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_ID,String.valueOf(assignModuleUpdateDTO.getModuleId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,String.valueOf(assignModuleUpdateDTO.getAppId()));

        //2.数据处理
        ServiceAssignModule assignModule = dozerUtils.map(assignModuleUpdateDTO,ServiceAssignModule.class);
        assignModule.setUpdateUser(BaseContextHandler.getAdminId());
        assignModule.setUpdateTime(new Date());

        //3.保存数据
        int result =  serviceAssignModuleService.updateByIdSelective(assignModule);
        AssignModuleRetDTO retDTO = dozerUtils.map(assignModuleUpdateDTO,AssignModuleRetDTO.class);
        if(result>0){
            return Result.success(retDTO);
        }
        return Result.fail("修改失败！");
    }

    /**
     * 根据id获取模块信息
     * 2018-5-25根据ID查询功能详情,申请功能时填写的页面字段及值,禅道BUG号2930
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取模块信息", notes = "根据id获取模块信息")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<QueryConsumAssignModuleInfoDTO> getById(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(id));
        //2.查询数据
        /*QueryConsummerAssignModule doc =  serviceAssignModuleService.findMoudleById(id);
        AssignServiceModuleRetDTO retDTO = dozerUtils.map(doc,AssignServiceModuleRetDTO.class);*/

        QueryConsumAssignModuleInfo doc =  serviceAssignModuleService.findApplyMoudleInfoById(id);

        if(doc == null){
            return Result.success(null);
        }

        QueryConsumAssignModuleInfoDTO retDTO = dozerUtils.map(doc,QueryConsumAssignModuleInfoDTO.class);
        if(doc.getAdviceModule()!=null&&!doc.getAdviceModule().equals(doc.getId())){
            ServiceModule sm = serviceModuleService.getById(doc.getAdviceModule());
            log.info("根据id[{}]查询我的功能建议模块",doc.getAdviceModule());
            if(sm!=null){
                retDTO.setAdviceModuleName(sm.getName());
            }
        }
        return Result.success(retDTO);
    }

    /**
     *查看我某个应用所消费的所有功能
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "/pageMy", method = RequestMethod.POST)
    @ApiOperation(value = "查看我某个应用所消费的所有功能", notes = "查看我某个应用所消费的所有功能")
    @ApiResponses({
            @ApiResponse(code = 75008, message = "APPID不能为空"),
    })
    public Result<PageInfo<AssignServiceModuleRetDTO>> pageMy(@RequestBody OpenApiReq<AssignModuleQueryMyDTO> req) {
        //1.校验
        AssignModuleQueryMyDTO date = req.getData();
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,String.valueOf(date.getAppId()));
        //1.数据处理
        QueryConsummerAssignModule assignModule = new QueryConsummerAssignModule();
        assignModule.setAppId(date.getAppId());
        assignModule.setAssignStatus(AssignModuleApplyConstant.ENABLE);
        assignModule.setModuleType(date.getModuleType());
        //2.查询
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        List<QueryConsummerAssignModule> list = serviceAssignModuleService.pageMy(assignModule);
        List<AssignServiceModuleRetDTO>  rlist = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);
        return Result.success(new PageInfo<>(rlist));
    }

    /**
     *查看所有消费的功能
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation(value = "查看所有消费的功能", notes = "查看所有消费的功能")
    public Result<PageInfo<AssignServiceModuleRetDTO>> page(@RequestBody OpenApiReq<AssignModuleQueryMYAppDTO> req) {
        AssignModuleQueryMYAppDTO date = req.getData();
        List<ApplicationDO> applist = applicationService.findAppByAdmin(BaseContextHandler.getAdminId(), null);
        //1.数据处理
        QueryConsummerAssignModule assignModule = new QueryConsummerAssignModule();
        assignModule.setAssignStatus(AssignModuleApplyConstant.ENABLE);
        if(date.getStatus() !=null && date.getStatus()){
            assignModule.setAssignStatus(AssignModuleApplyConstant.ENABLE);
        }else{
            assignModule.setAssignStatus(date.getStatus());
        }
        assignModule.setModuleType(date.getModuleType());
        //2.查询
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        List<QueryConsummerAssignModule> list = serviceAssignModuleService.page(assignModule,applist);

        List<AssignServiceModuleRetDTO>  rlist = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);
        return Result.success(new PageInfo<>(rlist));
    }

    /**
     * 2018-4-11查看所有消费的功能 无分页
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "/nopage", method = RequestMethod.GET)
    @ApiOperation(value = "查看所有消费的功能 无分页", notes = "查看所有消费的功能 无分页")
    public Result<List<AssignModuleNopageRetDTO>> findNoPage(@RequestParam(value = "moduleType",required = false) String moduleType, @RequestParam(value = "status",required = false)Boolean status) {
        List<ApplicationDO> applist = applicationService.findAppByAdmin(BaseContextHandler.getAdminId(), null);
        //1.数据处理
        QueryConsummerAssignModule assignModule = new QueryConsummerAssignModule();
        assignModule.setAssignStatus(AssignModuleApplyConstant.ENABLE);
        if(status!=null){
            if(status){
                assignModule.setAssignStatus(AssignModuleApplyConstant.ENABLE);
            }else{
                assignModule.setAssignStatus(AssignModuleApplyConstant.DISABLE);
            }
        }
        if(moduleType!=null && !"".equals(moduleType)){
            assignModule.setModuleType(moduleType);
        }
        //2.查询
        List<QueryConsummerAssignModule> list = serviceAssignModuleService.findNoPage(assignModule,applist);

        List<AssignModuleNopageRetDTO>  rlist = dozerUtils.mapList(list,AssignModuleNopageRetDTO.class);
        return Result.success(rlist);
    }

    /**
     * 查看功能列表（应用不限，所有应用。）
     * @param req
     * @return
     */
    @Override
    @RequestMapping(value = "/findAllMoudles", method = RequestMethod.POST)
    @ApiOperation(value = "查看功能列表（应用不限，所有应用。），可根据moduleTypee,status,name(模糊)，进行查询",
            notes = "查看功能列表（应用不限，所有应用。），可根据moduleTypee,status,name(模糊)，进行查询")
    @AppToken
    public Result<PageInfo<AssignServiceModuleRetDTO>> findAllMoudles(@RequestBody OpenApiReq<AssignModuleQueryMoudlesDTO> req) {

        //1.数据处理
        AssignModuleQueryMoudlesDTO date = req.getData();
        PageHelper.startPage(req.getPageNo(), req.getPageSize());

        ServiceModuleExample moduleExample = new ServiceModuleExample();
        moduleExample.createCriteria().andCodeEqualTo(date.getCode()).andStatusEqualTo(date.getStatus())
                .andNameLike(ServiceModuleExample.fullLike(date.getName())).andModuleTypeEqualTo(date.getModuleType());
        //2.查询
        List<ServiceModule> list = serviceModuleService.find(moduleExample);
        List<AssignServiceModuleRetDTO> retDTOList = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);
        return Result.success(new PageInfo<>(retDTOList));
    }

    /**
     * 查看功能列表 无分页（应用不限，所有应用。）
     * @param req
     * @return
     */
    @Override
    @RequestMapping(value = "/findAllMoudlesNoPage", method = RequestMethod.GET)
    @ApiOperation(value = "查看功能列表，无分页（应用不限，所有应用。），可根据moduleTypee,status,name(模糊)，进行查询",
            notes = "查看功能列表，无分页（应用不限，所有应用。），可根据moduleTypee,status,name(模糊)，进行查询")
    @AppToken
    public Result<List<AssignServiceModuleRetDTO>> findAllMoudlesNoPage(AssignModuleQueryMoudlesDTO req) {
        //1.数据处理
        /*ServiceModuleExample moduleExample = new ServiceModuleExample();
        moduleExample.createCriteria().andCodeEqualTo(req.getCode()).andStatusEqualTo(req.getStatus())
                .andNameLike(ServiceModuleExample.fullLike(req.getName())).andModuleTypeEqualTo(req.getModuleType());
        //2.查询
        List<ServiceModule> list = serviceModuleService.find(moduleExample);
        List<AssignServiceModuleRetDTO> retDTOList = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);*/

        //2018-5-30增加返回模块类型名称
        ServiceModule serviceModule = new ServiceModule();
        serviceModule.setCode(req.getCode());
        serviceModule.setStatus(req.getStatus());
        serviceModule.setName(req.getName());
        serviceModule.setModuleType(req.getModuleType());
        
        boolean isLogin = BaseContextHandler.getAdminId() != null;
        
        List<ServiceModule> list = serviceModuleService.findAllServiceModule(serviceModule,isLogin);
        List<AssignServiceModuleRetDTO> retDTOList = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);
        return Result.success(retDTOList);
    }

    /**
     * 查看功能列表（应用不限，所有应用。）
     * @param req
     * @return
     */
    @Override
    @RequestMapping(value = "/findNoLoginMoudles", method = RequestMethod.POST)
    @ApiOperation(value = "在未登陆下查看所有的功能列表（有些功能不允许登陆查看），可根据moduleTypee,status,name(模糊)，进行查询",
            notes = "在未登陆下查看所有的功能列表（有些功能不允许登陆查看），可根据moduleTypee,status,name(模糊)，进行查询")
    @AppToken
    public Result<PageInfo<AssignServiceModuleRetDTO>> findNoLoginMoudles(@RequestBody OpenApiReq<AssignModuleQueryMoudlesDTO> req) {
        //1.数据处理
        AssignModuleQueryMoudlesDTO date = req.getData();
        PageHelper.startPage(req.getPageNo(), req.getPageSize());

        ServiceModuleExample moduleExample = new ServiceModuleExample();
        moduleExample.createCriteria().andCodeEqualTo(date.getCode()).andStatusEqualTo(date.getStatus())
                //公开模块
                .andPublicLookEqualTo(AssignModuleApplyConstant.ENABLE)
                .andNameLike(ServiceModuleExample.fullLike(date.getName())).andModuleTypeEqualTo(date.getModuleType());
        //2.查询
        List<ServiceModule> list = serviceModuleService.find(moduleExample);
        List<AssignServiceModuleRetDTO> retDTOList = dozerUtils.mapList(list,AssignServiceModuleRetDTO.class);
        return Result.success(new PageInfo<>(retDTOList));
    }

    /**
     * 查询热门功能,默认显示8个，eg:top=10查询10个
     * @param top
     * @return
     */
    @Override
    @RequestMapping(value = "/assignModule/hotModule", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "top", value = "查询最热门返回个数", dataType = "int", paramType = "query"),
    })
    @ApiOperation(value = "查询热门功能,默认显示8个，eg:top=10查询10个",
            notes = "查询热门功能,默认显示8个，eg:top=10查询10个")
    @AppToken
    public Result<List<ServiceModuleDTO>> hotModule(@RequestParam(value = "top",required = false) Integer top) {
        if(top==null){
            top = 8;
        }
        
        boolean isLogin = BaseContextHandler.getAdminId() != null;
        
        List<ServiceModule> list = serviceModuleService.hotModule(top,isLogin);
        List<ServiceModuleDTO> retDTOList = dozerUtils.mapList(list,ServiceModuleDTO.class);
        return Result.success(retDTOList);
    }

    /**
     * 分页查询我的模块消费列表
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询我的模块消费列表", notes = "分页查询我的模块消费列表")
    @ApiResponses({
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
    })
    @RequestMapping(value = "/module/consume/page", method = RequestMethod.POST)
    public Result<PageInfo<ServiceAssignModuleDTO>> moduleConsumePage(@RequestBody OpenApiReq<Long> openApiReq) {

        //1.校验
        Long moduleId = openApiReq.getData();
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_ID, moduleId);

        //2.查询并返回
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServiceAssignModuleDO> doList = serviceAssignModuleService.moduleConsumePage(moduleId);
        List<ServiceAssignModuleDTO> list = dozerUtils.mapList(doList,ServiceAssignModuleDTO.class);
        return Result.success(new PageInfo<>(dozerUtils.mapList(list,ServiceAssignModuleDTO.class)));
    }
}