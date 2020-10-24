package com.hengyunsoft.platform.supervise.impl.center;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SuperviseExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.piping.api.msgs.dto.WarnMessageDTO;
import com.hengyunsoft.platform.piping.open.WarnMessageSendOpenApi;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import com.hengyunsoft.platform.supervise.entity.domain.PowerSuperviseTempDO;
import com.hengyunsoft.platform.supervise.entity.po.PowerSupervise;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseLink;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseTemp;
import com.hengyunsoft.platform.supervise.impl.constant.WarnConstat;
import com.hengyunsoft.platform.supervise.impl.manager.BizCommon;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseLinkExample;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTempExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseLinkService;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseService;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseTempService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：权责监管临时数据保存API
 * 修改人：sxy
 * 修改时间：2018/9/12
 * 修改内容：新增基础接口
 */
@Api(value = "API - PowerSuperviseTempApiImpl.java", description = "权责监管临时数据保存API")
@RestController
@RequestMapping("powersupervisetemp")
@Slf4j
public class PowerSuperviseTempApiImpl implements PowerSuperviseTempApi {


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    BizCommon bizCommon;

    @Autowired
    WarnMessageSendOpenApi warnApi;

    @Autowired
    private PowerSuperviseService powerSuperviseService;

    @Autowired
    private PowerSuperviseLinkService powerSuperviseLinkService;

    @Autowired
    private PowerSuperviseTempService powerSuperviseTempService;

    /**
     * 权责监管临时数据保存
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "权责监管临时数据保存", notes = "权责监管临时数据保存")
    @ApiResponses({
            @ApiResponse(code = 110121, message = "环节编码不能为空"),
            @ApiResponse(code = 110122, message = "环节名称不能为空"),
            @ApiResponse(code = 110129, message = "环节描述不能为空"),
            @ApiResponse(code = 110130, message = "开始时间不能为空"),
            //@ApiResponse(code = 110131, message = "结束时间不能为空"),
            @ApiResponse(code = 110124, message = "业务ID不能为空"),
            @ApiResponse(code = 110125, message = "应用ID不能为空"),
            @ApiResponse(code = 110126, message = "应用名称不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<PowerSuperviseTempSaveDTO> save(@RequestBody PowerSuperviseTempSaveDTO dto) {

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_APP_NAME_NULL, dto.getAppName());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_BIZ_ID_NULL, dto.getBizId());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_LINK_CODE_NULL, dto.getCode());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_LINK_NAME_NULL, dto.getName());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_LINK_DESC_NULL, dto.getDesc());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_START_TIME_NULL, dto.getStartTime());
        //BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_END_TIME_NULL, dto.getEndTime());

        //保存并返回
        PowerSuperviseTemp entity = dozerUtils.map(dto, PowerSuperviseTemp.class);
        entity.setCreateUser(BaseContextHandler.getAdminId());
        entity.setCreateTime(new Date());
        entity.setUpdateUser(BaseContextHandler.getAdminId());
        entity.setUpdateTime(new Date());
        entity.setIsFinish(false);
        entity.setIsSend(false);

        //校验重复提交
        PowerSuperviseTempExample tempEx = new PowerSuperviseTempExample();
        tempEx.createCriteria().andBizIdEqualTo(dto.getBizId()).andCodeEqualTo(dto.getCode()).andEndTimeIsNull();
        PowerSuperviseTemp powerSuperviseTemp = powerSuperviseTempService.getUnique(tempEx);
        if (powerSuperviseTemp != null) {
            PowerSuperviseTemp temp = new PowerSuperviseTemp();
            temp.setId(powerSuperviseTemp.getId());
            temp.setEndTime(entity.getEndTime());
            temp.setIsFinish(true);
            temp.setIsSend(true);
            powerSuperviseTempService.updateByIdSelective(temp);
            //根据业务id更新
            return Result.success(dozerUtils.map(entity, PowerSuperviseTempSaveDTO.class));
        }

        PowerSuperviseLinkExample ex = new PowerSuperviseLinkExample();
        ex.createCriteria().andCodeEqualTo(dto.getCode());
        PowerSuperviseLink powerSuperviseLink = powerSuperviseLinkService.getUnique(ex);
        if (powerSuperviseLink != null && StringUtils.isNotEmpty(powerSuperviseLink.getCode())) {
            return Result.success(dozerUtils.map(powerSuperviseTempService.save(entity), PowerSuperviseTempSaveDTO.class));
        }
        return Result.fail("环节编码不存在！！");
    }

    /**
     * 处理监管环节
     */
    public void addHandleSuperviseLink() {

        //获取未发送未处理环节
        List<PowerSuperviseTempDO> list = powerSuperviseTempService.getNotHandleLink();

        if (list == null) {
            log.info("获取未发送未处理环节,暂无数据!!");
            return;
        }
        for (PowerSuperviseTempDO li : list) {
            if(li.getEndTime() == null){//未结束
                String dutyUser = li.getDutyUser();
                String confirmUser = li.getConfirmUser();
                String copyUser = li.getCopyUser();
                String appId = li.getAppId();
                //String appName = li.getAppName();
                String systemName = li.getSystemName();
                Map<String, String> userMap = bizCommon.getUserInfo(confirmUser, dutyUser, copyUser);
                PowerSuperviseExample ex = new PowerSuperviseExample();
                ex.createCriteria().andIdEqualTo(li.getPowerSuperviseId());
                PowerSupervise powerSupervise = powerSuperviseService.getUnique(ex);
                String powerSuperviseName = powerSupervise == null?li.getLinkName():powerSupervise.getName();
                String confirmUserNames = null;
                String dutyUserName = null;
                String copyUserNames = null;
                log.info("定时处理监管环节，userMap,[{}]", userMap);
                if (userMap != null) {
                    confirmUserNames = userMap.get("confirmUserNames");
                    dutyUserName = userMap.get("dutyUserName");
                    copyUserNames = userMap.get("copyUserNames");
                }
                String content = null;
                if (StringUtils.isEmpty(copyUserNames)) {
                    content = MessageFormat.format("权责运行监管通知，“{0}”中“{1}”产生预警，责任人是{2}，确认人{3}，请及时处理。",
                            systemName,powerSuperviseName, dutyUserName, confirmUserNames);
                   //模板：权责运行监管通知，“XXXXX（系统名称）”中“XXXXX（权责名称）”产生预警，责任人是郑天艳，确认人郑天艳，请及时处理。
                } else {
                    content = MessageFormat.format("权责运行监管通知，“{0}”中“{1}”产生预警，责任人是{2}，确认人{3}，抄送人是{4}，请及时处理。",
                            systemName,powerSuperviseName, dutyUserName, confirmUserNames, copyUserNames);
                }
                if (bizCommon.validLimit(li.getStartTime(), li.getTimeLimit())) {
                    //产生预警 -- 这里只做一次发送
                    log.info("定时处理监管环节，appName,[{}],dutyUser,[{}],copyUser,[{}],confirmUser,[{}],copyUserNames,[{}],dutyUserName,[{}],confirmUserNames,[{}]",
                            systemName,dutyUser, copyUser, confirmUser, copyUserNames, dutyUserName, confirmUserNames);
                    WarnMessageDTO warnDto = bizCommon.buildWarnDto(dutyUser, copyUser, confirmUser, copyUserNames, dutyUserName, confirmUserNames, systemName, appId);
                    warnDto.setContent(content);
                    warnDto.setLevel(warnDto.getLevel() == null ? 1 : warnDto.getLevel());
                    warnDto.setTitle("权责运行监管");
                    // TODO: 2018/9/21 要注意需要提前配置
                    warnDto.setTypeId(WarnConstat.supervise_link_warn_id);
                    warnDto.setType(WarnConstat.supervise_link_warn_name);

                    //发预警
                    Result<String> result = warnApi.saveInsideSend(warnDto);
                    if (result != null) {
                        log.info("发送预警返回结果为[{}]", result.getData());
                    }

                    //更新预警状态为已发送，已处理。
                    PowerSuperviseTemp pst = new PowerSuperviseTemp();
                    pst.setId(li.getTempId());
                    pst.setIsSend(true);
                    pst.setIsFinish(true);
                    pst.setUpdateTime(new Date());
                    powerSuperviseTempService.updateByIdSelective(pst);

                    //发送短信或者消息 提醒方式 1-消息 2-短信 3-短信和消息
                    if (li.getRemindType() == 1) {
                        sendMSG(li, dutyUser, confirmUser, copyUser, content);//发消息
                    } else if (li.getRemindType() == 2) {
                        sendSMS(li, dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames);//发短信
                    } else if (li.getRemindType() == 3) {
                        sendMSG(li, dutyUser, confirmUser, copyUser, content);//发消息
                        sendSMS(li, dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames);//发短信
                    }
                }
            }
        }
    }

