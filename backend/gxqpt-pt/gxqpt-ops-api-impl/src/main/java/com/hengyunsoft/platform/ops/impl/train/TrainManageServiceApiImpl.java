package com.hengyunsoft.platform.ops.impl.train;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.entity.train.dos.*;
import com.hengyunsoft.platform.ops.entity.train.po.TrainDirectory;
import com.hengyunsoft.platform.ops.entity.train.po.TrainManage;
import com.hengyunsoft.platform.ops.impl.utils.OpsCode;
import com.hengyunsoft.platform.ops.impl.utils.OpsCodeUtil;
import com.hengyunsoft.platform.ops.impl.utils.PushSuperviseTemp;
import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;
import com.hengyunsoft.platform.ops.repository.file.service.OperationFileService;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.platform.ops.repository.train.example.TrainDirectoryExample;
import com.hengyunsoft.platform.ops.repository.train.service.TrainDirectoryService;
import com.hengyunsoft.platform.ops.repository.train.service.TrainManageService;
import com.hengyunsoft.platform.ops.servicedto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/train")
@Api(value = "API - TrainManageServiceImpl", description = "培训管理")
public class TrainManageServiceApiImpl {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private TrainManageService trainManageService;
    @Autowired
    private DealUserService dealUserService;
    @Autowired
    private TrainDirectoryService trainDirectoryService;
    @Autowired
    private OperationFileService operationFileService;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    @Autowired
    private PersonService personService;
    @Autowired
    private BbbMsgQueueProducer bbbMsgQueueProducer;
    @Autowired
    private AlarmInformationService alarmInformationService;
    @Autowired
    PushSuperviseTemp pushSuperviseTemp;
    /**
     * 驳回状态值
     */
    private Integer one = 1;

    /**
     * 获取培训课程目录分页列表
     *
     * @return
     */
    @ApiOperation(value = "获取培训课程目录分页列表", notes = "获取培训课程目录分页列表")
    @RequestMapping(value = "/typePage", method = RequestMethod.POST)
    public Result<PageInfo<TrainTypePageResDTO>> getTypeList(@RequestBody OpenApiReq<TrainTypePageReqDTO> openApiReq) {
        try {
            TrainTypePageReqDTO trainTypePageReqDTO = openApiReq.getData();
            if (trainTypePageReqDTO == null) {
                return Result.fail("参数错误");
            }
            String context = trainTypePageReqDTO.getContext();
            trainTypePageReqDTO.setContext(BaseExample.fullLike(context));
            TrainTypePageReqDO trainTypePageReqDO = dozerUtils.map(trainTypePageReqDTO, TrainTypePageReqDO.class);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<TrainTypePageResDO> list = trainDirectoryService.getTypeTree(trainTypePageReqDO);
            List<TrainTypePageResDTO> result = dozerUtils.mapPage(list, TrainTypePageResDTO.class);
            return Result.success(new PageInfo<>(result));
        } catch (Exception e) {
            log.error("获取培训课程目录分页列表异常：" + e);
            return Result.fail("获取培训课程目录分页列表失败");
        }
    }

    /**
     * 获取培训名称列表
     *
     * @return
     */
    @ApiOperation(value = "获取培训名称列表", notes = "获取培训名称列表")
    @RequestMapping(value = "type/list", method = RequestMethod.GET)
    public Result<List<TrainTypeDTO>> getTrainNameList() {
        try {
            List<TrainTypeDTO> list = new ArrayList<TrainTypeDTO>();
            TrainDirectoryExample example = new TrainDirectoryExample();
            example.createCriteria().andServiceNameIsNotNull().andTypeNotEqualTo("自定义培训");
            List<TrainDirectory> train = trainDirectoryService.find(example);
            Set<String> types = new HashSet<String>();
            for (TrainDirectory trainDirectory : train) {
                String type = trainDirectory.getType();
                types.add(type);
            }
            for (String type : types) {
                TrainTypeDTO trainTypeDTO = new TrainTypeDTO();
                trainTypeDTO.setType(type);
                List<String> names = new ArrayList<String>();
                for (TrainDirectory trainDirectory : train) {
                    String trainType = trainDirectory.getType();
                    String name = trainDirectory.getServiceName();
                    if (trainType != null && trainType.equals(type) && !StringUtils.isEmpty(name)) {
                        names.add(name);
                    }
                }
                trainTypeDTO.setNames(names);
                list.add(trainTypeDTO);
            }
            return Result.success(list);
        } catch (Exception e) {
            log.error("获取培训名称列表异常：" + e);
            return Result.fail("获取培训名称列表失败");
        }
    }

