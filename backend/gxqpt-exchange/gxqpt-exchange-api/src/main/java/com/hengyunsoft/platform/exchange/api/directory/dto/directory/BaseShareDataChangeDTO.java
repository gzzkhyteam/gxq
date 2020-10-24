package com.hengyunsoft.platform.exchange.api.directory.dto.directory;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-04-25
 */
@Data
public  abstract class BaseShareDataChangeDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private Long unitId;

    /**
     * 操作人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作人id")
    private Long userId;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作时间")
    private Date optTime;

    /**
     * 状态:1,待审批；2，已驳回；3，审批通过
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,待审批；2，已驳回；3，审批通过")
    private Integer status;

}
