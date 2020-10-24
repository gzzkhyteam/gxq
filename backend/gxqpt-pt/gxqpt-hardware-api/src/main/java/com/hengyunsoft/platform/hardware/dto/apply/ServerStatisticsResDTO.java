package com.hengyunsoft.platform.hardware.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ServerStatisticsRes", description = "服务器监控统计返回实体")
public class ServerStatisticsResDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * server的主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "server的主键")
    private Long serverId;

    /**
     * 生成时间
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;

    /**
     * cpu使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu使用率")
    private Byte cpu;

    /**
     * 内存使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "mem")
    private Byte mem;

    /**
     * 磁盘使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "disk")
    private Byte disk;

    /**
     * 上行流量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "wideUp")
    private Double wideUp;

    /**
     * 下行流量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "wideDown")
    private Double wideDown;
}
