package com.hengyunsoft.platform.mail.entity.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.mail.Session;

import com.hengyunsoft.platform.mail.repository.service.mail.send.SendMail;
import com.hengyunsoft.platform.mail.repository.service.mail.send.SmtpAuth;

import lombok.extern.slf4j.Slf4j;


/**
 * 类说明：用于创建session
 *

 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 */
@Slf4j
public class MailSession {
	/**
	 * 创建session
	 * 
	 * @param name
	 *            属性配置路径
	 * @param auth
	 *            用户认证
	 * @return Session 对象
	 */
	public static Session createSession(String name, SmtpAuth auth) {
		Session session = null;
		Properties props = MailSession.getProperties(name);
		session = Session.getInstance(props, auth);
		return session;
	}

	/**
	 * 加载邮件服务器属性配置文件
	 * 
	 * @param name
	 *            文件名（com/../类名）
	 * @return Properties
	 */
	public static Properties getProperties(String name) {
		Properties props = null;
		InputStream is = null;
		try {
			is = SendMail.class.getClassLoader().getResourceAsStream(name);
//            String path = SendMail.class.getResource("/").toString();
//            is = classLoader().getResourceAsStream(path);

			props = new Properties();
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}

    private static ClassLoader classLoader() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        return loader;
    }

	// 得到Session对象
	public static Session getInstance(String propsName) {
        Properties properties = getProperties(propsName);

        Set<String> strings = properties.stringPropertyNames();
        for(String name : strings){
            log.info("name={}, value={}", name, properties.get(name));
        }
        return Session.getInstance(properties);
	}
}
