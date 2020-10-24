package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "ServerManageUpdate", description = "服务分配管理修改")
public class ServerManageUpdateDTO {
    @ApiModelProperty(value = "服务器分配id主键")
    private Long id;
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
    private List<ServerAddDiskSaveDTO> saves;
    @ApiModelProperty(value = "磁盘修改实体")
    private List<ServerAddDiskUpdateDTO> updates;
    @ApiModelProperty(value = "磁盘删除id集合")
    private List<Long> deleteIds;
}
