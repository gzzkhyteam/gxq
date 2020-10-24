package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataDemandListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataDemandMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataDemandExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataDemandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api需求管理实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataDemandServiceImpl extends BaseAllServiceImpl<Long, ShareDataDemand, ShareDataDemandExample> implements ShareDataDemandService {
    @Autowired
    ShareDataDemandMapper mapper;

    @Override
    protected BaseNormalDao<Long, ShareDataDemand, ShareDataDemandExample> getDao() {
        return mapper;
    }


    /**
     * 描述：获取需求申请列表
     * 参数：Map<String, Object>
     * 返回值：ShareDataDemandListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @Override
    public List<ShareDataDemandListDO> findList(Map<String, Object> param) {
        return mapper.selectList(param);
    }
}
