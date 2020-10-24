package com.hengyunsoft.platform.sms.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hengyunsoft.utils.BizAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.platform.sms.dto.AnalysisRespondsDTO;
import com.hengyunsoft.platform.sms.dto.SmsAtlasCountDTO;
import com.hengyunsoft.platform.sms.dto.SmsTimeStampCountDTO;
import com.hengyunsoft.platform.sms.dto.TreeChaildDTO;
import com.hengyunsoft.platform.sms.dto.TreeDTO;
import com.hengyunsoft.platform.sms.entity.template.dos.AnalysisRespondsDO;
import com.hengyunsoft.platform.sms.entity.template.dos.ScaleRequestDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTimeStampCountDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsRecordService;
import com.hengyunsoft.platform.sms.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import static com.hengyunsoft.commons.exception.core.FileExceptionCode.REQUIRED_FILE_PARAM_EX;

/**
 * 短信分析统计
 * @author dxz
 */
@RestController
@Slf4j
@Api(value = "短信分析统计", description = "短信分析统计")
public class AnalysisCountApiImpl {
	
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private SmsRecordService smsRecordService;
	@Autowired
	private MsgsChannelService msgsChannelService;	
    /**
     * 各应用使用情况分析
     * @return
     */
	@RequestMapping(value = "/analysis/applications", method = RequestMethod.GET)
	@ApiOperation(value = "各应用使用情况分析", notes = "各应用使用情况分析")
	public Result<List<AnalysisRespondsDTO>> getApplicationsCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取渠道id集合
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(3);
			List<MsgsChannel> channelList = msgsChannelService.find(msgsChannelExample);
			if(channelList==null||channelList.size()==0){
				return Result.success(null);
			}
			List<Long> ids = new ArrayList<Long>();
			for(MsgsChannel msgsChannel:channelList){
				ids.add(msgsChannel.getId());
			}
			//获取各应用使用情况			
			List<AnalysisRespondsDO> result = smsRecordService.getApplicationsCount(ids);
			List<AnalysisRespondsDTO> list = dozerUtils.mapList(result, AnalysisRespondsDTO.class);
			return Result.success(list);
		} catch (Exception e) {
			log.error("各应用使用情况分析出错:"+e);
			return Result.fail("各应用使用情况分析出错");
		}
	}
    /**
     * 各服务使用情况分析
     * @return
     */
	@RequestMapping(value = "/analysis/services", method = RequestMethod.GET)
	@ApiOperation(value = "各服务使用情况分析", notes = "各服务使用情况分析")
	public Result<List<AnalysisRespondsDTO>> getServicesCount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			//获取渠道id集合
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(3);
			List<MsgsChannel> channelList = msgsChannelService.find(msgsChannelExample);
			if(channelList==null||channelList.size()==0){
				return Result.success(null);
			}
			List<Long> ids = new ArrayList<Long>();
			for(MsgsChannel msgsChannel:channelList){
				ids.add(msgsChannel.getId());
			}
			//获取各应用使用情况			
			List<AnalysisRespondsDO> result = smsRecordService.getServicesCount(ids);
			List<AnalysisRespondsDTO> list = dozerUtils.mapList(result, AnalysisRespondsDTO.class);
			return Result.success(list);
		} catch (Exception e) {
			log.error("各服务使用情况分析出错:"+e);
			return Result.fail("各服务使用情况分析出错");
		}
	}
    /**
     * 短信时间分析
     * @return
     */
	@RequestMapping(value = "/analysis/timestamp", method = RequestMethod.GET)
	@ApiOperation(value = "短信时间分析", notes = "短信时间分析")
	public Result<List<SmsTimeStampCountDTO>> getTimeStampCount(@RequestParam(value = "startTime")String startTime, @RequestParam(value = "endTime")String endTime) {
		if(!StringUtils.isEmpty(startTime)){
			if(StringUtils.isEmpty(endTime)){
				return Result.fail("请输入截止时间！！");
			}
		}
		try {
			Long userId = BaseContextHandler.getAdminId();
			String scale = DateUtil.getDateType(startTime, endTime);
			if("false".equals(scale)){
				return Result.fail("时间选取不正确");
			}
			List<SmsTimeStampCountDO> list = new ArrayList<SmsTimeStampCountDO>();
			ScaleRequestDO scaleRequestDO = new ScaleRequestDO();
			scaleRequestDO.setStartTime(startTime);
			scaleRequestDO.setEndTime(endTime);
			scaleRequestDO.setUserId(userId);
			if("halfYear".equals(scale)){
				//半年，按月展示
				list = smsRecordService.getHarfYearCount(scaleRequestDO);
				if(list!=null&&list.size()>0){
					List<String> dates = new ArrayList<String>();
					for(SmsTimeStampCountDO smsTimeStampCountDO:list){
						String month_ = smsTimeStampCountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth());
						dates.add(month_);
						smsTimeStampCountDO.setMonth(DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth()));
					}
					List<String> months = DateUtil.getHalfYearMonthBetween();
					for(String month:months){
						if(!dates.contains(month)){
							SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
							smsTimeStampCountDO.setYear(month.substring(0, 4));
							smsTimeStampCountDO.setMonth(month.substring(5));
							smsTimeStampCountDO.setCount(0);
							list.add(smsTimeStampCountDO);
						}
					}

					//排序
		            Collections.sort(list, new Comparator<SmsTimeStampCountDO>() {            	 
		    			@Override
		    			public int compare(SmsTimeStampCountDO o1, SmsTimeStampCountDO o2) {    				
		    				if(!o1.getYear().equals(o2.getYear())){
		    					return o1.getYear().compareTo(o2.getYear());
		    				}
		    				if(!o1.getMonth().equals(o2.getMonth())){
		    					return o1.getMonth().compareTo(o2.getMonth());
		    				}	  
		    				return 0;
		    			}
		    		});
				}else{
					List<String> months = DateUtil.getMonthBetween();
					for(String month:months){
						SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
						smsTimeStampCountDO.setYear(month.substring(0, 4));
						smsTimeStampCountDO.setMonth(month.substring(5));
						smsTimeStampCountDO.setCount(0);
						list.add(smsTimeStampCountDO);
					}
				}
			}else if("day".equals(scale)){
				//一个月，按天展示
				list = smsRecordService.getDayCount(scaleRequestDO);
				//组装日期数据
				if(!Util.isEmpty(list)){
					List<String> dates = new ArrayList<String>();
					for(SmsTimeStampCountDO smsTimeStampCountDO:list){
						String date = smsTimeStampCountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth())+"-"+DateUtil.getMonthAddZero(smsTimeStampCountDO.getDay());					
						dates.add(date);
						smsTimeStampCountDO.setMonth(DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth()));
						smsTimeStampCountDO.setDay(DateUtil.getMonthAddZero(smsTimeStampCountDO.getDay()));
					}
					List<Date> dateList = DateUtil.getDatesBetweenTwoDate1(DateUtil.stringToDate(startTime),DateUtil.stringToDate(endTime));
					for(Date date:dateList){
						String date_ = DateUtil.dateToStr1(date);
						if(!dates.contains(date_)){							
							SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
							smsTimeStampCountDO.setYear(date_.substring(0, 4));
							smsTimeStampCountDO.setMonth(date_.substring(5,7));
							smsTimeStampCountDO.setDay(date_.substring(8));
							smsTimeStampCountDO.setCount(0);
							list.add(smsTimeStampCountDO);
						}
					}
					//排序
		            Collections.sort(list, new Comparator<SmsTimeStampCountDO>() {            	 
		    			@Override
		    			public int compare(SmsTimeStampCountDO o1, SmsTimeStampCountDO o2) {    				
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
					list = new ArrayList<SmsTimeStampCountDO>();
					List<Date> dateList = DateUtil.getDatesBetweenTwoDate1(DateUtil.stringToDate(startTime),DateUtil.stringToDate(endTime));
					for(Date date:dateList){
						String date_ = DateUtil.dateToStr1(date);
						SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
						smsTimeStampCountDO.setYear(date_.substring(0, 4));
						smsTimeStampCountDO.setMonth(date_.substring(5,7));
						smsTimeStampCountDO.setDay(date_.substring(8));
						smsTimeStampCountDO.setCount(0);
						list.add(smsTimeStampCountDO);
					}
				}	
			}else if("week".equals(scale)){
				//三个月，按周展示
				list = smsRecordService.getWeekCount(scaleRequestDO);
				if(list!=null&&list.size()>0){
					List<String> dates = new ArrayList<String>();
					for(SmsTimeStampCountDO smsTimeStampCountDO:list){
						String week_ = smsTimeStampCountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsTimeStampCountDO.getWeek());
						dates.add(week_);
						smsTimeStampCountDO.setWeek(DateUtil.getMonthAddZero(smsTimeStampCountDO.getWeek()));
					}
					List<String> weeks = DateUtil.getWeekBetween(startTime,endTime);
					for(String week:weeks){
						if(!dates.contains(week)){
							SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
							smsTimeStampCountDO.setYear(week.substring(0, 4));
							smsTimeStampCountDO.setWeek(week.substring(5));
							smsTimeStampCountDO.setCount(0);
							list.add(smsTimeStampCountDO);
						}
					}
					//排序
		            Collections.sort(list, new Comparator<SmsTimeStampCountDO>() {            	 
		    			@Override
		    			public int compare(SmsTimeStampCountDO o1, SmsTimeStampCountDO o2) {    				
		    				if(!o1.getYear().equals(o2.getYear())){
		    					return o1.getYear().compareTo(o2.getYear());
		    				}
		    				if(!o1.getWeek().equals(o2.getWeek())){
		    					return o1.getWeek().compareTo(o2.getWeek());
		    				}	  
		    				return 0;
		    			}
		    		});
				}else{
					List<String> weeks = DateUtil.getWeekBetween(startTime,endTime);
					for(String week:weeks){
						SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
						smsTimeStampCountDO.setYear(week.substring(0, 4));
						smsTimeStampCountDO.setWeek(week.substring(5));
						smsTimeStampCountDO.setCount(0);
						list.add(smsTimeStampCountDO);
					}
				}
			}else if("month".equals(scale)){
				//一年，按月展示
				list = smsRecordService.getYearCount(scaleRequestDO);
				if(list!=null&&list.size()>0){
					List<String> dates = new ArrayList<String>();
					for(SmsTimeStampCountDO smsTimeStampCountDO:list){
						String month_ = smsTimeStampCountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth());
						dates.add(month_);
						smsTimeStampCountDO.setMonth(DateUtil.getMonthAddZero(smsTimeStampCountDO.getMonth()));
					}
					List<String> months = DateUtil.getMonthBetween(startTime,endTime);
					for(String month:months){
						if(!dates.contains(month)){
							SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
							smsTimeStampCountDO.setYear(month.substring(0, 4));
							smsTimeStampCountDO.setMonth(month.substring(5));
							smsTimeStampCountDO.setCount(0);
							list.add(smsTimeStampCountDO);
						}
					}

					//排序
		            Collections.sort(list, new Comparator<SmsTimeStampCountDO>() {            	 
		    			@Override
		    			public int compare(SmsTimeStampCountDO o1, SmsTimeStampCountDO o2) {    				
		    				if(!o1.getYear().equals(o2.getYear())){
		    					return o1.getYear().compareTo(o2.getYear());
		    				}
		    				if(!o1.getMonth().equals(o2.getMonth())){
		    					return o1.getMonth().compareTo(o2.getMonth());
		    				}	  
		    				return 0;
		    			}
		    		});
				}else{
					List<String> months = DateUtil.getMonthBetween(startTime,endTime);
					for(String month:months){
						SmsTimeStampCountDO smsTimeStampCountDO = new SmsTimeStampCountDO();
						smsTimeStampCountDO.setYear(month.substring(0, 4));
						smsTimeStampCountDO.setMonth(month.substring(5));
						smsTimeStampCountDO.setCount(0);
						list.add(smsTimeStampCountDO);
					}
				}
			}
			List<SmsTimeStampCountDTO> result = dozerUtils.mapList(list, SmsTimeStampCountDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("短信时间分析出错:"+e);
			return Result.fail("短信时间分析出错");
		}
	}
    /**
     * 发送、接收图谱
     * @return
     */
	@RequestMapping(value = "/analysis/atlas", method = RequestMethod.GET)
	@ApiOperation(value = "发送、接收图谱", notes = "发送、接收图谱")
	public Result<SmsAtlasCountDTO> getAtlasCount(@RequestParam(value = "startTime")String startTime,
			@RequestParam(value = "endTime") String endTime,@RequestParam(value = "mainMobile")String mainMobile) {
		try{
			if(StringUtils.isEmpty(mainMobile)){
				return Result.fail("参数错误");
			}
			Date begin = null;
			Date end = null;
			//时间判断
			if(StringUtils.isEmpty(startTime)&&StringUtils.isEmpty(endTime)){
				begin = DateUtil.getThisMonthTime();
				end = new Date();
			}
			if(!StringUtils.isEmpty(startTime)&&StringUtils.isEmpty(endTime)){
				begin = DateUtil.stringToDate(startTime);
				end = new Date();
			}
			if(!StringUtils.isEmpty(startTime)&&!StringUtils.isEmpty(endTime)){
				begin = DateUtil.stringToDate(startTime);
				end = DateUtil.stringToDate(endTime);
			}
			if(StringUtils.isEmpty(startTime)&&!StringUtils.isEmpty(endTime)){
				end = DateUtil.stringToDate(endTime);
			}
			SmsAtlasCountDTO smsAtlasCountDTO = new SmsAtlasCountDTO();
			Long userId = BaseContextHandler.getAdminId();
			SmsRecordExample smsRecordExample = new SmsRecordExample();
			//发送图谱
			if(StringUtils.isEmpty(startTime)&&!StringUtils.isEmpty(endTime)){
				smsRecordExample.createCriteria().andReceiverLike("%"+mainMobile+"%").andDraftEqualTo(0)
				.andCreateTimeLessThan(end);
			}else{
				smsRecordExample.createCriteria().andReceiverLike("%"+mainMobile+"%").andDraftEqualTo(0)
				.andCreateTimeBetween(begin,end);
			}
			List<SmsRecord> sendList = smsRecordService.find(smsRecordExample);
			List<TreeDTO> senderList = getSenderList(sendList);
			smsAtlasCountDTO.setSenderList(senderList);
			//接收图谱
			SmsRecordExample smsRecordExample1 = new SmsRecordExample();
			if(StringUtils.isEmpty(startTime)&&!StringUtils.isEmpty(endTime)){
				smsRecordExample1.createCriteria().andSenderEqualTo(String.valueOf(userId)).andDraftEqualTo(0)
				.andCreateTimeLessThan(end);
			}else{
				smsRecordExample1.createCriteria().andSenderEqualTo(String.valueOf(userId)).andDraftEqualTo(0)
				.andCreateTimeBetween(begin,end);
			}
			List<SmsRecord> reciveList = smsRecordService.find(smsRecordExample1);			
			List<TreeDTO> reciverList = getReciveList(reciveList);
			smsAtlasCountDTO.setReciveTopicList(reciverList);
			return Result.success(smsAtlasCountDTO);
		} catch (Exception e) {
			log.error("获取发送、接收图谱出错:"+e);
			return Result.fail("获取发送、接收图谱出错");
		}
	}
	/**
	 * 组装发送信息
	 * @return
	 */
	private List<TreeDTO> getSenderList(List<SmsRecord> list){		
		if(list==null||list.size()==0){
			return null;
		}
		List<TreeDTO> result = new ArrayList<TreeDTO>();
		Set<String> set = new HashSet<String>();
		for(SmsRecord smsRecord:list){
			String sender = smsRecord.getSender();
			if(sender!=null&&!"".equals(sender)){
				set.add(sender);
			}			
		}
		if(set.size()==0){
			return null;
		}
		for(String sender:set){
			TreeDTO treeDTO = new TreeDTO();
			List<TreeChaildDTO> topics = new ArrayList<TreeChaildDTO>();	
			String senderName = "";
			for(SmsRecord smsRecord:list){
				String send = smsRecord.getSender();
				String topic = smsRecord.getTopic();				
				if(send!=null&&send.equals(sender)&&!StringUtils.isEmpty(topic)){	
					TreeChaildDTO treeChaildDTO = new TreeChaildDTO();
					treeChaildDTO.setName(topic);
					topics.add(treeChaildDTO);
					senderName = smsRecord.getSenderName();
				}else if(send!=null&&send.equals(sender)&&StringUtils.isEmpty(topic)){
					senderName = smsRecord.getAppName();
				}				
			}	
			treeDTO.setName(senderName);
			treeDTO.setChildren(topics);
			result.add(treeDTO);
		}
		return result;		
	}
	/**
	 * 组装接收信息
	 * @return
	 */
	private List<TreeDTO> getReciveList(List<SmsRecord> list){		
		if(list==null||list.size()==0){
			return null;
		}
		List<TreeDTO> result = new ArrayList<TreeDTO>();
		Set<String> set = new HashSet<String>();
		for(SmsRecord smsRecord:list){
			String topic = smsRecord.getTopic();
			if(topic!=null&&!"".equals(topic)){
				set.add(topic);
			}			
		}
		if(set.size()==0){
			return null;
		}
		for(String topic:set){
			TreeDTO treeDTO = new TreeDTO();
			List<TreeChaildDTO> recivers = new ArrayList<TreeChaildDTO>();
			for(SmsRecord smsRecord:list){
				String reciver = smsRecord.getReceiver();
				List<String> sreciver = Arrays.asList(reciver.split(","));
				String title = smsRecord.getTopic();
				for(String jie:sreciver){									
					if(!StringUtils.isEmpty(title)&&title.equals(topic)){
						TreeChaildDTO treeChaildDTO = new TreeChaildDTO();
						treeChaildDTO.setName(jie);
						recivers.add(treeChaildDTO);
					}		
				}
			}
			treeDTO.setName(topic);
			treeDTO.setChildren(recivers);
			result.add(treeDTO);
		}
		return result;		
	}
}





