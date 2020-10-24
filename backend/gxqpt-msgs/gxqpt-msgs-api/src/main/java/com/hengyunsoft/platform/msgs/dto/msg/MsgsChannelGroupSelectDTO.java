package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelGroupSelect", description = "渠道群组下拉对象")
public class MsgsChannelGroupSelectDTO {
    /**
     * 渠道群组ID
     */
    @ApiModelProperty(value = "渠道群组ID")
    private Long id;

    /**
     *内容
     */
    @ApiModelProperty(value = "群组名称")
    private String name;



}
