package com.hengyunsoft.platform.developer.impl.fast;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.api.fast.api.WorkApproveApi;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveBusinessDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveExtraDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveLeaveDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveRecordDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestWorkApproveSupplyDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.ResponseWorkApproveDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.WorkApproveBusinessDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.WorkApproveExtraDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.WorkApproveLeaveDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.WorkApproveRecordDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.WorkApproveSupplyDTO;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApprove;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveBusiness;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveExtra;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveLeave;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveRecord;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveSupply;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveBusinessExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveExtraExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveLeaveExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveRecordExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveSupplyExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveBusinessService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveExtraService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveLeaveService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApprovePersonService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveRecordService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveSupplyService;
import com.hengyunsoft.platform.msgs.dto.msg.BacklogDTO;
import com.hengyunsoft.platform.msgs.dto.msg.BacklogSaveDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
//import com.hengyunsoft.platform.msgs.open.msg.BacklogApi;
import com.hengyunsoft.platform.sms.api.SmsRecordApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "API - AttenceApiImpl", description = "考勤审批管理")
@RestController
@RequestMapping("/attence")
@Slf4j
public class WorkApproveApiImpl implements WorkApproveApi {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private WorkApproveService workApproveService;
    @Autowired
    private WorkApprovePersonService workApprovePersonService;
    @Autowired
    private WorkApproveBusinessService workApproveBusinessService;
    @Autowired
    private WorkApproveExtraService workApproveExtraService;
    @Autowired
    private WorkApproveSupplyService workApproveSupplyService;
    @Autowired
    private WorkApproveLeaveService workApproveLeaveService;
    @Autowired
    private WorkApproveRecordService workApproveRecordService;
    @Autowired
    private UserService userService;
//    @Autowired
//    private BacklogApi backlogApi;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private SmsRecordApi smsRecordApi;

    @Value("${fast-url}")
    private String fastUrl;

    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    @ApiOperation(value = "审批列表查询", notes = "审批列表查询")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/findBy", method = RequestMethod.POST)
    public Result<PageInfo<ResponseWorkApproveDTO>> statisticFind(@RequestBody OpenApiReq<RequestWorkApproveDTO> openApiReq) {

        try {
            String approvalType = "";
            Date startDate = null;
            Date endDate = null;
            if (openApiReq.getData() != null) {
                if (!StringUtils.isBlank(openApiReq.getData().getApprovalType())) {
                    approvalType = openApiReq.getData().getApprovalType();
                }
                if (!StringUtils.isBlank(openApiReq.getData().getStartDate())) {
                    String startD = openApiReq.getData().getStartDate() + " 00:00:00";
                    startDate = sf.parse(startD);
                }
                if (!StringUtils.isBlank(openApiReq.getData().getEndDate())) {
                    String endD = openApiReq.getData().getEndDate() + " 23:59:59";
                    endDate = sf.parse(endD);
                }
            }
            Long loginUser = BaseContextHandler.getAdminId();
            List<WorkApprove> resultList = null;
            WorkApproveExample example = new WorkApproveExample();
            WorkApproveExample.Criteria criteria = example.createCriteria();


            if (startDate != null && endDate != null) {
                if ("1".equals(approvalType)) {
                    //查询我发出的
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andApplyTimeBetween(startDate, endDate)
                            .andCreateUserEqualTo(loginUser);
                } else if ("2".equals(approvalType)) {
                    //查询待我审批的
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andApplyTimeBetween(startDate, endDate)
                            .andCurrentAproveUserIdEqualTo(loginUser);
                } else {
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andApplyTimeBetween(startDate, endDate);
                }

            } else {
                if ("1".equals(approvalType)) {
                    //查询我发出的
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andCreateUserEqualTo(loginUser)
                            .andIdIsNotNull();
                } else if ("2".equals(approvalType)) {
                    //查询待我审批的
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andCurrentAproveUserIdEqualTo(loginUser)
                            .andIdIsNotNull();
                } else {
                    criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andIdIsNotNull();
                }
            }
            example.setOrderByClause("apply_time desc");
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            resultList = workApproveService.find(example);
            List<WorkApprove> returnList = new ArrayList<WorkApprove>();
            if (resultList != null) {
                for (WorkApprove workApprove : resultList) {
                    WorkApprove curObj = workApprove;
                    UserExample exampleUser = new UserExample();
                    example.createCriteria().andIdEqualTo(workApprove.getApplyUserId());
                    User user = userService.getUnique(exampleUser);
                    if (user != null) {
                        curObj.setApplyUserName(user.getName());
                    }
                    returnList.add(curObj);
                }
            }
            return Result.success(new PageInfo<>(dozerUtils.mapPage(returnList, ResponseWorkApproveDTO.class)));
        } catch (Exception ex) {
            return Result.fail("查询错误");
        }
    }


