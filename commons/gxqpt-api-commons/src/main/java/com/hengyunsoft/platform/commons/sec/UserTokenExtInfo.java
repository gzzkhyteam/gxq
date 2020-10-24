package com.hengyunsoft.platform.commons.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class UserTokenExtInfo {
	private Integer logoutFlag;
	private String account;
	private final static String PT_ADMIN_CODE = "_p_a_c";  
	/**
	 * 定义应用角色在long 64位中的顺序。
	 */
	private  static String[] app_list = {PT_ADMIN_CODE,AppIds.authority,AppIds.biaozhun,AppIds.center,AppIds.dataview,
			AppIds.developer,AppIds.email,AppIds.exchange,AppIds.fastDevlepoer,AppIds.hardware,AppIds.logs,AppIds.msgs,AppIds.mt,
			AppIds.yunpan,AppIds.warn,AppIds.supervise,AppIds.sms,AppIds.security,AppIds.search,AppIds.ops};
	static {
		 /**
		  * 对应用角色进行排序，只有有序的数组才可以进行二分查找。
		  */
		 Arrays.sort(app_list);
	}
	/**
	 * 应用管理员角色列表   long总共有64位，所以可以保有六十四个系统的管理员角色。后期若超过了六十四个系统，可以改变成数组，就会是无限的了。
	 * 具体顺序是{@link #app_list}中定义应用的顺序。
	 */
	private Long roles = 0L;
	public Integer getLogoutFlag() {
		return logoutFlag;
	}
	public void setLogoutFlag(Integer logoutFlag) {
		this.logoutFlag = logoutFlag;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserTokenExtInfo [logoutFlag=" + logoutFlag + ", account=" + account + ", roles=" + roles + "]";
	}
	public void setListRoles(List<String> appIds,boolean isPtAdmin) {
		
		roles = toLong(appIds,isPtAdmin);
	}
	/**
	 * 将应用appId及是否pt角色管理员进行编码，编码成一个64位的long
	 * @param appIds
	 * @param isPtAdmin
	 * @return
	 */
	public static long toLong(List<String> appIds,boolean isPtAdmin) {
		if(CollectionUtils.isEmpty(appIds)) {
			return 0;
		}
		long roles = 0;
		int index;
		for (String appId : appIds) {
			//因为我们在静态代码块中将app_list进行了排序，故这里可以使用二分查找来加速查找速度
			index = Arrays.binarySearch(app_list, appId);
			if(index >=0) {
				roles |= 1L<<index;
			}
		}
		if(isPtAdmin) {
			//将平台角色加入到long中。
			index = Arrays.binarySearch(app_list, PT_ADMIN_CODE);
			if(index >=0) {
				roles |= 1L<<index;
			}
		}
		return roles;
	}
	
	public void setRoles(Long roles) {
		this.roles = roles;
	}
	public boolean isAppAdmin(String appId) {
		
		if(StringUtils.isEmpty(app_list)) {
			return false;
		}
		//因为我们在静态代码块中将app_list进行了排序，故这里可以使用二分查找来加速查找速度
		int index = Arrays.binarySearch(app_list, appId);
		
		if(index >=0) {
			
			return ((1L << index) & roles) != 0l;
		} else {
			return false;
		}
	}
	/**
	 * 判断是否平台管理员角色
	 * @return
	 */
	public boolean ptAdminIs() {
		
		return isAppAdmin(PT_ADMIN_CODE);
	}
	
	public Long getRoles() {
		return roles;
	}
	
	public static void main(String[] args) {
		
		UserTokenExtInfo e = new UserTokenExtInfo();
		
		List<String> appIds = new ArrayList<>();
		appIds.add(AppIds.authority);
		appIds.add(AppIds.developer);
		appIds.add(AppIds.authority);
		appIds.add(AppIds.supervise);
		e.setRoles(e.toLong(appIds,false));
		for (String appId : app_list) {
			System.out.println(appId + "= " + e.isAppAdmin(appId));
		}
	}
}
