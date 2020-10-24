package com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请列表查询条件
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "ShareApplyQuery", description = "共享申请列表查询条件")
public class ShareApplyQueryDTO {

    @ApiModelProperty(value = "API名称")
    private String apiName;

    @ApiModelProperty(value = "API状态:1,启用；2，禁用")
    private Integer apiStatus;

    @ApiModelProperty(value = "状态:1,通过；2，驳回")
    private Integer status;

    @ApiModelProperty(value = "对应目录id")
    private Long dirId;

    @ApiModelProperty(value = "单位Id")
    private String unitId;


}
