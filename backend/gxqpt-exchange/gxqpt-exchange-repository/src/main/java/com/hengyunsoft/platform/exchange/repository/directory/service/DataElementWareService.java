package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementWareExample;

import java.util.List;

public interface DataElementWareService extends BaseAllService<Long, ShareDataElementWare, ShareDataElementWareExample> {
    /**
     * 目录审批通过后，同步保存元数据字段表
     *
     * @return
     * @Author tianai
     * @createtime 2018-05-07
     */
    int saveElementWare(ShareDataElementWare entity);

    /***
     * 根据目录id更新字段标识为null
     * @param dirId
     */
    void updateSetFiled2Null(long dirId);

    /***
     * 根据目录id、字段标识更新数据集字段标识
     * @param dirId 目录id
     * @param fieldCode 字段标识
     * @param setField 数据集字段标识
     */
    void updateSetFiled(long dirId, String fieldCode, String setField);

    /***
     * 根据目录id查询
     * @param dirId 目录id
     * @return
     */
    List<ShareDataElementWare> queryByDirId(long dirId);

    /**
     * 批量保存目录元字段信息到发布表
     * @param dataElementList
     */
    void batchSave(List<ShareDataElementWare>  dataElementList);

    /**
     * 批量更新目录元字段信息到发布表
     * @param dataElementList
     */
    void batchUpdate(List<ShareDataElementWare>  dataElementList);
}
