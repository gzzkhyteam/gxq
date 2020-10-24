package com.hengyunsoft.platform.ops.entity.train.dos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-07-16
 */
@Data
public class OperationFileDO implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务id")
    private Long bussId;

    /**
     *业务类型:服务报告(service_report)，2服务成果(service_result)，
     * 培训签到表(train_sign_in),培训反馈表(train_feedback),故障处理报告(fault_report)
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型")
    private String bussType;
    
    @ApiModelProperty(value = "文件id")
    private Long fileId;

    @ApiModelProperty(value = "文件名")
    private String fileName;


    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "文件类型")
    private String fileType;


    @ApiModelProperty(value = "文件路径")
    private String fileUrl;


    @ApiModelProperty(value = "上传时间")
    private Date createTime;

    @ApiModelProperty(value = "上传人")
    private Long userId;
}
