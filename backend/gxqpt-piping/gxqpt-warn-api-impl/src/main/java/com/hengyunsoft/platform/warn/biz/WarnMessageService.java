package com.hengyunsoft.platform.warn.biz;

import com.hengyunsoft.platform.warn.api.warn.dto.WarnMessageDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

/**
 * 预警服务接口
 * @author zjr
 */
public interface WarnMessageService {
	/**
	 * 保存预警信息到数据库
	 */
	String saveWarnMessage(String warn);

	/**
	 * 发送预警信息到接收人
	 */
	public String sendToSendee();

}
