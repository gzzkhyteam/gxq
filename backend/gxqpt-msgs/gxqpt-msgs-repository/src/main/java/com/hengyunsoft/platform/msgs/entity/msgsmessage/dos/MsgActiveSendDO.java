package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgActiveSendDO", description = "活跃发布商统计")
public class MsgActiveSendDO {
	@ApiModelProperty(value = "年份")
    private String year;
	@ApiModelProperty(value = "月份")
    private String month;
	@ApiModelProperty(value = "日期")
    private String day;
	@ApiModelProperty(value = "数量")
    private Integer count;
}
