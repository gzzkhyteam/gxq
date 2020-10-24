package com.hengyunsoft.platform.security;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.cas.sso.ext.CasConfigure;
import com.hengyunsoft.cas.sso.ext.CasRealm;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.config.GxqptWebappConfig;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.api.RoleApi;
import com.hengyunsoft.security.auth.api.UserApi;
import com.hengyunsoft.security.auth.dto.UserDTO;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * shiro的认证授权域
 *
 * @author tyh
 * @createTime 2017-11-17 14:44
 */
public class CasExtRealm extends CasRealm {

    @Autowired
    private AuthTokenApi authTokenApi;
    @Autowired
    private RoleApi roleApi;
    @Autowired
    private UserApi userApi;

    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;

    @Autowired
    private IUserToken userToken;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        return super.doGetAuthenticationInfo(token);
    }

    /**
     * 与数据库关联 通过用户登录账号去取出与此用户有关的信息
     *
     * @param account      登录账号
     * @param ticket       登录凭证 cas server的凭证
     * @param casAssertion cas server 返回的与用户有关的all信息。（一些扩展信息看{@link Assertion#getAttributes() }）
     * @return
     */
    @Override
    protected SimpleAuthenticationInfo createAuthenticationInfo(String account, String ticket, Assertion casAssertion, CasConfigure casConfigure) {
        Result<UserDTO> result = userApi.getByAccount(account);
        if (result.isSuccess() && result.getData() != null) {
            //AccountDTO data = new AccountDTO();
            //data.setAppId(appId);
            //data.setUserId(result.getData().getId());
            //data.setName(result.getData().getName());
            //data.setPhoto(result.getData().getPhoto());
            //data.setAccount(result.getData().getAccount());
            //登录后重新生成token
//            Result<TokenVo> token = authTokenApi.token(appId, appSecret);
            //RequestContextHolder.getRequestAttributes().setAttribute("token", token.getData().getToken(), RequestAttributes.SCOPE_SESSION);
            //查token 存缓存
        	UserDTO loginUserInfo = result.getData();
        	LoginInfoUtil.addLoginUser(loginUserInfo);
        	
            SimpleAuthenticationInfo casAuthenticationInfo = new SimpleAuthenticationInfo(
                    result.getData(), ticket, this.getName());
            
            
            List<String> adminAppIds = roleApi.findAppAdminRoleByUid(result.getData().getId()).getData();
            
            Boolean isPtAdmin = roleApi.isPtAdmin(result.getData().getId()).getData();
            
            long adminAppIdsLong = UserTokenExtInfo.toLong(adminAppIds,isPtAdmin);
            
            LoginInfoUtil.addLoginUserAdminAppIds(adminAppIdsLong);
            
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            HttpServletResponse response = requestAttributes.getResponse();
            HttpServletRequest request = requestAttributes.getRequest();


            String token = authTokenApi.token(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).getData().getToken();
//            String token = TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get().get();

            try {
            	UserTokenExtInfo userTokenInfo = new UserTokenExtInfo();
            	userTokenInfo.setAccount(loginUserInfo.getAccount());
            	userTokenInfo.setRoles(adminAppIdsLong);
            	
                token = userToken.encoder(token, loginUserInfo.getId().toString(), loginUserInfo.getName(), userTokenInfo);


                setTokenCookie(URLEncoder.encode(token, "utf-8"), request, response);

            } catch (Exception e) {
                throw new BizException(-1, "生成用户token失败");
            }

            return casAuthenticationInfo;
        }
        throw new BizException(result.getErrcode(), result.getErrmsg());
    }

    private void setTokenCookie(String token, HttpServletRequest request, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_token", token);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }

    //private void setUserIdCookie(Long userId, HttpServletResponse response) {
    //    Cookie userCookie = new Cookie("_user_id", String.valueOf(userId));
    //    userCookie.setPath("/");
    //    userCookie.setSecure(false);
    //    userCookie.setMaxAge(EXPIRE_SECONDS);
    //    response.addCookie(userCookie);
    //}
    //private void setUserNameCookie(String userName, HttpServletResponse response) {
    //    try{
    //        if(Strings.isNullOrEmpty(userName)){
    //            Cookie userNameCookie = new Cookie("_user_name", URLEncoder.encode(userName, "UTF-8"));
    //            userNameCookie.setPath("/");
    //            userNameCookie.setSecure(false);
    //            userNameCookie.setMaxAge(EXPIRE_SECONDS);
    //            response.addCookie(userNameCookie);
    //        }
    //    }catch (Exception e){
    //
    //        e.printStackTrace();
    //    }
    //}

    /**
     * 获取当前认证实体的授权信息（授权包括：角色、权限）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }
}
