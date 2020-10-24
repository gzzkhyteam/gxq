package com.hengyunsoft.platform.ops.faultdto;

import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.persondto.ChargeSystemDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-07-17
 */
@Data
public class FaultMangeDetailDTO implements Serializable{


    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "故障名称")
    private String faultName;


    @ApiModelProperty(value = "故障类别")
    private String faultType;

    @ApiModelProperty(value = "故障级别")
    private String faultLevel;

    @ApiModelProperty(value = "系统id")
    private String systemId;

    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "故障主机")
    private String faultHost;

    @ApiModelProperty(value = "状态:1未处理2c处理中3已完结")
    private Integer status;

    @ApiModelProperty(value = "产生时间")
    private Date happenTime;

    @ApiModelProperty(value = "故障简述")
    private String faultInfo;


    @ApiModelProperty(value = "是否属实")
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

    @ApiModelProperty(value = "处理人")
    private String dealUser;
    @ApiModelProperty(value = "所属职务名称")
    private String maindutyname;

    @ApiModelProperty(value = "手机")
    private String mainmobile;
    @ApiModelProperty(value = "主要工作内容")
    private String  content;
    @ApiModelProperty(value = "主要负责系统")
    private List<ChargeSystemDTO> chargeSystemDTOS;
    @ApiModelProperty(value = "协助人")
    private String assistant;


}
