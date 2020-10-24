package com.hengyunsoft.security.gete.utils;

import java.util.concurrent.TimeUnit;

/**
 * 缓存共享接口
 * 保证系统被多节点部署的时候，大家共用缓存
 * @author Administrator
 *
 */
public interface IShareCache {

	/**
	 * 放入绝对固定超时时间的数据      当时间超过配置时间后，清除
	 * @param key
	 * @param val
	 * @param timeout 
	 */
	public  void putFixedTimeout(String key,Object val,long timeout,TimeUnit unit);
	/**
	 * 放入相对超时时间的数据    当前后两次的访问时间间隔超过设定的值，则后一次将取不到数据，类似于session机制
	 * @param key
	 * @param val
	 * @param timeout
	 */
	public  void putRelativeTimeout(String key,Object val,long timeout,TimeUnit unit);
	
	/**
	 * 获取数据
	 * @param key
	 * @return
	 */
	public Object get(String key);
	
	/**
	 * 删除数据
	 * @param key
	 * @return
	 */
	public Object delete(String key);
	
}
