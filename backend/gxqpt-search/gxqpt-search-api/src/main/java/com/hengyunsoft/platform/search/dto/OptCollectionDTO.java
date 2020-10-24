package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：
 */
@Data
@ApiModel(value = "OptClollection", description = "集合显示信息")
public class OptCollectionDTO {
    @ApiModelProperty(value = "id")
    private long id;
    @ApiModelProperty(value = "集合id")
    private long collectionId;
    @ApiModelProperty(value = "appID")
    private String appId;
    @ApiModelProperty(value = "appID名称")
    private String appName;
    @ApiModelProperty(value = "集合名词")
    private String collectionName;
    @ApiModelProperty(value = "集合编码")
    private String collectionCode;
    @ApiModelProperty(value = "创建该集合的appid")
    private String createAppId;
    @ApiModelProperty(value = "创建该集合的应用名称")
    private String createAppName;
    @ApiModelProperty(value = "创建该的用户id")
    private long userId;
    @ApiModelProperty(value = "该app拥有的该集合的权限权限")
    private int opt;
}
