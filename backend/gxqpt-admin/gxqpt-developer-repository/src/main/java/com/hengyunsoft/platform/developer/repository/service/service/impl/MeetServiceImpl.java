package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.developer.constant.MeetJoinStatus;
import com.hengyunsoft.platform.developer.constant.MeetStatus;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.Meet;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.MeetNotice;
import com.hengyunsoft.platform.developer.repository.fast.meet.dao.MeetMapper;
import com.hengyunsoft.platform.developer.repository.fast.meet.dao.MeetNoticeMapper;
import com.hengyunsoft.platform.developer.repository.fast.meet.example.MeetExample;
import com.hengyunsoft.platform.developer.repository.service.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author chxy
 * @create 2018-04-02 15:49
 * @desc 会议管理业务实现层
 **/
@Service
public class MeetServiceImpl extends BaseServiceImpl<Long, Meet, MeetExample> implements MeetService {

    @Autowired
    private MeetMapper meetMapper;

    @Autowired
    private MeetNoticeMapper meetNoticeMapper;


    @Override
    protected BaseNormalDao getDao() {
        return meetMapper;
    }

    @Override
    public void saveMeetAndNotice(Meet entity, List<Long> joinerIds) {
        //设置初始状态并保存会议
        Long userId = BaseContextHandler.getAdminId();
        Long meetId = genId();
        entity.setId(meetId);
        entity.setMeetStatus(MeetStatus.NOTICING.getMeetStatus());
        entity.setCreateUser(userId);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setUpdateUser(userId);
        entity.setCancel((short)2); //默认没有取消
        meetMapper.insertSelective(entity);

        //保存会议通知
        MeetNotice meetNotice = new MeetNotice();
        meetNotice.setId(genId());
        meetNotice.setNoticeTime(new Date());
        meetNotice.setAppId(entity.getAppId());
        meetNotice.setEmpId(userId);
        meetNotice.setEmpType((short)1);
        meetNotice.setJoinStatus(MeetJoinStatus.CREATOR.getJoinStatus());
        meetNotice.setMeetId(meetId);
        meetNotice.setCreateTime(new Date());
        meetNotice.setUpdateTime(new Date());
        meetNotice.setCreateUser(userId);
        meetNotice.setUpdateUser(userId);
        meetNoticeMapper.insertSelective(meetNotice);
        if (joinerIds != null && joinerIds.size() > 0){
            for (Long joinerId : joinerIds){
                meetNotice = new MeetNotice();
                meetNotice.setId(genId());
                meetNotice.setAppId(entity.getAppId());
                meetNotice.setEmpId(joinerId);
                meetNotice.setEmpType((short)2);
                meetNotice.setJoinStatus(MeetJoinStatus.NOTICING.getJoinStatus());  //默认设置为通知中
                meetNotice.setMeetId(meetId);
                meetNotice.setNoticeTime(new Date());
                meetNotice.setCreateTime(new Date());
                meetNotice.setUpdateTime(new Date());
                meetNotice.setCreateUser(userId);
                meetNotice.setUpdateUser(userId);
                meetNoticeMapper.insertSelective(meetNotice);
            }
        }

    }
}