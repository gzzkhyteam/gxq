package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsContactOften", description = "常用联系人列表对象")
public class MsgsContactOftenDTO {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "联系人电话")
    private String contact;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String contactname;

}
