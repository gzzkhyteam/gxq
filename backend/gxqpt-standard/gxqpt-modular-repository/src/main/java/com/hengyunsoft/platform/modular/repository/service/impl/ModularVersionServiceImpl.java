package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.domain.GetVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionPage;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularVersion;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularVersionMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularVersionExample;
import com.hengyunsoft.platform.modular.repository.service.ModularVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoukx
 * @createTime 2018-3-28
 */
@Service
public class ModularVersionServiceImpl extends BaseAllServiceImpl<Long, ModularVersion, ModularVersionExample> implements ModularVersionService {
    @Autowired
    private ModularVersionMapper modularVersionMapper;

    @Override
    protected BaseNormalDao<Long, ModularVersion, ModularVersionExample> getDao() {
        return modularVersionMapper;
    }

    /**
     * 根据id获得相应的版本信息
     *
     * @param id 版本id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public ModularVersionDO getModularVersionById(Long id) {
        return modularVersionMapper.getModularVersionById(id);
    }

    /**
     * 版本列表查询
     * 分页查询指定模块的jar包
     *
     * @param example
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularVersionDO> pageModularJar(ModularVersionExample example) {

        return modularVersionMapper.pageModularJar(example);
    }

    /**
     * 版本列表分页查询
     * 分页查询jar包
     *
     * @param modularVersionPage
     * @createTime 2018-4-16
     * @author zhoukx
     */
    @Override
    public List<ModularVersionDO> pageJar(ModularVersionPage modularVersionPage) {
        return modularVersionMapper.pageJar(modularVersionPage);
    }

    /**
     * 根据groupId artifactId 版本号 classifier(jar包类型)查询相应的版本信息
     *
     * @param mdv
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public ModularVersion getModVerByGidAndAidAndVerAndClas(ModularVersionDO mdv) {
        return modularVersionMapper.getModVerByGidAndAidAndVerAndClas(mdv);
    }

	@Override
	public String getVersion(GetVersionDO getVersionDO) {
		return modularVersionMapper.getVersion(getVersionDO);
	}

	@Override
	public List<ModularVersion> getVersionList(GetVersionDO getVersionDO) {
		return modularVersionMapper.getVersionList(getVersionDO);
	}
}
