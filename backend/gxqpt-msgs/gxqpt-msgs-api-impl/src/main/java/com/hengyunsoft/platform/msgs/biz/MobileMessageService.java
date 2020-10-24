package com.hengyunsoft.platform.msgs.biz;
/**
 * 移动终端服务接口
 * @author dxz
 */
public interface MobileMessageService {

	/**
	 * 保存消息
	 * @param msg
	 * @return
	 */
	String saveMobileMessage(String msg);
	/**
	 * 定时发送
	 * @return
	 */
	String updateMobileMessage();
}
