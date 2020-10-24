package com.hengyunsoft.platform.developer.api.core.dto.application;

import org.hibernate.validator.constraints.Length;

import com.hengyunsoft.validator.annotation.FieldDesc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：应用展示数据
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class AppShowDto {
    @ApiModelProperty(value = "应用Id")
    private String appId;

    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用描述")
    private String desc;
    @ApiModelProperty(value = "应用首页链接")
    private String indexUrl;
    @ApiModelProperty(value = "应用编码")
    private String code;
    
    @ApiModelProperty("服务注册中心的唯一标示")
    private String serviceId;
}
