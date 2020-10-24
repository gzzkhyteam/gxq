package com.hengyunsoft.platform.warn.repository.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.warn.entity.domain.ConfirmTimeDO;
import com.hengyunsoft.platform.warn.entity.domain.DutyerDO;
import com.hengyunsoft.platform.warn.entity.domain.DutyerMessageDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptSendeeDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnPagingDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnResultPagingDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnMixStatusNumDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;

@Repository
public interface GxqptSendeeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.warn.entity.po.GxqptSendee, com.hengyunsoft.platform.warn.repository.example.GxqptSendeeExample> {
    /**
     * 根据预警id，接收人类型查询确认处理时长
     * @param warnId
     * @param recType
     * @return
     */
    ConfirmTimeDO getConfirmti(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType);
    /**
     * 根据预警id，接收人类型查询处理结果属实或者不属实的接收人信息
     * @param warnId
     * @param recType
     * @param handlerLeve
     * @return
     */
    ConfirmTimeDO getConfirmt(@Param(value = "warnId") Long warnId, @Param(value = "recType") String recType, @Param(value = "handlerLeve") Integer handlerLeve);

    /**
     * 预警id，接收人类型查询最该级别接收人信息查询处理结果不属实的确认时间
     * @param warnId
     * @param recType
     * @return
     */
    ConfirmTimeDO getConfirmtNo(@Param(value = "warnId") Long warnId,@Param(value = "recType") String recType);
    /**
     * 根据预警id，接收人类型，处理结果查询接收人信息
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
    DutyerMessageDO getDListByWarnId(@Param(value = "warnId") Long warnId, @Param(value = "recType") String recType);
    /**
     * 根据用户id查询预警id
     * @param userId
     * @return
     */
    List<Long> getWarnId(@Param("userId") Long userId);
    /**
     * 根据预警id查询接收人信息表
     * @param warnId
     * @return
     */
    List<Map<String,Object>> getSenList(@Param("warnId") Long warnId);

    /**
     * 根据预警id和接收人类型查询接收人信息
     * @param warnId
     * @param recType
     * @return
     */
    List<GxqptSendeeDO> getConList(@Param("warnId") Long warnId, @Param("recType") String recType);
    /**
     * 根据预警id和接收人类型查询责任人信息
     * @param warnId
     * @param recType
     * @return
     */
    GxqptSendee getDuList(@Param("warnId") Long warnId, @Param("recType") String recType);

    /**
     * 根据预警id和接收人类型查询接收人姓名
     * @param warnId
     * @return
     */
    List<GxqptWarnPagingDO> getDName(@Param("warnId") Set<Long> warnId, @Param("recType") String recType);
    /**
     * 根据预警id查询预警接收人级别列表
     * @param warnId
     * @return
     */
    Integer getLeveList(@Param("warnId") Long warnId,@Param("recType") String recType);

    /**
     * 更新预警接收人处理标识1
     * @param warnId
     * @param handlerLeve
     * @param whoHandle
     * @return
     */
    Boolean updateByWarnIdAndLeve(@Param("warnId") Long warnId,@Param("handlerLeve") Integer handlerLeve);

    /**
     * 更新预警接收人处理标识2
     * @param warnId
     * @param handlerLeve
     * @return
     */
    Boolean updateByWarnId(@Param("warnId") Long warnId,@Param("handlerLeve") Integer handlerLeve);

    /**
     * 根据预警id查询预警责任人
     * @return
     */
    DutyerDO getDutyer(@Param("warnId") Long warnId, @Param("recType") String recType);

    /**
     * 根据用户id和预警id查询预警接收人信息
     * @param userId
     * @param warnId
     * @return
     */
    GxqptSendee getByUserId(@Param(value = "userId")Long userId, @Param(value = "warnId")Long warnId,@Param("recType") String recType);

    /**
     * 查询预警接收信息
     * @param warnId
     * @return
     */
    List<GxqptSendee> getSendeeList(Long warnId);

    /**
     * 根据预警id查询抄送人
     * @param warnId
     * @return
     */
    List<GxqptSendee> getCsr(@Param(value = "warnId") Long warnId,@Param("recType") String recType);

    /**
     * 根据预警id和接收人类型更新预警状态
     * @param warnId
     * @param recType
     * @return
     */
    int updateStatus(@Param(value = "warnId") Long warnId,@Param("recType") String recType);

    /**
     * 根据预警id更新预警状态
     * @param warnId
     * @return
     */
    int updateStatusByWarnId(@Param(value = "warnId") Long warnId,@Param("recType") String recType);

    WarnMixStatusNumDO getWarnMixStatusNum(Long userId);
}