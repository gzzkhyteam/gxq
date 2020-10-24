package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "ShareDictBaseInfo", description = "数据字典基础信息")
public class ShareDictBaseInfoDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

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
}
