package com.hengyunsoft.base.dao;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.db.example.BaseExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;

/**
 * 有app_id的表，继承这个dao
 *
 * @author tyh
 * @createTime 2017-12-08 17:37
 */
public interface BaseAllDao<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample> extends BaseNormalDao<I, T, TE> {

    /**
     * 根据appid + id 真删除记录
     * @param appId 应用id
     * @param id id
     */
    int deleteByAppIdAndId(@Param("appId") String appId, @Param("id") I id);


    /**
     * 根据appid + idList 真删除记录
     *
     * @param appId 应用id
     * @param list id集合
     * @return
     */
    int deleteByAppIdAndIds(@Param("appId") String appId, @Param("list") Collection<I> list);


    /**
     * 根据appid + idList 逻辑删除记录
     *
     * @param appId 应用id
     * @param list id 集合
     * @return
     */
    int removeByAppIdAndIds(@Param("appId") String appId, @Param("list") Collection<I> list);

    /**
     * 根据appid + id 逻辑删除记录
     *
     * @param appId appID
     *
     * @param id 主键
     * @return
     */
    int removeByAppIdAndId(@Param("appId") String appId, @Param("id") I id);


    /**
     * 根据appId+id查询实体
     *
     * @param appId appId
     * @param id 主键
     * @return
     */
    T selectByAppIdAndId(@Param("appId") String appId, @Param("id") I id);

    /**
     * 根据appId+id，修改不为null的字段
     * @param record 实体
     */
    int updateByAppIdAndIdSelective(T record);

    /**
     * 根据appId+id，覆盖修改所有的字段
     * @param record 实体
     */
    int updateByAppIdAndId(T record);

    /**
     * 查询 appId
     *
     * @param id 主键
     * @return
     */
    String selectAppIdById(I id);
}
