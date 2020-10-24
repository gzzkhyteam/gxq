package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：资源树形Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class ResourceTreeDto extends TreeNode<ResourceTreeDto,Long> implements Serializable {

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源路径")
    private String url;

    @ApiModelProperty(value = "资源图标")
    private String icon;

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源编码")
    private String code;

    /**
     * 资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口")
    private Short type;

    /**
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走")
    private String target;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;


    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "菜单分组")
    private String group;
    
    @ApiModelProperty(value = "是否公有资源")
    private String publicIs;

}
