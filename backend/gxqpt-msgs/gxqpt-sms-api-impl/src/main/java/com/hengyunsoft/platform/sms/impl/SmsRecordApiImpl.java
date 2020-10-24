package com.hengyunsoft.platform.sms.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SmsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.biz.MessageService;
import com.hengyunsoft.platform.msgs.dto.msg.*;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgscontactoften.po.MsgsContactOften;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgscontactoften.example.MsgsContactOftenExample;
import com.hengyunsoft.platform.msgs.repository.msgscontactoften.service.MsgsContactOftenService;
import com.hengyunsoft.platform.sms.api.SmsRecordApi;
import com.hengyunsoft.platform.sms.constant.SmSConstant;
import com.hengyunsoft.platform.sms.dto.*;
import com.hengyunsoft.platform.sms.entity.template.dos.QuerySmsRecordDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsRecordDO;
import com.hengyunsoft.platform.sms.entity.template.po.SendStatus;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample;
import com.hengyunsoft.platform.sms.repository.publisher.service.SmsBlacklistService;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;
import com.hengyunsoft.platform.sms.repository.template.service.SendStatusService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsChannelOwnerService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsRecordService;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信记录服务
 *
 * @author dxz
 */
@RestController
@Slf4j
@Api(value = "短信记录服务", description = "短信记录服务")
public class SmsRecordApiImpl implements SmsRecordApi {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private SendStatusService sendStatusService;
    @Autowired
    private SmsRecordService smsRecordService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MsgsChannelService msgsChannelService;
    @Autowired
    private SmsChannelOwnerService smsChannelOwnerService;
    @Autowired
    private SmsTemplateService smsTemplateService;
    @Autowired
    private MsgsContactOftenService msgsContactOftenService;
    @Autowired
    private SmsBlacklistService smsBlacklistService;

    /**
     * 删除短信记录
     */
    @Override
    @ApiOperation(value = "删除短信记录", notes = "删除短信记录")
    @ApiResponses({
            @ApiResponse(code = 45112, message = "短信记录ID不能为空"),
    })
    public Result<String> deleteById(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(SmsExceptionCode.SMS_ID_NULL, id);

        //2.更新并返回
        SmsRecord smsRecord = new SmsRecord();
        smsRecord.setId(id);
        smsRecord.setDeleteIs(true);
        if (smsRecordService.updateByIdSelective(smsRecord) > 0) {
            return Result.success("success");
        }
        return Result.fail("fail");
    }

    /**
     * 获取短信记录分页列表
     *
     * @return
     */
    @Override
    @ApiOperation(value = "获取短信记录分页列表", notes = "获取短信记录分页列表")
    @ApiResponses({
            @ApiResponse(code = 45127, message = "短信记录来源类型不能为空"),
            @ApiResponse(code = 45128, message = "入参实体不能为空")
    })
    public Result<PageInfo<SmsRecordPageResDTO>> pageSmsRecordExtList(@RequestBody OpenApiReq<QuerySmsExtRecordDTO> openApiReq) {

        //1.校验
        QuerySmsExtRecordDTO req = openApiReq.getData();
        BizAssert.assertNotNull(SmsExceptionCode.SMS_ENTITY_NULL, req);
        BizAssert.assertNotEmpty(SmsExceptionCode.SMS_RECORD_SOURCE_TYPE_NULL, req.getSourceType());

        //2.查询并返回
        SmsRecordExample ex = new SmsRecordExample();
        ex.createCriteria().andSourceTypeLike(SmsRecordExample.fullLike(req.getSourceType()))
                .andAppNameLike(SmsRecordExample.fullLike(req.getAppName()))
                .andSenderNameLike(SmsRecordExample.fullLike(req.getSenderName()))
                .andTopicLike(SmsRecordExample.fullLike(req.getTopic()))
                .andReceiverEqualTo(req.getPhone())
                .andDeleteIsEqualTo(false)
                .andSendTimeBetween(req.getStartTime(), req.getEndTime());
        List<SmsRecord> list = smsRecordService.find(ex);
        if (SmSConstant.SystemType.MODULAR.toString().equals(req.getSourceType())) {
            list.forEach(val -> {
                val.setAppId(String.valueOf(val.getModuleId()));
                val.setAppName(val.getModuleName());
            });
        }
        return Result.success(new PageInfo<>(dozerUtils.mapList(list, SmsRecordPageResDTO.class)));
    }

