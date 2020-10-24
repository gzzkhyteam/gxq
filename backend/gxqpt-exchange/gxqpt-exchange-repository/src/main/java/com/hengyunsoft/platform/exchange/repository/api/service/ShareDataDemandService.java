package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataDemandListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataDemandExample;

import java.util.List;
import java.util.Map;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api需求管理
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */

public interface ShareDataDemandService extends BaseAllService<Long, ShareDataDemand, ShareDataDemandExample> {
    /**
     * 描述：获取需求申请列表
     * 参数：Map<String, Object>
     * 返回值：ShareDataDemandListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    List<ShareDataDemandListDO> findList(Map<String, Object> param);

}
