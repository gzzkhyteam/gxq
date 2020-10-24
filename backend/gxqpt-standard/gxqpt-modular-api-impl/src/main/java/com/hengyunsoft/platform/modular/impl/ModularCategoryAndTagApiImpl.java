package com.hengyunsoft.platform.modular.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.groups.Default;

import com.hengyunsoft.base.id.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.modular.dto.MdCategoryDefDTO;
import com.hengyunsoft.platform.modular.dto.MdTagDefDTO;
import com.hengyunsoft.platform.modular.dto.ModularCategoryAndTagApplyDTO;
import com.hengyunsoft.platform.modular.dto.ModularCategoryAndTagApplyDealDTO;
import com.hengyunsoft.platform.modular.dto.ModularCategoryAndTagApplyQueryDTO;
import com.hengyunsoft.platform.modular.dto.ModularCategoryAndTagApplySaveDTO;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularApply;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategoryDef;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTagDef;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularApplyExample;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularCategoryDefExample;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularTagDefExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryAndTagApplyService;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryDefService;
import com.hengyunsoft.platform.modular.repository.service.ModularTagDefService;
import com.hengyunsoft.platform.modular.utils.SuperviseType;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangs
 * @createTime 2018-4-5
 */

@RestController
@Slf4j
@Api(value = "ModularCategoryAndTagApiImpl", description = "模块分类和标签管理")
public class ModularCategoryAndTagApiImpl /*implements ModularCategoryAndTagApi*/ {

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private ModularCategoryAndTagApplyService modularCategoryAndTagApplyService;

    @Autowired
    private ModularCategoryDefService modularCategoryDefService;

    @Autowired
    private ModularTagDefService modularTagDefService;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private PowerSuperviseTempApi powerSuperviseTempApi;

    @Autowired
    private IdGenerate<Long> idGenerate;

