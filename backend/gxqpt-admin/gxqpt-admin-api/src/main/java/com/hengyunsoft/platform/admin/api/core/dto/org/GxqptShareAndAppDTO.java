package com.hengyunsoft.platform.admin.api.core.dto.org;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "GxqptShareAndApp", description = "分享与应用实体")
public class GxqptShareAndAppDTO implements Serializable {
    private Long id;

    /**
     * 将用户、部门、单位共享给应用-类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享类型")
    private String bizType;

    /**
     * 将用户、部门、单位共享给应用-单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享id")
    private String bizId;

    /**
     * 将用户、部门、单位共享给应用-应用appId
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用appId")
    private String appId;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     *
     * 创建时间
     *
     * @mbggenerated
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * app名称
     *
     * @mbggenerated
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}
