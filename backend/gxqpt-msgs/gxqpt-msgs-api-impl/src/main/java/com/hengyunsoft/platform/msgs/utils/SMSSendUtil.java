package com.hengyunsoft.platform.msgs.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.sms.SmsClient;
import com.baidubce.services.sms.SmsClientConfiguration;
import com.baidubce.services.sms.model.SendMessageV2Request;
import com.baidubce.services.sms.model.SendMessageV2Response;
import com.qcloud.sms.SmsSingleSender;
import com.qcloud.sms.SmsSingleSenderResult;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信工具类
 * 
 * @author dxz
 * 
 */
public class SMSSendUtil {
	/**
	 * 阿里云发送短信
	 * @param mobile
	 * @return
	 * @throws ClientException
	 */
	public static SendSmsResponse sendAliYunSms(String mobile, String appId,
			String appScreat, String signName, String templateCode,String templateParam) throws ClientException {
		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",appId, appScreat);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi","dysmsapi.aliyuncs.com");
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号
		request.setPhoneNumbers(mobile);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(signName);
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(templateCode);
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为"{\"name\":\"王总王\", \"code\":\"132465\"}"
		request.setTemplateParam(templateParam);
		// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		// request.setOutId("yourOutId");
		// hint 此处可能会抛出异常，注意catch
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		return sendSmsResponse;
	}

	/**
	 * 百度云发送短信
	 * @param phone
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param endPoint
	 * @param templateCode
	 * @param invokeId
	 * @param templateParam
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static SmsResult sendBaiduSms(String phone, String accessKeyId,
			String accessKeySecret,String templateCode,String invokeId, String templateParam) {
		try {
			// ak、sk等config
			SmsClientConfiguration config = new SmsClientConfiguration();
			config.setCredentials(new DefaultBceCredentials(accessKeyId,accessKeySecret));
			config.setEndpoint("sms.bj.baidubce.com");
			// 实例化发送客户端
			SmsClient smsClient = new SmsClient(config);
			// 若模板内容为：您的验证码是${code},在${time}分钟内输入有效
			// 定义请求参数
			Map<String, String> vars = new HashMap<>(10);
			if (!StringUtils.isEmpty(templateParam)) {
				vars = JSONObject.parseObject(templateParam, Map.class);
			}
			// 实例化请求对象
			SendMessageV2Request request = new SendMessageV2Request();
			request.withInvokeId(invokeId).withPhoneNumber(phone).withTemplateCode(templateCode).withContentVar(vars);
			// 发送请求
			SendMessageV2Response response = smsClient.sendMessage(request);
			return SmsResult.getInstance(response.isSuccess() ? 
					SmsResult.SUCCESS_BAIDU : response.getCode(), 
					response.getRequestId(), "", response.getMessage(), 0);
		} catch (Exception e) {
			return SmsResult.fail(e.getMessage());
		}
	}
	/**
	 * 腾讯云发送短信
	 * @param phone
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param endPoint
	 * @param templateCode
	 * @param invokeId
	 * @param templateParam
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static SmsResult sendTencentSms(String phone, String accessKeyId,
			String accessKeySecret, String templateCode,
			String invokeId, String templateParam) {
		try {
			// 初始化单发
			SmsSingleSender singleSender = new SmsSingleSender(Integer.parseInt(accessKeyId), accessKeySecret);
			SmsSingleSenderResult singleSenderResult;
			ArrayList<String> arrParams = new ArrayList<>();
			if (!StringUtils.isEmpty(templateParam)) {
				Map<String, String> map = JSONObject.parseObject(templateParam,Map.class);
				for (String value : map.values()) {
					arrParams.add(value);
				}
			}
			singleSenderResult = singleSender.sendWithParam("86", phone, Integer.parseInt(templateCode),arrParams, invokeId, "", "");
			return SmsResult.getInstance(singleSenderResult.result == 0 ? SmsResult.SUCCESS_TENCENT
							:String.valueOf(singleSenderResult.result),singleSenderResult.sid, singleSenderResult.ext,
							singleSenderResult.errMsg, singleSenderResult.fee);
		} catch (Exception e) {
			return SmsResult.fail(e.getMessage());
		}
	}
}
