package com.hengyunsoft.platform.security.api.backups.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseBackupsGetById", description = "备份根据ID查询返回信息")
public class ShareResponseBackupsGetByIdDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 备份名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份名称")
    private String name;

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份系统名称")
    private String applicationName;

    /**
     * 备份路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份路径")
    private String path;

    /**
     * 文件后缀
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件后缀")
    private String fileExt;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器ip")
    private String serverIp;

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器账号")
    private String serverAccount;

    /**
     * 服务器密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器密码")
    private String serverPasswd;

    /**
     * 数据库类型 1 mysql，2 oracle，3 sqlserver，4 mongodb，5 hbase
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型")
    private Integer dbType;

    /**
     * 备份频率(定时表达式) 直接填
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份频率")
    private String backupFrequency;

    /**
     * 检查标示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "检查标示")
    private Boolean checkMark;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;
}
