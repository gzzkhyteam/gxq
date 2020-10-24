package com.hengyunsoft.platform.supervise.dto.center.apprunning;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BizAppSuperviseUpdate", description = "应用运行监管修改接收实体")
public class BizAppSuperviseUpdateDTO {
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 同时在线用户量上限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "同时在线用户量上限")
    private Integer onlineLimit;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任人:单个")
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "确认人:多个,逗号隔开")
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送人:多个,逗号隔开")
    private String copyUser;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "监管类型")
    private Short superviseType;

    /**
     * 提醒方式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式")
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String desc;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
