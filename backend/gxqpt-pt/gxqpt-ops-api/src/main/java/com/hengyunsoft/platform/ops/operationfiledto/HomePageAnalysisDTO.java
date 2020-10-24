package com.hengyunsoft.platform.ops.operationfiledto;

import com.hengyunsoft.platform.ops.faultdto.HomePageReportTopDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author tianai
 * @createTime 2018-08-11
 */
@Data
public class HomePageAnalysisDTO implements Serializable{

    @ApiModelProperty(value = "总运维人数")
    private String operationPerson;
    @ApiModelProperty(value = "总故障数")
    private Integer faultCount;
    @ApiModelProperty(value = "本月故障数")
    private Integer monthFaultCount;
    @ApiModelProperty(value = "总运维服务次数")
    private Integer operationServiceCount;
    @ApiModelProperty(value = "本月运维服务次数")
    private Integer monthOperationServiceCount;
    @ApiModelProperty(value = "总培训次数")
    private Integer trainCount;
    @ApiModelProperty(value = "本月培训次数")
    private Integer monthTrainCount;

    @ApiModelProperty(value = "本年运维服务数量")
    private Map<String, Object> yearServiceMap ;

    @ApiModelProperty(value = "本年故障处理数量")
    private Map<String, Object> yearFaultMap ;

    @ApiModelProperty(value = "故障分析")
    private List<HomePageReportTopDTO>  dtoList;

}
