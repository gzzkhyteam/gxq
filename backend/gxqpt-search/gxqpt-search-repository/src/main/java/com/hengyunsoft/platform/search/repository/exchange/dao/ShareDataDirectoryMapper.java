package com.hengyunsoft.platform.search.repository.exchange.dao;



import com.hengyunsoft.platform.search.entity.core.po.ShareDataDirectory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShareDataDirectoryMapper{

    /**
     * 查询所有数据目录列表
     * @param
     */
    List<ShareDataDirectory> getAllList();

}