package com.hengyunsoft.platform.hardware.repository.apply.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.apply.po.Attachment, com.hengyunsoft.platform.hardware.repository.apply.example.AttachmentExample> {
    /**
     * 通过业务主键进行数据删除
     * @param busId
     * @return
     */
    int deleteByBusId(@Param("busId") Long busId);
}