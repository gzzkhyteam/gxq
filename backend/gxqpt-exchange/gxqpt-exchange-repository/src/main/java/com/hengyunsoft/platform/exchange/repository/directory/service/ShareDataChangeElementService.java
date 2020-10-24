package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeElementExample;

import java.util.List;

public interface ShareDataChangeElementService extends BaseAllService<Long,ShareDataChangeElement,ShareDataChangeElementExample> {
    /**
     * 根据申请编号查询字段目录信息
     * @param unitId
     * @param applyCode
     * @return
     */
    List<ShareDataChangeElement> findChangeEmtList(String unitId, String applyCode,Integer busType);

    /**
     * 删除未发布的变动字段记录信息表
     * @param elementId/字段表id
     */
    void  deleteByElementId(Long elementId);

    /**
     * 根据目录id删除字段变动记录信息表
     * @param dirId
     */
    void deleteByDirId(Long dirId);

    /**
     * 批量保存目录元字段变动记录信息
     * @param dataChangeElementList
     */
    void batchSave(List<ShareDataChangeElement>  dataChangeElementList);
}
