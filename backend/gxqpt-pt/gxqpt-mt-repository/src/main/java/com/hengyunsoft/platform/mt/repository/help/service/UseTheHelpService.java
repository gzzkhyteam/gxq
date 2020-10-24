package com.hengyunsoft.platform.mt.repository.help.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.help.po.UseTheHelp;
import com.hengyunsoft.platform.mt.repository.help.example.UseTheHelpExample;

import java.util.List;
import java.util.Map;

public interface UseTheHelpService extends BaseService<Long,UseTheHelp,UseTheHelpExample>{
    /**
     * 查询使用帮助文档列表息
     * @param
     */
    List<UseTheHelp> getPageList(Map map);
}
