package com.hengyunsoft.platform.logs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WarnType {
    KEY("关键字告警"),
    QUANTITY("数量告警"),
    RESPONSE("响应时长告警")
    ;
    private String warndescript;


}
