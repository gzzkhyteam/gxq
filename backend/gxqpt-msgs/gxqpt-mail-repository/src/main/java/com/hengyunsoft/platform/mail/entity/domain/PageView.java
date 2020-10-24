package com.hengyunsoft.platform.mail.entity.domain;

import java.util.List;

import com.hengyunsoft.platform.mail.constant.MailConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 封装页面信息

 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 * @param <T>
 */

@ApiModel(value = "PageView", description = "分页视图")
public class PageView<T> {
	/** 分页数据 **/
	@ApiModelProperty(value = "分页数据")
	private List<T> records;
	/** 页码开始索引和结束索引 **/
	@ApiModelProperty(value = "页码开始索引和结束索引")
	private PageIndex pageindex;
	/** 总页数 **/
	@ApiModelProperty(value = "总页数")
	private long totalpage = 1;
	/** 每页显示记录数 **/
	@ApiModelProperty(value = "每页显示记录数")
	private int maxresult = 12;
	/** 当前页 **/
	@ApiModelProperty(value = "当前页")
	private int currentpage = 1;
	/** 总记录数 **/
	@ApiModelProperty(value = "总记录数")
	private long totalrecord;
	/** 页面顶部要显示的页码数量 **/
	@ApiModelProperty(value = "页面顶部要显示的页码数量")
	private int pagecode = MailConstant.PAGE_COUNT;
	/** 新邮件总数 **/
	@ApiModelProperty(value = "新邮件总数")
	private int newMailTotal;
	/** 未读邮件总数 */
	@ApiModelProperty(value = "未读邮件总数")
	private int unreadMailTotal;

	/** 要获取记录的开始索引 **/
	public int getFirstResult() {
		return (this.currentpage - 1) * this.maxresult;
	}

	/**
	 * 页面顶部要显示的页码数量
	 * 
	 * @return int pagecode 页码数量
	 */
	public int getPagecode() {
		return pagecode;
	}

	/**
	 * 设置页码数量
	 */
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	/**
	 * 构造方法（封装页面信息）
	 * 
	 * @param maxresult
	 *            每页显示的记录条数
	 * @param currentpage
	 *            当前页
	 */
	public PageView(int maxresult, int currentpage) {
		this.maxresult = maxresult;
		this.currentpage = currentpage;
	}

	/**
	 * 设置结果集
	 * 
	 * @param QueryResult
	 *            <T> qr 数据总数，记录列表信息
	 */
	public void setQueryResult(QueryResult<T> qr) {
		setTotalrecord(qr.getTotalRecord());
		setRecords(qr.getResultList());
	}

	/**
	 * 设置结果集（列表，总记录数）
	 * 
	 * @param list
	 *            元素列表
	 * @param totalRecord
	 *            总记录数
	 */
	public void setQueryResult(List<T> list, long totalRecord) {
		setTotalrecord(totalRecord);
		setRecords(list);
	}

	/**
	 * 得到记录总数
	 * 
	 * @return long totalrecord
	 */
	public long getTotalrecord() {
		return totalrecord;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param totalrecord
	 */
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage(this.totalrecord % this.maxresult == 0 ? this.totalrecord
				/ this.maxresult : this.totalrecord / this.maxresult + 1);
	}

	/**
	 * 得到记录信息
	 * 
	 * @return List<T> 记录信息的列表
	 */
	public List<T> getRecords() {
		return records;
	}

	/**
	 * 设置List类型的记录信息
	 * 
	 * @param records
	 */
	public void setRecords(List<T> records) {
		this.records = records;
	}

	public PageIndex getPageindex() {
		return pageindex;
	}

	/**
	 * 返回总页数
	 * 
	 * @return long totalpage
	 */
	public long getTotalpage() {
		return totalpage;
	}

	/**
	 * 设置总页数
	 * 
	 * @param totalpage
	 */
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		this.pageindex = PageIndex.getPageIndex(pagecode, currentpage,
				totalpage);
	}

	/**
	 * 得到最大记录数（页面中一页最多显示记录数）
	 * 
	 * @return
	 */
	public int getMaxresult() {
		return maxresult;
	}

	/**
	 * 得到当前页
	 * 
	 * @return int currentpage
	 */
	public int getCurrentpage() {
		return currentpage;
	}

	/**
	 * 得到新邮件总数
	 * 
	 * @return int 新邮件数
	 */
	public int getNewMailTotal() {
		return newMailTotal;
	}

	/**
	 * 设置新邮件个数
	 * 
	 * @param int newMailTotal 新邮件个数
	 */
	public void setNewMailTotal(int newMailTotal) {
		this.newMailTotal = newMailTotal;
	}

	/**
	 * 得到未读邮件个数
	 * 
	 * @return int 未读邮件
	 */
	public int getUnreadMailTotal() {
		return unreadMailTotal;
	}

	/**
	 * 设置未读邮件
	 * 
	 * @param unreadMailTotal
	 */
	public void setUnreadMailTotal(int unreadMailTotal) {
		this.unreadMailTotal = unreadMailTotal;
	}

	/**
	 * 设置新邮件个未读邮件数
	 * 
	 * @param newMailTotal
	 *            新邮件数
	 * @param unreadMailTotal
	 *            未读邮件数
	 */
	public void setNewAndUnreadMail(int newMailTotal, int unreadMailTotal) {
		setNewMailTotal(newMailTotal);
		setUnreadMailTotal(unreadMailTotal);
	}
}
