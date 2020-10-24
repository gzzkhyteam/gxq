package com.hengyunsoft.platform.admin.api.authority.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 帐号信息
 */
@Data
@ApiModel(value = "account", description = "帐号信息")
public class AccountDTO implements Serializable{
    /**  */
    private Long userId;
    /**  */
    private String appId;
    /**  */
    private String name;
    /**  */
    private String photo;
    
    private String account;
}
