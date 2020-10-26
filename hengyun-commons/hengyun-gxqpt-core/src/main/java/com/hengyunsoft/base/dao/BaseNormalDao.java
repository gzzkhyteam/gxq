package com.hengyunsoft.base.dao;

import java.io.Serializable;

import com.hengyunsoft.base.dao.normal.Delete;
import com.hengyunsoft.base.dao.normal.Insert;
import com.hengyunsoft.base.dao.normal.Remove;
import com.hengyunsoft.base.dao.normal.Select;
import com.hengyunsoft.base.dao.normal.Update;
import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

/**
 * BaseDao，没有app_id 的dao 继承这个类
 */
public interface BaseNormalDao<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample>
		extends Insert<I, T, TE>, Update<I, T, TE>, Delete<I, T, TE>, Remove<I, T, TE>, Select<I, T, TE> {

}
