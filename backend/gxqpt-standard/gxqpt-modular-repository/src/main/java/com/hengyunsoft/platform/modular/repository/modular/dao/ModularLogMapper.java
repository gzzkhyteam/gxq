package com.hengyunsoft.platform.modular.repository.modular.dao;

import com.hengyunsoft.platform.modular.entity.modular.domain.ModularAnalysisCategoryTopDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDownloadNumDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangs
 * @createTime 2018-4-03
 */
@Repository
public interface ModularLogMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.modular.entity.modular.po.ModularLog, com.hengyunsoft.platform.modular.repository.modular.example.ModularLogExample> {
    /**
     * 下载量最多的CategoryTop10
     */
    List<ModularAnalysisCategoryTopDO> findCategoryDownTop10();

    /**
     * 使用量最多的模块Top10
     */
    List<ModularDO> findModularDownTop10();

    /**
     * 更新日志表modularId字段
     *
     * @author zx
     */
    int updateModularId();
    /**
     * 模块下载top20
     */
    List<ModularDownloadNumDO> getModularDownloadTop20();
    /**
     * 模块使用量
     * @return
     */
    Integer getModularUsedNum();
    /**
     * 本月模块使用量
     * @return
     */
    Integer getMonthModularUsedNum(@Param(value="date")Date date);
    /**
     * 模块使用率
     * @return
     */
    Integer getModularUsedRate();
    /**
     * 本月模块使用率
     * @return
     */
    Integer getMonthModularUsedRate(@Param(value="date")Date date);

    /**
     * 获取应用占比数
     * @return
     */
    public Integer getModularRatioSum(Map<String,Object> param);
}