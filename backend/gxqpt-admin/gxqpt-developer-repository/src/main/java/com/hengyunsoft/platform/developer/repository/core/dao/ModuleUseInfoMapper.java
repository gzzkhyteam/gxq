package com.hengyunsoft.platform.developer.repository.core.dao;

import com.hengyunsoft.platform.developer.entity.core.domain.ModuleUseRankDO;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseSumTotalNumDO;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseDayDataDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleUseInfoMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo, com.hengyunsoft.platform.developer.repository.core.example.ModuleUseInfoExample> {

    void saveLog(ModuleUseInfo moduleUseInfo);

    List<ModuleUseInfo> getJnlByYear(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                     @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<ModuleUseInfo> getJnlByMonth(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                      @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<ModuleUseInfo> getJnlByDay(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                    @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<ModuleUseInfo> getJnlByHour(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                     @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<ModuleUseInfo> getJnlByWeekEnd(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                        @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<ModuleUseInfo> getJnlByQuarter(@Param("appId")String appId, @Param("moduleId")String moduleId,
                                        @Param("startTime")String startTime, @Param("endTime")String endTime);

    /**
     * 获取模块调用总量
     * @return
     */
    ModuleUseSumTotalNumDO getSumTotalNum();

    /**
     * 获取全天模块统计调用总量
     * @return
     */
    List<ModuleUseDayDataDO> findDayData(@Param("pre") String pre, @Param("later")String later);

    /**
     * 大屏查询当天模块使用次数
     * @param nDay
     * @param nextDay1
     * @return
     */
    int getDayUserModuleCount(@Param("nowDay") String nowDay,@Param("nextDay") String nextDay);

    /**
     * 获取接口调用排行榜
     * @return
     */
    List<ModuleUseRankDO> getModuleUseRank();
}