package com.hengyunsoft.platform.hardware.dto.manage;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ServerMemoryResDTO", description = "服务器存储管理列表")
public class ServerMemoryResDTO {

    @ApiModelProperty(value = "服务器id主键")
    private Long id;


    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器ip")
    private String ip;


    /**
     * 服务器id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器id")
    private String serverId;

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "管理员id")
    private String manageUid;

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "管理员名称")
    private String manageUname;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;

    /**
     * 内存使用占比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存使用占比")
    private Byte memoryPercent;

    /**
     * 磁盘大小
     */
    @ApiModelProperty(value = "磁盘大小")
    private Integer diskSize;

    /**
     * 磁盘使用占比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘使用占比")
    private Byte diskPercent;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
