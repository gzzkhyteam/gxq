package com.hengyunsoft.platform.exchange.repository.system.service;


import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlow;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowExample;

/**
 * @author wgj
 * @todo 流程引擎service
 * @createtime 2018-4-22
 */
public interface ShareFlowService extends BaseAllService<Long, ShareFlow, ShareFlowExample> {

    /**
     * 根据流程编号查询流程信息
     *
     * @param procCode
     * @return
     * @createtime 2018-4-22
     */
    ShareFlow getByFlowKey(String procCode);

    /**
     * @param applyCode 申请编号
     * @param procCode  流程编号
     * @param userId    申请用户id
     * @return boolean
     * @todo 启动流程
     * @Author wgj
     * @createtime 2018-4-22
     */
    Result<Boolean> saveStartFlow(Integer type, String applyCode, String procCode, Long userId, String unitId);

    /**
     * @param taskId 任务id
     * @param status 流程状态 1,通过；2，驳回
     * @param userId 申请用户id
     * @return boolean
     * @todo 流程审批
     * @Param content 审批意见
     * @Author wgj
     * @createtime 2018-4-22
     */
    Result<Boolean> updateWorkFlow(Integer type,Long taskId, Long userId, Integer status, String content);


}
