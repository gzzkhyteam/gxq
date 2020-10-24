package com.hengyunsoft.platform.mt.impl.appr;

import com.hengyunsoft.platform.mt.api.appr.dto.ApprApplyPersonDTO;
import lombok.Data;

import java.util.List;

/***
 * 创建审批申请需要参数
 */
@Data
public class CreateApprApply {

    public CreateApprApply(String aprType, List<ApprApplyPersonDTO> apprPersons, List<ApprApplyPersonDTO> sendPersons) {
        this.aprType = aprType;
        this.apprPersons = apprPersons;
        this.sendPersons = sendPersons;
    }

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    private String aprType;

    /***
     * 审批人员列表(前端选择的顺序)
     */
    private List<ApprApplyPersonDTO> apprPersons;

    /***
     * 抄送人员列表(前端选择的顺序)
     */
    private List<ApprApplyPersonDTO> sendPersons;

}
