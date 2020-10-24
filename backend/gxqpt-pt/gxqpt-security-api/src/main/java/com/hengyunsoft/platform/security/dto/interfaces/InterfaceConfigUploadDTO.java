package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel
@Data
public class InterfaceConfigUploadDTO {

    @ApiModelProperty(value = "每5分钟错误次数")
    private Integer errorCountMinute;

    @ApiModelProperty(value = "每日上限次数（0：表示无限制）")
    private Integer upperLimitCountByDay;

    @ApiModelProperty(value = "是否短信通知（0：关闭，1：开启）")
    private Integer isSmsNotify;

    @ApiModelProperty(value = "是否已通知 0未通知 1已通知")
    private Integer isNotify;

    @ApiModelProperty(value = "电话号码")
    private String mobile;

    @ApiModelProperty(value = "批量更新记录id")
    private List<Long> idList;

    @ApiModelProperty(value = "修改人")
    private Long updateUser;
}
