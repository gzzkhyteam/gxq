package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDataChangeElementMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeElementExample> {

    /**
     * 根据申请编号查询字段目录信息
     * @param unitId
     * @param applyCode
     * @return
     */
    List<ShareDataChangeElement> findChangeEmtList(@Param("unitId") String unitId, @Param("applyCode")String applyCode,@Param("busType")Integer busType);

    /***
     * 更新数据集id为
     * @param elementId
     */
    void deleteByElementId(@Param("elementId") long elementId);

    /**
     * 根据目录id删除字段变动记录信息表
     * @param dirId
     */
    void deleteByDirId(@Param("dirId") Long dirId);
}