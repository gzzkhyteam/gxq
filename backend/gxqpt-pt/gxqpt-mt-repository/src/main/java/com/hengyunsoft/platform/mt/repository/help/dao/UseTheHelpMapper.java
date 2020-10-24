package com.hengyunsoft.platform.mt.repository.help.dao;

import com.hengyunsoft.platform.mt.entity.help.po.UseTheHelp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UseTheHelpMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, UseTheHelp, com.hengyunsoft.platform.mt.repository.help.example.UseTheHelpExample> {
    /**
     * 查询使用帮助文档列表息
     * @param
     */
    List<UseTheHelp> getPageList(Map map);
}