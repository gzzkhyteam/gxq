
package com.hengyunsoft.base.service.normal;

import java.io.Serializable;
import java.util.Collection;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface UpdateService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {

	/**
     * 更新
     *
     * @param entity
     * @return 影响行数
     */
    int updateById(T entity);
    
    /**
     * 批量更新
     * @param list
     * @return 影响行数
     */
    int updateByIds(Collection<T> entitys);
    
    /**
     * 更新非空字段的值
     * @param entity
     * @return 影响行数
     */
    int updateByIdSelective(T entity);
    
    /**
     * 批量更新非空字段的值
     * @param list
     * @return 影响行数
     */
    int updateByIdSelective(Collection<T> entitys);
}