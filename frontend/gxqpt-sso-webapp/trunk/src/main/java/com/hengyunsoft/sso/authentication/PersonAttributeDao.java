package com.hengyunsoft.sso.authentication;

import com.hengyunsoft.platform.commons.sec.ISecurityStrategy;
import com.hengyunsoft.sso.exception.LoginAuthFailException;
import com.hengyunsoft.sso.exception.LoginDisableException;
import org.jasig.cas.authentication.AccountDisabledException;
import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.BasePersonAttributeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * 把这里服务化  或者 查询数据库即可
 * @author 潘定遥
 *
 */
@Component("attributeRepository")
public class PersonAttributeDao  extends BasePersonAttributeDao {
    private static final int USER_LOGIN_DISABLE = 50006;

	@Override
	public IPersonAttributes getPerson(String account) {
		return null;
	}

	@Override
	public Set<IPersonAttributes> getPeople(Map<String, Object> query) {
		return null;
	}

	@Override
	public Set<IPersonAttributes> getPeopleWithMultivaluedAttributes(
			Map<String, List<Object>> query) {
		return null;
	}

	@Override
	public Set<String> getPossibleUserAttributeNames() {
		return null;
	}

	@Override
	public Set<String> getAvailableQueryAttributes() {
		return null;
	}



	@Autowired
	private SSOConfig ssoConfig;
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private ISecurityStrategy securityStrategy;
	
	public UserDTO getPerson(String account, String password, String salt) throws Exception {
		
		Map<String,String> urlVariables = new HashMap<>();
		urlVariables.put("account", account);
		urlVariables.put("password", password);
		String txt = String.valueOf(System.currentTimeMillis());
		urlVariables.put("secCode", securityStrategy.encrypt(ssoConfig.getRandomStr(), txt));
		urlVariables.put("salt", salt);

		Result re = restTemplate.postForEntity(ssoConfig.getLoadUserApi(),null, Result.class, urlVariables).getBody();
        if(re.getErrcode()==USER_LOGIN_DISABLE){
            throw new LoginDisableException(re.getErrmsg());
        }
		if(!re.isSuccess()) {
			throw new LoginAuthFailException(re.getErrmsg());
		}
		return re.getData();
	}

}
