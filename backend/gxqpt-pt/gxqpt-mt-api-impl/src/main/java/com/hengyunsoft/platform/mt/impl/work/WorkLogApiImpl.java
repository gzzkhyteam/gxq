package com.hengyunsoft.platform.mt.impl.work;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.groups.Default;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.org.OrgDeptDutyInfoDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptEmpOpenApi;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.mt.api.file.dto.WorkLogFileDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogAnswerDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogAnswerSaveDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogAppPageReqDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogAuthorityDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogCountDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogDetailDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogLookDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogLookSaveDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogPageDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogPageReqDTO;
import com.hengyunsoft.platform.mt.api.work.dto.WorkLogSaveDTO;
import com.hengyunsoft.platform.mt.entity.file.po.WorkLogFile;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLog;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogAnswer;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogAuthority;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogDetail;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogLook;
import com.hengyunsoft.platform.mt.entity.work.po.domain.WorkLogCountDO;
import com.hengyunsoft.platform.mt.impl.userconfig.UserConfigJobType;
import com.hengyunsoft.platform.mt.repository.file.example.WorkLogFileExample;
import com.hengyunsoft.platform.mt.repository.file.service.WorkLogFileService;
import com.hengyunsoft.platform.mt.repository.userconfig.example.UserConfigExample;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogAnswerExample;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogAuthorityExample;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogDetailExample;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogExample;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogLookExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogAnswerService;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogAuthorityService;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogDetailService;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogLookService;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogService;
import com.hengyunsoft.platform.mt.utils.MsgQueueUtil;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：工作日志管理
 * author：tianai
 *
 * @createTime：2018/5/29
 */


@RestController
@Slf4j
@RequestMapping("/work")
@Api(value = "工作日志管理", description = "工作日志管理")
public class WorkLogApiImpl /*implements WorkLogApi*/ {

