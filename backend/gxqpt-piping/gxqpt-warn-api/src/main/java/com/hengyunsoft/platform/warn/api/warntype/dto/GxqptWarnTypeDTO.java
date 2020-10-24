package com.hengyunsoft.platform.warn.api.warntype.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警类型DTO
 * @author zjr
 * @date 2018/03/28
 */
@Data
@ApiModel(value = "warnType", description = "预警类型DTO")
public class GxqptWarnTypeDTO implements Serializable {

    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 预警编码
     * @mbggenerated

     */
    @ApiModelProperty(value = "预警编码")
    private String code;
    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String typeName;
    /**
     * 序号
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;
    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId = 0L;
    /**
     * 是否启用 1：启用、0：禁用
     */
    @ApiModelProperty(value = "是否启用 1：启用、0：禁用")
    private Integer isEnable;
    /**
     * 类型描述
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型描述")
    private String context;
    /**
     * 层级
     * @mbggenerated
     */
    @ApiModelProperty(value = "层级")
    private String leve;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getLeve() {
        return leve;
    }

    public void setLeve(String leve) {
        this.leve = leve;
    }
}
