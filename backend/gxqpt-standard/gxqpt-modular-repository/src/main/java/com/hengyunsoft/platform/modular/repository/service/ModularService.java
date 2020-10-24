package com.hengyunsoft.platform.modular.repository.service;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularCategoryAndTagDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularHotDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.HotSupportListDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDiscardedNumDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNewestDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNumDO;
import com.hengyunsoft.platform.modular.entity.modular.po.Modular;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularExample;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularQueryEntity;

/**
 * @author zhoukx
 * @createTime 2018-4-05
 */
public interface ModularService extends BaseAllService<Long, Modular, ModularExample> {
    /**
     * 根据id 查看模块详情
     *
     * @param id 模块id
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    ModularDO getModularById(Long id);

    /**
     * 分页查询模块列表
     *
     * @param entity 分页信息
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    List<ModularDO> page(ModularQueryEntity entity);

    /**
     * 根据仓库名称和groupId和artifactId查询模块对象
     *
     * @param modular 模块对象
     * @return ModularDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    ModularDO getModularByRepNameAndGidAndAid(Modular modular);

    /**
     * 根据模块id获取模块的分类列表
     *
     * @param id 模块id
     * @return ModularCategoryAndTagDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    List<ModularCategoryAndTagDO> findCatagoryListByModularId(Long id);

    /**
     * 根据模块id获取模块的标签列表
     *
     * @param id 模块id
     * @return ModularCategoryAndTagDO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    List<ModularCategoryAndTagDO> findTagListByModularId(Long id);

    /**
     * 模块数量最多的库排行
     *
     */
    List<Modular> findRepositoryTop10();

    /**
     * 活跃提供商榜
     */
    List<ModularHotDO> findSupplierTop10();

    /**
     * 模块活跃度榜
     */
    List<ModularHotDO> findModularUpdateFrequencyTop10();

    /**
     * 新模块榜
     */
    List<ModularHotDO> findModularLastUploadTop10();
    /**
     * 新模块榜(最近半年)
     */
    List<ModularNewestDO> getModularNewestRanking();
    /**
     * 模块总数
     * @return
     */
    Integer getModularNum();
    /**
     * 本月新增模块数
     * @return
     */
    Integer getMonthModularNum(Date date);
    /**
     * 废弃模块总数
     * @return
     */
    Integer getModularDiscardedNum();
    /**
     * 本月废弃模块数
     * @return
     */
    Integer getMonthModularDiscardedNum(Date date);
    /**
     * 废弃模块数
     * @return
     */
    List<ModularDiscardedNumDO> getModularDiscardedAnalysis();
    /**
     * 模块数量分析
     * @return
     */
    List<ModularNumDO> getModularNumAnalysis(Date date);
    /**
     * 分页废弃模块列表
     *
     * @param entity 分页信息
     * @return ModularDO
     */
    List<ModularDO> pageDiscarded(String param);
    /**
     * 活跃提供商列表
     */
    List<HotSupportListDO> getSupplierListTop10();
}
