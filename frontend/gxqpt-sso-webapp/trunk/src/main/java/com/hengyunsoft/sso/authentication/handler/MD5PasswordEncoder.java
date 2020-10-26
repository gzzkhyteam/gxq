/*
 * 文件名：MD5PasswordEncoder.java
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：Cas自定义MD5加密工具
 * 修改人：loujingying@henyunsoft.com
 * 修改时间：2016年9月9日
 * 修改内容：新增
 */
package com.hengyunsoft.sso.authentication.handler;

import org.jasig.cas.authentication.handler.PasswordEncoder;

/**
 * Cas自定义MD5加密工具
 * 
 * @author loujingying@henyunsoft.com
 * @version 1.0.0, 2016-09-09
 * @see org.jasig.cas.authentication.handler.PasswordEncoder
 * @since SSO1.0.0
 */
public class MD5PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return com.hengyunsoft.security.util.PasswordEncoder.encode(rawPassword);
	}
	
}
