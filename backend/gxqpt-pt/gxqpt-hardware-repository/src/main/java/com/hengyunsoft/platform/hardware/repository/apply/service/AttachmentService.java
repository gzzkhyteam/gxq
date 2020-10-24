package com.hengyunsoft.platform.hardware.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.apply.po.Attachment;
import com.hengyunsoft.platform.hardware.repository.apply.example.AttachmentExample;

public interface AttachmentService extends BaseService<Long, Attachment, AttachmentExample> {
    /**
     * 根据业务id进行数据删除
     * @param id
     * @return
     */
    int deleteByBusId(Long busId);
}
