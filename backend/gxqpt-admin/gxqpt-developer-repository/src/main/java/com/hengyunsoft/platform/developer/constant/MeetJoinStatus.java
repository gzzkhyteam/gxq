package com.hengyunsoft.platform.developer.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Administrator on 2018/5/9.
 */
@AllArgsConstructor
@Getter
public enum MeetJoinStatus {
    NOTICING((short)0, "通知中"),
    JOIN((short)1, "参加"),
    NOT_JOIN((short)2, "不参加"),
    CREATOR((short)3, "发起人"),
    ;
    private Short joinStatus;
    private String desc;
}
