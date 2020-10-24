package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 定时邮件删除请求
 *
 * @auth wt
 * @date 2018/07/30
 */
@Data
@ApiModel(value = "RequestTimeSendDelete", description = "定时邮件删除请求")
public class RequestTimeSendDeleteDTO {

    /**
     * 删除ID集合
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "删除ID集合")
    private List<Long> data;


}
