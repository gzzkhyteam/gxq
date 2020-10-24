package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询审批列表参数
 * 修改人：gbl
 * 修改时间：2018/7/10
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryApprApplyParamDTO", description = "查询审批列表参数")
public class QueryApprApplyParamDTO {
    /***
     * 是否查询我发出的
     */
    @ApiModelProperty(value = "是否查询我发出的")
    private Boolean isFromMe;
    /***
     * 是否是我审批过的
     */
    @ApiModelProperty(value = "是否是我审批过的")
    private Boolean isPassMe;
    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)")
    private String aprType;
    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:已撤销)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销)")
    private Integer curState;

    /***
     * 开始创建时间
     */
    @ApiModelProperty(value = "开始创建时间")
    private Date startCreateTime;
    /***
     *结束创建时间
     */
    @ApiModelProperty(value = "结束创建时间")
    private Date endCreateTime;
}
