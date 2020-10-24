package com.hengyunsoft.platform.exchange.repository.set.dao;

import com.hengyunsoft.platform.exchange.entity.set.domain.DSFlowTaskInfoDO;
import com.hengyunsoft.platform.exchange.entity.set.domain.ShareDataSetDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataSetMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet, com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetExample> {
    /***
     * 查询数据集审批列表
     * @param param
     * @return
     */
    List<ShareDataSetDO> findAuditList(Map<String, Object> param);

    /***
     * 得到正在执行的数据集流程任务信息
     * @param taskId
     * @return
     */
    DSFlowTaskInfoDO getNowFlowTsakInfo(Long taskId);

    /***
     * 查询数据集列表
     * @param param
     * @return
     */
    List<ShareDataSetDO> findAllDataSetList(Map<String, Object> param);

    /***
     * 得到历史数据集流程信息
     * @param taskId
     * @return
     */
    DSFlowTaskInfoDO getHiFlowTsakInfo(Long taskId);
    /**
     * 根据单位查询数据量
     * @param unitId 单位id
     * @return
     */
    int getSetCountByUnitId(String unitId);
}