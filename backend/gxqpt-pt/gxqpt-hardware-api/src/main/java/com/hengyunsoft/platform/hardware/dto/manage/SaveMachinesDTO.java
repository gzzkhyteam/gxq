package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "SaveMachinesDTO", description = "保存主机")
public class SaveMachinesDTO {

    @ApiModelProperty(value = "主机集合")
    private  List<SaveMachineDTO> machines;
}