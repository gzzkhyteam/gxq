package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app查询打卡详情参数
 * 修改人：gbl
 * 修改时间：2019/7/2
 * 修改内容：
 */
@Data
@ApiModel(value = "AppPunchInfoReqParamDTO", description = "app查询打卡详情参数")
public class AppPunchInfoReqParamDTO {
    @ApiModelProperty(value = "单位id")
    private String orgId;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "状态 normal:正常,miner:旷工 late:迟到 early:早退 travel:出差 leave:请假 out:外勤 work:加班")
    private String state;
}
