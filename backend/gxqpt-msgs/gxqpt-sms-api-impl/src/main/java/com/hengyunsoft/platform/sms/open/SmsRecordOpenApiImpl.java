package com.hengyunsoft.platform.sms.open;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SmsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.sms.dto.QuerySmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsChannelDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDetailDTO;
import com.hengyunsoft.platform.sms.entity.template.po.SendStatus;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;
import com.hengyunsoft.platform.sms.repository.template.service.SendStatusService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsChannelOwnerService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsRecordService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
/**
 * 短信记录服务
 * @author dxz
 */
@RestController
@Slf4j
@Api(value = "短信记录服务", description = "短信记录服务")
public class SmsRecordOpenApiImpl implements SmsRecordOpenApi{
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private SendStatusService sendStatusService;
	@Autowired
	private SmsRecordService smsRecordService;
	@Autowired
	private MsgsChannelService msgsChannelService;
	@Autowired
	private SmsChannelOwnerService smsChannelOwnerService;
	@Autowired
	private SmsTemplateService smsTemplateService;
    /**
     * 查询短信记录列表、草稿列表
     * @return
     */
	@Override
    @ApiOperation(value="获取分页列表",notes = "获取分页列表")
    @ApiResponses({
        @ApiResponse(code = 45110, message = "参数错误"),
    })
	public Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(@RequestBody OpenApiReq<QuerySmsRecordDTO> openApiReq) {
		QuerySmsRecordDTO querySmsRecordDTO = openApiReq.getData();
		BizAssert.assertNotNull(SmsExceptionCode.SMS_RECORDPARAM_ERROR,querySmsRecordDTO);
		try {
			Long userId = BaseContextHandler.getAdminId();
			String appId = BaseContextHandler.getAppId();
			SmsRecordExample smsRecordExample = new SmsRecordExample();
			String topic = querySmsRecordDTO.getTopic();
			String channelId = querySmsRecordDTO.getChannelId();
			if(querySmsRecordDTO.getDraft()==1){
				smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
				.andTopicLike(SmsRecordExample.fullLike(topic)).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
				.andCreateTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime());
			}else{
				smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
				.andTopicLike(SmsRecordExample.fullLike(topic)).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
				.andSendTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime());
			}
			smsRecordExample.setOrderByClause("create_time desc");
			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
			List<SmsRecord> list = smsRecordService.find(smsRecordExample);
			List<SmsRecordDTO> pageDate = dozerUtils.mapPage(list, SmsRecordDTO.class);
			//渠道名称
			if(StringUtil.isNotEmpty(channelId)){
				MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(channelId));
				if(msgsChannel!=null){										
					for(SmsRecordDTO smsRecordDTO:pageDate){
						smsRecordDTO.setChannelName(msgsChannel.getName());
					}
				}
			}else{
				if(list!=null&&list.size()!=0){					
					SmsChannelOwnerExample smsChannelOwnerExample = new SmsChannelOwnerExample();
					smsChannelOwnerExample.createCriteria().andAppIdEqualTo(appId);		
					List<SmsChannelOwner> channelList = smsChannelOwnerService.find(smsChannelOwnerExample);
					Map<String,String> map = new HashMap<String,String>();
					for(SmsChannelOwner smsChannelOwner:channelList){
						map.put(String.valueOf(smsChannelOwner.getChannelId()), smsChannelOwner.getChannelName());
					}
					for(SmsRecordDTO smsRecordDTO:pageDate){						
						smsRecordDTO.setChannelName(map.get(smsRecordDTO.getChannelId()));
					}
				}				
			}
			return Result.success(new PageInfo<>(pageDate));
		} catch (Exception e) {
			log.error("获取短信记录列表、草稿列表出错",e);
			return Result.fail("获取短信记录列表、草稿列表出错");
		}
	}
    /**
     * 查询短信记录详情、草稿详情
     * @return
     */
	@Override
    @ApiOperation(value = "查询短信记录详情、草稿详情", notes = "查询短信记录详情、草稿详情")
    @ApiResponses({
            @ApiResponse(code = 45111, message = "短信信息ID为空"),
    })
	public Result<SmsRecordDetailDTO> getSmsRecordDetail(@RequestParam(value = "msgId") String msgId) {
		BizAssert.assertNotEmpty(SmsExceptionCode.SMS_MSGID_NULL,msgId);
		try {
			SmsRecord smsRecord = smsRecordService.selectByMsgId(msgId);
			//获取发送成功、失败个数
			List<SendStatus> smsList = sendStatusService.getByMsgId(msgId);
			String templateName = "";
			String content = "";
			if(smsRecord.getTemplateId()!=null){
				SmsTemplate smsTemplate = smsTemplateService.getById(smsRecord.getTemplateId());
				templateName = smsTemplate.getName();
				content = smsTemplate.getContent();
			}			
			int success = 0;
			int error = 0;
			if(smsList!=null&&smsList.size()!=0){
				for(SendStatus sendStatus:smsList){
					Integer status = sendStatus.getSendStatus();
					if(status==1){
						success += 1;
					}else if(status==2){
						error += 1;
					}
				}
			}
			SmsRecordDetailDTO smsRecordDetailDTO = dozerUtils.map(smsRecord, SmsRecordDetailDTO.class);
			MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(smsRecordDetailDTO.getChannelId()));
			if(msgsChannel!=null){
				smsRecordDetailDTO.setChannelName(msgsChannel.getName());
				smsRecordDetailDTO.setChannelServer(msgsChannel.getChannelServer());
			}
			smsRecordDetailDTO.setSuccess(success);
			smsRecordDetailDTO.setFail(error);
			smsRecordDetailDTO.setTemplateName(templateName);
			smsRecordDetailDTO.setContent(content);
			return Result.success(smsRecordDetailDTO);		
		} catch (Exception e) {
			log.error("获取短信记录详情、草稿详情出错",e);
			return Result.fail("获取短信记录详情、草稿详情出错");
		}
	}
    /**
     * 查询短信渠道
     */
	@Override
    @ApiOperation(value = "查询短信账号", notes = "查询短信账号")
    @ApiResponses({
        @ApiResponse(code = 45114, message = "应用程序ID不能为空"),
    })
	public Result<List<SmsChannelDTO>> getSmsChannelList(@RequestParam(value = "appId") String appId) {		
		BizAssert.assertNotNull(SmsExceptionCode.SMS_APPID_NULL,appId);		
		SmsChannelOwnerExample smsChannelOwnerExample = new SmsChannelOwnerExample();
		try {
			if(StringUtils.isEmpty(appId)){
				return Result.fail("参数错误");
			}
			smsChannelOwnerExample.createCriteria().andAppIdEqualTo(appId);		
			List<SmsChannelOwner> list = smsChannelOwnerService.find(smsChannelOwnerExample);
			List<SmsChannelDTO> result = dozerUtils.mapPage(list, SmsChannelDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("获取短信账号出错",e);
			return Result.fail("获取短信账号出错");
		}
	}
	 /**
     * 删除草稿
     */
	@Override
    @ApiOperation(value = "删除草稿", notes = "删除草稿")
    @ApiResponses({
        @ApiResponse(code = 45112, message = "短信记录ID不能为空"),
    })
	public Result<String> deleteSmsDraftById(@RequestParam(value = "recordId") Long recordId) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ID_NULL,recordId);
		try {
			int result = smsRecordService.deleteById(recordId);
			if(result>0){
				return Result.success("success");
			}
		} catch (Exception e) {
			log.error("删除草稿出错",e);
			return Result.fail("删除草稿出错");
		}
		return Result.fail("fail");
	}
}
