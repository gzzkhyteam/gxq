package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowApiListDO;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowDemanListDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowTaskMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowTaskExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 待办任务service
 *
 * @author wgj
 * @createtime 2018-04-22
 */
@Service
public class ShareFlowTaskServiceImpl extends BaseAllServiceImpl<Long, ShareFlowTask, ShareFlowTaskExample> implements ShareFlowTaskService {
    @Autowired
    ShareFlowTaskMapper shareFlowTaskMapper;

    @Override
    protected BaseNormalDao<Long, ShareFlowTask, ShareFlowTaskExample> getDao() {

        return shareFlowTaskMapper;
    }

    /**
     * 描述：查找需求申请列表
     * 参数：param
     * 返回值：FlowDemanListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    @Override
    public List<FlowDemanListDO> findDemandList(Map<String, Object> param) {
        return shareFlowTaskMapper.selectDemandList(param);
    }

    /**
     * 描述：查找共享申请列表
     * 参数：param
     * 返回值：FlowApiListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    @Override
    public List<FlowApiListDO> findApiApplyList(Map<String, Object> param) {
        return shareFlowTaskMapper.selectApiApplyList(param);
    }
}
