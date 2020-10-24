package com.hengyunsoft.platform.admin.api.authority.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tyh
 * @createTime 2018-01-02 15:51
 */
@Data
public class RoleDto  extends BaseAdminRoleDto implements Serializable {
    private Long id;

    /**
     * 角色编码
     *
     * @mbggenerated
     */
    private String code;
}
