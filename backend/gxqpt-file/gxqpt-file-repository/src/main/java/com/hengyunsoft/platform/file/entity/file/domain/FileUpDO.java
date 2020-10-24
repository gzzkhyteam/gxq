package com.hengyunsoft.platform.file.entity.file.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjr
 * @date 2018/09/06
 */
@Data
public class FileUpDO implements Serializable {

    /**
     * 上传时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "初始时间")
    private String upTime;

    /**
     * 上传大小
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享次数")
    private String size;

}
