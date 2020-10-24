package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelGroup", description = "渠道群组更改对象")
public class MsgsChannelGroupUpdateDTO extends MsgsChannelGroupBaseDTO{
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

}
