package com.hengyunsoft.platform.mt.api.punchclock.dto.rule;

import com.hengyunsoft.platform.mt.api.file.dto.CreateFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建规则
 * 修改人：gbl
 * 修改时间：2018/7/4
 * 修改内容：
 */
@Data
@ApiModel(value = "CreatePunchClockRuleDTO", description = "创建规则")
public class CreatePunchClockRuleDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键,有为编辑，没有是新增")
    private Long id;
    /**
     * 签到时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签到时间")
    private String inTime;

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签退时间")
    private String outTime;

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "午休开始时间")
    private String startTime;

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "午休结束时间")
    private String endTime;

    /**
     * 签到距离范围(米)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 签到距离范围(米)")
    private Integer distanceRange;

    /**
     * 经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "经度")
    private String lng;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "纬度")
    private String lat;

    /**
     * 打卡地点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打卡地点")
    private String location;

    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private List<CreateFileDTO> fileList;

}
