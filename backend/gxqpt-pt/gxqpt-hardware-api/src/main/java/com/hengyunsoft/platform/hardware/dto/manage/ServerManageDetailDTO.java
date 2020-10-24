package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ServerManageDetail", description = "服务分配管理详情查询")
public class ServerManageDetailDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "管理单位id")
    private String orgid;
    @ApiModelProperty(value = "管理单位名称")
    private String orgname;
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
    /**
     * 网关描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网关描述")
    private String gatewayDesc;
//    @ApiModelProperty(value = "管理单位id")
//    private String orgid;
//    @ApiModelProperty(value = "管理员id")
//    private String manageUid;
//    @ApiModelProperty(value = "管理单位名称")
//    private String orgname;
//    @ApiModelProperty(value = "管理员名称")
//    private String manageUname;
//    @ApiModelProperty(value = "开通时间")
//    private Date openTime;
    @ApiModelProperty(value = "磁盘详情实体")
    private List<ServerAddDiskDetailDTO> dtos;
}
