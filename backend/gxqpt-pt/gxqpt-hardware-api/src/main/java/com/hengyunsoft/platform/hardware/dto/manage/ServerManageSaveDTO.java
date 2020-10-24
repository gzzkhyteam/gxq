package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@ApiModel(value = "ServerManageSave", description = "服务分配管理新增查询")
public class ServerManageSaveDTO {
    @ApiModelProperty(value = "服务器id")
    private String serverId;
    @ApiModelProperty(value = "服务器ip")
    private String ip;
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;
    @ApiModelProperty(value = "操作系统")
    private String system;
    @ApiModelProperty(value = "所属网络")
    private String netScope;
    @ApiModelProperty(value = "网络带宽")
    private String netWide;
    @ApiModelProperty(value = "管理单位id")
    private String orgid;
    @ApiModelProperty(value = "管理员id")
    private String manageUid;
    @ApiModelProperty(value = "管理单位名称")
    private String orgname;
    @ApiModelProperty(value = "管理员名称")
    private String manageUname;
    @ApiModelProperty(value = "开通时间")
    private Date openTime;
    @ApiModelProperty(value = "磁盘新增实体")
    private List<ServerAddDiskSaveDTO> dtos;
}
