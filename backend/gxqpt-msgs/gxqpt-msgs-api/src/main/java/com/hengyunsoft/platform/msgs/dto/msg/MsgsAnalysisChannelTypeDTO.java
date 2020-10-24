package com.hengyunsoft.platform.msgs.dto.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "MsgsAnalysisChannelType", description = "渠道类型统计对象")
public class MsgsAnalysisChannelTypeDTO {
    /**
     * 渠道类型名称
     */
    @ApiModelProperty(value = "渠道类型名称")
    private String name;
    /**
     * 渠道类型发送消息个数
     */
    @ApiModelProperty(value = "渠道类型发送消息个数")
    private String count;

    /**
     *创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}
