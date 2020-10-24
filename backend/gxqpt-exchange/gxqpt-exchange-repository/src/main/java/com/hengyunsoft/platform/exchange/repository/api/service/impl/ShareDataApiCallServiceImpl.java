package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiCallDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiDirCallDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiCall;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiCallMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiCallExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiCallService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareDataApiCallServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiCall, ShareDataApiCallExample> implements ShareDataApiCallService {
    @Autowired
    ShareDataApiCallMapper shareDataApiCallMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataApiCall, ShareDataApiCallExample> getDao() {
        return shareDataApiCallMapper;
    }
    /**
     *api实时调用
     * @Author wgj
     * @createtime 2018-05-01
     */
    @Override
    public List<ApiCallDO> getApiRealTimeCall() {


        return shareDataApiCallMapper.getApiRealTimeCall();
    }
    /**
     * 当日调用次数
     * @param date
     * @return
     */
    @Override
    public int getApiCallCount(Date date) {


        return shareDataApiCallMapper.getApiCallCount(date);
    }
    /**
     * 查询单位申请的api
     * @param unitId
     * @return
     */
    @Override
    public List<ApiCallDO> getUnitListByUnitId(String unitId) {


        return shareDataApiCallMapper.getUnitListByUnitId(unitId);
    }
    /**
     * 查询api共享给那些单位了
     * @param id
     * @return
     */
    @Override
    public List<ApiCallDO> getShareUnitListByApiId(Long id) {


        return shareDataApiCallMapper.getShareUnitListByApiId(id);
    }
    /**
     * 描述：查询目录月度调用次数（按照共享与非共享分类）
     * 参数：year 年份
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    @Override
    public List<ApiDirCallDO> queryMonthCallInfo(String year) {
        return shareDataApiCallMapper.selectMonthCallInfo(year);
    }
    /**
     * 描述：共享交换分析查询API调用信息
     * 参数：shareWay:1:开放，2：不开放
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    @Override
    public List<ApiCallDO> queryApiCallInfo(Integer shareWay) {
        return shareDataApiCallMapper.selectApiCallInfo(shareWay);
    }
}
