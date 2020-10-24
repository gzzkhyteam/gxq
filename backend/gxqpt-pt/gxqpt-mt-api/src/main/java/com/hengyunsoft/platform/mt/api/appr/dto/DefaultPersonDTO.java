package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：默认审批人和抄送人
 * 修改人：gbl
 * 修改时间：2018/7/12
 * 修改内容：
 */
@Data
@ApiModel(value = "DefayltPersonDTO", description = "默认审批人和抄送人")
public class DefaultPersonDTO {
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
}
