package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.core.domain.ModuleUseRankDO;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseSumTotalNumDO;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseDayDataDO;
import com.hengyunsoft.platform.developer.repository.core.dao.ModuleUseInfoMapper;
import com.hengyunsoft.platform.developer.repository.core.example.ModuleUseInfoExample;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 描述:开发者调用日志ervice实现
 * @author sunxiaoya
 * @date 2018/4/18
 */
@Service
@Slf4j
public class ModuleUseJnlServiceImpl extends BaseAllServiceImpl<Long, ModuleUseInfo, ModuleUseInfoExample> implements ModuleUseJnlService {
    @Autowired
    private ModuleUseInfoMapper mapper;
    @Override
    protected BaseNormalDao<Long, ModuleUseInfo, ModuleUseInfoExample> getDao() {
        return mapper;
    }

    @Override
    public void saveLog(ModuleUseInfo info) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        String year =getYear(cal);
        String month =getMonth(cal);
        String day =getDay(cal);
        String hour =getHour(cal);
        info.setCombineId(year+"_"+month+"_"+day+"_"+hour+"_"+info.getAppId()+"_"+info.getModuleId());//
        info.setId(date.getTime());
        info.setUpdateTime(date);
        info.setUseYear(year);
        info.setUseMonth(year+"-"+month);
        info.setUseDay(year+"-"+month+"-"+day);
        hour = Integer.parseInt(hour)<10?"0"+hour+":00":hour+":00";
        info.setUseHour(year+"-"+month+"-"+day+" "+hour);
        info.setUseWeekend(year+"第"+getWeekEnd(cal)+"周");
        info.setUseQuarter(year+"第"+getQuarter(cal)+"季度");
        mapper.saveLog(info);
    }

    @Override
    public List<ModuleUseInfo> getJnl(String appId, String moduleId, String startTime, String endTime, String timeScale) {

        List<ModuleUseInfo> list = null;
        if(timeScale.equals("year")){
            list = mapper.getJnlByYear(appId,moduleId,startTime,endTime);
        }
        if(timeScale.equals("month")){
            list = mapper.getJnlByMonth(appId,moduleId,startTime,endTime);
        }
        if(timeScale.equals("day")){
            list = mapper.getJnlByDay(appId,moduleId,startTime,endTime);
        }
        if(timeScale.equals("hour")){
            list = mapper.getJnlByHour(appId,moduleId,startTime,endTime);
        }
        if(timeScale.equals("weekend")){
            list = mapper.getJnlByWeekEnd(appId,moduleId,startTime,endTime);
        }
        if("quarter".equals(timeScale)){
            list = mapper.getJnlByQuarter(appId,moduleId,startTime,endTime);
        }
        return list;
    }

    /**
     * 获取模块调用总量
     * @return
     */
    @Override
    public ModuleUseSumTotalNumDO getSumTotalNum() {
       return mapper.getSumTotalNum();
    }

    /**
     * 获取全天模块调用总量
     * @return
     */
    @Override
    public List<ModuleUseDayDataDO> findDayData() {
        Calendar instance = Calendar.getInstance();
        Date nDate = instance.getTime();
        long time1 = nDate.getTime();
         time1=time1+3600000;
        Date nowDate = new Date(time1);
        Date date = new Date( instance.getTimeInMillis()-(3600000*23));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH");
        String pre = sf.format(date);
        String later = sf.format(nowDate);
        List<ModuleUseDayDataDO> dayData = mapper.findDayData(pre, later);
        for (int i=0;i<24;i++){
            long time = date.getTime();
            time=time+i*3600000;
            Calendar instance1 = Calendar.getInstance();
            instance1.setTimeInMillis(time);
            Date date1 = instance1.getTime();
            String format1 = sf.format(date1);
            int j=0;
            for (ModuleUseDayDataDO mdd:dayData){
                String format = sf.format(mdd.getUseDay());
                if (format.equals(format1) && mdd.getNowDayHour()==instance1.get(Calendar.HOUR_OF_DAY)){
                    j=1;
                }
            }
            if (j!=1){
                ModuleUseDayDataDO mdd=new ModuleUseDayDataDO();
                mdd.setNowDayHour(instance1.get(Calendar.HOUR_OF_DAY));
                mdd.setSumTotalNum(0);
                mdd.setUseDay(date1);
                dayData.add(mdd);
            }
        }
        dayData.sort(new Comparator<ModuleUseDayDataDO>() {
            @Override
            public int compare(ModuleUseDayDataDO o1, ModuleUseDayDataDO o2) {
                return (int)(o1.getUseDay().getTime()-o2.getUseDay().getTime());
            }
        });
        return dayData;
    }

    //根据当前日历获取年份
    private String getYear(Calendar cal){
        return String.valueOf(cal.get(Calendar.YEAR));
    }

    //根据当前日历获取月份
    private String getMonth(Calendar cal){
        return String.valueOf(cal.get(Calendar.MONTH)+1);
    }

    //根据当前日历获取日
    private String getDay(Calendar cal){
        return String.valueOf(cal.get(Calendar.DATE));
    }

    //根据当前日历获取小时
    private String getHour(Calendar cal){
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
    }

    //根据当前日历获取当前第几周
    private String getWeekEnd(Calendar cal){
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(new Date());
        return String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
    }

    //根据当前日历获取当前第几季度
    private String getQuarter(Calendar cal){
        String month = getMonth(cal);
        if(month.equals("1")||month.equals("2")||month.equals("3")){
             return "1";
        }
        if(month.equals("4")||month.equals("5")||month.equals("6")){
            return "2";
        }
        if(month.equals("7")||month.equals("8")||month.equals("9")){
            return "3";
        }
        if(month.equals("10")||month.equals("11")||month.equals("12")){
            return "4";
        }
        return "0";
    }

    /**
     * 大屏 查询当天模块使用次数
     * @param nDay
     * @param nextDay1
     * @return
     */
    @Override
    public int getDayUserModuleCount(String nDay, String nextDay1) {
        return mapper.getDayUserModuleCount(nDay,nextDay1);
    }

    /**
     * 获取接口调用排行榜
     * @return
     */
    @Override
    public List<ModuleUseRankDO> getModuleUseRank() {
        return mapper.getModuleUseRank();
    }
}