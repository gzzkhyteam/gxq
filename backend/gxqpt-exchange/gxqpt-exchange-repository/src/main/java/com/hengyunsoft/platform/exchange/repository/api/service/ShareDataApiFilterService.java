package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiFilter;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiFilterExample;

import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api 选择过滤字段实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */

public interface ShareDataApiFilterService extends BaseAllService<Long, ShareDataApiFilter, ShareDataApiFilterExample> {
    /**
     * 描述：根据apiId查找其关联的过滤字段信息
     * 参数：apiId apiId
     * 返回值：ShareDataApiFilterDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    List<ShareDataApiFilterDO> findFilterInfoByApiId(Long apiId);
    /**
     * 描述：查询Api返回字段
     * 参数：apiId
     * 返回值：FiledFilterDO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/8
     * 修改内容：
     */
    List<FiledFilterDO> queryFilterFiled(Long apiId);
    /**
     * 描述：根据定义不同的属性删除
     * 参数：example
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */
    int deleteByExample(ShareDataApiFilterExample example);

    void saveBatch(List<ShareDataApiFilter> filters);
}
