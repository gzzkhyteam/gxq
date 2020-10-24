package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
public class ShareDataApiUserListDO {
    @ApiModelProperty(value = "共享申请 id")
    private Long id;
    @ApiModelProperty(value = "api id")
    private Long apiId;

    @ApiModelProperty(value = "API名称")
    private String apiName;

    @ApiModelProperty(value = "api编码")
    private String apiCode;

    @ApiModelProperty(value = "目录名")
    private String dirName;

    @ApiModelProperty(value = "使用次数")
    private Integer useNum;

    @ApiModelProperty(value = "api类型")
    private Integer apiType;

    @ApiModelProperty(value = "申请编码")
    private String applyCode;

    @ApiModelProperty(value = "API状态:1,启用；2，禁用")
    private Integer apiStatus;

    @ApiModelProperty(value = "授权有效期限")
    private Date limitTime;

    @ApiModelProperty(value = "状态:1,通过；2，驳回")
    private Integer status;

    @ApiModelProperty(value = "反馈意见")
    private String content;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "提供单位名称")
    private String provideUnitName;

    @ApiModelProperty(value = " 创建用户Id")
    private Long createUser;
    @ApiModelProperty(value = " 创建用户名")
    private String createUserName;

    @ApiModelProperty(value = "是否订阅（1：是，2：否）")
    private Integer isTake;

    @ApiModelProperty(value = "目录类型1,结构化数据；2，非结构化数据")
    private Integer dataType;
}
