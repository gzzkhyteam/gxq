package com.hengyunsoft.base.entity;

import java.io.Serializable;

/**
 * @author tyh
 * @createTime 2017-12-08 22:12
 */
public abstract class CommonBaseEntity<I extends Serializable> extends BaseEntity<I>{


    public abstract String getAppId();
    public abstract void setAppId(String appId);
}