package com.hengyunsoft.platform.supervise.util;

import java.util.ArrayList;
import java.util.List;

import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;

public class Utils {
	/**
	 * 查询预警类型树
	 * @param treeNodes
	 * @param trees
	 * @return
	 */
    public static List<GxqptWarnType> selectTrees(List<GxqptWarnType> treeNodes, List<GxqptWarnType> trees){
    	List<GxqptWarnType> gxqptWarnTypeList = new ArrayList<GxqptWarnType>();
    	if(treeNodes==null){
    		return null;
    	}
    	for (GxqptWarnType treeNode : treeNodes){
            List<GxqptWarnType> children = getChildren(treeNode.getId(),trees);
            gxqptWarnTypeList.addAll(children);
            if(children!=null && children.size()>0){
                selectTrees(children,trees);
            }
        }
        return gxqptWarnTypeList;
    }
    /**
     * 获取预警子类型树
     * @param id
     * @param list
     * @return
     */
    public static List<GxqptWarnType> getChildren(Long id,List<GxqptWarnType> list){
    	List<GxqptWarnType> gxqptWarnTypeList = new ArrayList<GxqptWarnType>();
    	if(list==null||id==null){
    		return null;
    	}
    	for(GxqptWarnType gxqptWarnType:list){
    		if(gxqptWarnType.getParentId().equals(id)){
    			gxqptWarnTypeList.add(gxqptWarnType);
    		}    		
    	}
		return gxqptWarnTypeList;
    }
}
