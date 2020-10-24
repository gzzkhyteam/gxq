package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建数据库数据集第一步返回内容
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDSPdbFirstRes", description = "创建数据库数据集第一步返回内容")
public class CreateDSPdbFirstResDTO {
    @ApiModelProperty(value = "数据集id")
    private Long id;
    @ApiModelProperty(value = "所有的表信息")
    protected List<DatabaseTableDTO> allTable = new ArrayList<>();
    @ApiModelProperty(value = "表名标识")
    private String tableCode;

  /*  @ApiModelProperty(value = "创建数据集方式:1,选择字段;2,sql查询")
    private Integer setMode;



    @ApiModelProperty(value = "数据类型:1,字段选择；2，SQL语句")
    private Integer dataType;

    @ApiModelProperty(value = "返回的字段名称列表")
    private List<String> resultFileName;

    @ApiModelProperty(value = "SQL语句")
    private String sqlCode;*/

}
