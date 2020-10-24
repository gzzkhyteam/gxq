package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.Meet;
import com.hengyunsoft.platform.developer.repository.fast.meet.example.MeetExample;

import java.util.List;

/**
 * 描述:会议管理Service
 * @author chxy
 * @date 2018/5/8 14:41
 */
public interface MeetService extends BaseService<Long, Meet, MeetExample> {
    void saveMeetAndNotice(Meet entity, List<Long> joinerIds);
}
