package com.hengyunsoft.platform.standard.utils;

import com.hengyunsoft.platform.standard.dto.StandardClassifyTreeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnTreeUtills {

    /**
     * 将list转为树tree结构
     * @param allRrecords 集合数据
     * @return
     */
    public static List<StandardClassifyTreeDTO> useListRecordToTree(List<StandardClassifyTreeDTO> allRrecords,String id) {

        List<StandardClassifyTreeDTO> listParentRecord = new ArrayList<StandardClassifyTreeDTO>();
        List<StandardClassifyTreeDTO> listNotParentRecord = new ArrayList<StandardClassifyTreeDTO>();
        // 第一步：遍历allRrecords保存所有数据的uuid用于判断是不是根节点
        Map<String, String> mapAllUuid = new HashMap<String, String>();
        Map<String, StandardClassifyTreeDTO> allRecordMap = new HashMap<String, StandardClassifyTreeDTO>();

        for (StandardClassifyTreeDTO resObj:allRrecords){
            if(id.equals(resObj.getId())){
                listParentRecord.add(resObj);
            }else{
                listNotParentRecord.add(resObj);
            }
        }

        // 第三步： 递归获取所有子节点
        if (listParentRecord.size() > 0) {
            for (StandardClassifyTreeDTO record : listParentRecord) {
                // 添加所有子级
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getId().toString()));
            }
        }
        return listParentRecord;
    }

    /**
     * 递归查询子节点
     * @param childList 所有子节点
     * @param parentUuid 父节点
     * @return
     */
    private static List<StandardClassifyTreeDTO> getTreeChildRecord(List<StandardClassifyTreeDTO> childList, String parentUuid) {
        List<StandardClassifyTreeDTO> listParentRecord = new ArrayList<StandardClassifyTreeDTO>();
        List<StandardClassifyTreeDTO> listNotParentRecord = new ArrayList<StandardClassifyTreeDTO>();
        // 遍历tmpList，找出所有的根节点和非根节点
        if (childList != null && childList.size() > 0) {
            for (StandardClassifyTreeDTO record : childList) {
                // 对比找出父节点
                String pId=record.getParentId().toString();
                if (pId.equals(parentUuid)) {
                    listParentRecord.add(record);
                } else {
                    listNotParentRecord.add(record);
                }

            }
        }
        // 查询子节点
        if (listParentRecord.size() > 0) {
            for (StandardClassifyTreeDTO record : listParentRecord) {
                // 递归查询子节点
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getId().toString()));
            }
        }
        return listParentRecord;
    }

}
