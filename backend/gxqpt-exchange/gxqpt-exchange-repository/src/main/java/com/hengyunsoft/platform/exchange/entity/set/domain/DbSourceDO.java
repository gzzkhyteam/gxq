package com.hengyunsoft.platform.exchange.entity.set.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据源扩展
 */
@Data
public class DbSourceDO extends ShareDbSource {

    /**
     * 系统名称
     */
    private String systemName;
}