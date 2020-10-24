package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;

import java.io.Serializable;
import java.util.Date;

public class ShareDataDirectoryDO extends ShareDataDirectory {

    /**
     * 发布记录表id
     *
     * @mbggenerated
     */
    private Long wareId;



    /**
     * 发布记录表id
     *
     * @mbggenerated
     */
    private Long setId;

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }
    @Override
    public Long getSetId() {
        return setId;
    }

    @Override
    public void setSetId(Long setId) {
        this.setId = setId;
    }
}



