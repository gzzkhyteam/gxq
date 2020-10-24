package com.hengyunsoft.platform.mail.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mail.entity.core.po.TimeSend;
import com.hengyunsoft.platform.mail.repository.core.dao.TimeSendMapper;
import com.hengyunsoft.platform.mail.repository.core.example.TimeSendExample;
import com.hengyunsoft.platform.mail.repository.core.service.TimeSendApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：邮件定时发送impl
 * 修改人：wt
 * 修改时间：2018/8/24
 * 修改内容：
 */
@Service
@Slf4j
public class TimeSendApiServiceImpl extends BaseServiceImpl<Long, TimeSend, TimeSendExample> implements TimeSendApiService {

    @Autowired
    TimeSendMapper timeSendMapper;


    @Override
    protected BaseNormalDao<Long,TimeSend, TimeSendExample> getDao() {
        return timeSendMapper;
    }
}
