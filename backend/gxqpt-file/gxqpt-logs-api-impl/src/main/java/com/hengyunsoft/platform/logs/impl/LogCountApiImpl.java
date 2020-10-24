package com.hengyunsoft.platform.logs.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.logs.dto.LogNumberAnalysisBaseDTO;
import com.hengyunsoft.platform.logs.dto.OrderEntity;
import com.hengyunsoft.platform.logs.entity.logs.po.LogCount;
import com.hengyunsoft.platform.logs.repository.logs.service.LogCountService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructAppService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "日志统计分析", description = "日志统计分析")
@RequestMapping("count")
public class LogCountApiImpl /*implements LogCountApi*/{
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private LogCountService logCountService;
    @Autowired
    private LogStructAppService logStructAppService;



    
    @ApiOperation(value = "用户登录数量统计", notes = "用户登录数量统计")
    @RequestMapping(value = "/userLoginQuantity", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getLoginQuantity(String startTime, String endTime, String applyId) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getLoginQuantity(getStartDate(startTime),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getLoginQuantity(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    
    @ApiOperation(value = "业务类型分类统计", notes = "业务类型分类统计")
    @RequestMapping(value = "/businessClassAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getBusinessClassAccount(String startTime, String endTime, String applyId) throws ParseException {
        List<LogCount> list = logCountService.getBusinessClassAccount(getStartDate(startTime),getEndDate(endTime),applyId);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "日志级别分类统计", notes = "日志级别分类统计")
    @RequestMapping(value = "/logLevelAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getLogLevelAccount(String startTime, String endTime, String applyId) throws ParseException {
        List<LogCount> list = logCountService.getLogLevelAccount(getStartDate(startTime),getEndDate(endTime),applyId);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "获取日志级别数量", notes = "获取日志级别数量")
    @RequestMapping(value = "/levelNumberAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getLevelNumberAccount(String startTime, String endTime, String applyId) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getLogLevelNum(getStartDate(startTime),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getLogLevelNum(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    private Date getStartDate(String startTime) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        return startDate;
    }
    private Date getEndDate(String endTime) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date endDate = format.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.MINUTE, 1);
        return calendar.getTime();
    }
    private String[] getTimeArray1(Date startTime, Date endTime,long m) {
        String[] strArry = new String[10];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        double a = m/(double)10;//分成10份
        double b = a*60*1000;//换算成毫秒
        long c = (long)b;
        long e = startTime.getTime();
        for(int i=0;i<10;i++){
            e=e+c;
            Date date = new Date(e);
            System.out.println(sdf.format(date));
            strArry[i]=sdf.format(date);
        }
        return strArry;
    }

    private String[] getTimeArray2(Date startTime, Date endTime,long m) {
        String[] strArry = new String[(int)m];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //double a = m/(double)10;//分成10份
        double b = 60*1000;//换算成毫秒
        long c = (long)b;
        long e = startTime.getTime();
        for(int i=0;i<m;i++){
            e=e+c;
            Date date = new Date(e);
            System.out.println(sdf.format(date));
            strArry[i]=sdf.format(date);
        }
        return strArry;
    }

    
    @ApiOperation(value = "获取日志类型数量占比", notes = "获取日志类型数量占比")
    @RequestMapping(value = "/numberAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getNumberAccount(String startTime, String endTime, String applyId) throws ParseException {
        List<LogCount> list = logCountService.getLogTypeNum(getStartDate(startTime),getEndDate(endTime),applyId);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "获取日志类型数量分析", notes = "获取日志类型数量分析")
    @RequestMapping(value = "/numberAnalysis", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getNumberAnalysis(String startTime, String endTime, String applyId) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getLogTypeNum(getStartDate(startTime),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getLogTypeNum(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    
    @ApiOperation(value = "获取日志类型响应时间", notes = "获取日志类型响应时间")
    @RequestMapping(value = "/logResponseTime", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getResponseTime(String startTime, String endTime, String applyId, String logType) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getResponseTime(getStartDate(startTime),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getResponseTime(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    
    @ApiOperation(value = "获取不同等级告警数量", notes = "获取不同等级告警数量")
    @RequestMapping(value = "/warnLevelNumber", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelNumber(String startTime, String endTime, String applyId) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getWarnLevelNumber(getStartDate(startTime),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getWarnLevelNumber(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    
    @ApiOperation(value = "获取告警数量占比", notes = "获取告警数量占比")
    @RequestMapping(value = "/warnLevelAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelAccount(String startTime, String endTime, String applyId) throws ParseException {
        List<LogCount> list = logCountService.getWarnLevelNumber(getStartDate(startTime),getEndDate(endTime),applyId);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "告警类型数量统计", notes = "告警类型数量统计")
    @RequestMapping(value = "/warnTypeNumber", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeNumber(String startTime, String endTime, String applyId, String logType) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getWarnTypeNumber(getStartDate(startTime),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getWarnTypeNumber(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }

    
    @ApiOperation(value = "告警类型数量占比", notes = "告警类型数量占比")
    @RequestMapping(value = "/warnTypeAccount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeAccount(String startTime, String endTime, String applyId) throws ParseException {
        List<LogCount> list = logCountService.getWarnTypeAccount(getStartDate(startTime),getEndDate(endTime),applyId);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "热门页面访问次数", notes = "热门页面访问次数")
    @RequestMapping(value = "/PageAccess", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getPageAccess(String startTime, String endTime, String applyId,String logType) throws ParseException {
        List<LogCount> list = logCountService.getPageAccess(getStartDate(startTime),getEndDate(endTime),applyId,logType);
        if(list.size()>0){
            List<OrderEntity> orderEntityList = new ArrayList<OrderEntity>();
            for(int i=0;i<list.size();i++){
                int number = Integer.parseInt(list.get(i).getNumber());
                String name = list.get(i).getLogTypeName();
                orderEntityList.add(new OrderEntity(number,name));
            }
            orderEntityList.sort(Comparator.naturalOrder());
            list = new ArrayList<>();
            for(int i=0;i<orderEntityList.size();i++){
                String number = String.valueOf(orderEntityList.get(i).getNumber());
                String name = orderEntityList.get(i).getName();
                LogCount logCount = new LogCount();
                logCount.setNumber(number);
                logCount.setLogTypeName(name);
                list.add(logCount);
            }
        }

        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "HTTP状态数量", notes = "HTTP状态数量")
    @RequestMapping(value = "/HttpStatus", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getHttpStatus(String startTime, String endTime, String applyId,String logType) throws ParseException {
        List<LogCount> list = logCountService.getHttpStatus(getStartDate(startTime),getEndDate(endTime),applyId,logType);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "浏览器类型占比", notes = "浏览器类型占比")
    @RequestMapping(value = "/BrowserType", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getBrowserType(String startTime, String endTime, String applyId,String logType) throws ParseException {
        List<LogCount> list = logCountService.getBrowserType(getStartDate(startTime),getEndDate(endTime),applyId,logType);
        List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(list,LogNumberAnalysisBaseDTO.class);
        return Result.success(pageList);
    }

    
    @ApiOperation(value = "访问PV/UV统计", notes = "访问PV/UV统计")
    @RequestMapping(value = "/PvToUvCount", method = RequestMethod.POST)
    public Result<List<LogNumberAnalysisBaseDTO>> getPvToUvCount(String startTime, String endTime, String applyId,String logType) throws ParseException {
        List list = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        String[] timeArray=new String[]{};//定义一个存储时间变量的数组
        if(startTime.equals(endTime)){
            timeArray[0]=startTime;//开始时间等于结束时间，只显示一个时间
        }else{
            long s = (endDate.getTime()-startDate.getTime())/1000;//把相差时间转换成秒
            long m = s/60;//分钟
            if(m>=10){
                timeArray= getTimeArray1(startDate,endDate,m);//根据开始结束时间，平分时间段，分成10份
            }else if(m>0){
                timeArray= getTimeArray2(startDate,endDate,m);//小于10分钟的，间隔按分钟个数显示
            }
        }
        //根据时间循环获取
        for(int i=0;i<timeArray.length;i++){
            if(i==0){
                List<LogCount> countList = logCountService.getPvToUvCount(getStartDate(startTime),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }else{
                List<LogCount> countList = logCountService.getPvToUvCount(getStartDate(timeArray[i-1]),getEndDate(timeArray[i]),applyId,logType);
                List<LogNumberAnalysisBaseDTO> pageList = dozerUtils.mapPage(countList,LogNumberAnalysisBaseDTO.class);
                for(LogNumberAnalysisBaseDTO dto:pageList){
                    dto.setTime(timeArray[i]);
                }
                list.add(pageList);
            }

        }
        return Result.success(list);
    }


}
