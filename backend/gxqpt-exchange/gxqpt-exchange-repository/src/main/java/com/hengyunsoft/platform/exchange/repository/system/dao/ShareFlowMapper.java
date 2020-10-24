package com.hengyunsoft.platform.exchange.repository.system.dao;

import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareFlowMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.system.po.ShareFlow, com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowExample> {
    /**
     * 根据流程编号查询流程信息
     * @param procCode
     * @return
     * @createtime 2018-4-22
     */
    ShareFlow getByFlowKey(@Param("procCode")String procCode);
}