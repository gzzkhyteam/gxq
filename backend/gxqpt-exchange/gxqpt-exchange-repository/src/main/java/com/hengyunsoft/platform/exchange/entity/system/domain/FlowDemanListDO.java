package com.hengyunsoft.platform.exchange.entity.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.system.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
public class FlowDemanListDO {
    @ApiModelProperty(value = "流程taskId")
    private Long id;

    @ApiModelProperty(value = "申请编码")
    private String applyCode;

    @ApiModelProperty(value = "需求Id")
    private Long demandId;

    @ApiModelProperty(value = "apiId")
    private Long apiId;

    @ApiModelProperty(value = "单位名称")
    private String name;
    
    @ApiModelProperty(value = "单位类型")
    private String unitType;
    
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    
    @ApiModelProperty(value = "联系人姓名")
    private String contName;
    
    @ApiModelProperty(value = "联系人电话")
    private String contTel;
    
    @ApiModelProperty(value = "联系人邮箱")
    private String contEmail;
    
    @ApiModelProperty(value = "申请时间")
    private Date createTime;
    
    @ApiModelProperty(value = "需求内容")
    private String content;
    
    @ApiModelProperty(value = "用途")
    private String purpose;
    
    @ApiModelProperty(value = "申请原因")
    private String applyReason;
    
    @ApiModelProperty(value = "处理状态名称")
    private String hdStatus;
    
    @ApiModelProperty(value = "处理状态，用于操作按钮的判断（1,待审批；2，已驳回；3，通过，待封装API；4，已封装API）")
    private Integer status;
}
