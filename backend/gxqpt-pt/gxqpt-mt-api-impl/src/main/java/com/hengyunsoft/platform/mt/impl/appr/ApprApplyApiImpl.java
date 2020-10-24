package com.hengyunsoft.platform.mt.impl.appr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.open.core.api.UserOpenApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.mt.api.appr.dto.*;
import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import com.hengyunsoft.platform.mt.entity.file.po.File;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprPersonService;
import com.hengyunsoft.platform.mt.repository.file.example.FileExample;
import com.hengyunsoft.platform.mt.repository.file.service.FileService;
import com.hengyunsoft.platform.mt.utils.MsgQueueUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.appr
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：考勤申请和审批
 * 修改人：gbl
 * 修改时间：2018/7/11
 * 修改内容：新增基础接口
 */
@Api(value = "API - ApprApplyApiImpl.java", description = "考勤申请和审批")
@RestController
@RequestMapping("apprApply")
@Slf4j
public class ApprApplyApiImpl /*implements ApprApplyApi*/ {
    @Autowired
    private ApprApplyManager apprApplyManager;
    @Autowired
    private ApprApplyService apprApplyService;
    @Autowired
    private ApprPersonService apprPersonService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserOpenApi userOpenApi;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    /**
     * 描述：web端分页查询申请列表
     * 参数：[openApiReq]
     * 返回值：com.hengyunsoft.base.Result<com.github.pagehelper.PageInfo<com.hengyunsoft.platform.mt.api.appr.dto.ApprApplyDTO>>
     * 修改人：gbl
     * 修改时间：2018/7/10
     * 修改内容：
     */
    @RequestMapping(value = "findApprApplyPage", method = RequestMethod.POST)
    @ApiOperation(value = "web端分页查询申请列表", notes = "web端分页查询申请列表")
    @ApiResponses({
            @ApiResponse(code = 93025, message = "查询申请列表记录参数不能为空"),
    })

