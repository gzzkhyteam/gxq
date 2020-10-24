package com.hengyunsoft.platform.ops.servicedto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainHandleDTO", description = "培训申请处理请求参数")
public class TrainHandleDTO {
    /**
     * 培训id
     */
	@ApiModelProperty(value = "培训id")
    private Long id;
    /**
     * 处理状态0=同意；1=驳回
     */
	@ApiModelProperty(value = "处理状态；0=同意；1=驳回")
    private Integer status;
    /**
     * 培训意见
     */
    @ApiModelProperty(value = "培训意见")
    private String advice;
    /**
     * 培训人姓名
     */
    @ApiModelProperty(value = "培训人姓名")
    private String trainer;
    /**
     * 培训人Id
     */
    @ApiModelProperty(value = "培训人Id")
    private Long trainerId;
    /**
     * 协助人
     */
    @ApiModelProperty(value = "协助人")
    private List<AssistantDTO> assistant;
}
