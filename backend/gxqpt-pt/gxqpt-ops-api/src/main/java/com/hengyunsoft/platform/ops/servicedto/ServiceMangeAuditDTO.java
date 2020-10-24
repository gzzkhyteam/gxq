package com.hengyunsoft.platform.ops.servicedto;

import com.hengyunsoft.platform.ops.consultdto.DealUserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-07-19
 */
@Data
public class ServiceMangeAuditDTO implements Serializable{

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "结果")
    private String result;

    @ApiModelProperty(value = "审批意见")
    private String auditOpinion;


    @ApiModelProperty(value = "状态:1未处理，2已驳回,3已同意4已完结")
    private Integer status;


    @ApiModelProperty(value = "服务态度")
    private Long serviceAttitude;


    @ApiModelProperty(value = "服务效率")
    private Long serviceEfficiency;

    @ApiModelProperty(value = "服务评价")
    private Long serviceEvaluation;

    @ApiModelProperty(value = "评分")
    private Long score;

    @ApiModelProperty(value = "服务建议")
    private String serviceAdvice;

    @ApiModelProperty(value = "处理人")
    private DealUserDTO  dealUserDTO ;

    @ApiModelProperty(value = "协助人")
    private List<DealUserDTO> userNames;
}
