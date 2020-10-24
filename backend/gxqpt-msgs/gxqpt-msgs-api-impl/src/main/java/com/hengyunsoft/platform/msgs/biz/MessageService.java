package com.hengyunsoft.platform.msgs.biz;

import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;

import net.sf.json.JSONObject;


/**
 * 保存信息接口
 * @author dxz
 */
public interface MessageService {

	/**
	 * 保存信息
	 * @param msg
	 */
	String saveMessage(MessageDTO messageDTO);
	/**
	 * 获得信息详情错误信息情况
	 * @return
	 */
	JSONObject getErrorInfo(String msgId);
}
