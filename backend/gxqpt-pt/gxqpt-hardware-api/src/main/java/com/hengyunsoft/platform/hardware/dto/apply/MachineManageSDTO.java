package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "MachineManageSDTO", description = "新增主机提交")
public class MachineManageSDTO {

    /**
     * 申请表主键（资源不足时为哪个申请进行资源补充便于展示）
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

    @ApiModelProperty(value = "新增主机")
    private List<MachineManageSubmitDTO> machineManage;
}
