package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessageQueryDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.ChannelByAnalysis;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessageAnalysis;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessageMerge;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageQueryParam;

@Repository
public interface MsgsMessageMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage, com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageExample> {

    public List<MsgsMessageMerge> queryMessageMergeChannelByPage(MsgsMessageQueryParam msgsMessageQueryParam);
    //非空字段 更改
    public int updateMessageById(MsgsMessage msgsMessage);
    //渠道平台消息量分析
    public List<ChannelByAnalysis> queryChannelByAnalysis(MsgsMessageQueryParam msgsMessageQueryParam);

    public List<MsgsMessageAnalysis> queryTypeByAnalysis(MsgsMessageQueryParam msgsMessageQueryParam);
    
    void updateStatusById(@Param(value = "id") Long id);
    /**
     * 获取信息列表
     * @param msgsMessageQueryDTO
     * @return
     */
    List<MsgsListDO> getMsgsList(@Param(value="msgsMessageQueryDTO")MsgsMessageQueryDO msgsMessageQueryDTO);
}