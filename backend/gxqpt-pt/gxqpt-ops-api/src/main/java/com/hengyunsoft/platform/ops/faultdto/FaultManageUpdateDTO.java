package com.hengyunsoft.platform.ops.faultdto;

import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class FaultManageUpdateDTO implements Serializable{

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "故障类别")
    private String faultType;

    @ApiModelProperty(value = "故障级别")
    private String faultLevel;

    @ApiModelProperty(value = "状态:1未处理2c处理中3已完结")
    private Integer status;

    @ApiModelProperty(value = "故障简述")
    private String faultInfo;

    @ApiModelProperty(value = " 是否属实1属实2不属实")
    private String isTrue;

    @ApiModelProperty(value = "处理意见")
    private String dealOpinion;

    @ApiModelProperty(value = "处理时间")
    private Date dealTime;


    @ApiModelProperty(value = "处理流程")
    private String dealProcess;

    @ApiModelProperty(value = "处理结果")
    private String result;


    @ApiModelProperty(value = "建议")
    private String advice;


    @ApiModelProperty(value = "是否加入知识库")
    private Integer isJoinKnowledge;

    @ApiModelProperty(value = "附件")
    private List<OperationFileDTO> fileList;
}
