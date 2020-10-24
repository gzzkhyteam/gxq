package com.hengyunsoft.platform.supervise.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.SuperviseExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.piping.api.msgs.dto.WarnMessageDTO;
import com.hengyunsoft.platform.piping.open.WarnMessageSendOpenApi;
import com.hengyunsoft.platform.supervise.dto.center.ServerSuperviseDetailDTO;
import com.hengyunsoft.platform.supervise.dto.center.ServerSupervisePageReqDTO;
import com.hengyunsoft.platform.supervise.dto.center.ServerSupervisePageResDTO;
import com.hengyunsoft.platform.supervise.dto.center.ServerSuperviseSaveDTO;
import com.hengyunsoft.platform.supervise.dto.center.ServerSuperviseSaveRetDTO;
import com.hengyunsoft.platform.supervise.dto.center.ServerSuperviseUpdateDTO;
import com.hengyunsoft.platform.supervise.entity.po.ServerSupervise;
import com.hengyunsoft.platform.supervise.impl.constant.SuperviseTypeEnum;
import com.hengyunsoft.platform.supervise.impl.constant.WarnConstat;
import com.hengyunsoft.platform.supervise.impl.manager.BizCommon;
import com.hengyunsoft.platform.supervise.repository.example.ServerSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.ServerSuperviseService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.hengyunsoft.platform.supervise.util.TransUtil.getSuperviseTime;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务监管API
 * 修改人：sxy
 * 修改时间：2018/9/12
 * 修改内容：新增基础服务
 */
@Api(value = "API - ServerSuperviseApiImpl.java", description = "服务监管API")
@RestController
@RequestMapping("serversupervise")
@Slf4j
public class ServerSuperviseApiImpl {


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    BizCommon bizCommon;

