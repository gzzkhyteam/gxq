package com.hengyunsoft.platform.msgs.biz;

import org.springframework.web.bind.annotation.RequestParam;

public interface SmsMessageService {
	/**
	 * 发送短信到接收人
	 * @param msg
	 * @return
	 */
	public String sendToSMS();
	/**
	 * 保存短信信息到数据库
	 */
	public String saveMsg(@RequestParam(value="msg") String msg);
}
