package com.hengyunsoft.platform.admin.repository.base.dao;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.platform.admin.entity.base.domain.DictionaryMaintainDO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMapper extends BaseAllDao<Long, Dictionary, DictionaryExample> {
    /**
     * 删除数据字典信息
     *
     * @param appId 应用id,  typeId 字典类型id
     */
    int deleteByAppIdAndTypeId(@Param("appId") String appId, @Param("typeId") Long typeId);

    /**
     * 根据功能名查询
     *
     * @modify:madb
     * @TIME:2018/4/10
     */
    Dictionary findByName(String name);

    /**
     * 根据更新功能数据字典
     * @modify:madb
     * @TIME:2018/4/10
     * */
    //int updateByPrimaryKey(Dictionary dictionary);

    /**
     * 根据id删除功能信息（物理删除）
     *
     * @modify:madb
     * @TIME:2018/4/10
     */
    int delById(Dictionary dictionary);

    /**
     * 应用类型维护 修改
     *
     * @param dictionary
     */
    int updateDictionaryById(Dictionary dictionary);

    /**
     * 查询单位的所有字典
     *
     * @return
     */
    List findOrgDictionary();

    /**
     * 应用类型维护查询
     *
     * @return
     */
    List<DictionaryMaintainDO> findAppMaintainPage(@Param("typeCode") String typeCode, @Param("appId") String appId);

    /**
     * 功能类型维护查询
     *
     * @param typeCode
     * @param
     * @return
     */
    List<DictionaryMaintainDO> findModMaintainPage(@Param("typeCode") String typeCode,
                                                   @Param("appId") String appId);
}