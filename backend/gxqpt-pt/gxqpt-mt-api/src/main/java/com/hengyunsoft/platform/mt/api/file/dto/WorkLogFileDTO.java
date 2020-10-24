package com.hengyunsoft.platform.mt.api.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogFileDTO implements Serializable{
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 日志主表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志主表id")
    private Long logId;
    /**
     * 详情
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "详情表id")
    private Long logDetailId;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    /**
     * 文件类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件路径")
    private String fileUrl;



    /**
     * 上传用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上传用户id")
    private Long userId;
}
