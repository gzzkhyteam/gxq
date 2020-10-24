package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：日志列表详情
 * 修改人：gbl
 * 修改时间：2019/7/3
 * 修改内容：
 */
@Data
@ApiModel(value = "WorkListLogDTO", description = "日志列表详情")
public class WorkListLogDTO {
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
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 日期")
    private Date createDate;
    @ApiModelProperty(value = "日志状态 未提交  已提交")
    private String state;

    //@ApiModelProperty(value = " 日志详情")
    //private List<WorkLogDetailDTO> workLogDetailDTOS;
    @ApiModelProperty(value = " 工作描述")
    private String description;
}
