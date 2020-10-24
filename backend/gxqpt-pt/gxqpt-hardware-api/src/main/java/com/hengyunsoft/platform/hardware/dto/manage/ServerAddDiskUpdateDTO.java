package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServerAddDiskUpdate", description = "服务分配时磁盘修改实体")
public class ServerAddDiskUpdateDTO {
    @ApiModelProperty(value = "主键id")
    private String id;
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
