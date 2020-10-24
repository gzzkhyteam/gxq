package com.hengyunsoft.platform.warn.repository.service;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.warn.entity.domain.ConfirmTimeDO;
import com.hengyunsoft.platform.warn.entity.domain.DutyerMessageDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnResultPagingDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnMixStatusNumDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.repository.example.GxqptSendeeExample;

public interface GxqptSendeeService extends BaseService<Long, GxqptSendee, GxqptSendeeExample> {
    /**
     * 根据预警id，接收人类型查询确认处理时长
     * @param warnId
     * @param recType
     * @return
     */
    ConfirmTimeDO getConfirmti(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType);
    /**
     * 根据预警id，接收人类型查询最该级别接确认时间
     * @param warnId
     * @param recType
     * @param handlerLeve
     * @return
     */
    ConfirmTimeDO getConfirmt(@Param(value = "warnId") Long warnId, @Param(value = "recType") String recType, @Param(value = "handlerLeve") Integer handlerLeve);

    /**
     * 根据预警id，接收人类型查询最该级别接收人信息查询处理结果不属实的确认时间
     * @param warnId
     * @param recType
     * @return
     */
    ConfirmTimeDO getConfirmtNo(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType);
    /**
     * 根据预警id，接收人类型，处理结果查询处理结果为不属实的信息数量
     * @param warnId
     * @param recType
     * @param result
     * @return
     */
    Integer getNotResult(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType,@Param(value = "result") Boolean result);
    /**
     * 根据预警id和接收人类型查询责任人姓名
     * @param warnId
     * @param recType
     * @return
     */
    List<GxqptWarnResultPagingDO> getDNameByWarnId(@Param(value = "warnId") Set<Long> warnId, @Param(value = "recType") String recType);
    /**
     * 根据预警id和接收人类型查询责任人信息
     * @param warnId
     * @param recType
     * @return
     */
    DutyerMessageDO getDListByWarnId(@Param(value = "warnId")Long warnId, @Param(value = "recType") String recType);
    /**
     * 根据用户id查询预警id
     * @param userId
     * @return
     */
    List<Long> getWarnId(Long userId);
    /**
     * 更新预警接收人处理标识1
     * @param warnId
     * @param handlerLeve
     * @param whoHandle
     * @return
     */
    Boolean updateByWarnIdAndLeve(@Param(value = "warnId") Long warnId,@Param(value = "handlerLeve") Integer handlerLeve);

    /**
     * 更新预警接收人处理标识2
     * @param warnId
     * @param handlerLeve
     * @return
     */
    Boolean updateByWarnId(@Param(value = "warnId") Long warnId,@Param(value = "handlerLeve") Integer handlerLeve);

    /**
     * 根据预警id和接收人类型查询抄送人信息
     * @param warnId
     * @param handlerLeve
     * @return
     */
    List<GxqptSendee> getCsr(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType);

    /**
     * 获取个人预警混合状态数量,确认,处理
     * @param userId
     * @return
     */
    WarnMixStatusNumDO getWarnMixStatusNum(Long userId);
}
