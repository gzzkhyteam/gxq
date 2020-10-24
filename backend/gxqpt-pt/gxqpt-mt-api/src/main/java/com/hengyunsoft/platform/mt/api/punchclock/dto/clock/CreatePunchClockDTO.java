package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import com.hengyunsoft.platform.mt.api.file.dto.CreateFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建打卡
 * 修改人：gbl
 * 修改时间：2018/7/4
 * 修改内容：
 */
@Data
@ApiModel(value = "CreatePunchClockDTO", description = "创建打卡")
public class CreatePunchClockDTO {
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

    /**
     * 是否自动签到:1,手动；2，自动
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否自动签到:1,手动；2，自动")
    private Integer autoSignInFlag;

    /**
     * 是否自动签退:1,手动；2，自动
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否自动签退:1,手动；2，自动")
    private Integer autoSignOffFlag;

    /**
     * 签到经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签到经度")
    private String signInLng;

    /**
     * 签到纬度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签到纬度")
    private String signInLat;

    /**
     * 签到地点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签到地点")
    private String signLocation;

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签退经度")
    private String signOffLng;

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 签退纬度")
    private String signOffLat;

    /**
     * 签退地点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签退地点")
    private String signOffLocation;

    /**
     * 迟到（早退）说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "迟到（早退）说明")
    private String lateReason;
    /**
     * 外勤事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "外勤事由")
    private String outterReason;
    /**
     * 打卡图片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打卡图片")
    private List<CreateFileDTO> images;

}
