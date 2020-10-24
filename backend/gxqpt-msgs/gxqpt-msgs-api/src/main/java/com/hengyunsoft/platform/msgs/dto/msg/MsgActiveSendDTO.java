package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgActiveSendDTO", description = "活跃发布商统计")
public class MsgActiveSendDTO {
	@ApiModelProperty(value = "年份")
    private String year;
	@ApiModelProperty(value = "月份")
    private String month;
	@ApiModelProperty(value = "日期")
    private String day;
	@ApiModelProperty(value = "数量")
    private Integer count;
}
