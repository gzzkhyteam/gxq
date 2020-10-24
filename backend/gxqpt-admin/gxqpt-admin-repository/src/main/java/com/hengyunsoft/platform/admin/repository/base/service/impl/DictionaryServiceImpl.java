package com.hengyunsoft.platform.admin.repository.base.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.platform.admin.entity.base.domain.DictionaryMaintainDO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.repository.base.dao.DictionaryMapper;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
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
public class DictionaryServiceImpl extends BaseAllServiceImpl<Long, Dictionary, DictionaryExample> implements DictionaryService {


    @Autowired
    private DictionaryMapper dictionaryMapper;


    @Override
    protected BaseAllDao<Long, Dictionary, DictionaryExample> getDao() {
        return dictionaryMapper;
    }

    /**
     * 根据应用ID-appId、字典类型ID-typeId查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    @Override
    public List<Dictionary> findByTypeId(String appId, Long typeId) {
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andAppIdEqualTo(appId).andDictionaryTypeIdEqualTo(typeId)
                .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                .andIsEnableEqualTo(EnableStatus.ENABLE.getVal());
        example.setOrderByClause("order_num asc");
        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        return dictionaryList;
    }

    /**
     * 根据应用ID-appId、字典类型ID-typeId删除数据字典表信息
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    @Override
    public int deleteByAppIdAndTypeId(String appId, Long typeId) {
        return dictionaryMapper.deleteByAppIdAndTypeId(appId, typeId);
    }

    /**
     * @wangzhen 2018-3-15
     * 根据应用ID-appId、字典类型ID-typeId查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    @Override
    public List<List<Dictionary>> findByTypeId(String appId, Long[] typeIds) {
        List<List<Dictionary>> list = new ArrayList<>();
        for (Long typeId : typeIds) {
            list.add(findByTypeId(appId, typeId));
        }
        return list;
    }
    /**
     * @wangzhen 2018-3-15
     * 根据应用ID-appId、字典类型ID-typeId查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */

    @Override
    public List<List<Dictionary>> findByTypeCode(String[] typeCodes) {
        List<List<Dictionary>> list = new ArrayList<>();
        for (String typeCode : typeCodes) {
            list.add(findByTypeCode(typeCode));
        }
        return list;
    }

    /**
     * 查询唯一code
     * @param code
     * @return
     */
    @Override
    public Dictionary findByCode(String code) {
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andCodeEqualTo(code);
        return getUnique(example);
    }

    /**
     * 根据功能名查询
     * */
    @Override
    public Dictionary findByName(String name) {
        return dictionaryMapper.findByName(name);
    }

    /**
     * 根据id（逻辑）删除功能
     * */
    @Override
    public int delById(Dictionary dictionary) {

        return dictionaryMapper.delById(dictionary);
    }

    /**
     * 根据code查询数据字典(默认加appId)
     * @param code,appId
     * @return
     */
    @Override
    public List<Dictionary> findByCodeList(String appId,String code) {
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andAppIdEqualTo(appId)
                                .andDictionaryTypeCodeEqualTo(code)
                                .andIsDeleteEqualTo(false);//@modify:madb  2018/5/3
        example.setOrderByClause(" order_num asc ");
        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        return dictionaryList;


    }

    /**
     * 应用类型维护 修改
     * @param dictionary
     * @return
     */
    @Override
    public int updateDictionaryById(Dictionary dictionary) {
        return dictionaryMapper.updateDictionaryById(dictionary);
    }

    /**
     * 应用类型维护 保存
     * @param dictionary
     * @return
     */
    @Override
    public int saveDictionaryById(Dictionary dictionary) {
        return dictionaryMapper.insertSelective(dictionary);
    }

    /**
     * 根据应用ID-appId、字典类型ID-typeId查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    @Override
    public List<Dictionary> findByTypeCode(String typeCode) {
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andDictionaryTypeCodeEqualTo(typeCode)
                .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                .andIsEnableEqualTo(EnableStatus.ENABLE.getVal());
        example.setOrderByClause("order_num asc");
        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        return dictionaryList;
    }

    /**
     * 查询单位的所有字典
     * @return
     */
    @Override
    public List findOrgDictionary() {
        return dictionaryMapper.findOrgDictionary();
    }

    /**
     * 应用类型维护查询
     * @return
     */
    @Override
    public List<DictionaryMaintainDO> findAppMaintainPage(String typeCode, String appId) {
        return dictionaryMapper.findAppMaintainPage(typeCode, appId);
    }

    /**
     * 功能类型维护查询
     * @param typeCode
     * @param name
     * @return
     */
    @Override
    public List<DictionaryMaintainDO> findModMaintainPage(String typeCode,String appId) {
        return dictionaryMapper.findModMaintainPage(typeCode, appId);
    }

    /**
     * 判断字段code是否存在
     * @param appId
     * @param code
     * @return
     */
    @Override
    public boolean check( String code,String typeCode) {
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andCodeEqualTo(code).andDictionaryTypeCodeEqualTo(typeCode);
        return dictionaryMapper.countByExample(example) > 0 ? true : false;
    }
}