    /**
     * 查询短信记录列表、草稿列表
     *
     * @return
     */
    @Override
    @ApiOperation(value = "获取分页列表", notes = "获取分页列表")
    @ApiResponses({
            @ApiResponse(code = 45110, message = "参数错误")
    })
    public Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(@RequestBody OpenApiReq<QuerySmsRecordDTO> openApiReq) {
        QuerySmsRecordDTO querySmsRecordDTO = openApiReq.getData();
        BizAssert.assertNotNull(SmsExceptionCode.SMS_RECORDPARAM_ERROR, querySmsRecordDTO);
        QuerySmsRecordDO querySmsRecordDO = dozerUtils.map(querySmsRecordDTO, QuerySmsRecordDO.class);
        try {
            String appId = BaseContextHandler.getAppId();
            String channelId = querySmsRecordDTO.getChannelId();
			/*SmsRecordExample smsRecordExample = new SmsRecordExample();
			String topic = querySmsRecordDTO.getTopic();
			String sourceType = querySmsRecordDTO.getSourceType();*/
            //if(StringUtils.isEmpty(sourceType)){
				/*if(querySmsRecordDTO.getDraft()==1){
					smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
							.andTopicLike(SmsRecordExample.fullLike(topic)).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
					.andCreateTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime());
				}else{
					smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
							.andTopicLike(SmsRecordExample.fullLike(topic)).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
					.andSendTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime());
				}*/
            //Draft()==1 按照创建时间查数据，按照发送时间查数据
            //}else{
				/*if(querySmsRecordDTO.getDraft()==1){
					smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
					.andTopicLike(querySmsRecordDTO.getTopic()).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
					.andCreateTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime()).andSourceTypeEqualTo(sourceType);
				}else{
					smsRecordExample.createCriteria().andSenderEqualTo(String.valueOf(userId)).andChannelIdEqualTo(channelId)
					.andTopicLike(querySmsRecordDTO.getTopic()).andDraftEqualTo(querySmsRecordDTO.getDraft()).andAppIdEqualTo(appId)
					.andSendTimeBetween(querySmsRecordDTO.getStartTime(), querySmsRecordDTO.getEndTime()).andSourceTypeEqualTo(sourceType);
				}*/
            //}
            //smsRecordExample.setOrderByClause("create_time desc");
            querySmsRecordDO.setAppId(appId);
            querySmsRecordDO.setSender(String.valueOf(BaseContextHandler.getAdminId()));
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<SmsRecordDO> list = smsRecordService.pageSmsRecordList(querySmsRecordDO);
            List<SmsRecordDTO> pageDate = dozerUtils.mapList(list, SmsRecordDTO.class);
            if (pageDate == null || pageDate.size() == 0) {
                return Result.success(new PageInfo<>(pageDate));
            }

            //渠道名称
            if (StringUtil.isNotEmpty(channelId)) {
                MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(channelId));
                if (msgsChannel != null) {
                    for (SmsRecordDTO smsRecordDTO : pageDate) {
                        smsRecordDTO.setChannelName(msgsChannel.getName());
                    }
                }
            } else {
                SmsChannelOwnerExample smsChannelOwnerExample = new SmsChannelOwnerExample();
                smsChannelOwnerExample.createCriteria().andAppIdEqualTo(appId);
                List<SmsChannelOwner> channelList = smsChannelOwnerService.find(smsChannelOwnerExample);
                Map<String, String> map = new HashMap<String, String>();
                for (SmsChannelOwner smsChannelOwner : channelList) {
                    map.put(String.valueOf(smsChannelOwner.getChannelId()), smsChannelOwner.getChannelName());
                }
                for (SmsRecordDTO smsRecordDTO : pageDate) {
                    smsRecordDTO.setChannelName(map.get(smsRecordDTO.getChannelId()));
                }
            }
            return Result.success(new PageInfo<>(pageDate));
        } catch (Exception e) {
            log.error("获取短信记录列表、草稿列表出错", e);
            return Result.fail("获取短信记录列表、草稿列表出错");
        }
    }

    /**
     * 查询短信记录详情、草稿详情
     *
     * @return
     */
    @Override
    @ApiOperation(value = "查询短信记录详情、草稿详情", notes = "查询短信记录详情、草稿详情")
    @ApiResponses({
            @ApiResponse(code = 45111, message = "短信信息ID为空"),
    })
    public Result<SmsRecordDetailDTO> getSmsRecordDetail(@RequestParam(value = "msgId") String msgId) {
        if (StringUtils.isEmpty(msgId)) {
            BizAssert.assertNotNull(SmsExceptionCode.SMS_MSGID_NULL, msgId);
        }
        try {
            SmsRecord smsRecord = smsRecordService.selectByMsgId(msgId);
            //获取发送成功、失败个数
            List<SendStatus> smsList = sendStatusService.getByMsgId(msgId);
            String templateName = "";
            String content = "";
            if (smsRecord.getTemplateId() != null) {
                SmsTemplate smsTemplate = smsTemplateService.getById(smsRecord.getTemplateId());
                templateName = smsTemplate.getName();
                content = smsTemplate.getContent();
            }
            int success = 0;
            int error = 0;
            if (smsList != null && smsList.size() != 0) {
                for (SendStatus sendStatus : smsList) {
                    Integer status = sendStatus.getSendStatus();
                    if (status == 1) {
                        success += 1;
                    } else if (status == 2) {
                        error += 1;
                    }
                }
            }
            SmsRecordDetailDTO smsRecordDetailDTO = dozerUtils.map(smsRecord, SmsRecordDetailDTO.class);
            MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(smsRecordDetailDTO.getChannelId()));
            if (msgsChannel != null) {
                smsRecordDetailDTO.setChannelName(msgsChannel.getName());
                smsRecordDetailDTO.setChannelServer(msgsChannel.getChannelServer());
            }
            smsRecordDetailDTO.setSuccess(success);
            smsRecordDetailDTO.setFail(error);
            smsRecordDetailDTO.setTemplateName(templateName);
            smsRecordDetailDTO.setContent(content);
            return Result.success(smsRecordDetailDTO);
        } catch (Exception e) {
            log.error("获取短信记录详情、草稿详情出错", e);
            return Result.fail("获取短信记录详情、草稿详情出错");
        }
    }


    /**
     * 新建发送、保存草稿、定时发送
     */
    @Override
    @ApiOperation(value = "新建发送、保存草稿、定时发送", notes = "新建发送、保存草稿、定时发送")
    @ApiResponses({
            @ApiResponse(code = 45113, message = "短信信息不能为空"),
            @ApiResponse(code = 45116, message = "短信接收人不能为空"),
            @ApiResponse(code = 45117, message = "短信发送渠道不能为空"),
            @ApiResponse(code = 45118, message = "短信信息模板ID不能为空"),
            @ApiResponse(code = 45119, message = "短信信息模板参数不能为空"),
            @ApiResponse(code = 45130, message = "短信内容不能为空"),
            @ApiResponse(code = 45131, message = "短信主题不能为空"),
    })
    public Result<String> addSmsRecord(@RequestBody MessageDTO messageDTO) {
        BizAssert.assertNotNull(SmsExceptionCode.SMS_MESSAGE_NULL, messageDTO);
        BizAssert.assertNotNull(SmsExceptionCode.SMS_RECEIVER_NULL, messageDTO.getReceiver());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_MESSAGECHANNELID_NULL, messageDTO.getChannelId());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_MESSAGETEMPLATEID_NULL, messageDTO.getTemplateId());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEPARAMS_NULL, messageDTO.getTemplateParams());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TOPIC_NULL, messageDTO.getTopic());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_CONTEXT_NULL, messageDTO.getContext());

        try {
            //查询当前登陆人是否在软件系统被拉黑
            String appName = BaseContextHandler.getAppName();
            String appId = BaseContextHandler.getAppId();
            Long userId = BaseContextHandler.getAdminId();
            //随消息管理系统改变start
            String channelId = messageDTO.getChannelId();
            JSONObject json = JSONObject.fromObject(channelId);
            String channelIds = (String) json.get("Sms");
            String[] channel = channelIds.split(",");
            List<MsgsChannelThreeDTO> list = new ArrayList<MsgsChannelThreeDTO>();
            for (String s : channel) {
                MsgsChannelThreeDTO msgsChannelThreeDTO = new MsgsChannelThreeDTO();
                msgsChannelThreeDTO.setChannelType("3");
                msgsChannelThreeDTO.setId(Long.valueOf(s));
                list.add(msgsChannelThreeDTO);
            }
            //验证黑名单
            String ss = channel[0];
            MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(ss));
            if (msgsChannel == null) {
                return Result.fail("您所选的账号不存在");
            }
            SmsBlacklistExample smsBlacklistExample = new SmsBlacklistExample();
            smsBlacklistExample.createCriteria().andGxqptEmpIdEqualTo(userId).andAppIdEqualTo(appId);
            Integer blackCount = smsBlacklistService.count(smsBlacklistExample);
            if (blackCount != null && blackCount > 0) {
                return Result.fail("您已被加入黑名单，请联系系统管理员");
            }
            messageDTO.setChannelIds(list);
            messageDTO.setChannelId(null);
            //随消息管理系统改变end
            if (StringUtil.isEmpty(appId)) {
                appId = BaseContextHandler.getAppId();
            }
            if (StringUtil.isEmpty(appName)) {
                appName = BaseContextHandler.getAppName();
            }
            messageDTO.setAppId(appId);
            messageDTO.setAppName(appName);
            messageDTO.setSourceType(SmSConstant.SystemType.APP.toString());
            String reciver = messageDTO.getReceiver();
            List<String> recivers = Arrays.asList(reciver.split(","));
            String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
            for (String mobile : recivers) {
                if (mobile.indexOf("<") >= 0) {
                    mobile = mobile.substring(mobile.indexOf("<") + 1, mobile.indexOf(">"));
                }
                if (mobile.length() != 11) {
                    return Result.fail("手机号应为11位数");
                } else {
                    Pattern p = Pattern.compile(PHONE_NUMBER_REG);
                    Matcher m = p.matcher(mobile);
                    if (!m.matches()) {
                        return Result.fail("手机号格式不正确");
                    }
                }
            }
            String result = messageService.saveMessage(messageDTO);
            return Result.success(result);
        } catch (Exception e) {
            log.error("新建发送、保存草稿、定时发送出错", e);
            return Result.fail("新建发送、保存草稿、定时发送出错");
        }
    }

    /**
     * 查询短信渠道
     */
    @Override
    @ApiOperation(value = "查询短信渠道", notes = "查询短信渠道")
    @ApiResponses({
            @ApiResponse(code = 45114, message = "应用程序ID不能为空"),
    })
    public Result<List<SmsChannelDTO>> getSmsChannelList(@RequestParam(value = "appId") String appId) {
        if (StringUtils.isEmpty(appId)) {
            BizAssert.assertNotNull(SmsExceptionCode.SMS_APPID_NULL, appId);
        }
        //SmsChannelOwnerExample smsChannelOwnerExample = new SmsChannelOwnerExample();
        try {
            //smsChannelOwnerExample.createCriteria().andAppIdEqualTo(appId);
            //List<SmsChannelOwner> list = smsChannelOwnerService.find(smsChannelOwnerExample);
            SmsChannelOwner owner = new SmsChannelOwner();
            owner.setAppId(appId);
            List<SmsChannelOwner> list = smsChannelOwnerService.getOwnerChannerl(owner);
            List<SmsChannelDTO> result = dozerUtils.mapPage(list, SmsChannelDTO.class);
            return Result.success(result);
        } catch (Exception e) {
            log.error("获取短信渠道出错", e);
            return Result.fail("获取短信渠道出错");
        }
    }

    /**
     * 批量删除草稿
     */
    @Override
    @ApiOperation(value = "批量删除草稿", notes = "批量删除草稿")
    @ApiResponses({
            @ApiResponse(code = 45112, message = "短信记录ID不能为空"),
    })
    public Result<String> deleteSmsDraft(@RequestParam(value = "recordIds") String recordIds) {
        BizAssert.assertNotNull(SmsExceptionCode.SMS_ID_NULL, recordIds);
        try {
            if (StringUtils.isEmpty(recordIds)) {
                return Result.fail("fail");
            }
            String[] ids = recordIds.split(",");
            List<String> list = Arrays.asList(ids);
            List<Long> newList = new ArrayList<Long>();
            for (String id : list) {
                Long newId = Long.parseLong(id);
                newList.add(newId);
            }
            smsRecordService.batchDeleteDraft(newList);
            return Result.success("success");
        } catch (Exception e) {
            log.error("批量删除草稿出错", e);
            return Result.fail("批量删除草稿出错");
        }
    }

    /**
     * 删除草稿
     */
    @Override
    @ApiOperation(value = "删除草稿", notes = "删除草稿")
    @ApiResponses({
            @ApiResponse(code = 45112, message = "短信记录ID不能为空"),
    })
    public Result<String> deleteSmsDraftById(@RequestParam(value = "recordId") Long recordId) {
        BizAssert.assertNotNull(SmsExceptionCode.SMS_ID_NULL, recordId);
        try {
            int result = smsRecordService.deleteById(recordId);
            if (result > 0) {
                return Result.success("success");
            }
        } catch (Exception e) {
            log.error("删除草稿出错", e);
            return Result.fail("删除草稿出错");
        }
        return Result.fail("fail");
    }


    /**
     * 编辑草稿
     */
    @Override
    @ApiOperation(value = "编辑草稿", notes = "编辑草稿")
    @ApiResponses({
            @ApiResponse(code = 45112, message = "短信记录ID不能为空"),
    })
    public Result<String> updateSmsRecord(@RequestParam(value = "id") Long id, @RequestBody MessageDTO messageDTO) {
        BizAssert.assertNotNull(SmsExceptionCode.SMS_ID_NULL, id);
        try {
            SmsRecord smsRecord = dozerUtils.map(messageDTO, SmsRecord.class);
            smsRecord.setId(id);
            smsRecord.setUpdateTime(new Date());
            int result = smsRecordService.updateById(smsRecord);
            if (result > 0) {
                return Result.fail("success");
            }
        } catch (Exception e) {
            log.error("编辑草稿出错", e);
            return Result.fail("编辑草稿出错");
        }
        return Result.fail("fail");
    }

    /**
     * 常用联系人初次显示以及输入框查询
     */
    @Override
    @ApiOperation(value = "常用联系人初次显示以及输入框查询", notes = "常用联系人初次显示以及输入框查询")
    public Result<PageInfo<MsgsContactOftenDTO>> getIdPhonenum(@RequestParam(value = "contact") String contact) {
        try {
            Object adminId = BaseContextHandler.get("currentAdminId");
            Long userId = new Long(adminId.toString());
            MsgsContactOftenExample msgsContactOftenExample = new MsgsContactOftenExample();
            if (contact == "") {
                msgsContactOftenExample.createCriteria().andUserIdEqualTo(userId);
            } else {
                msgsContactOftenExample.createCriteria().andContactLike(MsgsContactOftenExample.fullLike(contact)).andUserIdEqualTo(userId);
            }
            msgsContactOftenExample.setOrderByClause("use_num desc");
            List<MsgsContactOften> list = msgsContactOftenService.find(msgsContactOftenExample);
            List<MsgsContactOftenDTO> pageList = dozerUtils.mapPage(list, MsgsContactOftenDTO.class);
            return Result.success(new PageInfo<>(pageList));
        } catch (Exception e) {
            log.error("常用联系人初次显示以及输入框查询出错", e);
            return Result.fail("常用联系人初次显示以及输入框查询出错");
        }
    }

    /**
     * save
     */
    public void save(String num) {
        try {
            //num是人名+电话或者电话的形式
            Object currentAdminId = BaseContextHandler.get("currentAdminId");
            Long userId = new Long(currentAdminId.toString());
            Long adminId = BaseContextHandler.getAdminId();
            MsgsContactOftenSaveDTO msgscontactoftenSaveDTO = new MsgsContactOftenSaveDTO();
            MsgsContactOften msgscontactoften = dozerUtils.map(msgscontactoftenSaveDTO, MsgsContactOften.class);
            if (num.indexOf("<") != -1) {
                //名字号码
                String contact_name = num.substring(0, num.indexOf("<"));
                String contact_number = num.substring(num.indexOf("<") + 1, num.length() - 1);
                msgscontactoften.setContactname(contact_name);
                msgscontactoften.setContact(contact_number);
            } else {
                msgscontactoften.setContactname(num);
                msgscontactoften.setContact(num);
            }
            msgscontactoften.setCreateUser(BaseContextHandler.getAdminId());
            msgscontactoften.setCreateTime(Calendar.getInstance().getTime());
            msgscontactoften.setUseNum(1);
            msgscontactoften.setUserId(userId);
            msgscontactoften.setUpdateUser(adminId);
            msgscontactoften.setUpdateTime(Calendar.getInstance().getTime());
            msgscontactoften = msgsContactOftenService.save(msgscontactoften);
        } catch (Exception e) {
            log.error("保存常用联系人出错", e);
        }
    }

    /**
     * update
     *
     * @param num
     * @param list
     * @return
     */
    public int update(String num, List<MsgsContactOften> list) {
        try {
            MsgsContactOftenUpdateDTO msgscontactoftenUpdateDTO = new MsgsContactOftenUpdateDTO();
            Object currentAdminId = BaseContextHandler.get("currentAdminId");
            Long userId = new Long(currentAdminId.toString());
            Long adminId = BaseContextHandler.getAdminId();
            MsgsContactOften msgscontactoften = dozerUtils.map(msgscontactoftenUpdateDTO, MsgsContactOften.class);
            long id = list.get(0).getId();
            msgscontactoften.setId(id);
            msgscontactoften.setUserId(userId);
            msgscontactoften.setContact(num);
            msgscontactoften.setUpdateUser(adminId);
            msgscontactoften.setUpdateTime(Calendar.getInstance().getTime());
            msgscontactoften.setUseNum(list.get(0).getUseNum() + 1);
            int i = msgsContactOftenService.updateByIdSelective(msgscontactoften);
            return i;
        } catch (Exception e) {
            log.error("更新常用联系人出错", e);
            return -1;
        }
    }

    @Override
    @ApiOperation(value = "发送时常用联系人查询、更新", notes = "发送时常用联系人查询、更新")
    public Result<Boolean> getSendPhonenum(@RequestParam(value = "contact_send") String contact_send) {
        int isSuccess = 0;
        Object currentAdminId = BaseContextHandler.get("currentAdminId");
        Long userId = new Long(currentAdminId.toString());
        if (contact_send.contains(",")) {
            //拆分挨个查询是否存在
            String[] content_group = contact_send.split(",");
            for (int i = 0; i < content_group.length; i++) {
                String contact_bak = content_group[i];//人名电话或者直接为电话号码
                //获取人名
                String contact_name = contact_bak.substring(0, contact_bak.indexOf("<"));
                //获取电话号码
                String contact_number = contact_bak.substring(contact_bak.indexOf("<") + 1, contact_bak.length() - 1);
                MsgsContactOftenExample msgsContactOftenExample = new MsgsContactOftenExample();
                if (contact_name != "") {
                    //人名不为空拿人名去查
                    msgsContactOftenExample.createCriteria().andContactnameEqualTo(contact_name).andUserIdEqualTo(userId);
                } else {
                    //人名为空拿电话号码去查
                    msgsContactOftenExample.createCriteria().andContactEqualTo(contact_number).andUserIdEqualTo(userId);
                }
                List<MsgsContactOften> list_bak = msgsContactOftenService.find(msgsContactOftenExample);
                if (list_bak.size() == 0) {
                    //save
                    save(contact_bak);
                    isSuccess = 1;
                } else {
                    //update只有电话号码情况一定不会走这个
                    isSuccess = update(contact_number, list_bak);
                }
            }
        } else {
            //直接查询单条数据两种形式人名+电话号码或者电话号码
            //获取人名
            String contact_name = "";
            String contact_number = "";
            if (contact_send.indexOf(">") != -1) {//人名+电话号码形式
                contact_name = contact_send.substring(0, contact_send.indexOf("<"));
                ;
                //获取电话号码
                contact_number = contact_send.substring(contact_send.indexOf("<") + 1, contact_send.length() - 1);
            } else {
                contact_number = contact_send;
            }

            MsgsContactOftenExample msgsContactOftenExample = new MsgsContactOftenExample();
            if (contact_name != "") {
                //人名不为空拿人名去查
                msgsContactOftenExample.createCriteria().andContactnameEqualTo(contact_name).andUserIdEqualTo(userId);
            } else {
                //只有电话号码形式
                msgsContactOftenExample.createCriteria().andContactEqualTo(contact_send).andUserIdEqualTo(userId);
            }

            List<MsgsContactOften> list = msgsContactOftenService.find(msgsContactOftenExample);
            if (list.size() == 0) {
                //save
                save(contact_send);
                isSuccess = 1;
            } else {
                //update
                isSuccess = update(contact_number, list);
            }
        }
        if (isSuccess > 0) {
            return Result.success(true);
        } else {
            return Result.fail("失败");
        }
    }

    @Override
    public Result<Boolean> deleteContactByIds(@RequestParam(value = "ids") String ids) {
        BizAssert.assertNotNull(SmsExceptionCode.CONTACT_ID_NULL, ids);
        try {
            if (StringUtils.isEmpty(ids)) {
                return Result.fail("删除失败");
            }
            List<Long> contactIds = new ArrayList<>();
            for (String id : ids.split(",")) {
                contactIds.add(Long.parseLong(id));
            }
            if (msgsContactOftenService.deleteByIds(contactIds) > 0) {
                return Result.success(true);
            }
        } catch (Exception e) {
            log.error("联系人删除失败", e);
            return Result.fail("删除失败");
        }

        return Result.fail("删除失败");
    }

}