package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDataElementWareMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementWareExample> {
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
     * 批量更新目录元字段信息到发布表
     * @param dataElementList
     */
    void batchUpdate(List<ShareDataElementWare>  dataElementList);
}