    /**
     * 培训申请
     *
     * @return
     */
    @ApiOperation(value = "培训申请", notes = "培训申请")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Result<TrainManage> saveTrainManage(@RequestBody TrainManageDTO trainManageDTO) {
        try {
            if (trainManageDTO == null) {
                return Result.fail("参数错误");
            }
            TrainManage trainManage = new TrainManage();
            String applyCode = OpsCodeUtil.automaticCode("PX");
            trainManage.setId(trainManageService.genId());
            trainManage.setCreateTime(new Date());
            trainManage.setCreateUser(BaseContextHandler.getAdminId());
            trainManage.setStatus(1);
            trainManage.setApplyCode(applyCode);
            trainManage.setTrainAddress(trainManageDTO.getTrainAddress());
            trainManage.setTrainInfo(trainManageDTO.getTrainInfo());
            trainManage.setTrainTime(trainManageDTO.getTrainTime());
            trainManage.setTrainType(trainManageDTO.getTrainType());
            trainManage.setTrainName(trainManageDTO.getTrainName());
            trainManage.setSubDept(trainManageDTO.getCompany());
            trainManage.setSubPerson(BaseContextHandler.getName());
            TrainManage result = trainManageService.save(trainManage);
            //发送消息给审核人
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setBizId(String.valueOf(result.getId()));
            bbsAllMainMsgDTO.setBizType("train_apply");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setBriefTpye("work_audit");
            bbsAllMainMsgDTO.setDetailedType("train_apply");
            bbsAllMainMsgDTO.setDetailedTypeDesc("培训审核");
            bbsAllMainMsgDTO.setTitle("培训审核");
            bbsAllMainMsgDTO.setContent("您有一条" + result.getTrainName() + "申请待审核。");
            bbsAllMainMsgDTO.setSenderName(BaseContextHandler.getName());
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/trainAudit");
            bbsAllMainMsgDTO.setSingleHandleIs(true);
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            String errorMsg = bbbMsgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO, "app_approval", BaseContextHandler.getAppId());
            if (errorMsg != null) {
                log.error("培训申请异常：" + errorMsg);
            }
            //推送到统一监管
            pushSuperviseTemp.pushSupervise(trainManage.getId(), new Date(), null, OpsCode.TRAIN_CODE.getCode(),
                    OpsCode.TRAIN_CODE.getName(), OpsCode.TRAIN_CODE.getDescribe());
            return Result.success(result);
        } catch (Exception e) {
            log.error("培训申请异常：" + e);
            return Result.fail("培训申请失败");
        }
    }

    /**
     * 处理培训申请
     *
     * @return
     */
    @ApiOperation(value = "处理培训申请", notes = "处理培训申请")
    @RequestMapping(value = "handle/apply", method = RequestMethod.POST)
    public Result<Boolean> saveHandleApply(@RequestBody TrainHandleDTO trainHandleDTO) {
        try {
            if (trainHandleDTO == null || trainHandleDTO.getId() == null) {
                return Result.fail("参数错误");
            }
            Long id = trainHandleDTO.getId();
            Long userid = BaseContextHandler.getAdminId();
            TrainManage trainManage = trainManageService.getById(id);
            trainManage.setId(id);
            trainManage.setUpdateTime(new Date());
            trainManage.setUpdateUser(userid);
            Integer status = trainHandleDTO.getStatus();
            if (status == 0) {
                trainManage.setStatus(3);
                trainManage.setDealOpinion(trainHandleDTO.getAdvice());
                List<DealUser> dealUserList = new ArrayList<DealUser>();
                //保存培训人
                DealUser trainer = new DealUser();
                trainer.setBussId(id);
                trainer.setCreateTime(new Date());
                trainer.setCreateUser(userid);
                trainer.setPersonId(trainHandleDTO.getTrainerId());
                trainer.setPersonName(trainHandleDTO.getTrainer());
                trainer.setType("pxr");
                dealUserList.add(trainer);
                //保存协助人
                List<AssistantDTO> list = trainHandleDTO.getAssistant();
                if (list != null && list.size() != 0) {
                    for (AssistantDTO assistantDTO : list) {
                        DealUser assistant = new DealUser();
                        assistant.setBussId(id);
                        assistant.setCreateTime(new Date());
                        assistant.setCreateUser(userid);
                        assistant.setPersonId(assistantDTO.getId());
                        assistant.setPersonName(assistantDTO.getName());
                        assistant.setType("xzr");
                        dealUserList.add(assistant);
                    }
                }
                dealUserService.save(dealUserList);
            } else if (status == 1) {
                trainManage.setStatus(2);
                trainManage.setDealOpinion(trainHandleDTO.getAdvice());
            }
            //保存处理人
            DealUser handler = new DealUser();
            handler.setBussId(id);
            handler.setCreateTime(new Date());
            handler.setCreateUser(userid);
            handler.setPersonId(trainHandleDTO.getTrainerId());
            handler.setPersonName(trainHandleDTO.getTrainer());
            handler.setType("clr");
            dealUserService.save(handler);
            int result = trainManageService.updateByIdSelective(trainManage);
            if (result < 0) {
                return Result.success(false);
            }
            //发送消息给处理人
            List<Long> list = new ArrayList<Long>();
            list.add(trainHandleDTO.getTrainerId());
            TrainManage trainManage1 = trainManageService.getById(id);
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setBizId(String.valueOf(id));
            bbsAllMainMsgDTO.setBizType("train_handle");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setBriefTpye("audit_result");
            bbsAllMainMsgDTO.setDetailedType("train_handle");
            bbsAllMainMsgDTO.setDetailedTypeDesc("培训处理");
            bbsAllMainMsgDTO.setTitle("培训处理");
            bbsAllMainMsgDTO.setContent("您有一条" + trainManage1.getTrainName() + "申请待处理。");
            bbsAllMainMsgDTO.setSenderName(BaseContextHandler.getName());
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/trainDeal");
            bbsAllMainMsgDTO.setSingleHandleIs(true);
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbbMsgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, null, list);
            //发送消息给申请人
            List<Long> list1 = new ArrayList<Long>();
            list1.add(trainManage1.getCreateUser());
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/trainList");
            bbsAllMainMsgDTO.setDetailedTypeDesc("培训申请");
            bbsAllMainMsgDTO.setTitle("培训申请");
            if (status == 0) {
                bbsAllMainMsgDTO.setContent("您的" + trainManage1.getTrainName() + "申请已审批通过。");
            } else if (status == 1) {
                bbsAllMainMsgDTO.setContent("您的" + trainManage1.getTrainName() + "申请已被驳回。");
            }
            bbsAllMainMsgDTO.setSingleHandleIs(true);
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbbMsgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, list1, null);
            if (trainManage.getApplyCode() != null) {
                AlarmInformationExample informationExample = new AlarmInformationExample();
                informationExample.createCriteria().andApplyCodeEqualTo(trainManage.getApplyCode()).andApplyTypeEqualTo("train_audit");
                List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
                if (informationList != null && informationList.size() > 0) {
                    for (AlarmInformation information : informationList) {
                        information.setStatus(2);
                        information.setUpdateUser(userid);
                        alarmInformationService.updateByIdSelective(information);
                    }
                }
            }
            //推送到统一监管-结束审批
            pushSuperviseTemp.pushSupervise(trainManage.getId(), new Date(), new Date(), OpsCode.TRAIN_CODE.getCode(),
                    OpsCode.TRAIN_CODE.getName(), OpsCode.TRAIN_CODE.getDescribe());
            //推送到统一监管-处理申请
            if (!status.equals(one)) {
                pushSuperviseTemp.pushSupervise(trainManage.getId(), new Date(), null, OpsCode.TRAIN_DEAL_APPLY_CODE.getCode(),
                        OpsCode.TRAIN_DEAL_APPLY_CODE.getName(), OpsCode.TRAIN_DEAL_APPLY_CODE.getDescribe());
            }
            return Result.success(true);
        } catch (Exception e) {
            log.error("处理培训申请异常：" + e);
            return Result.fail("处理培训申请失败");
        }
    }

    /**
     * 获取培训分页列表
     *
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiOperation(value = "获取培训分页列表", notes = "获取培训分页列表")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<TrainPageResDTO>> getList(@RequestBody OpenApiReq<TrainPageReqDTO> openApiReq) {
        try {
            String name = openApiReq.getData().getName();
            String context = openApiReq.getData().getContext();

            Date startTime = openApiReq.getData().getStartTime();
            Date endTime = openApiReq.getData().getEndTime();
            String type = openApiReq.getData().getType();
            Integer status = openApiReq.getData().getStatus();
            String applyCode = openApiReq.getData().getApplyCode();
            Map map = new HashMap();
            map.put("startTime", startTime);
            map.put("endTime", endTime);
            map.put("name", BaseExample.fullLike(name));
            map.put("context", BaseExample.fullLike(context));
            map.put("applyCode", BaseExample.fullLike(applyCode));
            map.put("type", type);
            map.put("createUser", BaseContextHandler.getAdminId());
            map.put("status", status);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<TrainPageResDO> list = trainManageService.getList(map);
            Set<Long> set = new HashSet<>();
            for (TrainPageResDO trainPageResDO : list) {
                Long id = trainPageResDO.getId();
                set.add(id);
            }
            if (set.size() > 0) {
                List<OperationFileDO> files = trainManageService.getFilesByBussId(set);
                for (TrainPageResDO trainPageResDO : list) {
                    Long id = trainPageResDO.getId();
                    List<OperationFileDO> fileList = new ArrayList<>();
                    for (OperationFileDO operationFileDO : files) {
                        Long fileBussId = operationFileDO.getBussId();
                        if (fileBussId.equals(id)) {
                            fileList.add(operationFileDO);
                        }
                    }
                    trainPageResDO.setFiles(fileList);
                }
            }
            if (list.size() == 0) {
                return Result.success(new PageInfo<>(null));
            }
            //排序
            list.sort((o1, o2) -> {
                if (o1.getTrainTime() == null) {
                    if (o2.getTrainTime() == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
                if (o2.getTrainTime() == null) {
                    if (o1.getTrainTime() == null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                return -o1.getTrainTime().compareTo(o2.getTrainTime());
            });
            List<TrainPageResDTO> result = dozerUtils.mapList(list, TrainPageResDTO.class);
            return Result.success(new PageInfo<>(result));
        } catch (Exception e) {
            log.error("获取培训分页列表异常：" + e);
            return Result.fail("获取培训分页列表失败");
        }
    }

    /**
     * 修改培训内容
     *
     * @return
     */
    @ApiOperation(value = "修改培训内容", notes = "修改培训内容")
    @RequestMapping(value = "context/update", method = RequestMethod.POST)
    public Result<Boolean> updateContext(@RequestBody TrainManageDTO trainManageDTO) {
        try {
            if (trainManageDTO == null) {
                return Result.fail("参数错误");
            }
            TrainManage trainManage = new TrainManage();
            trainManage.setId(trainManageDTO.getId());
            trainManage.setStatus(4);
            trainManage.setTrainAddress(trainManageDTO.getTrainAddress());
            trainManage.setTrainInfo(trainManageDTO.getTrainInfo());
            trainManage.setTrainTime(trainManageDTO.getTrainTime());
            trainManage.setTrainType(trainManageDTO.getTrainType());
            trainManage.setTrainName(trainManageDTO.getTrainName());
            trainManage.setUpdateTime(new Date());
            trainManage.setUpdateUser(BaseContextHandler.getAdminId());
            int result = trainManageService.updateByIdSelective(trainManage);
            if (result < 0) {
                return Result.success(false);
            }
            //推送到统一监管
            pushSuperviseTemp.pushSupervise(trainManage.getId(), new Date(), null, OpsCode.TRAIN_CODE.getCode(),
                    OpsCode.TRAIN_CODE.getName(), OpsCode.TRAIN_CODE.getDescribe());
            return Result.success(true);
        } catch (Exception e) {
            log.error("修改培训内容异常：" + e);
            return Result.fail("修改培训内容失败");
        }
    }

    /**
     * 培训评价
     *
     * @return
     */
    @ApiOperation(value = "培训评价", notes = "培训评价")
    @RequestMapping(value = "/evaluate", method = RequestMethod.POST)
    public Result<Boolean> updateEvaluate(@RequestBody TrainEvaluateDTO trainEvaluateDTO) {
        try {
            if (trainEvaluateDTO == null) {
                return Result.fail("参数错误");
            }
            TrainManage trainManage = new TrainManage();
            trainManage.setId(trainEvaluateDTO.getId());
            trainManage.setTrainAdvice(trainEvaluateDTO.getAdvice());
            trainManage.setTrainSorce(trainEvaluateDTO.getScore());
            trainManage.setScoreTime(new Date());
            trainManage.setUpdateUser(BaseContextHandler.getAdminId());
            int result = trainManageService.updateByIdSelective(trainManage);
            if (result < 0) {
                return Result.success(false);
            }
            //发送消息给处理人
            List<Long> list = new ArrayList<Long>();
            DealUserExample example = new DealUserExample();
            example.createCriteria().andBussIdEqualTo(trainEvaluateDTO.getId()).andTypeEqualTo("clr");
            List<DealUser> train = dealUserService.find(example);
            if (train != null && train.size() != 0) {
                list.add(train.get(0).getPersonId());
            }
            TrainManage trainManage1 = trainManageService.getById(trainEvaluateDTO.getId());
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setBizId(String.valueOf(trainEvaluateDTO.getId()));
            bbsAllMainMsgDTO.setBizType("train_evaluate");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setBriefTpye("evaluate");
            bbsAllMainMsgDTO.setDetailedType("train_evaluate");
            bbsAllMainMsgDTO.setDetailedTypeDesc("培训评价");
            bbsAllMainMsgDTO.setTitle("培训评价");
            bbsAllMainMsgDTO.setContent("您的" + trainManage1.getTrainName() + "已评价。");
            bbsAllMainMsgDTO.setSenderName(BaseContextHandler.getName());
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/trainDeal");
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setHandlerNeedIs(false);
            bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbbMsgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, null, list);
            return Result.success(true);
        } catch (Exception e) {
            log.error("培训评价异常：" + e);
            return Result.fail("培训评价失败");
        }
    }

    /**
     * 获取培训审核分页列表
     *
     * @return
     */
    @ApiOperation(value = "获取培训审核分页列表", notes = "获取培训审核分页列表")
    @RequestMapping(value = "/auditor/page", method = RequestMethod.POST)
    public Result<PageInfo<TrainAdminPageResDTO>> getAuditorList(@RequestBody OpenApiReq<TrainAdminPageReqDTO> openApiReq) {
        try {
            TrainAdminPageReqDTO trainAdminPageReqDTO = openApiReq.getData();
            if (trainAdminPageReqDTO == null) {
                return Result.fail("参数错误");
            }
            String name = trainAdminPageReqDTO.getName();
            String context = trainAdminPageReqDTO.getContext();
            String person = trainAdminPageReqDTO.getPerson();
            String company = trainAdminPageReqDTO.getCompany();
            Integer handle = trainAdminPageReqDTO.getHandle();
            String applyCode = trainAdminPageReqDTO.getApplyCode();
            trainAdminPageReqDTO.setName(BaseExample.fullLike(name));
            trainAdminPageReqDTO.setContext(BaseExample.fullLike(context));
            trainAdminPageReqDTO.setCompany(BaseExample.fullLike(company));
            trainAdminPageReqDTO.setPerson(BaseExample.fullLike(person));
            trainAdminPageReqDTO.setApplyCode(BaseExample.fullLike(applyCode));
            if (trainAdminPageReqDTO.getStatus() == null || trainAdminPageReqDTO.getStatus() == 0) {
                trainAdminPageReqDTO.setStatus(0);
            }
            //管理员可以看所有数据并操作
            UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
            String appId = BaseContextHandler.getAppId();
            log.info("是否为管理员：" + userTokenExtInfo.isAppAdmin(appId));
            if (userTokenExtInfo.isAppAdmin(appId)) {
                //管理员
                trainAdminPageReqDTO.setCreateUser(-1L);
            } else {
                //非管理员
                if (handle != null && handle == 1) {
                    //处理页面
                    trainAdminPageReqDTO.setCreateUser(BaseContextHandler.getAdminId());
                } else {
                    //审核页面
                    trainAdminPageReqDTO.setCreateUser(0L);
                }
            }
            TrainAdminPageReqDO trainAdminPageReqDO = dozerUtils.map(trainAdminPageReqDTO, TrainAdminPageReqDO.class);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<TrainAdminPageResDO> list = trainManageService.getAuditorList(trainAdminPageReqDO);
            Set<Long> set = new HashSet<>();
            if (list != null && list.size() > 0) {
                for (TrainAdminPageResDO trainAdminPageResDO : list) {
                    Long id = trainAdminPageResDO.getId();
                    set.add(id);
                }
            }
            if (set.size() > 0) {
                List<OperationFileDO> files = trainManageService.getFilesByBussId(set);
                if (files != null && files.size() != 0) {
                    for (TrainAdminPageResDO trainAdminPageResDO : list) {
                        Long id = trainAdminPageResDO.getId();
                        if (id == null) {
                            continue;
                        }
                        List<OperationFileDO> fileList = new ArrayList<>();
                        for (OperationFileDO operationFileDO : files) {
                            Long fileBussId = operationFileDO.getBussId();
                            if (fileBussId == null) {
                                continue;
                            }
                            if (fileBussId.equals(id)) {
                                fileList.add(operationFileDO);
                            }
                        }
                        trainAdminPageResDO.setFiles(fileList);
                    }
                }
            }
            if (list == null || list.size() == 0) {
                return Result.success(new PageInfo<>(null));
            }
            //排序
            Collections.sort(list, (Comparator<TrainPageResDO>) (o1, o2) -> {
                if (o1.getTrainTime() == null) {
                    if (o2.getTrainTime() == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
                if (o2.getTrainTime() == null) {
                    if (o1.getTrainTime() == null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                return -o1.getTrainTime().compareTo(o2.getTrainTime());
            });
            List<TrainAdminPageResDTO> result = dozerUtils.mapList(list, TrainAdminPageResDTO.class);
            return Result.success(new PageInfo<>(result));
        } catch (Exception e) {
            log.error("获取培训审核分页列表异常：" + e);
            return Result.fail("获取培训审核分页列表失败");
        }
    }

    /**
     * 获取培训课程目录树
     *
     * @return
     */
    @ApiOperation(value = "获取培训课程目录树", notes = "获取培训课程目录树")
    @RequestMapping(value = "/course/tree", method = RequestMethod.GET)
    public Result<List<TrainDirectoryTreeDTO>> getCourseTree(@RequestParam(value = "serviceName") String serviceName) {
        List<TrainDirectory> list;
        try {
            TrainDirectoryExample example = new TrainDirectoryExample();
            if (org.apache.commons.lang3.StringUtils.isNoneBlank(serviceName)) {
                list = trainDirectoryService.getPageList(serviceName);
                if (list != null && !list.isEmpty()) {
                    // id集合
                    Set<Long> ids = new HashSet<>();
                    List<TrainDirectory> treeList = new ArrayList<>(list);
                    list.forEach(l -> {
                        // 排除父节点查询
                        if (!ids.contains(l.getId())) {
                            treeList.addAll(trainDirectoryService.selectParentsById(l.getId()));
                            ids.add(l.getId());
                            ids.add(l.getParentId());
                        }
                    });

                    // 数据去重
                    list = treeList.stream().collect(
                            Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(TrainDirectory::getId))), ArrayList::new));
                }
            } else {
                list = trainDirectoryService.find(example);
            }
            List<TrainDirectoryTreeDTO> resultList = dozerUtils.mapList(list, TrainDirectoryTreeDTO.class);
            return Result.success(TreeUtil.builderTreeOrdered(resultList));
        } catch (Exception e) {
            log.error("获取培训课程目录树异常：" + e);
            return Result.fail("获取培训课程目录树失败");
        }
    }

    /**
     * 新增培训课程
     *
     * @return
     */
    @ApiOperation(value = "新增培训课程", notes = "新增培训课程")
    @RequestMapping(value = "/course/save", method = RequestMethod.POST)
    public Result<TrainDirectory> addCourse(@RequestBody AddCourseDTO addCourseDTO) {
        try {
            if (addCourseDTO == null) {
                return Result.fail("参数错误");
            }
            TrainDirectory trainDirectory = new TrainDirectory();
            trainDirectory.setCreateTime(new Date());
            trainDirectory.setCreateUser(BaseContextHandler.getAdminId());
            trainDirectory.setLevel(addCourseDTO.getLevel());
            trainDirectory.setParentId(addCourseDTO.getPId());
            trainDirectory.setServiceInfo(addCourseDTO.getContext());
            trainDirectory.setServiceName(addCourseDTO.getName());
            trainDirectory.setSort(addCourseDTO.getSort());
            trainDirectory.setType(addCourseDTO.getType());
            TrainDirectory result = trainDirectoryService.save(trainDirectory);
            return Result.success(result);
        } catch (Exception e) {
            log.error("新增培训课程异常：" + e);
            return Result.fail("新增培训课程失败");
        }
    }

    /**
     * 删除培训课程
     *
     * @return
     */
    @ApiOperation(value = "删除培训课程", notes = "删除培训课程")
    @RequestMapping(value = "/course/delete", method = RequestMethod.POST)
    public Result<Boolean> deleteCourse(@RequestParam(value = "id") Long id) {
        try {
            if (id == null) {
                return Result.fail("参数错误");
            }
            int result = trainDirectoryService.deleteById(id);
            if (result < 0) {
                return Result.success(false);
            }
            return Result.success(true);
        } catch (Exception e) {
            log.error("删除培训课程异常：" + e);
            return Result.fail("删除培训课程失败");
        }
    }

    /**
     * 修改培训课程
     *
     * @return
     */
    @ApiOperation(value = "修改培训课程", notes = "修改培训课程")
    @RequestMapping(value = "/course/update", method = RequestMethod.POST)
    public Result<Boolean> updateCourse(@RequestBody UpdateCourseDTO updateCourseDTO) {
        try {
            if (updateCourseDTO == null || updateCourseDTO.getId() == null) {
                return Result.fail("参数错误");
            }
            String type = updateCourseDTO.getType();
            String name = updateCourseDTO.getName();
            String info = updateCourseDTO.getContext();
            TrainDirectory trainDirectory = new TrainDirectory();
            trainDirectory.setId(updateCourseDTO.getId());
            if (!StringUtils.isEmpty(type)) {
                trainDirectory.setType(type);
            }
            if (!StringUtils.isEmpty(name)) {
                trainDirectory.setServiceName(name);
            }
            if (!StringUtils.isEmpty(info)) {
                trainDirectory.setServiceInfo(info);
            }
            trainDirectory.setUpdateTime(new Date());
            trainDirectory.setUpdateUser(BaseContextHandler.getAdminId());
            int result = trainDirectoryService.updateByIdSelective(trainDirectory);
            trainDirectory.setParentId(updateCourseDTO.getId());
            if (result < 0) {
                return Result.success(false);
            }
            trainDirectoryService.updateByParentId(trainDirectory);
            return Result.success(true);
        } catch (Exception e) {
            log.error("修改培训课程异常：" + e);
            return Result.fail("修改培训课程失败");
        }
    }

    /**
     * 保存培训上传文件信息
     *
     * @return
     */
    @ApiOperation(value = "保存培训上传文件信息", notes = "保存培训上传文件信息")
    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
    public Result<String> saveTrainFile(@RequestBody TrainFileUploadDTO trainFileUploadDTO) {
        try {
            if (trainFileUploadDTO == null) {
                return Result.fail("参数错误");
            }
            List<TrainFileDTO> list = trainFileUploadDTO.getFiles();
            if (list == null || list.size() == 0) {
                return Result.fail("参数错误");
            }
            //删除文件
            List<Long> fileIds = trainFileUploadDTO.getFileIds();
            if (fileIds != null && fileIds.size() != 0) {
                operationFileService.deleteByFileIds(fileIds);
            }
            //保存文件
            List<OperationFile> fileList = new ArrayList<OperationFile>();
            for (TrainFileDTO trainFileDTO : list) {
                OperationFile operationFile = new OperationFile();
                operationFile.setCreateTime(new Date());
                operationFile.setUserId(BaseContextHandler.getAdminId());
                operationFile.setBussId(trainFileDTO.getBussId());
                operationFile.setBussType(trainFileDTO.getBussType());
                operationFile.setFileName(trainFileDTO.getName());
                operationFile.setFileSize(trainFileDTO.getFileSize());
                operationFile.setFileType(trainFileDTO.getType());
                operationFile.setFileUrl(trainFileDTO.getFileUrl());
                operationFile.setFileId(trainFileDTO.getFileId());
                fileList.add(operationFile);
            }
            operationFileService.save(fileList);
            return Result.success("保存文件信息成功");
        } catch (Exception e) {
            log.error("保存培训上传文件信息异常：" + e);
            return Result.fail("保存培训上传文件信息失败");
        }
    }

    /**
     * 完结培训
     *
     * @return
     */
    @ApiOperation(value = "完结培训", notes = "完结培训")
    @RequestMapping(value = "/end/update", method = RequestMethod.POST)
    public Result<Boolean> updateTrainEnd(@RequestParam(value = "id") Long id) {
        try {
            if (id == null) {
                return Result.fail("参数错误");
            }
            TrainManage trainManage = new TrainManage();
            trainManage.setId(id);
            trainManage.setStatus(5);
            trainManage.setUpdateTime(new Date());
            trainManage.setUpdateUser(BaseContextHandler.getAdminId());
            int result = trainManageService.updateByIdSelective(trainManage);
            if (result < 0) {
                return Result.success(false);
            }
            //发信息给申请人
            TrainManage trainManage1 = trainManageService.getById(id);
            List<Long> list = new ArrayList<Long>();
            list.add(trainManage1.getCreateUser());
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setBizId(String.valueOf(id));
            bbsAllMainMsgDTO.setBizType("train_end");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setBriefTpye("evaluate");
            bbsAllMainMsgDTO.setDetailedType("train_end");
            bbsAllMainMsgDTO.setDetailedTypeDesc("培训评价");
            bbsAllMainMsgDTO.setTitle("培训评价");
            bbsAllMainMsgDTO.setContent("您有一条" + trainManage1.getTrainName() + "已处理，请尽快评价。");
            bbsAllMainMsgDTO.setSenderName(BaseContextHandler.getName());
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/trainList");
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setHandlerNeedIs(false);
            bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbbMsgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, list, null);
            if (trainManage.getApplyCode() != null) {
                AlarmInformationExample informationExample = new AlarmInformationExample();
                informationExample.createCriteria().andApplyCodeEqualTo(trainManage.getApplyCode()).andApplyTypeEqualTo("train_deal");
                List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
                if (informationList != null && informationList.size() > 0) {
                    for (AlarmInformation information : informationList) {
                        information.setStatus(2);
                        information.setUpdateUser(BaseContextHandler.getAdminId());
                        alarmInformationService.updateByIdSelective(information);
                    }
                }
            }
            //推送到统一监管
            pushSuperviseTemp.pushSupervise(trainManage.getId(), new Date(), new Date(), OpsCode.TRAIN_DEAL_APPLY_CODE.getCode(),
                    OpsCode.TRAIN_DEAL_APPLY_CODE.getName(), OpsCode.TRAIN_DEAL_APPLY_CODE.getDescribe());
            return Result.success(true);
        } catch (Exception e) {
            log.error("完结培训异常：" + e);
            return Result.fail("完结培训失败");
        }
    }

    /**
     * 获取培训详情
     *
     * @return
     */
    @ApiOperation(value = "获取培训详情", notes = "获取培训详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<TrainDetailDTO> getTrainDetail(@RequestParam(value = "id") Long id) {
        try {
            if (id == null) {
                return Result.fail("参数错误");
            }
            TrainDetailDTO trainDetailDTO = new TrainDetailDTO();
            //获取培训信息
            TrainManage trainManage = trainManageService.getById(id);
            if (trainManage == null) {
                return Result.fail("培训不存在");
            }
            trainDetailDTO.setStatus(trainManage.getStatus());
            trainDetailDTO.setTrainAddress(trainManage.getTrainAddress());
            trainDetailDTO.setTrainAdvice(trainManage.getTrainAdvice());
            trainDetailDTO.setTrainInfo(trainManage.getTrainInfo());
            trainDetailDTO.setTrainName(trainManage.getTrainName());
            trainDetailDTO.setTrainSorce(trainManage.getTrainSorce());
            trainDetailDTO.setTrainTime(trainManage.getTrainTime());
            trainDetailDTO.setTrainType(trainManage.getTrainType());
            trainDetailDTO.setDealOpinion(trainManage.getDealOpinion());
            //获取协助人、培训人信息
            List<DealUser> trainer = dealUserService.getByBussId(id);
            if (trainer != null && trainer.size() != 0) {
                String assistant = "";
                for (DealUser dealUser : trainer) {
                    String type = dealUser.getType();
                    //培训人只有一个
                    if ("pxr".equals(type)) {
                        trainDetailDTO.setPersonName(dealUser.getPersonName());
                        Long personId = dealUser.getPersonId();
                        Long[] ids = {personId};
                        Result<List<GxqptEmpRetDTO>> renyuan = gxqptEmpApi.findByIdsGxqptYw(ids);
                        List<GxqptEmpRetDTO> empList = renyuan.getData();
                        if (empList != null && !empList.isEmpty()) {
                            GxqptEmpRetDTO gxqptEmpRetDTO = empList.get(0);
                            if (gxqptEmpRetDTO != null) {
                                trainDetailDTO.setPosition(gxqptEmpRetDTO.getMaindutyname());
                            }
                        }
                        PersonManage personManage = personService.getById(personId);
                        if (personManage != null) {
                            trainDetailDTO.setContact(personManage.getMainmobile());
                            trainDetailDTO.setJob(personManage.getContent());
                        }
                    }
                    //协助人
                    if ("xzr".equals(type)) {
                        assistant += dealUser.getPersonName() + ",";
                    }
                }
                if (!StringUtils.isEmpty(assistant)) {
                    assistant = assistant.substring(0, assistant.length() - 1);
                }
                trainDetailDTO.setAssistant(assistant);
            }
            OperationFileExample fileExample = new OperationFileExample();
            fileExample.createCriteria().andBussIdEqualTo(trainManage.getId());
            List<OperationFileDTO> fileList = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
            if (!fileList.isEmpty()) {
                trainDetailDTO.setFiles(fileList);
            }
            return Result.success(trainDetailDTO);
        } catch (Exception e) {
            log.error("获取培训详情异常：" + e);
            return Result.fail("获取培训详情失败");
        }
    }
}
