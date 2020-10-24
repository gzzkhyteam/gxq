package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：需求列表DO
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
public class ShareDataDemandListDO {
    @ApiModelProperty(value = "申请Id")
    private Long id;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "申请编码")
    private String applyCode;

    @ApiModelProperty(value = "单位类型")
    private String unitType;

    @ApiModelProperty(value = "联系人姓名")
    private String contName;

    @ApiModelProperty(value = "联系人电话")
    private String contTel;

    @ApiModelProperty(value = "联系人邮箱")
    private String contEmail;

    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;

    @ApiModelProperty(value = "需求内容")
    private String content;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "申请原因")
    private String applyReason;

    @ApiModelProperty(value = "处理单位名称")
    private String hdOrgName;

    @ApiModelProperty(value = "申请时间")
    private Date createTime;

    @ApiModelProperty(value = "处理状态(1,待审批；2，已驳回；3，通过，待封装API；4，已封装API)")
    private Integer status;

    @ApiModelProperty(value = "处理意见")
    private String hdContent;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "apiId")
    private Long apiId;

}
