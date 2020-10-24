package com.hengyunsoft.platform.modular.dto;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2019-2-20
 */
@Data
@ApiModel(value = "ProviderInfomationPageDTO", description = "提供商分页对象")
public class ProviderInfomationPageDTO implements Serializable{

    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 提供商名称
     *
     * @mbggenerated
     */
    @FieldDesc("提供商名称")
    @ApiModelProperty(value = "提供商名称")
    @Length(max=100)
    private String name;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @FieldDesc("联系电话")
    @ApiModelProperty(value = "联系电话")
    @Length(max=20)
    private String phone;

    /**
     * 提供商简介
     *
     * @mbggenerated
     */
    @FieldDesc("提供商简介")
    @ApiModelProperty(value = "提供商简介")
    @Length(max=500)
    private String describle;

    /**
     * 提供商地址
     *
     * @mbggenerated
     */
    @FieldDesc("提供商地址")
    @ApiModelProperty(value = "提供商地址")
    @Length(max=500)
    private String address;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
