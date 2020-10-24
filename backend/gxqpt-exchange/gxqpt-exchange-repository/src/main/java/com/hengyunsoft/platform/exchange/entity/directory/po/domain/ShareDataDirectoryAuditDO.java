package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ShareDataDirectoryAuditDO extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;


    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;



    /**
     * 单位名称
     *
     * @mbggenerated
     */
    private String unitName;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    private Long userId;


    /**
     * 审核id
     *
     * @mbggenerated
     */
    private Long auditId;


    /**
     * 流程待办任务id
     *
     * @mbggenerated
     */
    private Long taskId;
    /**
     * 操作类型
     *
     * @mbggenerated
     */
    private String optType;
    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 是否平台管理员 1是
     *
     * @mbggenerated
     */
    private Integer isPtadmin;

    /**
     * 申请理由
     *
     * @mbggenerated
     */
    private String applicationReasons;
    /**
     * 操作时间（当做申请时间）
     *
     * @mbggenerated
     */
    private Date optTime;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String  applyCode;

}

