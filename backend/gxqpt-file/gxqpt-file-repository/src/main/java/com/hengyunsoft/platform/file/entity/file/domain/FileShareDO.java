package com.hengyunsoft.platform.file.entity.file.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zjr
 * @date 2018/09/06
 */
@Data
public class FileShareDO implements Serializable {

    /**
     * 分享时间时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "初始时间")
    private String shareTime;

    /**
     * 分享次数
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享次数")
    private Integer count;

}
