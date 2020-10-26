package com.hengyunsoft.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tyh
 * @createTime 2017-12-08 17:34
 */
public abstract class BaseEntity<I extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract I getId();

    public abstract void setId(I id);

    protected Date createTime;
    protected Date updateTime;

    public  Date getCreateTime(){
        return this.createTime;
    }
    public  Date getUpdateTime(){
        return updateTime;
    }
    public  void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    public  void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }
}
