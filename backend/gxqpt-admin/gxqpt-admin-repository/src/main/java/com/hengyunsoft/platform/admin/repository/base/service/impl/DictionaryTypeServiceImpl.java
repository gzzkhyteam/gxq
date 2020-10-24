package com.hengyunsoft.platform.admin.repository.base.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.platform.admin.entity.base.po.Area;
import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import com.hengyunsoft.platform.admin.repository.base.dao.DictionaryTypeMapper;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-24
 */
@Service
@Slf4j
public class DictionaryTypeServiceImpl extends BaseAllServiceImpl<Long, DictionaryType, DictionaryTypeExample> implements DictionaryTypeService {

    @Autowired
    private DictionaryTypeMapper dictionaryTypeMapper;

    @Override
    protected BaseAllDao<Long, DictionaryType, DictionaryTypeExample> getDao() {
        return dictionaryTypeMapper;
    }

    /**
     * 根据应用ID-appId查詢数据字典類型列表
     *
     * @param appId 应用id
     */
    @Override
    public List<DictionaryType> find(String appId) {
        DictionaryTypeExample example = new DictionaryTypeExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
        List<DictionaryType> dictionaryTypeList = dictionaryTypeMapper.selectByExample(example);
        return dictionaryTypeList;
    }

    @Override
    public List<DictionaryType> findByParentId(String appId,Long parentId) {
        return dictionaryTypeMapper.findByParentId(appId,parentId);
    }

    @Override
    public List<DictionaryType> getSubDictionaryList(String appId, Long id) {
        //区域及子区域ID列表
        List<DictionaryType> List = new ArrayList<>();

        //获取子区域ID
        List<DictionaryType> subIdList = findByParentId(appId,id);
        getTreeList(subIdList, List);

        return List;
    }
    /**
     * 递归
     */
    private void getTreeList(List<DictionaryType> subIdList, List<DictionaryType> List){
        for(DictionaryType d : subIdList){
            List<DictionaryType> list = findByParentId(d.getAppId(),d.getId());
            if(list.size() > 0){
                getTreeList(list, List);
            }

            List.add(d);
        }
    }
    /**
     * 根据应用ID-appId、字典編碼檢查数据字典是否已存在
     *
     * @param appId 应用id 、code字典编码
     */
    @Override
    public boolean check( String code) {
        DictionaryTypeExample example = new DictionaryTypeExample();
        example.createCriteria().andCodeEqualTo(code);
        return dictionaryTypeMapper.countByExample(example) > 0 ? true : false;
    }


}
