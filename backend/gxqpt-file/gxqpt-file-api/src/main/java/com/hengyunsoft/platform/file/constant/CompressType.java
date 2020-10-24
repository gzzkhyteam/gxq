package com.hengyunsoft.platform.file.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CompressType {
    /**
     * 小
     */
    NULL("",null),
    /**
     * 小
     */
    SMALL("_small",0.5f),
    /**
     * 中
     */
    MIDDLE("_middle",0.618f),
    /**
     * 大
     */
    LAGER("_lager",0.8f),
    /** 自定义 */
    CUSTOM("_custom",1f),

    ;

    /**
     * thumWatermark
     */
    String type;
    Float value;
}
