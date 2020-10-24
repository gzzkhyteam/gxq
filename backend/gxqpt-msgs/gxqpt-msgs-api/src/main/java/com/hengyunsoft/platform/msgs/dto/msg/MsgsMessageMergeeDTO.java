package com.hengyunsoft.platform.msgs.dto.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@ApiModel(value = "MsgsMessageMerge", description = "消息列表对象")
public class MsgsMessageMergeeDTO extends MsgsMessageBaseDTO{
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 5渠道个渠道之合
     *
     * @mbggenerated
     */
    private String channelSum;
    private String succesNum;//成功个数
    private String erroNum;//失败个数
    private String fileLists;//微博文件列表
    /**
     *创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}
