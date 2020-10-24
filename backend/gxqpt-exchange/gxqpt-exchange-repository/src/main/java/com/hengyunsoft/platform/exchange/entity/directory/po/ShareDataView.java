package com.hengyunsoft.platform.exchange.entity.directory.po;

import com.hengyunsoft.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShareDataView implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;
    /**
     * 目录名称
     *
     * @mbggenerated
     */
    private String dirName;

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    private String dirCode;
    /**
     * 查看次数
     *
     * @mbggenerated
     */
    private Integer seeCount;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    private Integer downCount;

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    private Integer dataType;
    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    private String themeThreeName;
    /**
     * 行业小类
     *
     * @mbggenerated
     */
    private String industryThreeName;

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    private String serviceThreeName;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date createTime;
    /**
     * 领域分类
     *
     * @mbggenerated
     */
    private String domainName;
    /**
     * 单位名称
     *
     * @mbggenerated
     */
    private String unitName;
    /**
     * 目录描述
     *
     * @mbggenerated
     */
    private String desc;
    /**
     * 数据量
     *
     * @mbggenerated
     */
    private Integer dataCount;
    /**
     * 开放方式:1,开发；2，不开放
     *
     * @mbggenerated
     */
    private Integer openWay;
    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    private Integer shareWay;

    private Long setId;
    private String unitId;
}
