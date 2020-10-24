package com.hengyunsoft.platform.sms.dto;

public class PersonalCountResultDTO {
	private String sender;
	private Integer count;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
