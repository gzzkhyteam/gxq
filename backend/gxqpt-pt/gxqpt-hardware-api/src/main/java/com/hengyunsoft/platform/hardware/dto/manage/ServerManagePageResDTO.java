package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ServerManagePageRes", description = "服务器管理分配分页返回实体")
public class ServerManagePageResDTO {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "服务器id")
    private String serverId;
    @ApiModelProperty(value = "ip")
    private String ip;
    @ApiModelProperty(value = "管理单位id")
    private String orgid;
    @ApiModelProperty(value = "管理单位名称")
    private String orgname;
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;
    @ApiModelProperty(value = "管理员id")
    private String manageUid;
    @ApiModelProperty(value = "管理员名称")
    private String manageUname;
    @ApiModelProperty(value = "内存")
    private Integer memorySize;
    @ApiModelProperty(value = "操作系统")
    private String system;
    @ApiModelProperty(value = "所属网络")
    private String netScope;
    @ApiModelProperty(value = "开通时间")
    private Date openTime;
    @ApiModelProperty(value = "最近变更时间")
    private Date updateTime;
    @ApiModelProperty(value = "变更次数")
    private Integer changeCount;
    @ApiModelProperty(value = "申请id")
    private Long applyKeyid;
    /**
     * 初始变更源（记录最开始被变更的服务器主键）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "初始变更源（记录最开始被变更的服务器主键）")
    private Long originId;

    /**
     * 0未使用（已释放），1使用中，2已归还
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "0未使用（已释放），1使用中，2已归还")
    private Integer useStatus;
}
