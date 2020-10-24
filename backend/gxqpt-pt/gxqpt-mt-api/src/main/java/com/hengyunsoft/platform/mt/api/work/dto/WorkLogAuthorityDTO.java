package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogAuthorityDTO implements Serializable{

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 查看人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查看人id")
    private Long userId;

    /**
     * 被查看人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "被查看人id")
    private Long beViewedUser;

}
