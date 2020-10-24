package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRecycleMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.file.entity.file.po.FileRecycle, com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample> {
    /**
     * 删除回收站数据
     * @param appId
     * @param ids
     * @return
     */
    int removeFileRecycleByAppIdAndId(@Param("appId") String appId, @Param("adminId")Long adminId, @Param("id")Long id);

    /**
     * 清空回收站
     * @param appId
     * @param adminId
     * @return
     */
    int cleanAll(@Param("appId") String appId,  @Param("adminId")Long adminId);

    /**
     * 获取永久回收数据
     * @param isOneLevelDelete
     * @return
     */
    List<FileRecycle> getForeverRecycle(@Param("isOneLevelDelete") Boolean isOneLevelDelete);

    /**
     * 永久回收数据
     * @param
     * @return
     */
    void foreverRecycle(@Param("id") Long id);
}