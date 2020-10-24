package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集元数据
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：新增
 */
@Data
@ApiModel(value = " DataSetElement", description = "数据集元数据")
public class DataSetElementDTO {
    @ApiModelProperty(value = "字段id")
    private Long id;

    @ApiModelProperty(value = "字段名称(字段注释)")
    private String fieldName;

    @ApiModelProperty(value = "字段标识")
    private String fieldCode;

    @ApiModelProperty(value = "字段类型")
    private String fieldType;

    @ApiModelProperty(value = "字段长度,没有的话为null")
    private Integer precision;
    @ApiModelProperty(value = "小数长度,没有的话为null")
    private Integer scale;

    /***
     * 得到带长度的字段类型
     * @return
     */
    public String getHasLengthFieldType() {
        StringBuffer sb = new StringBuffer(fieldType);
        if (precision != null) {
            sb.append("(");
            sb.append(precision);
            if (scale != null) {
                sb.append(",");
                sb.append(scale);
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
