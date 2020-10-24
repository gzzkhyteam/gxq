package com.hengyunsoft.security.logoutflag.impl;

import java.util.concurrent.atomic.AtomicReferenceArray;

import com.hengyunsoft.security.logoutflag.ILogoutFlagStorage;

public class LogoutFlagManager implements ILogoutFlagStorage{

	/**
	 * 持有桶的原子数组
	 */
	private final AtomicReferenceArray<ArraylistLogoutFlagStorage> flagStorages ;

	/**
	 * 前后两次换桶的时间
	 * 这里使用了139分钟。基本是2小时19分钟进行一次换桶
	 */
	private final static int CHANGE_CONTAINER_TIME = 1 << 23;
	/**
	 * 记录当前使用的是哪一个桶
	 */
	private volatile int currentStoreFlagsIndex = 0;
	/**
	 * 换桶的时候，需要进行锁操作，此作为锁对象
	 */
	private final  Object changeStoreageFlage = new Object();
	public LogoutFlagManager() {

		//初始化桶    使得桶永远不可能是null的桶  后继操作可以不用担心null的情况
		ArraylistLogoutFlagStorage[] stores = new ArraylistLogoutFlagStorage[2];
		stores[0] = new ArraylistLogoutFlagStorage(50);
		stores[1] = new ArraylistLogoutFlagStorage(50);
		flagStorages = new AtomicReferenceArray<>(stores);
	}
	@Override
	public void addLogoutFlag(int logoutFlag) {
		long currentTimeMillis = System.currentTimeMillis();
		//用当前时间与换桶时间相比较，若到达换桶时间，则将进行换桶操作。
		int flagStoragesIndex = (currentTimeMillis & CHANGE_CONTAINER_TIME) == 0 ? 0:1;
		if(currentStoreFlagsIndex != flagStoragesIndex) {
			//进入换桶
			synchronized(changeStoreageFlage) {
				//换桶的时候需要进行加锁   
				if(currentStoreFlagsIndex != flagStoragesIndex) {
					//争抢到了换桶的机会   切换成另外一只桶
					flagStorages.set(flagStoragesIndex,  new ArraylistLogoutFlagStorage(50));
					currentStoreFlagsIndex = flagStoragesIndex; //标记当前桶为： flagStoragesIndex
				}
			}
		}
		flagStorages.get(flagStoragesIndex).addLogoutFlag(logoutFlag);
	}

	@Override
	public boolean existLogutFlag(int logoutFlag) {
		
		ILogoutFlagStorage first = flagStorages.get(0);
		ILogoutFlagStorage second = flagStorages.get(1);
		return first.existLogutFlag(logoutFlag) || second.existLogutFlag(logoutFlag);
	}
}
