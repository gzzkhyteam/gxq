package com.hengyunsoft.platform.commons.utils;


import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * list列表 转换成tree列表
 * Created by Ace on 2017/6/12.
 */
public class TreeUtil {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {

            if (root.toString().equals(treeNode.getParentId().toString())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (treeNode.getId().equals(it.getParentId().toString())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<T>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 描述：根据父节点获取其所有子节点的树形结构，但不包含父节点信息
     * 参数：root 父Id
     * 参数：treeNodes 列表数据
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/9
     * 修改内容：
     */
    public static <T extends TreeNode> List<T> queryTree(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            String menuId = treeNode.getId().toString();
            String pid = treeNode.getParentId().toString();
            if (root.toString().equals(pid)) {
                List<T> c_node = queryTree(treeNodes, menuId);
                if (c_node.size() > 0) {
                    treeNode.setChildren(c_node);
                }
                trees.add(treeNode);
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.toString().equals(treeNode.getParentId().toString())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<T>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    /**
     * 根据id递归查找子节点
     *
     * @param id
     * @param treeNodes
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> T findChildren(String id, List<T> treeNodes) {
        T treeNode = null;
        for (T it : treeNodes) {
            if (it.getId().equals(id)) {
                treeNode = findChildren(it, treeNodes);
            }
        }
        return treeNode;
    }

    /**
     * 建立多个根节点树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode<T,? extends  Serializable>> List<T> buildByRecursives(List<T> treeNodes) {
        List<T> trees = new ArrayList<>();

        List<Serializable> p_ids = treeNodes.stream().map(T::getId).collect(Collectors.toList());
        for (T baseNode : treeNodes) {
            if (!p_ids.contains(baseNode.getParentId())) {
                trees.add(findChildren(baseNode, treeNodes));
            }
        }
        return trees;
    }
    
    /**
     * 复杂度O(N^2)<br/>
     * 建立多个根节点树   
     * 保证构造后的树中，同一级的节点间的相互顺序与在传入数据中的相互顺序保持一致。
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode<T,? extends  Serializable>> List<T> builderTreeOrdered(List<T> treeNodes) {
    	if(CollectionUtils.isEmpty(treeNodes)) {
    		return treeNodes;
    	}
    	///////////////////////////////////////为每一个节点找到子节点集合//////////////////////////////////////
    	for (T parent : treeNodes) {
    		Serializable id = parent.getId();
    		for (T children : treeNodes) {
    			if(id.equals(children.getParentId())) {
    				if(parent.getChildren() == null) {
    					parent.setChildren(new ArrayList<T>());
    				}
    				parent.getChildren().add(children);
    			}
    		}
		}
    	//////////////////////////////////////找出根节点集合///////////////////////////////////////
    	List<T> trees = new ArrayList<>();
    	List<Serializable> p_ids = treeNodes.stream().map(T::getId).collect(Collectors.toList());
    	for (T baseNode : treeNodes) {
    		if (!p_ids.contains(baseNode.getParentId())) {
    			trees.add(baseNode);
    		}
    	}
    	/////////////////////////////////////////////////////////////////////////////
    	return trees;
    }
}
