package com.hengyunsoft.platform.msgs.manager;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.MsgExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.msgs.dto.bbs.*;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.UpdateBacklogDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllMainMsg;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllReceiveMsg;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementMainMsg;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementReceiveMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllMainMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllReceiveMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementReceiveMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllMainMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllReceiveMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementMainMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementReceiveMsgService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 站内消息相关公共业务处理类
 * @author sxy
 * @date 20180814
 */
@Component
@Slf4j
public class BbsBizCommon {

    @Autowired
    BbsAllMainMsgService bbsAllMainMsgService;

    @Autowired
    BbsAllReceiveMsgService bbsAllReceiveMsgService;

    @Autowired
    BbsIncrementReceiveMsgService bbsIncrementReceiveMsgService;

    @Autowired
    BbsIncrementMainMsgService bbsIncrementMainMsgService;

    @Autowired
    RoleApi roleApi;

    @Autowired
    DozerUtils dozerUtils;

    /**
     * 更新站内消息公共方法处理
     * @param
     * @return
     */
    public Result<Boolean> updateBacklogCommon(UpdateBacklogReqDTO dto) {

        log.info("更新站内消息,dto[{}] ", JSONUtils.toJsonString(dto));
        BbsAllMainMsgExample example = new BbsAllMainMsgExample();
        example.createCriteria()
                .andAppIdEqualTo(dto.getAppId())
                .andBizIdEqualTo(dto.getBizId())
                .andBizTypeEqualTo(dto.getBizType());
        //3.查询
        List<BbsAllMainMsg> list = bbsAllMainMsgService.find(example);
        if(list == null){
            log.info("根据条件查询消息失败,暂无消息存在!!");
            return Result.success(false);
        }
        Long msgId = null;
        if(list.size()>0){
            msgId = list.get(0).getId();
        }
        if(msgId == null){
            log.info("根据条件查询消息失败!!");
            return Result.success(false);
        }
        UpdateBacklogDTO updateBacklogDTO = new UpdateBacklogDTO();
        updateBacklogDTO.setMsgId(msgId);

        //更新单个接收人的消息状态
        if(dto.getReceiveId()!=null){
            updateBacklogDTO.setReceiveId(dto.getReceiveId());
            log.info("根据消息ID[{}],接收人ID[{}],更新消息内容。",msgId, dto.getReceiveId());
            //未读直接处理情况需要更新已读状态；
            updateStatusReadedCommon(msgId ,dto.getReceiveId());
            bbsAllReceiveMsgService.updateBacklog(dozerUtils.map(updateBacklogDTO, UpdateBacklogDO.class));
        }else{
            BbsAllReceiveMsgExample ex = new BbsAllReceiveMsgExample();
            ex.createCriteria().andMsgIdEqualTo(msgId);
            List<BbsAllReceiveMsg> exList = bbsAllReceiveMsgService.find(ex);
            if(exList!=null&&exList.size()>0){
                for(BbsAllReceiveMsg li:exList){
                    UpdateBacklogDTO updateDto = new UpdateBacklogDTO();
                    updateDto.setReceiveId(li.getReceiveId());
                    updateDto.setMsgId(li.getMsgId());
                    log.info("根据消息ID[{}],接收人ID[{}],更新消息内容。",li.getMsgId(), li.getReceiveId());
                    //未读直接处理情况需要更新已读状态；
                    updateStatusReadedCommon(li.getMsgId() ,li.getReceiveId());
                    //更新各个接收人的状态
                    bbsAllReceiveMsgService.updateBacklog(dozerUtils.map(updateDto, UpdateBacklogDO.class));
                }
            }
            return Result.success(true);
        }
        return Result.success(false);
    }

    /**
     * 更新状态已读公共处理方法
     * @param msgId
     * @param recId
     */
    public void updateStatusReadedCommon(Long msgId ,Long recId){
        BbsIncrementReceiveMsgExample example = new BbsIncrementReceiveMsgExample();
        example.createCriteria().andMsgIdEqualTo(msgId)
                .andReceiveIdEqualTo(recId);
        List<BbsIncrementReceiveMsg> list = bbsIncrementReceiveMsgService.find(example);
        if(list!=null&&list.size()>0){
            log.info("根据消息ID[{}],接收人ID[{}]查询结果list.size=[{}]更新已读",msgId,recId,list.size());
            for(BbsIncrementReceiveMsg li:list){
                Long[] id =  {li.getId()};
                updateMsgsReadedCommon(id);
            }
        }
    }

    /**
     * 更新消息已读公共处理方法
     * @param ids
     * @return
     */
    public Result<Boolean> updateMsgsReadedCommon(Long[] ids) {

        //校验
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_IDS_EMPTY, ids);

