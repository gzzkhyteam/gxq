package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.domain.DSFlowTaskInfoDO;
import com.hengyunsoft.platform.exchange.entity.set.domain.ShareDataSetDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetService extends BaseAllService<Long, ShareDataSet, ShareDataSetExample> {
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
     * 得到历史数据集流程信息
     * @param taskId
     * @return
     */
    DSFlowTaskInfoDO getHiFlowTsakInfo(Long taskId);

    /***
     * 查询数据集列表
     * @param param
     * @return
     */
    List<ShareDataSetDO> findAllDataSetList(Map<String, Object> param);

    /**
     * 根据单位查询数据量
     *
     * @param unitId 单位id
     * @return
     */
    int getSetCountByUnitId(String unitId);

    /***
     * 数据集是否审批通过
     * @param dataSetId
     * @return
     */
    boolean isAuditPass(Long dataSetId);

    /***
     * 根据申请编码查询数据
     * @param applyCode
     * @return
     */
    ShareDataSet getShareDataSetByApplyCod(String applyCode);

    /***
     * 根据数据集标识查询
     * @param setCode
     * @return
     */
    ShareDataSet getShareDataSetBySetCode(String setCode);
}
