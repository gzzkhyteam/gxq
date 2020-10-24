package com.hengyunsoft.security.ratelimit.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示用户给定时间类到速率阀值限制实体。
 * <p>
 *  limit - 还剩有多少请求可以由用户执行。映射到请求头： X-Ratelimit-limit
 *  remaining - 限制此次数内，剩下多少可调用次数。 映射到请求头：X-Ratelimit-Remaining
 *  reset - 重置时间。 映射到请求头： X-Ratelimit-Reset
 * @auth tangyh
 * @date 2018/07/03
 */
@Data //get set方法
@NoArgsConstructor  //生成无参构造函数
@AllArgsConstructor //生成全参构造函数
public class Rate {

    /** 缓存key */
    private String key;
    /** 限制次数内，剩下可调用次数 */
    private Long remaining;
    /** 过期重置时间秒 */
    private Long reset;
    /** 到期时间 */
    private Date expiration;
}
