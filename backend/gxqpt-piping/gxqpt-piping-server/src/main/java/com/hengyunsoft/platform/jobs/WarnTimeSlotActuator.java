package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.warn.entity.domain.FairWarnNumberCountDO;
import com.hengyunsoft.platform.warn.entity.domain.ObjectWarnCountDO;
import com.hengyunsoft.platform.warn.entity.po.WarnScaleStatistical;
import com.hengyunsoft.platform.warn.entity.po.WarnTimeSlot;
import com.hengyunsoft.platform.warn.repository.example.WarnScaleStatisticalExample;
import com.hengyunsoft.platform.warn.repository.example.WarnTimeSlotExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;
import com.hengyunsoft.platform.warn.repository.service.WarnTimeSlotService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author dxz
 * 定时统计个个人员 部门应用的预警情况
 * */
@Slf4j
@Component
public class WarnTimeSlotActuator{
	@Autowired
	private GxqptWarnService gxqptWarnService;
	@Autowired
	private WarnTimeSlotService warnTimeSlotService;
	@Autowired
	private WarnScaleStatisticalService warnScaleStatisticalService;

	/**
     * @Scheduled(cron = "0 0 1  1 * ?")//每月一日的01:00:00触发    0 0 1 1 * ?
     * 每5分钟执行一次
     * */
	@Scheduled(cron = "0 0/30 * * * ?")
    public void warnTimeSlotTask() {
    	log.info("执行应用预警统计任务开始");
    	try {			
	    	//获取本月最后一天的结束的时间  23:59:59
            Dates dates = getDate();
            Date endDate = dates.getEndDate();
	    	//获取本月1号00:00:00的时间
	    	Date beforeDate = dates.getBeforeDate();
	    	//查询数据
	    	List<FairWarnNumberCountDO> list = gxqptWarnService.getNewCome(beforeDate,endDate);
	    	Set<String> set = new HashSet<String>();
	    	for(FairWarnNumberCountDO dto:list){
	    		if(!StringUtils.isEmpty(dto.getAppId())&&!StringUtils.isEmpty(dto.getAppName())){
	    			set.add(dto.getAppId());
	    		}	    		
	    	}    	
	    	//组装数据
	    	List<WarnTimeSlot> warnList = new ArrayList<WarnTimeSlot>();
	    	Date thisTime = dates.getThisTime();
	    	String month = dates.getYearDate();
	    	for (String appid:set) {   
	    		WarnTimeSlot warnTimeSlot = new WarnTimeSlot();
	    		warnTimeSlot.setAppId(appid);
	    		warnTimeSlot.setCreateTime(thisTime);
	    		warnTimeSlot.setStatisticalTime(month);
	    		String avgHandleTime;
                String avgConfirmTime;
	    		for(FairWarnNumberCountDO dto:list){

	    			if(StringUtils.isEmpty(dto.getAppId())||StringUtils.isEmpty(dto.getAppName())){
		    			continue;
		    		}
					if(appid.equals(dto.getAppId())){
						warnTimeSlot.setAppName(dto.getAppName());
						//新预警
						if("1".equals(dto.getTag())){
							warnTimeSlot.setNewCome(dto.getCount()==null?0:dto.getCount());
						}
						//已处理
						if("2".equals(dto.getTag())){
							avgHandleTime = dto.getHandleCostTime() == null ? "0.00" : dto.getHandleCostTime();
                            warnTimeSlot.setAvgHandleTime(String.valueOf(avgHandleTime));
                            warnTimeSlot.setHandled(dto.getCount()==null?0:dto.getCount());
						}
						//待处理预警
						if("3".equals(dto.getTag())){
							warnTimeSlot.setPending(dto.getCount()==null?0:dto.getCount());
						}
						//未确认
						if("4".equals(dto.getTag())){
							warnTimeSlot.setUnconfirm(dto.getCount()==null?0:dto.getCount());
						}
						//已确认
						if("5".equals(dto.getTag())){
							avgConfirmTime = dto.getConfirmCostTime() == null ? "0.00" : dto.getConfirmCostTime();
                            warnTimeSlot.setAvgConfirmTime(String.valueOf(avgConfirmTime));
							warnTimeSlot.setConfirm(dto.getCount()==null?0:dto.getCount());
						}
					}
	    		}

	    		WarnTimeSlotExample warnTimeSlotExample = new WarnTimeSlotExample();
                warnTimeSlotExample.createCriteria().andAppIdEqualTo(warnTimeSlot.getAppId()).andStatisticalTimeEqualTo(warnTimeSlot.getStatisticalTime());
                WarnTimeSlot unique = warnTimeSlotService.getUnique(warnTimeSlotExample);
                if(null != unique && unique.getId() > 0){
                    warnTimeSlot.setId(unique.getId());
                    warnTimeSlotService.updateByIdSelective(warnTimeSlot);
                }else {
                    warnList.add(warnTimeSlot);
                }
	    	}
	    	if(warnList.size() > 0){
                warnTimeSlotService.save(warnList);
                log.info("执行应用预警统计任务结束");
            }
		} catch (Exception e) {
			log.error("每月统计预警数量出错"+e);
		}
    }


