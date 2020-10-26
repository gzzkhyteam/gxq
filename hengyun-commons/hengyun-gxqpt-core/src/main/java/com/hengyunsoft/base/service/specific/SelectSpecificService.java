
package com.hengyunsoft.base.service.specific;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;

public interface SelectSpecificService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {


    /**
     * 根据ID + AppId查找记录
     *
     * @param id
     */
    T getByAppIdAndId(String appId, I id);
}
