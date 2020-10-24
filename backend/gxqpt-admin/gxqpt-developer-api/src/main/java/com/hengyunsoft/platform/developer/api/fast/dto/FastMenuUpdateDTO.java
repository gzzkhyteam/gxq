package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用分页
 **/
@Data
@ApiModel(value = "FastApplication",description = "快速应用分页")
public class FastMenuUpdateDTO implements Serializable{
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "配置ID")
    private Long bFastBizConfig;

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "功能描述")
    private String desc;

    @ApiModelProperty(value = "资源编码")
    private String code;

    @ApiModelProperty(value = "资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口")
    private Short type;

    @ApiModelProperty(value = "路径")
    private String url;

    @ApiModelProperty(value = "打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走")
    private String target;

    @ApiModelProperty(value = "状态    1、启用    2禁用")
    private Short status;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单分组")
    private String group;

    @ApiModelProperty(value = "父级菜单id")
    private Long parentId;

}