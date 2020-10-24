package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集管理分页查询返回元素
 * 修改人：gbl
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryDataSetParamEle", description = "数据集管理分页查询返回元素")
public class QueryDataSetResEleDTO {
    @ApiModelProperty(value = "流程taskId")
    private Long taskId;

    @ApiModelProperty(value = "数据集id")
    private Long id;

    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    @ApiModelProperty(value = "申请类型 1：新增，2修改")
    private int applyType;

    @ApiModelProperty(value = "是否可以删除")
    private int canDelete;

    @ApiModelProperty(value = "数据集名称")
    private String setName;

    @ApiModelProperty(value = "数据集标识")
    private String setCode;

    @ApiModelProperty(value = "数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    private Integer setType;

    @ApiModelProperty(value = "数据集大小")
    private Float dataCount;

    @ApiModelProperty(value = "更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年")
    private Integer updateRate;

    @ApiModelProperty(value = "创建理由")
    private String reason;

    @ApiModelProperty(value = "状态:-1，暂存 1，审批中；2，驳回；3，已上架；4，已下架")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createUserName;

    @ApiModelProperty(value = "关联目录数")
    private Integer relatedDicCunt;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "处理意见")
    private String dealContext;
}
