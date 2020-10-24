package com.hengyunsoft.platform.mt.repository.version.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.version.po.ClientVersion;
import com.hengyunsoft.platform.mt.repository.version.example.ClientVersionExample;

import java.util.List;
import java.util.Map;

public interface ClientVersionService extends BaseService<Long, ClientVersion, ClientVersionExample> {
    /***
     * 查询版本列表
     * @param param
     * @return
     */
    List<ClientVersion> findClientVersion(Map<String, Object> param);

    /***
     * 增加版本更新数量1
     * @param id
     */
    void addUpdateNum(Long id);

    /***
     * 查询所有已经发布的版本
     * @return
     */
    List<ClientVersion> findPubishVersion();

    /***
     * 查询最新的版本
     * @return
     */
    ClientVersion getLastVersionInfo();
}
