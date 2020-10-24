package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsContactOftenUpdate", description = "常用联系人更改对象")
public class MsgsContactOftenUpdateDTO extends MsgsContactOftenDTO{
    /*
     * 使用次数
     */
    @ApiModelProperty(value = "使用次数")
    private int use_num;
}
