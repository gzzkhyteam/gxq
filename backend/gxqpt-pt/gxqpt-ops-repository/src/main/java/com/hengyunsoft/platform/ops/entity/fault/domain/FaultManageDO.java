package com.hengyunsoft.platform.ops.entity.fault.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class FaultManageDO extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 故障名称
     *
     * @mbggenerated
     */
    private String faultName;

    /**
     * 故障类别
     *
     * @mbggenerated
     */
    private String faultType;

    /**
     * 故障级别
     *
     * @mbggenerated
     */
    private String faultLevel;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String systemName;

    /**
     * 故障主机
     *
     * @mbggenerated
     */
    private String faultHost;

    /**
     * 状态:1未处理2c处理中3已完结
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 产生时间
     *
     * @mbggenerated
     */
    private Date happenTime;

    /**
     * 故障简述
     *
     * @mbggenerated
     */
    private String faultInfo;

    /**
     * 是否属实
     *
     * @mbggenerated
     */
    private String isTrue;

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    private String dealOpinion;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    private Date dealTime;

    /**
     * 处理流程
     *
     * @mbggenerated
     */
    private String dealProcess;

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    private String result;

    /**
     * 建议
     *
     * @mbggenerated
     */
    private String advice;

    /**
     * 是否加入知识库
     *
     * @mbggenerated
     */
    private Integer isJoinKnowledge;

}