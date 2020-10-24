//package com.hengyunsoft.platform.warn.jobs;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.platform.warn.entity.domain.FairWarnNumberCountDO;
//import com.hengyunsoft.platform.warn.entity.domain.ObjectWarnCountDO;
//import com.hengyunsoft.platform.warn.entity.po.WarnScaleStatistical;
//import com.hengyunsoft.platform.warn.entity.po.WarnTimeSlot;
//import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
//import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;
//import com.hengyunsoft.platform.warn.repository.service.WarnTimeSlotService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class WarnTimeSlotActuator{
//	@Autowired
//	private GxqptWarnService gxqptWarnService;
//	@Autowired
//	private WarnTimeSlotService warnTimeSlotService;
//	@Autowired
//	private WarnScaleStatisticalService warnScaleStatisticalService;
//	
//    @Scheduled(cron = "0 0 1  1 * ?")//每月一日的01:00:00触发    0 0 1 1 * ?
//    public void warnTimeSlotTask() {
//    	log.info("执行应用预警统计任务开始");
//    	try {			
//	    	//获取上个月1号00:00:00的时间
//	    	Date beforeDate = getBeforeMonthTime();
//	    	//获取本月1号00:00:00的时间
//	    	Date date = getThisMonthTime();
//	    	//查询数据
//	    	List<FairWarnNumberCountDO> list = gxqptWarnService.getNewCome(beforeDate,date);   	
//	    	Set<String> set = new HashSet<String>();
//	    	for(FairWarnNumberCountDO dto:list){
//	    		String appid = dto.getAppId();
//	    		String appName = dto.getAppName();
//	    		if(!StringUtils.isEmpty(appid)&&!StringUtils.isEmpty(appName)){
//	    			set.add(appid);
//	    		}	    		
//	    	}    	
//	    	//组装数据
//	    	List<WarnTimeSlot> warnList = new ArrayList<WarnTimeSlot>();
//	    	Date thisTime = new Date();
//	    	String month = getMonthString();
//	    	for (String appid:set) {   
//	    		WarnTimeSlot warnTimeSlot = new WarnTimeSlot();
//	    		warnTimeSlot.setAppId(appid);
//	    		warnTimeSlot.setCreateTime(thisTime);
//	    		warnTimeSlot.setStatisticalTime(month);
//	    		Double avgHandleTime = 0.0;
//	    		Double avgConfirmTime = 0.0;
//	    		int num = 0;
//	    		for(FairWarnNumberCountDO dto:list){
//	    			if(StringUtils.isEmpty(dto.getAppId())||StringUtils.isEmpty(dto.getAppName())){
//		    			continue;
//		    		}
//		    		num += 1;
//		    		avgHandleTime += Double.valueOf(dto.getHandleCostTime()==null?"0.00":dto.getHandleCostTime());
//		    		avgConfirmTime += Double.valueOf(dto.getConfirmCostTime()==null?"0.00":dto.getConfirmCostTime());
//	    			warnTimeSlot.setAppName(dto.getAppName());
//	    			if(appid.equals(dto.getAppId())&&"1".equals(dto.getTag())){    				
//	    				warnTimeSlot.setNewCome(dto.getCount()==null?0:dto.getCount());
//	    			}
//					if(appid.equals(dto.getAppId())&&"2".equals(dto.getTag())){
//						warnTimeSlot.setHandled(dto.getCount()==null?0:dto.getCount());		
//					}
//					if(appid.equals(dto.getAppId())&&"3".equals(dto.getTag())){
//						warnTimeSlot.setPending(dto.getCount()==null?0:dto.getCount());
//					}
//	    		}
//	    		if(num!=0){
//	    			warnTimeSlot.setAvgConfirmTime(String.valueOf(avgConfirmTime/num));
//	    			warnTimeSlot.setAvgHandleTime(String.valueOf(avgHandleTime/num));
//	    		}else{
//	    			warnTimeSlot.setAvgConfirmTime("0");
//	    			warnTimeSlot.setAvgHandleTime("0");
//	    		}
//	    		warnList.add(warnTimeSlot);
//	    	}
//	    	warnTimeSlotService.save(warnList);
//	    	log.info("执行应用预警统计任务结束");
//		} catch (Exception e) {
//			log.error("每月统计预警数量出错"+e);
//		}
//    }
//    
//    
//    /**
//     * 单位、部门、人员预警统计任务
//     */
//    @Scheduled(cron = "0 0 1  1 * ?")//每月一日的01:00:00触发  
//    public void warnScaleTask() {
//    	log.info("执行单位、部门、人员预警统计任务开始");
//    	try {			
//	    	//获取上个月1号00:00:00的时间
//	    	Date beforeDate = getBeforeMonthTime();
//	    	//获取本月1号00:00:00的时间
//	    	Date date = getThisMonthTime();
//	    	Date thisTime = new Date();
//	    	String month = getMonthString();
//	    	List<WarnScaleStatistical> warnList = new ArrayList<WarnScaleStatistical>();
//	    	
//	    	//查询单位数据
//	    	List<ObjectWarnCountDO> orgList = gxqptWarnService.getOrgWarns(beforeDate,date);   	
//	    	Set<String> set = new HashSet<String>();
//	    	for(ObjectWarnCountDO dto:orgList){
//	    		String objId = dto.getObjectId();
//	    		String objName = dto.getObjectName();
//	    		if(!StringUtils.isEmpty(objId)&&!StringUtils.isEmpty(objName)){
//	    			set.add(objId);
//	    		}	
//	    	}    	
//	    	//组装单位数据	    	
//	    	for (String objId:set) {   
//	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
//	    		warnScaleStatistical.setObjectId(objId);
//	    		warnScaleStatistical.setCreateTime(thisTime);
//	    		warnScaleStatistical.setStatisticalScale(month);
//	    		warnScaleStatistical.setObjectType(1);
//	    		Double avgHandleTime = 0.0;
//	    		Double avgConfirmTime = 0.0;
//	    		int num = 0;
//	    		for(ObjectWarnCountDO dto:orgList){   
//		    		if(StringUtils.isEmpty(dto.getObjectId())||StringUtils.isEmpty(dto.getObjectName())){
//		    			continue;
//		    		}
//		    		num += 1;
//		    		avgHandleTime += Double.valueOf(dto.getHandleCostTime()==null?"0.00":dto.getHandleCostTime());
//		    		avgConfirmTime += Double.valueOf(dto.getConfirmCostTime()==null?"0.00":dto.getConfirmCostTime());
//	    			warnScaleStatistical.setObjectName(dto.getObjectName());
//	    			if(objId.equals(dto.getObjectId())&&"1".equals(dto.getTag())){    				
//	    				warnScaleStatistical.setNewComeNum(dto.getCount()==null?0:dto.getCount());
//	    			}
//					if(objId.equals(dto.getObjectId())&&"2".equals(dto.getTag())){
//						warnScaleStatistical.setHandledNum(dto.getCount()==null?0:dto.getCount());		
//					}
//					if(objId.equals(dto.getObjectId())&&"3".equals(dto.getTag())){
//						warnScaleStatistical.setPendingNum(dto.getCount()==null?0:dto.getCount());
//					}
//	    		}
//	    		if(num!=0){
//	    			warnScaleStatistical.setAvgConfirmTime(String.valueOf(avgConfirmTime/num));
//	    			warnScaleStatistical.setAvgHandleTime(String.valueOf(avgHandleTime/num));
//	    		}else{
//	    			warnScaleStatistical.setAvgConfirmTime("0");
//	    			warnScaleStatistical.setAvgHandleTime("0");
//	    		}
//	    		warnList.add(warnScaleStatistical);
//	    	}
//
//	    	//查询部门数据
//	    	List<ObjectWarnCountDO> depList = gxqptWarnService.getDepWarns(beforeDate,date);   	
//	    	Set<String> depSet = new HashSet<String>();
//	    	for(ObjectWarnCountDO dto:depList){
//	    		String objId = dto.getObjectId();
//	    		String objName = dto.getObjectName();
//	    		if(!StringUtils.isEmpty(objId)&&!StringUtils.isEmpty(objName)){
//	    			depSet.add(objId);
//	    		}
//	    	}    	
//	    	//组装部门数据
//	    	for (String objId:depSet) {   
//	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
//	    		warnScaleStatistical.setObjectId(objId);
//	    		warnScaleStatistical.setCreateTime(thisTime);
//	    		warnScaleStatistical.setStatisticalScale(month);
//	    		warnScaleStatistical.setObjectType(2);
//	    		Double avgHandleTime = 0.0;
//	    		Double avgConfirmTime = 0.0;
//	    		int num = 0;
//	    		for(ObjectWarnCountDO dto:orgList){   
//		    		if(StringUtils.isEmpty(dto.getObjectId())||StringUtils.isEmpty(dto.getObjectName())){
//		    			continue;
//		    		}
//		    		num += 1;
//		    		avgHandleTime += Double.valueOf(dto.getHandleCostTime()==null?"0.00":dto.getHandleCostTime());
//		    		avgConfirmTime += Double.valueOf(dto.getConfirmCostTime()==null?"0.00":dto.getConfirmCostTime());
//	    			warnScaleStatistical.setObjectName(dto.getObjectName());
//	    			if(objId.equals(dto.getObjectId())&&"1".equals(dto.getTag())){    				
//	    				warnScaleStatistical.setNewComeNum(dto.getCount()==null?0:dto.getCount());
//	    			}
//					if(objId.equals(dto.getObjectId())&&"2".equals(dto.getTag())){
//						warnScaleStatistical.setHandledNum(dto.getCount()==null?0:dto.getCount());		
//					}
//					if(objId.equals(dto.getObjectId())&&"3".equals(dto.getTag())){
//						warnScaleStatistical.setPendingNum(dto.getCount()==null?0:dto.getCount());
//					}
//	    		}
//	    		if(num!=0){
//	    			warnScaleStatistical.setAvgConfirmTime(String.valueOf(avgConfirmTime/num));
//	    			warnScaleStatistical.setAvgHandleTime(String.valueOf(avgHandleTime/num));
//	    		}else{
//	    			warnScaleStatistical.setAvgConfirmTime("0");
//	    			warnScaleStatistical.setAvgHandleTime("0");
//	    		}
//	    		warnList.add(warnScaleStatistical);
//	    	}
//
//	    	//查询人员数据
//	    	List<ObjectWarnCountDO> empList = gxqptWarnService.getEmpWarns(beforeDate,date);   	
//	    	Set<String> empSet = new HashSet<String>();
//	    	for(ObjectWarnCountDO dto:empList){
//	    		String objId = dto.getObjectId();
//	    		String objName = dto.getObjectName();
//	    		if(!StringUtils.isEmpty(objId)&&!StringUtils.isEmpty(objName)){
//	    			empSet.add(objId);
//	    		}
//	    	}    	
//	    	//组装人员数据
//	    	for (String objId:empSet) {   
//	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
//	    		warnScaleStatistical.setObjectId(objId);
//	    		warnScaleStatistical.setCreateTime(thisTime);
//	    		warnScaleStatistical.setStatisticalScale(month);
//	    		warnScaleStatistical.setObjectType(3);
//	    		Double avgHandleTime = 0.0;
//	    		Double avgConfirmTime = 0.0;
//	    		int num = 0;
//	    		for(ObjectWarnCountDO dto:empList){   
//		    		if(StringUtils.isEmpty(dto.getObjectId())||StringUtils.isEmpty(dto.getObjectName())){
//		    			continue;
//		    		}
//		    		num += 1;
//		    		avgHandleTime += Double.valueOf(dto.getHandleCostTime()==null?"0.00":dto.getHandleCostTime());
//		    		avgConfirmTime += Double.valueOf(dto.getConfirmCostTime()==null?"0.00":dto.getConfirmCostTime());		    		
//	    			warnScaleStatistical.setObjectName(dto.getObjectName());
//	    			if(objId.equals(dto.getObjectId())&&"1".equals(dto.getTag())){    				
//	    				warnScaleStatistical.setNewComeNum(dto.getCount()==null?0:dto.getCount());
//	    			}
//					if(objId.equals(dto.getObjectId())&&"2".equals(dto.getTag())){
//						warnScaleStatistical.setHandledNum(dto.getCount()==null?0:dto.getCount());		
//					}
//					if(objId.equals(dto.getObjectId())&&"3".equals(dto.getTag())){
//						warnScaleStatistical.setPendingNum(dto.getCount()==null?0:dto.getCount());
//					}
//	    		}
//	    		if(num!=0){
//	    			warnScaleStatistical.setAvgConfirmTime(String.valueOf(avgConfirmTime/num));
//	    			warnScaleStatistical.setAvgHandleTime(String.valueOf(avgHandleTime/num));
//	    		}else{
//	    			warnScaleStatistical.setAvgConfirmTime("0");
//	    			warnScaleStatistical.setAvgHandleTime("0");
//	    		}	    		
//	    		warnList.add(warnScaleStatistical);
//	    	}
//	    	//保存数据
//	    	warnScaleStatisticalService.save(warnList);
//	    	log.info("执行单位、部门、人员预警统计任务结束");
//		} catch (Exception e) {
//			log.error("每月统计预警数量出错"+e);
//		}
//    }
//    
//    
//    
//    /**
//     * 获取上个月1号00:00:00的时间
//     * @return
//     */
//    static Date getBeforeMonthTime(){
//    	Calendar calendar = Calendar.getInstance();    
//    	calendar.add(Calendar.MONTH, -1);
//    	calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
//    	//将小时至0  
//    	calendar.set(Calendar.HOUR_OF_DAY, 0);  
//    	//将分钟至0  
//    	calendar.set(Calendar.MINUTE, 0);  
//    	//将秒至0  
//    	calendar.set(Calendar.SECOND,0);  
//    	//将毫秒至0  
//    	calendar.set(Calendar.MILLISECOND, 0); 
//		return calendar.getTime();    	
//    }
//    /**
//     * 获取本月1号00:00:00的时间
//     * @return
//     */
//    static Date getThisMonthTime(){
//    	Calendar calendar = Calendar.getInstance();    
//    	calendar.add(Calendar.MONTH, 0);
//    	calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
//    	//将小时至0  
//    	calendar.set(Calendar.HOUR_OF_DAY, 0);  
//    	//将分钟至0  
//    	calendar.set(Calendar.MINUTE, 0);  
//    	//将秒至0  
//    	calendar.set(Calendar.SECOND,0);  
//    	//将毫秒至0  
//    	calendar.set(Calendar.MILLISECOND, 0); 
//		return calendar.getTime();    	
//    }
//    /**
//     * 获取当前月份
//     * @return
//     */
//    static String getMonthString(){
//    	Calendar calendar = Calendar.getInstance();    	
//    	String year = String.valueOf(calendar.get(Calendar.YEAR));
//    	int month = calendar.get(Calendar.MONTH);
//    	String month1 = "";  
//    	if(month<10){
//    		month1 = "0"+month;
//    	}else{
//    		month1 = String.valueOf(month);
//    	}
//		return year+month1;   	
//    }
//}
