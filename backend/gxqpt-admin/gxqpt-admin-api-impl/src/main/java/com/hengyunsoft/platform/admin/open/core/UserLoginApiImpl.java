package com.hengyunsoft.platform.admin.open.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.sec.PasswordEncoder;
import com.hengyunsoft.utils.BizAssert;


@RestController
@RequestMapping("/p/login")
public class UserLoginApiImpl {

	@Autowired
	private UserService userService;
    @Autowired
    private DozerUtils dozerUtils;
//    @Value("${gxqpt.randomstr}")
//    private String randomstr;
//    @Autowired
//    private ISecurityStrategy securityStrategy;
//    private final long HOURSE = 1*60*60*1000;
//
	//改方法已经移动到 auth-server 的 UserController中
//    @RequestMapping(value="",method=RequestMethod.POST)
//	public Result<UserDto> login(String account,String password) {
//    	BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
//    	BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
//    	String enCoderPassword = PasswordEncoder.encoder(password);
//
//		User user = userService.getLogin(account, enCoderPassword);
//		BizAssert.assertNotNull(AuthorityExceptionCode.USER_NAME_PWD_ERROR, user);
//		return Result.success(dozerUtils.map(user, UserDto.class));
//	}
    
//    private Boolean pass(String secCode) {
//    	
//    	try {
//			String dateTime = securityStrategy.uncrypt(randomstr, secCode);
//			long distance = System.currentTimeMillis() - Long.valueOf(dateTime);
//			
//			return Math.abs(distance) < HOURSE;
//		} catch (Exception e) {
//			return false;
//		}
//    }
}