    /**
     * 保存模块申请信息
     *
     * @param modularCategoryAndTagApplySaveDTO
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存模块申请", notes = "保存模块申请信息")
    @ApiResponses({
            @ApiResponse(code = 37001, message = "模块申请信息为空"),
            @ApiResponse(code = 37002, message = "模块申请类型为空"),
            @ApiResponse(code = 37003, message = "模块申请名称为空"),
            @ApiResponse(code = 37004, message = "模块申请描述为空"),
            @ApiResponse(code = 37005, message = "模块申请原因为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ModularApply.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<ModularCategoryAndTagApplyDTO> save(@RequestBody ModularCategoryAndTagApplySaveDTO modularCategoryAndTagApplySaveDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.MODULAR_APPLY_NULL, modularCategoryAndTagApplySaveDTO);
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_TYPE_EMPTY, modularCategoryAndTagApplySaveDTO.getApplyType());
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_NAME_EMPTY, modularCategoryAndTagApplySaveDTO.getName());
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_DESCRIPTION_EMPTY, modularCategoryAndTagApplySaveDTO.getDescription());
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_REASON_EMPTY, modularCategoryAndTagApplySaveDTO.getReason());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        //3,转换po，并保存
        ModularApply modularApply = dozerUtils.map(modularCategoryAndTagApplySaveDTO, ModularApply.class);
        Date date = Calendar.getInstance().getTime();
		modularApply.setCreateTime(date);//申请时间
        modularApply.setCreateUser(adminId);//申请人id
        modularApply.setCreateUserName(userName);//申请人姓名
        modularApply.setIsDeal(false);//新申请的数据为待办状态
        //update start wangsong 2018-05-08 添加申请人公司信息
        modularApply.setCreateCompany(modularCategoryAndTagApplySaveDTO.getCreateCompany());
        modularApply.setCreateCompanyName(modularCategoryAndTagApplySaveDTO.getCreateCompanyName());
        //update end wangsong 2018-05-08
		modularApply.setId(idGenerate.generate());
        modularCategoryAndTagApplyService.saveModularApply(modularApply);
        //发送消息给管理员
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(modularApply);
        msgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO,"app_admin","35kj6358");
        
        //推送到统一监管
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(modularApply.getId());
        sts.setStartTime(modularApply.getCreateTime());
        sts.setCode(SuperviseType.MODULAR_CODE.getCode());
        sts.setName(SuperviseType.MODULAR_CODE.getName());
        sts.setDesc(SuperviseType.MODULAR_CODE.getDescribe());
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        //4,返回
        return Result.success(dozerUtils.map(modularApply, ModularCategoryAndTagApplyDTO.class));
    }

    /**
     * 通过模块申请信息
     *
     * @param modularCategoryAndTagApplyDealDTO
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/pass", method = RequestMethod.POST)
    @ApiOperation(value = "通过模块申请", notes = "通过模块申请信息")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
            @ApiResponse(code = 37006, message = "处理意见为空"),
    })
    public Result<Boolean> pass(@RequestBody ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, modularCategoryAndTagApplyDealDTO.getId());
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_DEAL_SUGGESTION_EMPTY, modularCategoryAndTagApplyDealDTO.getDealSuggestion());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        List<Long> lookUserIds = new ArrayList<>(1);
        UpdateBacklogReqDTO updateBacklogReqDTO = null;
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        //3,转换po，并保存
        ModularApply modularApply = dozerUtils.map(modularCategoryAndTagApplyDealDTO, ModularApply.class);

        modularApply.setIsDeal(true);//处理状态--已处理
        modularApply.setDealSuggestion(modularCategoryAndTagApplyDealDTO.getDealSuggestion());//处理通过的意见
        modularApply.setDealResult("PASS");//处理结果--通过
        modularApply.setUpdateTime(Calendar.getInstance().getTime());//处理时间
        modularApply.setUpdateUser(adminId);//更新人id
        modularApply.setUpdateUserName(userName);//更新人姓名


        int i = modularCategoryAndTagApplyService.updateByIdSelective(modularApply);

        ModularApply newModularApply = modularCategoryAndTagApplyService.getById(modularCategoryAndTagApplyDealDTO.getId());
        //获取申请人的id
        lookUserIds.add(newModularApply.getCreateUser());
        //待审批的消息更新
        updateBacklogReqDTO = builderUpdateBacklogReqDTO(newModularApply,adminId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        //给申请人发消息
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(newModularApply,true);
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);

        //推送到统一监管
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(modularApply.getId());
        sts.setStartTime(newModularApply.getCreateTime());
        sts.setEndTime(newModularApply.getUpdateTime());
        sts.setCode(SuperviseType.MODULAR_CODE.getCode());
        sts.setName(SuperviseType.MODULAR_CODE.getName());
        sts.setDesc(SuperviseType.MODULAR_CODE.getDescribe());
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        
        //4,返回并在分类表或者标签表插入数据
        if (i > 0) {
            ModularApply apply = modularCategoryAndTagApplyService.getById(modularCategoryAndTagApplyDealDTO.getId());
            if ("CATEGORYAPPLY".equals(apply.getApplyType())) {
                ModularCategoryDef modularCategoryDef = new ModularCategoryDef();
                modularCategoryDef.setName(apply.getName());
                modularCategoryDef.setDescription(apply.getDescription());
                modularCategoryDef.setCreateTime(Calendar.getInstance().getTime());
                modularCategoryDefService.save(modularCategoryDef);//分类表插入数据
            } else if ("TAGAPPLY".equals(apply.getApplyType())) {
                ModularTagDef modularTagDef = new ModularTagDef();
                modularTagDef.setName(apply.getName());
                modularTagDef.setDescription(apply.getDescription());
                modularTagDef.setCreateTime(Calendar.getInstance().getTime());
                modularTagDefService.save(modularTagDef);//标签表插入数据
            }
            return Result.success(true);
        } else {
            return Result.fail("未找到要处理的数据，id：" + modularCategoryAndTagApplyDealDTO.getId());
        }
    }

    /**
     * 驳回模块申请信息
     *
     * @param modularCategoryAndTagApplyDealDTO
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/reject", method = RequestMethod.POST)
    @ApiOperation(value = "驳回模块申请", notes = "驳回模块申请信息")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
            @ApiResponse(code = 37006, message = "处理意见为空"),
    })
    public Result<Boolean> reject(@RequestBody ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, modularCategoryAndTagApplyDealDTO.getId());
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_APPLY_DEAL_SUGGESTION_EMPTY, modularCategoryAndTagApplyDealDTO.getDealSuggestion());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        List<Long> lookUserIds = new ArrayList<>(1);
        UpdateBacklogReqDTO updateBacklogReqDTO = null;
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        //3,转换po，并保存
        ModularApply modularApply = dozerUtils.map(modularCategoryAndTagApplyDealDTO, ModularApply.class);

        modularApply.setIsDeal(true);//处理状态--已处理
        modularApply.setDealSuggestion(modularCategoryAndTagApplyDealDTO.getDealSuggestion());//处理驳回的意见
        modularApply.setDealResult("REJECT");//处理结果--驳回
        modularApply.setUpdateTime(Calendar.getInstance().getTime());//处理时间
        modularApply.setUpdateUser(adminId);//更新人id
        modularApply.setUpdateUserName(userName);//更新人姓名

        int i = modularCategoryAndTagApplyService.updateByIdSelective(modularApply);

        ModularApply newModularApply = modularCategoryAndTagApplyService.getById(modularCategoryAndTagApplyDealDTO.getId());
        //获取申请人的id
        lookUserIds.add(newModularApply.getCreateUser());
        //待审批的消息更新
        updateBacklogReqDTO = builderUpdateBacklogReqDTO(newModularApply,adminId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        //给申请人发消息
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(newModularApply,false);
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);
        //推送到统一监管
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(modularApply.getId());
        sts.setStartTime(newModularApply.getCreateTime());
        sts.setEndTime(newModularApply.getUpdateTime());
        sts.setCode(SuperviseType.MODULAR_CODE.getCode());
        sts.setName(SuperviseType.MODULAR_CODE.getName());
        sts.setDesc(SuperviseType.MODULAR_CODE.getDescribe());
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要处理的数据，id：" + modularCategoryAndTagApplyDealDTO.getId());
        }
    }

    /**
     * 模块申请信息分页查询
     *
     * @param openApiReq
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/pageApply", method = RequestMethod.POST)
    @ApiOperation(value = "模块申请信息", notes = "模块申请信息分页查询")
    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageApply(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
        //1，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        ModularApplyExample example = new ModularApplyExample();

        if (openApiReq.getData() != null) {
            example.createCriteria().andCreateUserEqualTo(adminId)
                    .andApplyTypeEqualTo(openApiReq.getData().getApplyType())
                    .andNameLike(ModularApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd())
                    .andDealResultEqualTo(openApiReq.getData().getDealResult());
        } else {
            example.createCriteria().andCreateUserEqualTo(adminId);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularApply> list = modularCategoryAndTagApplyService.find(example);
        List<ModularCategoryAndTagApplyDTO> pageList = dozerUtils.mapPage(list, ModularCategoryAndTagApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 模块申请已办事项分页查询
     *
     * @param openApiReq
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/pageDone", method = RequestMethod.POST)
    @ApiOperation(value = "模块申请已办事项", notes = "模块申请已办事项分页查询")
    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageDone(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
        ModularApplyExample example = new ModularApplyExample();
        if (openApiReq.getData() != null) {
            example.createCriteria().andIsDealEqualTo(true)
                    .andApplyTypeEqualTo(openApiReq.getData().getApplyType())
                    .andNameLike(ModularApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd())
                    .andDealResultEqualTo(openApiReq.getData().getDealResult());
        } else {
            example.createCriteria().andIsDealEqualTo(true);//查询已办理的申请信息
        }
        example.setOrderByClause(" create_time desc ");

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularApply> list = modularCategoryAndTagApplyService.find(example);
        List<ModularCategoryAndTagApplyDTO> pageList = dozerUtils.mapPage(list, ModularCategoryAndTagApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 模块申请待办事项分页查询
     *
     * @param openApiReq
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/mdapply/pageToDo", method = RequestMethod.POST)
    @ApiOperation(value = "模块申请待办事项", notes = "模块申请待办事项分页查询")
    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageToDo(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
        ModularApplyExample example = new ModularApplyExample();
        if (openApiReq.getData() != null) {
            example.createCriteria().andIsDealEqualTo(false)
                    .andApplyTypeEqualTo(openApiReq.getData().getApplyType())
                    .andNameLike(ModularApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd());
        } else {
            example.createCriteria().andIsDealEqualTo(false);//查询已办理的申请信息
        }
        example.setOrderByClause(" create_time desc ");

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularApply> list = modularCategoryAndTagApplyService.find(example);
        List<ModularCategoryAndTagApplyDTO> pageList = dozerUtils.mapPage(list, ModularCategoryAndTagApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 分类列表查询
     *
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/category/findCategoryDef", method = RequestMethod.POST)
    @ApiOperation(value = "分类列表查询", notes = "分类列表查询")
    public Result<List<MdCategoryDefDTO>> findCategoryDef() {

        ModularCategoryDefExample example = new ModularCategoryDefExample();
        example.createCriteria();
        List<ModularCategoryDef> lists = modularCategoryDefService.find(example);

        return Result.success(dozerUtils.mapPage(lists, MdCategoryDefDTO.class));
    }

    /**
     * 标签列表查询
     *
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/tag/findTagDef", method = RequestMethod.POST)
    @ApiOperation(value = "标签列表查询", notes = "标签列表查询")
    public Result<List<MdTagDefDTO>> findTagDef() {
        ModularTagDefExample example = new ModularTagDefExample();
        example.createCriteria();
        List<ModularTagDef> lists = modularTagDefService.find(example);

        return Result.success(dozerUtils.mapPage(lists, MdTagDefDTO.class));
    }

    //待审批消息的对象
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ModularApply modularApply) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(modularApply.getId().toString());
        bbsAllMainMsgDTO.setBizType("invoke_module");
        bbsAllMainMsgDTO.setBriefTpye("work_result");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        if ("CATEGORYAPPLY".equals(modularApply.getApplyType())){
            bbsAllMainMsgDTO.setContent("您有一个"+modularApply.getName()+"Categories申请待审批.");
            bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Categories申请");
            bbsAllMainMsgDTO.setDetailedTypeDesc("Categories申请待审批");
        }else if("TAGAPPLY".equals(modularApply.getApplyType())){
            bbsAllMainMsgDTO.setContent("您有一个"+modularApply.getName()+"Tags申请待审批.");
            bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Tags申请");
            bbsAllMainMsgDTO.setDetailedTypeDesc("Tags申请待审批");
        }
        bbsAllMainMsgDTO.setDetailedType("module_invoke");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setHandlerUrl("/module/index?promUrl=/gxqpt-modular/modular/toDoApplyList");
        bbsAllMainMsgDTO.setHandlerParams("");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }
    //审批消息的对象
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(ModularApply modularApply, boolean pass) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(modularApply.getId().toString());
        bbsAllMainMsgDTO.setBizType("add_module");
        bbsAllMainMsgDTO.setBriefTpye("audit_result");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        if(pass) {
            if ("CATEGORYAPPLY".equals(modularApply.getApplyType())){
                bbsAllMainMsgDTO.setContent("您申请的"+modularApply.getName()+"Categories已审批通过.");
                bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Categories审批通过");
                bbsAllMainMsgDTO.setDetailedTypeDesc("Categories审批结果");
            }else if("TAGAPPLY".equals(modularApply.getApplyType())){
                bbsAllMainMsgDTO.setContent("您申请的"+modularApply.getName()+"Tags已审批通过.");
                bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Tags审批通过");
                bbsAllMainMsgDTO.setDetailedTypeDesc("Tags审批结果");
            }

        } else {
            if ("CATEGORYAPPLY".equals(modularApply.getApplyType())){
                bbsAllMainMsgDTO.setContent("您申请的"+modularApply.getName()+"Categories被驳回.");
                bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Categories被驳回");
                bbsAllMainMsgDTO.setDetailedTypeDesc("Categories审批结果");
            }else if("TAGAPPLY".equals(modularApply.getApplyType())){
                bbsAllMainMsgDTO.setContent("您申请的"+modularApply.getName()+"Tags被驳回.");
                bbsAllMainMsgDTO.setTitle(modularApply.getName()+"Tags被驳回");
                bbsAllMainMsgDTO.setDetailedTypeDesc("Tags审批结果");
            }
        }
        bbsAllMainMsgDTO.setDetailedType("module_add_apply");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("/module/index?promUrl=/gxqpt-modular/modular/categoryAndTagApplyList");
        bbsAllMainMsgDTO.setHandlerParams("");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }
    //更新待审批消息的对象
    private UpdateBacklogReqDTO builderUpdateBacklogReqDTO(ModularApply modularApply, Long receiveId){
        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
        updateBacklogReqDTO.setReceiveId(receiveId);
        updateBacklogReqDTO.setAppId(BaseContextHandler.getAppId());
        updateBacklogReqDTO.setBizId(modularApply.getId().toString());
        updateBacklogReqDTO.setClientFlag("gxqpt");
        updateBacklogReqDTO.setBizType("invoke_module");
        return updateBacklogReqDTO;
    }
}
