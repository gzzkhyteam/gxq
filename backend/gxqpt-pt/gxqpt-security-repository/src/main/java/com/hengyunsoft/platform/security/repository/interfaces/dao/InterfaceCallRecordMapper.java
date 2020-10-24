package com.hengyunsoft.platform.security.repository.interfaces.dao;

import com.hengyunsoft.platform.security.entity.interfaces.domain.InterCallMonthDO;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InterfaceCallRecordMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord, com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordExample> {
    List<InterCallMonthDO> findInterCallMonthCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<InterfaceCallRecord> pageInterCallList(@Param("account") Integer account, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("userName") String userName, @Param("appId") String appId);
}