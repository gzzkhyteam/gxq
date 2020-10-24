package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：批量打卡
 * 修改人：gbl
 * 修改时间：2019/6/19
 * 修改内容：
 */
@Data
@ApiModel(value = "BatchCreateClockDTO", description = "批量打卡")
public class BatchCreateClockDTO {
    @ApiModelProperty(value = "开始生成时间 如 2019-05-20")
    private String startDay;
    @ApiModelProperty(value = "生成多少天的")
    private Integer days;
    @ApiModelProperty(value = "除了不生成的用户")
    private List<Long> exceptUserIds;
    @ApiModelProperty(value = "签到经度")
    private String signInLng;

    @ApiModelProperty(value = "签到纬度")
    private String signInLat;

    @ApiModelProperty(value = "签到地点")
    private String signLocation;

    @ApiModelProperty(value = "签退经度")
    private String signOffLng;


    @ApiModelProperty(value = " 签退纬度")
    private String signOffLat;

    @ApiModelProperty(value = "签退地点")
    private String signOffLocation;


}
