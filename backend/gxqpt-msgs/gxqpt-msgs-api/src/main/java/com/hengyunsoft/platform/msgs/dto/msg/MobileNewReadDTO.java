package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "MobileNewReadDTO", description = "移动终端未读消息")
public class MobileNewReadDTO {
	 /**
     * 主键id
     */
	@ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 发布信息的id
     */
	@ApiModelProperty(value = "信息id")
    private String msgId;

    /**
     * 应用程序id
     */
	@ApiModelProperty(value = "应用程序id")
    private String appId;

    /**
     * 发布者账号
     */
	@ApiModelProperty(value = "发布者Id")
    private String sender;

    /**
     * 信息主题
     */
	@ApiModelProperty(value = "信息主题")
    private String topic;

    /**
     * 发送渠道的id
     */
	@ApiModelProperty(value = "发送渠道的id")
    private String channelId;

    /**
     * 发送开始时间
     */
	@ApiModelProperty(value = "发送开始时间")
    private String startTime;

    /**
     * 信息内容
     */
	@ApiModelProperty(value = "信息内容")
    private String imgText;

    /**
     * 信息记录创建时间
     */
	//@ApiModelProperty(value = "创建时间")
    //private Date createTime;

    /**
     * 信息记录更新时间
     */
	//@ApiModelProperty(value = "更新时间")
    //private Date updateTime;

    /**
     * 图片封面路径
     */
	//@ApiModelProperty(value = "封面图片路径")
    //private String filePath;
	
    /**
     * 未读数量
     */
	@ApiModelProperty(value = "未读数量")
    private Integer readNum;
}
