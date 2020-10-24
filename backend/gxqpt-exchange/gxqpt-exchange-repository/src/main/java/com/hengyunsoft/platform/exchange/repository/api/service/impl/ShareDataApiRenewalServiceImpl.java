package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiRenewal;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiRenewalMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiRenewalExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiRenewalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api续期申请实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiRenewalServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiRenewal, ShareDataApiRenewalExample> implements ShareDataApiRenewalService {
    @Autowired
    ShareDataApiRenewalMapper mapper;

    @Override
    protected BaseNormalDao<Long, ShareDataApiRenewal, ShareDataApiRenewalExample> getDao() {
        return mapper;
    }


}
