package com.hengyunsoft.platform.mail.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mail.entity.core.po.TimeAttachment;
import com.hengyunsoft.platform.mail.repository.core.dao.TimeAttachmentMapper;
import com.hengyunsoft.platform.mail.repository.core.example.TimeAttachmentExample;
import com.hengyunsoft.platform.mail.repository.core.service.TimeAttachmentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：定时发送附件impl
 * 修改人：wt
 * 修改时间：2018/8/24
 * 修改内容：
 */
@Service
@Slf4j
public class TimeAttachmentApiServiceImpl extends BaseServiceImpl<Long, TimeAttachment, TimeAttachmentExample> implements TimeAttachmentApiService {

    @Autowired
    TimeAttachmentMapper timeAttachmentMapper;


    @Override
    protected BaseNormalDao<Long,TimeAttachment, TimeAttachmentExample> getDao() {
        return timeAttachmentMapper;
    }
}
