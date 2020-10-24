package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisHandleDTO", description = "消息各操作统计")
public class MsgAnalysisHandleDTO {
	@ApiModelProperty(value = "已发送消息数量")
	private Integer sendNum;
	@ApiModelProperty(value = "草稿箱消息数量")
	private Integer draftNum;
	@ApiModelProperty(value = "渠道维护数量")
	private Integer channelNum;
	@ApiModelProperty(value = "发布商数量")
	private Integer publisherNum;
}
