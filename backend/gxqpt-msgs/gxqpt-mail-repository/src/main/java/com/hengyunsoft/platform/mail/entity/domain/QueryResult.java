package com.hengyunsoft.platform.mail.entity.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类说明：分页数据结果类
 *
 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 */

@ApiModel(value = "QueryResult", description = "分页数据结果类")
public class QueryResult<T> {

	/**
	 * 结果列表
	 */
	@ApiModelProperty(value = "结果列表")
	private List<T> resultList;
	/**
	 * 记录的总数
	 */
	@ApiModelProperty(value = "记录的总数")
	private long totalRecord;

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

}