    /**
     * 单位、部门、人员预警统计任务
     * @Scheduled(cron = "0 0 1  1 * ?")//每月一日的01:00:00触发
     * 每30分钟执行一次
     */
	@Scheduled(cron = "0 0/30 * * * ?")
    public void warnScaleTask() {
    	log.info("执行单位、部门、人员预警统计任务开始");
    	try {			
	    	//获取这个月最后一天的结束的时间  23:59:59
            Dates dates = getDate();
	    	Date endDate = dates.getEndDate();
	    	//获取本月1号00:00:00的时间
	    	Date beforeDate = dates.getBeforeDate();
	    	Date thisTime = dates.getThisTime();
	    	String month = dates.getYearDate();
	    	List<WarnScaleStatistical> warnList = new ArrayList<>();
	    	
	    	//查询单位数据
	    	List<ObjectWarnCountDO> orgList = gxqptWarnService.getOrgWarns(beforeDate,endDate);
	    	Set<String> set = new HashSet<String>();
	    	for(ObjectWarnCountDO dto:orgList){
				log.info("单位数据: orgList -> dto :{}",dto.toString());
	    		if(!StringUtils.isEmpty(dto.getObjectId())&&!StringUtils.isEmpty(dto.getObjectName())){
	    			set.add(dto.getObjectId());
	    		}	
	    	}    	
	    	//组装单位数据	    	
	    	for (String objId:set) {   
	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
	    		warnScaleStatistical.setObjectId(objId);
	    		warnScaleStatistical.setCreateTime(thisTime);
	    		warnScaleStatistical.setStatisticalScale(month);
	    		warnScaleStatistical.setObjectType(1);

				WarnScaleStatistical childOrgWarn = dealObjectWarn(orgList, warnScaleStatistical, objId);

                WarnScaleStatisticalExample warnScaleStatisticalExample = new WarnScaleStatisticalExample();
                warnScaleStatisticalExample.createCriteria().andObjectIdEqualTo(childOrgWarn.getObjectId()).andStatisticalScaleEqualTo(childOrgWarn.getStatisticalScale()).andObjectTypeEqualTo(1);
                WarnScaleStatistical unique = warnScaleStatisticalService.getUnique(warnScaleStatisticalExample);
                if(null != unique && unique.getId() > 0){
					childOrgWarn.setId(unique.getId());
                    warnScaleStatisticalService.updateByIdSelective(childOrgWarn);
                }else{
                    warnList.add(childOrgWarn);
                }
	    	}

	    	//查询部门数据
	    	List<ObjectWarnCountDO> depList = gxqptWarnService.getDepWarns(beforeDate,endDate);
	    	Set<String> depSet = new HashSet<String>();
	    	for(ObjectWarnCountDO dto:depList){
				log.info("部门数据: depList -> dto :{}",dto.toString());
	    		if(!StringUtils.isEmpty(dto.getObjectId())&&!StringUtils.isEmpty(dto.getObjectName())){
	    			depSet.add(dto.getObjectId());
	    		}
	    	}    	
	    	//组装部门数据
	    	for (String objId:depSet) {   
	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
	    		warnScaleStatistical.setObjectId(objId);
	    		warnScaleStatistical.setCreateTime(thisTime);
	    		warnScaleStatistical.setStatisticalScale(month);
	    		warnScaleStatistical.setObjectType(2);

				WarnScaleStatistical childDepWarn = dealObjectWarn(depList, warnScaleStatistical, objId);

	    		//查询之前本月是否有记录 有就更新   没有就新增
				WarnScaleStatisticalExample warnScaleStatisticalExample = new WarnScaleStatisticalExample();
				warnScaleStatisticalExample.createCriteria().andObjectIdEqualTo(childDepWarn.getObjectId()).andStatisticalScaleEqualTo(childDepWarn.getStatisticalScale()).andObjectTypeEqualTo(2);
                WarnScaleStatistical unique = warnScaleStatisticalService.getUnique(warnScaleStatisticalExample);
                if(null != unique && unique.getId() > 0){
					childDepWarn.setId(unique.getId());
                    warnScaleStatisticalService.updateByIdSelective(childDepWarn);
                }else{
                    warnList.add(childDepWarn);
                }
	    	}

	    	//查询人员数据
	    	List<ObjectWarnCountDO> empList = gxqptWarnService.getEmpWarns(beforeDate,endDate);
	    	Set<String> empSet = new HashSet<String>();
	    	for(ObjectWarnCountDO dto:empList){
				log.info("人员数据: empList -> dto :{}",dto.toString());
	    		if(!StringUtils.isEmpty(dto.getObjectId())&&!StringUtils.isEmpty(dto.getObjectName())){
	    			empSet.add(dto.getObjectId());
	    		}
	    	}    	
	    	//组装人员数据
	    	for (String objId:empSet) {   
	    		WarnScaleStatistical warnScaleStatistical = new WarnScaleStatistical();
	    		warnScaleStatistical.setObjectId(objId);
	    		warnScaleStatistical.setCreateTime(thisTime);
	    		warnScaleStatistical.setStatisticalScale(month);
	    		warnScaleStatistical.setObjectType(3);

				WarnScaleStatistical childEmpWarn = dealObjectWarn(empList, warnScaleStatistical, objId);

				if(null != childEmpWarn){
					WarnScaleStatisticalExample warnScaleStatisticalExample = new WarnScaleStatisticalExample();
					warnScaleStatisticalExample.createCriteria().andObjectIdEqualTo(childEmpWarn.getObjectId()).andStatisticalScaleEqualTo(childEmpWarn.getStatisticalScale()).andObjectTypeEqualTo(3);
					WarnScaleStatistical unique = warnScaleStatisticalService.getUnique(warnScaleStatisticalExample);
					if(null != unique && unique.getId() > 0){
						childEmpWarn.setId(unique.getId());
						warnScaleStatisticalService.updateByIdSelective(childEmpWarn);
					}else{
						warnList.add(childEmpWarn);
					}
				}
	    	}
	    	//保存数据
            if(warnList.size() > 0){
                warnScaleStatisticalService.save(warnList);
                log.info("执行单位、部门、人员预警统计任务结束");
            }
		} catch (Exception e) {
			log.error("每月统计预警数量出错"+e);
		}
    }
    /**
     * @method
     * @description 获取统建的时间   假如为统计定时未 5 分钟一次  可能这个月的最后一天的最后几分钟数据有误差
     * 那么在第二个月的开始 第一次统计时  先统计前面一个月的所有数据
     * @date: 2019/4/30 0030 11:51
     * @author: mdengb
     * @param
     * @return
     */
    private Dates getDate(){

        Calendar curMonthBeginC = Calendar.getInstance();
        Calendar endDayOfYesterdayC = Calendar.getInstance();
        Dates dates = new Dates();
        Date thisTime = new Date();
         //获取本月的结束时间
        Date curMonthEnd = DateUtils.getCurMonthEnd();
        //本月的开始时间
        Date curMonthBegin = DateUtils.getCurMonthBegin();
        //获取昨天时间 如果当前的时间和昨天的不是一个月  就先把上个月的数据最后统计一次  下一次再同步当月的数据
        Date endDayOfYesterday = DateUtils.getEndDayOfYesterDay();
        curMonthBeginC.setTime(curMonthBegin);
        endDayOfYesterdayC.setTime(endDayOfYesterday);
        //定时方法执行的定时时间 60min
        Double jobTime = 60.0;
        if(curMonthBeginC.get(Calendar.MONTH) == endDayOfYesterdayC.get(Calendar.MONTH)){
            dates =  dealMonth(curMonthBeginC, dates, thisTime, curMonthEnd, curMonthBegin);
        } else {
            //遇到月份交替时 在定时时间内 如果小于定时时间差的 就先统计上一个月的数量
            if(jobTime > DateUtils.getDistMinute(thisTime,endDayOfYesterday)){
                //获取上一个月的第一天开始时间
                Date monthFirstDay = DateUtils.getMonthFirstDay(endDayOfYesterday);
                dates = dealMonth(endDayOfYesterdayC, dates, endDayOfYesterday, endDayOfYesterday, monthFirstDay);
            } else {
                dates = dealMonth(curMonthBeginC, dates, thisTime, curMonthEnd, curMonthBegin);
            }
        }
        return dates;
    }
    /**
     * @method
     * @description 处理本月数据的时间
     * @date: 2019/4/30 0030 13:37
     * @author: mdengb
     * @param calendar,
     * @param dates 时间集合，
     * @param thisTime  对于月份交替时 取今天的 还是昨天的数据，记录哪天的数据
     * @param endTime 统计的结束时间
     * @param beginTime 统计的开始时间
     * @return
     */
    private Dates dealMonth(Calendar calendar,
                            Dates dates,
                            Date thisTime,
                            Date endTime,
                            Date beginTime) {
        int mon;
        String month;
        dates.setBeforeDate(beginTime);
        dates.setEndDate(endTime);
        dates.setThisTime(thisTime);
        mon = calendar.get(Calendar.MONTH) + 1;
        month = mon < 10 ? "0"+mon : mon+"";
        dates.setYearDate(calendar.get(Calendar.YEAR)+month);
        return dates;
    }

