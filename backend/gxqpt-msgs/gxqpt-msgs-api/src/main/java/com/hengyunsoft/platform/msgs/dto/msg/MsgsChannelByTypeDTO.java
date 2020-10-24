package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelByType", description = "根据类型查询渠道列表展示对象")
public class MsgsChannelByTypeDTO {
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

}
