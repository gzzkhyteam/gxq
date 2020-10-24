package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateDictionaryTypeDTO {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 编码
     */
    @ApiModelProperty(value="编码")
    private String code;

    /**
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String description;


}