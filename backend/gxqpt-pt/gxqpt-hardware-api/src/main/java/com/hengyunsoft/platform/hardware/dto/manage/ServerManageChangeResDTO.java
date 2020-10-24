package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ServerManageChangeRes", description = "服务分配管理变更信息返回实体")
public class ServerManageChangeResDTO {
    @ApiModelProperty(value = "变更源")
    ServerManageChangeDTO source;
    @ApiModelProperty(value = "变更目标")
    ServerManageChangeDTO target;
    /**
     * 申请单号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人姓名")
    private String applyUname;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
}
