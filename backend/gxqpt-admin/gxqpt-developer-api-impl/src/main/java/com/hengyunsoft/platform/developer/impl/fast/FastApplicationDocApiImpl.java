package com.hengyunsoft.platform.developer.impl.fast;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.FastApplicationDocApi;
import com.hengyunsoft.platform.developer.api.fast.dto.docment.*;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocExtraAdvice;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocTask;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocTaskJnl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocUserConfig;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocExtraAdviceExample;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocTaskExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocExtraAdviceService;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocTaskJnlService;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocTaskService;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocUserConfigService;
import com.hengyunsoft.platform.msgs.dto.msg.OfficeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.OfficeSaveDTO;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "API - FastApplicationDocApiImpl", description = "快速应用公文服务管理")
@RestController
@RequestMapping("/fastapplicationdoc")
@Slf4j
public class FastApplicationDocApiImpl implements FastApplicationDocApi {

    @Autowired
    private FastAppDocTaskService fastAppDocTaskService;
    @Autowired
    private FastAppDocTaskJnlService fastAppDocTaskJnlService;
    @Autowired
    private FastAppDocExtraAdviceService fastAppDocExtraAdviceService;
    @Autowired
    private FastAppDocUserConfigService fastAppDocUserConfigService;
//    @Autowired
//    private OfficeApi officeApi;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 公文登记
     */
    private static final String FAST_APP_DOC_REGISTER = "register";
    /**
     * 处室领导审批
     */
    private static final String FAST_APP_DOC_DIRECTOR_LEADER = "directorLeader";
    /**
     * 分管领导审批
     */
    private static final String FAST_APP_DOC_DIVISION_LEADER = "divisionLeader";
    /**
     * 主要领导审批
     */
    private static final String FAST_APP_DOC_MAIN_LEADER = "mainLeader";
    /**
     * 办结
     */
    private static final String FAST_APP_DOC_FINISHED = "finished";
    /**
     * 处理中
     */
    private static final String FAST_APP_DOC_PROCESSING = "processing";
    @Value("${fast-url}")
    private String fastUrl;

    /**
     * 描述：快速应用公文审批Api
     * 参数：FastAppDocTaskApproveDTO
     * 返回值：Boolean
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "快速应用公文审批", notes = "快速应用公文审批")
    @ApiResponses({
    })
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public Result<Boolean> approve(@RequestBody FastAppDocTaskApproveDTO dto) {

        //1.验证
        //办结状态
       /* 环节状态：公文登记（register）处室领导审批（directorLeader）
        分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）*/
        FastAppDocTask task = fastAppDocTaskService.getById(dto.getId());

        String nextStatus = null;
        String currentStatus = getStatusByKey(task.getLinkStatus());
        if(currentStatus==null){
            System.out.println("环节状态不正确!!");
            return Result.success(false);
        }
        if(!FAST_APP_DOC_FINISHED.equals(currentStatus)){
             nextStatus = getStatusByKey(currentStatus);
        }

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        Date date = new Date();

        //3、转换并赋初值
        FastAppDocTask fastAppDocTask = dozerUtils.map(dto, FastAppDocTask.class);
        fastAppDocTask.setId(dto.getId());
        fastAppDocTask.setUpdateUser(userId);
        fastAppDocTask.setUpdateTime(date);
        fastAppDocTask.setCurrentUserType(currentStatus);
        fastAppDocTask.setLinkStatus(currentStatus);
        if(nextStatus!=null){
            fastAppDocTask.setNextUserType(nextStatus);
        }
        //更新所有为 FAST_APP_DOC_FINISHED 前端判断 此处按钮为办结即可；
        if(FAST_APP_DOC_MAIN_LEADER.equals(task.getLinkStatus())){
            fastAppDocTask.setHandleStatus(FAST_APP_DOC_FINISHED);
            fastAppDocTask.setCurrentUserType(FAST_APP_DOC_FINISHED);
            fastAppDocTask.setLinkStatus(FAST_APP_DOC_FINISHED);
        }

