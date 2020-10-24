package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述:根据name查询application数据DTO
 * @author chb
 * @date 2018/3/28 19:28 
 */
@Data
public class AppQueryDTO {

    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     *应用Id
     */
    @ApiModelProperty(value = "应用Id")
    private String appId;

    /**
     *应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;
    private String indexUrl;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    private String code;

}
