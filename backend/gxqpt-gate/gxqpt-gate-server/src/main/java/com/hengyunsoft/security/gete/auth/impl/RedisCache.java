package com.hengyunsoft.security.gete.auth.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

import com.hengyunsoft.security.gete.utils.IShareCache;
public class RedisCache implements IShareCache {

//	@Autowired
	@Resource(name = "redisJdkTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void putFixedTimeout(String key, Object val, long timeout, TimeUnit unit) {
		
		redisTemplate.boundValueOps(key).set(val, timeout, unit);
	}

	@Override
	public void putRelativeTimeout(String key, Object val, long timeout, TimeUnit unit) {
		
		putFixedTimeout(key,new RelativeTimeoutEntity(val,timeout,unit), timeout, unit);
	}

	@Override
	public Object get(String key) {
//		return null;
		Object entity = redisTemplate.opsForValue().get(key);
		if(entity instanceof RelativeTimeoutEntity) {
			//
			RelativeTimeoutEntity date = (RelativeTimeoutEntity) entity;
			redisTemplate.boundValueOps(key).expire(date.getTimeout(), date.getUnit());
			return date.getVal();
		}
		return entity;
	}

	@Override
	public Object delete(String key) {
		Object obj = redisTemplate.boundValueOps(key).get();
		redisTemplate.delete(key);
		return obj;
	}

	public static class RelativeTimeoutEntity{
		private Object val;
		private long timeout;
		private TimeUnit unit;
		public Object getVal() {
			return val;
		}
		public void setVal(Object val) {
			this.val = val;
		}
		public long getTimeout() {
			return timeout;
		}
		public void setTimeout(long timeout) {
			this.timeout = timeout;
		}
		public TimeUnit getUnit() {
			return unit;
		}
		public void setUnit(TimeUnit unit) {
			this.unit = unit;
		}
		public RelativeTimeoutEntity(Object val, long timeout, TimeUnit unit) {
			super();
			this.val = val;
			this.timeout = timeout;
			this.unit = unit;
		}
	}
}
