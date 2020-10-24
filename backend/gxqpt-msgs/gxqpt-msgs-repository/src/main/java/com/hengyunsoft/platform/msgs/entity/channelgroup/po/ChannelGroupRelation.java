package com.hengyunsoft.platform.msgs.entity.channelgroup.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;

public class ChannelGroupRelation extends BaseEntity<Long> implements Serializable {
    private Long id;

    private Long channelGroupId;

    private Long channelId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelGroupId() {
        return channelGroupId;
    }

    public void setChannelGroupId(Long channelGroupId) {
        this.channelGroupId = channelGroupId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
}