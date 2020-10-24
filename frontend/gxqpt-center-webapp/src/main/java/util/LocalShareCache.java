package util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class LocalShareCache implements IShareCache {

	private ConcurrentHashMap<String, CacheEntity> kv = new ConcurrentHashMap<>();
	/**
	 * 是否在剔除数据中 只需要同时只有一个线程在剔除数据即可
	 */
	private AtomicBoolean removeing = new AtomicBoolean(false);
	/**
	 * 前后两次的移除时间间隔
	 */
	private final long remove_interval_ms = 5 * 1000;
	/**
	 * 
	 */
	private volatile long next_remove_time_ms = System.currentTimeMillis();

	@Override
	public void putFixedTimeout(String key, Object val, long timeout) {

		removeTimeoutDate();
		if (val == null) {
			return;
		}
		long nextTimeout = timeout + System.currentTimeMillis();
		CacheEntity entity = new CacheEntity(val, timeout, true, nextTimeout);
		kv.put(key, entity);
	}

	@Override
	public void putRelativeTimeout(String key, Object val, long timeout) {

		removeTimeoutDate();
		if (val == null) {
			return;
		}
		long nextTimeout = timeout + System.currentTimeMillis();
		CacheEntity entity = new CacheEntity(val, timeout, false, nextTimeout);
		kv.put(key, entity);
	}

	@Override
	public Object get(String key) {

		removeTimeoutDate();
		CacheEntity obj = kv.get(key);

		if (obj == null) {
			return null;
		}
		long curr = System.currentTimeMillis();
		if (!isTimeout(curr, obj)) {
			// 只能够获取到没有过期的的数据
			if (!obj.fixedTimeout) {
				// 更新非固定时间的下一次过期时间
				obj.setNextTimeout(curr + obj.timeout);
			}
			return obj.val;
		} else {
			// 移除过期的数据
			kv.remove(key);
			return null;
		}
	}

	@Override
	public Object delete(String key) {

		removeTimeoutDate();
		if (key == null) {
			return null;
		}
		CacheEntity entity = kv.remove(key);
		if (entity == null) {
			return null;
		}
		if (!isTimeout(System.currentTimeMillis(), entity)) {

			return entity.val;
		}
		return null;
	}

	/**
	 * 剔除过期数据
	 */
	private void removeTimeoutDate() {

		long curr = System.currentTimeMillis();
		if (removeing.compareAndSet(false, true)) {
			// 这里面任何时刻有且仅有一个线程在内部执行   所以updateNextRemoveTime方法是在单线程中进行执行的，只要保证内存可见即可
			if (updateNextRemoveTime(curr)) {
				// 可以更新下一次移除时间 说明可以进行一次移除
				Collection<CacheEntity> entities = kv.values();
				for (CacheEntity cacheEntity : entities) {
					if (isTimeout(curr, cacheEntity)) {
						entities.remove(cacheEntity);
					}
				}
			}
			removeing.set(false);
		}

	}

	private boolean updateNextRemoveTime(long curr) {

		if (curr >= next_remove_time_ms) {
			// 超过下一次移除时间
			next_remove_time_ms = curr + remove_interval_ms;
			return true;
		}
		return false;
	}

	/**
	 * 判断是否过期
	 * 
	 * @param curr
	 * @param cacheEntity
	 * @return
	 */
	private boolean isTimeout(long curr, CacheEntity cacheEntity) {

		return curr > cacheEntity.getNextTimeout();
	}

	private static class CacheEntity {

		/**
		 * 值
		 */
		private final Object val;
		/**
		 * 超时时间
		 */
		private final long timeout;
		/**
		 * 下一次超时时间
		 */
		private final AtomicLong nextTimeout;
		/**
		 * 是否固定超时时间
		 */
		private final boolean fixedTimeout;

		public CacheEntity(Object val, long timeout, boolean fixedTimeout, long nextTimeout) {
			super();
			this.val = val;
			this.timeout = timeout;
			this.fixedTimeout = fixedTimeout;
			this.nextTimeout = new AtomicLong(nextTimeout);
		}

		public void setNextTimeout(long nextTimeout) {
			this.nextTimeout.set(nextTimeout);
		}

		public long getNextTimeout() {
			return this.nextTimeout.get();
		}

		@Override
		public String toString() {
			return "CacheEntity [val=" + val + ", timeout=" + timeout + ", nextTimeout=" + nextTimeout
					+ ", fixedTimeout=" + fixedTimeout + "]";
		}
	}

}