    /* *
     * @Author wz
     * @Description //消息方法提取
     * @Date 13:58 2019/4/19
     * @Param [li, dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames]
     * @return void
     **/
    private void sendMSG(PowerSuperviseTempDO li, String dutyUser, String confirmUser, String copyUser, String content) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setBizId(String.valueOf(li.getTempId()));
        bbsAllMainMsgDTO.setBizType("handle_supervise_link");
        bbsAllMainMsgDTO.setBriefTpye("work_supervise");
        bbsAllMainMsgDTO.setContent(content);
        bbsAllMainMsgDTO.setTitle("处理监管环节");
        bbsAllMainMsgDTO.setDetailedType("handle_supervise_link_send_warn");
        bbsAllMainMsgDTO.setDetailedTypeDesc("处理监管环节发送预警");

        //发消息
        bizCommon.addSendBbsUserList(confirmUser, copyUser, dutyUser, bbsAllMainMsgDTO);
    }

    /* *
     * @Author wz
     * @Description //TODO 短信模板更改，负责人有时间自行优化
     * @Date 13:58 2019/4/19
     * @Param [li, dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames]
     * @return void
     **/
    private void sendSMS(PowerSuperviseTempDO li, String dutyUser, String confirmUser, String copyUser, String confirmUserNames, String dutyUserName, String copyUserNames) {
        //发短信
        Map<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("{1}", "权责运行监管");
//       // hashMap.put("{2}", li.getLinkName() + "权责流程的" + li.getTempName() + "环节产生预警");
//        hashMap.put("{2}", li.getAppName() + "产生预警");
//        hashMap.put("{3}", dutyUserName);
//        hashMap.put("{4}", confirmUserNames);

        StringBuilder sb = new StringBuilder();

        sb.append("权责运行监管通知，"+li.getSystemName()+"，" + li.getAppName() + "产生预警。");
        if (!StringUtils.isEmpty(dutyUserName)) {
            sb.append("责任人是").append(dutyUserName).append(",");
        }
        if (!StringUtils.isEmpty(confirmUserNames)) {
            sb.append("确认人是").append(confirmUserNames).append(",");
        }
        if (!StringUtils.isEmpty(copyUserNames)) {
            sb.append("抄送人是").append(copyUserNames).append(",");
        }
        sb.append("请及时处理。");

        hashMap.put("{正文}", sb.toString());
        /*hashMap.put("name", "权责环节处理");//信息内容
        hashMap.put("desc", "高新区一体化系统-统一监管平台-权责环节处理");//信息描述*/
        bizCommon.addSendPhoneUserList(confirmUser, copyUser, dutyUser, hashMap);
    }
}
