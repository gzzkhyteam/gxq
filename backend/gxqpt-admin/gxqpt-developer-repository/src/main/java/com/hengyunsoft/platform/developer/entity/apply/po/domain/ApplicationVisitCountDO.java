package com.hengyunsoft.platform.developer.entity.apply.po.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationVisitCountDO implements Serializable {
    /**
     * 访问次数
     */
    private Integer count;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用id
     */
    private String appId;
}
