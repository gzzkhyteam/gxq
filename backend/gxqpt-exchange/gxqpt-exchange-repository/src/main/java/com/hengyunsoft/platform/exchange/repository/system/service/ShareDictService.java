package com.hengyunsoft.platform.exchange.repository.system.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.system.domain.DictDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典service
 * @author wt
 * @createtime 2018-04-23
 */
public interface ShareDictService extends BaseAllService<Long,ShareDict,ShareDictExample> {

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
