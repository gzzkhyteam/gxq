package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResourceDTO {


    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口
     *
     * @mbggenerated
     */
    private Short type;

    /**
     * 路径
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    private String target;

    /**
     * 状态    1、启用    2禁用
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * 序号
     *
     * @mbggenerated
     */
    private Integer orderNo;

    /**
     * 菜单图标
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    private String group;

    /**
     * 层级
     *
     * @mbggenerated
     */
    private String leve;

    /**
     * 父级菜单id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    private String appId;
    
    /**
     * 是否公有资源
     */
    private String publicIs;
    
    /**
     * 需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割  ， 公有资源不需要填写此项，填写了也不做过滤
     *
     * @mbggenerated
     */
    private String authUrls;
}