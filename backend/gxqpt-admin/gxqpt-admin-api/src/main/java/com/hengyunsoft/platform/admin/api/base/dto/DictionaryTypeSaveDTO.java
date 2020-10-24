package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-1-25
 */
@Data
@ApiModel(value = "DictionaryTypeSave", description = "数据字典类型")
public class DictionaryTypeSaveDTO extends BaseDictionaryTypeDTO implements Serializable {

    /**
     * 数据字典类型编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型编码",required = true)
    private String code;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id",required = true)
    private Long parentId;

    /**
     * appId
     */
    @ApiModelProperty(value = "appId",required = true)
    private String appId;

}
