package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShareDataElementMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample> {
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
     * 查询申请发布元数据变动记录
     * @param
     */
    List<ShareDataElement> getElementChangeListApply(@Param("unitId")String unitId, @Param("status")Integer status);
    /**
     * 查询数据元数据变动记录
     * @param
     */
    List<ShareDataElement> getElementChangeList(@Param("applyCode")String applyCode);
    /**
     * 查询数据元数据列表
     * @param
     */
    List<ShareDataElement> getElementWareList(Long dirId);
    /**
     * 根据目录id查询字段
     * @param dirId
     * @return
     */
    List<Long> getEltListByDirId(@Param("dirId")Long dirId);

    /***
     * 根据目录id更新字段标识为空
     * @param dirId
     */
    void updateSetFiled2Null(@Param("dirId") long dirId);

    /***
     * 根据目录id，字段标识更新数据集标识
     * @param dirId
     * @param fieldCode
     * @param setField
     */
    void updateSetFiled(@Param("dirId") long dirId, @Param("fieldCode") String fieldCode,@Param("setField") String setField);
    /**
     * 查询目录下主键字段对象
     * @param dirId
     * @return
     */
    ShareDataElement getByDirId(Long dirId);

    /**
     * 批量更新目录元字段信息
     * @param dataElementList
     */
    void batchUpdate(List<ShareDataElement>  dataElementList);
}