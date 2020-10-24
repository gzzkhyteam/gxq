package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述:查询消费的功能实体
 * @author chb
 * @date 2018/4/4 10:45 
 */
@Data
@ApiModel(value = "AssignServiceModuleRet", description = "模块功能申请")
public class AssignServiceModuleRetDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String logo;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能名称")
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能编码")
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能描述")
    private String desc;

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用")
    private Short status;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态： 1启用   2禁用")
    private Boolean assignStatus;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人邮箱")
    private String email;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块类型")
    private String moduleType;

    /**
     * 模块类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块类型名称")
    private String moduleTypeName;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否公有模块")
    private Boolean publicIs;

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否公开模块")
    private Boolean publicLook;

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API接口文档地址")
    private String apiSyncUrl;

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源数量")
    private Integer resourceNum;

    /**
     * 停用日期（停止使用/维护日期）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停用日期")
    private Date stopTime;

    /**
     * 建议使用模块
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "建议使用模块")
    private Long adviceModule;

    private static final long serialVersionUID = 1L;
}
