package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-1-25
 */
@Data
public abstract class BaseDictionaryTypeDTO {
    /**
     * 名称
     *
     */
    @ApiModelProperty(value = "数据字典类型名称")
    protected String name;

    /**
     * 描述
     *
     */
    @ApiModelProperty(value = "数据字典类型描述")
    protected String description;

    /**
     * 是否删除
     1：已删除
     0：未删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;


}
