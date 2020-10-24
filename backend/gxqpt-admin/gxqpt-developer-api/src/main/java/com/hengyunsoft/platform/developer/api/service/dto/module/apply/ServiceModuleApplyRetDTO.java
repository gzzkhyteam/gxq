package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能申请管理dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/2
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceModuleApplyRet", description = "新增模块功能申请返回")
public class ServiceModuleApplyRetDTO {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "图标")
    private String logo;

    @ApiModelProperty(value = "功能名称")
    private String name;

    @ApiModelProperty(value = "功能编码")
    private String code;

    @ApiModelProperty(value = "功能描述")
    private String desc;

    @ApiModelProperty(value = "状态： 1、正常使用中   10、已过时（有新版本取代）   20、停止使用")
    private Short status;

    @ApiModelProperty(value = "联系人邮箱")
    private String email;

    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    @ApiModelProperty(value = "模块类型")
    private String moduleType;

    @ApiModelProperty(value = "是否公有模块 所有人可调用(无需申请)")
    private Boolean publicIs;

    @ApiModelProperty(value = "是否公开模块   需要登陆才可以看到。")
    private Boolean publicLook;

    @ApiModelProperty(value = "API接口文档地址")
    private String apiSyncUrl;

    @ApiModelProperty(value = "资源数量（接口数量）")
    private Integer resourceNum;

    @ApiModelProperty(value = "停用日期（停止使用/维护日期）")
    private Date stopTime;

    @ApiModelProperty(value = "建议使用模块")
    private Long adviceModule;

    @ApiModelProperty(value = "申请备注")
    private String applyDesc;
    
    @ApiModelProperty("使用此服务，可以节省多少工期（人/天）")
    private Double reduceTime;

    @ApiModelProperty("使用此服务，可以节省多少成本（元）")
    private Integer reduceCost;

   /* @ApiModelProperty(value = "申请状态： 1、待审核     11、已通过      21、被拒绝")
    private Short applyStatus;*/

   /* @ApiModelProperty(value = "申请人")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyUserName;

    @ApiModelProperty(value = "审批人")
    private Long auditUser;

    @ApiModelProperty(value = "审批人名称")
    private String auditUserName;

    @ApiModelProperty(value = "审批备注")
    private String auditDesc;

    @ApiModelProperty(value = "申请成功的模块id")
    private Long successPassModuleId;*/

}
