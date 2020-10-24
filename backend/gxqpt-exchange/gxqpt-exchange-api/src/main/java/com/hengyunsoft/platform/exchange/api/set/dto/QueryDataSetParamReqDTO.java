package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集管理分页查询参数
 * 修改人：gbl
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryDataSetParamReq", description = "数据集管理分页查询参数")
public class QueryDataSetParamReqDTO {
    @ApiModelProperty(value = "数据集名称")
    protected String setName;
    @ApiModelProperty(value = "数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    protected Integer setType;
    @ApiModelProperty(value = "状态:1，审批中；2，驳回；3，已上架；4，已下架")
    private Integer status;
    @ApiModelProperty(value = "创建人名称")
    private String createUserName;
    @ApiModelProperty(value = "申请类型，1新增，2修改")
    private Integer applyType;
    @ApiModelProperty(value = "申请开始时间")
    private Date startTime;
    @ApiModelProperty(value = "申请结束时间")
    private Date endTime;
    @ApiModelProperty(value = "目录名称")
    private  String dirName;
}

