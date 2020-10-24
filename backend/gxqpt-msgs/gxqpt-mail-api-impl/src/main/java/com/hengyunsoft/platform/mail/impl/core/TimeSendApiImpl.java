package com.hengyunsoft.platform.mail.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.dto.core.RequestTimeAttDTO;
import com.hengyunsoft.platform.mail.dto.core.RequestTimeSendDTO;
import com.hengyunsoft.platform.mail.dto.core.RequestTimeSendDeleteDTO;
import com.hengyunsoft.platform.mail.dto.core.ResponseTimeSendDTO;
import com.hengyunsoft.platform.mail.entity.core.po.TimeAttachment;
import com.hengyunsoft.platform.mail.entity.core.po.TimeSend;
import com.hengyunsoft.platform.mail.repository.core.example.TimeAttachmentExample;
import com.hengyunsoft.platform.mail.repository.core.example.TimeSendExample;
import com.hengyunsoft.platform.mail.repository.core.service.TimeAttachmentApiService;
import com.hengyunsoft.platform.mail.repository.core.service.TimeSendApiService;
import com.hengyunsoft.platform.mail.repository.service.BWListService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：定时发送邮件API
 * 修改人：wt
 * 修改时间：2018/8/24
 * 修改内容：
 */
@Api(value = "API - TimeSendApiImpl.java", description = "定时发送邮件API")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class TimeSendApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private TimeSendApiService timeSendApiService;
    @Autowired
    private TimeAttachmentApiService timeAttachmentApiService;
    @Autowired
    private BWListService bwListService;

    /**
     * 描述：保存定时邮件
     * 参数：
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/24
     * 修改内容：
     */
    @RequestMapping(value = "/timeSend", method = RequestMethod.POST)
    @ApiOperation(value = "保存定时邮件", notes = "保存定时邮件")
    public Result<Integer> saveTimeSend(@RequestBody RequestTimeSendDTO dto){
        //基本数据的获取
        String account = AccountUtils.getAccount();
        log.info("参数RequestTimeSendDTO={}",dto);
        String checkValue = bwListService.checkKeyword(dto.getSubject(),dto.getContent());
        if(!"".equals(checkValue)){
            return Result.fail("邮件中包含'"+checkValue+"'关键字，请修改后发送！");
        }
        try {
            TimeSend timeSend = new TimeSend();
            timeSend.setMailName(account);
            timeSend.setMailFrom(dto.getFrom());
            timeSend.setMailCc(dto.getCc());
            timeSend.setContent(dto.getContent());
            timeSend.setIsReplySign(dto.getIsReplySign());
            timeSend.setSendTime(dto.getSendTime());
            timeSend.setSubject(dto.getSubject());
            timeSend.setMailTo(dto.getTo());
            timeSend.setMailType(dto.getMailType());
            TimeSend resultTimeSend = timeSendApiService.saveSelective(timeSend);
            if(dto.getAttachement() != null) {
                List<RequestTimeAttDTO> attachement = dto.getAttachement();
                for (RequestTimeAttDTO curObj : attachement) {
                    TimeAttachment timeAttachment = new TimeAttachment();
                    timeAttachment.setFileName(curObj.getFileName());
                    timeAttachment.setFileUrl(curObj.getFileUrl());
                    timeAttachment.setMailId(resultTimeSend.getId());
                    timeAttachmentApiService.saveSelective(timeAttachment);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("错误信息={}",ex);
            return Result.success(0);
        }
        return Result.success(1);
    }

    /**
     * 描述：查询邮件列表
     * 参数：邮件类型 String
     * 返回值：PageInfo<RequestTimeSendDTO>
     * 修改人：wt
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "/timefind", method = RequestMethod.POST)
    @ApiOperation(value = "查询邮件列表", notes = "查询邮件列表")
    @ApiResponses({
    })
    public Result<PageInfo<ResponseTimeSendDTO>> queryTimedsFind(@RequestBody OpenApiReq<String> openApiReq) {

        String username = AccountUtils.getAccount();
        String type = openApiReq.getData();
        TimeSendExample timeSendExample = new TimeSendExample();
        timeSendExample.createCriteria().andMailNameEqualTo(username).andMailTypeEqualTo(type);
        timeSendExample.setOrderByClause("send_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<TimeSend> timeSendList = timeSendApiService.find(timeSendExample);
        List<ResponseTimeSendDTO> requestTimeSendDTOList = dozerUtils.mapList(timeSendList,ResponseTimeSendDTO.class);
        return Result.success(new PageInfo<>(requestTimeSendDTOList));
    }

    /**
     * 描述：查询定时邮件列表
     * 参数：id
     * 返回值：ResponseTimeSendDTO
     * 修改人：wt
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "/timeget", method = RequestMethod.GET)
    @ApiOperation(value = "查询定时邮件详情", notes = "查询定时邮件列表")
    @ApiResponses({
    })
    public Result<ResponseTimeSendDTO> queryTimeFind(@RequestParam("id") Long id) {

        TimeSendExample timeSendExample = new TimeSendExample();
        timeSendExample.createCriteria().andIdEqualTo(id);
        TimeSend timeSendList = timeSendApiService.getUnique(timeSendExample);
        ResponseTimeSendDTO responseTimeSendDTO = dozerUtils.map(timeSendList,ResponseTimeSendDTO.class);

        TimeAttachmentExample timeAttachmentExample = new TimeAttachmentExample();
        timeAttachmentExample.createCriteria().andMailIdEqualTo(responseTimeSendDTO.getId());
        List<TimeAttachment> timeAttachmentList = timeAttachmentApiService.find(timeAttachmentExample);
        if(timeAttachmentList != null && timeAttachmentList.size() > 0) {
            List<RequestTimeAttDTO> requestTimeAttDTOList = dozerUtils.mapList(timeAttachmentList, RequestTimeAttDTO.class);
            responseTimeSendDTO.setAttachement(requestTimeAttDTOList);
        }
        return Result.success(responseTimeSendDTO);
    }

    /**
     * 描述：更新定时邮件
     * 参数：RequestTimeSendDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "/timeupdate", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新")
    @ApiResponses({
    })
    public Result<Integer> updateTime(@RequestBody ResponseTimeSendDTO dto) {
        Integer result = 0;
        try{
            TimeSend timeSend = dozerUtils.map(dto,TimeSend.class);
            timeSendApiService.updateByIdSelective(timeSend);
            List<RequestTimeAttDTO> requestTimeAttDTOList = dto.getAttachement();
            if(requestTimeAttDTOList != null && requestTimeAttDTOList.size() > 0){
                for (RequestTimeAttDTO curr : requestTimeAttDTOList){
                    TimeAttachment timeAttachment = dozerUtils.map(curr,TimeAttachment.class);
                    if(curr.getId() != null){
                        timeAttachmentApiService.updateByIdSelective(timeAttachment);
                    }else{
                        timeAttachment.setMailId(dto.getId());
                        timeAttachmentApiService.saveSelective(timeAttachment);
                    }
                }
            }
            result = 1;
        }catch (Exception ex){
            log.error("失败信息={}",ex);
        }
        return Result.success(result);
    }

    /**
     * 描述：多项删除定时邮件
     * 参数：RequestTimeSendDeleteDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/timedelete", method = RequestMethod.POST)
    @ApiOperation(value = "多项删除", notes = "多项删除")
    @ApiResponses({
    })
    public Result<Integer> deleteDelivery(@RequestBody RequestTimeSendDeleteDTO dto) {
        Integer result = 0;
        try{
            List<Long> idList = dto.getData();
            if(idList != null) {
                for (Long id : idList) {
                    timeSendApiService.deleteById(id);
                    TimeAttachmentExample timeAttachmentExample = new TimeAttachmentExample();
                    timeAttachmentExample.createCriteria().andMailIdEqualTo(id);
                    List<TimeAttachment> timeAttachmentList = timeAttachmentApiService.find(timeAttachmentExample);
                    if (timeAttachmentList != null && timeAttachmentList.size() > 0) {
                        List<Long> deleteIdList = new ArrayList<Long>();
                        for (TimeAttachment curr : timeAttachmentList) {
                            deleteIdList.add(curr.getId());
                        }
                        timeAttachmentApiService.deleteByIds(deleteIdList);
                    }
                }
            }
            result = 1;
        }catch (Exception ex){
            log.error("失败信息={}",ex);
        }
        return Result.success(result);
    }
}
