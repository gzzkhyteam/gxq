package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询打卡记录参数
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryPunchclockParamDTO", description = "查询打卡记录参数")
public class QueryPunchclockParamDTO {
    /***
     *是否来自app端
     */
    @ApiModelProperty(value = "是否来自app端")
    private Boolean fromApp;
    /**
     * 打卡类型:1,签到；2，签退
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 打卡类型:1,签到；2，签退")
    private Integer clockType;
    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "考勤类型:1,内勤；2，外勤")
    private Integer adceType;

    /***
     * 开始创建时间( 打卡时间)
     */
    @ApiModelProperty(value = "开始创建时间( 打卡时间)")
    private Date startCreateTime;
    /***
     *结束创建时间(打卡时间)
     */
    @ApiModelProperty(value = "结束创建时间(打卡时间)")
    private Date endCreateTime;
}
