package com.hengyunsoft.platform.sms.dto;

public class SmsChannelDTO {
	//渠道id
	private Long channelId;
	//渠道名称
	private String channelName;
    //渠道服务商英文名称
    private String channelServer;
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelServer() {
		return channelServer;
	}
	public void setChannelServer(String channelServer) {
		this.channelServer = channelServer;
	}
	
}
