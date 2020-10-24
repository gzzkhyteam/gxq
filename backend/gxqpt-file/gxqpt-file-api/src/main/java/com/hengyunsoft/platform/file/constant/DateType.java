package com.hengyunsoft.platform.file.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DateType {
    //无期限
    NUL(0),
    //1天
    DAY(1),
    //7天
    WEEK(7),
    ;

    int key;
}
