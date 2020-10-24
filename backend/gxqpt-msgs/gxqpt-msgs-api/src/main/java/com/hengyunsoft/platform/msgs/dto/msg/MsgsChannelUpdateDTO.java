package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelUpdate", description = "渠道更改对象")
public class MsgsChannelUpdateDTO  extends MsgsChannelBaseDTO{
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

}
