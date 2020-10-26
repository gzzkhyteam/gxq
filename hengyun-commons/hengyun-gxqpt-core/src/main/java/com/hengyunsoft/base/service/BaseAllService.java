package com.hengyunsoft.base.service;

import java.io.Serializable;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.base.service.specific.BaseSpecificService;
import com.hengyunsoft.db.example.BaseExample;

/**
 * @author tyh
 * @createTime 2017-12-08 17:30
 */
public interface BaseAllService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> extends BaseService<I, T, TE> 
										, BaseSpecificService<I, T, TE>{

}
