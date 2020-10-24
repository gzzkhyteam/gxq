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
@ApiModel(value = "RecycleSetting", description = "云盘设置")
public class RecycleSettingDTO {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 时间段：一个月，两个月。。。。半年
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "时间段：一个月，两个月。。。。半年")
    private String timePeriod;

    /**
     * 分享保存时间结束后是否删除：1：删除   0：保存
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享保存时间结束后是否删除：1：删除   0：保存")
    private Boolean isDelete;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改人")
    private Long updateUser;
}
