package com.hengyunsoft.platform.config;

import com.hengyunsoft.cas.sso.ext.CasFilter;
import com.hengyunsoft.cas.sso.ext.MultipleCasConfigureManager;
import com.hengyunsoft.platform.security.CasExtRealm;
import com.hengyunsoft.platform.security.CasFilterExt;
import com.hengyunsoft.platform.security.MultipleCasConfigure;
import com.hengyunsoft.platform.security.MultipleCasConfigureManagerExt;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月13日
 */
@Configuration
// @EnableAspectJAutoProxy
public class ShiroConfiguration {
	// private static final String casFilterUrlPattern = "/shiro-cas";
	private static final String casFilterUrlPattern = "/";

	/**
	 * 注册过滤器 相当于在web.xml中配置
	 *
	 * <filter> <filter-name>shiroFilter</filter-name>
	 * <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	 * </filter> <filter-mapping> <filter-name>shiroFilter</filter-name>
	 * <url-pattern>*.do</url-pattern> </filter-mapping>
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
		filterRegistration.addInitParameter("targetFilterLifecycle", "true");
		filterRegistration.setEnabled(true);
		filterRegistration.addUrlPatterns("/*");
		// filterRegistration.addUrlPatterns("*.do");
		filterRegistration.addInitParameter("exclusions",
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,/mgmt/*,/static/*,/css/*");
		filterRegistration.setOrder(2);
		return filterRegistration;
	}

	/**
	 * Shiro生命周期处理器： 用于在实现了Initializable接口的Shiro bean初始化时调用Initializable接口回调，
	 * 在实现了Destroyable接口的Shiro bean销毁时调用
	 * Destroyable接口回调。如UserRealm就实现了Initializable，
	 * 而DefaultSecurityManager实现了Destroyable。具体可以查看它们的继承关系。
	 * 
	 * @return
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}


	@Bean("multipleCasConfigureManager")
	public MultipleCasConfigureManager getMultipleCasConfigureManager(
			@Value("${cas.configure-key:casFlag}") String casConfigureKey,
			MultipleCasConfigure multipleCasConfigure) {
		
		MultipleCasConfigureManagerExt mcme = new MultipleCasConfigureManagerExt();
		
		mcme.setCasConfigureKey(casConfigureKey);
		
		mcme.setDefaultCasConfigure(multipleCasConfigure.getCasConfigure().values().iterator().next());
		
//		Map<String, CasConfigure> casConfMap = new HashMap<>();
//		casConfMap.put("centerCas", centerCas);
		mcme.setCasConfigures(multipleCasConfigure.getCasConfigure());
		return mcme;
	}

	/**
	 * CAS Filter
	 */
	@Bean(name = "casFilter")
	public CasFilter getCasFilter(MultipleCasConfigureManager multipleCasConfigureManager) {
		CasFilter casFilter = new CasFilterExt();
		// casFilter.setName("casFilter");
		// casFilter.setEnabled(true);
		// String loginUrl = casServerUrlPrefix + "/login?service=" +
		// shiroServerUrlPrefix + casFilterUrlPattern;
		// casFilter.setFailureUrl(loginUrl);
		casFilter.setConfigureManager(multipleCasConfigureManager);
		return casFilter;
	}

	/**
	 * 配置过滤器
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean someFilterRegistration(
			@Qualifier("multipleCasConfigureManager") MultipleCasConfigureManager multipleCasConfigureManager) {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(getCasFilter(multipleCasConfigureManager));
		registration.addUrlPatterns("/jklejrt");
		return registration;
	}

	@Bean(name = "casRealm")
	public CasExtRealm getCasExtRealm() {
		return new CasExtRealm();
	}

	/**
	 * securityManager安全管理器
	 *
	 * @return
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("casRealm") CasExtRealm casRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// CasRealm casRealm = new CasRealm();
		// casRealm.setDefaultRoles("ROLE_USER");
		// casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
		// casRealm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
		securityManager.setRealm(casRealm);
		// securityManager.setCacheManager(new MemoryConstrainedCacheManager());
		// securityManager.setSubjectFactory(new CasSubjectFactory());
		return securityManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager);
		return aasa;
	}

	/**
	 * Shiro Web过滤器
	 *
	 * @param securityManager
	 * @param casFilter
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager,
			@Qualifier("casFilter") AuthenticatingFilter casFilter) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setSuccessUrl("/");

		// String loginUrl = casServerUrlPrefix + "/login?service=" +
		// shiroServerUrlPrefix + casFilterUrlPattern;
		// shiroFilterFactoryBean.setLoginUrl(loginUrl);
		Map<String, Filter> filters = new HashMap<>();
		filters.put("casFilter", casFilter);
		// TODO 这里可以测试下
		// LogoutFilter logoutFilter = new LogoutFilter();
		// logoutFilter.setRedirectUrl(casServerUrlPrefix + "/logout?service=" +
		// shiroServerUrlPrefix);
		// filters.put("logout",logoutFilter);
		shiroFilterFactoryBean.setFilters(filters);

		// filterChainDefinitions
		loadShiroFilterChain(shiroFilterFactoryBean);
		return shiroFilterFactoryBean;
	}

	private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/slogin", "anon");
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/search", "anon");
		filterChainDefinitionMap.put("/svalidate", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		// filterChainDefinitionMap.put("/templates/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/mgmt/**", "anon");
		filterChainDefinitionMap.put("/no/**", "anon");
		/// swagger-ui.html,/webjars/*,/v2/api-docs/*,/swagger-resources/*

		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/v2/api-docs/**", "anon");
		filterChainDefinitionMap.put("/swagger-resources/**", "anon");
		filterChainDefinitionMap.put("/logout", "anon");
		filterChainDefinitionMap.put("/**", "casFilter");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	}
	
	
	
	

	/**
	 * 回话管理DefaultWebSecurityManager使用的默认实现，用于Web环境，其直接使用Servlet容器的会话；
	 * 
	 * @return
	 */
	@Bean("sessionManager")
	public ServletContainerSessionManager servletContainerSessionManager() {
		return new ServletContainerSessionManager();
	}

	/**
	 * 相当于调用SecurityUtils.setSecurityManager(securityManager)
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public MethodInvokingFactoryBean getMethodInvokingFactoryBean(DefaultWebSecurityManager securityManager) {
		MethodInvokingFactoryBean mifBean = new MethodInvokingFactoryBean();
		mifBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		mifBean.setArguments(new Object[] { securityManager });
		return mifBean;
	}

}