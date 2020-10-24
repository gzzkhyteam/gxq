package com.hengyunsoft.platform.supervise.repository.service;


import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseType;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTypeExample;

import java.util.List;

public interface PowerSuperviseTypeService extends BaseService<Long, PowerSuperviseType, PowerSuperviseTypeExample> {

    /**
     * 根据父id查询id
     * @param parentId
     * @return
     */
    Long getIdByParentId(Long parentId);

    /**
     * 查询全责类型编码
     * @return
     */
    List<String> getCode(String code);
}
