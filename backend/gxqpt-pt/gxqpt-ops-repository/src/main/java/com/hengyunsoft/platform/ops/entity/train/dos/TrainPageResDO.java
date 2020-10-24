package com.hengyunsoft.platform.ops.entity.train.dos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainPageResDTO", description = "培训分页列表返回参数")
public class TrainPageResDO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "培训记录id")
    private Long id;
    @ApiModelProperty(value = "培训名称")
    private String name;
    @ApiModelProperty(value = "培训类别")
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "培训时间")
    private Date trainTime;
    @ApiModelProperty(value = "培训状态")
    private Integer status;
    @ApiModelProperty(value = "培训评分")
    private Long trainSorce;
    @ApiModelProperty(value = "文件信息")
    private List<OperationFileDO> files;
    @ApiModelProperty(value = "培训内容")
    private String context;
    @ApiModelProperty(value = "培训地点")
    private String trainAddress;
    @ApiModelProperty(value = "申请单位")
    private String company;
    @ApiModelProperty(value = "申请编号",required = false)
    private String applyCode;
}
