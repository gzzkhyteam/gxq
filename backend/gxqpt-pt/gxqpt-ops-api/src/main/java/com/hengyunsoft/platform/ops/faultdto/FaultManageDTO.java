package com.hengyunsoft.platform.ops.faultdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class FaultManageDTO implements Serializable{

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date happenTime;

    @ApiModelProperty(value = "故障简述")
    private String faultInfo;


    @ApiModelProperty(value = "是否属实")
    private String isTrue;

    @ApiModelProperty(value = "处理意见")
    private String dealOpinion;

    @ApiModelProperty(value = "处理时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dealTime;

    @ApiModelProperty(value = "处理人")
    private String personName;
    @ApiModelProperty(value = "处理流程")
    private String dealProcess;

    @ApiModelProperty(value = "处理结果")
    private String result;


    @ApiModelProperty(value = "建议")
    private String advice;


    @ApiModelProperty(value = "是否加入知识库：1是2否")
    private Integer isJoinKnowledge;

    @ApiModelProperty(value = "创建人")
    private String  createUser;
    @ApiModelProperty(value = "更新人")
    private String  updateUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
