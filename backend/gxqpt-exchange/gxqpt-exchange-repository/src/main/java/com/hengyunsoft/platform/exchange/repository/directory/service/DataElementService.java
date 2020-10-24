package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;

import java.util.List;

public interface DataElementService extends BaseAllService<Long,ShareDataElement,ShareDataElementExample> {
    /**
     * 根据目录id删除目录元数据信息
     *
     * @param dirId-目录id
     */
    int deleteByDirId(Long dirId);

    /**
     * 更新元数据数据集字段setField
     * @param
     */
    void updateSetFieldByPrimaryKey(ShareDataElement shareDataElement);
    /**
     * 查询数据元数据变动记录
     * @param
     */
    List<ShareDataElement> getElementChangeListApply(String unitId,Integer status);
    /**
     * 查询申请发布元数据变动记录
     * @param
     */
    List<ShareDataElement> getElementChangeList(String applyCode);
    /**
     * 查询数据元数据列表
     * @param
     */
    List<ShareDataElement> getElementWareList(Long dirId);

    /**
     * 根据目录id查询字段
     * @param id
     * @return
     */
    List<Long> getEltListByDirId(Long id);

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

    /**
     * 查询目录下主键字段对象
     * @param dirId
     * @return
     */
    ShareDataElement getByDirId(Long dirId);

    /**
     * 批量保存目录元字段信息
     * @param dataElementList
     */
    void batchSave(List<ShareDataElement>  dataElementList);

    /**
     * 批量更新目录元字段信息
     * @param dataElementList
     */
    void batchUpdate(List<ShareDataElement>  dataElementList);
}
