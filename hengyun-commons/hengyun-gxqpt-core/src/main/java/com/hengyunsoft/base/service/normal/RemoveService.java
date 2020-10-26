package com.hengyunsoft.base.service.normal;

import java.io.Serializable;
import java.util.Collection;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.exception.BizException;

public interface RemoveService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {

	/**
     * 逻辑删除，[约定表中一定存在is_delete字段,不存在字段就报错]
     *
     * @param id
     * @return
     */
    int removeById(I id) throws BizException;
    
    /**
     * 批量逻辑删除记录 [约定表中一定存在is_delete字段,不存在字段就报错]
     *
     * @param ids
     * @return 影响行数
     */
    int removeByIds(Collection<I> ids) throws BizException;
}