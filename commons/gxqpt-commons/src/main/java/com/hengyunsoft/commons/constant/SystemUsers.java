package com.hengyunsoft.commons.constant;
/**
 * 
 * 定义一些系统用户，这些用户的id号是负数（小于0的）。
 * 使用于系统在写定时任务的时候或别的场景，需要以系统的身份发送消息的或者处理事件的。
 * @author 潘定遥
 *
 */
public class SystemUsers {
	
	public final static SystemUsers gxqptSystem ;
	
	static {
		gxqptSystem = new SystemUsers("高新区平台", -1L);
	}
	private final String name; 
	private final Long id;
	public SystemUsers(String name, Long id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	} 
}
