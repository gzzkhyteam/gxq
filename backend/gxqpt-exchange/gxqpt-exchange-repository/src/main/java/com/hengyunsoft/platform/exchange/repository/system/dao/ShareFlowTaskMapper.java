package com.hengyunsoft.platform.exchange.repository.system.dao;

import com.hengyunsoft.platform.exchange.entity.system.domain.FlowApiListDO;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowDemanListDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareFlowTaskMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask, com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowTaskExample> {
    /**
     * 描述：查找需求申请列表
     * 参数：param
     * 返回值：FlowDemanListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    List<FlowDemanListDO> selectDemandList(Map<String, Object> param);
    /**
     * 描述：查找共享申请列表
     * 参数：param
     * 返回值：FlowApiListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    List<FlowApiListDO> selectApiApplyList(Map<String, Object> param);
}