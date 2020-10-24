package com.hengyunsoft.platform.exchange.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GxqPtRoleUnits {
    @Autowired
    private RoleOpenApi roleOpenApi;

    /**
     * 平台管理员编码
     */
    public static final String PT_ADMIN_ROLE_CODE = "gxq_pt_admin";
    /**
     * 单位数据操作员编码
     */
    public static final String UNITY_ADMIN_DATA_ROLE_CODE = "gxq_unity_data_admin";
    /**
     * 平台数据操作员编码appID
     */
    public static final String PT_ADMIN_DATA_ROLE_CODE = "gxq_pt_data_admin";
    /**
     * 单位管理员
     */
    public static final String ORG_ADMIN_DATA_ROLE_CODE = "org_admin";

    /**
     * 数据字典第2层级
     */
    public static final Integer DICT_TWO_LEVEL = 2;
    /**
     * 数据字典第3层级
     */
    public static final Integer DICT_THREE_LEVEL = 2;

    /***
     * 是否是平台管理员
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
     * 是否单位管理员
     * @param userId,unitId
     * @return
     */
    public Boolean getGxqUnitRole(Long userId, String unitId) {
//        Boolean gxqUnitAdmin = false;//是否单位管理员
//        if(unitId==null){
//            return gxqUnitAdmin;
//        }else{
//            Result<Boolean> unitAdmin = roleOpenApi.getOrgUnit(userId,unitId);
//            if(unitAdmin.getData()) {
//                gxqUnitAdmin=true;
//            }
//            return gxqUnitAdmin;
//        }
        Boolean gxqPtRole = getGxqPtRole(userId, ORG_ADMIN_DATA_ROLE_CODE);
        return gxqPtRole;
    }
}
