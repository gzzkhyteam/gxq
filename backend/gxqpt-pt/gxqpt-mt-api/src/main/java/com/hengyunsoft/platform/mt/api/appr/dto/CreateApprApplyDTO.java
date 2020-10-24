package com.hengyunsoft.platform.mt.api.appr.dto;

import com.hengyunsoft.platform.mt.api.file.dto.CreateFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：考勤申请
 * 修改人：gbl
 * 修改时间：2018/7/10
 * 修改内容：
 */
@Data
@ApiModel(value = "ApprOverTimeDTO", description = "")
public class CreateApprApplyDTO {
    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)")
    private String aprType;

    //-------------公共字段-----------------
    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    /**
     * 请假类型,出差类型（从数据字典中获取name来存放）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假类型,出差类型（从数据字典中获取name来存放）")
    private String leaveType;
    /***
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private List<ApprApplyPersonDTO> apprPersons;
    /***
     * 抄送人
     */
    @ApiModelProperty(value = "抄送人")
    private List<ApprApplyPersonDTO> sendPersons;
    /***
     *附件
     */
    @ApiModelProperty(value = "附件")
    private List<CreateFileDTO> images;

    //----------------------加班字段---------------------
    /**
     * 加班内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班内容")
    private String content;

    //------------------外勤字段-------------------------------------
    /**
     * 外出描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "外出描述")
    private String description;
    //--------------------------请假类型--------------------------------------------

    /**
     * 请假小时
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假小时")
    private Float leaveHour;

    /**
     * 请假事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假事由")
    private String leaveReason;
    //------------------------出差-------------------------
    /**
     * 出差省
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差省")
    private String province;

    /**
     * 出差市
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差市")
    private String city;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 交通工具")
    private String vehicle;

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "随行人员")
    private String entourage;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 联系电话")
    private String entouragePhone;

    /**
     * 出差 小时
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差 小时")
    private Float businessHour;

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差事由")
    private String businessReason;
    //------------------------补签---------------------------------
    /**
     * 补签类型(1:签到、2:签退)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "补签类型(1:签到、2:签退)")
    private Integer supplyType;

    /**
     * 补签日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "补签日期")
    private Date date;

    /**
     * 补签理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "补签理由")
    private String reason;
}