    @Override
    @ApiOperation(value = "出差审批保存", notes = "出差审批保存")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/businesssave", method = RequestMethod.POST)
    public Result<Boolean> workApproveBusinessSave(@RequestBody RequestWorkApproveBusinessDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        String loginName = BaseContextHandler.getName();
        WorkApprove workApprove = new WorkApprove();
        workApprove.setAppId(dto.getAppId());
        workApprove.setAproveCode("SP" + System.currentTimeMillis());
        workApprove.setAproveType("2");
        workApprove.setApplyTime(new Date());
        workApprove.setCurrentState(dto.getCurrentAproveUserName() + "审批");
        workApprove.setCurrentAproveUserId(dto.getCurrentAproveUserId()); //当前环节审批人
        workApprove.setCurrentAproveUserOperation(dto.getCurrentAproveUserOperation());
        workApprove.setAproveState(dto.getAproveState());
        workApprove.setInAprove(dto.getInAprove());
        workApprove.setApplyUserId(loginUser);
        workApprove.setApplyUserName(loginName);
        workApprove.setCreateUser(loginUser);
        workApprove.setUpdateUser(loginUser);
        WorkApprove resultObj = workApproveService.saveSelective(workApprove);
        WorkApproveBusiness workApproveBusiness = dozerUtils.map(dto, WorkApproveBusiness.class);
        workApproveBusiness.setAproveId(resultObj.getId());
        workApproveBusinessService.saveSelective(workApproveBusiness);

        BacklogSaveDTO backlog = new BacklogSaveDTO();
        backlog.setCreateUserId(loginUser);
        backlog.setCreateUser(loginName);
        backlog.setReceiverId(dto.getCurrentAproveUserId());
        backlog.setTask("出差审批");
        backlog.setTaskLink(workApprove.getCurrentState());
        backlog.setTaskUrl(fastUrl + "/fast/" + dto.getAppId() + "?url=/gxqpt-fast/fast/" + dto.getAppId() + "/workapprove/list");
        if (StringUtils.isNotEmpty(dto.getAppId())) {
            ApplicationExample example = new ApplicationExample();
            example.createCriteria().andAppIdEqualTo(dto.getAppId());
            Application application = applicationService.getUnique(example);
            backlog.setTaskSource(application != null ? application.getName() : "快速开发平台");
        }
        backlog.setTaskNum(1);
//        Result<BacklogDTO> result = backlogApi.addBacklog(backlog);
//        if (result.isSuccess() && result.getData() != null) {
//            Long bcaklogId = result.getData().getId();
//            WorkApprove workApproveUpdate = new WorkApprove();
//            workApproveUpdate.setId(resultObj.getId());
//            workApproveUpdate.setBacklogId(bcaklogId);
//            workApproveService.updateByIdSelective(workApproveUpdate);
//        }

        //发送短信
        String topic = dto.getCurrentAproveUserName() + "出差审批";
        sendMsg(dto.getCurrentAproveUserId(), dto.getAppId(), dto.getCurrentAproveUserName(), topic);
        return Result.success(true);
    }

    /**
     * 发送考勤审批处理短信通知
     *
     * @param currentAproveUserId
     * @param appId
     * @param currentAproveUserName
     * @param topic
     */
    private void sendMsg(Long currentAproveUserId, String appId, String currentAproveUserName, String topic) {
        //获取审批人信息
        User user = userService.getById(currentAproveUserId);
        if(user == null){
            return;
        }
        String loginName = BaseContextHandler.getName();
        String uPhone = user.getPhone();
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setAppId(appId);
        messageDTO.setAppName("快速开发系统考勤审批");
        messageDTO.setSender(loginName);
        messageDTO.setReceiver(uPhone);
        messageDTO.setTopic(topic);
        messageDTO.setChannelId("{\"Sms\":\"123\"}");
        messageDTO.setTemplateId("666");

        //组装发送短信内容
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", currentAproveUserName);//信息接收人名字
        map.put("name", "考勤出差审批");//信息内容
        map.put("desc", "高新区一体化系统进入待办主页");//信息描述
        String jsonStr = JSON.toJSONString(map);
        messageDTO.setTemplateParams(jsonStr);

        //存在手机号，发送短信
        if (StringUtils.isNotEmpty(uPhone)) {
            Result<String> res = smsRecordApi.addSmsRecord(messageDTO);
            log.info("res={} ", res.toString());
            if (res.isSuccess() && res.getData() != null) {
                log.info("用户名：{}，手机号码：{}，发送短信成功!!", currentAproveUserName, uPhone, res.getErrmsg());
            } else {
                log.info("用户名：{}，手机号码：{}，发送短信失败!!", currentAproveUserName, uPhone, res.getErrmsg());
            }
        }
    }

