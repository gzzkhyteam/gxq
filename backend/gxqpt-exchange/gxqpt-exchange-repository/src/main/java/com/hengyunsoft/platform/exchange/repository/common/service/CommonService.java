package com.hengyunsoft.platform.exchange.repository.common.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand;
import com.hengyunsoft.platform.exchange.entity.screen.po.BusInfoDetailDO;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.exchange.repository.common.service
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：自定义查询
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */
public interface CommonService{
    /**
     * 描述：根据useId获取orgId
     * 参数：userId
     * 返回值：orgId
     * 修改人：zhaopengfei
     * 修改时间：2018/4/23
     * 修改内容：
     */
    String getOrgIdByUserId(Long userId);
    /**
     * 描述：根据单位Id查询单位名称
     * 参数：unitId 单位Id
     * 返回值：单位名称
     * 修改人：zhaopengfei
     * 修改时间：2018/5/7
     * 修改内容：
     */
    String getOrgNameByUnitId(String orgId);
    /**
     * 描述：根据用户信息获取单位信息
     * 参数：userId 用户Id
     * 返回值：Map<String,Object>
     * 修改人：zhaopengfei
     * 修改时间：2018/7/10
     * 修改内容：
     */
    Map<String,Object> querDemandUnitInfoByUserId(Long userId);

    List<Map<String, Object>> selectBusInfoList(Map<String, Object> param);

    BusInfoDetailDO selectBusInfoDetail(String id);
}
