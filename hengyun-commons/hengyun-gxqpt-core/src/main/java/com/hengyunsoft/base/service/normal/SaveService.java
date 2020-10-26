package com.hengyunsoft.base.service.normal;

import java.io.Serializable;
import java.util.Collection;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface SaveService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {

	/**
     * 保存
     * @param entity
     */
    T save(T entity);

    /**
     * 批量保存
     * @param list
     */
    Collection<T> save(Collection<T> list);

    /***
     * 有选择(不为null)的保存
     * @param entity
     * @return
     */
    T saveSelective(T entity);
    
    /**
     * id 生成器生成id
     * @return
     */
    I genId();
}
