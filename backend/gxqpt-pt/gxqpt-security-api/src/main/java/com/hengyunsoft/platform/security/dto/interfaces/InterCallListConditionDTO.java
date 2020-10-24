package com.hengyunsoft.platform.security.dto.interfaces;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-09-05 16:57
 * @desc 接口调用查询条件
 **/
@Data
@ApiModel
public class InterCallListConditionDTO {
    @ApiModelProperty(value = "起始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    @ApiModelProperty(value ="用户名称" )
    private String userName;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "应用id")
    private String appId;
}