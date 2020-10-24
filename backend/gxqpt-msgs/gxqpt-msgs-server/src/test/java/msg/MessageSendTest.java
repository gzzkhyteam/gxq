package msg;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hengyunsoft.platform.GxqptMsgsApplication;
import com.hengyunsoft.platform.msgs.biz.MessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
 

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=GxqptMsgsApplication.class)//指定spring-boot的启动类 
public class MessageSendTest {
	@Autowired
	private MessageService messageService;	
	/**
	 * 发送短信
	 */
	@Test
    public void testMsgSend() {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setAppId("XHJZGsdhsu3590rjUsc9ys");
		messageDTO.setAppName("新兴应用");
		messageDTO.setSender("dxz");
		messageDTO.setReceiver("18032297269");
		messageDTO.setTopic("审核结果通知");
		messageDTO.setChannelId("{\"Sms\":\"123\"}");
		messageDTO.setTemplateId("1");
		messageDTO.setTemplateParams("{\"userName\":\"杜晓征\",\"name\":\"银饰打造\",\"desc\":\"资质证书不全\"}");
		messageService.saveMessage(messageDTO);
    }
}
