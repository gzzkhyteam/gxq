package com.hengyunsoft.security.logoutflag;

/**
 * 退出标记存储器
 * 
 * 因为我在每次登录的时候，都为登录赋予了一个编号（数字>=1），所以在退出的时候，会将这个标记报告给网关，网关在拿到用户级token的时候，
 * 需要看看这个用户级token是否已经退出，若在记录的退出存储标记中，那么就不再转发请求，而是直接告知已退出，重新登录。
 * @author 潘定遥
 * 注意：  实现需要保证线程安全
 */
public interface ILogoutFlagStorage {

	/**
	 * 增加一个退出标记
	 * @param logoutFlag (>=1)
	 */
	public void addLogoutFlag(int logoutFlag);
	
	public boolean existLogutFlag(int logoutFlag);
}
