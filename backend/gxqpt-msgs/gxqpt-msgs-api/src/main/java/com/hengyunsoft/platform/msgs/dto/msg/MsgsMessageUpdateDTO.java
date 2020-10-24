package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsMessageUpdate", description = "消息更改对象")
public class MsgsMessageUpdateDTO extends MsgsMessageBaseDTO{
    /**
     * 消息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息")
    private Long id;

}
