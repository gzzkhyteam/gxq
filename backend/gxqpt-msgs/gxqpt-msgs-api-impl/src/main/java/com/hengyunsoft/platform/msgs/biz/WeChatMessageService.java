package com.hengyunsoft.platform.msgs.biz;

/**
 * 微信服务接口
 */
public interface WeChatMessageService {
	/**
	 * 保存微信消息
	 */
	String saveWechatMessage(String msg);
	/**
	 * 发送消息到微信
	 * @param msg
	 * @return
	 */
	public String sendToWeChat();
}
