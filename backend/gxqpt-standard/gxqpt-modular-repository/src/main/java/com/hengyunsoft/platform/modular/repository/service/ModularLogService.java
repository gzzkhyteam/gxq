package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularAnalysisCategoryTopDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDownloadNumDO;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularLog;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularLogExample;

import java.util.Date;
import java.util.List;

/**
 * @author wangs
 * @createTime 2018-4-03
 */
public interface ModularLogService extends BaseAllService<Long, ModularLog, ModularLogExample> {
    /**
     * 解析日志文件并入库
     *
     * @param fileName：文件路径
     * @author zx
     */
    public void parseLogFile(String fileName);

    /**
     * 下载量最多的CategoryTop10
     */
    List<ModularAnalysisCategoryTopDO> findCategoryDownTop10();

    /**
     * 使用量最多的模块Top10
     */
    List<ModularDO> findModularDownTop10();
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
    Integer getMonthModularUsedNum(Date date);
    /**
     * 模块使用率
     * @return
     */
    Integer getModularUsedRate();
    /**
     * 本月模块使用率
     * @return
     */
    Integer getMonthModularUsedRate(Date date);

    /**
     * 获取应用占比数
     * @return
     */
    public Integer getModularRatioSum(List<Long> idList,Date startDate,Date endDate);
}
