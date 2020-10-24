package com.hengyunsoft.platform.mail.constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.PropertiesLoaderUtils;


/**
 * 类说明：邮件常用常量
 *
 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 */
@Slf4j
public class MailConstant {
    /**
     * 收件夹
     */
    public static final String FOLDER_INBOX = "INBOX";

    /**
     * 已发送
     */
    public static final String FOLDER_SENDED = "SENDED";

    /**
     * 草稿箱
     */
    public static final String FOLDER_DRAFT = "DRAFT";

    /**
     * 已删除
     */
    public static final String FOLDER_DELETE = "DELETE";

    /**
     * 垃圾邮件夹
     */
    public static final String FOLDER_SPAM = "SPAM";
    /**
     * 异常邮件夹
     */
    public static final String FOLDER_ABNORMAL = "ABNORMAL";
    /**
     * 病毒邮件夹
     */
    public static final String FOLDER_VIRUSES = "VIRUSES";

    /**
     * 异常邮件
     */
    public static final String FOLDER_TRASH = "TRASH";

    /**
     * 邮件夹类型
     */
    public static final int INBOX = 1;// 收件夹
    public static final int DRAFT = 2;// 草稿箱
    public static final int SENDED = 3;// 已发送
    public static final int DELETE = 4;// 已删除
    public static final int SPAM = 5;// 垃圾邮件
    public static final int ABNORMAL = 6;// 垃圾邮件
    public static final int VIRUSES = 7;// 垃圾邮件
    public static final int TRASH = 9;// 异常邮件


    /**
     * 邮件列表页面每页显示的邮件数
     **/
    public static final int MAXRESULT = 15;
    /**
     * 邮件页面导航要显示的页码数量
     */
    public static final int PAGE_COUNT = 8;

    /**
     * 邮件配置文件路径
     */
//	public static final String EMAIL_CONFIG_PATH = "cn/edu/pdsu/service/mail/email.properties";
    public static final String EMAIL_CONFIG_PATH = "mail/email.properties";

    /**
     * 找回密码自动发送邮件配置 用户名 ,在UserRegisterService类中使用 了
     */
    public static final String SENDMAIL_USERNAME = "admin@gygxq.com";
    /**
     * 找回密码自动发送邮件配置 密码
     */
    public static final String SENDMAIL_PASSWORD = "admin";
    /**
     * 找回密码自动发送邮件配置 发件人
     */
    public static final String SENDMAIL_FROM = "admin@gygxq.com";


    /**
     * 邮箱认证的默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";
    /** 上传文件时，存储链接的请求头 */
    public static final String HEADER_FILE_URL = "file_url";
    public static final String HEADER_FILE_NAME = "file_name";

//	Properties properties = new Properties();
//	 // 使用ClassLoader加载properties配置文件生成对应的输入流
//	  in = MailConstant.class.getClassLoader().getResourceAsStream("emailconfigure.properties");
//	 // 使用properties对象加载输入流
//	 properties.load(in);
//	 //获取key对应的value值
//	 properties.getProperty(String key);


    // 获取properties文件属性值
    public static String readPropertiesFile(String filePath, String key) throws FileNotFoundException, IOException {
        try {
            Properties props = new Properties();
            props.load(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String value = props.getProperty(key);
            System.out.println(key + "键的值是：" + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据配置文件得到值
    public static String getProperties(String filePath, String keyWord) {
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(filePath);
            // 根据关键字查询相应的值
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    //根据配置文件key得到值邮箱域名
    public static String getPropertiesByMailPrefix() {
        return MailConstant.getProperties("mail/emailconfigure.properties", "mail.prefix");
    }

    //将邮箱域名拼接在登录名后
    public static String fightAdmin(String username) {
        String mailPrefix = MailConstant.getPropertiesByMailPrefix();
        log.info("mailPrefix={}", mailPrefix);
        username += mailPrefix;
        log.info("username={}", username);
        return username;
    }
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		MailConstant aa = new MailConstant();
//		 String properties_1 = aa.getPropertiesByMailPrefix();
//		          System.out.println("mail.prefix = " + properties_1);
//
//
//	}
}
