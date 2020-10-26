package com.hengyunsoft.base.service.specific;
import java.io.Serializable;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface BaseSpecificService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> extends SaveSpecificService<I, T, TE>
                 ,UpdateSpecificService<I, T, TE>, DeleteSpecificService<I, T, TE>, RemoveSpecificService<I, T, TE>, SelectSpecificService<I, T, TE>{

}