package com.hengyunsoft.platform.developer.repository.fast.attence.dao;

import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceList;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceListExample;
import org.springframework.stereotype.Repository;

@Repository
public interface AttenceListMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, AttenceList, AttenceListExample> {
}