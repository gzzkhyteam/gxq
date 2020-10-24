package com.hengyunsoft.platform.mt.api.appr.dto;

import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：审批详情
 * 修改人：gbl
 * 修改时间：2018/7/11
 * 修改内容：
 */
@Data
@ApiModel(value = "ApprApplyInfoDTO", description = "审批详情")
public class ApprApplyInfoDTO {
    //补签特有
    @ApiModelProperty(value = "补签类型:1签到,2签退")
    private Integer supplyType;
    //出差特有
    @ApiModelProperty(value = "出差类型 :公务出差:official 外出培训:train")
    private String businessType;
    //请假特有
    @ApiModelProperty(value = "请假类型:事假:leave  病假:sick  年假:year 探亲假:relatives   婚假:marriage   产假:maternity 丧假:funeral")
    private String leaveType;


    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)")
    private String aprType;
    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销))
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前状态,1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销")
    private Integer curState;
    /***
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private String applyName;
    /**
     * 申请人Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人Id")
    private Long applyUserId;
    /**
     * 撤销业务Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "撤销业务Id")
    private Long applyId;

    /**
     * 撤销原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "撤销原因")
    private String canceReasonl;
    /***
     *开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    /***
     *结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    /***
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;
    /***
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;
    /***
     *附件信息
     */
    @ApiModelProperty(value = "附件信息")
    private List<FileDTO> files;
    /***
     * 审批记录
     */
    @ApiModelProperty(value = "审批记录")
    private List<ApprApplyRecodeDTO> applyRecodes;
    /***
     * 抄送人
     */
    @ApiModelProperty(value = "抄送人")
    private List<ApprApplyPersonDTO> sendPersons;
    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
