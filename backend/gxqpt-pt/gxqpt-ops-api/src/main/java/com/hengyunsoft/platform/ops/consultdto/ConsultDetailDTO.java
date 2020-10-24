package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by kevin on 2018/7/17.
 */
@Data
@ApiModel(value = "ConsultDetail", description = "咨询详情")
public class ConsultDetailDTO implements Serializable{

    @ApiModelProperty(value = "咨询名称")
    private String consultName;

    @ApiModelProperty(value = "咨询时间")
    private Date consultTime;

    @ApiModelProperty(value = "咨询内容")
    private String consultInfo;



    @ApiModelProperty(value = "处理结果")
    private String dealResult;

    @ApiModelProperty(value = "处理意见")
    private String dealOpinion;

    @ApiModelProperty(value = "咨询人")
    private String consultPerson;

    @ApiModelProperty(value = "职位")
    private String job;

    @ApiModelProperty(value = "联系方式")
    private String tel;

    @ApiModelProperty(value = "主要工作内容")
    private String workInfo;

    @ApiModelProperty(value = "协助人")
    private List<String> helpPerson;



    @ApiModelProperty(value = "服务态度")
    private Long serviceAttitude;

    @ApiModelProperty(value = "服务效率")
    private Long serviceEfficiency;

    @ApiModelProperty(value = "服务质量")
    private Long serviceQuality;

    @ApiModelProperty(value = "咨询建议")
    private String consultAdvice;

}
