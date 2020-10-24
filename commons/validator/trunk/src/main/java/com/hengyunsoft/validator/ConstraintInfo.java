package com.hengyunsoft.validator;

import java.util.Map;

/**
 * 
 * 检验约束信息
 * 
 * @author 潘定遥
 *
 */
public class ConstraintInfo {

	/**
	 * 约束对象的类型
	 */
	private String type;
	/**
	 * 约束属性
	 */
	private Map<String,Object> attrs;
	
	private ConstraintInfo() {}
	
	public String getType() {
		return type;
	}
	
	public Map<String, Object> getAttrs() {
		return attrs;
	}
	
	@Override
	public String toString() {
		return "Constraint [type=" + type + ", attrs=" + attrs + "]";
	}
	
	public static Builder builder() {
		
		return new Builder();
	}
	
	public static class Builder{
		
		private ConstraintInfo target = new ConstraintInfo();
		
		
		
		public Builder setAttrs(Map<String, Object> attrs) {
			this.target.attrs = attrs;
			return this;
		}
		
		public Builder setType(String type) {
			this.target.type = type;
			return this;
		}
		
		public ConstraintInfo builder() {
			return target ;
		}
	}
}
