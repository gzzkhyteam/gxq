package com.hengyunsoft.platform.mt.api.work.dto;

import com.hengyunsoft.platform.mt.api.file.dto.WorkLogFileDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogDetailDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 日志id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主表日志id")
    private Long logId;

    /**
     *单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String unitId;
    /**
     * 工作类型;0：本职工作，1：非本职工作
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 工作类型")
    private Integer workType;

    /**
     * 非本职工作类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "非本职工作类型")
    private String nonJobType;
    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    /**
     * 可查看人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "可查看人id")
    private List<Long> userIds;
    /**
     * 工作描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 工作描述")
    private String description;

    @ApiModelProperty(value = " 附件详情")
    private List<WorkLogFileDTO> workLogFileDTOS;
}
