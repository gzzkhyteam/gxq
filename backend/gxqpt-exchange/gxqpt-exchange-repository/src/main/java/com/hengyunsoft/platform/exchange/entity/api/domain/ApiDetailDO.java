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
public class ApiDetailDO {
    @ApiModelProperty(value = "API id")
    private String id;
    @ApiModelProperty(value = "API名称")
    private String apiName;

    @ApiModelProperty(value = "api编码")
    private String apiCode;
    @ApiModelProperty(value = "api描述")
    private String apiDesc;

    @ApiModelProperty(value = "API访问地址")
    private String apiUrl;

    @ApiModelProperty(value = "支持格式（1,json;2,xml）")
    private String dataFmat;

    @ApiModelProperty(value = "创建人")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "数据集Id")
    private Long setId;
    @ApiModelProperty(value = "api所属单位Id")
    private Long unitId;
    @ApiModelProperty(value = "登录用户单位Id")
    private Long loginUnitId;
    @ApiModelProperty(value = "开放方式:1,开放；2，不开放")
    private Integer openWay;
    @ApiModelProperty(value = "共享方式:1,共享；2，有条件共享；3，不共享")
    private Integer shareWay;

}
