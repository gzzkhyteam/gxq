package com.hengyunsoft.platform.warn.api.warn.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 预警信息对象
 * @author zjr
 */
@Data
@ApiModel(value = "WarnMessage", description = "预警信息对象")
public class WarnMessageDTO implements Serializable {
    /**
     * 预警标题
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警标题" )
    private String title;
    /**
     * 预警内容
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警内容")
    private String content;
    /**
     * 预警类型id
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型id")
    private Long typeId;
    /**
     * 预警类型
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型")
    private String type;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
    /**
     * 预警责任信息,json格式[{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"},{"bizId":"xxx","bizType":"xxx","name":"xxx","dutyType":"xxx","appId":"xxx","appName":"xxx","appType":"xxx","userId":"xxx","empName":"xxx",
     * "departmentId":"xxx","departmentName":"xxx","orgId":"xxx","orgName":"xxx"}]
     * 数组形式
     */
    @ApiModelProperty(value = "预警责任信息")
    private List<DutyDTO> duty;
    /**
     * 预警确认人信息,json格式[{"userId":"xxx","recName":"xxx","handlerLeve":"xxx"},{"userId":"xxx","recName":"xxx","handlerLeve":"xxx"},{"userId":"xxx","recName":"xxx","handlerLeve":"xxx"}]
     * 数组形式
     */
    @ApiModelProperty(value = "预警确认人信息")
    private List<HandlerDTO> handler;
    /**
     * 预警抄送人信息,json格式[{"userId":"xxx","recName":"xxx"},{"userId":"xxx","recName":"xxx"},{"userId":"xxx","recName":"xxx"}]
     */
    @ApiModelProperty(value = "预警抄送人信息")
    private List<CsrDTO> csr;
    /**
     * 预警责任人信息,json格式{"userId":"xxx","recName":"xxx"}
     */
    @ApiModelProperty(value = "预警责任人信息")
    private DutyNameDTO dutyName;

    /**
     * 平台是否可处理
     */
    @ApiModelProperty(value = "平台是否可处理")
    private Boolean isHandle;
    /**
     * 应用处理回调地址
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用处理回调地址")
    private String callbackUrl;

    private static final long serialVersionUID = 1L;

}
