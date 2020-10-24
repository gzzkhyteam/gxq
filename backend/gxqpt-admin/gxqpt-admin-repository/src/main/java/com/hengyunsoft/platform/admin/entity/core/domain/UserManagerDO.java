package com.hengyunsoft.platform.admin.entity.core.domain;

import com.hengyunsoft.platform.admin.entity.core.po.User;
import lombok.Data;

@Data
public class UserManagerDO extends User{
    private int tag;
    private int relate;
    private Long assignId;
    private Long roleId;
}
