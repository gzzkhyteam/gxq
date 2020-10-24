package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ShareDataElementDO extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;



    /**
     * 目录id
     *
     * @mbggenerated
     */
    private String dirId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 主键
     *
     * @mbggenerated
     */
    private Integer isPrimary;


    /**
     * 字段名称
     *
     * @mbggenerated
     */
    private String fieldName;

    /**
     * 字段标识
     *
     * @mbggenerated
     */
    private String fieldCode;

    /**
     * 字段类型
     *
     * @mbggenerated
     */
    private String fieldType;

    /**
     * 字段描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 数据集字段
     *
     * @mbggenerated
     */
    private String setField;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用
     *
     * @mbggenerated
     */
    private Integer optType;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    private Integer dataStatus;

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
    private Long createUser;

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
    /**
     * 更新人名称
     *
     * @mbggenerated
     */
    private String updateUserName;

}