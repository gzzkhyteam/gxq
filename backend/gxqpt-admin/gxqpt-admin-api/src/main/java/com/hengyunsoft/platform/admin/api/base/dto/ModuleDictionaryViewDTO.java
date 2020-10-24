package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能类型维护DTO
 * @author madb
 * @createTime 2018/4/10
 */
@Data
public class ModuleDictionaryViewDTO implements Serializable{
    /**
     * 收索功能类型
     * */
    @ApiModelProperty(value = "收索功能类型")
    private String name;
}
