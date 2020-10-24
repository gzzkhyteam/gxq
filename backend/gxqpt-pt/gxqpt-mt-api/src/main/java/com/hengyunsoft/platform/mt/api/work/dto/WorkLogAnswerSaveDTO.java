package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-06-7
 */
@Data
public class WorkLogAnswerSaveDTO implements Serializable{

    @ApiModelProperty(value = " 主键")
    private Long id;

    /**
     * 工作日志id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 工作日志id")
    private Long workLogId;

    /**
     * 回复人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 回复人id")
    private Long userId;

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "回复内容")
    private String content;


}
