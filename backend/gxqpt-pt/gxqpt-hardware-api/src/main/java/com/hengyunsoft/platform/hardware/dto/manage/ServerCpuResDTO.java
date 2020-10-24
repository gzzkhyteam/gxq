package com.hengyunsoft.platform.hardware.dto.manage;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ServerCpuResDTO", description = "计算资源管理列表")
public class ServerCpuResDTO{
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
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

        /**
         * cpu核数
         *
         * @mbggenerated
         */
        @ApiModelProperty(value = "cpu核数")
        private Integer cpuCount;

        /**
         * cpu使用占比
         *
         * @mbggenerated
         */
        @ApiModelProperty(value = "cpu使用占比")
        private Byte cpuPercent;

}
