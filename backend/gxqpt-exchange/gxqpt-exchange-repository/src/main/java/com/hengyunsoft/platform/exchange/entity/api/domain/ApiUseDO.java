package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
public class ApiUseDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "调用情况Id")
    private Long id;
    @ApiModelProperty(value = "调用Api单位")
    private String orgName;

    @ApiModelProperty(value = "授权期限")
    private Date limitTime;

    @ApiModelProperty(value = "调用时间")
    private Date visitTime;

    @ApiModelProperty(value = "交换数据量")
    private Integer dataCount;

    @ApiModelProperty(value = "调用时长")
    private Float rsponseTime;
}
