package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjr
 * @date 2018/09/06
 */
@Data
public class FileDownDTO implements Serializable {

    /**
     * 文件原始名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件原始名称")
    private String fileName;

    /**
     * 分享者
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享者")
    private String userName;

}
