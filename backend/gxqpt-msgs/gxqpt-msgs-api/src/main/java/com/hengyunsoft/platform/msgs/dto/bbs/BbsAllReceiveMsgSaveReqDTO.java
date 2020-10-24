package com.hengyunsoft.platform.msgs.dto.bbs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息接收保存DTO
 */
@Data
@ApiModel(value = "BbsAllReceiveMsgSaveReqDTO", description = "消息接收保存DTO")
public class BbsAllReceiveMsgSaveReqDTO implements Serializable {

    /**
     * 消息id
     *
     * @mbggenerated
     */
    /*@ApiModelProperty(value = "消息id")
    private Long msgId;*/

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收人id")
    private Long receiveId;

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否已读")
    private Boolean readIs;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteIs;

    /**
     * 是否需要处理
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要处理")
    private Boolean handlerNeedIs;



    private static final long serialVersionUID = 1L;
}