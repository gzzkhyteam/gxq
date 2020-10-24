package com.hengyunsoft.platform.mt.api.work.dto;

import com.hengyunsoft.platform.mt.api.file.dto.WorkLogFileDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogSaveDTO extends BaseWorkLogDTO {
    /**
     * 工作类型;1：本职工作，2：非本职工作
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


    @ApiModelProperty(value = "单位id")
    private String unitId;


    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建人")
    private Long userId;
    /**
     * 工作描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 工作描述")
    private String description;

    /**
     * 可查看人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "可查看人id")
    private List<Long> userIds;
    /**
     * 附件信息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件信息")
    private List<WorkLogFileDTO> files;
}
