package com.hengyunsoft.platform.supervise.dto.center.apprunning;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "BizAppSuperviseBase", description = "应用运行监管基本实体")
public class BizAppSuperviseBaseDTO {
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 同时在线用户量上限
     *
     * @mbggenerated
     */
    private Integer onlineLimit;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    private String copyUser;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    private Short superviseType;

    /**
     * 提醒方式
     *
     * @mbggenerated
     */
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    private Boolean runStatus;

    private Date scheduledTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
