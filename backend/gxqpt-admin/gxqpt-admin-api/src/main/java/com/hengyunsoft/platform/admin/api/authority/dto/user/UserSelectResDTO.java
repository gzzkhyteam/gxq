package com.hengyunsoft.platform.admin.api.authority.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSelectResDTO implements Serializable {
    private Long id;
    private String name;
    private String phone;
}
