package com.hengyunsoft.platform.standard.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.standard.dto.StandardClassifyApplyDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyApplyDealDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyApplyQueryDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyApplySaveDTO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassifyApply;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyApplyExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyApplyService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.utils.SuperviseType;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "标准分类申请", description = "标准分类申请")
public class StandardClassifyApplyApiImpl /*implements StandardClassifyApplyApi*/ {

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private StandardClassifyApplyService standardClassifyApplyService;

    @Autowired
    private StandardClassifyService standardClassifyService;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private PowerSuperviseTempApi powerSuperviseTempApi;

    /**
     * 根据id 查看分类申请详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/apply/get", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
    })
    public Result<StandardClassifyApplyDTO> get(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardClassifyApply classify = standardClassifyApplyService.getById(id);

        return Result.success(dozerUtils.map(classify, StandardClassifyApplyDTO.class));
    }

    /**
     * 保存标准分类申请信息
     *
     * @param standardClassifyApplySaveDTO
     * @return
     */
    @RequestMapping(value = "/apply/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 35003, message = "标准分类申请信息为空"),
            @ApiResponse(code = 35004, message = "标准分类申请名称为空"),
            @ApiResponse(code = 35005, message = "标准分类申请父类别为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = StandardClassifyApply.class)
            }
    )
    public Result<StandardClassifyApplyDTO> save(@RequestBody StandardClassifyApplySaveDTO standardClassifyApplySaveDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.CLASSIFY_APPLY_NULL, standardClassifyApplySaveDTO);
        BizAssert.assertNotEmpty(StandardExceptionCode.CLASSIFY_APPLY_NAME_EMPTY, standardClassifyApplySaveDTO.getName());
        BizAssert.assertNotEmpty(StandardExceptionCode.CLASSIFY_APPLY_PARENT_EMPTY, standardClassifyApplySaveDTO.getParentId());

