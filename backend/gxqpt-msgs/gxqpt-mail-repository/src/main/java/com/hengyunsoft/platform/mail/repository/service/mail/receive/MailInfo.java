package com.hengyunsoft.platform.mail.repository.service.mail.receive;

import java.util.List;

import com.hengyunsoft.platform.mail.entity.domain.MailBean;

/**
 * 类说明：邮件的一些共用信息
 * 
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-7-23 下午05:10:20
 */
public class MailInfo {
	/**
	 * 新邮件数
	 */
	private int newMessageCount = 0;
	/**
	 * 邮件总数
	 */
	private int messageCount = 0;
	/**
	 * 未读邮件数
	 */
	private int unreadMessageCount = 0;

	/**
	 * 邮件列表信息
	 */
	private List<MailBean> mailBeanList;

	public int getNewMessageCount() {
		return newMessageCount;
	}

	public void setNewMessageCount(int newMessageCount) {
		this.newMessageCount = newMessageCount;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public int getUnreadMessageCount() {
		return unreadMessageCount;
	}

	public void setUnreadMessageCount(int unreadMessageCount) {
		this.unreadMessageCount = unreadMessageCount;
	}

	public List<MailBean> getMailBeanList() {
		return mailBeanList;
	}

	public void setMailBeanList(List<MailBean> mailBeanList) {
		this.mailBeanList = mailBeanList;
	}

}
