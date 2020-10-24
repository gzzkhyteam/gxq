package com.hengyunsoft.platform.ops.servicedto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainPageReqDTO", description = "培训分页列表请求参数")
public class TrainPageReqDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间" ,required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "截止时间",required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "培训类别")
    private String type;
    @ApiModelProperty(value = "培训名称")
    private String name;
    @ApiModelProperty(value = "培训内容")
    private String context;
    @ApiModelProperty(value = "培训地点")
    private String trainAddress;
    @ApiModelProperty(value = "培训状态")
    private Integer status;
    @ApiModelProperty(value = "创建人，不用传")
    private Long createUser;
    @ApiModelProperty(value = "申请编号" ,required = false)
    private String applyCode;
}
