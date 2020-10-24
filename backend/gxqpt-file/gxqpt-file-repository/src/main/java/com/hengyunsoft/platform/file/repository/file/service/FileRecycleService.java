package com.hengyunsoft.platform.file.repository.file.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 文件回收站
 */
public interface FileRecycleService extends BaseAllService<Long, FileRecycle, FileRecycleExample> {
    /**
     * 回收站删除数据，并删除文件表相关记录，支持一个或者多个删除，及文件夹删除
     * @param appId
     * @param adminId
     * @param ids
     * @return
     */
    int removeFileRecycleByAppIdAndIds(String appId, Long adminId, Long[] ids);

    /**
     * 清空回收站
     * @param appId
     * @param admin_id
     * @return
     */
    int cleanAll(String appId, Long admin_id);

    /**
     * 保存数据不使用自动生成主键
     * @param relist
     * @return
     */
    int saveNoAutoGenId(List<FileRecycle> relist);

    /**
     * 保存数据不使用自动生成主键
     * @param
     * @return
     */
    int saveNoAutoGenId(FileRecycle refile);

    /**
     * 还原回收站数据
     * @param appId
     * @param adminId
     * @param ids
     * @return
     */
    int updateRecycle(String appId, Long adminId, Long[] ids);

    /**
     * 获取永久回收数据
     * @return
     */
    List<FileRecycle> getForeverRecycle();

    /**
     * 永久回收数据
     * @param
     * @return
     */
    void updateForeverRecycle(Long id);

    /**
     *     * @return
     */
    int deleteAll();

    Boolean clearAll(String appId, Long adminId);
}
