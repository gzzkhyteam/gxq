package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api使用异常记录
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
public class ApiUseExceptionDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "调用情况Id")
    private Long id;
    @ApiModelProperty(value = "异常情况")
    private String failLog;

    @ApiModelProperty(value = "异常时间")
    private Date visitTime;

    @ApiModelProperty(value = "异常来源")
    private Integer failType;

    @ApiModelProperty(value = "处理状态")
    private Integer hdleState;

    @ApiModelProperty(value = "处理人")
    private String hdleUser;
}
