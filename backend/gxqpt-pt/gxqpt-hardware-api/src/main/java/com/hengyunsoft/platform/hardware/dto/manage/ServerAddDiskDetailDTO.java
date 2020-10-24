package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ServerAddDiskDetail", description = "服务分配磁盘详情实体")
public class ServerAddDiskDetailDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "服务分配外键id")
    private Long serverId;
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
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
