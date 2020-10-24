package com.hengyunsoft.platform.developer.impl.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.msg.BriefTpye;
import com.hengyunsoft.commons.msg.DeveloperBizType;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.developer.api.service.api.AssignModuleApplyApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.repository.apply.example.ServiceAssignModuleApplyExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleApplyService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 描述:模块申请实现类
 * @author chb
 * @date 2018/4/2 11:05
 * @return
 */
@Api(value = "API - AssignModuleApplyImpl", description = "模块申请实现类")
@RestController
@RequestMapping("assignModuleApply")
@Slf4j
public class AssignModuleApplyImpl implements AssignModuleApplyApi {
    /**
     *DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private ServiceAssignModuleApplyService assignModuleApplyService;

    @Autowired
    private ServiceModuleService serviceModuleService;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    
    /**
     * 描述:新增模块申请
     * @param AssignModuleApplySaveDTO
     * @return
     */
    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "新增模块申请", notes = "新增模块申请")
    @ApiResponses({
            @ApiResponse(code = 75005, message = "模块数据不能为空"),
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用ID不能为空"),
            @ApiResponse(code = 75009, message = "申请描述不能为空"),
    })
    public Result<AssignModuleApplyUpdateDTO> save(@RequestBody AssignModuleApplySaveDTO assignModuleApplySaveDTO){
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY,assignModuleApplySaveDTO);
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_ID,assignModuleApplySaveDTO.getModuleId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,assignModuleApplySaveDTO.getAppId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_DESC,assignModuleApplySaveDTO.getApplyDesc());
        //2.数据处理
        ServiceAssignModuleApply assignModuleApply = dozerUtils.map(assignModuleApplySaveDTO,ServiceAssignModuleApply.class);
        assignModuleApply.setCreateUser(BaseContextHandler.getAdminId());
        assignModuleApply.setUpdateUser(BaseContextHandler.getAdminId());
        assignModuleApply.setUpdateTime(new Date());
        assignModuleApply.setCreateTime(new Date());
        //申请人
        assignModuleApply.setApplyUser(BaseContextHandler.getAdminId());
        assignModuleApply.setApplyUserName(BaseContextHandler.getName());
        assignModuleApply.setStatus(AssignModuleApplyConstant.STATUS_PROCESS);
        //3.保存数据
        ServiceAssignModuleApply result = assignModuleApplyService.save(assignModuleApply);
        ServiceModule module = serviceModuleService.getById(assignModuleApply.getModuleId());
        
        msgQueueProducer.saveHandlerMsgToRole(builderBbsAllMainMsgDTO(module,assignModuleApply), RoleService.application_admin_code, module.getAppId());
        return Result.success(dozerUtils.map(result,AssignModuleApplyUpdateDTO.class));
    }
    
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ServiceModule module, ServiceAssignModuleApply assignModuleApply) {
    	
    	BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
    	
    	bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
    	bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
    	bbsAllMainMsgDTO.setBizId(assignModuleApply.getId().toString());
    	bbsAllMainMsgDTO.setBizType(DeveloperBizType.INVOKE_MODULE_AUDIT);
    	bbsAllMainMsgDTO.setBriefTpye(BriefTpye.WORK_AUDIT);
    
    	bbsAllMainMsgDTO.setContent(assignModuleApply.getApplyUserName() + "申请调用"+module.getName()+"功能待审批");
    	bbsAllMainMsgDTO.setTitle("申请调用"+module.getName());
    	
    	bbsAllMainMsgDTO.setDetailedType("invoke_module");
    	bbsAllMainMsgDTO.setDetailedTypeDesc("调用申请");
    	bbsAllMainMsgDTO.setHandlerNeedIs(true);
    	bbsAllMainMsgDTO.setSingleHandleIs(false);
    	bbsAllMainMsgDTO.setClientFlag("gxqpt");
    	bbsAllMainMsgDTO.setHandlerUrl("/module/myTaskList");
    	bbsAllMainMsgDTO.setHandlerParams("moduleName="+module.getName());
    	bbsAllMainMsgDTO.setSenderName("系统自动通知");
		return bbsAllMainMsgDTO;
	}

    /**
     * 根据id获取模块申请信息
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取模块申请信息", notes = "根据id获取模块申请信息")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<AssignModuleApplyRetDTO> getById(@RequestParam(value="id")String id){
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,id);
        //2.查询数据
        ServiceAssignModuleApply doc =  assignModuleApplyService.getById(Long.valueOf(id));
        AssignModuleApplyRetDTO retDTO = dozerUtils.map(doc,AssignModuleApplyRetDTO.class);
        return Result.success(retDTO);
    }

    /**
     * 根据id删除模块申请信息
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    @ApiOperation(value = "删除模块", notes = "删除模块")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<String> deleteById(@RequestParam(value="id")String id){
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,id);
        //2.查询数据
        int result =  assignModuleApplyService.deleteById(Long.valueOf(id));
        if(result>0){
            return Result.success("删除成功！");
        }
        return Result.fail("删除失败！");
    }

    /**
     * 根据id修改模块申请信息
     * @param assignModuleApplyUpdateDTO
     * @return
     */
    @Override
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改模块申请信息", notes = "根据id修改模块申请信息")
    @ApiResponses({
            @ApiResponse(code = 75005, message = "模块数据不能为空"),
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用ID不能为空"),
            @ApiResponse(code = 75009, message = "申请描述不能为空"),
    })
    public Result<AssignModuleApplyUpdateDTO> updateById(@RequestBody AssignModuleApplyUpdateDTO assignModuleApplyUpdateDTO){
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY,assignModuleApplyUpdateDTO);
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_ID,assignModuleApplyUpdateDTO.getModuleId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,assignModuleApplyUpdateDTO.getAppId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_DESC,assignModuleApplyUpdateDTO.getApplyDesc());

        //2.数据处理
        ServiceAssignModuleApply assignModuleApply = dozerUtils.map(assignModuleApplyUpdateDTO,ServiceAssignModuleApply.class);
        assignModuleApply.setUpdateUser(BaseContextHandler.getAdminId());
        assignModuleApply.setUpdateTime(new Date());

        //3.保存数据
        int result =  assignModuleApplyService.updateByIdSelective(assignModuleApply);

        if(result>0){
            return Result.success(assignModuleApplyUpdateDTO);
        }
        return Result.fail("修改失败！");
    }


    /*
     * 获取模块个人申请分页数据
     * @param req
     * @return
     */
    /*@Override
    @RequestMapping(value = "/pageMyApply", method = RequestMethod.POST)
    @ApiOperation(value = "获取模块个人申请分页数据(弃用！)", notes = "获取模块个人申请分页数据(弃用！)")
    @ApiResponses({
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用ID不能为空"),
            @ApiResponse(code = 75011, message = "审批状态不能为空"),
    })
    public Result<PageInfo<AssignModuleApplyRetDTO>> pageMyApply(@RequestBody OpenApiReq<AssignModuleApplyQueryDTO> req){
        AssignModuleApplyQueryDTO assignModuleApplyQueryDTO = req.getData();
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_ID,assignModuleApplyQueryDTO.getModuleId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,assignModuleApplyQueryDTO.getAppId());
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPR_STATUS,assignModuleApplyQueryDTO.getStatus());

        //2.数据处理
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        //3.查询
        ServiceAssignModuleApply apply = new ServiceAssignModuleApply();
        apply.setAppId(assignModuleApplyQueryDTO.getAppId());
        apply.setModuleId(assignModuleApplyQueryDTO.getModuleId());
        apply.setStatus(assignModuleApplyQueryDTO.getStatus());
        apply.setApplyUser(BaseContextHandler.getAdminId());
        apply.setApplyUserName(assignModuleApplyQueryDTO.getAuditUserName());
        List<ServiceAssignModuleApply> list = assignModuleApplyService.findMyApply(apply);

        List<AssignModuleApplyRetDTO> retList = dozerUtils.mapList(list,AssignModuleApplyRetDTO.class);
        return Result.success((new PageInfo<>(retList)));
    }
*/
    /*
     * 获取模块个人审批分页数据
     * @param req
     * @return
     */
    /*@Override
    @RequestMapping(value = "/pageMyAudit", method = RequestMethod.POST)
    @ApiOperation(value = "获取模块个人审批分页数据(弃用！)", notes = "获取模块个人审批分页数据(弃用！)")
    @ApiResponses({
            @ApiResponse(code = 75007, message = "模块ID不能为空"),
            @ApiResponse(code = 75008, message = "应用ID不能为空"),
    })
    public Result<PageInfo<AssignModuleApplyRetDTO>> pageMyAudit(OpenApiReq<AssignModuleApplyQueryDTO> req) {
            AssignModuleApplyQueryDTO assignModuleApplyQueryDTO = req.getData();
            //1.校验
            BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_ID,assignModuleApplyQueryDTO.getModuleId());
            BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APP_ID,assignModuleApplyQueryDTO.getAppId());

            //2.数据处理
            ServiceAssignModuleApplyExample example = new ServiceAssignModuleApplyExample();
            example.createCriteria().andModuleIdEqualTo(assignModuleApplyQueryDTO.getModuleId())
                    .andAppIdEqualTo(assignModuleApplyQueryDTO.getAppId())
                    .andStatusEqualTo(assignModuleApplyQueryDTO.getStatus())
                    .andAuditUserEqualTo(BaseContextHandler.getAdminId())
                    .andApplyUserNameLike( ServiceAssignModuleApplyExample.fullLike(assignModuleApplyQueryDTO.getApplyUserName()));
            PageHelper.startPage(req.getPageNo(), req.getPageSize());

            //3.查询
            List<ServiceAssignModuleApply> list = assignModuleApplyService.find(example);

            List<AssignModuleApplyRetDTO> retList = dozerUtils.mapList(list,AssignModuleApplyRetDTO.class);
            return Result.success((new PageInfo<>(retList)));
        }*/
    /*
     * 提交审批
     * @param id
     * @return
     */
   /* @Override
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @ApiOperation(value = "提交审批(弃用！)", notes = "提交审批(弃用！)")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<String> updateSubmitStatus( @RequestParam (value = "id")Long id,
                                              @RequestParam (value = "moduleId")Long moduleId,
                                              @RequestParam (value = "appId")String appId) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(id));
        //2.数据处理
        ServiceAssignModuleApply apply = new ServiceAssignModuleApply();
        apply.setId(id);
        apply.setStatus(AssignModuleApplyConstant.STATUS_PROCESS);
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(BaseContextHandler.getAdminId());
        //3.判断

        ServiceModuleExample sExample = new ServiceModuleExample();
        sExample.createCriteria().andIdEqualTo(moduleId);
        ServiceModule module = serviceModuleService.getUnique(sExample);
        //公有模块 所有人可调用(无需申请)
        if(module !=null && module.getPublicIs()){
            return Result.success("公有模块 所有人可调用(无需申请)！");
        }

        ServiceAssignModuleApplyExample example = new ServiceAssignModuleApplyExample();
        example.createCriteria().andStatusNotEqualTo(AssignModuleApplyConstant.STATUS_PROCESS)
                .andAppIdEqualTo(appId).andModuleIdEqualTo(moduleId);
        List<ServiceAssignModuleApply> list = assignModuleApplyService.find(example);
        if(list !=null && list.size()>0){
            return Result.fail("请勿重复申请！");
        }
        //4.保存
        int result = assignModuleApplyService.updateByIdSelective(apply);
        if(result>0){
            return Result.success("提交成功！");
        }
        return Result.fail("提交失败！");
    }*/

    /*
     * 审批
     * @param applyApprDTO
     * @return
     */
    /*@Override
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    @ApiOperation(value = "审批(弃用！)", notes = "审批(弃用！)")
    @ApiResponses({
            @ApiResponse(code = 75005, message = "模块数据不能为空"),
            @ApiResponse(code = 75006, message = "ID不能为空"),
            @ApiResponse(code = 75010, message = "审批描述不能为空"),
            @ApiResponse(code = 75011, message = "审批状态不能为空"),
    })
    public Result<String> updateApproveStatus(@RequestBody AssignModuleApplyApprDTO applyApprDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.ASSIGN_MODULE_APPLY,applyApprDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(applyApprDTO.getId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPR_DESC,applyApprDTO.getAuditDesc());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPR_STATUS,String.valueOf(applyApprDTO.getPassStatus()));
        //2.数据处理
        ServiceAssignModuleApply apply = new ServiceAssignModuleApply();
        apply.setId(applyApprDTO.getId());
        apply.setAuditDesc(applyApprDTO.getAuditDesc());
        if(applyApprDTO.getPassStatus()){
            apply.setStatus(AssignModuleApplyConstant.STATUS_PASS);
        }else{
            apply.setStatus(AssignModuleApplyConstant.STATUS_NOT_PASS);
        }
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(BaseContextHandler.getAdminId());
        //3.保存
        int result = assignModuleApplyService.updateByIdSelective(apply);
        if(result>0){
            //TODO 保存数据，虽然写了 ，但是后面得知审批功能不由我做，所以没再补充
            return Result.success("审批成功！");
        }
        return Result.fail("审批失败！");
    }*/

    /**
     * 查询审批历史
     * @param apprId
     * @return
     */
    @Override
    @RequestMapping(value = "/apprHistory", method = RequestMethod.GET)
    @ApiOperation(value = "查询审批历史", notes = "查询审批历史")
    @ApiResponses({
            @ApiResponse(code = 75006, message = "ID不能为空"),
    })
    public Result<AssignModuleApplyRetDTO> getApprHistory( @RequestParam (value = "apprId")Long apprId) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.ASSIGN_MODULE_APPLY_ID,String.valueOf(apprId));
        //2.查询数据
        ServiceAssignModuleApplyExample example = new ServiceAssignModuleApplyExample();
        example.createCriteria().andServiceAssignModuleIdEqualTo(apprId);
        ServiceAssignModuleApply doc =  assignModuleApplyService.getUnique(example);
        AssignModuleApplyRetDTO retDTO = dozerUtils.map(doc,AssignModuleApplyRetDTO.class);
        return Result.success(retDTO);
    }
}
