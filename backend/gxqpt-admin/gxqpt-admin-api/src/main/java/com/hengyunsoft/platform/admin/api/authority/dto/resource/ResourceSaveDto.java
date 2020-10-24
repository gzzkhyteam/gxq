package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：新增资源dto
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
@ApiModel(value = "ResourceSave", description = "新增资源")
public class ResourceSaveDto {
    @ApiModelProperty(value = "资源名称")
    private String name;

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

    @ApiModelProperty(value = "开发者ID")
    private String appId;
    
    @ApiModelProperty(value = "是否公有资源")
    private String publicIs;
    
    @ApiModelProperty(value = "需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割  ， 公有资源不需要填写此项，填写了也不做过滤")
    private String authUrls;

}
