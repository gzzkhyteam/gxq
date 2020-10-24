package com.hengyunsoft.validator;

import java.util.List;
/**
 * 字段校验规则信息
 * @author 潘定遥
 *
 */
public class FieldValidatorDesc {

	/**
	 * 字段名称
	 */
	private String fieldName;
	/**
	 * 字段所在的类名称短名称（也可以叫做领域名称）
	 */
	private String domainName;
	/**
	 * 字段的类型
	 */
	private String fieldType;
	/**
	 * 约束集合
	 */
	private List<ConstraintInfo> constraints;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}


	public List<ConstraintInfo> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<ConstraintInfo> constraints) {
		this.constraints = constraints;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
}
