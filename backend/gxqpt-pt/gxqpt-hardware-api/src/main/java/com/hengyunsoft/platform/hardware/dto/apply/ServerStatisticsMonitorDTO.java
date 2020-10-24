package com.hengyunsoft.platform.hardware.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ServerStatisticsMonitor", description = "服务器监控统计入参实体")
public class ServerStatisticsMonitorDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 生成时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查询时间之后的数据")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    /**
     * 查找类型
     */
    @ApiModelProperty(value = "查询性能类型：1-cpu; 2-内存; 3-磁盘; 4-上行流量; 5-下行流量")
    private String type;
}
