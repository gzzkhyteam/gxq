package com.hengyunsoft.platform.admin.api.core.dto.emp;

import lombok.Data;

import java.util.Date;

@Data
public class GxqptEmpAndUserDTO {

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    private String maindutyname;

    private String systemCode;
}
