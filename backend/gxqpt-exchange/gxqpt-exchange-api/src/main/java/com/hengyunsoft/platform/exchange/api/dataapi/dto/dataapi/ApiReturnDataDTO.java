package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：API列表查询条件
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiReturnData", description = "API列表查询条件")
public class ApiReturnDataDTO {
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
    @ApiModelProperty(value = "目录数据类型:1,结构化数据；2，非结构化数据")
    private Integer dataType;
    @ApiModelProperty(value = " 审批状态:1,待审批；2，已驳回；3，审批通过")
    private Integer authStatus;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = " 创建用户Id")
    private Long createUser;
    @ApiModelProperty(value = " 创建用户名")
    private String createUserName;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = "目录id")
    private String dirId;
}
