package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogLevelMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogMonthErrorDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogSortDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogStructAppMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogStructAppServiceImpl  extends BaseAllServiceImpl<Long, LogStructApp, LogStructAppExample> implements LogStructAppService {
    @Autowired
    private LogStructAppMapper logStructAppMapper;
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogStructApp, LogStructAppExample> getDao() {
        return logStructAppMapper;
    }

    @Override
    public List<LogStructApp> pageQueryApp(LogStructAppExample example) {
        return logStructAppMapper.pageQueryApp(example);
    }

    @Override
    public List<LogStructApp> pageQueryWarningApp(Long id) {
        return logStructAppMapper.pageQueryWarningApp(id);
    }

    @Override
    public int deleteByDocumentIds(LogStructAppExample example,String conditions) {
        int i=logStructAppMapper.deleteByDocumentIds(example);
        if(i>0){
            LogOpenDelete logOpenDelete = new LogOpenDelete();
            Long simple=System.currentTimeMillis();
            logOpenDelete.setId(simple);
            logOpenDelete.setAppId(BaseContextHandler.getAppId());
            logOpenDelete.setIp("");
            logOpenDelete.setCallServeTime(Calendar.getInstance().getTime());
            logOpenDelete.setDeleteCondition(conditions);
            logOpenDelete.setDeleteCount((long) i);
            logOpenDelete.setCreateTime(Calendar.getInstance().getTime());
            logOpenDelete.setCreateUser(BaseContextHandler.getAdminId());
            logOpenDelete.setCreateUserName(BaseContextHandler.getName());
            logOpenDeleteMapper.insert(logOpenDelete);//保存删除的文件接口数据
        }
        return i;
    }

    /**
     * 统计当前月error数量
     * @return
     */
    @Override
    public int currentCount() {
       return logStructAppMapper.currentCount();
    }

    /**
     * 统计每月error数量
     * @return
     */
    @Override
    public List<LogMonthErrorDO> findErrorLogMonthCount() {
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
        List<LogMonthErrorDO> list = logStructAppMapper.findErrorLogMonthCount(startTime, endTime);
        Integer month = Integer.parseInt(split[1]);
        Integer year = Integer.parseInt(split[0]);
        while(list.size()<12){
            Iterator<LogMonthErrorDO> iterator = list.iterator();
            Boolean s=false;
            while (iterator.hasNext()) {
                String s1 = iterator.next().getMonth().toString();
                if (s1.equals(month.toString()) ) {
                    s=true;
                    break;
                } else {
                    s=false;
                }
            }
            if(!s.booleanValue()){
                LogMonthErrorDO logTypeDO = new LogMonthErrorDO();
                logTypeDO.setMonth(month);
                logTypeDO.setYear(year);
                logTypeDO.setCount(0);
                list.add(logTypeDO);
            }

            if ("1".equals(month.toString())) {
                month = 13;
                year = year - 1;
            }
            month = month - 1;
        }
        list.sort(new Comparator<LogMonthErrorDO>() {
            @Override
            public int compare(LogMonthErrorDO o1, LogMonthErrorDO o2) {
                int x=o1.getYear()-o2.getYear();
                int y=o1.getMonth()-o2.getMonth();
                if(x==0){
                    return y;
                }
                return x;
            }
        });
        return list;
    }

    /**
     * 统计前十二月数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogTypeDO> findMonthCount(String startTime, String endTime) {
      return   logStructAppMapper.findMonthCount(startTime,endTime);
    }

    /**
     * 日志分类数量
     * @return
     */
    @Override
    public List<LogSortDO> findLogSortCount() {
        List<LogSortDO> logSortCount = logStructAppMapper.findLogSortCount();
        List<String> list=new ArrayList<>();
        list.add("ERROR");
        list.add("DEBUG");
        list.add("INFO");
        list.add("FAILED");
        list.add("WARN");
        for(LogSortDO ls:logSortCount){
           list.remove(ls.getLevel());
        }
        for(String s:list){
            LogSortDO ls=new LogSortDO();
           ls.setLevel(s);
           ls.setCount(0);
            logSortCount.add(ls);
        }

        return logSortCount;
    }

    /**
     * 查询前12月日志级别数量
     * @return
     */
    @Override
    public List<List<LogLevelMonthDO>> findLogLevelMonthCount() {
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
      List<LogLevelMonthDO> list= logStructAppMapper.findLogLevelMonthCount(startTime,endTime);
      List<LogLevelMonthDO> error=new ArrayList<>();
      List<LogLevelMonthDO> info=new ArrayList<>();
      List<LogLevelMonthDO> failed=new ArrayList<>();
      List<LogLevelMonthDO> warn=new ArrayList<>();
      List<LogLevelMonthDO> debug=new ArrayList<>();
      for(LogLevelMonthDO lm:list){
         if("ERROR".equals(lm.getLevel())){
             error.add(lm);
         }else if("DEBUG".equals(lm.getLevel())){
             debug.add(lm);
         }else if("INFO".equals(lm.getLevel())){
             info.add(lm);
         }else if("FAILED".equals(lm.getLevel())){
             failed.add(lm);
         }else if("WARN".equals(lm.getLevel())){
             warn.add(lm);
         }
      }
        List<LogLevelMonthDO> error1 = sortLog("error", error);
        sortList(error1);
        List<LogLevelMonthDO> debug1 = sortLog("debug", debug);
        sortList(debug);
        List<LogLevelMonthDO> info1 = sortLog("info", info);
        sortList(info1);
        List<LogLevelMonthDO> failed1 = sortLog("failed", failed);
        sortList(failed1);
        List<LogLevelMonthDO> warn1 = sortLog("warn", warn);
        sortList(warn1);
      List<List<LogLevelMonthDO>> map=new ArrayList<>();
      for(int c=0;c<12;c++){
          List<LogLevelMonthDO> listType=new ArrayList<>();
          listType.add(error1.get(c));
          listType.add(debug1.get(c));
          listType.add(info1.get(c));
          listType.add(failed1.get(c));
          listType.add(warn1.get(c));
          map.add(listType);
      }
     return map;
    }

    /**
     * 公共排序
     * @param list
     */
    public void sortList(List list){
        list.sort(new Comparator<LogLevelMonthDO>() {
            @Override
            public int compare(LogLevelMonthDO o1, LogLevelMonthDO o2) {
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
    public List<LogLevelMonthDO> sortLog(String logType, List<LogLevelMonthDO> list) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer month = Integer.parseInt(split[1]);
        Integer year = Integer.parseInt(split[0]);

        while(list.size()<12){
            Iterator<LogLevelMonthDO> iterator = list.iterator();
            Boolean s=false;
            while (iterator.hasNext()) {
                LogLevelMonthDO next = iterator.next();
                next.setLevel(logType);
                String s1 = next.getMonth().toString();
                if (s1.equals(month.toString()) ) {
                    s=true;
                    break;
                } else {
                    s=false;
                }
            }
            if(!s.booleanValue()){
                LogLevelMonthDO logTypeDO = new LogLevelMonthDO();
                logTypeDO.setMonth(month);
                logTypeDO.setYear(year);
                logTypeDO.setCount(0);
                logTypeDO.setLevel(logType);
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
}
