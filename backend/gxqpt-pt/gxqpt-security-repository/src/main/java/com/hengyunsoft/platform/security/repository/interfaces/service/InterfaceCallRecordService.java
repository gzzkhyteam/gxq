package com.hengyunsoft.platform.security.repository.interfaces.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.interfaces.domain.InterCallMonthDO;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecordMain;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordExample;

import java.util.Date;
import java.util.List;

public interface InterfaceCallRecordService extends BaseService<Long,InterfaceCallRecord,InterfaceCallRecordExample> {
    /**
     * 查询前十二月接口调用数
     * @return
     */
    List<InterCallMonthDO> findInterCallMonthCount();

    /**
     * 查询接口调用列表
     * @param account
     * @param startTime
     * @param endTime
     * @param userName
     * @param appId
     * @return
     */
    List<InterfaceCallRecord> pageInterCallList(Integer account, Date startTime, Date endTime, String userName, String appId);

    /**
     * 分表插入数据
     * @param entity
     * @param mainEntity
     * @return
     */
    InterfaceCallRecord saveMain(InterfaceCallRecord entity, InterfaceCallRecordMain mainEntity);
}
