package com.hengyunsoft.platform.mt.api.userconfig.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * com.hengyunsoft.platform.mt.api.userconfig.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：红点提醒消息
 * 修改人：gbl
 * 修改时间：2018/8/20
 * 修改内容：
 */
@Data
@ApiModel(value = "ReadMsgDTO", description = "红点提醒消息")
public class RedMsgDTO {
    /***
     * 消息类型: sysMsg:系统通知消息  feedBack:意见反馈  sysNotice:系统公告
     */
    @ApiModelProperty(value = "消息类型: sysMsg:系统通知消息  feedBack:意见反馈  sysNotice:系统公告")
    private String msgType;
    /***
     * 显示内容
     */
    @ApiModelProperty(value = "消息内容")
    private String content;
    /***
     *未读数量
     */
    @ApiModelProperty(value = "未读数量")
    private Integer notReadCount;
}
