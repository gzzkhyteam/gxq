package com.hengyunsoft.platform.exchange.repository.system.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowApiListDO;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowDemanListDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowTaskExample;

import java.util.List;
import java.util.Map;

/**
 * 待办任务service
 * @author wgj
 * @createtime 2018-04-22
 */
public interface ShareFlowTaskService extends BaseAllService<Long,ShareFlowTask,ShareFlowTaskExample> {
    /**
     * 描述：查找需求申请列表
     * 参数：param
     * 返回值：FlowDemanListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    List<FlowDemanListDO> findDemandList(Map<String,Object> param);
    /**
     * 描述：查找共享申请列表
     * 参数：param
     * 返回值：FlowDemanListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    List<FlowApiListDO> findApiApplyList(Map<String, Object> param);
}
