package com.hengyunsoft.platform.hardware.repository.dic.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.dic.po.DictionaryType;
import com.hengyunsoft.platform.hardware.repository.dic.dao.DictionaryTypeMapper;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryTypeExample;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DictionaryTypeCopyServiceImpl extends BaseServiceImpl<Long, DictionaryType, DictionaryTypeExample> implements DictionaryTypeService {

    @Autowired
    DictionaryTypeMapper dictionaryTypeMapper;

    @Override
    protected BaseNormalDao<Long, DictionaryType, DictionaryTypeExample> getDao() {
        return dictionaryTypeMapper;
    }




}