package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDir;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetDirService extends BaseAllService<Long, ShareDataSetDir, ShareDataSetDirExample> {
    /***
     * 根据目录id和数据集id查询
     * @param dirId
     * @param setId
     * @return
     */
    ShareDataSetDir getShareDataSetDirByDirIdAndSetId(long dirId, long setId);

    /***
     * 根据数据集id查询
     * @param setId
     * @return key:目录id
     */
    Map<Long, ShareDataSetDir> getShareDataSetDirBySetId(long setId);

    /***
     * 根据数据集id查询不是删除操作的
     * @param setId
     * @return key:目录id
     */
    Map<Long, ShareDataSetDir> getShareDataSetDirBySetIdNotDele(long setId);

    /***
     * 根据数据集id和操作类型查询
     * @param setId  数据集id
     * @param optType  操作类型：1,新增,2，删除,3，正常,
     * @return
     */
    List<ShareDataSetDir> getShareDataSetDirBySetIdAndOpt(long setId, int optType);

    /***
     * 根据数据集id删除
     * @param setId
     */
    void deleteBySetId(Long setId);
}
