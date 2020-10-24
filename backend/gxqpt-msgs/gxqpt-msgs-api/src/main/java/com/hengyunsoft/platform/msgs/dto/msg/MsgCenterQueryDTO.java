package com.hengyunsoft.platform.msgs.dto.msg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MsgCenterQueryDTO {
	@ApiModelProperty(value = "接收者ID")
	private Long reciverId;
	@ApiModelProperty(value = "更多 1表示更多0表示进入")
	private Integer more;
}
