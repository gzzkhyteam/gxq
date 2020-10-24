package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiCallDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiDirCallDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiCall;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiCallExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public interface ShareDataApiCallService extends BaseAllService<Long, ShareDataApiCall, ShareDataApiCallExample> {
    /**
     *api实时调用
     * @Author wgj
     * @createtime 2018-05-01
     */
    List<ApiCallDO> getApiRealTimeCall();

    /**
     * 当日调用次数
     * @param date
     * @return
     */
    int getApiCallCount(Date date);

    /**
     * 查询单位申请的api
     * @param unitId
     * @return
     */
    List<ApiCallDO> getUnitListByUnitId(String unitId);

    /**
     * 查询api共享给那些单位了
     * @param id
     * @return
     */
    List<ApiCallDO> getShareUnitListByApiId(Long id);

    /**
     * 查询目录月度调用次数（按照共享与非共享分类）
     * @param year
     * @return
     */
    List<ApiDirCallDO> queryMonthCallInfo(String year);

    /**
     * 共享交换分析查询API调用信息
     * @param shareWay
     * @return
     */
    List queryApiCallInfo(Integer shareWay);
}
