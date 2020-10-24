package com.hengyunsoft.platform.hardware.repository.dic.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.dic.po.Dictionary;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryExample;

public interface DictionaryService extends BaseService<Long, Dictionary, DictionaryExample> {
    /**
     * 保存数据字典
     */
    void saveDictionary(Dictionary dictionary);
}
