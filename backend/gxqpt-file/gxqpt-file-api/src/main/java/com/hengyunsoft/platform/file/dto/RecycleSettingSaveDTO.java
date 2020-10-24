package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author madengbo
 * @create 2018-09-03 14:05
 * @desc
 * @Version 1.0
 **/
@Data
@ApiModel(value = "RecycleSettingSaveDTO", description = "云盘设置")
public class RecycleSettingSaveDTO {

    /**
     * 时间段：一个月，两个月。。。。半年
     *
     * @mbggenerated
     *
     */
    @ApiModelProperty(value = "时间段：1、一个月  2、两个月  3、三个月   。。。。  6、半年")
    private String timePeriod;

    /**
     * 分享保存时间结束后是否删除：1：删除   0：保存
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享保存时间结束后是否删除：1：删除   0：保存")
    private Boolean isDelete;
}
