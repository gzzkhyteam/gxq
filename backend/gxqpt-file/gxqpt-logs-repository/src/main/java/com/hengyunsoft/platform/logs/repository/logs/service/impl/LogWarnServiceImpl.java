package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.domain.*;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarning;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogWarningMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarningExample;
import com.hengyunsoft.platform.logs.repository.logs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogWarnServiceImpl extends BaseAllServiceImpl<Long, LogWarning, LogWarningExample> implements LogWarnService,Serializable {
    @Autowired
    private LogWarningMapper logWarningMapper;
    @Autowired
    private LogStructAppService logStructAppService;
    @Autowired
    private LogStructApacheService logStructApacheService;
    @Autowired
    private LogStructTomcatService logStructTomcatService;
    @Autowired
    private LogStructNginxService logStructNginxService;
    @Override
    protected BaseNormalDao<Long, LogWarning, LogWarningExample> getDao() {
        return logWarningMapper;
    }

    @Override
    public List<LogWarningDO> pageQueryWarning(LogWarningExample example) {
        return logWarningMapper.pageQueryWarning(example);
    }

    /**
     * 统计当前月告警数
     *
     * @return
     */
    @Override
    public Integer currentWarnCount() {
        return logWarningMapper.currentWarnCount();
    }

    /**
     * 统计当前月告警数
     *
     * @return
     */
    @Override
    public Integer currentWarnDealCount() {
        return logWarningMapper.currentWarnDealCount();
    }

    /**
     * 统计日志类型数量
     *
     * @return
     */
    @Override
    public  Map<String ,List<LogTypeDO>> findLogTypeCount() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer i = Integer.parseInt(split[0]);
        Integer j = i - 1;
        Integer i1 = Integer.parseInt(split[1]);
        Integer k = null;
        if (i1.equals(12)) {
            k = 1;
        } else {
            k = i1 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("-");
        sb.append(k);
        sb.append("-");
        sb.append("01");
        sb.append(" 00:00:00");
        String endTime = sb.toString();
        List<LogTypeDO>  apache= logStructApacheService.findMonthCount(startTime,endTime);
        List<LogTypeDO>  app=  logStructAppService.findMonthCount(startTime,endTime);
        List<LogTypeDO>  nginx=  logStructNginxService.findMonthCount(startTime,endTime);
        List<LogTypeDO>  tomcat= logStructTomcatService.findMonthCount(startTime,endTime);
        List<LogTypeDO> apache1 = sortLog("APACHE", apache);
        List<LogTypeDO> app1 = sortLog("APP", app);
        List<LogTypeDO> nginx1 = sortLog("NGINX", nginx);
        List<LogTypeDO> tomcat1 = sortLog("TOMCAT", tomcat);
        sortList(apache1);
        sortList(app1);
        sortList(nginx1);
        sortList(tomcat1);
        Map<String ,List<LogTypeDO>> map=new HashMap<>();
        map.put("apache",apache1);
        map.put("app",app1);
        map.put("nginx",nginx1);
        map.put("tomcat",tomcat1);
        return map;
    }
    /**
     * 查新告警前12月数量
     * @return
     */
    @Override
    public List<LogTypeDO> findWarnCount() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer i = Integer.parseInt(split[0]);
        Integer j = i - 1;
        Integer i1 = Integer.parseInt(split[1]);
        Integer k = null;
        if (i1.equals(12)) {
            k = 1;
        } else {
            k = i1 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("-");
        sb.append(k);
        sb.append("-");
        sb.append("01");
        sb.append(" 00:00:00");
        String endTime = sb.toString();
        List<LogTypeDO> warnCount = logWarningMapper.findWarnCount(startTime, endTime);
        List<LogTypeDO> logTypeDOS = sortLog("", warnCount);
        sortList(logTypeDOS);
        return logTypeDOS;
    }

    /**
     * 统计日志应用
     * @return
     */
    @Override
    public List<LogAppNameDO> findWarnAppName() {
       return logWarningMapper.logWarningMapper();
    }

    /**
     * 查询告警处理平均时间
     * @return
     */
    @Override
    public LogWarnAvgTimeDO findWarnAvgTime() {
       return logWarningMapper.findWarnAvgTime();
    }

    /**
     * 查询日志前十二月每月总数
     * @return
     */
    @Override
    public List<LogTypeDO> findLogAvgMonth() {
        List<LogTypeDO> list=new ArrayList<>();
        Map<String, List<LogTypeDO>> logTypeCount = findLogTypeCount();
        List<LogTypeDO> apache = logTypeCount.get("apache");
        List<LogTypeDO> app = logTypeCount.get("app");
        List<LogTypeDO> nginx = logTypeCount.get("nginx");
        List<LogTypeDO> tomcat = logTypeCount.get("tomcat");
        for(int i=0;i<12;i++){
            LogTypeDO ld=new LogTypeDO();
            ld.setYear(apache.get(i).getYear());
            ld.setMonth(apache.get(i).getMonth());
            Integer count=apache.get(i).getCount()+app.get(i).getCount()+nginx.get(i).getCount()+tomcat.get(i).getCount();
            ld.setCount(count);
            list.add(ld);
        }
        return list;
    }

    /**
     * 查询前十二月日志响应时间
     * @return
     */
    @Override
    public List<LogRespondMonthDO> findLogRespondMonth() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer i = Integer.parseInt(split[0]);
        Integer j = i - 1;
        Integer i1 = Integer.parseInt(split[1]);
        Integer k = null;
        if (i1.equals(12)) {
            k = 1;
        } else {
            k = i1 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("-");
        sb.append(k);
        sb.append("-");
        sb.append("01");
        sb.append(" 00:00:00");
        String endTime = sb.toString();
        List<LogRespondMonthDO> apache= logStructApacheService.findLogRespondMonth(startTime,endTime);
        List<LogRespondMonthDO> tomcat =logStructTomcatService.findLogRespondMonth(startTime,endTime);
        List<LogRespondMonthDO> nginx=logStructNginxService.findLogRespondMonth(startTime,endTime);
        List<LogRespondMonthDO> apache1 = sortLog(apache);
        List<LogRespondMonthDO> nginx1 = sortLog(nginx);
        List<LogRespondMonthDO> tomcat1 = sortLog(tomcat);
        sortRsepondList(apache1);
        sortRsepondList(nginx1);
        sortRsepondList(tomcat1);
        List<LogRespondMonthDO> list=new ArrayList<>();
        for (int r=0;r<12;r++){
            LogRespondMonthDO lr =new LogRespondMonthDO();
            lr.setMonth(apache1.get(r).getMonth());
            lr.setYear(apache1.get(r).getYear());
            lr.setRespondTime(apache1.get(r).getRespondTime()+nginx1.get(r).getRespondTime()+tomcat1.get(r).getRespondTime());
            list.add(lr);
        }
        return list;

    }

    /**
     * 查询前十二月告警数量等级统计
     * @return
     */
    @Override
    public  List< List<LogTypeDO>> findLogWarnMonth() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer i = Integer.parseInt(split[0]);
        Integer j = i - 1;
        Integer i1 = Integer.parseInt(split[1]);
        Integer k = null;
        if (i1.equals(12)) {
            k = 1;
        } else {
            k = i1 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("-");
        sb.append(k);
        sb.append("-");
        sb.append("01");
        sb.append(" 00:00:00");
        String endTime = sb.toString();
        List<LogTypeDO> list=  logWarningMapper.findLogWarnMonth(startTime,endTime);
        List<LogTypeDO> warn1=new ArrayList<>();
        List<LogTypeDO> warn2 =new ArrayList<>();
        List<LogTypeDO> warn3=new ArrayList<>();
        for (LogTypeDO lt:list){
            if("1".equals(lt.getLogType())){
                warn1.add(lt);
            }else if("2".equals(lt.getLogType())){
                warn2.add(lt);
            }else if("3".equals(lt.getLogType())){
                warn3.add(lt);
            }
        }
        List<LogTypeDO> w1 = sortLog("一级", warn1);
        sortList(w1);
        List<LogTypeDO> w2 = sortLog("二级", warn2);
        sortList(w2);
        List<LogTypeDO> w3 = sortLog("三级", warn3);
        sortList(w3);
        List< List<LogTypeDO>> listWarn=new ArrayList<>();
        for (int w=0;w<12;w++){
            List<LogTypeDO> ld=new ArrayList<>();
            ld.add(w1.get(w));
            ld.add(w2.get(w));
            ld.add(w3.get(w));
            listWarn.add(ld);
        }
return listWarn;
    }

    /**
     * 查询告警数量类型统计
     * @return
     */
    @Override
    public List<LogTypeDO> findLogWarnTypeMonth() {
        List<LogTypeDO> logWarnTypeMonth = logWarningMapper.findLogWarnTypeMonth();
        boolean key=true;
        boolean qua=true;
        boolean res=true;
        for(LogTypeDO ld:logWarnTypeMonth){
            if("KEY".equals(ld.getLogType())){
                ld.setLogType("关键字告警");
                key=false;
            }else if("QUANTITY".equals(ld.getLogType())){
                ld.setLogType("数量告警");
                qua=false;
            }else if("RESPONSE".equals(ld.getLogType())){
                ld.setLogType("响应时长告警");
                res=false;
            }
        }
        if(key){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("关键字告警");
            lt.setCount(0);
            logWarnTypeMonth.add(lt);
        }
        if(qua){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("数量告警");
            lt.setCount(0);
            logWarnTypeMonth.add(lt);
        }
        if (res){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("响应时长告警");
            lt.setCount(0);
            logWarnTypeMonth.add(lt);
        }
        return logWarnTypeMonth;
    }

    /**
     * 统计告警类型数量
     * @return
     */
    @Override
    public List<LogTypeDO> findLogWarnLevleCount() {
        List<LogTypeDO> logWarnLevleCount = logWarningMapper.findLogWarnLevleCount();
        boolean one=true;
        boolean two=true;
        boolean three=true;
        for(LogTypeDO ld:logWarnLevleCount){
            if("1".equals(ld.getLogType())){
                ld.setLogType("一级");
                one=false;
            }else if("2".equals(ld.getLogType())){
                ld.setLogType("二级");
                two=false;
            }else if("3".equals(ld.getLogType())){
                ld.setLogType("三级");
                three=false;
            }
        }
        if(one){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("一级");
            lt.setCount(0);
            logWarnLevleCount.add(lt);
        }
        if(two){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("二级");
            lt.setCount(0);
            logWarnLevleCount.add(lt);
        }
        if (three){
            LogTypeDO lt=new LogTypeDO();
            lt.setLogType("三级");
            lt.setCount(0);
            logWarnLevleCount.add(lt);
        }
        return logWarnLevleCount;
    }

    /**
     * 公共排序
     * @param list
     */
    public void sortList(List<LogTypeDO> list){
        list.sort(new Comparator<LogTypeDO>() {
            @Override
            public int compare(LogTypeDO o1, LogTypeDO o2) {
                int x=o1.getYear()-o2.getYear();
                int y=o1.getMonth()-o2.getMonth();
                if(x==0){
                    return y;
                }
                return x;
            }
        });
}
    /**
     * 统计日志类型数量的公共方法
     *
     * @param logType
     * @param list
     * @return
     */
    public List<LogTypeDO> sortLog(String logType, List<LogTypeDO> list) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
            Integer month = Integer.parseInt(split[1]);
            Integer year = Integer.parseInt(split[0]);

           while(list.size()<12){
               Iterator<LogTypeDO> iterator = list.iterator();
            Boolean s=false;
            while (iterator.hasNext()) {
                LogTypeDO next = iterator.next();
                next.setLogType(logType);
                String s1 = next.getMonth().toString();
                if (s1.equals(month.toString()) ) {
                    s=true;
                    break;
                } else {
                    s=false;
                }
            }
            if(!s.booleanValue()){
                  LogTypeDO logTypeDO = new LogTypeDO();
                    logTypeDO.setMonth(month);
                    logTypeDO.setYear(year);
                    logTypeDO.setCount(0);
                    logTypeDO.setLogType(logType);
                    list.add(logTypeDO);
            }

                if ("1".equals(month.toString())) {
                    month = 13;
                    year = year - 1;
                }
                month = month - 1;
            }
        return list;
    }
    /**
     * 统计日志响应时间公共方法
     *
     * @param
     * @param list
     * @return
     */
    public List<LogRespondMonthDO> sortLog( List<LogRespondMonthDO> list) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer month = Integer.parseInt(split[1]);
        Integer year = Integer.parseInt(split[0]);

        while(list.size()<12){
            Iterator<LogRespondMonthDO> iterator = list.iterator();
            Boolean s=false;
            while (iterator.hasNext()) {
                LogRespondMonthDO next = iterator.next();
                if(next.getRespondTime()==null) {
                    next.setRespondTime(0);
                }
                String s1 = next.getMonth().toString();
                if (s1.equals(month.toString()) ) {
                    s=true;
                    break;
                } else {
                    s=false;
                }
            }
            if(!s.booleanValue()){
                LogRespondMonthDO logTypeDO = new LogRespondMonthDO();
                logTypeDO.setMonth(month);
                logTypeDO.setYear(year);
                logTypeDO.setRespondTime(0);
                list.add(logTypeDO);
            }

            if ("1".equals(month.toString())) {
                month = 13;
                year = year - 1;
            }
            month = month - 1;
        }
        return list;
    }
    /**
     * 日志响应时间公共排序
     * @param list
     */
    public void sortRsepondList(List<LogRespondMonthDO> list) {
        list.sort(new Comparator<LogRespondMonthDO>() {
            @Override
            public int compare(LogRespondMonthDO o1, LogRespondMonthDO o2) {
                int x = o1.getYear() - o2.getYear();
                int y = o1.getMonth() - o2.getMonth();
                if (x == 0) {
                    return y;
                }
                return x;
            }
        });
    }
}