package com.hengyunsoft.platform.search.repository.core.service;

import com.hengyunsoft.platform.search.entity.core.po.AppOptCollection;

import java.util.List;

public interface AppOptcollectionService {
    /***
     * 插入或者更新
     * @param appOptCollection
     */
    void saveOrUpdate(AppOptCollection appOptCollection);

    /***
     * 得到集合指定app的权限
     * @param collectionId
     * @param appId
     * @return
     */
    List<AppOptCollection> getByAppIdAndCollectionid(Long collectionId, String appId);

    /***
     *  得到指定集合的权限
     * @param collectionId
     * @return
     */
    List<AppOptCollection> getByCollectionid(Long collectionId);
}
