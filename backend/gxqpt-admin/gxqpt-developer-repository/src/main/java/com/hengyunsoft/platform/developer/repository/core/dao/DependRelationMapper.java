package com.hengyunsoft.platform.developer.repository.core.dao;

import com.hengyunsoft.platform.developer.entity.apply.po.domain.DependRelationDO;
import com.hengyunsoft.platform.developer.entity.core.domain.DependRelationStatisticsDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependRelationMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.core.po.DependRelation, com.hengyunsoft.platform.developer.repository.core.example.DependRelationExample> {

    /**
     * 查询指定月份前各应用使用总数
     * @return
     */
    List<DependRelationDO> getUseInfo(String strDate);

    /**
     * 总降本率查询
     * @return
     */
    String getReduced();
    /**
     * farglory
     * 降本提质-成本统计
     * @return
     */
    List<DependRelationStatisticsDO> findApplicationReduceCost();
    /**
     * farglory
     * 降本提质-工期统计
     * @return
     */
    List<DependRelationStatisticsDO>  findApplicationReduceTime();
}