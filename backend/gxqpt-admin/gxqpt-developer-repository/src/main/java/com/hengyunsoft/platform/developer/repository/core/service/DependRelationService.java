package com.hengyunsoft.platform.developer.repository.core.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.core.domain.DependRelationStatisticsDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.DependRelationDO;
import com.hengyunsoft.platform.developer.entity.core.po.DependRelation;
import com.hengyunsoft.platform.developer.repository.core.example.DependRelationExample;

import java.util.List;

public interface DependRelationService extends BaseService<Long, DependRelation, DependRelationExample> {


    /**
     * 查询指定月份前各应用使用总数
     *
     * @return
     */
    List<DependRelationDO> getUseInfo(String strDate);

    /**
     * 统计应用预计降本率
     *
     * @return
     */
    String getReduced();

    /**
     * farglory
     * 降本提质-成本统计
     *
     * @return
     */
    List<DependRelationStatisticsDO> findApplicationReduceCost();

    /**
     * farglory
     * 降本提质-工期统计
     *
     * @return
     */
    List<DependRelationStatisticsDO> findApplicationReduceTime();
}
