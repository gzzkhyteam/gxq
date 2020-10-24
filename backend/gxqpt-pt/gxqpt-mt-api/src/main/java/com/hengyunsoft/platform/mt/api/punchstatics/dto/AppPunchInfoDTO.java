package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：显示用户的打卡详情
 * 修改人：gbl
 * 修改时间：2019/7/2
 * 修改内容：
 */
@Data
@ApiModel(value = "AppPunchInfoDTO", description = "显示用户的打卡详情")
public class AppPunchInfoDTO {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "日期")
    private String date;
    @ApiModelProperty(value = "签到状态  normal:正常,miner:旷工 late:迟到 early:早退 travel:出差 leave:请假 out:外勤 work:加班")
    private List<String> siginState;
    @ApiModelProperty(value = "签退状态  normal:正常,miner:旷工 late:迟到 early:早退 travel:出差 leave:请假 out:外勤 work:加班")
    private  List<String> sigiOffState;

}
