package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnitWare;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample;

import java.util.List;

public interface ShareUnitWareService extends BaseAllService<Long,ShareUnitWare,ShareUnitWareExample> {
    /**
     * 删除共享单位
     * @param dirId
     */
   void deleteWareByDirId(Long dirId);
    /**
     * 批量保存目录共享单位(发布表)
     * @param shareUnitWareList
     */
    void batchSave(List<ShareUnitWare> shareUnitWareList);
}
