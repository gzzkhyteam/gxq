package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import java.io.Serializable;
import java.util.Date;
//合并消息|消息类型 |消息渠道
public class ChannelByAnalysis implements Serializable {
    /**
     * 消息
     *
     * @mbggenerated
     */
    private Long id;

    private Integer count;

    private String name;

    private Date createTime;



    private static final long serialVersionUID = 1L;

    /**
     * 消息
     *
     * @mbggenerated

     */
    public Long getId() {
        return id;
    }

    /**
     * 消息
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}