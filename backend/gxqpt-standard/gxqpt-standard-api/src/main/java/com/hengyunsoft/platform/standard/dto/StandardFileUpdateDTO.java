package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "StandardFileUpdate", description = "标准文档展示对象")
public class StandardFileUpdateDTO extends StandardFileBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
    private String companyId;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    private String companyName;
}
