package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledSelectDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElement;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiElementMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiElementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.repository.api.service.impl
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api 选择字段实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiElementServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiElement, ShareDataApiElementExample> implements ShareDataApiElementService {
    @Autowired
    ShareDataApiElementMapper mapper;

    @Override
    protected BaseNormalDao<Long, ShareDataApiElement, ShareDataApiElementExample> getDao() {
        return mapper;
    }

    /**
     * 描述：根据apiId查询查询字段详细信息
     * 参数：apiId
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @Override
    public List<ShareDataElement> findElementInfoByApiId(Long apiId) {
        return mapper.selectElementInfoByApiId(apiId);
    }

    @Override
    public List<FiledSelectDO> querySelectFiled(Long apiId) {
       return mapper.selectFiled(apiId);
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
    public int deleteByExample(ShareDataApiElementExample example) {
       return mapper.deleteByExample(example);
    }

    @Override
    public void saveBatch(List<ShareDataApiElement> elements) {
        mapper.batchInsert(elements);
    }
}
