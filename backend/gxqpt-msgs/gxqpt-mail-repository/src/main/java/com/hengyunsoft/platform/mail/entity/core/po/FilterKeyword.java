package com.hengyunsoft.platform.mail.entity.core.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FilterKeyword implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 过滤关键字
     *
     * @mbggenerated
     */
    private String filterWord;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

    private Integer count;
}