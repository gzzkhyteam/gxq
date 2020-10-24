package com.hengyunsoft.platform.hardware.repository.dic.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.hardware.entity.dic.po.Dictionary;
import com.hengyunsoft.platform.hardware.repository.dic.dao.DictionaryMapper;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryExample;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryService;
import com.hengyunsoft.platform.hardware.util.pinyin.Pinyin4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DictionaryCopyServiceImpl extends BaseServiceImpl<Long, Dictionary, DictionaryExample> implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    protected BaseNormalDao<Long, Dictionary, DictionaryExample> getDao() {
        return dictionaryMapper;
    }

    /**
     * 保存数据字典
     */
    @Override
    public void saveDictionary(Dictionary dictionary) {
        Long adminId = BaseContextHandler.getAdminId();
        dictionary.setId(genId());
        dictionary.setCreateTime(new Date());
        dictionary.setUpdateTime(new Date());
        dictionary.setCreateUser(adminId);
        dictionary.setUpdateUser(adminId);
        String code= dictionary.getDictionaryTypeCode()+ "_"+Pinyin4jUtil.getSimplePinyinHeadChar(dictionary.getName());
        dictionary.setCode(code);
        dictionary.setIsDelete(false);
        dictionary.setIsEnable(true);
        dictionaryMapper.insert(dictionary);

    }
}
