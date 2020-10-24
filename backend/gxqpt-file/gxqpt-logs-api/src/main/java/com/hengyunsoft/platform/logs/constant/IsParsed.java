package com.hengyunsoft.platform.logs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IsParsed {
    PARSED("已解析"),
    PARSING("解析中"),
    NOTPARSED("未解析"),
    PARSEDFAILED("解析失败"),
    INVALID("已失效"),
    ;

    private String parsedescript;
}