        try {
            for(Long id:ids){
                log.info("根据id[{}]删除消息,",id);
                //处理正式库
                BbsIncrementReceiveMsg  birm = null;
                birm = bbsIncrementReceiveMsgService.getById(id);
                if(birm != null){
                    Long msgId = birm.getMsgId();

                    //已读即可删除
                    bbsIncrementReceiveMsgService.deleteById(id);
                    BbsIncrementReceiveMsgExample example = new BbsIncrementReceiveMsgExample();
                    BbsIncrementReceiveMsgExample.Criteria criteria = example.createCriteria();
                    criteria.andMsgIdEqualTo(msgId);
                    criteria.andReadIsEqualTo(false);

                    List<BbsIncrementReceiveMsg> list = bbsIncrementReceiveMsgService.find(example);
                    if(list!=null&&list.size()==0){//最后一条消息已读，删除主表消息
                        bbsIncrementMainMsgService.deleteById(msgId);
                    }

                    BbsAllReceiveMsg barm = new BbsAllReceiveMsg();
                    barm.setId(id);
                    barm.setReadIs(true);
                    barm.setUpdateTime(new Date());
                    //更新历史库
                    bbsAllReceiveMsgService.updateByIdSelective(barm);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(true);
    }

    /**
     * 保存消息已读公共处理方法
     * @param bammDTO
     * @return
     */
    public Result<BbsAllMainMsgSaveResDTO> saveMsgCommon(BbsAllMainMsgSaveReqDTO bammDTO) {
        //1.校验
        if(bammDTO==null||bammDTO.getBbsAllMainMsgDTO()==null){
            return Result.fail("入参实体DTO不为空！！");
        }
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_USER_TYPE_EMPTY, bammDTO.getRecvType());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_BIZ_ID_EMPTY, bammDTO.getBbsAllMainMsgDTO().getBizId());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_BIZ_TYPE_EMPTY, bammDTO.getBbsAllMainMsgDTO().getBizType());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_CLIENT_FLAG_EMPTY, bammDTO.getBbsAllMainMsgDTO().getClientFlag());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_BRIEF_TPYE_EMPTY, bammDTO.getBbsAllMainMsgDTO().getBriefTpye());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_DETAILED_TYPE_EMPTY, bammDTO.getBbsAllMainMsgDTO().getDetailedType());
        /*BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_DETAILED_TYPE_DESC_EMPTY, bammDTO.getBbsAllMainMsgDTO().getDetailedTypeDesc());*/
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_TITLE_EMPTY, bammDTO.getBbsAllMainMsgDTO().getTitle());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_CONTENT_EMPTY, bammDTO.getBbsAllMainMsgDTO().getContent());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_SENDER_NAME_EMPTY, bammDTO.getBbsAllMainMsgDTO().getSenderName());
        /*BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_HANDLER_URL_EMPTY, bammDTO.getBbsAllMainMsgDTO().getHandlerUrl());*/
        /*BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_HANDLER_PARAMS_EMPTY, bammDTO.getBbsAllMainMsgDTO().getHandlerParams());*/
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_SINGLE_HANDLE_IS_EMPTY, bammDTO.getBbsAllMainMsgDTO().getSingleHandleIs());
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_MAIN_HANDLER_NEED_IS_EMPTY, bammDTO.getBbsAllMainMsgDTO().getHandlerNeedIs());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_APP_ID_EMPTY, bammDTO.getBbsAllMainMsgDTO().getAppId());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_APP_NAME_EMPTY, bammDTO.getBbsAllMainMsgDTO().getAppName());

        log.info("保存站内消息,dto[{}] ", JSONUtils.toJsonString(bammDTO));
        String userType = bammDTO.getRecvType();
        List<BbsAllReceiveMsgSaveReqDTO> dtoList = null;
        if(BbsAllMainMsgSaveReqDTO.ROLE_RECV_TYPE.equals(userType)){
            dtoList = getNewDto(bammDTO);
        }
        if(BbsAllMainMsgSaveReqDTO.PERSON_RECV_TYPE.equals(userType)){
            dtoList = buidlerBbsAllReceiveMsgSaveReqDTO(bammDTO.getLookUsers(),bammDTO.getHandlerUsers());
        }

        if(dtoList==null){
            return Result.fail("接收人列表不为空！！");
        }
        /*for(BbsAllReceiveMsgSaveReqDTO dto : dtoList){
            BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_RECEIVE_ID_EMPTY, dto.getReceiveId());
            BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_RECEIVE_HANDLER_NEED_IS_EMPTY, dto.getHandlerNeedIs());
        }*/

        //保存至历史库主表
        Date date = new Date();
        BbsAllMainMsg bamm = dozerUtils.map(bammDTO.getBbsAllMainMsgDTO(),BbsAllMainMsg.class);
        bamm.setCreateTime(date);
        BbsAllMainMsg bbsAllMainMsg = bbsAllMainMsgService.save(bamm);

        //保存至正式库主表
        BbsIncrementMainMsg bimm = dozerUtils.map(bbsAllMainMsg,BbsIncrementMainMsg.class);
        bbsIncrementMainMsgService.saveBimm(bimm);


        List<BbsAllReceiveMsgSaveResDTO> resDtoList = new ArrayList<BbsAllReceiveMsgSaveResDTO>();
        if(dtoList!=null&&dtoList.size()>0){
            for(BbsAllReceiveMsgSaveReqDTO dto:dtoList){
                BbsAllReceiveMsg barm = dozerUtils.map(dto,BbsAllReceiveMsg.class);
                barm.setCreateTime(date);
                barm.setUpdateTime(date);
                barm.setMsgId(bbsAllMainMsg.getId());
                //保存至历史库接收表
                BbsAllReceiveMsg bbsAllReceiveMsg = bbsAllReceiveMsgService.save(barm);

                //组装接收信息返回DTO
                BbsAllReceiveMsgSaveResDTO bbsAllReceiveMsgSaveResDTO = dozerUtils.map(bbsAllReceiveMsg,BbsAllReceiveMsgSaveResDTO.class);
                resDtoList.add(bbsAllReceiveMsgSaveResDTO);

                //保存至正式库接收表
                BbsIncrementReceiveMsg birm = new BbsIncrementReceiveMsg();
                birm.setId(bbsAllReceiveMsg.getId());
                birm.setMsgId(bbsAllMainMsg.getId());
                birm.setReadIs(bbsAllReceiveMsg.getReadIs());
                birm.setCreateTime(bbsAllReceiveMsg.getCreateTime());
                birm.setUpdateTime(bbsAllReceiveMsg.getUpdateTime());
                birm.setHandlerNeedIs(bbsAllReceiveMsg.getHandlerNeedIs());
                birm.setMsgId(bbsAllReceiveMsg.getMsgId());
                birm.setReceiveId(bbsAllReceiveMsg.getReceiveId());
                bbsIncrementReceiveMsgService.saveBrim(birm);
            }
        }

        //3.数据返回
        BbsAllMainMsgSaveResDTO bbsAllMainMsgSaveResDTO = dozerUtils.map(bbsAllMainMsg,BbsAllMainMsgSaveResDTO.class);
        bbsAllMainMsgSaveResDTO.setBbsAllReceiveMsgSaveResDTO(resDtoList);
        return Result.success(dozerUtils.map(bbsAllMainMsgSaveResDTO,BbsAllMainMsgSaveResDTO.class));
    }

    /**
     * 构建dto
     * @param lookUsers
     * @param handlerUsers
     * @return
     */
    private List<BbsAllReceiveMsgSaveReqDTO> buidlerBbsAllReceiveMsgSaveReqDTO(List<Long> lookUsers, List<Long> handlerUsers) {
        List<BbsAllReceiveMsgSaveReqDTO> result = new ArrayList<>();
        if(!CollectionUtils.isEmpty(lookUsers)){
            for (Long lookuser: lookUsers) {
                BbsAllReceiveMsgSaveReqDTO dto = new BbsAllReceiveMsgSaveReqDTO();
                dto.setDeleteIs(false);
                dto.setHandlerNeedIs(false);
                dto.setReadIs(false);
                dto.setReceiveId(lookuser);
                result.add(dto);
            }
        }
        if(!CollectionUtils.isEmpty(handlerUsers)){
            for (Long handlerUser: handlerUsers) {
                BbsAllReceiveMsgSaveReqDTO dto = new BbsAllReceiveMsgSaveReqDTO();
                dto.setDeleteIs(false);
                dto.setHandlerNeedIs(true);
                dto.setReadIs(false);
                dto.setReceiveId(handlerUser);
                result.add(dto);
            }
        }
        return result;
    }

    /**
     * 获取角色类型接收人
     */
    public List<BbsAllReceiveMsgSaveReqDTO> getNewDto(BbsAllMainMsgSaveReqDTO bammDTO){
        List<BbsAllReceiveMsgSaveReqDTO> result = null;
        RoleDto roleDto = new RoleDto();
        roleDto.setCode(bammDTO.getRoleCode());
        roleDto.setAppId(bammDTO.getRoleAppId());
        Result<List<Long>> res = roleApi.findUsers(roleDto);
        if(res==null){
            log.info("获取角色用户结果[{}]",res);
            return null;
        }
        Boolean roleHandIs = bammDTO.getRoleHandIs();
        if(res.getData()==null){
            return null;
        }
        if(res.getData().size()<=0){
            return null;
        }
        if(roleHandIs){
            result = buidlerBbsAllReceiveMsgSaveReqDTO(null, res.getData());
        }else{
            result = buidlerBbsAllReceiveMsgSaveReqDTO(res.getData(), null);
        }
        return result;
    }
}


