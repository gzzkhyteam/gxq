package com.hengyunsoft.base.dao.normal;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.validator.annotation.ValidGroup;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface Update<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample> {
	/**
     * 根据example拼接的条件，修改不为null的字段
     *
     * @param record  实体
     * @param example 实体操作类
     */
    int updateByExampleSelective(@ValidGroup @Param("record") T record, @Param("example") TE example);

    /**
     * 根据id，修改不为null的字段
     *
     * @param record 实体
     */
    int updateByPrimaryKeySelective(@ValidGroup T record);

    /**
     * 根据example拼接的条件，覆盖修改所有字段
     *
     * @param record  实体
     * @param example 实体操作类
     */
    int updateByExample(@ValidGroup @Param("record") T record, @Param("example") TE example);

    /**
     * 根据id，覆盖修改所有字段
     *
     * @param record 实体
     */
    int updateByPrimaryKey(@ValidGroup T record);
}
