package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.ApiCallDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiDirCallDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShareDataApiCallMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiCall, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiCallExample> {
    /**
     *api实时调用
     * @Author wgj
     * @createtime 2018-05-01
     */
    List<ApiCallDO> getApiRealTimeCall();
    /**
     * 当日调用次数
     * @param nowDate
     * @return
     */
    int getApiCallCount(@Param("nowDate") Date nowDate);
    /**
     * 查询单位申请的api
     * @param unitId
     * @return
     */
    List<ApiCallDO> getUnitListByUnitId(@Param("unitId")String unitId);
    /**
     * 查询api共享给那些单位了
     * @param apiId
     * @return
     */
    List<ApiCallDO> getShareUnitListByApiId(@Param("apiId")Long apiId);

    /**
     * 查询目录月度调用次数（按照共享与非共享分类）
     * @param year
     * @return
     */
    List<ApiDirCallDO> selectMonthCallInfo(String year);

    /**
     * 描述：共享交换分析查询API调用信息
     * 参数：shareWay:1:开放，2：不开放
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    List<ApiCallDO> selectApiCallInfo(Integer shareWay);
}