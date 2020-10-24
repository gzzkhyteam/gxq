package com.hengyunsoft.platform.msgs.dto.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "MsgsChannelType", description = "渠道类型对象")
public class MsgsChannelTypeDTO {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 厂商名称
     */
    @ApiModelProperty(value = "厂商名称")
    private String factoryName;

    /**
     * 支持消息类型
     */
    @ApiModelProperty(value = "支持消息类型")
    private String msgType;

    /**
     *说明
     */
    @ApiModelProperty(value = "说明")
    private String remark;



    /**
     *创建开始时间
     */
    @ApiModelProperty(value = "创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
