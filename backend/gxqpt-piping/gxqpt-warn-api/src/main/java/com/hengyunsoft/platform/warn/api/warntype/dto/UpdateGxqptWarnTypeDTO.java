package com.hengyunsoft.platform.warn.api.warntype.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：编辑预警类型DTO
 * @author zjr
 * @date 2018/03/28
 */
@Data
@ApiModel(value = "update", description = "编辑预警类型")
public class UpdateGxqptWarnTypeDTO implements Serializable {
    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String typeName;
    /**
     * 预警类型编码
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型编码")
    private String code;
    /**
     * 序号
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;
    /**
     * 类型描述
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型描述")
    private String context;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String setTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
