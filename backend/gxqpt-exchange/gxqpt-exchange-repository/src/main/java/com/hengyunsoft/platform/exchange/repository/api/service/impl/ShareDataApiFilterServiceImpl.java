package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiFilter;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiFilterMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiFilterExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiFilterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.repository.api.service.impl
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api 选择过滤字段实现
 * 修改人：zhaopengfei
 * 修改时间：：2018/4/23
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiFilterServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiFilter, ShareDataApiFilterExample> implements ShareDataApiFilterService {
    @Autowired
    ShareDataApiFilterMapper mapper;

    @Override
    protected BaseNormalDao<Long, ShareDataApiFilter, ShareDataApiFilterExample> getDao() {
        return mapper;
    }

    /**
     * 描述：根据apiId查找其关联的过滤字段信息
     * 参数：apiId apiId
     * 返回值：ShareDataApiFilterDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @Override
    public List<ShareDataApiFilterDO> findFilterInfoByApiId(@Param("apiId") Long apiId) {
        return mapper.selectFilterInfoByApiId(apiId);
    }

    @Override
    public List<FiledFilterDO> queryFilterFiled(@Param("apiId") Long apiId) {
        return mapper.selectFilterFiled(apiId);
    }
    /**
     * 描述：根据定义不同的属性删除
     * 参数：example
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */
    @Override
    public int deleteByExample(ShareDataApiFilterExample example) {
       return mapper.deleteByExample(example);
    }

    @Override
    public void saveBatch(List<ShareDataApiFilter> filters) {
        mapper.batchInsert(filters);
    }
}
