package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 自定义文件夹
 *
 * @auth wt
 * @date 2018/07/30
 */
@Data
@ApiModel(value = "ResponseCostomFile", description = "自定义文件夹返回")
public class ResponseCostomFileDTO {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 文件标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件标识")
    private String fileMark;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

}
