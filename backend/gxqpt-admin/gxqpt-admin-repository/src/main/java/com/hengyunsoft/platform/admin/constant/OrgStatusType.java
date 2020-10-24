package com.hengyunsoft.platform.admin.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrgStatusType {
    NOLMAL("1"),
    TOBEREVOKED("2"),
    REVOKE("3"),;

    private String value;
}
