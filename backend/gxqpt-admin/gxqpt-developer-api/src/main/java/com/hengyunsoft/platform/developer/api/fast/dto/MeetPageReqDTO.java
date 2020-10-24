package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenxiaoyuan
 * @create 2018-05-08
 * @desc 会议管理分页
 **/
@Data
@ApiModel(value = "Meet",description = "会议管理分页")
public class MeetPageReqDTO implements Serializable{
    @ApiModelProperty(value = "应用id")
    private String appId;
    @ApiModelProperty(value = "会议名称")
    private String name;
    @ApiModelProperty(value = "会议状态")
    private Short meetStatus;
    @ApiModelProperty(value = "参会状态")
    private Short joinStatus;
}