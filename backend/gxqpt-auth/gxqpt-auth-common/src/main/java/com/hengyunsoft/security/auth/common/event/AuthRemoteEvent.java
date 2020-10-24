package com.hengyunsoft.security.auth.common.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import java.util.List;

/**
 * @author ace
 * @create 2017/11/4.
 */
public class AuthRemoteEvent extends RemoteApplicationEvent {
    private List<String> allowedClient;

    /**
     * jackson序列化反序列化必须有无参构造函数
     */
    public AuthRemoteEvent() {
    }

    public AuthRemoteEvent(Object source, String originService, String destinationService, List<String> allowedClient) {
        // source is the object that is publishing the event
        // originService is the unique context ID of the publisher
        super(source, originService, destinationService);
        this.allowedClient = allowedClient;

        System.out.println("--我执行了:AuthRemoteEvent");
    }

    public List<String> getAllowedClient() {
        return allowedClient;
    }

    public void setAllowedClient(List<String> allowedClient) {
        this.allowedClient = allowedClient;
    }
}
