//package com.hengyunsoft.platform.mail.dto;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import io.swagger.annotations.ApiModel;
//import lombok.Data;
//import org.apache.commons.lang.builder.ToStringBuilder;
//
///**
// * 类说明：发送邮件的基本信息
// *
// * @author 作者: tangyh
// * @version 创建时间：2018-07-25
// */
//@Data
//@ApiModel(value = "MailInfo", description = "发送邮件的基本信息")
//public class MailInfoDTO {
//	/** 邮件uid */
//	private long uid;
//	/** 发件人 */
//	private String from;
//	/** 收件人 */
//	private String to;
//	/** 抄送人 */
//	private String cc;
//	/** 密送人 */
//	private String bcc;
//	/** 主题 */
//	private String subject;
//	/** 内容 */
//	private String content;
//	/** 保存到已发送 */
//	private Boolean sended = false;
//	/** 紧急邮件 */
//	private Boolean exigence = false;
//	/** 存文本 */
//	private Boolean text= false;
//	/** 定时发送 */
//	private Boolean time= false;
//
//	/** 邮件所在的邮件夹 */
//	private int folderType;
//
//	public String checkEmailAddress(String emailAddress) {
//		String email = null;
//		if (emailAddress != null && !"".equals(emailAddress)
//				&& emailAddress.length() > 0) {
//			emailAddress = emailAddress.replaceAll("；", ";");
//			email = emailAddress;
//			int index = emailAddress.lastIndexOf(";");
//			if (index == emailAddress.length() - 1) {
//				email = emailAddress.substring(0, emailAddress.length() - 1);
//			}
//			if (emailAddress.indexOf(";") != -1) {
//				email = emailAddress(emailAddress);// 检测email地址的有效性
//			}
//		}
//		return email;
//	}
//
//	// 检测每个email地址的有效性
//	public String emailAddress(String emailAdd) {
//		String emails[] = emailAdd.split(";");
//		StringBuffer sb = new StringBuffer();
//		for (String email : emails) {
//			if (isEmail(email)) {
//				sb.append(email).append(",");
//			}
//		}
//		if (sb.length() > 0)
//			sb.deleteCharAt(sb.length() - 1);
//		return sb.toString();
//	}
//
//	// 检测是否是email地址
//	public boolean isEmail(String emailAddress) {
//		boolean ise = false;
//		Pattern pt = Pattern
//				.compile("^\".+\"<[\\w[-_.]]+@[\\w[-_.]]+\\.\\w+>$");
//		Pattern pt2 = Pattern.compile("[\\w[-_.]]+@[\\w[-_.]]+\\.\\w+");
//		Matcher matcher = pt.matcher(emailAddress);
//		if (matcher.matches()) {
//			ise = true;
//		} else {
//			Matcher matcher2 = pt2.matcher(emailAddress);
//			if (matcher2.matches()) {
//				ise = true;
//			}
//		}
//		return ise;
//	}
//
////	public String toString() {
////		return new ToStringBuilder(this).append("From", from).append("To", to)
////				.append("Cc", cc).append("Bcc", bcc).append("Subject", subject)
////				.append("Content", content).append("Sended", sended)
////				.append("Exigence", exigence).append("Text", text)
////				.append("Time", time).toString();
////	}
//
////	public static void main(String[] args) {
////		MailInfoDTO fb = new MailInfoDTO();
////		System.out.println("1 : " + fb.isEmail("\"abc\"<abc@163.com>"));
////		System.out.println("2 : " + fb.isEmail("\"abcd\"<abc@163.com>"));
////		System.out.println("3 : " + fb.isEmail("\"abc\"abc@163.com>"));
////		System.out.println("4 : " + fb.isEmail("\"abc\"<abc@163.com"));
////		System.out.println("5 : " + fb.isEmail("\"abc\"<abc163.com>"));
////		System.out.println("6 : " + fb.isEmail("\"abc<abc@163.com>"));
////		System.out.println("7 : " + fb.isEmail("abc\"<abc@163.com>"));
////		System.out.println("8 : " + fb.isEmail("abc@163.com"));
////		System.out.println("9 : " + fb.isEmail("abc@163.com>"));
////		System.out.println("10 : " + fb.isEmail("<abc@163.com"));
////		System.out.println("11 : " + fb.isEmail("abc@1.63.com"));
////		String email = "\"abc\"<abc@163.com>;" + "\"abcd\"<abc@163.com>;"
////				+ "\"abc\"abc@163.com>;" + "\"abc\"<abc@163.com;"
////				+ "\"abc\"<abc163.com>;" + "\"abc<abc@163.com>;"
////				+ "abc\"<abc@163.com>;" + "abc@163.com;" + "abc@163.com>;"
////				+ "<abc@163.com;" + "abc@1.63.com";
////
////		System.out.println(fb
////				.emailAddress("\"张晓红3\"<xiaohong3@163.com>;2011@ljg.com"));
////		fb.checkEmailAddress("\"张晓红3\"<xiaohong3@163.com>;2011@ljg.com");
////		System.out.println(fb.emailAddress(email));
////		System.out.println(fb.checkEmailAddress("test2@ljg.com"));
////	}
//}
