package com.hengyunsoft.platform.ops.entity.consult.domain;


import com.hengyunsoft.platform.ops.entity.consult.po.ConsultManage;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class ConsultManageDO extends ConsultManage{

    /**
     * 咨询人ID
     */
    private Long zxrId;

    /**
     * 是否管理员角色
     */
    private Boolean isAdminRole;

}
