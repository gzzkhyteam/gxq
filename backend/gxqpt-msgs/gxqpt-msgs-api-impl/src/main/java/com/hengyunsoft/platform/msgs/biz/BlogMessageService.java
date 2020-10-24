package com.hengyunsoft.platform.msgs.biz;

/**
 * 微博服务接口
 * @author dxz
 */
public interface BlogMessageService {
	/**
	 * 保存微博消息
	 */
	String saveBlogMessage(String msg);
	/**
	 * 发送消息到微博
	 * @param msg
	 * @return
	 */
	public String sendToBlog();
}
