package com.hengyunsoft.platform.mt.repository.version.dao;

import com.hengyunsoft.platform.mt.entity.version.po.ClientVersion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClientVersionMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.mt.entity.version.po.ClientVersion, com.hengyunsoft.platform.mt.repository.version.example.ClientVersionExample> {
    /***
     * 查询客户端版本
     * @param param
     * @return
     */
    List<ClientVersion> findClientVersion(Map<String, Object> param);

    /***
     * 增加更新一个更新数量
     * @param id
     */
    void addUpdateNum(Long id);

    /***
     * 找到一家发布的版本
     * @return
     */
    List<ClientVersion> findPubishVersion();

    /***
     * 获取最新版本
     * @return
     */
    ClientVersion getLastVersionInfo();
}