    @Autowired
    private WorkLogService workLogService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private WorkLogFileService fileService;
    @Autowired
    GxqptOrgOpenApi gxqptOrgOpenApi;
    @Autowired
    private WorkLogLookService workLogLookService;
    @Autowired
    private WorkLogAnswerService workLogAnswerService;
    @Autowired
    private WorkLogDetailService workLogDetailService;
    @Autowired
    private WorkLogAuthorityService workLogAuthorityService;
    @Autowired
    private WorkLogFileService workLogFileService;
    @Autowired
    GxqptEmpOpenApi gxqptEmpOpenApi;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    
    @ApiOperation(value = "查询工作日志分页信息", notes = "查询工作日志分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<WorkLogPageDTO>> getPage(@RequestBody OpenApiReq<WorkLogPageReqDTO> openApiReq) {
        Date start = null;
        Date end = null;
        Long userId = BaseContextHandler.getAdminId();
        //Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(userId);
        //String unitId=orgDeptDutyInfo.getData().getOrgId();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = openApiReq.getData().getStartTime();
        String endTime = openApiReq.getData().getEndTime();
        String mainDeptId = openApiReq.getData().getMainDeptId();
        String unitId = openApiReq.getData().getUnitId();

        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);
        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
        }
        if (endTime != null && endTime != "") {
            end = formatter.parse(endTime, poss);
        }
        Map map = new HashMap<>();
        map.put("mainDeptId", mainDeptId);
        map.put("startTime", start);
        map.put("endTime", end);
        map.put("unitId", unitId);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(workLogService.getPageList(map), WorkLogPageDTO.class)));
    }

    
    @ApiOperation(value = "根据用户id,查询工作日志分页信息(APP端)", notes = "根据用户id,查询工作日志分页信息(APP端)")
    @RequestMapping(value = "/pageApp", method = RequestMethod.POST)
    public Result<PageInfo<WorkLogDTO>> getPageApp(@RequestBody OpenApiReq<WorkLogAppPageReqDTO> openApiReq) {
        Long userId = openApiReq.getData().getUserId();
        if (userId == null) {
            return Result.fail("用户id不能为空");
        }
        log.info("uninid={}, userid={}", openApiReq.getData().getUnitId(), openApiReq.getData().getUserId());
        String unitId = openApiReq.getData().getUnitId();
        WorkLogExample workLogExample = new WorkLogExample();
        workLogExample.createCriteria().andUserIdEqualTo(userId).andMainOrgIdEqualTo(unitId);
        workLogExample.setOrderByClause("create_date desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<WorkLog> list = workLogService.find(workLogExample);
        log.info(" list ={}" , list.size());
        PageInfo<WorkLogDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(list, WorkLogDTO.class));
        log.info(" total={} , pages={}, getList size ={}" ,pageDTO.getTotal(), pageDTO.getPages(),  pageDTO.getList().size());
        if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
            for (WorkLogDTO workLog : pageDTO.getList()) {
                WorkLogDetailExample workLogDetailExample = new WorkLogDetailExample();
                workLogDetailExample.createCriteria().andLogIdEqualTo(workLog.getId());
                workLogDetailExample.setOrderByClause("create_time asc");
                List<WorkLogDetailDTO> listDetail = dozerUtils.mapList(workLogDetailService.find(workLogDetailExample), WorkLogDetailDTO.class);
                List<WorkLogDetailDTO> detailDTOS = new ArrayList<>();
                if (listDetail != null && listDetail.size() > 0) {
                    for (WorkLogDetailDTO workLogDetailDTO : listDetail) {
                        WorkLogFileExample workLogFileExample = new WorkLogFileExample();
                        workLogFileExample.createCriteria().andLogDetailIdEqualTo(workLogDetailDTO.getId());
                        List<WorkLogFileDTO> workLogFile = dozerUtils.mapList(workLogFileService.find(workLogFileExample), WorkLogFileDTO.class);
                        workLogDetailDTO.setWorkLogFileDTOS(workLogFile);
                        detailDTOS.add(workLogDetailDTO);
                    }
                }
                workLog.setStatus(0);//查询我的日志不标识已读未读，默认返回0给h5判断
                WorkLogAnswerExample example = new WorkLogAnswerExample();
                example.createCriteria().andWorkLogIdEqualTo(workLog.getId());
                example.setOrderByClause("create_time asc");

                workLog.setUserName(workLog.getUserName());
                 Result<OrgDeptDutyInfoDTO> orgInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(workLog.getUserId());
                workLog.setPhoto(orgInfo.getData().getPhoto());
                workLog.setUserName(orgInfo.getData().getUserName());
                workLog.setCreateDate(workLog.getCreateDate());
                workLog.setWorkLogDetailDTOS(detailDTOS);
                List<WorkLogAnswerDTO> dtoList=new ArrayList<>();
                List<WorkLogAnswerDTO> logAnswerDTOS = dozerUtils.mapList(workLogAnswerService.find(example), WorkLogAnswerDTO.class);
                if (logAnswerDTOS != null && logAnswerDTOS.size() > 0) {
                    for(WorkLogAnswerDTO answerDTO:logAnswerDTOS){
                        Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(answerDTO.getUserId());
                        answerDTO.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                        answerDTO.setCreateUser(orgDeptDutyInfo.getData().getUserName());
                        dtoList.add(answerDTO);
                    }
                    workLog.setWorkLogAnswerDTOS(dtoList);
                } else {
                    workLog.setWorkLogAnswerDTOS(null);
                }
            }
        }
        log.info(" total={} , pages={}, getList size ={}" ,pageDTO.getTotal(), pageDTO.getPages(),  pageDTO.getList().size());
        return Result.success(pageDTO);
    }

    
    @ApiOperation(value = "查询本周工作日志统计信息", notes = "查询本周工作日志统计信息")
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<List<WorkLogCountDTO>> getList(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "deptId", required = false) String deptId, @RequestParam(value = "name", required = false) String name) {
        Long userId = BaseContextHandler.getAdminId();
        if (unitId == null) {
            return Result.fail("单位ID不能为空");
        }
        String userName = name;
        List<WorkLogCountDTO> countList = new ArrayList<>();
        WorkLogAuthorityExample authorityExample = new WorkLogAuthorityExample();
        authorityExample.createCriteria().andUserIdEqualTo(userId).andUnitIdEqualTo(unitId);
        List<WorkLogAuthority> authorityList = workLogAuthorityService.find(authorityExample);
        List<Long> userIds = new ArrayList<>();
        if (authorityList != null && authorityList.size() > 0) {
            for (WorkLogAuthority authority : authorityList) {
                userIds.add(authority.getBeViewedUser());
            }
        }
        if (userIds != null && userIds.size() > 0) {
            for (Long id : userIds) {
                Map map = new HashMap<>();
                map.put("unitId", unitId);
                map.put("mainDeptId", deptId);
                map.put("userName", userName);
                map.put("userId", id);
                WorkLogCountDO countDO = workLogService.getCountList(map);
                WorkLogCountDTO countDTO = new WorkLogCountDTO();
                if (countDO != null) {
                    countDTO.setCount(countDO.getCount());
                    countDTO.setGxqptEmpId(countDO.getUserId());
                    Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(countDO.getUserId());
                    countDTO.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                    countDTO.setMaindeptname(orgDeptDutyInfo.getData().getDeptName());
                    countDTO.setMaindutyname(orgDeptDutyInfo.getData().getDutyName());
                    countDTO.setName(orgDeptDutyInfo.getData().getUserName());
                   // countDTO.setPhoto(countDO.getPhoto());
                    countList.add(countDTO);
                }
            }
        }
        return Result.success(countList);
    }

    
    @ApiOperation(value = "保存工作日志信息", notes = "保存工作日志信息")
    @ApiResponses({
            /*  @ApiResponse(code = 91500, message = "工作类型不能为空"),*/
            @ApiResponse(code = 91501, message = "工作描述不能为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = WorkLog.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<WorkLogSaveDTO> save(@RequestBody WorkLogSaveDTO workLogSaveDTO) {
        //1.校验
        // BizAssert.assertNotNull(MtExceptionCode.WORK_TYPE_NULL, workLogSaveDTO.getWorkType());
        BizAssert.assertNotNull(MtExceptionCode.WORK_DESCRIPTION_NULL, workLogSaveDTO.getDescription());
        Long userId = workLogSaveDTO.getUserId();
        if (userId == null) {
            return Result.fail("用户id信息为空");
        }
        String orgId = workLogSaveDTO.getUnitId();
        //转换
        Result<List<OrgDeptDutyInfoDTO>> orgDeptDutyinfo = gxqptOrgOpenApi.getOrgDeptDutyinfo(userId, orgId);
        WorkLog workLog = new WorkLog();
        if (orgDeptDutyinfo.getData().size() == 0) {
            return Result.fail("用户单位信息为空");
        }
        WorkLog getLog = workLogService.getByUserId(userId, orgId);
        if (getLog != null) {
            getLog.setNowNum(getLog.getNowNum() + 1);
            workLogService.updateByIdSelective(getLog);
        } else {
            String deptId = null;
            String deptName = null;
            String dutyName = null;
            String userName = null;
            String unitId = null;
            String photo = null;
            for (OrgDeptDutyInfoDTO orgInfo : orgDeptDutyinfo.getData()) {
                if (deptId == null) {
                    deptId = orgInfo.getDeptId();
                } else {
                    deptId = deptId + "," + orgInfo.getDeptId();
                }
                if (deptName == null) {
                    deptName = orgInfo.getDeptName();
                } else {
                    deptName = deptName + "," + orgInfo.getDeptName();
                }
                if (dutyName == null) {
                    dutyName = orgInfo.getDutyName();
                } else {
                    dutyName = dutyName + "," + orgInfo.getDutyName();
                }
                userName = orgInfo.getUserName();
                unitId = orgInfo.getOrgId();
                photo = orgInfo.getPhoto();
            }
            workLog.setCreateDate(new Date());
            workLog.setMainOrgId(unitId);
            workLog.setMainDeptId(deptId);
            workLog.setMainDeptName(deptName);
            workLog.setMainDutyName(dutyName);
            workLog.setUserName(userName);
            workLog.setUserId(userId);
            workLog.setPhoto(photo);
            workLogService.saveSelective(workLog);

        }
        WorkLogDetail workLogDetail = new WorkLogDetail();
        workLogDetail.setDescription(workLogSaveDTO.getDescription());
        if (getLog != null) {
            Long logId = getLog.getId();
            workLogDetail.setLogId(logId);
        } else {
            workLogDetail.setLogId(workLog.getId());
        }
        workLogDetail.setCreateUser(userId);
        workLogDetail.setUpdateUser(userId);
        //保存
        workLogDetailService.saveSelective(workLogDetail);
        List<Long> userIds = workLogSaveDTO.getUserIds();
        WorkLogAuthorityExample authorityExample = new WorkLogAuthorityExample();
        authorityExample.createCriteria().andBeViewedUserEqualTo(userId).andUnitIdEqualTo(orgId);
        List<WorkLogAuthority> authorities = workLogAuthorityService.find(authorityExample);
        if (authorities != null && authorities.size() > 0) {
            for (WorkLogAuthority workLogAuthority : authorities) {
                workLogAuthorityService.deleteById(workLogAuthority.getId());
            }
        }
        List<WorkLogAuthority> lookList = new ArrayList<>();
        if (userIds != null && userIds.size() > 0) {
            for (Long user : userIds) {
                if(user!=null) {
                    WorkLogAuthority workLogAuthority = new WorkLogAuthority();
                    workLogAuthority.setUserId(user);//查看人id
                    workLogAuthority.setUnitId(orgId);
                    workLogAuthority.setBeViewedUser(userId);//被查看人id
                    workLogAuthority.setCreateUser(userId);
                    workLogAuthority.setUpdateUser(userId);
                    lookList.add(workLogAuthority);
                }
            }
        }
        workLogAuthorityService.save(lookList);
        List<WorkLogFileDTO> files = workLogSaveDTO.getFiles();
        List<WorkLogFile> fileList = new ArrayList<>();
        for (WorkLogFileDTO fdto : files) {
            WorkLogFile file = dozerUtils.map(fdto, WorkLogFile.class);
            file.setLogId(workLogDetail.getId());
            if (getLog != null) {
                Long logId = getLog.getId();
                file.setLogId(logId);
            } else {
                file.setLogId(workLog.getId());
            }
            file.setLogDetailId(workLogDetail.getId());
            file.setUserId(userId);
            fileList.add(file);
        }
        workLogFileService.save(fileList);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String dateString=null;
        String title=null;
        String content=null;
        Long workId=null;
        if (getLog != null) {
             dateString = formatter.format(getLog.getCreateDate());
             title ="您有一条"+getLog.getUserName()+"的日志待查看";
             content = "您有一条"+getLog.getUserName()+" "+dateString+"的日志待查看";
             workId=getLog.getId();
        } else {
            dateString = formatter.format(workLog.getCreateDate());
            title ="您有一条"+workLog.getUserName()+"的日志待查看";
            content = "您有一条"+workLog.getUserName()+" "+dateString+"的日志待查看";
            workId=workLog.getId();
        }
        BbsAllMainMsgDTO msgDto = MsgQueueUtil.createBbsAllMainMsgWorkDTO(workId, "系统自动通知", title, content);
        List<Long> handlerUserIds = new ArrayList<>();
        msgQueueProducer.saveMsgToUser(msgDto, userIds, handlerUserIds);
        return Result.success(dozerUtils.map(workLog, WorkLogSaveDTO.class));
    }

    
    @ApiOperation(value = "根据id查询工作日志信息", notes = "根据id查询工作日志信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<WorkLogDTO> get(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("工作日志id不能为空");
        }
        WorkLog worklog = workLogService.getById(id);
        if (worklog == null) {
            return Result.fail("工作日志不存在");
        }
        WorkLogDTO dto = dozerUtils.map(worklog, WorkLogDTO.class);
        WorkLogDetailExample workLogDetailExample = new WorkLogDetailExample();
        workLogDetailExample.createCriteria().andLogIdEqualTo(dto.getId());
        workLogDetailExample.setOrderByClause("create_time asc");
        List<WorkLogDetailDTO> listDetail = dozerUtils.mapList(workLogDetailService.find(workLogDetailExample), WorkLogDetailDTO.class);
        List<WorkLogDetailDTO> detailDTOS = new ArrayList<>();
        if (listDetail != null && listDetail.size() > 0) {
            for (WorkLogDetailDTO detailDTO : listDetail) {
                WorkLogFileExample workLogFileExample = new WorkLogFileExample();
                workLogFileExample.createCriteria().andLogDetailIdEqualTo(detailDTO.getId());
                List<WorkLogFileDTO> workLogFile = dozerUtils.mapList(workLogFileService.find(workLogFileExample), WorkLogFileDTO.class);
                ;
                detailDTO.setWorkLogFileDTOS(workLogFile);
                detailDTOS.add(detailDTO);
            }
        }
        dto.setWorkLogDetailDTOS(detailDTOS);
        return Result.success(dto);
    }

    
    @ApiOperation(value = "根据id删除工作日志信息", notes = "根据id删除工作日志信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("工作日志id不能为空");
        }
        workLogService.deleteById(id);
        return Result.success(true);
    }

    
    @ApiOperation(value = "保存回复信息（工作日志）", notes = "保存回复信息（工作日志）")
    @ApiResponses({
            @ApiResponse(code = 91502, message = "回复内容不能为空"),
            @ApiResponse(code = 91503, message = "日志ID不能为空"),
            @ApiResponse(code = 91504, message = "用户ID不能为空")
    })
    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    public Result<WorkLogAnswerSaveDTO> saveAnswer(@RequestBody WorkLogAnswerSaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(MtExceptionCode.WORK_CONTENT_NULL, saveDTO.getContent());
        BizAssert.assertNotNull(MtExceptionCode.WORK_LOG_ID_NULL, saveDTO.getWorkLogId());
        BizAssert.assertNotNull(MtExceptionCode.WORK_USER_ID_NULL, saveDTO.getUserId());
        Long userId = BaseContextHandler.getAdminId();
        //转换
        WorkLogAnswer workLogAnswer = dozerUtils.map(saveDTO, WorkLogAnswer.class);
        workLogAnswer.setCreateUser(userId);
        workLogAnswer.setUpdateUser(userId);
        //保存
        workLogAnswerService.saveSelective(workLogAnswer);
        WorkLog workLog=workLogService.getById(workLogAnswer.getWorkLogId());
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        List<Long> applyUser = new ArrayList<>(1);
        applyUser.add(Long.valueOf(workLog.getUserId()));//发送给申请人
        String bizType="mt_work_answer";
        Result<OrgDeptDutyInfoDTO> orgInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(workLogAnswer.getUserId());
        bbsAllMainMsgDTO =  MsgQueueUtil.createMsgWorkDTO(workLogAnswer.getId(),bizType,""+orgInfo.getData().getUserName()+"评论了您的日志","日志评论");
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,applyUser , null);
        return Result.success(dozerUtils.map(workLogAnswer, WorkLogAnswerSaveDTO.class));

    }

    
    @ApiOperation(value = "根据用户id,查询可以查看的工作日志信息", notes = "根据用户id,查询可以查看的工作日志信息")
    @RequestMapping(value = "/lookPage", method = RequestMethod.POST)
    public Result<PageInfo<WorkLogDTO>> getLookPage(@RequestBody OpenApiReq<WorkLogAppPageReqDTO> openApiReq) {

        Long userId = openApiReq.getData().getUserId();
        String unitId=openApiReq.getData().getUnitId();
        if (userId == null) {
            return Result.fail("用户id不能为空");
        }
        WorkLogAuthorityExample authorityExample = new WorkLogAuthorityExample();
        authorityExample.createCriteria().andUserIdEqualTo(userId).andUnitIdEqualTo(unitId);
        List<WorkLogAuthority> authorityList = workLogAuthorityService.find(authorityExample);
        List<Long> userIds = new ArrayList<>();
        if (authorityList != null && authorityList.size() > 0) {
            for (WorkLogAuthority authority : authorityList) {
                userIds.add(authority.getBeViewedUser());
            }
        }

        WorkLogExample workLogExample = new WorkLogExample();
        //String unitId = openApiReq.getData().getUnitId();
        if (userIds != null && userIds.size() > 0) {
            workLogExample.createCriteria().andUserIdIn(userIds).andMainOrgIdEqualTo(unitId);
            workLogExample.setOrderByClause("create_date desc");
        } else {
            return Result.success(null);
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<WorkLog> list = workLogService.find(workLogExample);
        PageInfo<WorkLogDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(list, WorkLogDTO.class));
        if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
            for (WorkLogDTO workLogDTO : pageDTO.getList()) {
                // WorkLogDTO workLogDTO = new WorkLogDTO();
                WorkLogDetailExample workLogDetailExample = new WorkLogDetailExample();
                workLogDetailExample.createCriteria().andLogIdEqualTo(workLogDTO.getId());
                workLogDetailExample.setOrderByClause("create_time asc");
                List<WorkLogDetailDTO> listDetail = dozerUtils.mapList(workLogDetailService.find(workLogDetailExample), WorkLogDetailDTO.class);
                List<WorkLogDetailDTO> detailDTOS = new ArrayList<>();
                if (listDetail != null && listDetail.size() > 0) {
                    for (WorkLogDetailDTO workLogDetailDTO : listDetail) {
                        WorkLogFileExample workLogFileExample = new WorkLogFileExample();
                        workLogFileExample.createCriteria().andLogDetailIdEqualTo(workLogDetailDTO.getId());
                        List<WorkLogFileDTO> workLogFile = dozerUtils.mapList(workLogFileService.find(workLogFileExample), WorkLogFileDTO.class);
                        ;
                        workLogDetailDTO.setWorkLogFileDTOS(workLogFile);
                        detailDTOS.add(workLogDetailDTO);
                    }
                }
                WorkLogLookExample lookExample = new WorkLogLookExample();
                lookExample.createCriteria().andUserIdEqualTo(userId).andLogIdEqualTo(workLogDTO.getId());
                WorkLogLook look = workLogLookService.getUnique(lookExample);
                if (look != null) {
                    workLogDTO.setStatus(2);//已查看
                } else {
                    workLogDTO.setStatus(1);//未查看
                }
                WorkLogAnswerExample example = new WorkLogAnswerExample();
                example.createCriteria().andWorkLogIdEqualTo(workLogDTO.getId());
                example.setOrderByClause("create_time asc");
                List<WorkLogAnswerDTO> answerList = dozerUtils.mapList(workLogAnswerService.find(example), WorkLogAnswerDTO.class);
                List<WorkLogAnswerDTO> answerDtoList=new ArrayList<>();
                if (answerList != null && answerList.size() > 0) {
                    for(WorkLogAnswerDTO answerDTO:answerList){
                        Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(answerDTO.getUserId());
                        answerDTO.setCreateUser(orgDeptDutyInfo.getData().getUserName());
                        answerDTO.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                        answerDtoList.add(answerDTO);
                    }
                    workLogDTO.setWorkLogAnswerDTOS(answerDtoList);
                } else {
                    workLogDTO.setWorkLogAnswerDTOS(null);
                }
                Result<OrgDeptDutyInfoDTO> orgInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(workLogDTO.getUserId());
                workLogDTO.setPhoto(orgInfo.getData().getPhoto());
                workLogDTO.setUserName(orgInfo.getData().getUserName());
                workLogDTO.setCreateDate(workLogDTO.getCreateDate());
                workLogDTO.setWorkLogDetailDTOS(detailDTOS);
            }
        }
        return Result.success(pageDTO);
    }

    
    @ApiOperation(value = "根据日志id,查询相应的回复信息", notes = "根据日志id,查询相应的回复信息")
    @RequestMapping(value = "/getAnswerList", method = RequestMethod.GET)
    public Result<List<WorkLogAnswerDTO>> getAnswerList(@RequestParam(value = "workLogId") Long workLogId) {

        if (workLogId == null) {
            return Result.fail("工作日子id不能为空");
        }
        WorkLogAnswerExample workLogAnswerExample = new WorkLogAnswerExample();
        workLogAnswerExample.createCriteria().andWorkLogIdEqualTo(workLogId);
        workLogAnswerExample.setOrderByClause("create_time asc");
        List<WorkLogAnswerDTO> List = dozerUtils.mapList(workLogAnswerService.find(workLogAnswerExample), WorkLogAnswerDTO.class);
        List<WorkLogAnswerDTO> dtoList = new ArrayList<>();
        if (List != null && List.size() > 0) {
            for (WorkLogAnswerDTO dto : List) {
                Result<OrgDeptDutyInfoDTO> orgInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(dto.getUserId());
                dto.setCreateUser(orgInfo.getData().getUserName());
                dto.setPhoto(orgInfo.getData().getPhoto());
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    
    @ApiOperation(value = "根据日志用户id,查询相应的可查看人信息", notes = "根据日志用户id,查询相应的可查看人信息")
    @RequestMapping(value = "/getAuthorityList", method = RequestMethod.GET)
    public Result<List<WorkLogLookDTO>> getAuthorityList(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "userId") Long userId) {
        if (userId == null) {
            return Result.fail("用户id不能为空");
        }
        if (unitId == null) {
            return Result.fail("用户单位id不能为空");
        }
        /*WorkLog getWorkLog = workLogService.getByUserId(userId, unitId);
        if (getWorkLog == null) {
            return Result.success(null);
        } else {*/
            WorkLogAuthorityExample example = new WorkLogAuthorityExample();
            example.createCriteria().andBeViewedUserEqualTo(userId).andUnitIdEqualTo(unitId);
            List<WorkLogAuthorityDTO> list = dozerUtils.mapList(workLogAuthorityService.find(example), WorkLogAuthorityDTO.class);
            Long useId = null;
            List<WorkLogLookDTO> workLogLookDTOS = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (WorkLogAuthorityDTO dto : list) {
                    useId = dto.getUserId();
                    WorkLogLookDTO workLogLookDTO = new WorkLogLookDTO();
                    Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(useId);
                    if (orgDeptDutyInfo.getData() != null) {
                        workLogLookDTO.setName(orgDeptDutyInfo.getData().getUserName());
                        workLogLookDTO.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                        workLogLookDTO.setUserId(dto.getUserId());
                    }
                    workLogLookDTOS.add(workLogLookDTO);
                }

            }
          return Result.success(workLogLookDTOS);
    }

    
    @ApiOperation(value = "保存已查看工作日志信息", notes = "保存已查看工作日志信息")
    @ApiResponses({
            @ApiResponse(code = 91503, message = "日志ID不能为空"),
            @ApiResponse(code = 91504, message = "用户ID不能为空")
    })
    @RequestMapping(value = "/workLogLook", method = RequestMethod.POST)
    public Result<WorkLogLookSaveDTO> saveWorkLogLook(@RequestBody WorkLogLookSaveDTO lookSaveDTO) {

        //1.校验
        BizAssert.assertNotNull(MtExceptionCode.WORK_LOG_ID_NULL, lookSaveDTO.getLogId());
        BizAssert.assertNotNull(MtExceptionCode.WORK_USER_ID_NULL, lookSaveDTO.getUserId());
        Long userId = BaseContextHandler.getAdminId();
        //转换
        WorkLogLookExample lookExample = new WorkLogLookExample();
        lookExample.createCriteria().andLogIdEqualTo(lookSaveDTO.getLogId()).andUserIdEqualTo(lookSaveDTO.getUserId());
        WorkLogLook look = workLogLookService.getUnique(lookExample);
        if (look != null) {
            return Result.success(null);
        } else {
            WorkLogLook workLogLook = dozerUtils.map(lookSaveDTO, WorkLogLook.class);
            workLogLook.setCreateUser(userId);
            workLogLook.setUpdateUser(userId);
            //保存
            workLogLookService.saveSelective(workLogLook);
            return Result.success(dozerUtils.map(workLogLook, WorkLogLookSaveDTO.class));
        }
    }

    
    @ApiOperation(value = "根据id查询工作日志信息", notes = "根据id查询工作日志信息")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public Result<WorkLogDetailDTO> getDetail(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("工作日志详情id不能为空");
        }
        WorkLogDetail workLogDetail = workLogDetailService.getById(id);
        if (workLogDetail == null) {
            return Result.fail("工作日志详情为空");
        }
        WorkLogDetailDTO dto = dozerUtils.map(workLogDetail, WorkLogDetailDTO.class);
        WorkLogFileExample workLogFileExample = new WorkLogFileExample();
        workLogFileExample.createCriteria().andLogDetailIdEqualTo(dto.getId());
        List<WorkLogFileDTO> workLogFile = dozerUtils.mapList(workLogFileService.find(workLogFileExample), WorkLogFileDTO.class);
        ;
        dto.setWorkLogFileDTOS(workLogFile);
        return Result.success(dto);
    }

    
    @ApiOperation(value = "修改工作日志详情信息", notes = "修改工作日志详情信息")
    @ValidatorStandard(
            {
                    @Constraint(value = WorkLog.class)
            }
    )
    @RequestMapping(value = "/updateDetail", method = RequestMethod.POST)
    public Result<WorkLogDetailDTO> updateDetail(@RequestBody WorkLogDetailDTO workLogDetailDTO) {
        Long userId = BaseContextHandler.getAdminId();
        Long logId = workLogDetailDTO.getLogId();
        String unitId= workLogDetailDTO.getUnitId();
        if (logId == null) {
            return Result.fail("日志i不能为空！");
        }
        WorkLogDetail workLogDetail = dozerUtils.map(workLogDetailDTO, WorkLogDetail.class);
        workLogDetail.setUpdateUser(userId);
        workLogDetailService.updateByIdSelective(workLogDetail);
        List<Long> userIds=workLogDetailDTO.getUserIds();
        List<WorkLogAuthority> lookList = new ArrayList<>();
        if(userIds!=null && userIds.size()>0) {
            WorkLogAuthorityExample authorityExample = new WorkLogAuthorityExample();
            authorityExample.createCriteria().andBeViewedUserEqualTo(userId).andUnitIdEqualTo(unitId);
            List<WorkLogAuthority> authorities = workLogAuthorityService.find(authorityExample);
            if (authorities != null && authorities.size() > 0) {
                for (WorkLogAuthority workLogAuthority : authorities) {
                    workLogAuthorityService.deleteById(workLogAuthority.getId());
                }
            }
            for (Long user : userIds) {
                if(user!=null) {
                    WorkLogAuthority workLogAuthority = new WorkLogAuthority();
                    workLogAuthority.setUserId(user);//查看人id
                    workLogAuthority.setBeViewedUser(userId);//被查看人id
                    workLogAuthority.setUnitId(unitId);//单位id
                    workLogAuthority.setCreateUser(userId);
                    workLogAuthority.setUpdateUser(userId);
                    lookList.add(workLogAuthority);
                }
            }
        }
        workLogAuthorityService.save(lookList);
        WorkLogFileExample fileExample = new WorkLogFileExample();
        fileExample.createCriteria().andLogDetailIdEqualTo(workLogDetailDTO.getId());
        List<WorkLogFile> logFileList = workLogFileService.find(fileExample);
        if (logFileList != null && logFileList.size() > 0) {
            for (WorkLogFile workLogFile : logFileList) {
                workLogFileService.deleteById(workLogFile.getId());
            }
        }

        List<WorkLogFileDTO> files = workLogDetailDTO.getWorkLogFileDTOS();
        List<WorkLogFile> fileList = new ArrayList<>();
        for (WorkLogFileDTO fdto : files) {
            WorkLogFile file = dozerUtils.map(fdto, WorkLogFile.class);
            file.setLogId(logId);
            file.setLogDetailId(workLogDetail.getId());
            file.setUserId(userId);
            fileList.add(file);
        }
        workLogFileService.save(fileList);
        return Result.success(dozerUtils.map(workLogDetail, WorkLogDetailDTO.class));
    }

    
    @ApiOperation(value = "根据工作日志logId查询已查看或未查看人信息", notes = "根据工作日志logId查询已查看或未查看人信息")
    @RequestMapping(value = "/getLookUser", method = RequestMethod.GET)
    public Result<List<WorkLogLookDTO>> getLookUser(@RequestParam(value = "logId") Long logId, @RequestParam(value = "status") Integer status) {
        if (logId == null) {
            return Result.fail("日志id不能为空");
        }
        if (status == null) {
            return Result.fail("查看状态不能为空");
        }
        if (status == 1) {//未读
            WorkLog log=workLogService.getById(logId);
            List<WorkLogLookDTO> lookDTOS = new ArrayList<>();
            WorkLogAuthorityExample authorityExample = new WorkLogAuthorityExample();
            authorityExample.createCriteria().andBeViewedUserEqualTo(log.getUserId()).andUnitIdEqualTo(log.getMainOrgId());
            List<WorkLogAuthority> authorityList = workLogAuthorityService.find(authorityExample);
            if(authorityList!=null && authorityList.size()>0) {
                for (WorkLogAuthority workLogAuthority : authorityList) {
                    Long userId = workLogAuthority.getUserId();
                    WorkLogLookExample lookExample = new WorkLogLookExample();
                    lookExample.createCriteria().andUserIdEqualTo(userId).andLogIdEqualTo(logId);
                    List<WorkLogLook> lookList = dozerUtils.mapList(workLogLookService.find(lookExample), WorkLogLook.class);
                    if (lookList.size()==0) {
                        WorkLogLookDTO workLogLookDTO = new WorkLogLookDTO();
                        Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(userId);
                        if (orgDeptDutyInfo.getData() != null) {
                            workLogLookDTO.setUserId(userId);
                            workLogLookDTO.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                            workLogLookDTO.setName(orgDeptDutyInfo.getData().getUserName());
                        }
                        lookDTOS.add(workLogLookDTO);
                    }
                }
            }
            return Result.success(lookDTOS);
        } else {//已读
            WorkLogLookExample lookExample = new WorkLogLookExample();
            lookExample.createCriteria().andLogIdEqualTo(logId);
            List<WorkLogLook> lookList = dozerUtils.mapList(workLogLookService.find(lookExample), WorkLogLook.class);
            List<WorkLogLookDTO> list = new ArrayList<>();
            if (lookList != null && lookList.size() > 0) {
                for (WorkLogLook look : lookList) {
                    Long userId = look.getUserId();
                    WorkLogLookDTO dto = new WorkLogLookDTO();
                    Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(userId);
                    if (orgDeptDutyInfo.getData() != null) {
                        dto.setPhoto(orgDeptDutyInfo.getData().getPhoto());
                        dto.setName(orgDeptDutyInfo.getData().getUserName());
                        dto.setUserId(userId);
                    }
                    list.add(dto);
                }
            }
            return Result.success(list);
        }

    }

    
    @ApiOperation(value = "根据用户id查询工作日志", notes = "根据用户id查询工作日志")
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public Result<List<WorkLogDTO>> getByUserId(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "userId") Long userId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) {
        if (userId == null) {
            return Result.fail("用户id不能为空");
        }
        if (unitId == null) {
            return Result.fail("用户单位id不能为空");
        }
        Date start = null;
        Date end = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);

        WorkLogExample workLogExample = new WorkLogExample();

        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
            if (endTime != null && endTime != "") {
                end = formatter.parse(endTime, poss);
                workLogExample.createCriteria().andUserIdEqualTo(userId).andMainOrgIdEqualTo(unitId).
                        andCreateDateGreaterThanOrEqualTo(start).andCreateDateLessThanOrEqualTo(end);
            } else {
                workLogExample.createCriteria().andUserIdEqualTo(userId).andMainOrgIdEqualTo(unitId).andCreateDateGreaterThanOrEqualTo(start);
            }
        } else {
            if (endTime != null && endTime != "") {
                end = formatter.parse(endTime, poss);
                workLogExample.createCriteria().andUserIdEqualTo(userId).andMainOrgIdEqualTo(unitId).andCreateDateLessThanOrEqualTo(end);
            } else {
                workLogExample.createCriteria().andUserIdEqualTo(userId).andMainOrgIdEqualTo(unitId);
            }
        }
        workLogExample.setOrderByClause("create_date desc");
        List<WorkLogDTO> listOne = new ArrayList<>();

        List<WorkLog> list = dozerUtils.mapList(workLogService.find(workLogExample), WorkLog.class);
        if (list != null && list.size() > 0) {
            for (WorkLog workLog : list) {
                WorkLogDTO workLogDTO = new WorkLogDTO();
                WorkLogDetailExample workLogDetailExample = new WorkLogDetailExample();
                workLogDetailExample.createCriteria().andLogIdEqualTo(workLog.getId());
                workLogDetailExample.setOrderByClause("create_time asc");
                List<WorkLogDetailDTO> listDetail = dozerUtils.mapList(workLogDetailService.find(workLogDetailExample), WorkLogDetailDTO.class);

                WorkLogLookExample lookExample = new WorkLogLookExample();
                lookExample.createCriteria().andUserIdEqualTo(userId).andLogIdEqualTo(workLog.getId());
                WorkLogLook look = workLogLookService.getUnique(lookExample);
                if (look != null) {
                    workLogDTO.setStatus(2);
                } else {
                    workLogDTO.setStatus(1);
                }
                workLogDTO.setId(workLog.getId());
                workLogDTO.setUserName(workLog.getUserName());
                workLogDTO.setPhoto(workLog.getPhoto());
                workLogDTO.setCreateDate(workLog.getCreateDate());
                workLogDTO.setWorkLogDetailDTOS(listDetail);
                WorkLogAnswerExample example = new WorkLogAnswerExample();
                example.createCriteria().andWorkLogIdEqualTo(workLog.getId());
                List<WorkLogAnswerDTO> answerList = dozerUtils.mapList(workLogAnswerService.find(example), WorkLogAnswerDTO.class);
                if (answerList != null && answerList.size() > 0) {
                    workLogDTO.setWorkLogAnswerDTOS(answerList);
                } else {
                    workLogDTO.setWorkLogAnswerDTOS(null);
                }
                listOne.add(workLogDTO);
            }

        }
        return Result.success(listOne);
    }

    
    @ApiOperation(value = "查询用户当前月写了多少日志", notes = "查询用户当前月写了多少日志")
    @RequestMapping(value = "/getMonthCount", method = RequestMethod.GET)
    public Result<Integer> getMonthCount() {
        Long userId = BaseContextHandler.getAdminId();

        //查询设置的单位id
        UserConfigExample example = new UserConfigExample();
        UserConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andJobIdEqualTo(UserConfigJobType.now_unity_id.jobId);
        UserConfig uConfig = userConfigService.getUnique(example);
        if (uConfig == null) {
            return Result.fail("没有设置主单位");
        }
        int count = workLogService.getMonthCount(userId, uConfig.getJobValue());

        return Result.success(count);
    }

}