        //2，获取身份
        String userName = BaseContextHandler.getName();
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        //3,转换po，并保存
        StandardClassifyApply standardClassifyApply = dozerUtils.map(standardClassifyApplySaveDTO, StandardClassifyApply.class);
        standardClassifyApply.setCreateTime(Calendar.getInstance().getTime());//申请时间
        standardClassifyApply.setCreateUser(BaseContextHandler.getAdminId());//申请人id
        standardClassifyApply.setCreateUserName(userName);//申请人姓名
        standardClassifyApply.setIsDeal(false);//新申请的数据为待办状态
        //update start wangsong 2018-05-08 添加申请人公司信息
        standardClassifyApply.setCreateCompany(standardClassifyApplySaveDTO.getCreateCompany());
        standardClassifyApply.setCreateCompanyName(standardClassifyApplySaveDTO.getCreateCompanyName());
        //update end wangsong 2018-05-08
        standardClassifyApply = standardClassifyApplyService.save(standardClassifyApply);
        //发送消息给管理员
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(standardClassifyApply);
        msgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO,"app_admin","25kj6354");
        
        //推送到统一监管
	    PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
	    sts.setBizId(standardClassifyApply.getId());
	    sts.setStartTime(standardClassifyApply.getCreateTime());
	    sts.setCode(SuperviseType.STANDARD_CODE.getCode());
	    sts.setName(SuperviseType.STANDARD_CODE.getName());
	    sts.setDesc(SuperviseType.STANDARD_CODE.getDescribe());
	    sts.setAppId(BaseContextHandler.getAppId());
	    sts.setAppName(BaseContextHandler.getAppName());
	    Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
	    log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        //4,返回
        return Result.success(dozerUtils.map(standardClassifyApply, StandardClassifyApplyDTO.class));
    }

    /**
     * 通过标准分类申请信息
     *
     * @param standardClassifyApplyDealDTO
     */
    @RequestMapping(value = "/apply/pass", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
            @ApiResponse(code = 35006, message = "处理申请信息为空"),
    })
    public Result<Boolean> updatePass(@RequestBody StandardClassifyApplyDealDTO standardClassifyApplyDealDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, standardClassifyApplyDealDTO.getId());
        BizAssert.assertNotNull(StandardExceptionCode.CLASSIFY_APPLY_DEAL_NULL, standardClassifyApplyDealDTO);

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        List<Long> lookUserIds = new ArrayList<Long>();
                
        //3,转换po，并保存
        StandardClassifyApply standardClassifyApply = dozerUtils.map(standardClassifyApplyDealDTO, StandardClassifyApply.class);
        standardClassifyApply.setIsDeal(true);//处理状态--已处理
        standardClassifyApply.setDealResultDescription(standardClassifyApplyDealDTO.getDealResultDescription());//处理通过的意见
        standardClassifyApply.setDealResult("PASS");//处理结果--通过
        standardClassifyApply.setUpdateTime(Calendar.getInstance().getTime());//处理时间
        standardClassifyApply.setUpdateUser(adminId);//更新人id
        standardClassifyApply.setUpdateUserName(userName);//更新人姓名
        int i = standardClassifyApplyService.updateByIdSelective(standardClassifyApply);
        StandardClassifyApply newClassify = standardClassifyApplyService.getById(standardClassifyApply.getId());
        //获取申请人的id
        lookUserIds.add(newClassify.getCreateUser());
        //待审批的消息更新
        UpdateBacklogReqDTO updateBacklogReqDTO = builderUpdateBacklogReqDTO(newClassify,adminId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        //给申请人发消息
        BbsAllMainMsgDTO bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(newClassify,true);
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);
        
        //推送到统一监管
	    PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
	    sts.setBizId(standardClassifyApply.getId());
	    sts.setStartTime(newClassify.getCreateTime());
	    sts.setEndTime(newClassify.getUpdateTime());
	    sts.setCode(SuperviseType.STANDARD_CODE.getCode());
	    sts.setName(SuperviseType.STANDARD_CODE.getName());
	    sts.setDesc(SuperviseType.STANDARD_CODE.getDescribe());
	    sts.setAppId(BaseContextHandler.getAppId());
	    sts.setAppName(BaseContextHandler.getAppName());
	    Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
	    log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        //4,返回
        if (i > 0) {
            StandardClassify standardClassify = new StandardClassify();
            StandardClassifyApply classify = standardClassifyApplyService.getById(standardClassifyApplyDealDTO.getId());
            standardClassify.setName(classify.getName());
            standardClassify.setParentId(classify.getParentId());
            standardClassify.setDescription(classify.getDescription());
            standardClassify.setCreateUser(adminId);
            standardClassify.setCreateTime(Calendar.getInstance().getTime());
            standardClassify.setCreateUserName(userName);
            standardClassify.setIsEnable(true);
            standardClassifyService.save(standardClassify);
            return Result.success(true);
        } else {
            return Result.fail("未找到要处理的数据，id：" + standardClassifyApplyDealDTO.getId());
        }
    }

    /**
     * 驳回标准分类申请信息
     *
     * @param standardClassifyApplyDealDTO
     */
    @RequestMapping(value = "/apply/reject", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
            @ApiResponse(code = 35006, message = "处理申请信息为空"),
    })
    public Result<Boolean> updateReject(@RequestBody StandardClassifyApplyDealDTO standardClassifyApplyDealDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, standardClassifyApplyDealDTO.getId());
        BizAssert.assertNotNull(StandardExceptionCode.CLASSIFY_APPLY_DEAL_NULL, standardClassifyApplyDealDTO);

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        List<Long> lookUserIds = new ArrayList<>(1);
        UpdateBacklogReqDTO updateBacklogReqDTO = null;
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        //3,转换po，并保存
        StandardClassifyApply standardClassifyApply = dozerUtils.map(standardClassifyApplyDealDTO, StandardClassifyApply.class);

        standardClassifyApply.setIsDeal(true);//处理状态--已处理
        standardClassifyApply.setDealResultDescription(standardClassifyApplyDealDTO.getDealResultDescription());//处理驳回的意见
        standardClassifyApply.setDealResult("REJECT");//处理结果--驳回
        standardClassifyApply.setUpdateTime(Calendar.getInstance().getTime());//处理时间
        standardClassifyApply.setUpdateUser(adminId);//更新人id
        standardClassifyApply.setUpdateUserName(userName);//更新人姓名

        int i = standardClassifyApplyService.updateByIdSelective(standardClassifyApply);
        StandardClassifyApply newClassify = standardClassifyApplyService.getById(standardClassifyApply.getId());
        //获取申请人的id
        lookUserIds.add(newClassify.getCreateUser());
        //待审批的消息更新
        updateBacklogReqDTO = builderUpdateBacklogReqDTO(newClassify,adminId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        //给申请人发消息
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(newClassify,false);
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds , null);
        
        //推送到统一监管
	    PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
	    sts.setBizId(standardClassifyApply.getId());
	    sts.setStartTime(newClassify.getCreateTime());
	    sts.setEndTime(newClassify.getUpdateTime());
	    sts.setCode(SuperviseType.STANDARD_CODE.getCode());
	    sts.setName(SuperviseType.STANDARD_CODE.getName());
	    sts.setDesc(SuperviseType.STANDARD_CODE.getDescribe());
	    sts.setAppId(BaseContextHandler.getAppId());
	    sts.setAppName(BaseContextHandler.getAppName());
	    Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
	    log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要处理的数据，id：" + standardClassifyApplyDealDTO.getId());
        }
    }

    /**
     * 标准分类申请信息分页查询
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/apply/pageMyApply", method = RequestMethod.POST)
    public Result<PageInfo<StandardClassifyApplyDTO>> pageMyApply(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        StandardClassifyApplyExample example = new StandardClassifyApplyExample();

        if (openApiReq.getData() != null) {
            example.createCriteria().andCreateUserEqualTo(adminId)
                    .andNameLike(StandardClassifyApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd())
                    .andDealResultEqualTo(openApiReq.getData().getDealResult());
        }else{
            example.createCriteria().andCreateUserEqualTo(adminId);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardClassifyApply> list = standardClassifyApplyService.find(example);
        List<StandardClassifyApplyDTO> pageList = dozerUtils.mapPage(list, StandardClassifyApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 标准分类申请已办事项分页查询
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/apply/pageDone", method = RequestMethod.POST)
    public Result<PageInfo<StandardClassifyApplyDTO>> pageDone(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
        StandardClassifyApplyExample example = new StandardClassifyApplyExample();
        if (openApiReq.getData() != null) {
            example.createCriteria().andIsDealEqualTo(true)
                    .andNameLike(StandardClassifyApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd())
                    .andDealResultEqualTo(openApiReq.getData().getDealResult());
        }else{
            example.createCriteria().andIsDealEqualTo(true);//查询已办理的申请信息
        }
        example.setOrderByClause(" create_time desc ");

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardClassifyApply> list = standardClassifyApplyService.find(example);
        List<StandardClassifyApplyDTO> pageList = dozerUtils.mapPage(list, StandardClassifyApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 标准分类申请未办理事项分页查询
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/apply/pageToDo", method = RequestMethod.POST)
    public Result<PageInfo<StandardClassifyApplyDTO>> pageToDo(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
        StandardClassifyApplyExample example = new StandardClassifyApplyExample();
        if (openApiReq.getData() != null) {
            example.createCriteria().andIsDealEqualTo(false)
                    .andNameLike(StandardClassifyApplyExample.fullLike(openApiReq.getData().getName()))
                    .andCreateTimeGreaterThanOrEqualTo(openApiReq.getData().getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(openApiReq.getData().getCreateTimeEnd())
                    .andDealResultEqualTo(openApiReq.getData().getDealResult());
        }else{
            example.createCriteria().andIsDealEqualTo(false);//查询未办理的申请信息
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardClassifyApply> list = standardClassifyApplyService.find(example);
        List<StandardClassifyApplyDTO> pageList = dozerUtils.mapPage(list, StandardClassifyApplyDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    //待审批消息的对象
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(StandardClassifyApply standardClassifyApply) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(standardClassifyApply.getId().toString());
        bbsAllMainMsgDTO.setBizType("invoke_module");
        bbsAllMainMsgDTO.setBriefTpye("work_result");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        bbsAllMainMsgDTO.setContent("您有一个"+standardClassifyApply.getName()+"标准分类申请待审批.");
        bbsAllMainMsgDTO.setTitle(standardClassifyApply.getName()+"标准分类申请");
        bbsAllMainMsgDTO.setDetailedType("module_invoke");
        bbsAllMainMsgDTO.setDetailedTypeDesc("标准分类申请");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setHandlerUrl("/module/index?promUrl=/gxqpt-standard/standard/toDoList");
        bbsAllMainMsgDTO.setHandlerParams("");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }
    //审批消息的对象
    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(StandardClassifyApply standardClassifyApply, boolean pass) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(standardClassifyApply.getId().toString());
        bbsAllMainMsgDTO.setBizType("add_module");
        bbsAllMainMsgDTO.setBriefTpye("audit_result");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        if(pass) {
            bbsAllMainMsgDTO.setContent("您申请的"+standardClassifyApply.getName()+"标准分类已审批通过.");
            bbsAllMainMsgDTO.setTitle(standardClassifyApply.getName()+"标准分类审批通过");
        } else {
            bbsAllMainMsgDTO.setContent("您申请的"+standardClassifyApply.getName()+"标准分类被驳回.");
            bbsAllMainMsgDTO.setTitle(standardClassifyApply.getName()+"标准分类被驳回");
        }
        bbsAllMainMsgDTO.setDetailedType("module_add_apply");
        bbsAllMainMsgDTO.setDetailedTypeDesc("标准分类审批");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("/module/index?promUrl=/gxqpt-standard/standard/applyList");
        bbsAllMainMsgDTO.setHandlerParams("");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }
    //更新待审批消息的对象
    private UpdateBacklogReqDTO builderUpdateBacklogReqDTO(StandardClassifyApply standardClassifyApply,Long receiveId){
        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
        updateBacklogReqDTO.setReceiveId(receiveId);
        updateBacklogReqDTO.setAppId(BaseContextHandler.getAppId());
        updateBacklogReqDTO.setBizId(standardClassifyApply.getId().toString());
        updateBacklogReqDTO.setClientFlag("gxqpt");
        updateBacklogReqDTO.setBizType("invoke_module");
        return updateBacklogReqDTO;
    }
}
