package com.hengyunsoft.platform.exchange.repository.common.dao;

import com.hengyunsoft.platform.exchange.entity.screen.po.BusInfoDetailDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommonMapper{
    String selectOrgIdByUserId(@Param("userId") Long userId);

    /**
     * 描述：根据单位Id查询单位名称
     * 参数：unitId 单位Id
     * 返回值：单位名称
     * 修改人：zhaopengfei
     * 修改时间：2018/5/7
     * 修改内容：
     */
    String selectOrgNameByUnitId(@Param("orgId") String orgId);

    Map<String,Object> selectDemandUnitInfoByUserId(@Param("userId") Long userId);

    List<Map<String, Object>> selectBusInfoList(Map<String, Object> param);

    BusInfoDetailDO selectBusInfoDetail(String id);
}