    @Override
    @ApiOperation(value = "出差审批更新", notes = "出差审批更新")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/businessupdate", method = RequestMethod.POST)
    public Result<Integer> workApproveBusinessUpdate(@RequestBody RequestWorkApproveBusinessDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        WorkApproveBusiness workApproveBusiness = dozerUtils.map(dto, WorkApproveBusiness.class);
        workApproveBusiness.setUpdateTime(new Date());
        workApproveBusiness.setUpdateUser(loginUser);
        Integer result = workApproveBusinessService.updateByIdSelective(workApproveBusiness);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "出差审批查询", notes = "出差审批查询")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/businessview", method = RequestMethod.POST)
    public Result<WorkApproveBusinessDTO> workApproveBusinessById(Long approveId) {
        WorkApproveBusinessExample example = new WorkApproveBusinessExample();
        example.createCriteria().andAproveIdEqualTo(approveId);
        WorkApproveBusiness workApproveBusiness = workApproveBusinessService.getUnique(example);
        WorkApproveBusinessDTO result = dozerUtils.map(workApproveBusiness, WorkApproveBusinessDTO.class);
        result.setApproveRecord(getApproveRecord(approveId));
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "加班审批保存", notes = "加班审批保存")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/extrasave", method = RequestMethod.POST)
    public Result<Boolean> workApproveExtraSave(@RequestBody RequestWorkApproveExtraDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        String loginName = BaseContextHandler.getName();
        WorkApprove workApprove = new WorkApprove();
        workApprove.setAppId(dto.getAppId());
        workApprove.setAproveCode("SP" + System.currentTimeMillis());
        workApprove.setAproveType("4");
        workApprove.setApplyTime(new Date());
        workApprove.setCurrentState(dto.getCurrentAproveUserName() + "审批");
        workApprove.setCurrentAproveUserId(dto.getCurrentAproveUserId());  //
        workApprove.setCurrentAproveUserOperation(dto.getCurrentAproveUserOperation());
        workApprove.setAproveState(dto.getAproveState());
        workApprove.setInAprove(dto.getInAprove());
        workApprove.setApplyUserId(loginUser);
        workApprove.setApplyUserName(loginName);
        WorkApprove resultObj = workApproveService.saveSelective(workApprove);
        WorkApproveExtra workApproveExtra = dozerUtils.map(dto, WorkApproveExtra.class);
        workApproveExtra.setApproveId(resultObj.getId());
        workApproveExtraService.saveSelective(workApproveExtra);

        BacklogSaveDTO backlog = new BacklogSaveDTO();
        backlog.setCreateUserId(loginUser);
        backlog.setCreateUser(loginName);
        backlog.setReceiverId(dto.getCurrentAproveUserId());
        backlog.setTask("加班审批");
        backlog.setTaskLink(workApprove.getCurrentState());
        backlog.setTaskUrl(fastUrl + "/fast/" + dto.getAppId() + "?url=/gxqpt-fast/fast/" + dto.getAppId() + "/workapprove/list");
        if (StringUtils.isNotEmpty(dto.getAppId())) {
            ApplicationExample example = new ApplicationExample();
            example.createCriteria().andAppIdEqualTo(dto.getAppId());
            Application application = applicationService.getUnique(example);
            backlog.setTaskSource(application != null ? application.getName() : "快速开发平台");
        }
        backlog.setTaskNum(1);
//        Result<BacklogDTO> result = backlogApi.addBacklog(backlog);
//        if (result.isSuccess() && result.getData() != null) {
//            Long bcaklogId = result.getData().getId();
//            WorkApprove workApproveUpdate = new WorkApprove();
//            workApproveUpdate.setId(resultObj.getId());
//            workApproveUpdate.setBacklogId(bcaklogId);
//            workApproveService.updateByIdSelective(workApproveUpdate);
//        }

        //发送短信
        String topic = dto.getCurrentAproveUserName() + "加班审批";
        sendMsg(dto.getCurrentAproveUserId(), dto.getAppId(), dto.getCurrentAproveUserName(), topic);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "加班审批更新", notes = "加班审批更新")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/extraupdate", method = RequestMethod.POST)
    public Result<Integer> workApproveExtraUpdate(@RequestBody RequestWorkApproveExtraDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        WorkApproveExtra workApproveExtra = dozerUtils.map(dto, WorkApproveExtra.class);
        workApproveExtra.setUpdateTime(new Date());
        workApproveExtra.setUpdateUser(loginUser);
        Integer result = workApproveExtraService.updateByIdSelective(workApproveExtra);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "加班审批查询", notes = "加班审批查询")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/extraview", method = RequestMethod.POST)
    public Result<WorkApproveExtraDTO> workApproveExtraById(Long approveId) {
        WorkApproveExtraExample example = new WorkApproveExtraExample();
        example.createCriteria().andApproveIdEqualTo(approveId);
        WorkApproveExtra workApproveExtra = workApproveExtraService.getUnique(example);
        WorkApproveExtraDTO result = dozerUtils.map2(workApproveExtra, WorkApproveExtraDTO.class);
        WorkApprove workap = workApproveService.getById(approveId);

        result.setCurrentAproveUserId(workap.getCurrentAproveUserId());
        result.setCurrentAproveUserOperation(workap.getCurrentAproveUserOperation());

        result.setApproveRecord(getApproveRecord(approveId));
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "请假审批保存", notes = "请假审批保存")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/leavesave", method = RequestMethod.POST)
    public Result<Boolean> workApproveLeaveSave(@RequestBody RequestWorkApproveLeaveDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        String loginName = BaseContextHandler.getName();
        WorkApprove workApprove = new WorkApprove();
        workApprove.setAppId(dto.getAppId());
        workApprove.setAproveCode("SP" + System.currentTimeMillis());
        workApprove.setAproveType("1");
        workApprove.setApplyTime(new Date());
        workApprove.setCurrentAproveUserId(dto.getCurrentAproveUserId());
        workApprove.setCurrentAproveUserOperation(dto.getCurrentAproveUserOperation());
        workApprove.setAproveState(dto.getAproveState());
        workApprove.setInAprove(dto.getInAprove());
        workApprove.setApplyUserId(loginUser);
        workApprove.setApplyUserName(loginName);
        WorkApprove resultObj = workApproveService.saveSelective(workApprove);
        WorkApproveLeave workApproveLeave = dozerUtils.map(dto, WorkApproveLeave.class);
        workApproveLeave.setAproveId(resultObj.getId());
        workApproveLeaveService.saveSelective(workApproveLeave);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "请假审批更新", notes = "请假审批更新")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/leaveupdate", method = RequestMethod.POST)
    public Result<Integer> workApproveLeaveUpdate(@RequestBody RequestWorkApproveLeaveDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        WorkApproveLeave workApproveLeave = dozerUtils.map(dto, WorkApproveLeave.class);
        workApproveLeave.setUpdateTime(new Date());
        workApproveLeave.setUpdateUser(loginUser);
        Integer result = workApproveLeaveService.updateByIdSelective(workApproveLeave);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "请假审批查询", notes = "请假审批查询")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/leaveview", method = RequestMethod.POST)
    public Result<WorkApproveLeaveDTO> workApproveLeaveById(Long approveId) {
        WorkApproveLeaveExample example = new WorkApproveLeaveExample();
        example.createCriteria().andAproveIdEqualTo(approveId);
        WorkApproveLeave workApproveLeave = workApproveLeaveService.getUnique(example);
        WorkApproveLeaveDTO result = dozerUtils.map(workApproveLeave, WorkApproveLeaveDTO.class);
        result.setApproveRecord(getApproveRecord(approveId));
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "普通审批保存", notes = "普通审批保存")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/supplysave", method = RequestMethod.POST)
    public Result<Boolean> workApproveSupplySave(@RequestBody RequestWorkApproveSupplyDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        String loginName = BaseContextHandler.getName();
        WorkApprove workApprove = new WorkApprove();
        workApprove.setAppId(dto.getAppId());
        workApprove.setAproveCode("SP" + System.currentTimeMillis());
        workApprove.setAproveType("3");
        workApprove.setApplyTime(new Date());
        workApprove.setCurrentAproveUserId(dto.getCurrentAproveUserId());
        workApprove.setCurrentAproveUserOperation(dto.getCurrentAproveUserOperation());
        workApprove.setAproveState(dto.getAproveState());
        workApprove.setInAprove(dto.getInAprove());
        workApprove.setApplyUserId(loginUser);
        workApprove.setApplyUserName(loginName);
        WorkApprove resultObj = workApproveService.saveSelective(workApprove);
        WorkApproveSupply workApproveSupply = dozerUtils.map(dto, WorkApproveSupply.class);
        workApproveSupply.setApprId(resultObj.getId());
        workApproveSupplyService.saveSelective(workApproveSupply);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "普通审批更新", notes = "普通审批更新")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/supplyupdate", method = RequestMethod.POST)
    public Result<Integer> workApproveSupplyUpdate(@RequestBody RequestWorkApproveSupplyDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        WorkApproveSupply workApproveSupply = dozerUtils.map(dto, WorkApproveSupply.class);
        workApproveSupply.setUpdateTime(new Date());
        workApproveSupply.setUpdateUser(loginUser);
        Integer result = workApproveSupplyService.updateByIdSelective(workApproveSupply);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "普通审批查询", notes = "普通审批查询")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/supplyview", method = RequestMethod.POST)
    public Result<WorkApproveSupplyDTO> workApproveSupplyById(Long approveId) {
        WorkApproveSupplyExample example = new WorkApproveSupplyExample();
        example.createCriteria().andApprIdEqualTo(approveId);
        WorkApproveSupply workApproveSupply = workApproveSupplyService.getUnique(example);
        WorkApproveSupplyDTO result = dozerUtils.map(workApproveSupply, WorkApproveSupplyDTO.class);
        result.setApproveRecord(getApproveRecord(approveId));
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "保存审批意见", notes = "保存审批意见")
    @ApiResponses({})
    @RequestMapping(value = "/workapprove/recordSave", method = RequestMethod.POST)
    public Result<Boolean> workApproveRecordSave(@RequestBody RequestWorkApproveRecordDTO dto) {
        String userName = BaseContextHandler.getName();
        //修改审批记录状态
        WorkApprove workApprove = new WorkApprove();
        //o.currentAproveUserId = $("#addPerson_ccspEmp").val();   //下一个审批人id  （null 发起人）
        //o.currentAproveUserName = $("#addPerson_ccspEmpName").val();   //下一个审批人name
        //o.currentAproveUserOperation = "1";  //等待审批
        //o.aproveState = "1";  //审批状态("0"为未提交，”1“为已提交)
        //o.inAprove = "0";//是否已经审批过("0":还未审批过，"1"已经审批过)

        //当前环节审批人操作("1"为等待审批,"2"为同意审批，"3"拒绝审批)
        if ("2".equalsIgnoreCase(dto.getCurrentAproveUserOperation())) {
            workApprove.setCurrentState("结束");
        } else if ("3".equalsIgnoreCase(dto.getCurrentAproveUserOperation())) {
            workApprove.setCurrentState(userName + "驳回");
        }
        workApprove.setCurrentAproveUserId(-1L);

        workApprove.setId(dto.getApprId());
        workApprove.setCurrentAproveUserOperation(dto.getCurrentAproveUserOperation());
        workApprove.setAproveState("1");
        workApprove.setInAprove(dto.getInAprove());
        workApproveService.updateByIdSelective(workApprove);
        //新增审批数据
        WorkApproveRecord workApproveRecord = dozerUtils.map(dto, WorkApproveRecord.class);
        workApproveRecordService.saveSelective(workApproveRecord);


        WorkApprove wa = workApproveService.getById(dto.getApprId());
        if (wa != null && wa.getBacklogId() != null) {
            //获取申请人信息
            /*User user = userService.getById(wa.getApplyUserId());
            String uName = user.getName();
            String uPhone = user.getPhone();*/
//            backlogApi.updateBacklogStatus(wa.getBacklogId());
        }
        return Result.success(true);
    }

    //获取审批记录
    private WorkApproveRecordDTO getApproveRecord(Long approveId) {
        WorkApproveRecordExample example = new WorkApproveRecordExample();
        example.createCriteria().andApprIdEqualTo(approveId);
        WorkApproveRecord workApproveRecord = workApproveRecordService.getUnique(example);
        return dozerUtils.map(workApproveRecord, WorkApproveRecordDTO.class);
    }

}
