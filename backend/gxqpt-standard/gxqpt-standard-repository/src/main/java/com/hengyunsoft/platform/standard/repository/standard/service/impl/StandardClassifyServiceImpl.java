package com.hengyunsoft.platform.standard.repository.standard.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.repository.standard.dao.StandardClassifyMapper;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;

@Service
public class StandardClassifyServiceImpl extends BaseAllServiceImpl<Long, StandardClassify, StandardClassifyExample> implements StandardClassifyService {
    @Autowired
    private StandardClassifyMapper standardClassifyMapper;

    @Override
    protected BaseNormalDao<Long, StandardClassify, StandardClassifyExample> getDao() {
        return standardClassifyMapper;
    }
    /**
     * 获取数据
     * @param id ID（顶级）
	 * @param name 名称
     */
	@Override
	public List<StandardClassify> findDevOpsDocTree(String id, String name) {
		Long treeId = Long.parseLong(id);
		// 通过名称模糊查询
		List<StandardClassify> list = standardClassifyMapper.findDevOpsDocTree(null,name);
		if(list!=null && list.size() > 0) {
			list = commonStandardClassify(list,new ArrayList<StandardClassify>());
		}
		// 不管怎么都要把顶级数据查出来
		list.addAll(list.size(), standardClassifyMapper.findDevOpsDocTree(treeId,null));
		// 去掉重复的数据
		List<StandardClassify> collect = list.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))), ArrayList::new));
		return collect;
	}
	/**
	 * 递归获取获取存储数据
	 * @param list 初始化数据
	 * @param classifys 存储数据
	 * @return
	 */
	private List<StandardClassify> commonStandardClassify(List<StandardClassify> list,List<StandardClassify> classifys){
		
		if(list.size()>0) {
			for(StandardClassify en : list) {
				classifys.add(en);// 数据存储
				// 通过父级ID获取数据
				List<StandardClassify> findDevOpsDocTree = standardClassifyMapper.findDevOpsDocTree(en.getParentId(),null);
				commonStandardClassify(findDevOpsDocTree,classifys);
			}
		}
		
		return classifys;
	}
	@Override
	public List<Long> findCurrentChildNodeIds(List<Long> childs) {
		// 获取所有的递归数据
		List<Long> allNodeIds = getALlRecursionChildNodeId(childs,childs);
		// 去重
		List<Long> nodeIds = allNodeIds.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o))), ArrayList::new));
		return nodeIds;
	}
	
	/**
	 * 递归
	 * 通过类型ID获取该类型下的所有子节点ID
	 * @param typeId
	 */
	private List<Long> getALlRecursionChildNodeId (List<Long> childs,List<Long> allNodeIds) {
		//获取当前子节点的ID
		List<Long> list =  standardClassifyMapper.findCurrentChildNodeId(childs);
		if(list!=null && list.size()>0) {
			for(Long id:list) {
				allNodeIds.add(id);
				getALlRecursionChildNodeId(list,allNodeIds);
			}
		}
		return allNodeIds;
		
	}
}