    public Result<PageInfo<ApprApplyDTO>> getApprApplyPage(@RequestBody OpenApiReq<QueryApprApplyParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.QUERY_APPRAPPLY_PARAM, openApiReq);
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);

        Map<String, Object> param = new HashMap<>();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        param.put("unitId", unitId);//只看本单位的
        List<ApprApply> list = new ArrayList<>();
        if (openApiReq.getData() != null) {
            param.put("aprType", openApiReq.getData().getAprType());
            param.put("curState", openApiReq.getData().getCurState());
            param.put("startCreateTime", openApiReq.getData().getStartCreateTime());
            param.put("endCreateTime", openApiReq.getData().getEndCreateTime());

            if (openApiReq.getData().getIsFromMe() != null && openApiReq.getData().getIsFromMe()) {//查询我发出的
                param.put("createUser", userId);
                list = apprApplyService.findPageMyApplyList(param);
            } else {//查询我收到的
                param.put("personId", userId);
                list = apprApplyService.findPageSendMeApplyList(param);
            }
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApprApplyDTO.class)));
    }

    /**
     * 描述：查询当前待我审批或者查询我审批过的的列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/10
     * 修改内容：
     */

    @RequestMapping(value = "findPageCurSendMeApplyList", method = RequestMethod.POST)
    @ApiOperation(value = "查询当前待我审批或者查询我审批过的的列表", notes = "查询当前待我审批或者查询我审批过的的列表")
    @ApiResponses({
            @ApiResponse(code = 93025, message = "查询申请列表记录参数不能为空"),
    })
    public Result<PageInfo<ApprApplyDTO>> getPageCurSendMeApplyList(@RequestBody OpenApiReq<QueryApprApplyParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.QUERY_APPRAPPLY_PARAM, openApiReq);
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);

        Map<String, Object> param = new HashMap<>();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApprApply> list = null;
        param.put("personId", userId);

        param.put("unitId", unitId);//只看本单位的
        if (openApiReq.getData() != null) {
            param.put("aprType", openApiReq.getData().getAprType());
            param.put("curState", openApiReq.getData().getCurState());
            param.put("startCreateTime", openApiReq.getData().getStartCreateTime());
            param.put("endCreateTime", openApiReq.getData().getEndCreateTime());
            if (openApiReq.getData().getIsPassMe() != null && openApiReq.getData().getIsPassMe()) {//查询我审批过的
                List<ApprApply> pagePassSendMeApplyList = apprApplyService.findPagePassSendMeApplyList(param);
                list = pagePassSendMeApplyList;
            } else {//查询当前待我审批
                param.put("curState", 1);//查询审批中的
                List<ApprApply> pageCurSendMeApplyList = apprApplyService.findPageCurSendMeApplyList(param);
                list = pageCurSendMeApplyList;
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        List<Integer> removes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ApprApply aa = list.get(i);
            if (aa == null) {
                removes.add(i);
            }
        }
        for (int in : removes) {
            list.remove(in);
        }

        List<ApprApplyDTO> listApprDto = dozerUtils.mapPage(list, ApprApplyDTO.class);
        //设置头像
        ArrayList<Long> uids = new ArrayList<>();
        for (ApprApplyDTO aa : listApprDto) {
            uids.add(aa.getApplyUserId());
        }
        Result<Map<Long, UserResDTO>> res = userOpenApi.findUserByIdList(uids);
        if (res.isSuccess()) {
            Map<Long, UserResDTO> data = res.getData();
            for (ApprApplyDTO aad : listApprDto) {
                UserResDTO userResDTO = data.get(aad.getApplyUserId());
                aad.setPhoto(userResDTO.getPhoto());
            }
        } else {
            log.error("调用 UserOpenApi的方法findUserByIdList失败，返回消息:" + res.getErrmsg());
        }
        return Result.success(new PageInfo<>(listApprDto));
    }

    /**
     * 描述：处理审批请求
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/10
     * 修改内容：
     */

    @RequestMapping(value = "dealApprApply", method = RequestMethod.GET)
    @ApiOperation(value = "处理审批请求", notes = "处理审批请求")
    @ApiResponses({
            @ApiResponse(code = 93026, message = "审批id不能为空"),
            @ApiResponse(code = 93027, message = "审批申请不存在"),
            @ApiResponse(code = 93028, message = "当前不到你审批"),
            @ApiResponse(code = 93029, message = "是否同意不能为空"),
            @ApiResponse(code = 93030, message = "处理内容不能为空"),
            @ApiResponse(code = 93031, message = "审批人不存在"),
            @ApiResponse(code = 93032, message = "该申请没有在审批中"),

    })
    public Result<Boolean> saveDealApprApply(@RequestParam("id") Long id, @RequestParam("agree") Integer agree, @RequestParam("apprOpinion") String apprOpinion) {
        BizAssert.assertNotNull(MtExceptionCode.APPLYID_HAS_NOT, id);
        BizAssert.assertNotNull(MtExceptionCode.APPLY_HAS_IS_AGREE, agree);
        BizAssert.assertNotEmpty(MtExceptionCode.APPLY_HAS_IS_CONTENT, apprOpinion);

        ApprApply apprApply = apprApplyService.getById(id);
        if (apprApply == null) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT);
        }
        //当前状态
        Integer curState = apprApply.getCurState();
        if (curState != 1) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT_ING);
        }
        //当前审批人
        Long userId = BaseContextHandler.getAdminId();
        ApprPerson person = apprPersonService.getApprApply(apprApply.getId(), 1, apprApply.getCurUserIndex());
        if (person == null) {
            return Result.fail(MtExceptionCode.APPLY_PERSON_HAS_NOT);
        }
        Long curAprUserId = apprApply.getCurAprUserId();
        if (userId.longValue() != curAprUserId.longValue()) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT_RREACH);
        }
        person.setAgree(agree);
        person.setApprOpinion(apprOpinion);
        person.setApprTime(new Date());

        boolean isCancel = apprApply.getApplyId() != null;//是否是撤销
        //执行审批
        if (agree == 0) {//0 同意  1不同意
            apprApply.setCurUserIndex(apprApply.getCurUserIndex() + 1);
            //找到审人列表，如果没有了，就表示审批通过
            ApprPerson newPerson = apprPersonService.getApprApply(apprApply.getId(), 1, apprApply.getCurUserIndex());
            if (newPerson != null) {
                apprApply.setCurAprUserId(newPerson.getApprUserId());
                apprApply.setCurAprUserName(newPerson.getApprUserName());
            } else {
                apprApply.setCurState(3);//审批通过
                if (apprApply.getApplyId() != null) {//如果是撤销审批申请，要更新以前申请为 已撤销
                    ApprApply old = apprApplyService.getById(apprApply.getApplyId());
                    if (old != null) {
                        old.setCurState(5);
                        apprApplyService.updateByIdSelective(old);
                    }
                }
            }
        } else {
            //不同意就是驳回
            apprApply.setCurState(2);
            if (isCancel) {//如果是撤销那么以前的申请继续执行
                ApprApply oldApprApply = apprApplyService.getById(apprApply.getApplyId());
                ApprPerson newPerson = apprPersonService.getApprApply(oldApprApply.getId(), 1, oldApprApply.getCurUserIndex());
                if (newPerson != null) {
                    oldApprApply.setCurState(1);
                } else {
                    oldApprApply.setCurState(3);
                }
                apprApplyService.updateByIdSelective(oldApprApply);
            }
        }
        apprApplyService.updateByIdSelective(apprApply);
        apprPersonService.updateByIdSelective(person);
        //审批通过,去执行统计
        ApprAppWork apprAppWork = ApprAppWork.getApprAppWorkByName(apprApply.getAprType());
        if (apprApply.getCurState() == 3) {
            if (!isCancel) {
                apprAppWork.statics(apprApply.getId(), apprApply.getUnitId(), isCancel);
            } else {
                apprAppWork.statics(apprApply.getApplyId(), apprApply.getUnitId(), isCancel);
            }

        }

        //审批中发送消息通知当前审批者
        if (apprApply.getCurState() == 1) {
            //您有一条xxx的加班申请待审批。
            //您有一条王国军的加班撤销申请待审批。
            String isCancellStr = isCancel ? "撤销" : "";
            String content = "您有一条" + apprApply.getApplyUserName() + "的" + apprAppWork.chineseName + isCancellStr + "申请待审批";
            BbsAllMainMsgDTO msgDto = MsgQueueUtil.createBbsAllMainMsgDTO(apprApply.getId(), "系统自动通知", content, content);
            msgDto.setHandlerNeedIs(true);
            msgDto.setSingleHandleIs(true);
            List<Long> lookUserIds = new ArrayList<>();
            lookUserIds.add(apprApply.getCurAprUserId());
            String s = msgQueueProducer.saveMsgToUser(msgDto, null, lookUserIds);
            log.info("createApprApply发送提醒消息{},返回值:{}，lookUserIds:{},handlerUserIds:{}", JSONUtils.toJsonString(msgDto), s,null,JSONUtils.toJsonString(lookUserIds));

        }
        //处理结束 发送消息通知 申请者
        if (apprApply.getCurState() == 2 || apprApply.getCurState() == 3) {
            //您申请的加班申请已审批通过。
            //您申请的加班申请已驳回。
            //您的加班撤销申请已审批通过。
            //您的加班撤销申请已驳回。
            //String userName = BaseContextHandler.getName();
            String isCancellStr = isCancel ? "撤销" : "";
            String isPassStr = apprApply.getCurState() == 2 ? isCancellStr + "申请已驳回" : isCancellStr + "申请已审批通过";
            String title = apprAppWork.chineseName + isPassStr;
            String content = "您申请的" + apprAppWork.chineseName + isPassStr;
            BbsAllMainMsgDTO msgDto = MsgQueueUtil.createBbsAllMainMsgDTO(apprApply.getId(), "系统自动通知", title, content);
            List<Long> lookUserIds = new ArrayList<>();
            lookUserIds.add(apprApply.getApplyUserId());
            List<Long> handlerUserIds = new ArrayList<>();
            String s = msgQueueProducer.saveMsgToUser(msgDto, lookUserIds, handlerUserIds);
            log.info("createApprApply发送提醒消息{},返回值:{}，lookUserIds:{},handlerUserIds:{}", JSONUtils.toJsonString(msgDto), s,JSONUtils.toJsonString(lookUserIds),JSONUtils.toJsonString(handlerUserIds));

        }
        //更新自己受到的审批消息未已经处理了
        UpdateBacklogReqDTO updateBacklogReqDTO = MsgQueueUtil.createUpdateBacklogReqDTO(apprApply.getId(), userId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        return Result.success(true);
    }

    /**
     * 描述：撤销申请
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/13
     * 修改内容
     */

    @RequestMapping(value = "cancellApprApply", method = RequestMethod.POST)
    @ApiOperation(value = "撤销申请", notes = "撤销申请")
    @ApiResponses({
            @ApiResponse(code = 93027, message = "审批申请不存在"),
            @ApiResponse(code = 93052, message = "撤销申请不能撤销"),
            @ApiResponse(code = 93053, message = "撤销申请，不能为空"),
            @ApiResponse(code = 93054, message = "申请id，不能为空"),
            //@ApiResponse(code = 93055,message = "撤销理由，不能为空"),
            @ApiResponse(code = 93057, message = "撤销中或者已撤销的申请不能撤销"),
    })
    public Result<Boolean> saveCancellApprApply(@RequestBody CancellApprAppDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CANCELLAPPRAPPLY_CANCELLAPPRAPPDTO, dto);
        BizAssert.assertNotNull(MtExceptionCode.CANCELLAPPRAPPLY_CANCELLAPPRAPPDTO_ID, dto.getId());
        ///BizAssert.assertNotEmpty(MtExceptionCode.CANCELLAPPRAPPLY_CANCELLAPPRAPPDTO_CANCEREASONL,dto.getCanceReasonl());

        ApprApply apprApply = apprApplyService.getById(dto.getId());
        if (apprApply == null) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT);
        }
        //当前状态，撤销中或者已撤销的申请不能撤销,被驳回的也不能撤销
        Integer curState = apprApply.getCurState();
        if (curState == 2 || curState == 4 || curState == 5) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT_CACALE);
        }
        if (apprApply.getApplyId() != null) { //本身是撤销申请不能撤销
            return Result.fail(MtExceptionCode.CANCEL_CAN_NOT_CANCEL);
        }
        apprApply.setCanceReasonl(dto.getCanceReasonl());
        //当前审批为撤销中，生成新的审批申请，新申请为已经审批过源申请的人审批，如果没有人申请过，那么直接通过

        if (apprApply.getCurUserIndex() == 0) {//还没有人审批过，撤销直接成功
//            newApply.setCurState(3);
//            newApply.setCurUserIndex(null);
//            newApply.setCurAprUserName(null);
            apprApply.setCurState(5);
        } else {   //有人审批过了，新申请重走审批流程,审批过的人来审批撤销申请
            ApprApply newApply = dozerUtils.map(apprApply, ApprApply.class);
            newApply.setId(null);
            newApply.setApplyId(apprApply.getId());
            newApply.setCurUserIndex(0);
            newApply.setCanceReasonl(dto.getCanceReasonl());

            newApply.setCurState(1);
            apprApply.setCurState(4);

            //审批人和抄送人
            List<ApprPerson> apprPersons = apprPersonService.getApprPersons(apprApply.getId(), 1);
            List<ApprPerson> nowPersons = new ArrayList<>();
            for (ApprPerson p : apprPersons) {
                if (p.getApprUserIndex() < apprApply.getCurUserIndex()) {
                    nowPersons.add(p);
                    if (p.getApprUserIndex().equals(newApply.getCurUserIndex())) {
                        newApply.setCurAprUserId(p.getApprUserId());
                        newApply.setCurAprUserName(p.getApprUserName());
                    }
                }
            }
            apprApplyService.saveSelective(newApply);

            List<ApprPerson> sendPersons = apprPersonService.getApprPersons(apprApply.getId(), 2);
            apprApplyManager.saveApprAndSendPersons(newApply.getId(), dozerUtils.mapList(nowPersons, ApprApplyPersonDTO.class), dozerUtils.mapList(sendPersons, ApprApplyPersonDTO.class));
            //发送消息给当前审批人
            //您有一条王国军的加班撤销申请待审批。
            ApprAppWork apprAppWork = ApprAppWork.getApprAppWorkByName(newApply.getAprType());
            String content = "您有一条" + newApply.getApplyUserName() + "的" + apprAppWork.chineseName + "撤销申请待审批";
            BbsAllMainMsgDTO msgDto = MsgQueueUtil.createBbsAllMainMsgDTO(newApply.getId(), "系统自动通知", content, content);
            msgDto.setHandlerNeedIs(true);
            msgDto.setSingleHandleIs(true);
            List<Long> lookUserIds = new ArrayList<>();
            lookUserIds.add(newApply.getCurAprUserId());
            String s = msgQueueProducer.saveMsgToUser(msgDto, null, lookUserIds);
            log.info("createApprApply发送提醒消息{},返回值:{}，lookUserIds:{},handlerUserIds:{}", JSONUtils.toJsonString(msgDto), s,null,JSONUtils.toJsonString(lookUserIds));
        }
        apprApplyService.updateByIdSelective(apprApply);

        return Result.success(true);
    }

    /**
     * 描述：提交考勤审批
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/11
     * 修改内容：
     */

    @RequestMapping(value = "createApprApply", method = RequestMethod.POST)
    @ApiOperation(value = "提交考勤审批", notes = "提交考勤审批")
    @ApiResponses({
            @ApiResponse(code = 93032, message = "，不能为空"),
            @ApiResponse(code = 93033, message = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)，不能为空"),
            @ApiResponse(code = 93034, message = "开始时间，不能为空"),
            @ApiResponse(code = 93035, message = "结束时间，不能为空"),
            @ApiResponse(code = 93036, message = "请假类型,出差类型（从数据字典中获取name来存放），不能为空"),
            @ApiResponse(code = 93037, message = "加班内容，不能为空"),
            @ApiResponse(code = 93038, message = "请假小时，不能为空"),
            @ApiResponse(code = 93039, message = "请假事由，不能为空"),
            @ApiResponse(code = 93040, message = "出差省，不能为空"),
            @ApiResponse(code = 93041, message = "出差市，不能为空"),
            @ApiResponse(code = 93042, message = "详细地址，不能为空"),
            @ApiResponse(code = 93043, message = " 交通工具，不能为空"),
            @ApiResponse(code = 93044, message = "随行人员，不能为空"),
            @ApiResponse(code = 93045, message = " 联系电话，不能为空"),
            @ApiResponse(code = 93046, message = "出差 小时，不能为空"),
            @ApiResponse(code = 93047, message = "出差事由，不能为空"),
            @ApiResponse(code = 93048, message = "补签类型(1:签到、2:签退)，不能为空"),
            @ApiResponse(code = 93049, message = "补签日期，不能为空"),
            @ApiResponse(code = 93050, message = "补签理由，不能为空"),
            @ApiResponse(code = 93051, message = "外出描述,不能为空"),
            @ApiResponse(code = 93056, message = "加班申请不能跨天"),
            @ApiResponse(code = 93061, message = "审批人不能为空"),
    })
    public Result<Boolean> saveCreateApprApply(@RequestBody CreateApprApplyDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_APRTYPE, dto.getAprType());
        BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_APPRR_PERSON, dto.getApprPersons());
        //审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
        ApprAppWork apprAppWorkByName = ApprAppWork.getApprAppWorkByName(dto.getAprType());
        if (apprAppWorkByName == null) {
            return Result.fail("审批类型错误");
        }
        //开启审批流程
        Long userId = BaseContextHandler.getAdminId();
        CreateApprApply createApprApply = new CreateApprApply(dto.getAprType(), dto.getApprPersons(), dto.getSendPersons());
        Long applyId = apprApplyManager.addApprApplyt(userId, createApprApply);
        //创建保存业务数据
        Long id = apprAppWorkByName.createApprApp(dto, applyId);

        //图片

        if (dto.getImages() != null && dto.getImages().size() > 0) {
            List<File> files = dozerUtils.mapList(dto.getImages(), File.class);
            for (File f : files) {
                f.setTableId(id);
                f.setCreateUser(userId);
            }
            fileService.save(files);
        }
        //发送消息通知
        //您有一条xxx的加班申请待审批。
        //发给当前审批人，当前审批人审批通过后发给下一个审批人，审批结束后才发给所有的抄送人
        String userName = BaseContextHandler.getName();
        String title = apprAppWorkByName.chineseName + "申请待审批";
        String content = "您有一条" + userName + "的" + apprAppWorkByName.chineseName + "申请待审批";
        BbsAllMainMsgDTO msgDto = MsgQueueUtil.createBbsAllMainMsgDTO(applyId, "系统自动通知", title, content);
        msgDto.setHandlerNeedIs(true);
        msgDto.setSingleHandleIs(true);
        List<Long> lookUserIds = new ArrayList<>();
        lookUserIds.add(dto.getApprPersons().get(0).getApprUserId());
        //List<Long> handlerUserIds = new ArrayList<>();
        String s = msgQueueProducer.saveMsgToUser(msgDto, null, lookUserIds);
        log.info("createApprApply发送提醒消息{},返回值:{}，lookUserIds:{},handlerUserIds:{}", JSONUtils.toJsonString(msgDto), s,null,JSONUtils.toJsonString(lookUserIds));
        return Result.success(true);
    }

    /**
     * 描述：查看审批详情
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/11
     * 修改内容：
     */

    @RequestMapping(value = "getApprApplyInfo", method = RequestMethod.GET)
    @ApiOperation(value = "查看审批详情", notes = "查看审批详情")
    @ApiResponses({
            @ApiResponse(code = 93026, message = "审批id不能为空"),
            @ApiResponse(code = 93027, message = "审批申请不存在"),
    })
    public Result<ApprApplyInfoDTO> saveGetApprApplyInfo(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.APPLYID_HAS_NOT, id);
        ApprApply apprApply = apprApplyService.getById(id);
        if (apprApply == null) {
            return Result.fail(MtExceptionCode.APPLY_HAS_NOT);
        }
        ApprApplyInfoDTO res = new ApprApplyInfoDTO();
        res.setId(apprApply.getId());
        res.setApplyName(apprApply.getApplyUserName());
        res.setAprType(apprApply.getAprType());
        res.setApplyUserId(apprApply.getApplyUserId());
        res.setCurState(apprApply.getCurState());
        res.setApplyId(apprApply.getApplyId());
        res.setCanceReasonl(apprApply.getCanceReasonl());
        res.setCreateTime(apprApply.getCreateTime());
        //设置各个业务相关的基本信息
        ApprAppWork apprAppWork = ApprAppWork.getApprAppWorkByName(apprApply.getAprType());
        Long workId = null;
        if (apprApply.getApplyId() != null) {//如果是撤销，那么业务数据的申请id是元 原来的申请id
            workId = apprAppWork.setWorkInfo(apprApply.getApplyId(), res);
        } else {
            workId = apprAppWork.setWorkInfo(id, res);
        }
        //抄送人
        List<ApprPerson> sendPersons = apprPersonService.getApprPersons(id, 2);
        //  example.setOrderByClause("sort_value asc");
        List<ApprApplyPersonDTO> sendRes = dozerUtils.mapList(sendPersons, ApprApplyPersonDTO.class);
        res.setSendPersons(sendRes);
        //审批记录
        List<ApprPerson> apprPersons = apprPersonService.getApprPersons(id, 1);
