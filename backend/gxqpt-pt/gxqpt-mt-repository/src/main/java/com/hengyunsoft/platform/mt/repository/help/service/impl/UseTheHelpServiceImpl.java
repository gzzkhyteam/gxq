package com.hengyunsoft.platform.mt.repository.help.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.help.po.UseTheHelp;
import com.hengyunsoft.platform.mt.repository.help.dao.UseTheHelpMapper;
import com.hengyunsoft.platform.mt.repository.help.example.UseTheHelpExample;
import com.hengyunsoft.platform.mt.repository.help.service.UseTheHelpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class UseTheHelpServiceImpl extends BaseServiceImpl<Long,UseTheHelp,UseTheHelpExample> implements UseTheHelpService {

    @Autowired
    private UseTheHelpMapper useTheHelpMapper;

    @Override
    public List<UseTheHelp> getPageList(Map map) {
        return useTheHelpMapper.getPageList(map);
    }

    @Override
    protected BaseNormalDao<Long, UseTheHelp, UseTheHelpExample> getDao() {
        return useTheHelpMapper;
    }
}
