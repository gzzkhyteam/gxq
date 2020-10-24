package com.hengyunsoft.platform.warn.repository.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.warn.entity.domain.ConfirmTimeDO;
import com.hengyunsoft.platform.warn.entity.domain.DutyerMessageDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnResultPagingDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnMixStatusNumDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendeeMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptSendeeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GxqptSendeeServiceImpl extends BaseAllServiceImpl<Long, GxqptSendee, GxqptSendeeExample> implements GxqptSendeeService {

    @Autowired
    private GxqptSendeeMapper gxqptSendeeMapper;

    /**
     * 根据预警id，接收人类型查询确认处理时长
     * @param warnId
     * @param recType
     * @return
     */
    public ConfirmTimeDO getConfirmti( Long warnId, String recType){return gxqptSendeeMapper.getConfirmti(warnId,recType);}
    /**
     * 根据预警id，接收人类型查询最该级别接确认时间
     * @param warnId
     * @param recType
     * @param handlerLeve
     * @return
     */
    public ConfirmTimeDO getConfirmt(Long warnId, String recType, Integer handlerLeve){return gxqptSendeeMapper.getConfirmt(warnId,recType,handlerLeve);}

    /**
     * 根据预警id，接收人类型查询最该级别接收人信息查询处理结果不属实的确认时间
     * @param warnId
     * @param recType
     * @return
     */
    public ConfirmTimeDO getConfirmtNo( Long warnId, String recType){return gxqptSendeeMapper.getConfirmtNo(warnId,recType);}
    /**
     * 根据预警id，接收人类型，处理结果查询接收人信息
     * @param warnId
     * @param recType
     * @param result
     * @return
     */
    public Integer getNotResult(Long warnId,String recType,Boolean result){return gxqptSendeeMapper.getNotResult(warnId,recType,result);}
    /**
     * 根据预警id和接收人类型查询责任人姓名
     * @param warnId
     * @param recType
     * @return
     */
    @Override
    public List<GxqptWarnResultPagingDO> getDNameByWarnId(Set<Long> warnId, String recType){return gxqptSendeeMapper.getDNameByWarnId(warnId,recType);}
    /**
     * 根据预警id和接收人类型查询责任人信息
     * @param warnId
     * @param recType
     * @return
     */
    @Override
    public DutyerMessageDO getDListByWarnId(Long warnId, String recType){return gxqptSendeeMapper.getDListByWarnId(warnId,recType);}
    /**
     * 根据用户id查询预警id
     * @param userId
     * @return
     */
    @Override
    public List<Long> getWarnId(Long userId){
        return gxqptSendeeMapper.getWarnId(userId);
    }
    /**
     * 更新预警接收人处理标识1
     * @param warnId
     * @param handlerLeve
     * @param whoHandle
     * @return
     */
    @Override
    public Boolean updateByWarnIdAndLeve(Long warnId,Integer handlerLeve) {
        return gxqptSendeeMapper.updateByWarnIdAndLeve(warnId,handlerLeve);
    }

    /**
     * 更新预警接收人处理标识2
     * @param warnId
     * @param handlerLeve
     * @return
     */
    @Override
    public Boolean updateByWarnId(Long warnId,Integer handlerLeve) {
        return gxqptSendeeMapper.updateByWarnId(warnId,handlerLeve);
    }

    public List<GxqptSendee> getCsr(Long warnId,String recType){
        return gxqptSendeeMapper.getCsr(warnId,recType);
    }

    @Override
    public WarnMixStatusNumDO getWarnMixStatusNum(Long userId) {
        return gxqptSendeeMapper.getWarnMixStatusNum(userId);
    }

    @Override
    protected BaseNormalDao<Long, GxqptSendee, GxqptSendeeExample> getDao() {
        return gxqptSendeeMapper;
    }
}
