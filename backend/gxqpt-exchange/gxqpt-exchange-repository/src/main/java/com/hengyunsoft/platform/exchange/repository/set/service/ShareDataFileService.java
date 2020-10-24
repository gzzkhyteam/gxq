package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataFile;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataFileExample;

import java.util.List;
import java.util.Map;

public interface ShareDataFileService extends BaseAllService<Long, ShareDataFile, ShareDataFileExample> {
    /***
     * 根据数据集id查询文件
     * @param setId 数据集id
     * @return key:文件编号
     */
    Map<Long, ShareDataFile> getShareDataFileBySetId(long setId);

    /***
     * 根据数据集id删除删除操作的文件
     * @param setId
     */
    void deleteOptDeleBySetId(long setId);

    void saveBatch(List<ShareDataFile> shareDataFiles);
}
