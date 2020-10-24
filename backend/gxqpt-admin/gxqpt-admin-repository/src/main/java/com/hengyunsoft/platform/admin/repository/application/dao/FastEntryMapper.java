package com.hengyunsoft.platform.admin.repository.application.dao;

import com.hengyunsoft.platform.admin.entity.application.po.FastEntry;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.FastEntryRankDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FastEntryMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.admin.entity.application.po.FastEntry, com.hengyunsoft.platform.admin.repository.application.example.FastEntryExample> {
    /**
     * 描述：根据用户Id查找所有
     * 参数：userId 用户Id
     * 返回值：List<FastEntry> 应用list
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    List<FastEntry> selectAppByUserId(@Param("userId") Long userId);

    /**
     * 描述：根据Id更新快捷入口
     * 参数：Id
     * 返回值：void
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    void update(FastEntry fastEntry);

    /**
     * 获取快捷入口排行榜
     * @param resultNum
     * @return
     */
    List<FastEntryRankDO> getFastEntryRank(Long resultNum);
}