package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.domain.GetVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionPage;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularVersion;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularVersionExample;

import java.util.List;

/**
 * @author zhoukx
 * @createTime 2018-3-28
 */
public interface ModularVersionService extends BaseAllService<Long, ModularVersion, ModularVersionExample> {

    /**
     * 根据id获得相应的版本信息
     *
     * @param id 版本id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    ModularVersionDO getModularVersionById(Long id);

    /**
     * 版本列表查询
     * 分页查询指定模块的jar包
     *
     * @param example
     * @createTime 2018-4-5
     * @author zhoukx
     */
    List<ModularVersionDO> pageModularJar(ModularVersionExample example);

    /**
     * 版本列表分页查询
     * 分页查询jar包
     *
     * @param modularVersionPage
     * @createTime 2018-4-16
     * @author zhoukx
     */
    List<ModularVersionDO> pageJar(ModularVersionPage modularVersionPage);

    /**
     * 根据groupId artifactId 版本号 classifier(jar包类型)查询相应的版本信息
     *
     * @param mdv
     * @createTime 2018-4-5
     * @author zhoukx
     */
    ModularVersion getModVerByGidAndAidAndVerAndClas(ModularVersionDO mdv);
    
    /**
     * 获取版本号
     * @return
     */
    String getVersion(GetVersionDO getVersionDO);
    /**
     * 获取一个版本集合（用于查询上传的文件）
     * @return
     */
    List<ModularVersion> getVersionList(GetVersionDO getVersionDO);
}
