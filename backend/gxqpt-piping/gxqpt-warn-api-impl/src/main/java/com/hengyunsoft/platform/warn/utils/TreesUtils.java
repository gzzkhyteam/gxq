package com.hengyunsoft.platform.warn.utils;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.warn.api.warntype.dto.WarnTreeListDTO;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnTypeMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TreesUtils {

    @Autowired
    private GxqptWarnTypeService gxqptWarnTypeService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptWarnTypeMapper gxqptWarnTypeMapper;
   /**
    * 获取只是启用的类型树
    * */
    public List<Long> getTypeIdList(Long typeId){
        String rootId = null;
        //2.1.查询所有的父id、id、类型名称
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        gxqptWarnTypeExample.createCriteria().andIsEnableEqualTo(true);
        gxqptWarnTypeExample.setOrderByClause("parent_id");
        List<GxqptWarnType> typeListAll = gxqptWarnTypeService.find(gxqptWarnTypeExample);
        List<Long> typeIdList = new ArrayList<Long>();
        if (typeListAll != null) {
            List<WarnTreeListDTO> treeList = dozerUtils.mapList(typeListAll, WarnTreeListDTO.class);
            if (typeId != null) {
                for (WarnTreeListDTO tree : treeList) {
                    if (tree.getId() == typeId) {
                        tree.setChecked(true);
                        break;
                    }
                }
            }
            if(typeId!=null){
                List<WarnTreeListDTO> treeList1 = TreeUtil.build(treeList, typeId);
                //2.1.1.根据父类查询子类

                List<WarnTreeListDTO> trees = new ArrayList<>();
                trees =  selectTrees(treeList1,trees);
                if (trees!=null && trees.size()!=0){
                    for (WarnTreeListDTO warnTreeListDTO : trees){
                        typeIdList.add(warnTreeListDTO.getId());
                    }
                }else {
                    GxqptWarnType gxqptWarnType = gxqptWarnTypeMapper.selectByPrimaryKey(typeId);
                    if (gxqptWarnType!=null){
                        Long ids = gxqptWarnType.getId();
                        typeIdList.add(ids);
                    }
                }
            }
        }
        return typeIdList;
    }

    /**
     * 获取所有预警类型的树(包括启用 和 禁用的)
     * */

    public List<Long> getAllTypeIdList(Long typeId){
        //2.1.查询所有的父id、id、类型名称
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        gxqptWarnTypeExample.createCriteria().andIdEqualTo(typeId);
        if(null == typeId){
            return null;
        }
        GxqptWarnType type = gxqptWarnTypeService.getById(typeId);
        //获取子类型
        List<Long> ids = new ArrayList<>();
        List<Long> childById = getChildById(type.getId(), ids);

        return childById;
    }

    /**
     * 获取预警子类型
     * */
    private List<Long> getChildById(Long typeId, List<Long> ids){

        ids.add(typeId);
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        gxqptWarnTypeExample.createCriteria().andParentIdEqualTo(typeId);
        List<GxqptWarnType> gxqptWarnTypes = gxqptWarnTypeService.find(gxqptWarnTypeExample);

        if(gxqptWarnTypes.size() > 0){
            for (GxqptWarnType gxqptWarnType: gxqptWarnTypes) {
                getChildById(gxqptWarnType.getId(),ids);
            }
        }
        return ids;
    }


    /**
     * 获取预警子类型递归
     * @param treeNodes
     * @param trees
     * @return
     */
    private static List<WarnTreeListDTO> selectTrees( List<WarnTreeListDTO> treeNodes, List<WarnTreeListDTO> trees){
        for (WarnTreeListDTO treeNode : treeNodes){
            List<WarnTreeListDTO> children = treeNode.getChildren();
            if(children!=null && children.size()>0){
                selectTrees(children,trees);
            }
            trees.add(treeNode);
        }
        return trees;
    }
}
