package com.hengyunsoft.base.dao.normal;

import java.io.Serializable;
import java.util.List;

import javax.validation.groups.Default;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.ValidGroup;

public interface Insert<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample> {

	/**
     * 保存
     *
     * @param record 实体
     */
    int insert(@ValidGroup({Default.class,MustNoneNull.class}) T record);

    /**
     * 保存不为null的字段
     *
     * @param record 实体
     */
    int insertSelective(@ValidGroup T record)  ;

    /**
     * 批量保存
     *
     * @param list list实体集合
     */
    void batchInsert(List<T> list);
}
