package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareRequestDictDTO", description = "数据字典请求信息")
public class ShareRequestDictDTO implements Serializable {

    /**
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String dictName;

    /**
     * 编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编码")
    private String dictCode;


    /**
     * 上级目录名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级目录名称")
    private String pDictName;

    /**
     * 上级目录编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级目录编码")
    private String pDictCode;

}
