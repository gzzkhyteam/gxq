package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.core.domain.ModuleUseRankDO;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseSumTotalNumDO;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseDayDataDO;
import com.hengyunsoft.platform.developer.repository.core.example.ModuleUseInfoExample;

import java.util.List;

/**
 * 描述:开发者调用日志Service
 * @author sunxiaoya
 * @date 2018/4/18
 */
public interface ModuleUseJnlService extends BaseService<Long, ModuleUseInfo, ModuleUseInfoExample> {

    /**
     * 描述：开发者调用日志记录Api
     * 参数：[ModuleUseInfo：开发者调用日志记录]
     * 返回值：void
     * 修改人：sunxiaoya
     * 修改时间：2018/4/17
     * 修改内容：
     */
    void saveLog(ModuleUseInfo moduleUseInfo);

    /**
     * 描述：查询开发者调用日志Api
     * 参数：[combineId：查询开发者调用日志]
     * 返回值：List<ModuleUseInfo>
     * 修改人：sunxiaoya
     * 修改时间：2018/4/19
     * 修改内容：
     */
    List<ModuleUseInfo> getJnl(String appId, String moduleId, String startTime, String endTime, String timeScale);

    /**
     * 获取模块调用总量
     * @return
     */
    ModuleUseSumTotalNumDO getSumTotalNum();

    /**
     * 获取全天模块调用总量
     * @return
     */
    List<ModuleUseDayDataDO> findDayData();

    /**
     * 大屏 查询当天模块使用次数
     * @param nDay
     * @param nextDay1
     * @return
     */
    int getDayUserModuleCount(String nDay, String nextDay1);

    /**
     * 获取接口调用排行榜
     * @return
     */
    List<ModuleUseRankDO> getModuleUseRank();
}
