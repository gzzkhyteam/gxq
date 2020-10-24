package com.hengyunsoft.platform.exchange.api.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DirViewDTO {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "目录名称")
    private String dirName;
    @ApiModelProperty(value = "数据集Id")
    private Long setId;
    @ApiModelProperty(value = "目录编码")
    private String dirCode;
    @ApiModelProperty(value = "访问次数")
    private Integer seeCount;
    @ApiModelProperty(value = "下载次数")
    private Integer downCount;
    @ApiModelProperty(value = "数据类型:1,结构化数据；2，非结构化数据")
    private Integer dataType;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "主题小类")
    private String themeThreeName;
    @ApiModelProperty(value = "行业小类")
    private String industryThreeName;
    @ApiModelProperty(value = "服务小类")
    private String serviceThreeName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "领域分类")
    private String domainName;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "目录描述")
    private String desc;
    @ApiModelProperty(value = "数据量")
    private Integer dataCount;
    @ApiModelProperty(value = "开放方式:1,开发；2，不开放")
    private Integer openWay;
    @ApiModelProperty(value = "共享方式:1,共享；2，有条件共享；3，不共享")
    private Integer shareWay;
    @ApiModelProperty(value = "数据集审批是否通过")
    private Boolean dataSetIsAudio;
    @ApiModelProperty(value = "当前访问单位Id")
    private String loginUnitId;
    @ApiModelProperty(value = "目录所属单位Id")
    private String unitId;
    @ApiModelProperty(value = "当前登录单位是否共享单位")
    private Integer shareUnit;

}
