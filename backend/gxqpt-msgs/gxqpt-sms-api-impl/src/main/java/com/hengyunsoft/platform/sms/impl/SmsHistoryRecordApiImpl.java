package com.hengyunsoft.platform.sms.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.platform.sms.constant.SmSConstant;
import com.hengyunsoft.platform.sms.dto.SmsAcountDTO;
import com.hengyunsoft.platform.sms.dto.SmsMonthAcountDTO;
import com.hengyunsoft.platform.sms.dto.SmsTemplateTop10DTO;
import com.hengyunsoft.platform.sms.dto.SmsYearAcountDTO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsMonthAcountDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsRequestDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTemplateTop10DO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsYearAcountDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;
import com.hengyunsoft.platform.sms.repository.template.example.TemplateExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsRecordService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;
import com.hengyunsoft.platform.sms.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "短信首页", description = "短信首页")
public class SmsHistoryRecordApiImpl {
	
	@Autowired
	private SmsRecordService smsRecordService;
	@Autowired
	private MsgsChannelService msgsChannelService;
	@Autowired
	private SmsTemplateService smsTemplateService;
	@Autowired
    private DozerUtils dozerUtils;
	
	private String sourceType = SmSConstant.SystemType.APP.toString();
	
	/**
     * 各短信量统计
     * @return
     */
	@RequestMapping(value = "/home/smsacount", method = RequestMethod.GET)
	@ApiOperation(value="各短信量统计",notes = "各短信量统计")
	public Result<SmsAcountDTO> getSmsAcount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			SmsAcountDTO smsAcountDTO = new SmsAcountDTO();
			//发送量
			Integer num = smsRecordService.getSendNum(String.valueOf(userId));
			if(num!=null){
				smsAcountDTO.setSendNum(num);
			}else{
				smsAcountDTO.setSendNum(0);
			}
			//草稿箱短信数量
			SmsRecordExample smsRecordExample1 = new SmsRecordExample();
			smsRecordExample1.createCriteria().andSenderEqualTo(String.valueOf(userId))
			.andSourceTypeEqualTo(sourceType).andDraftEqualTo(1);
			List<SmsRecord> list2 = smsRecordService.find(smsRecordExample1);
			if(list2!=null){
				Integer draftNum = list2.size();
				smsAcountDTO.setDraftNum(draftNum);
			}else{
				smsAcountDTO.setDraftNum(0);
			}			
			//短信模板数量
			TemplateExample smsTemplateExample = new TemplateExample();
			smsTemplateExample.createCriteria().andCreateUserEqualTo(userId);
			List<SmsTemplate> templateList = smsTemplateService.find(smsTemplateExample);
			if(templateList!=null){
				Integer modleNum = templateList.size();
				smsAcountDTO.setModleNum(modleNum);
			}else{
				smsAcountDTO.setModleNum(0);
			}
			//短信服务账号数量
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeEqualTo(3);
			List<MsgsChannel> channelList = msgsChannelService.find(msgsChannelExample);
			if(channelList!=null){
				Integer accountNum = channelList.size();
				smsAcountDTO.setAccountNum(accountNum);
			}else{
				smsAcountDTO.setAccountNum(0);
			}
			return Result.success(smsAcountDTO);			
		} catch (Exception e) {
			log.error("各短信量统计出错："+e);
			return Result.fail("各短信量统计出错");
		}
	}
	/**
     * 近一月短信使用情况
     * @return
     */
	@RequestMapping(value = "/home/acount/month", method = RequestMethod.GET)
	@ApiOperation(value="近一月短信使用情况",notes = "近一月短信使用情况")
	public Result<List<SmsMonthAcountDTO>> getSmsMonthAcount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			SmsRequestDO smsRequestDO = new SmsRequestDO();
			smsRequestDO.setSourceType(sourceType);
			smsRequestDO.setUserId(userId);			
			List<SmsMonthAcountDO> result = smsRecordService.getSmsMonthAcount(smsRequestDO);
			//组装日期数据
			if(!Util.isEmpty(result)){
				List<String> dates = new ArrayList<String>();
				for(SmsMonthAcountDO smsMonthAcountDO:result){
					String date = smsMonthAcountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsMonthAcountDO.getMonth())+"-"+DateUtil.getMonthAddZero(smsMonthAcountDO.getDay());					
					dates.add(date);
					smsMonthAcountDO.setMonth(DateUtil.getMonthAddZero(smsMonthAcountDO.getMonth()));
					smsMonthAcountDO.setDay(DateUtil.getMonthAddZero(smsMonthAcountDO.getDay()));
				}
				List<Date> dateList = DateUtil.getDatesBetweenTwoDate(DateUtil.getBeforeMonthTime(),new Date());
				for(Date date:dateList){
					String date_ = DateUtil.dateToStr1(date);
					if(!dates.contains(date_)){						
						SmsMonthAcountDO smsMonthAcountDO = new SmsMonthAcountDO();
						smsMonthAcountDO.setYear(date_.substring(0, 4));
						smsMonthAcountDO.setMonth(date_.substring(5,7));
						smsMonthAcountDO.setDay(date_.substring(8));
						smsMonthAcountDO.setSuccess(0);
						smsMonthAcountDO.setFail(0);
						result.add(smsMonthAcountDO);
					}
				}
				//排序
	            Collections.sort(result, new Comparator<SmsMonthAcountDO>() {            	 
	    			@Override
	    			public int compare(SmsMonthAcountDO o1, SmsMonthAcountDO o2) {    				
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
				result = new ArrayList<SmsMonthAcountDO>();
				List<Date> dateList = DateUtil.getDatesBetweenTwoDate(DateUtil.getBeforeMonthTime(),new Date());
				for(Date date:dateList){
					String date_ = DateUtil.dateToStr1(date);
					SmsMonthAcountDO smsMonthAcountDTO = new SmsMonthAcountDO();
					smsMonthAcountDTO.setYear(date_.substring(0, 4));
					smsMonthAcountDTO.setMonth(date_.substring(5,7));
					smsMonthAcountDTO.setDay(date_.substring(8));
					smsMonthAcountDTO.setSuccess(0);
					smsMonthAcountDTO.setFail(0);
					result.add(smsMonthAcountDTO);
				}
			}	
			List<SmsMonthAcountDTO> list = dozerUtils.mapList(result, SmsMonthAcountDTO.class);
			return Result.success(list);
		} catch (Exception e) {
			log.error("获取近一月短信使用情况出错："+e);
			return Result.fail("获取近一月短信使用情况出错");
		}
	}
	/**
     * 近一年短信使用情况
     * @return
     */
	@RequestMapping(value = "/home/acount/year", method = RequestMethod.GET)
	@ApiOperation(value="近一年短信使用情况",notes = "近一年短信使用情况")
	public Result<List<SmsYearAcountDTO>> getSmsYearAcount() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			SmsRequestDO smsRequestDO = new SmsRequestDO();
			smsRequestDO.setSourceType(sourceType);
			smsRequestDO.setUserId(userId);			
			List<SmsYearAcountDO> list = smsRecordService.getSmsYearAcount(smsRequestDO);
			if(list!=null&&list.size()>0){
				List<String> dates = new ArrayList<String>();
				for(SmsYearAcountDO smsYearAcountDO:list){
					String month_ = smsYearAcountDO.getYear()+"-"+DateUtil.getMonthAddZero(smsYearAcountDO.getMonth());
					dates.add(month_);
					smsYearAcountDO.setMonth(DateUtil.getMonthAddZero(smsYearAcountDO.getMonth()));
				}
				List<String> months = DateUtil.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						SmsYearAcountDO smsYearAcountDO = new SmsYearAcountDO();
						smsYearAcountDO.setYear(month.substring(0, 4));
						smsYearAcountDO.setMonth(month.substring(5));
						smsYearAcountDO.setCount(0);
						list.add(smsYearAcountDO);
					}
				}

				//排序
	            Collections.sort(list, new Comparator<SmsYearAcountDO>() {            	 
	    			@Override
	    			public int compare(SmsYearAcountDO o1, SmsYearAcountDO o2) {    				
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
					SmsYearAcountDO smsYearAcountDO = new SmsYearAcountDO();
					smsYearAcountDO.setYear(month.substring(0, 4));
					smsYearAcountDO.setMonth(month.substring(5));
					smsYearAcountDO.setCount(0);
					list.add(smsYearAcountDO);
				}
			}
			List<SmsYearAcountDTO> result = dozerUtils.mapList(list, SmsYearAcountDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("获取近一年短信使用情况出错："+e);
			return Result.fail("获取近一年短信使用情况出错");
		}
	}
	/**
     * 模板使用TOP10
     * @return
     */
	@RequestMapping(value = "/home/template/top10", method = RequestMethod.GET)
	@ApiOperation(value="模板使用TOP10",notes = "模板使用TOP10")
	public Result<List<SmsTemplateTop10DTO>> getTemplateTop10() {
		try {
			Long userId = BaseContextHandler.getAdminId();
			SmsRequestDO smsRequestDO = new SmsRequestDO();
			smsRequestDO.setSourceType(sourceType);
			smsRequestDO.setUserId(userId);			
			List<SmsTemplateTop10DO> list = smsRecordService.getTemplateTop10(smsRequestDO);
			List<SmsTemplateTop10DTO> result = dozerUtils.mapList(list, SmsTemplateTop10DTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("获取模板使用TOP10出错："+e);
			return Result.fail("获取模板使用TOP10出错");
		}
	}

}
