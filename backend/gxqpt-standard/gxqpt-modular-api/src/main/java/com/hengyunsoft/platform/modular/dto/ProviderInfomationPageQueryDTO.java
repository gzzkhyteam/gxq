package com.hengyunsoft.platform.modular.dto;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2019-2-20
 */
@Data
@ApiModel(value = "ProviderInfomationPageQueryDTO", description = "提供商分页对象")
public class ProviderInfomationPageQueryDTO implements Serializable{

    /**
     * 提供商名称
     *
     * @mbggenerated
     */
    @FieldDesc("提供商名称")
    @ApiModelProperty(value = "提供商名称")
    @Length(max=100)
    private String name;


}
