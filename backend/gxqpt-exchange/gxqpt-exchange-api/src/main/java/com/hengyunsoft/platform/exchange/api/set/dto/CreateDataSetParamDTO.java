package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/4/21
 * 修改内容：创建数据集参数
 */
@Data
@ApiModel(value = "CreateDataSetParam", description = "创建数据集参数")
public class CreateDataSetParamDTO {
    @ApiModelProperty(value = "编辑类型,1新增，2编辑，3详情")
    private Integer editType;
    @ApiModelProperty(value = "主键,编辑有id，新增无id")
    private Long id;
    @ApiModelProperty(value = "数据集名称")
    protected String setName;

    @ApiModelProperty(value = "数据集标识")
    protected String setCode;

    @ApiModelProperty(value = "数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    protected Integer setType;

    @ApiModelProperty(value = "更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年")
    protected Integer updateRate;

    @ApiModelProperty(value = "创建理由")
    protected String reason;


}
