package com.hengyunsoft.security.ratelimit.queue;

import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/16
 */
@Data
public class InterfaceWarnSms {
    public final static int UPPER_DAY = 0;
    public final static int WARN = 1;
    private Long id;
    private int status;//0 每日上限 1 预警阀值
}
