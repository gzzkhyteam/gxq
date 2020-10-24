package com.hengyunsoft.platform.exchange.repository.common.service.impl;

import com.hengyunsoft.platform.exchange.entity.screen.po.BusInfoDetailDO;
import com.hengyunsoft.platform.exchange.repository.common.dao.CommonMapper;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.exchange.repository.common.service.impl
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：自定义查询
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService{
    @Autowired
    CommonMapper commonMapper;
    @Override
    public String getOrgIdByUserId(Long userId) {
        return commonMapper.selectOrgIdByUserId(userId);
    }

    /**
     * 描述：根据单位Id查询单位名称
     * 参数：unitId 单位Id
     * 返回值：单位名称
     * 修改人：zhaopengfei
     * 修改时间：2018/5/7
     * 修改内容：
     */
    @Override
    public String getOrgNameByUnitId(String orgId) {
       return commonMapper.selectOrgNameByUnitId(orgId);
    }

    @Override
    public Map<String, Object> querDemandUnitInfoByUserId(Long userId) {
        return commonMapper.selectDemandUnitInfoByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> selectBusInfoList(Map<String, Object> param) {
        return commonMapper.selectBusInfoList(param);
    }

    @Override
    public BusInfoDetailDO selectBusInfoDetail(String id) {
        return commonMapper.selectBusInfoDetail(id);
    }
}
