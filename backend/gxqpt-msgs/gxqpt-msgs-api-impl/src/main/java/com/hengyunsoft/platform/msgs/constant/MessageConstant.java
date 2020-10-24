package com.hengyunsoft.platform.msgs.constant;

public class MessageConstant {
	/**
	 * 信息的状态,0=待发送;1=已发送;2=发送失败
	 */
	public static Integer sendStatus = 0;	
	//WeChat\Blog\Sms\Mobile\Public渠道类型
	public enum SystemType{
		APP,MODULAR,SERVICE
	}
	/**
	 * 微信渠道
	 */
	public static final String WECHAT_MESSAGE_CHANNEL = "wechatChannel";
	public static final String WECHAT_MESSAGE_CHANNEL_BACK = "wechatBackChannel";
	/**
	 * 短信渠道
	 */
	public static final String SMS_MESSAGE_CHANNEL = "smsChannel";
	public static final String SMS_MESSAGE_CHANNEL_BACK = "smsBackChannel";
	/**
	 * 微博渠道
	 */
	public static final String BLOG_MESSAGE_CHANNEL = "blogChannel";
	public static final String BLOG_MESSAGE_CHANNEL_BACK = "blogBackChannel";
	/**
	 * 邮件渠道
	 */
	public static final String MAIL_MESSAGE_CHANNEL = "mailChannel";	
	//获取微信公众号access_token地址
	public static final String wechat_tokenGetUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%t";
	//群发发消息到微信地址
	public static final String sendToWeChat = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=%s";
	//发图文消息到微信地址
	public static final String sendImageToWeChat = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";
	//发送素材消息到微信地址
	public static final String sendSourceToWeChat = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=%s";
	//发送文件消息到微信地址
	public static final String sendFileToWeChat = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%t";
	//发送永久素材到微信地址
	public static final String sendMediaToWeChat = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%t";
	//获取永久素材地址
	public static final String getMediaFromWeChat = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s&media_id=%t";
	//发送视频消息到微信地址
	public static final String sendVideoToWeChat = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=%s";
	//获取上传多媒体地址
	public static final String getIDFromWeChat = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%t";		
	//获取上传音频地址
	public static final String getVoiceFromWeChat = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=%s&media_id=%t";				
	//发布一条消息到微博地址
	public static final String sendToBlog = "https://api.weibo.com/2/statuses/share.json";		
	//发布图片、文件消息到微博地址
	public static final String sendFileToBlog = "https://upload.api.weibo.com/2/statuses/upload.json";	
	//发布图片消息到微博地址
	public static final String getBlogUrl = "https://upload.api.weibo.com/2/kandian/upload/get_url";	
}
