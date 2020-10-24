package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServerAddDiskSave", description = "服务分配时磁盘新增实体")
public class ServerAddDiskSaveDTO {
    @ApiModelProperty(value = "磁盘id")
    private String diskId;
    @ApiModelProperty(value = "磁盘名称")
    private String diskName;
    @ApiModelProperty(value = "磁盘大小")
    private String diskSize;
    @ApiModelProperty(value = "挂载点")
    private String diskPath;
    @ApiModelProperty(value = "磁盘属性")
    private String diskType;
}
