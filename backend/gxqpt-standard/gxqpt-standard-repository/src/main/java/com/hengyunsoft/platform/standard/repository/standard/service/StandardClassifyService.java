package com.hengyunsoft.platform.standard.repository.standard.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample;

public interface StandardClassifyService extends BaseAllService<Long, StandardClassify, StandardClassifyExample> {
	/**
     * 运维文档数据获取
     * @param id ID（顶级）
	 * @param name 名称
     */
	List<StandardClassify> findDevOpsDocTree(String treeId, String name);
	/**
	 * 通过类型ID获取该类型下的所有子节点ID
	 * 递归
	 * @param childs
	 * @return
	 */
	List<Long> findCurrentChildNodeIds(List<Long> childs);
}
