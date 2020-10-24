package com.hengyunsoft.platform.search.repository.exchange.dao;


import com.hengyunsoft.platform.search.entity.core.po.ShareDataApiIndex;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShareDataApiMapper {

    /**
     * 查询所有可用API列表
     * @param
     */
    List<ShareDataApiIndex> getAllApiList();

}