package com.hengyunsoft.security.gete.auth;

import java.util.List;

/**
 * application 认证
 * 应用认证    判断某个应用是否具有访问指定资源的权限。
 * 外网关
 *
 * @author 潘定遥
 */
public interface ApplicationAuth {

    /**
     * 是否有可消费的模块   判断指定消费者是否可用访问指定生产者的指定资源。
     * 若可以访问，则返回可访问的模块id。否则返回null。
     *
     * @param consumerAppId 消费者appid，就是服务的调用杜； 判断是否允许此应用访问指定的url
     * @param producerAppId 生产者appid，就是服务的提供者；就是资源的提供者
     * @param url           需要鉴别的地址
     * @param token         因为在加载资源的时候，需要token   暂时还没有想到有什么好的方案解决token的问题
     * @return 非null          表示允许           null 则拒绝
     */
    Long moduleIdOfConsumerUseable(String consumerAppId, String producerAppId, String url, String token);
    
    /**
     * 获取指定生产者对应的url所在的模块id
     * @param producerAppId
     * @param url
     * @param token
     * @return
     */
    Long getModuleId(String producerAppId, String url, String token);

    /**
     * 验证指定的应用是否是接入应用
     *
     * @param appId
     * @return
     */
    boolean isJryy(String appId, String token);

    /**
     * 通过serviceId获取到对应的appId集合，因为一个真实的服务可能会被包含多个应用。
     *
     * @param serviceId
     * @return appIds
     */
    List<String> getAppIdsByServiceId(String serviceId, String token);
}
