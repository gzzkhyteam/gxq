package com.hengyunsoft.platform.developer.repository.fast.meet.dao;

import com.hengyunsoft.platform.developer.entity.fast.meet.domain.MeetNoticeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MeetNoticeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.developer.entity.fast.meet.po.MeetNotice, com.hengyunsoft.platform.developer.repository.fast.meet.example.MeetNoticeExample> {
    /**
     * 按照登陆用户ID查询所有会议
     * @param appId
     * @param userId
     * @param meetName 会议名称
     * @param joinStatus    参会状态
     * @return
     */
    List<MeetNoticeDO> findMeetList(@Param("appId") String appId,
                                    @Param("userId") Long userId,
                                    @Param("meetName") String meetName,
                                    @Param("meetStatus") Short meetStatus,
                                    @Param("joinStatus") Short joinStatus);

    /**
     * 按照会议ID查询会议
     *
     * @param id
     * @return
     */
    MeetNoticeDO findMeetById(@Param("id") Long id);
}