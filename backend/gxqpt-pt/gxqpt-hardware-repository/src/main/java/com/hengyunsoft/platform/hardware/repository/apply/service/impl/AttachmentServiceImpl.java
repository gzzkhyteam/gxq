package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.po.Attachment;
import com.hengyunsoft.platform.hardware.repository.apply.dao.AttachmentMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.AttachmentExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl extends BaseServiceImpl<Long, Attachment, AttachmentExample> implements AttachmentService {

    @Autowired
    AttachmentMapper attachmentMapper;

    @Override
    protected BaseNormalDao<Long, Attachment, AttachmentExample> getDao() {
        return attachmentMapper;
    }

    /**
     * 通过业务ID进行数据删除
     * @param id
     * @return
     */
    @Override
    public int deleteByBusId(Long busId) {
        return attachmentMapper.deleteByBusId(busId);
    }
}
