package com.hengyunsoft.platform.exchange.repository.system.dao;

import com.hengyunsoft.platform.exchange.entity.system.domain.DictDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDictMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.system.po.ShareDict, com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample> {
    /**
     * 查询数据字典
     * @param pId 父目录ID
     * @return
     */
    public List<DictDO> queryDict(@Param("pId") String pId);

    /**
     * 获取当前最大排序号
     * @param
     * @return
     */
    public Integer getCurrIndexNo();

    /**
     * 根据父ID获得当前层级
     * @param
     * @return
     */
    public Integer getPidCurrLevel(String pId);
}