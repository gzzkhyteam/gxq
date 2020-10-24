package com.hengyunsoft.platform.hardware.constant;

/**
 * 角色对应审批数据权限
 */
public enum  Role2ScodeEnum {
    HARDWARE_MANAGE("HARDWARE_MANAGE","GL"),
    HARDWARE_GXUY("HARDWARE_GXUY","UY"),
    HARDWARE_GXYY("HARDWARE_GXYY","YY"),
    //HARDWARE_DEPT_ROLE("HARDWARE_DEPT_ROLE","SQ"),
    ;
    private String sCode;
    private String roleCode;

     Role2ScodeEnum(String roleCode,String sCode){
        this.roleCode = roleCode;
        this.sCode = sCode;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public static String getScodeByRoleCode(String roleCode){
        if(roleCode==null){
            return null;
        }
        for (Role2ScodeEnum c : Role2ScodeEnum.values()) {
            if (roleCode.equals(c.getRoleCode())) {
                return c.getsCode();
            }
        }
        return null;
    }
}
