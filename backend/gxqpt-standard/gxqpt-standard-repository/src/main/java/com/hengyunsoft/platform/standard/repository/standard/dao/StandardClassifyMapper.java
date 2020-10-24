package com.hengyunsoft.platform.standard.repository.standard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;

@Repository
public interface StandardClassifyMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify, com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample> {
	/**
     * 运维文档数据获取
     * @param id ID（顶级）
	 * @param name 名称
     */
	List<StandardClassify> findDevOpsDocTree(@Param("treeId")Long treeId, @Param("name")String name);
	/**
	 * 通过类型ID获取该类型下的所有子节点ID
	 * 递归
	 * @param childs
	 * @return
	 */
	List<Long> findCurrentChildNodeId(@Param("childs")List<Long> childs);
}