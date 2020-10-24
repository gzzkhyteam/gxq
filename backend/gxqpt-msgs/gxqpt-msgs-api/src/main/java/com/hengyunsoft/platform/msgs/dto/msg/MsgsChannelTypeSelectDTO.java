package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "MsgsChannelTypeSelec", description = "渠道类型下拉框查询")
public class MsgsChannelTypeSelectDTO {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;


}
