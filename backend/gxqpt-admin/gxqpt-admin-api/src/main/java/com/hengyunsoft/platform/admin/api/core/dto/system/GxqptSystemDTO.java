package com.hengyunsoft.platform.admin.api.core.dto.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 描述：体系信息DTO
 * @author zjr
 * @createTime 2018-03-07
 */
@Data
public class GxqptSystemDTO implements Serializable {

    /**
     * 主键
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 体系编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 体系名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 体系来源
     *
     * @mbggenerated
     */
    private String source;

    /**
     * 体系描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 体系状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系状态 1启用、 2 禁用")
    private String status;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 体系编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 体系编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 体系名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 体系名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 体系来源
     *
     * @mbggenerated
     */
    public String getSource() {
        return source;
    }

    /**
     * 体系来源
     *
     * @mbggenerated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 体系描述
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 体系描述
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 体系状态
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 体系状态
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


}
