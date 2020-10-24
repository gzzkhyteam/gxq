package com.hengyunsoft.platform.supervise.dto.center.apprunning;

import com.hengyunsoft.platform.supervise.constant.ApplicationNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BizAppSupervisePage", description = "应用运行监管分页返回实体")
public class BizAppSupervisePageResDTO extends ApplicationNode{

    /**
     * 同时在线用户量上限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "同时在线用户量上限")
    private Integer onlineLimit;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "监管类型")
    private Short superviseType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 提醒方式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式")
    private Short remindType;

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
