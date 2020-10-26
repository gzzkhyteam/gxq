package com.hengyunsoft.sso.webflow.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.hengyunsoft.util.StringUtils;
@Component("updatePwdAction")
public class UpdatePwdAction extends AbstractAction{
	 private JdbcTemplate jdbcTemplate;
	 private DataSource dataSource;
	 @NotNull
     private String sql;
	 
	 
	@Override
	protected Event doExecute(RequestContext context) throws Exception {
		 final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		// 获取用户名和密码
		 String username = request.getParameter("username");
         String password = request.getParameter("pwd");
         String retpwd = request.getParameter("retpwd");
         Map<?,?> result  = getJdbcTemplate().queryForMap(this.sql,username);
         if(!retpwd.equals(password)) {
        	 request.setAttribute("msg", "两次输入的密码不一致!");
             return error();
         }
         boolean isTrue=checkPwd(password);
         if(!isTrue){
        	 request.setAttribute("msg", "密码必须由6-18位的数字字母或者特殊字符组成!");
        	 return error();
         }
		 if(StringUtils.isNotEmpty(result.get("password").toString())){
			  final String encryptedPassword = new Md5Hash(password).toString();
			  String pwd_sql="update c_emp set password = '"+encryptedPassword+"' where user_name = '"+username+"'";
			  if(result.get("userType").toString().equals("2")){
				  pwd_sql="update b_duty_unit_info set password_ = '"+encryptedPassword+"' where account_ = '"+username+"'";
			  }
			  getJdbcTemplate().execute(pwd_sql);
		 }
		return success();
	}
	 /**
     * Method to set the datasource and generate a JdbcTemplate.
     *
     * @param dataSource the datasource to use.
     */
    @Autowired(required = false)    
    public void setDataSource(@Qualifier("queryDatabaseDataSource") final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }
	 protected final JdbcTemplate getJdbcTemplate() {
	        return this.jdbcTemplate;
	 }

	 protected final DataSource getDataSource() {
	        return this.dataSource;
	 }
	 /**
     * @param sql The sql to set.
     */
    @Autowired
    public void setSql(@Value("${cas.jdbc.authn.query.sql:}") final String sql) {
        this.sql = sql;
    }
    public static boolean  checkPwd ( String  pwd ){
    	    if(pwd.length() < 6 ){
    	    	return false;
    	    }
            if (pwd.matches ("^\\d+$")){
                return false;
            }
            else if (pwd.matches ("^[a-zA-Z]+$")) {
            	return false;
            }
            return true;
    }
}
