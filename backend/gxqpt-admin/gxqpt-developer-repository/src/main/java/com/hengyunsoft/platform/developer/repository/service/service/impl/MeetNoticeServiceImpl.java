package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.developer.constant.MeetJoinStatus;
import com.hengyunsoft.platform.developer.constant.MeetStatus;
import com.hengyunsoft.platform.developer.entity.fast.meet.domain.MeetNoticeDO;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.Meet;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.MeetNotice;
import com.hengyunsoft.platform.developer.repository.fast.meet.dao.MeetMapper;
import com.hengyunsoft.platform.developer.repository.fast.meet.dao.MeetNoticeMapper;
import com.hengyunsoft.platform.developer.repository.fast.meet.example.MeetNoticeExample;
import com.hengyunsoft.platform.developer.repository.service.service.MeetNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author chxy
 * @create 2018-04-02 15:49
 * @desc 会议通知业务实现层
 **/
@Service
public class MeetNoticeServiceImpl extends BaseServiceImpl<Long, MeetNotice, MeetNoticeExample> implements MeetNoticeService {

    @Autowired
    private MeetNoticeMapper meetNoticeMapper;

    @Autowired
    private MeetMapper meetMapper;


    @Override
    protected BaseNormalDao getDao() {
        return meetNoticeMapper;
    }

    /**
     * 按照登陆用户ID查询所有会议
     *
     * @param appId
     * @param userId
     * @param meetName   会议名称
     * @param meetStatus    参会状态
     * @return
     */
    @Override
    public List<MeetNoticeDO> findMeetList(String appId, Long userId, String meetName, Short meetStatus, Short joinStatus) {
        return meetNoticeMapper.findMeetList(appId, userId, meetName, meetStatus, joinStatus);
    }

    /**
     * 按照会议ID查询会议
     *
     * @param id
     * @return
     */
    @Override
    public MeetNoticeDO findMeetById(Long id) {
        return meetNoticeMapper.findMeetById(id);
    }

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
    @Override
    public void operateMeetById(Long id, int opType, String remark) {
        Long userId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        MeetNotice meetNotice = meetNoticeMapper.selectByPrimaryKey(id);
        Meet meet = meetMapper.selectByPrimaryKey(meetNotice.getMeetId());
        //如果会议已经取消的话 就不要操作了 前端也增加过滤
        if (meet.getMeetStatus() == MeetStatus.CANCELED.getMeetStatus()){
            return;
        }
        switch (opType){
            case 1:   //确认参加会议
                meetNotice.setJoinStatus(MeetJoinStatus.JOIN.getJoinStatus()); //设置参会状态为参加
                meetNoticeMapper.updateByPrimaryKeySelective(meetNotice);

                //此时检查会议是否有人已拒绝过，如没有，在全部已确认的情况下设置为已确认，否则部分确认
                MeetNoticeExample example = new MeetNoticeExample();
                example.createCriteria().andAppIdEqualTo(appId).andMeetIdEqualTo(meetNotice.getMeetId()).andJoinStatusEqualTo(MeetJoinStatus.NOT_JOIN.getJoinStatus());
                List<MeetNotice> refuseList = meetNoticeMapper.selectByExample(example);
                if (refuseList.isEmpty()){
                    //查看还有没有在通知中的
                    example = new MeetNoticeExample();
                    example.createCriteria().andAppIdEqualTo(appId).andMeetIdEqualTo(meetNotice.getMeetId()).andJoinStatusEqualTo(MeetJoinStatus.NOTICING.getJoinStatus());
                    List<MeetNotice> noticeList = meetNoticeMapper.selectByExample(example);
                    if (noticeList.isEmpty()){
                        meet.setMeetStatus(MeetStatus.WHOLE_CONFIRMED.getMeetStatus());   //全部确认
                    }else {
                        meet.setMeetStatus(MeetStatus.PART_CONFIRMED.getMeetStatus());   //部分确认
                    }

                    meetMapper.updateByPrimaryKeySelective(meet);
                }
                break;
            case 2: //拒绝参加会议
                meetNotice.setJoinStatus(MeetJoinStatus.NOT_JOIN.getJoinStatus()); //设置参会状态为不参加
                meetNotice.setRemark(remark);   //拒绝原因
                meetNoticeMapper.updateByPrimaryKeySelective(meetNotice);

                //既然已有人拒绝，直接设置会议状态为有人拒绝
                meet.setMeetStatus(MeetStatus.PART_REFUSED.getMeetStatus());
                meetMapper.updateByPrimaryKeySelective(meet);
                break;
            case 3: //取消会议
                meet.setCancel((short)1);
                meet.setMeetStatus(MeetStatus.CANCELED.getMeetStatus());
                meet.setCancelUser(userId);
                meet.setCancelReason(remark);
                meet.setCancelTime(new Date());
                meetMapper.updateByPrimaryKeySelective(meet);
                break;
        }
    }
}