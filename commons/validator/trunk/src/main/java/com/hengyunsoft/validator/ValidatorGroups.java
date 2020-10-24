package com.hengyunsoft.validator;
/**
 * 校验组集合
 * @author 潘定遥
 */
public class ValidatorGroups {

	/**
	 * 
	 * 不允许为空组
	 * @author 潘定遥
	 */
	public static interface MustNoneNull{};
	/**
	 * 忽略空组，就是允许空值
	 * @author 潘定遥
	 */
	public static interface IgnoreNull{};
}