//        Collections.sort(apprPersons, new Comparator<ApprPerson>() {
//            
//            public int compare(ApprPerson o1, ApprPerson o2) {
//                return o1.getApprUserIndex().compareTo(o2.getApprUserIndex());
//            }
//        });
        List<ApprApplyRecodeDTO> applyRecodes = dozerUtils.mapList(apprPersons, ApprApplyRecodeDTO.class);
        res.setApplyRecodes(applyRecodes);
        //附件信息
        FileExample fileExample = new FileExample();
        FileExample.Criteria fileCriteria = fileExample.createCriteria();
        fileCriteria.andTableIdEqualTo(workId);
        List<File> files = fileService.find(fileExample);
        List<FileDTO> resfiles = dozerUtils.mapList(files, FileDTO.class);
        res.setFiles(resfiles);
        //如果是看当前到自己的审批的，就更新是否已读
        Long userId = BaseContextHandler.getAdminId();
        if (apprApply.getCurAprUserId().equals(userId) && apprApply.getCurState() == 1) {
            for (ApprPerson ap : apprPersons) {
                if (ap.getApprUserId().equals(userId)) {
                    ap.setIsRead(1);
                    apprPersonService.updateByIdSelective(ap);
                    break;
                }
            }
        }
        return Result.success(res);
    }

    /**
     * 描述：查询默认审批人
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/12
     * 修改内容：
     */

    @RequestMapping(value = "getDefaultPerson", method = RequestMethod.GET)
    @ApiOperation(value = "查询默认审批人和抄送人", notes = "查询默认审批人和抄送人")
    @ApiResponses({
            @ApiResponse(code = 93033, message = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)，不能为空"),
    })
    public Result<DefaultPersonDTO> getDefaultPerson(@RequestParam("aprType") String aprType) {
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_APRTYPE, aprType);
        //审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
        ApprAppWork apprAppWorkByName = ApprAppWork.getApprAppWorkByName(aprType);
        if (apprAppWorkByName == null) {
            return Result.fail("审批类型错误");
        }
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);
        ApprApply apprApply = apprApplyService.findLastApplyByAprType(userId, unitId, aprType);
        if (apprApply == null) {
            return Result.success(null);
        }
        DefaultPersonDTO dpd = new DefaultPersonDTO();
        //抄送人
        List<ApprPerson> sendPersons = apprPersonService.getApprPersons(apprApply.getId(), 2);
        List<ApprApplyPersonDTO> sendRes = dozerUtils.mapList(sendPersons, ApprApplyPersonDTO.class);
        //审批人
        List<ApprPerson> apprPersons = apprPersonService.getApprPersons(apprApply.getId(), 1);
        List<ApprApplyPersonDTO> applys = dozerUtils.mapList(apprPersons, ApprApplyPersonDTO.class);

        dpd.setSendPersons(sendRes);
        dpd.setApprPersons(applys);
        //设置头像
        /*ArrayList<Long> uids = new ArrayList<>();
        for (ApprApplyPersonDTO aa : sendRes) {
            uids.add(aa.getApprUserId());
        }
        for (ApprApplyPersonDTO aa : applys) {
            uids.add(aa.getApprUserId());
        }
        Result<Map<Long, UserResDTO>> res = userOpenApi.findUserByIdList(uids);
        if (res.isSuccess()) {
            Map<Long, UserResDTO> data = res.getData();
            for (ApprApplyPersonDTO aad : sendRes) {
                UserResDTO userResDTO = data.get(aad.getApprUserId());
                if (userResDTO != null) {
                    aad.setPhoto(userResDTO.getPhoto());
                }
            }
            for (ApprApplyPersonDTO aad : applys) {
                UserResDTO userResDTO = data.get(aad.getApprUserId());
                if (userResDTO != null) {
                    aad.setPhoto(userResDTO.getPhoto());
                }
            }
        } else {
            log.error("调用 UserOpenApi的方法findUserByIdList失败，返回消息:" + res.getErrmsg());
        }*/
        return Result.success(dpd);
    }


    /**
     * 描述：查询当前待我审批的数量
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/7
     * 修改内容：
     */

    @RequestMapping(value = "geCurSendMeCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询当前待我审批的数量", notes = "查询当前待我审批的数量")
    public Result<Integer> getCurSendMeCount() {
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);

        Map<String, Object> param = new HashMap<>();
        param.put("personId", userId);
        param.put("unitId", unitId);
        int count = apprApplyService.getCurSendMeApplyCount(userId, unitId);
        log.info("查询当前待我审批的数{}", count);
        return Result.success(count);
    }
}
