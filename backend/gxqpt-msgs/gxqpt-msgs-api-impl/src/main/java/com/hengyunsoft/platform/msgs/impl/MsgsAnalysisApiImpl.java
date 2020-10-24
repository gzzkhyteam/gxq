package com.hengyunsoft.platform.msgs.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgActiveSendDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAllChannelUsedDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelTypeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelUsedDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisHandleDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendErrorDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendExceptionDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgActiveSendDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageRecord;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WechatSendStatusService;
import com.hengyunsoft.platform.msgs.utils.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "消息统计分析", description = "消息统计分析")
public class MsgsAnalysisApiImpl {
	
    @Autowired
    private DozerUtils dozerUtils;	
    @Autowired
    private MsgsMessageService msgsMessageService;
    @Autowired
    private MsgsChannelService msgsChannelService;
	@Autowired
    private BlogMessageRecordService blogMessageRecordService;
	@Autowired
    private WeChatMessageRecordService weChatMessageRecordService;
	@Autowired
    private MobileMessageRecordService mobileMessageRecordService;
	@Autowired
    private BlogSendStatusService blogSendStatusService;
	@Autowired
    private WechatSendStatusService wechatSendStatusService;
	@Autowired
    private MobileSendStatusService mobileSendStatusService;
	@Autowired
	private MsgsBlacklistService msgsBlacklistService;
	@Autowired
	private ApplicationApi applicationApi;
    /**
     * 消息各操作数量统计
     * @return
     */
	@RequestMapping(value = "/analysis/handle", method = RequestMethod.GET)
	@ApiOperation(value="消息各操作数量统计",notes = "消息各操作数量统计")
	public Result<MsgAnalysisHandleDTO> getMsgHandleCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			MsgAnalysisHandleDTO msgAnalysisHandleDTO = new MsgAnalysisHandleDTO();
			//已发送数量
			MsgsMessageExample msgsMessageExample = new MsgsMessageExample();			
			msgsMessageExample.createCriteria().andCreateUserEqualTo(userId).andMsgStatusEqualTo(0L);			
			List<MsgsMessage> sendNum = msgsMessageService.find(msgsMessageExample);
			if(sendNum!=null){
				msgAnalysisHandleDTO.setSendNum(sendNum.size());
			}else{
				msgAnalysisHandleDTO.setSendNum(0);
			}
			//草稿箱数量		
			MsgsMessageExample msgsMessageExample1 = new MsgsMessageExample();
			msgsMessageExample1.createCriteria().andCreateUserEqualTo(userId).andMsgStatusEqualTo(1L);			
			List<MsgsMessage> draftNum = msgsMessageService.find(msgsMessageExample1);
			if(draftNum!=null){
				msgAnalysisHandleDTO.setDraftNum(draftNum.size());
			}else{
				msgAnalysisHandleDTO.setDraftNum(0);
			}
			//渠道维护数量
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(channelNum!=null){
				msgAnalysisHandleDTO.setChannelNum(channelNum.size());
			}else{
				msgAnalysisHandleDTO.setChannelNum(0);
			}
			//发布商数量
			msgsMessageExample.createCriteria().andCreateUserEqualTo(userId).andMsgStatusEqualTo(0L);
			msgsMessageExample.setGroupByClause("app_id");
			List<MsgsMessage> publisherNum = msgsMessageService.find(msgsMessageExample);
			if(publisherNum!=null){
				msgAnalysisHandleDTO.setPublisherNum(publisherNum.size());
			}else{
				msgAnalysisHandleDTO.setPublisherNum(0);
			}
			return Result.success(msgAnalysisHandleDTO);
		} catch (Exception e) {
			log.error("消息各操作数量统计出错："+e);
			return Result.fail("消息各操作数量统计出错");
		}
	}
    /**
     * 个人渠道使用情况
     * @return
     */
	@RequestMapping(value = "/analysis/channel/used", method = RequestMethod.GET)
	@ApiOperation(value="个人渠道使用情况",notes = "个人渠道使用情况")
	public Result<List<MsgAnalysisChannelUsedDTO>> getMsgChannelUsedCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			String useId = String.valueOf(userId);
			List<MsgAnalysisChannelUsedDO> result = new ArrayList<MsgAnalysisChannelUsedDO>();
			//获取微信渠道情况
			List<MsgAnalysisChannelUsedDO> wechat = weChatMessageRecordService.getMsgChannelUsedCount(useId,list);
			if(!Util.isEmpty(wechat)){
				result.addAll(wechat);
			}
			//获取微博渠道情况
			List<MsgAnalysisChannelUsedDO> blog = blogMessageRecordService.getMsgChannelUsedCount(useId,list);		
			if(!Util.isEmpty(blog)){
				result.addAll(blog);
			}
			//获取移动终端渠道情况			
			List<MsgAnalysisChannelUsedDO> mobile = mobileMessageRecordService.getMsgChannelUsedCount(useId,list);						
			if(!Util.isEmpty(mobile)){
				result.addAll(mobile);
			}
			//获取公示平台渠道情况
			List<MsgAnalysisChannelUsedDTO> resultList = dozerUtils.mapList(result, MsgAnalysisChannelUsedDTO.class);
			return Result.success(resultList);
		} catch (Exception e) {
			log.error("获取个人渠道使用情况出错："+e);
			return Result.fail("获取个人渠道使用情况出错");
		}
	}
    /**
     * 个人渠道类型使用占比分析
     * @return
     */
	@RequestMapping(value = "/analysis/personal/channeltype", method = RequestMethod.GET)
	@ApiOperation(value="个人渠道类型使用占比分析",notes = "个人渠道类型使用占比分析")
	public Result<MsgAnalysisChannelTypeDTO> getMsgPersonalChannelTypeCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			MsgAnalysisChannelTypeDTO msgAnalysisChannelTypeDTO = new MsgAnalysisChannelTypeDTO();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			//微信数量
			WeChatMessageRecordExample weChatMessageRecordExample = new WeChatMessageRecordExample();
			weChatMessageRecordExample.createCriteria().andChannelIdIn(list).andDraftEqualTo(0);
			List<WeChatMessageRecord> wechat = weChatMessageRecordService.find(weChatMessageRecordExample);
			if(wechat!=null){
				msgAnalysisChannelTypeDTO.setWechat(wechat.size());
			}else{
				msgAnalysisChannelTypeDTO.setWechat(0);
			}			
			//微博数量
			BlogMessageRecordExample blogMessageRecordExample = new BlogMessageRecordExample();
			blogMessageRecordExample.createCriteria().andChannelIdIn(list).andDraftEqualTo(0);
			List<BlogMessageRecord> blog = blogMessageRecordService.find(blogMessageRecordExample);
			if(blog!=null){
				msgAnalysisChannelTypeDTO.setBlog(blog.size());
			}else{
				msgAnalysisChannelTypeDTO.setBlog(0);
			}
			//移动终端数量
			MobileMessageRecordExample mobileMessageRecordExample = new MobileMessageRecordExample();
			mobileMessageRecordExample.createCriteria().andChannelIdIn(list);
			List<MobileMessageRecord> mobile = mobileMessageRecordService.find(mobileMessageRecordExample);
			if(mobile!=null){
				msgAnalysisChannelTypeDTO.setMobile(mobile.size());
			}else{
				msgAnalysisChannelTypeDTO.setMobile(0);
			}
			return Result.success(msgAnalysisChannelTypeDTO);
		} catch (Exception e) {
			log.error("个人渠道类型使用占比分析出错："+e);
			return Result.fail("个人渠道类型使用占比分析出错");
		}
	}
    /**
     * 高新区渠道类型使用占比分析
     * @return
     */
	@RequestMapping(value = "/analysis/all/channeltype", method = RequestMethod.GET)
	@ApiOperation(value="高新区渠道类型使用占比分析",notes = "高新区渠道类型使用占比分析")
	public Result<MsgAnalysisChannelTypeDTO> getMsgAllChannelTypeCount() {
		try {
			MsgAnalysisChannelTypeDTO msgAnalysisChannelTypeDTO = new MsgAnalysisChannelTypeDTO();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			//微信数量
			WeChatMessageRecordExample weChatMessageRecordExample = new WeChatMessageRecordExample();
			weChatMessageRecordExample.createCriteria().andChannelIdIn(list).andDraftEqualTo(0);
			List<WeChatMessageRecord> wechat = weChatMessageRecordService.find(weChatMessageRecordExample);
			if(wechat!=null){
				msgAnalysisChannelTypeDTO.setWechat(wechat.size());
			}else{
				msgAnalysisChannelTypeDTO.setWechat(0);
			}			
			//微博数量
			BlogMessageRecordExample blogMessageRecordExample = new BlogMessageRecordExample();
			blogMessageRecordExample.createCriteria().andChannelIdIn(list).andDraftEqualTo(0);
			List<BlogMessageRecord> blog = blogMessageRecordService.find(blogMessageRecordExample);
			if(blog!=null){
				msgAnalysisChannelTypeDTO.setBlog(blog.size());
			}else{
				msgAnalysisChannelTypeDTO.setBlog(0);
			}
			//移动终端数量
			MobileMessageRecordExample mobileMessageRecordExample = new MobileMessageRecordExample();
			mobileMessageRecordExample.createCriteria().andChannelIdIn(list);
			List<MobileMessageRecord> mobile = mobileMessageRecordService.find(mobileMessageRecordExample);
			if(mobile!=null){
				msgAnalysisChannelTypeDTO.setMobile(mobile.size());
			}else{
				msgAnalysisChannelTypeDTO.setMobile(0);
			}
			return Result.success(msgAnalysisChannelTypeDTO);
		} catch (Exception e) {
			log.error("高新区渠道类型使用占比分析出错："+e);
			return Result.fail("高新区渠道类型使用占比分析出错");
		}
	}
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/senderror/top10", method = RequestMethod.GET)
	@ApiOperation(value="各类型渠道发送问题TOP10",notes = "各类型渠道发送问题TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getMsgSendErrorTop10(@RequestParam(value="type") String type) {
		try {
			if(Util.isEmptyString(type)){
				return Result.fail("参数错误");
			}
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			List<MsgAnalysisSendErrorDO> result = null;
			if("wechat".equals(type)){
				result = wechatSendStatusService.getMsgSendErrorTop10(list);
			}else if("blog".equals(type)){
				result = blogSendStatusService.getMsgSendErrorTop10(list);
			}else if("mobile".equals(type)){
				result = mobileSendStatusService.getMsgSendErrorTop10(list);
			}else if("publicSys".equals(type)){
				
			}			
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			if(resultList == null){
				return Result.success(resultList);
			}
			resultList.forEach((li) ->{
				li.setName(getTranslate(li.getName()));
			});
			return Result.success(resultList);			
		} catch (Exception e) {
			log.error("获取各类型渠道发送问题TOP10出错："+e);
			return Result.fail("获取各类型渠道发送问题TOP10出错");
		}
	}

	/**
	 * 根据接口返回信息获取中文翻译
	 * @param str
	 * @return
	 */
	public String getTranslate(String str) {

		if(StringUtil.isBlank(str)) {
			return "";
		}
		if(str.contains("forbid to clear quota because of reaching the limit")
				||str.contains("api freq out of limit")) {
			return "调用微信接口次数超限";
		}
		if(str.contains("has no masssend quota hint")) {
			return "当天发送微信次数超限";
		}
		if(str.contains("invalid message type hint")) {
			return "无效消息类型";
		}
		if(str.contains("has no masssend hint")||str.contains("no permission for this msgtype hint")) {
			return "无发送图文消息权限";
		}
		if(str.contains("access_token is invalid or not latest hint")) {
			return "请求凭证不是最新的";
		}
		if(str.contains("response out of time limit or subscription is canceled hint")) {
			return "接收报文超时";
		}
		if(str.contains("invalid group id hint")) {
			return "无法获取分组标识";
		}
		if(str.contains("system error")) {
			return "微信服务器连接超时";
		}
		return "调用服务失败";
	}

    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	@RequestMapping(value = "/analysis/send/exception", method = RequestMethod.GET)
	@ApiOperation(value="各渠道类型异常情况分析",notes = "各渠道类型异常情况分析")
	public Result<Map<String,List<MsgAnalysisSendExceptionDTO>>> getMsgSendExceptionCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			Map<String,List<MsgAnalysisSendExceptionDTO>> map = new HashMap<String,List<MsgAnalysisSendExceptionDTO>>();
			//获取微信信息
			List<MsgAnalysisSendExceptionDO> wechat = wechatSendStatusService.getMsgSendExceptionCount(userId);
			if(!Util.isEmpty(wechat)){
				List<String> dates = new ArrayList<String>();
				for(MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO:wechat){
					String date = msgAnalysisSendExceptionDO.getYear()+"-"+Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth());
					dates.add(date);
					msgAnalysisSendExceptionDO.setMonth(Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth()));
				}
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
						msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
						msgAnalysisSendExceptionDO.setMonth(month.substring(5));
						msgAnalysisSendExceptionDO.setCount(0);
						list.add(msgAnalysisSendExceptionDO);
					}
				}
				list.addAll(wechat);
				//排序
	            Collections.sort(list, new Comparator<MsgAnalysisSendExceptionDO>() {            	 
	    			@Override
	    			public int compare(MsgAnalysisSendExceptionDO o1, MsgAnalysisSendExceptionDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
	            List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("wechat",result);
			}else{
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
					msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
					msgAnalysisSendExceptionDO.setMonth(month.substring(5));
					msgAnalysisSendExceptionDO.setCount(0);
					list.add(msgAnalysisSendExceptionDO);
				}
				List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("wechat",result);
			}			
			//获取微博信息
			List<MsgAnalysisSendExceptionDO> blog = blogSendStatusService.getMsgSendExceptionCount(userId);
			if(!Util.isEmpty(blog)){
				List<String> dates = new ArrayList<String>();
				for(MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO:blog){
					String date = msgAnalysisSendExceptionDO.getYear()+"-"+Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth());
					dates.add(date);
					msgAnalysisSendExceptionDO.setMonth(Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth()));
				}
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
						msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
						msgAnalysisSendExceptionDO.setMonth(month.substring(5));
						msgAnalysisSendExceptionDO.setCount(0);
						list.add(msgAnalysisSendExceptionDO);
					}
				}
				list.addAll(blog);
				//排序
	            Collections.sort(list, new Comparator<MsgAnalysisSendExceptionDO>() {            	 
	    			@Override
	    			public int compare(MsgAnalysisSendExceptionDO o1, MsgAnalysisSendExceptionDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
				List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("blog",result);
			}else{
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
					msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
					msgAnalysisSendExceptionDO.setMonth(month.substring(5));
					msgAnalysisSendExceptionDO.setCount(0);
					list.add(msgAnalysisSendExceptionDO);
				}
				List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("blog",result);
			}
			//获取移动终端信息
			List<MsgAnalysisSendExceptionDO> mobile = mobileSendStatusService.getMsgSendExceptionCount(userId);
			if(!Util.isEmpty(mobile)){
				List<String> dates = new ArrayList<String>();
				for(MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO:mobile){
					String date = msgAnalysisSendExceptionDO.getYear()+"-"+Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth());
					dates.add(date);
					msgAnalysisSendExceptionDO.setMonth(Util.getMonthAddZero(msgAnalysisSendExceptionDO.getMonth()));
				}
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
						msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
						msgAnalysisSendExceptionDO.setMonth(month.substring(5));
						msgAnalysisSendExceptionDO.setCount(0);
						list.add(msgAnalysisSendExceptionDO);
					}
				}
				list.addAll(mobile);
				//排序
	            Collections.sort(list, new Comparator<MsgAnalysisSendExceptionDO>() {            	 
	    			@Override
	    			public int compare(MsgAnalysisSendExceptionDO o1, MsgAnalysisSendExceptionDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
				List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("mobile",result);
			}else{
				List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
				List<String> months = Util.getHalfYearMonthBetween();
				for(String month:months){
					MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
					msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
					msgAnalysisSendExceptionDO.setMonth(month.substring(5));
					msgAnalysisSendExceptionDO.setCount(0);
					list.add(msgAnalysisSendExceptionDO);
				}
				List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
				map.put("mobile",result);
			}
			//获取公示平台信息
			List<MsgAnalysisSendExceptionDO> list = new ArrayList<MsgAnalysisSendExceptionDO>();
			List<String> months = Util.getHalfYearMonthBetween();
			for(String month:months){
				MsgAnalysisSendExceptionDO msgAnalysisSendExceptionDO = new MsgAnalysisSendExceptionDO();
				msgAnalysisSendExceptionDO.setYear(month.substring(0, 4));
				msgAnalysisSendExceptionDO.setMonth(month.substring(5));
				msgAnalysisSendExceptionDO.setCount(0);
				list.add(msgAnalysisSendExceptionDO);
			}
			List<MsgAnalysisSendExceptionDTO> result = dozerUtils.mapList(list, MsgAnalysisSendExceptionDTO.class);
			map.put("publicSys",result);
			return Result.success(map);
		} catch (Exception e) {
			log.error("各渠道类型异常情况分析出错："+e);
			return Result.fail("各渠道类型异常情况分析出错");
		}
	}
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	@RequestMapping(value = "/analysis/allchannel/used", method = RequestMethod.GET)
	@ApiOperation(value="近一年高新区各类型渠道使用发展情况",notes = "近一年高新区各类型渠道使用发展情况")
	public Result<Map<String,List<MsgAllChannelUsedDTO>>> getMsgAllChannelUsedCount() {
		try {
			Map<String,List<MsgAllChannelUsedDTO>> map = new HashMap<String,List<MsgAllChannelUsedDTO>>();
			//获取微信记录
			List<MsgAllChannelUsedDO> wechat = weChatMessageRecordService.getMsgAllChannelUsedCount();
			if(!Util.isEmpty(wechat)){
				List<String> dates = new ArrayList<String>();
				for(MsgAllChannelUsedDO msgAllChannelUsedDO:wechat){
					String date = msgAllChannelUsedDO.getYear()+"-"+Util.getMonthAddZero(msgAllChannelUsedDO.getMonth());
					dates.add(date);
					msgAllChannelUsedDO.setMonth(Util.getMonthAddZero(msgAllChannelUsedDO.getMonth()));
				}
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
						msgAllChannelUsedDO.setYear(month.substring(0, 4));
						msgAllChannelUsedDO.setMonth(month.substring(5));
						msgAllChannelUsedDO.setCount(0);
						list.add(msgAllChannelUsedDO);
					}
				}
				list.addAll(wechat);
				//排序
	            Collections.sort(list, new Comparator<MsgAllChannelUsedDO>() {            	 
	    			@Override
	    			public int compare(MsgAllChannelUsedDO o1, MsgAllChannelUsedDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("wechat",result);
			}else{
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
					msgAllChannelUsedDO.setYear(month.substring(0, 4));
					msgAllChannelUsedDO.setMonth(month.substring(5));
					msgAllChannelUsedDO.setCount(0);
					list.add(msgAllChannelUsedDO);
				}
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("wechat",result);
			}
			//获取微博记录
			List<MsgAllChannelUsedDO> blog = blogMessageRecordService.getMsgAllChannelUsedCount();
			if(!Util.isEmpty(blog)){
				List<String> dates = new ArrayList<String>();
				for(MsgAllChannelUsedDO msgAllChannelUsedDO:blog){
					String date = msgAllChannelUsedDO.getYear()+"-"+Util.getMonthAddZero(msgAllChannelUsedDO.getMonth());
					dates.add(date);
					msgAllChannelUsedDO.setMonth(Util.getMonthAddZero(msgAllChannelUsedDO.getMonth()));
				}
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
						msgAllChannelUsedDO.setYear(month.substring(0, 4));
						msgAllChannelUsedDO.setMonth(month.substring(5));
						msgAllChannelUsedDO.setCount(0);
						list.add(msgAllChannelUsedDO);
					}
				}
				list.addAll(blog);
				//排序
	            Collections.sort(list, new Comparator<MsgAllChannelUsedDO>() {            	 
	    			@Override
	    			public int compare(MsgAllChannelUsedDO o1, MsgAllChannelUsedDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("blog",result);
			}else{
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
					msgAllChannelUsedDO.setYear(month.substring(0, 4));
					msgAllChannelUsedDO.setMonth(month.substring(5));
					msgAllChannelUsedDO.setCount(0);
					list.add(msgAllChannelUsedDO);
				}
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("blog",result);
			}
			//获取移动终端记录
			List<MsgAllChannelUsedDO> mobile = mobileMessageRecordService.getMsgAllChannelUsedCount();
			if(!Util.isEmpty(mobile)){
				List<String> dates = new ArrayList<String>();
				for(MsgAllChannelUsedDO msgAllChannelUsedDO:mobile){
					String date = msgAllChannelUsedDO.getYear()+"-"+Util.getMonthAddZero(msgAllChannelUsedDO.getMonth());
					dates.add(date);
					msgAllChannelUsedDO.setMonth(Util.getMonthAddZero(msgAllChannelUsedDO.getMonth()));
				}
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
						msgAllChannelUsedDO.setYear(month.substring(0, 4));
						msgAllChannelUsedDO.setMonth(month.substring(5));
						msgAllChannelUsedDO.setCount(0);
						list.add(msgAllChannelUsedDO);
					}
				}
				list.addAll(mobile);
				//排序
	            Collections.sort(list, new Comparator<MsgAllChannelUsedDO>() {            	 
	    			@Override
	    			public int compare(MsgAllChannelUsedDO o1, MsgAllChannelUsedDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}	  
	    				return 0;
	    			}
	    		});
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("mobile",result);
			}else{
				List<MsgAllChannelUsedDO> list = new ArrayList<MsgAllChannelUsedDO>();
				List<String> months = Util.getMonthBetween();
				for(String month:months){
					MsgAllChannelUsedDO msgAllChannelUsedDO = new MsgAllChannelUsedDO();
					msgAllChannelUsedDO.setYear(month.substring(0, 4));
					msgAllChannelUsedDO.setMonth(month.substring(5));
					msgAllChannelUsedDO.setCount(0);
					list.add(msgAllChannelUsedDO);
				}
				List<MsgAllChannelUsedDTO> result = dozerUtils.mapList(list, MsgAllChannelUsedDTO.class);
				map.put("mobile",result);
			}
			return Result.success(map);
		} catch (Exception e) {
			log.error("获取近一年高新区各类型渠道使用发展情况出错："+e);
			return Result.fail("获取近一年高新区各类型渠道使用发展情况出错");
		}
	}
    /**
     * 微信发送问题TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/wechat/top10", method = RequestMethod.GET)
	@ApiOperation(value="微信发送问题TOP10",notes = "微信发送问题TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getWechatExceptionTop10() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(1);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			List<MsgAnalysisSendErrorDO> result = wechatSendStatusService.getMsgSendErrorTop10(list);
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			return Result.success(resultList);			
		} catch (Exception e) {
			log.error("获取微信发送问题TOP10出错："+e);
			return Result.fail("获取微信发送问题TOP10出错");
		}
	}
    /**
     * 微博发送问题TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/blog/top10", method = RequestMethod.GET)
	@ApiOperation(value="微博发送问题TOP10",notes = "微博发送问题TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getBlogExceptionTop10() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(2);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			List<MsgAnalysisSendErrorDO> result = blogSendStatusService.getMsgSendErrorTop10(list);
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			return Result.success(resultList);			
		} catch (Exception e) {
			log.error("获取微博发送问题TOP10出错："+e);
			return Result.fail("获取微博发送问题TOP10出错");
		}
	}
    /**
     * 移动终端发送问题TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/mobile/top10", method = RequestMethod.GET)
	@ApiOperation(value="移动终端发送问题TOP10",notes = "移动终端发送问题TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getMobileExceptionTop10() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(5);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			List<MsgAnalysisSendErrorDO> result = mobileSendStatusService.getMsgSendErrorTop10(list);
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			return Result.success(resultList);		
		} catch (Exception e) {
			log.error("获取移动终端发送问题TOP10出错："+e);
			return Result.fail("获取移动终端发送问题TOP10出错");
		}
	}
    /**
     * 公示平台发送问题TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/public/top10", method = RequestMethod.GET)
	@ApiOperation(value="公示平台发送问题TOP10",notes = "公示平台发送问题TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getPublicExceptionTop10() {
		return Result.success(null);	
	}
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/publisher/sendtop10", method = RequestMethod.GET)
	@ApiOperation(value="个人渠道发布商次数TOP10",notes = "个人渠道发布商次数TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getPublisherSendTop10() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			List<MsgAnalysisSendErrorDO> result = new ArrayList<MsgAnalysisSendErrorDO>();
			List<MsgAnalysisSendErrorDO> wechat = weChatMessageRecordService.getPublisherSendTop10(list);
			if(!Util.isEmpty(wechat)){
				for(MsgAnalysisSendErrorDO msgAnalysisSendErrorDO:wechat){
					if(!Util.isEmptyString(msgAnalysisSendErrorDO.getName())
							&&msgAnalysisSendErrorDO.getCount()!=null){
						result.add(msgAnalysisSendErrorDO);
					}
				}
			}
			//排序
			if(!Util.isEmpty(result)){				
	            Collections.sort(result, new Comparator<MsgAnalysisSendErrorDO>() {            	 
	    			@Override
	    			public int compare(MsgAnalysisSendErrorDO o1, MsgAnalysisSendErrorDO o2) {    				
	    				if(!o1.getCount().equals(o2.getCount())){
	    					return o1.getCount().compareTo(o2.getCount());
	    				}  
	    				return 0;
	    			}
	    		});		
	            if(result.size()>10){
	            	result = result.subList(0, 10);
	            }	
			}else{
				return Result.success(null);
			}
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			return Result.success(resultList);
		} catch (Exception e) {
			log.error("获取个人渠道发布商次数TOP10出错："+e);
			return Result.fail("获取个人渠道发布商次数TOP10出错");
		}
	}
    /**
     * 高新区发布商使用次数TOP10
     * @return
     */
	@RequestMapping(value = "/analysis/gxqpt/sendtop10", method = RequestMethod.GET)
	@ApiOperation(value="高新区发布商使用次数TOP10",notes = "高新区发布商使用次数TOP10")
	public Result<List<MsgAnalysisSendErrorDTO>> getGxqptSendTop10() {
		try{
			List<MsgAnalysisSendErrorDO> result = new ArrayList<MsgAnalysisSendErrorDO>();
			List<MsgAnalysisSendErrorDO> wechat = weChatMessageRecordService.getPublisherSendTop10(null);
			if(!Util.isEmpty(wechat)){
				for(MsgAnalysisSendErrorDO msgAnalysisSendErrorDO:wechat){
					if(!Util.isEmptyString(msgAnalysisSendErrorDO.getName())
							&&msgAnalysisSendErrorDO.getCount()!=null){
						result.add(msgAnalysisSendErrorDO);
					}
				}				
			}			
			//排序
			if(!Util.isEmpty(result)){				
	            Collections.sort(result, new Comparator<MsgAnalysisSendErrorDO>() {            	 
	    			@Override
	    			public int compare(MsgAnalysisSendErrorDO o1, MsgAnalysisSendErrorDO o2) {    				
	    				if(!o1.getCount().equals(o2.getCount())){
	    					return -o1.getCount().compareTo(o2.getCount());
	    				}  
	    				return 0;
	    			}
	    		});		
	            if(result.size()>10){
	            	result = result.subList(0, 10);
	            }	            
			}else{
				return Result.success(null);
			}
			List<MsgAnalysisSendErrorDTO> resultList = dozerUtils.mapList(result, MsgAnalysisSendErrorDTO.class);
			return Result.success(resultList);
		} catch (Exception e) {
			log.error("获取高新区发布商使用次数TOP10出错："+e);
			return Result.fail("获取高新区发布商使用次数TOP10出错");
		}
	}
    /**
     * 近期发布商活跃情况分析
     * @return
     */
	@RequestMapping(value = "/analysis/active/sendtop10", method = RequestMethod.GET)
	@ApiOperation(value="近期发布商活跃情况分析",notes = "近期发布商活跃情况分析")
	public Result<List<MsgActiveSendDTO>> getActivePublisherSendCount(@RequestParam(value="appId") String appId) {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取所有应用
			List<ApplicationAllDTO> appList = applicationApi.findAllList().getData();
			List<String> allAppIds = new ArrayList<String>();
			for(ApplicationAllDTO applicationAllDTO:appList){
				allAppIds.add(applicationAllDTO.getAppId());
			}
			//获取授权应用
			MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
			msgsBlacklistExample.createCriteria().andCreateUserEqualTo(userId);
			List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
			if(!Util.isEmpty(list)){
				allAppIds.removeAll(list);
			}
			//获取本人创建的渠道
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<Long> channelIds = new ArrayList<Long>();
			for(MsgsChannel msgsChannel:channelNum){
				channelIds.add(msgsChannel.getId());
			}
			//获取查询结果
			List<MsgActiveSendDO> result = weChatMessageRecordService.getActivePublisherSendCount(allAppIds, channelIds, appId);
			//组装日期数据
			if(!Util.isEmpty(result)){
				List<String> dates = new ArrayList<String>();
				for(MsgActiveSendDO msgActiveSendDO:result){
					String date = msgActiveSendDO.getYear()+"-"+Util.getMonthAddZero(msgActiveSendDO.getMonth())+"-"+Util.getMonthAddZero(msgActiveSendDO.getDay());					
					dates.add(date);
					msgActiveSendDO.setMonth(Util.getMonthAddZero(msgActiveSendDO.getMonth()));
					msgActiveSendDO.setDay(Util.getMonthAddZero(msgActiveSendDO.getDay()));
				}
				List<Date> dateList = Util.getDatesBetweenTwoDate(Util.getBeforeMonthTime(),new Date());
				for(Date date:dateList){
					String date_ = Util.dateToStr1(date);
					if(!dates.contains(date_)){						
						MsgActiveSendDO msgActiveSendDO = new MsgActiveSendDO();
						msgActiveSendDO.setYear(date_.substring(0, 4));
						msgActiveSendDO.setMonth(date_.substring(5,7));
						msgActiveSendDO.setDay(date_.substring(8));
						msgActiveSendDO.setCount(0);
						result.add(msgActiveSendDO);
					}
				}
				//排序
	            Collections.sort(result, new Comparator<MsgActiveSendDO>() {            	 
	    			@Override
	    			public int compare(MsgActiveSendDO o1, MsgActiveSendDO o2) {    				
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}
	    				if(!o1.getDay().equals(o2.getDay())){
	    					return o1.getDay().compareTo(o2.getDay());
	    				}
	    				return 0;
	    			}
	    		});
			}else{
				result = new ArrayList<MsgActiveSendDO>();
				List<Date> dateList = Util.getDatesBetweenTwoDate(Util.getBeforeMonthTime(),new Date());
				for(Date date:dateList){
					String date_ = Util.dateToStr1(date);
					MsgActiveSendDO msgActiveSendDO = new MsgActiveSendDO();
					msgActiveSendDO.setYear(date_.substring(0, 4));
					msgActiveSendDO.setMonth(date_.substring(5,7));
					msgActiveSendDO.setDay(date_.substring(8));
					msgActiveSendDO.setCount(0);
					result.add(msgActiveSendDO);
				}
			}			
			List<MsgActiveSendDTO> resultList = dozerUtils.mapList(result, MsgActiveSendDTO.class);
			return Result.success(resultList);			
		} catch (Exception e) {
			log.error("近期发布商活跃情况分析出错："+e);
			return Result.fail("近期发布商活跃情况分析出错");
		}
	}
    
}
