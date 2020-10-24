package com.hengyunsoft.platform.ops.impl.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class YwPtRoleUnits {
    @Autowired
    private RoleOpenApi roleOpenApi;

    /**
     * 运维管理平台管理员
     */
    public static final String APP_ADMIN_ROLE_CODE = "app_admin";
    /**
     * 运维单位管理员
     */
    public static final String YW_UNIT_ADMIN_ROLE_CODE = "yw_unit_admin";

    /**
     * 运维单位管理员
     */
    public static final String YW_APPROVAL_CODE = "app_approval";

    /***
     * 是否运维管理平台管理员或运维单位管理员
     * @param adminId
     * @return
     */
    public Boolean getGxqPtRole(Long adminId, String type) {
        Boolean gxqPtAdmin = false;//是否是平台管理员
        Result<List<RoleDto>> roleList = roleOpenApi.findAllPtAndCurrentAppRoleById(adminId);

        log.info("issuccess ={}, data={} ", roleList.isSuccess(), roleList.getData());
        if (roleList.getData() != null) {
            log.info("size={} ", roleList.getData().size());
        }

        String code = null;
        if (roleList.getData() != null && roleList.getData().size() > 0) {
            for (RoleDto rloe : roleList.getData()) {
                code = rloe.getCode();
                if (code.equals(type)) {
                    gxqPtAdmin = true;
                    break;
                }
            }
        }
        return gxqPtAdmin;
    }

    /***
     * 是否运维管理平台管理员或运维单位管理员
     * @param userId,unitId
     * @return
     */
    public Boolean getYwUnitOrPtRole(Long userId, String type) {
        Boolean gxqPtRole = getGxqPtRole(userId, type);
        return gxqPtRole;
    }
}
