package com.hengyunsoft.platform.ops.servicedto;

import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "TrainDetailDTO", description = "培训详情")
public class TrainDetailDTO {
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
    @ApiModelProperty(value = "培训时间")
    private Date trainTime;
    /**
     * 培训内容
     */
    @ApiModelProperty(value = "培训内容")
    private String trainInfo;
    /**
     * 状态 1=申请;2=驳回；3=同意4=驳回后申请;5=完结
     */
    @ApiModelProperty(value = "状态  1=申请;2=驳回；3=同意4=驳回后申请;5=完结")
    private Integer status;
    /**
     * 培训评分
     */
    @ApiModelProperty(value = "培训评分")
    private Long trainSorce;
    /**
     * 培训意见
     */
    @ApiModelProperty(value = "培训意见")
    private String trainAdvice;
    /**
     * 处理意见
     */
    @ApiModelProperty(value = "处理意见")
    private String dealOpinion;
    /**
     * 培训人姓名
     */
    @ApiModelProperty(value = "培训人姓名")
    private String personName;
    /**
     * 培训人职位
     */
    @ApiModelProperty(value = "培训人职位")
    private String position;
    /**
     * 培训人联系方式
     */
    @ApiModelProperty(value = "培训人联系方式")
    private String contact;
    /**
     * 培训人主要工作内容
     */
    @ApiModelProperty(value = "培训人主要工作内容")
    private String job;   
    /**
     * 协助人
     */
    @ApiModelProperty(value = "协助人")
    private String assistant;

    @ApiModelProperty(value = "附件")
    private List<OperationFileDTO> files;
}
