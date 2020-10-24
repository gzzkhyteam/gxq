package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServerManageChangeReq", description = "服务分配管理变更信息入参实体")
public class ServerManageChangeReqDTO {
    @ApiModelProperty(value = "服务分配源id")
    private String originId;
    @ApiModelProperty(value = "申请名")
    private String applyUname;
    @ApiModelProperty(value = "所属网络")
    private String netScope;

    /**
     * 2019-04-24 测试提出的需求变更新增
     */
    @ApiModelProperty(value = "审批查询变更前数据服务器id")
    private Long serverKeyid;

    /**
     * 2019-04-24 测试提出的需求变更新增
     */
    @ApiModelProperty(value = "查询类型，空的话是原查询，1的话为新增查询")
    private Integer type;
}