    @SuppressWarnings("rawtypes")
    @Resource(name = "redisSuperviseTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    WarnMessageSendOpenApi warnApi;

    @Autowired
    ApplicationApi applicationApi;

    @Autowired
    private ServerSuperviseService serverSuperviseService;

    /**
     * 服务监管保存
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "服务监管保存", notes = "服务监管保存")
    @ApiResponses({
            @ApiResponse(code = 110141, message = "服务监管所属服务ID不能为空"),
            @ApiResponse(code = 110146, message = "服务监管服务编码不能为空"),
            @ApiResponse(code = 110144, message = "服务监管上限阀值不能为空"),
            @ApiResponse(code = 110145, message = "服务监管阀值周期不能为空"),
            @ApiResponse(code = 110124, message = "责任人不能为空"),
            @ApiResponse(code = 110125, message = "确认人不能为空"),
            @ApiResponse(code = 110126, message = "提醒方式不能为空"),
            @ApiResponse(code = 110128, message = "运行状态不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<ServerSuperviseSaveRetDTO> save(@RequestBody ServerSuperviseSaveDTO dto) {

        //校验
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SERVER_SUPERVISE_SERVER_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SERVER_SUPERVISE_CODE_NULL, dto.getAppCode());
        BizAssert.assertNotNull(SuperviseExceptionCode.SERVER_SUPERVISE_WARN_LIMIT_NULL, dto.getLimit());
        BizAssert.assertNotNull(SuperviseExceptionCode.SERVER_SUPERVISE_LIMIT_CYCLE_NULL, dto.getLimitCycle());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_DUTY_USER_NULL, dto.getDutyUser());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_CONFIRM_USER_NULL, dto.getConfirmUser());
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_REMIND_TYPE_NULL, dto.getRemindType());
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_RUN_STATUS_NULL, dto.getRunStatus());

        //转换
        ServerSupervise entity = dozerUtils.map(dto, ServerSupervise.class);
        entity.setCreateUser(BaseContextHandler.getAdminId());
        entity.setCreateTime(new Date());
        entity.setUpdateUser(BaseContextHandler.getAdminId());
        entity.setUpdateTime(new Date());
        entity.setUpdateTime(new Date());

        //校验重复提交
        ServerSuperviseExample ex = new ServerSuperviseExample();
        ex.createCriteria().andAppCodeEqualTo(dto.getAppCode());
        ServerSupervise serverSupervise = serverSuperviseService.getUnique(ex);
        if (serverSupervise != null && StringUtils.isNotEmpty(serverSupervise.getAppCode())) {
            Result.fail("服务编码不能重复！！");
        }
        entity.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(dto.getLimitCycle().shortValue()), +1));

        //保存并返回
        ServerSupervise resEntity = serverSuperviseService.save(entity);
        return Result.success(dozerUtils.map(resEntity, ServerSuperviseSaveRetDTO.class));
    }

    /**
     * 服务监管删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "服务监管删除", notes = "服务监管删除")
    @ApiResponses({
            @ApiResponse(code = 110140, message = "服务监管ID不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SERVER_SUPERVISE_SERVER_ID_NULL, id);

        //删除并返回
        serverSuperviseService.deleteById(id);
        return Result.success(true);
    }

    /**
     * 服务监管更新
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "服务监管更新", notes = "服务监管更新")
    @ApiResponses({
            @ApiResponse(code = 110140, message = "服务监管ID不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody ServerSuperviseUpdateDTO dto) {

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SERVER_SUPERVISE_SERVER_ID_NULL, dto.getId());

        //更新并返回
        ServerSupervise entity = serverSuperviseService.getById(dto.getId());
        if (entity == null) {
            return Result.fail("更新数据不存在！！");
        }
        ServerSupervise serverSupervise = dozerUtils.map(dto, ServerSupervise.class);
        if (dto.getLimitCycle() != null && entity.getLimitCycle() != dto.getLimitCycle()) {
            serverSupervise.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(dto.getLimitCycle().shortValue()), +1));
        }
        serverSuperviseService.updateByIdSelective(serverSupervise);
        return Result.success(true);
    }

    /**
     * 服务监管分页
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "服务监管分页", notes = "服务监管分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ServerSupervisePageResDTO>> page(@RequestBody OpenApiReq<ServerSupervisePageReqDTO> openApiReq) {

        //启动分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        if (openApiReq.getData().getAppId().isEmpty()) {
            return Result.success(new PageInfo<>());
        }
        ServerSuperviseExample ex = new ServerSuperviseExample();
        ex.createCriteria().andAppIdIn(openApiReq.getData().getAppId())
                .andRunStatusEqualTo(openApiReq.getData().getRunStatus());
        ex.setOrderByClause(" create_time desc");

        //查询并返回
        List<ServerSupervise> list = serverSuperviseService.find(ex);
        if (list == null) {
            return Result.success(null);
        }
        List<ServerSupervisePageResDTO> dtoList = dozerUtils.mapList(list, ServerSupervisePageResDTO.class);
        List<ApplicationAllDTO> appList = applicationApi.findAllList().getData();
        if (appList != null) {
            dtoList.forEach((li) -> {
                Map<String, String> map = bizCommon.getUserInfo(li.getConfirmUser(), li.getDutyUser(), li.getCopyUser());
                if (map != null) {
                    li.setConfirmUserName(map.get("confirmUserNames"));
                    li.setDutyUserName(map.get("dutyUserName"));
                    li.setCopyUserName(map.get("copyUserNames"));
                }
                appList.forEach((app) -> {
                    if (li.getAppId().equals(app.getAppId())) {
                        li.setAppName(app.getName());
                    }
                });
            });
        }
        return Result.success(new PageInfo<>(dtoList));
    }

    /**
     * 服务监管详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "服务监管详情", notes = "服务监管详情")
    @ApiResponses({
            @ApiResponse(code = 110140, message = "服务监管ID不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Result<ServerSuperviseDetailDTO> detail(@RequestParam(value = "id") Long id) {

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SERVER_SUPERVISE_SERVER_ID_NULL, id);

        //查询并返回
        ServerSupervise serverSupervise = serverSuperviseService.getById(id);

        //查询应用信息
        ApplicationAllDTO app = applicationApi.getAppInforByAppId(serverSupervise.getAppId()).getData();
        ServerSuperviseDetailDTO dto = dozerUtils.map(serverSupervise, ServerSuperviseDetailDTO.class);
        if (app != null) {
            dto.setAppName(app.getName());
        }
        Map<String, String> map = bizCommon.getUserInfo(dto.getConfirmUser(), dto.getDutyUser(), dto.getCopyUser());
        if (map != null) {
            dto.setConfirmUserName(map.get("confirmUserNames"));
            dto.setDutyUserName(map.get("dutyUserName"));
            dto.setCopyUserName(map.get("copyUserNames"));
        }
        return Result.success(dto);
    }

    /**
     * 根据日期获取年月日时字符串
     *
     * @param date
     * @return
     */
    private static StringBuilder getDateStr(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(cal.get(Calendar.YEAR)));
        sb.append(String.valueOf(cal.get(Calendar.MONTH) + 1));
        sb.append(String.valueOf(cal.get(Calendar.DATE)));
        sb.append(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
        return sb;
    }

    /**
     * 判断是否与当前时间匹配
     *
     * @return
     */
    public static boolean isMachCurrentTime(Date date) {
        if (date == null) {
            return false;
        }
        if (getDateStr(date).toString().equals(getDateStr(new Date()).toString())) {
            return true;
        }
        return false;
    }

    /**
     * 处理服务监管
     */
    public void addHandleServerSupervise() {

        //redis不存在
        if (redisTemplate == null) {
            log.info("定时获取缓存服务调用统计信息,redis服务不存在!!");
            return;
        }
        Object mapObj = redisTemplate.opsForValue().get(CommonConstants.SERVER_LIMIT_CODE_CACHE_LIST);
        ConcurrentHashMap<String, Object> cacheMap = (ConcurrentHashMap<String, Object>) mapObj;

        try {
            //无缓存数据
            if (cacheMap == null) {
                log.info("定时获取缓存中服务调用统计,暂无缓存数据!!");
                return;
            }

            //查询符合当前时间，并且为启用状态
            List<ServerSupervise> serverSupervise = serverSuperviseService.getUsableConfig();
            Set<String> set = cacheMap.keySet();
            for (String key : set) {
                for (ServerSupervise li : serverSupervise) {
                    if (li.getAppCode().equals(key)) {
                        Object obj = cacheMap.get(key);
                        if (obj != null) {
                            int limitValue = Integer.parseInt(obj.toString());
                            //超过阀值，并且与定时时间相等
                            if (limitValue > li.getLimit() && isMachCurrentTime(li.getScheduledTime())) {

                                //删除已预警服务统计阀值
                                cacheMap.remove(key);
                                String dutyUser = li.getDutyUser();
                                String confirmUser = li.getConfirmUser();
                                String copyUser = li.getCopyUser();
                                String appId = li.getCopyUser();
                                Map<String, String> userMap = bizCommon.getUserInfo(confirmUser, dutyUser, copyUser);
                                String confirmUserNames = null;
                                String dutyUserName = null;
                                String copyUserNames = null;
                                if (userMap != null) {
                                    confirmUserNames = userMap.get("confirmUserNames");
                                    dutyUserName = userMap.get("dutyUserName");
                                    copyUserNames = userMap.get("copyUserNames");
                                }
                                ApplicationAllDTO appDto = applicationApi.getAppInforByAppId(li.getAppId()).getData();
                                String appName = null;
                                if (appDto != null) {
                                    appName = appDto.getName();
                                }
                                String content = null;
                                if (StringUtils.isEmpty(copyUserNames)) {
                                    content = MessageFormat.format("服务运行监管通知，{0}产生预警，责任人是{1}，确认人{2}，请及时处理。",
                                            appName, dutyUserName, confirmUserNames);
                                } else {
                                    content = MessageFormat.format("服务运行监管通知，{0}产生预警，责任人是{1}，确认人{2}，抄送人是{3}，请及时处理。",
                                            appName, dutyUserName, confirmUserNames, copyUserNames);
                                }

                                //产生预警 -- 这里只做一次发送
                                WarnMessageDTO warnDto = bizCommon.buildWarnDto(dutyUser, copyUser, confirmUser, copyUserNames, dutyUserName, confirmUserNames, appName, appId);
                                warnDto.setContent(content);
                                warnDto.setLevel(li.getLevel() == null ? 1 : li.getLevel());
                                warnDto.setTitle("服务运行监管");
                                // TODO: 2018/9/21 要注意需要提前配置
                                warnDto.setTypeId(WarnConstat.server_supervise_warn_id);
                                warnDto.setType(WarnConstat.server_supervise_warn_name);

                                //发预警
                                Result<String> result = warnApi.saveInsideSend(warnDto);
                                if (result != null && result.getData() == null) {
                                    log.info("发送预警返回结果:errcode[{}],errmsg[{}]", result.getErrcode(), result.getErrmsg());
                                }

                                //更新定时信息-往后推移
                                ServerSupervise serverSup = new ServerSupervise();
                                serverSup.setId(li.getId());
                                serverSup.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(li.getLimitCycle().shortValue()), +1));
                                serverSup.setUpdateTime(new Date());
                                serverSuperviseService.updateByIdSelective(serverSup);

                                //发送短信或者消息 提醒方式 消息:1,短信:2
                                if (li.getRemindType() == 1) {
                                    sendMSG(li, dutyUser, confirmUser, copyUser, content);
                                } else if (li.getRemindType() == 2) {

                                    //发短信-组装短信模板
                                    sendSMS(dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames, appName);
                                } else if (li.getRemindType() == 3) {
                                    //消息
                                    sendMSG(li, dutyUser, confirmUser, copyUser, content);

                                    //短信
                                    sendSMS(dutyUser, confirmUser, copyUser, confirmUserNames, dutyUserName, copyUserNames, appName);
                                }
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            log.info("定时获取缓存中服务调用统计失败!!", e);
        } finally {
            redisTemplate.opsForValue().set(CommonConstants.SERVER_LIMIT_CODE_CACHE_LIST, cacheMap);
        }
    }

    /* *
     * @Author wz
     * @Description //消息方法提取
     * @Date 14:04 2019/4/19
     * @Param [li, dutyUser, confirmUser, copyUser, content]
     * @return void
     **/
    private void sendMSG(ServerSupervise li, String dutyUser, String confirmUser, String copyUser, String content) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setBizId(String.valueOf(li.getId()));
        bbsAllMainMsgDTO.setBizType("handle_server_supervise");
        bbsAllMainMsgDTO.setBriefTpye("work_supervise");

        bbsAllMainMsgDTO.setContent(content);
        bbsAllMainMsgDTO.setTitle("服务监管处理");
        bbsAllMainMsgDTO.setDetailedType("handle_server_supervise_send_warn");
        bbsAllMainMsgDTO.setDetailedTypeDesc("服务监管处理发送预警");

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
    private void sendSMS(String dutyUser, String confirmUser, String copyUser, String confirmUserNames, String dutyUserName, String copyUserNames, String appName) {
        //发短信-组装短信模板
        Map<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("{1}", "服务运行监管");
//        hashMap.put("{2}", appName + "服务");
//        hashMap.put("{3}", dutyUserName);
//        hashMap.put("{4}", confirmUserNames);
        StringBuilder sb = new StringBuilder();
        sb.append("服务运行监管通知," + appName + "产生预警。");
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
                                    /*hashMap.put("name", "服务监管处理");//信息内容
                                    hashMap.put("desc", "高新区一体化系统-统一监管平台-服务监管处理");//信息描述*/
        bizCommon.addSendPhoneUserList(confirmUser, copyUser, dutyUser, hashMap);
    }
}