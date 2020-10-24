package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.domain.DbSourceDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource;
import com.hengyunsoft.platform.exchange.entity.system.domain.DictDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDbSourceExample;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 数据源管理service
 * @author wt
 * @createtime 2018-04-23
 */
public interface ShareDbSourceService extends BaseAllService<Long,ShareDbSource,ShareDbSourceExample> {
    /**
     * 查询数据源列表
     * @param sourceName 数据源名称
     * @param dbName 数据连接名
     * @param dbType 数据类型
     * @param sysName 系统名称 模糊批撇
     * @param userId 创建人
     * @return
     */
    public List<DbSourceDO> queryDbSourceList(@Param("params") Map<Object,Object> params);

    /**
     * 根据数据源列表ID查询
     * @param id
     * @return
     */
    public DbSourceDO getDbSourceById(@Param("id") Long id);
}
