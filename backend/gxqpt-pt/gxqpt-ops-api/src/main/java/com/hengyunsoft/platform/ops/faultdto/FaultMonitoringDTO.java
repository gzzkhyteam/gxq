package com.hengyunsoft.platform.ops.faultdto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@ApiModel
public class FaultMonitoringDTO implements Serializable{

    @ApiModelProperty(value = "无故障持续时间")
    private Long time;//相差多少小时

    @ApiModelProperty(value = "未处理故障数")
    private Integer unhandledFault;

    @ApiModelProperty(value = "故障处理平均时长")
    private Integer averageTime;

    @ApiModelProperty(value = "平均每日故障数")
    private String dayFaults;
    @ApiModelProperty(value = "年统计故障数")
    private Map<String, Object> map ;
    @ApiModelProperty(value = "故障数TOP5")
    private List<ReportTopDTO> reportTopDTOList;

}
