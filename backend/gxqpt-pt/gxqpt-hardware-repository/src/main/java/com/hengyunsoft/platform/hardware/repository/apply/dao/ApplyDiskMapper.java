package com.hengyunsoft.platform.hardware.repository.apply.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyDiskMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.apply.po.ApplyDisk, com.hengyunsoft.platform.hardware.repository.apply.example.ApplyDiskExample> {
    /**
     * 根据服务id删除磁盘
     * @param id
     * @return
     */
    int deleteByServerKeyId(@Param("serverKeyId") Long id);
}