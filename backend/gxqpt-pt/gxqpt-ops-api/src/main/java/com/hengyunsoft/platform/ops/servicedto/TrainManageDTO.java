package com.hengyunsoft.platform.ops.servicedto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "TrainManageDTO", description = "培训申请请求参数")
public class TrainManageDTO {
    /**
     * 培训id
     */
	@ApiModelProperty(value = "培训id,修改时候传")
    private Long id;
    /**
     * 培训类别
     */
	@ApiModelProperty(value = "培训类别")
    private String trainType;
    /**
     * 培训名称
     */
	@ApiModelProperty(value = "培训名称")
    private String trainName;
    /**
     * 培训地点
     */
	@ApiModelProperty(value = "培训地点")
    private String trainAddress;
    /**
     * 培训时间
     */
    @ApiModelProperty(value = "培训时间",required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date trainTime;
    /**
     * 培训内容
     */
	@ApiModelProperty(value = "培训内容")
    private String trainInfo;
    /**
     * 提交单位
     */
	@ApiModelProperty(value = "提交单位")
    private String company;
}
