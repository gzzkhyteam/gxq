package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelThree", description = "渠道id、渠道名称、渠道类型")
public class MsgsChannelThreeDTO {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 渠道
     */
    @ApiModelProperty(value = "渠道")
    private String name;
    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private String channelType;

}
