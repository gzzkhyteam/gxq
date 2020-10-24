package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataFile;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;

import java.util.List;

public interface ShareUnitService extends BaseAllService<Long,ShareUnit,ShareUnitExample> {
    /**
     * 根据目录id查询共享单位id
     * @param id
     * @return
     */
    List<String> getUnitListByDirId(Long id);

    /**
     * 删除共享单位
     * @param chgId
     */
    void deleteByDirId(Long chgId);

    /**
     * 批量保存目录共享单位
     * @param shareUnitList
     */
    void batchSave(List<ShareUnit>  shareUnitList);
    /**
     * 批量更新目录共享单位
     * @param shareUnitList
     */
    void batchUpdate(List<ShareUnit>  shareUnitList);

}
