package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：Api列表展示数据
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
public class ShareDataApiListDO implements Serializable {
    @ApiModelProperty(value = "API id")
    private Long id;
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "api编码")
    private String apiCode;
    @ApiModelProperty(value = "API状态:1,启用；2，禁用")
    private Integer apiStatus;
    @ApiModelProperty(value = "api目录")
    private String dirName;
    @ApiModelProperty(value = "目录id")
    private String dirId;
    @ApiModelProperty(value = "目录数据类型:1,结构化数据；2，非结构化数据")
    private Integer dataType;
    @ApiModelProperty(value = " 审批状态:1,待审批；2，已驳回；3，审批通过")
    private Integer authStatus;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "单位Id")
    private String unitId;
    @ApiModelProperty(value = " 创建用户Id")
    private Long createUser;
    @ApiModelProperty(value = " 创建用户名")
    private String createUserName;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = "支持格式:1,json;2,xml")
    private Integer dataFmat;
    @ApiModelProperty(value = "API访问地址")
    private String apiUrl;
}
