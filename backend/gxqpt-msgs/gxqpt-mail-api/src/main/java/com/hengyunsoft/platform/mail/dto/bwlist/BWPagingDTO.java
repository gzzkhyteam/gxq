package com.hengyunsoft.platform.mail.dto.bwlist;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjr
 * @date 2018/08/08
 */
@Data
@ApiModel(value = "BWPaging", description = "黑名单分页列表")
public class BWPagingDTO implements Serializable {
    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 地址值  比如：邮件地址、IP地
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址值  比如：邮件地址、IP地")
    private String value;
    /**
     * 当前账号  登录用户的账号
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前账号  登录用户的账号")
    private String currentEmail;
}
