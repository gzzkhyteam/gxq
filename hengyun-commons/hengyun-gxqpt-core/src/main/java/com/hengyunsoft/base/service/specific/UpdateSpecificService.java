
package com.hengyunsoft.base.service.specific;

import java.io.Serializable;
import java.util.Collection;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface UpdateSpecificService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {

	 /**
     * 更新
     *
     * @param entity
     * @return 影响行数
     */
    int updateByAppIdAndId(String appId, T entity);

    /**
     * 批量更新
     * @param list
     * @return 影响行数
     */
    int updateByAppIdAndId(String appId, Collection<T> entitys);

    /**
     * 更新非空字段的值
     * @param entity
     * @return 影响行数
     */
    int updateByAppIdAndIdSelective(String appId, T entity);

	/**
     * 批量更新非空字段的值
     * @param list
     * @return 影响行数
     */
    int updateByAppIdAndIdSelective(String appId, Collection<T> entitys);
}