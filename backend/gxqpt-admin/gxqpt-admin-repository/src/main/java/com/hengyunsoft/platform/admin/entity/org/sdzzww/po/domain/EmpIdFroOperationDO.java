package com.hengyunsoft.platform.admin.entity.org.sdzzww.po.domain;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import lombok.Data;

@Data
public class EmpIdFroOperationDO extends GxqptEmp {
    private String theAppId;
    private String theCode;
    private String systemCode;
}
