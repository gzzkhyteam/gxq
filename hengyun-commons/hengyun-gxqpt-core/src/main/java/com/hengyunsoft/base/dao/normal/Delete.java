package com.hengyunsoft.base.dao.normal;

import java.io.Serializable;
import java.util.Collection;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface Delete<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample> {
	/**
     * 根据example拼接的条件，删除记录
     *
     * @param example 实体操作类
     */
    int deleteByExample(TE example);

    /**
     * 根据id，删除记录
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(I id);
    /**
     * 根据id，删除记录
     *
     * @param id 主键
     */
    int deleteByIds(Collection<I> list);
}
