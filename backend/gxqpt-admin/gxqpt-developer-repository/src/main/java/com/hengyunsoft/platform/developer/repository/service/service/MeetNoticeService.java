package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.fast.meet.domain.MeetNoticeDO;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.MeetNotice;
import com.hengyunsoft.platform.developer.repository.fast.meet.example.MeetNoticeExample;

import java.util.List;

/**
 * 描述:会议管理Service
 * @author chxy
 * @date 2018/5/8 14:41
 */
public interface MeetNoticeService extends BaseService<Long, MeetNotice, MeetNoticeExample> {
    /**
     * 按照登陆用户ID查询所有会议
     *
     * @param appId
     * @param userId
     * @param meetName   会议名称
     * @param meetStatus    参会状态
     * @return
     */
    List<MeetNoticeDO> findMeetList(String appId, Long userId, String meetName, Short meetStatus, Short joinStatus);

    /**
     * 按照会议ID查询会议
     *
     * @param id
     * @return
     */
    MeetNoticeDO findMeetById(Long id);

    /**
     * 描述：根据id操作会议
     * @param id 数据ID
     * @param opType 操作类型 1：确认参加会议，2：拒绝参加会议，3：取消会议
     * @param remark 操作描述
     * 返回值：Boolean
     * 修改人：chxy
     * 修改时间：2018/5/3
     * 修改内容：
     */
    void operateMeetById(Long id, int opType, String remark);
}
