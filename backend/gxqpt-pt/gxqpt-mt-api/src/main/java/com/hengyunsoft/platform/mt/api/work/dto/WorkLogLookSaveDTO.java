package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-06-7
 */
@Data
public class WorkLogLookSaveDTO implements Serializable{

    @ApiModelProperty(value = " 主键")
    private Long id;
    /**
     * 查看人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查看人id")
    private Long userId;

    /**
     * 查看日志id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 查看日志id")
    private Long logId;

}
