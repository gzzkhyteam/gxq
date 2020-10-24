package com.hengyunsoft.platform.hardware.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ServerStatisticsSave", description = "服务器监控统计保存实体")
public class ServerStatisticsSaveDTO {

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
    private float cpu;

    /**
     * 内存使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存使用率")
    private float mem;

    /**
     * 磁盘使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘使用率")
    private float disk;

    /**
     * 上行流量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上行流量")
    private Double wideUp;

    /**
     * 下行流量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下行流量")
    private Double wideDown;
}
