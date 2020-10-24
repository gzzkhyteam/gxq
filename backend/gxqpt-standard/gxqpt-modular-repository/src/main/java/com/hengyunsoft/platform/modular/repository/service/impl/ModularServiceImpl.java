package com.hengyunsoft.platform.modular.repository.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularCategoryAndTagDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularHotDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.HotSupportListDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDiscardedNumDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNewestDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNumDO;
import com.hengyunsoft.platform.modular.entity.modular.po.Modular;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularExample;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularQueryEntity;
import com.hengyunsoft.platform.modular.repository.service.ModularService;


/**
 * @author zhoukx
 * @createTime 2018-4-05
 */
@Service
public class ModularServiceImpl extends BaseAllServiceImpl<Long, Modular, ModularExample>
        implements ModularService {
    @Autowired
    private ModularMapper modularMapper;

    @Override
    protected BaseNormalDao<Long, Modular, ModularExample> getDao() {

        return modularMapper;
    }

    /**
     * 通过id查询模块对象信息
     *
     * @param id 模块id
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public ModularDO getModularById(Long id) {

        return modularMapper.getModularById(id);
    }

    /**
     * 分页查询模块列表
     *
     * @param entity 分页信息
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularDO> page(ModularQueryEntity entity) {

        return modularMapper.pageModularQuery(entity);
    }

    /**
     * 根据仓库名称和groupId和artifactId查询模块对象
     *
     * @param modular 模块对象
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public ModularDO getModularByRepNameAndGidAndAid(Modular modular) {


        return modularMapper.getModularByRepNameAndGidAndAid(modular);
    }

    /**
     * 根据模块id获取模块的分类列表
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularCategoryAndTagDO> findCatagoryListByModularId(Long id) {
        return modularMapper.findCatagoryListByModularId(id);
    }

    /**
     * 根据模块id获取模块的标签列表
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularCategoryAndTagDO> findTagListByModularId(Long id) {
        return modularMapper.findTagListByModularId(id);
    }

    /**
     * 模块数量最多的库排行
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<Modular> findRepositoryTop10() {
        return modularMapper.findRepositoryTop10();
    }

    /**
     * 活跃提供商榜
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularHotDO> findSupplierTop10() {
        return modularMapper.findSupplierTop10();
    }

    /**
     * 模块活跃度榜
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularHotDO> findModularUpdateFrequencyTop10() {
        return modularMapper.findModularUpdateFrequencyTop10();
    }

    /**
     * 新模块榜
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @Override
    public List<ModularHotDO> findModularLastUploadTop10() {
        return modularMapper.findModularLastUploadTop10();
    }

	@Override
	public List<ModularNewestDO> getModularNewestRanking() {
		return modularMapper.getModularNewestRanking();
	}
    /**
     * 模块总数
     * @return
     */
	@Override
	public Integer getModularNum() {
		return modularMapper.modularNum();
	}
    /**
     * 本月新增模块数
     * @return
     */
	@Override
	public Integer getMonthModularNum(Date date) {
		return modularMapper.monthModularNum(date);
	}
    /**
     * 废弃模块总数
     * @return
     */
	@Override
	public Integer getModularDiscardedNum() {
		return modularMapper.getModularDiscardedNum();
	}
    /**
     * 本月废弃模块数
     * @return
     */
	@Override
	public Integer getMonthModularDiscardedNum(Date date) {
		return modularMapper.getMonthModularDiscardedNum(date);
	}
    /**
     * 废弃模块数
     * @return
     */
	@Override
	public List<ModularDiscardedNumDO> getModularDiscardedAnalysis() {
		return modularMapper.getModularDiscardedAnalysis();
	}
    /**
     * 模块数量分析
     * @return
     */
	@Override
	public List<ModularNumDO> getModularNumAnalysis(Date date) {
		return modularMapper.getModularNumAnalysis(date);
	}
    /**
     * 分页废弃模块列表
     */
	@Override
	public List<ModularDO> pageDiscarded(String param) {
		return modularMapper.pageDiscarded(param);
	}
    /**
     * 活跃提供商列表
     */
	@Override
	public List<HotSupportListDO> getSupplierListTop10() {
		return modularMapper.getSupplierListTop10();
	}

}