        //4、修改
        fastAppDocTaskService.updateByIdSelective(fastAppDocTask);
        OfficeSaveDTO officeDto = new OfficeSaveDTO();
        officeDto.setCreateUser(name);
        officeDto.setCreateUserId(userId);
        officeDto.setTask(dto.getTitle());
        if("send".equals(dto.getDocType())){
            officeDto.setTaskUrl(fastUrl + "/fast/" + dto.getAppId() + "?url=/gxqpt-fast/fast/" + dto.getAppId() + "/document/taskSendFile"); //
        }else{
            officeDto.setTaskUrl(fastUrl + "/fast/" + dto.getAppId() + "?url=/gxqpt-fast/fast/" + dto.getAppId() + "/document/taskRecvFile"); //
        }
        officeDto.setTopic(dto.getDocType().equals("send")?"发文":"收文");
        officeDto.setUrgent(2);//紧急程度
        String testId = String.valueOf(userId);

        //管理员
        if(testId.equals("1")){
            officeDto.setReceiverId(new Long(2)); //接收人

//            Result<OfficeDTO> result = officeApi.addOffice(officeDto);
//            if(result.isSuccess() && result.getData()!= null){
//                FastAppDocUserConfig fc = new FastAppDocUserConfig();
//                fc.setId(new Long(34));
//                fc.setCreateUser(new Long(2));
//                fc.setUpdateUser(result.getData().getId());
//                fastAppDocUserConfigService.updateByIdSelective(fc);
//            }
        }else if(testId.equals("2")){
            officeDto.setReceiverId(new Long(3)); //接收人

//            Result<OfficeDTO> result = officeApi.addOffice(officeDto);
//
//            if(result.isSuccess() && result.getData()!= null){
//                FastAppDocUserConfig fc = new FastAppDocUserConfig();
//                fc.setId(new Long(35));
//                fc.setCreateUser(new Long(3));
//                fc.setUpdateUser(result.getData().getId());
//                fastAppDocUserConfigService.updateByIdSelective(fc);
//            }
//            FastAppDocUserConfig fc = fastAppDocUserConfigService.getById(new Long(34));
//            officeApi.deleteOffice(fc.getUpdateUser());
        }else if(testId.equals("3")){
            officeDto.setReceiverId(new Long(4)); //接收人
 
//            Result<OfficeDTO> result = officeApi.addOffice(officeDto);

//            if(result.isSuccess() && result.getData()!= null){
//                FastAppDocUserConfig fc = new FastAppDocUserConfig();
//                fc.setId(new Long(36));
//                fc.setCreateUser(new Long(4));
//                fc.setUpdateUser(result.getData().getId());
//                fastAppDocUserConfigService.updateByIdSelective(fc);
//            }

            FastAppDocUserConfig fc = fastAppDocUserConfigService.getById(new Long(35));
//            officeApi.deleteOffice(fc.getUpdateUser());

        }else if(testId.equals("4")){
            FastAppDocUserConfig fc = fastAppDocUserConfigService.getById(new Long(36));
//            officeApi.deleteOffice(fc.getUpdateUser());
        }
        log.info("{},发送收发文待办信息成功，接收人，{}",testId,officeDto.getReceiverId());
        return Result.success(true);
    }

    /**
     * 描述：快速应用公文更新Api
     * 参数：FastAppDocTaskUpdateDTO
     * 返回值：Boolean
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @ApiOperation(value = "快速应用公文更新", notes = "快速应用公文更新")
    @ApiResponses({

    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody FastAppDocTaskUpdateDTO dto) {

        //1.验证


        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        FastAppDocTask fastAppDocTask = dozerUtils.map(dto, FastAppDocTask.class);
        fastAppDocTask.setUpdateUser(userId);
        fastAppDocTask.setUpdateTime(date);

        //4、修改
        fastAppDocTaskService.updateByIdSelective(fastAppDocTask);
        return Result.success(true);
    }

    /**
     * 描述：快速应用公文分页Api
     * 参数：[FastAppDocTaskPageDTO]
     * 返回值：<PageInfo<FastAppDocTaskPageRetDTO>>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "快速应用分页", notes = "快速应用分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<FastAppDocTaskPageRetDTO>> page(@RequestBody OpenApiReq<FastAppDocTaskPageDTO> openApiReq) {
        //1.获取基础数据
        Date endTime = null;
        Date startTime = null;
        String handleStatus = null;
        String fileName = null;
        String docType = null;
        String content = null;
        String docNum = null;
        String draftedPersonName = null;
        String appId = null;
        Long userId = BaseContextHandler.getAdminId();
        if(openApiReq.getData()!=null){
            if(StringUtils.isNotEmpty(openApiReq.getData().getHandleStatus())){
                handleStatus = openApiReq.getData().getHandleStatus();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getFileName())){
                fileName = openApiReq.getData().getFileName();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getDocNum())){
                docNum = openApiReq.getData().getDocNum();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getDocType())){
                docType = openApiReq.getData().getDocType();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getContent())){
                content = openApiReq.getData().getContent();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getDraftedPersonName())){
                draftedPersonName = openApiReq.getData().getDraftedPersonName();
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getStartTime())){
                startTime = getDate(openApiReq.getData().getStartTime());
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getEndTime())){
                endTime = getDate(openApiReq.getData().getEndTime());
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getAppId())){
                appId = openApiReq.getData().getAppId();
            }
        }
        FastAppDocUserConfig fastAppDocUserConfig = fastAppDocUserConfigService.getByUserId(userId);
        if(fastAppDocUserConfig==null){
            return null;
        }
        //2.组装数据
        FastAppDocTaskExample example = new FastAppDocTaskExample();
        example.createCriteria().andNextUserTypeEqualTo(fastAppDocUserConfig.getUserType()).andHandleStatusEqualTo(handleStatus)
                .andDocTypeEqualTo(docType).andAppIdEqualTo(appId)
                .andDocNumLike(FastAppDocTaskExample.fullLike(docNum))
                .andAttachmentNameLike(FastAppDocTaskExample.fullLike(fileName))
                .andContentLike(FastAppDocTaskExample.fullLike(content))
                .andCreateUserNameLike(FastAppDocTaskExample.fullLike(draftedPersonName))
                .andCreateTimeBetween(startTime,endTime);
        example.setOrderByClause("id asc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询并返回
        return Result.success(new PageInfo<>(dozerUtils.mapPage(fastAppDocTaskService.find(example), FastAppDocTaskPageRetDTO.class)));

    }

    /**
     * 描述：根据id查询快速应用公文详情Api
     * 参数：id
     * 返回值：FastAppDocTaskRetDTO
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据id查询快速应用详情", notes = "根据id查询快速应用详情")
    @ApiResponses({

    })
    @RequestMapping(value = "/taskDetail", method = RequestMethod.GET)
    public Result<FastAppDocTaskRetDTO> getById(@RequestParam Long id) {

        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.MODULE_APPLY_ID_NULL, id);

        //2、执行查询
        FastAppDocTask fastAppDocTask = fastAppDocTaskService.getById(id);
        if (fastAppDocTask == null) {
            return Result.success(null);
        }

        //3、返回结果
        return Result.success(dozerUtils.map(fastAppDocTask, FastAppDocTaskRetDTO.class));
    }


    /**
     * 描述：根据id查询快速应用公文拟办详情Api
     * 参数：taskId
     * 返回值：List<FastAppDocExtraAdviceRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据id查询快速应用详情", notes = "根据id查询快速应用详情")
    @ApiResponses({

    })
    @RequestMapping(value = "/taskExtraDetail", method = RequestMethod.GET)
    public Result<List<FastAppDocExtraAdviceRetDTO>> getByTaskId(@RequestParam Long taskId) {

        //1、验证


        //2、执行查询
        FastAppDocExtraAdviceExample example = new FastAppDocExtraAdviceExample();
        example.createCriteria().andTaskIdEqualTo(taskId);
        List<FastAppDocExtraAdvice> list = fastAppDocExtraAdviceService.find(example);
        if (list == null) {
            return Result.success(null);
        }

        //2、根据appId查询我的功能列表
        List<FastAppDocExtraAdviceRetDTO> dto = dozerUtils.mapList(list, FastAppDocExtraAdviceRetDTO.class);

        //3、返回
        return Result.success(dto);
    }


    /**
     * 描述：新增公文
     * 参数：FastAppDocTaskSaveDTO
     * 返回值：Result<FastAppDocTaskSaveRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiResponses({ })
    @ApiOperation(value = "新增公文", notes = "新增公文")
    @RequestMapping(value = "/saveDoc", method = RequestMethod.POST)
    public Result<FastAppDocTaskSaveRetDTO> saveDoc(@RequestBody FastAppDocTaskSaveDTO dto) {
        //1、验证


        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        FastAppDocTask fastAppDocTask = dozerUtils.map(dto, FastAppDocTask.class);
        fastAppDocTask.setCreateTime(date);
        fastAppDocTask.setUpdateTime(date);
        fastAppDocTask.setCreateUser(userId);
        fastAppDocTask.setUpdateUser(userId);
        fastAppDocTask.setCurrentUserType(FAST_APP_DOC_REGISTER);
        fastAppDocTask.setNextUserType(FAST_APP_DOC_DIRECTOR_LEADER);
        fastAppDocTask.setHandleStatus(FAST_APP_DOC_PROCESSING);
        fastAppDocTask.setLinkStatus(FAST_APP_DOC_REGISTER);

        //4、保存
        fastAppDocTask = fastAppDocTaskService.save(fastAppDocTask);
        FastAppDocTaskJnl fastAppDocTaskJnl = new FastAppDocTaskJnl();
        fastAppDocTaskJnl.setTaskId(fastAppDocTask.getId());
        fastAppDocTaskJnl.setTaskStatus(FAST_APP_DOC_REGISTER);
        fastAppDocTaskJnl.setTaskType(fastAppDocTask.getDocType());
        fastAppDocTaskJnl.setCreateTime(date);
        fastAppDocTaskJnl.setUpdateTime(date);
        fastAppDocTaskJnl.setCreateUser(userId);
        fastAppDocTaskJnl.setUpdateUser(userId);
        fastAppDocTaskJnlService.save(fastAppDocTaskJnl);

        //5、返回
        return Result.success(dozerUtils.map(fastAppDocTask, FastAppDocTaskSaveRetDTO.class));

    }

    /**
     * 描述：新增拟办
     * 参数：FastAppDocExtraAdviceSaveDTO
     * 返回值：Result<FastAppDocExtraAdviceRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @Override
    @ApiResponses({ })
    @ApiOperation(value = "新增拟办", notes = "新增拟办")
    @RequestMapping(value = "/saveExtraDoc", method = RequestMethod.POST)
    public Result<FastAppDocExtraAdviceSaveRetDTO> saveExtraDoc(@RequestBody FastAppDocExtraAdviceSaveDTO dto) {

        //1、验证


        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        FastAppDocExtraAdvice fastAppDocExtraAdvice = dozerUtils.map(dto, FastAppDocExtraAdvice.class);
        fastAppDocExtraAdvice.setCreateTime(date);
        fastAppDocExtraAdvice.setUpdateTime(date);
        fastAppDocExtraAdvice.setCreateUser(userId);
        fastAppDocExtraAdvice.setUpdateUser(userId);

        //4、保存
        fastAppDocExtraAdvice = fastAppDocExtraAdviceService.save(fastAppDocExtraAdvice);

        //5、返回
        return Result.success(dozerUtils.map(fastAppDocExtraAdvice, FastAppDocExtraAdviceSaveRetDTO.class));

    }

    /**
     * 根据key获取状态
     */
    private String getStatusByKey(String key){
       /* 环节状态：公文登记（register）处室领导审批（directorLeader）
        分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）*/
        StringBuilder sb = new StringBuilder();
        sb.append(FAST_APP_DOC_REGISTER);
        sb.append(FAST_APP_DOC_DIRECTOR_LEADER);
        sb.append(FAST_APP_DOC_DIVISION_LEADER);
        sb.append(FAST_APP_DOC_MAIN_LEADER);
        sb.append(FAST_APP_DOC_FINISHED);
        if(sb.indexOf(key)==-1){
            return null;
        }
        if(FAST_APP_DOC_FINISHED.equals(key)){
            return null;
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put(FAST_APP_DOC_REGISTER,FAST_APP_DOC_DIRECTOR_LEADER);
        map.put(FAST_APP_DOC_DIRECTOR_LEADER,FAST_APP_DOC_DIVISION_LEADER);
        map.put(FAST_APP_DOC_DIVISION_LEADER,FAST_APP_DOC_MAIN_LEADER);
        map.put(FAST_APP_DOC_MAIN_LEADER,FAST_APP_DOC_FINISHED);
        return map.get(key);
    }

    /**
     * 获取日期
     * @param  dateStr
     *
     */
    private Date getDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.info("Exception",e);
        }
        return  date;
    }
}
