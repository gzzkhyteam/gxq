package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "DealToServerDTO", description = "优易分配虚拟机")
public class DealToServerDTO {
    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请表主键")
    private Long applyKeyid;

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节的特定标识")
    private String stepCode;

    /**
     * 分配的主机数据
     */
    @ApiModelProperty(value = "分配的主机数据")
    private List<DealServerDTO> dealServer;
}
