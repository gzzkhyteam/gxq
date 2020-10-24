package com.hengyunsoft.platform.jobs;


import com.hengyunsoft.platform.warn.biz.WarnMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 发送预警信息
 * @author zjr
 */

@Component
@Slf4j
public class WarnSendActuator {

	@Autowired
	private WarnMessageService warnMessageService;

	@Scheduled(cron = "0 0/2 *  * * ?")
	public void getWarnData() {
		try {
				//从数据库中查询待发送信息，把待发送信息发送出去，并修改状态
				warnMessageService.sendToSendee();
				log.info("临时表预警信息");
		} catch (Exception e) {
			log.info("获取信息失败",e);
//			e.printStackTrace();
		}
	}

}
