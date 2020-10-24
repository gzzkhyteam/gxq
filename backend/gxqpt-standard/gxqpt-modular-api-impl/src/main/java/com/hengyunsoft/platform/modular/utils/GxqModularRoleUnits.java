package com.hengyunsoft.platform.modular.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GxqModularRoleUnits {

    @Autowired
    private RoleOpenApi roleOpenApi;

    /**
     * 平台管理员编码
     */
    public static final String ADMIN_ROLE_CODE = "app_admin";

    /***
     * 是否是平台管理员
     */
    public boolean getGxqModularRole(Long adminId, String type) {
        // 是否是平台管理员
        boolean gxqPtAdmin = false;
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

}