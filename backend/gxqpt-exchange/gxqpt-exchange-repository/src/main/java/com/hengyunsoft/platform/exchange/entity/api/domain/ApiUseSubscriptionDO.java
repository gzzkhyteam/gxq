package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api申请订阅-数据集-订阅相关信息
 * 修改人：zhaopengfei
 * 修改时间：2018/09/17
 * 修改内容：
 */
@Data
public class ApiUseSubscriptionDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "申请Id")
    private Long applyId;
    @ApiModelProperty(value = "数据集对应数据仓库表")
    private String tableName;

    @ApiModelProperty(value = "最后一次更新时间")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "通知表主键Id")
    private Long subId;

    @ApiModelProperty(value = "申请用户Id")
    private Long applyUserId;

    @ApiModelProperty(value = "API名称")
    private String apiName;
}
