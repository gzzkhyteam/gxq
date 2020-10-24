package com.hengyunsoft.platform.search.repository.core.service;

import com.hengyunsoft.platform.search.entity.core.po.Collection;
import com.hengyunsoft.platform.search.entity.core.po.OptClollection;

import java.util.List;

public interface CollectionService {
    /***
     * 根据集合id查询
     * @param id
     * @return
     */
    Collection getById(long id);

    /***
     * 查询所有集合
     * @return
     */
    List<Collection> getAll();
    /***
     * 根据在solr里面的真实集合名称查询
     * @param code solr里面的真实集合名称查询
     * @return
     */
    List<Collection> getByCode(String code);

    /***
     * 查询该app能够或者写或者读写的所有集合
     * @param appId
     * @return
     */
    List<OptClollection> getAllOptByAppId(String appId);

    /***
     * 查询该app能够写操作的所有集合
     * @param appId
     * @return
     */
    List<OptClollection> getAllCanWrite(String appId);

    /***
     * 查询该app能够读操作的所有集合
     * @param appId
     * @return
     */
    List<OptClollection> getAllCanRead(String appId);

    /***
     * 保存集合
     * @param collection
     */
    Collection  saveCollection(Collection collection);
}
