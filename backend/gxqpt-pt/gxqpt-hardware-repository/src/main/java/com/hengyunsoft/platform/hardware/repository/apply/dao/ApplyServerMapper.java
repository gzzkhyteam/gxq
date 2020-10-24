package com.hengyunsoft.platform.hardware.repository.apply.dao;

import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyServerDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyServerMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.apply.po.ApplyServer, com.hengyunsoft.platform.hardware.repository.apply.example.ApplyServerExample> {
    /**
     * 根据applyKeyId删除数据
     * @param id
     * @return
     */
    int deleteByApplyKeyId(@Param("applyKeyId") Long id);

    /**
     * 连查操作系统和网络
     * @param id
     * @return
     */
    ApplyServerDO getApplyServerById(Long id);

    List<ApplyServerDO> getApplyServerByApplyKeyId(Long id);
}