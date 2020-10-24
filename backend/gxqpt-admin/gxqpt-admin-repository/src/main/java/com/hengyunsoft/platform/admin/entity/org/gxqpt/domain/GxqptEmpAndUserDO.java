package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import lombok.Data;

@Data
public class GxqptEmpAndUserDO extends GxqptEmp {
    /**
     * 体系编码
     */
    private String systemCode;

    /**
     * 身份id
     */
    private String identityId;
}
