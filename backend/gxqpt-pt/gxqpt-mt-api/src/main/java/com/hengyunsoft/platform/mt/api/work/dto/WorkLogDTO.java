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
public class WorkLogDTO implements Serializable {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建人")
    private Long userId;
    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建人")
    private String userName;
    /**
     * 头像
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "头像")
    private String  photo;

    /**
     * 查看状态；1未查看，2已查看
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查看状态")
    private Integer status;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建时间")
    private Date createDate;

    @ApiModelProperty(value = " 日志详情")
    private List<WorkLogDetailDTO> workLogDetailDTOS;


    @ApiModelProperty(value = " 日志回复")
    private List<WorkLogAnswerDTO> workLogAnswerDTOS;
}
