package com.hengyunsoft.platform.developer.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by Administrator on 2018/5/9.
 */
@AllArgsConstructor
@Getter
public enum MeetStatus {
    NOTICING((short)1, "通知中"),
    PART_CONFIRMED((short)2, "部分确认"),
    WHOLE_CONFIRMED((short)3, "全部确认"),
    CANCELED((short)4, "已取消"),
    PART_REFUSED((short)5, "部分拒绝"),
    ;
    private Short meetStatus;
    private String desc;
}
