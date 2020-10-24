package com.hengyunsoft.platform.security.repository.interfaces.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.interfaces.domain.InterCallMonthDO;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecordMain;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceCallRecordMainMapper;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceCallRecordMapper;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordExample;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordMainExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceCallRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class InterfaceCallRecordServiceImpl extends BaseServiceImpl<Long,InterfaceCallRecord,InterfaceCallRecordExample> implements InterfaceCallRecordService {

    @Autowired
    private InterfaceCallRecordMapper interfaceCallRecordMapper;
    @Autowired
    private InterfaceCallRecordMainMapper interfaceCallRecordMainMapper;

    @Override
    protected BaseNormalDao<Long, InterfaceCallRecord, InterfaceCallRecordExample> getDao() {
        return interfaceCallRecordMapper;
    }
    protected BaseNormalDao<Long, InterfaceCallRecordMain, InterfaceCallRecordMainExample> getMainDao(){
        return interfaceCallRecordMainMapper;
    }

    /**
     * 查询前十二月接口调用数
     * @return
     */
    @Override
    public List<InterCallMonthDO> findInterCallMonthCount() {
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
        String endTime = sb.toString();
        List<InterCallMonthDO> list=interfaceCallRecordMapper.findInterCallMonthCount(startTime,endTime);
        List<InterCallMonthDO> interCallMonthDOS = sortLog("operate",list);
        sortList(interCallMonthDOS);
        return  interCallMonthDOS;
    }

    /**
     * 查询接口调用列表
     * @param account
     * @param startTime
     * @param endTime
     * @param userName
     * @param appId
     * @return
     */
    @Override
    public List<InterfaceCallRecord> pageInterCallList(Integer account, Date startTime, Date endTime, String userName, String appId) {
        List<InterfaceCallRecord> interfaceCallRecords = interfaceCallRecordMapper.pageInterCallList(account,startTime, endTime, userName, appId);
        return interfaceCallRecords;

    }

    /**
     * 公共排序
     * @param list
     */
    public void sortList(List list){
        list.sort(new Comparator<InterCallMonthDO>() {
            @Override
            public int compare(InterCallMonthDO o1, InterCallMonthDO o2) {
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
     * 统计公共方法
     *
     * @param logType
     * @param list
     * @return
     */
    public List<InterCallMonthDO> sortLog(String logType, List<InterCallMonthDO> list) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sf.format(date);
        String[] split = startTime.split("-");
        Integer month = Integer.parseInt(split[1]);
        Integer year = Integer.parseInt(split[0]);

        while(list.size()<12){
            Iterator<InterCallMonthDO> iterator = list.iterator();
            Boolean s=false;
            while (iterator.hasNext()) {
                InterCallMonthDO next = iterator.next();
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
                InterCallMonthDO logTypeDO = new InterCallMonthDO();
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

    public InterfaceCallRecord saveMain(InterfaceCallRecord entity, InterfaceCallRecordMain mainEntity) {
        if (entity == null || mainEntity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        //子表数据插入
        setSaveTimes(entity);
        entity.setId(genId());
        getDao().insert(entity);
        //主表数据插入
        mainEntity.setCreateTime(entity.getCreateTime());
        mainEntity.setId(entity.getId());
        mainEntity.setConsumerAppId(entity.getCallerAppId());
        
        getMainDao().insert(mainEntity);
        
        return entity;
    }
}
