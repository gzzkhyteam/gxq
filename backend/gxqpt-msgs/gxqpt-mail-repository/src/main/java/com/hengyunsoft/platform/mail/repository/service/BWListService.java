package com.hengyunsoft.platform.mail.repository.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mail.entity.core.po.FilterKeyword;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.example.BWListExample;

import java.util.List;

/**
 * @author zjr
 * @date 2018/08/08
 */
public interface BWListService extends BaseService<Long, BWList, BWListExample> {
	/**
	 * 查询黑名单分页列表
	 * @param queryBWDto
	 * @return
	 */
	List<BWList> findBWList(BWList bw);

	int insertFilterKeyWord(FilterKeyword fk);

	int deleteFilterKeyWord(Long id);

	List<FilterKeyword> getFilterKeywordAll(String filterWord);

	String checkKeyword(String subject,String content);
}
