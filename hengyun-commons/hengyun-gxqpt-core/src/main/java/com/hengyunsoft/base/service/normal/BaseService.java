package com.hengyunsoft.base.service.normal;

import java.io.Serializable;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface BaseService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> extends SaveService<I, T, TE>
                 ,  UpdateService<I, T, TE>, DeleteService<I, T, TE>, RemoveService<I, T, TE>, SelectService<I, T, TE>{

}