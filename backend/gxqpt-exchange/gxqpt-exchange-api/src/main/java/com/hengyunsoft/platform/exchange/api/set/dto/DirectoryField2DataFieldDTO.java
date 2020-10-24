package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：目录字段对应数据集字段
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = "DirectoryField2DataField", description = "目录字段对应数据集字段")
public class DirectoryField2DataFieldDTO {
    @ApiModelProperty(value = "目录字段ID")
    private long id;
    @ApiModelProperty(value = "目录字段标识")
    private String fieldCode;
    @ApiModelProperty(value = "字段类型")
    private String fieldType;
    @ApiModelProperty(value = "字段名称")
    private String fieldName;
    @ApiModelProperty(value = "数据字段标识")
    private String setField;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DirectoryField2DataFieldDTO that = (DirectoryField2DataFieldDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
