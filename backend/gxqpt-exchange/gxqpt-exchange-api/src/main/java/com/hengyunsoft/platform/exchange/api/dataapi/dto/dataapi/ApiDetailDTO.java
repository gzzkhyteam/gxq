package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api基础信息
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiDetail", description = "API基础信息")
public class ApiDetailDTO {
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

    @ApiModelProperty(value = "查询字段列表")
    private List<ApiElementBaseDTO> elementList;

    @ApiModelProperty(value = "过滤条件列表")
    private List<ApiFilterBaseDTO> filterList;

    @ApiModelProperty(value = "数据集Id")
    private Long setId;
    @ApiModelProperty(value = "api所属单位Id")
    private Long unitId;
   @ApiModelProperty(value = "是否共享单位 1：是，0：否")
    private Integer shareUnit;
    @ApiModelProperty(value = "开放方式:1,开放；2，不开放")
    private Integer openWay;
    @ApiModelProperty(value = "共享方式:1,共享；2，有条件共享；3，不共享")
    private Integer shareWay;
    @ApiModelProperty(value = "当前登录用户Id")
    private String loginUnitId;


}
