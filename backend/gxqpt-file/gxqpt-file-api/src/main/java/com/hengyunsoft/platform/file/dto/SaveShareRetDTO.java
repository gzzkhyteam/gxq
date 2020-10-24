package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SaveShareRet", description = "分享返回值")
public class SaveShareRetDTO {
    /**
     * 分享链接
     */
    @ApiModelProperty(value = "分享链接")
    private String url;
    /**
     * 分享密码
     */
    @ApiModelProperty(value = "分享密码")
    private String sharePassword;
    /**
     * 分享有效期
     */
    @ApiModelProperty(value = "分享有效期")
    private String valid;
}