    /**
     * 时间类
     * */
    @Data
    private class Dates{
        /**
         * 统计的月份的结束是时间  xx 23:59:59
         * */
        Date endDate;
        /**
         * 统计的月份的开始是时间  xx 00:00:00
         * */
        Date beforeDate;
        /**
         * 年份 YYYYxx
         * */
        String yearDate;

        /**
         * 当前时间
         * */
        Date thisTime;
    }


    /**
     * @method
     * @description 部门 应用 人员的方法抽取
     * @date: 2019/4/28 0028 19:17
     * @author: mdengb
     * @param
     * @return
     */
    private WarnScaleStatistical dealObjectWarn(List<ObjectWarnCountDO> objectWarnCountDO,
												   WarnScaleStatistical warnScaleStatistical,
												   String objId
												   ){
        String avgHandleTime;
        String avgConfirmTime;
		for(ObjectWarnCountDO dto:objectWarnCountDO){
			if(StringUtils.isEmpty(dto.getObjectId())||StringUtils.isEmpty(dto.getObjectName())){
				continue;
			}
			if(objId.equals(dto.getObjectId())){
				warnScaleStatistical.setObjectName(dto.getObjectName());
				if("1".equals(dto.getTag())){
					//待确认
					warnScaleStatistical.setNewComeNum(dto.getCount()==null?0:dto.getCount());
				}
				if("2".equals(dto.getTag())){
					//已处理
					avgHandleTime = dto.getHandleCostTime()==null?"0.00":dto.getHandleCostTime();
                    warnScaleStatistical.setAvgHandleTime(avgHandleTime);
					warnScaleStatistical.setHandledNum(dto.getCount()==null?0:dto.getCount());
				}
				if("3".equals(dto.getTag())){
					//待处理
					warnScaleStatistical.setPendingNum(dto.getCount()==null?0:dto.getCount());
				}
				if("4".equals(dto.getTag())){
					//已确认
					avgConfirmTime = dto.getConfirmCostTime()==null?"0.00":dto.getConfirmCostTime();
                    warnScaleStatistical.setAvgConfirmTime(avgConfirmTime);
                    warnScaleStatistical.setConfirmNum(dto.getCount()==null?0:dto.getCount());
				}
			}
		}
    	return warnScaleStatistical;
	}

}
