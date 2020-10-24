package com.hengyunsoft.platform.supervise.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.exception.core.WarnExceptionCode;
import com.hengyunsoft.commons.msg.SuperviseBizTypeEnum;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogMaxDTO;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSuperviseDetailDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSupervisePageLikeDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSupervisePageResDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSuperviseSaveDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSuperviseScheduledDTO;
import com.hengyunsoft.platform.supervise.dto.center.apprunning.BizAppSuperviseUpdateDTO;
import com.hengyunsoft.platform.supervise.entity.po.BizAppSupervise;
import com.hengyunsoft.platform.supervise.impl.constant.SuperviseTypeEnum;
import com.hengyunsoft.platform.supervise.impl.constant.WarnConstat;
import com.hengyunsoft.platform.supervise.impl.manager.BizCommon;
import com.hengyunsoft.platform.supervise.repository.example.BizAppSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.BizAppSuperviseService;
import com.hengyunsoft.platform.supervise.util.TransUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.hengyunsoft.commons.exception.core.WarnExceptionCode.BIZ_APP_ID_NULL;
import static com.hengyunsoft.platform.supervise.util.TransUtil.getSuperviseTime;

/**
 * 业务应用运行监管配置
 */
@Api(value = "AppRunningSuperviseApi", description = "业务应用运行监管配置")
@RestController
@Slf4j
@RequestMapping("apprunningsupervise")
public class AppRunningSuperviseApiImpl {
    @Autowired
    BizAppSuperviseService appSuperviseService;
    @Autowired
    LoginLogApi loginLogApi;
    @Autowired
    ApplicationApi applicationApi;
    @Autowired
    UserApi userApi;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    BizCommon bizCommon;

    /**
     * 同时在线最大值预警统计
     *
     * @return
     */
    public Result<Integer> findOnlineMaxNum() {
        //找出id所对应的条目
        BizAppSuperviseExample example = new BizAppSuperviseExample();
        example.createCriteria().
                andRunStatusEqualTo(true).
                andScheduledTimeLessThanOrEqualTo(new Date());
        List<BizAppSupervise> bizAppsPO = appSuperviseService.find(example);

        //替换对应的其他模块id
        List<BizAppSuperviseScheduledDTO> bizApps = TransUtil.transAppName(dozerUtils
                        .mapList(bizAppsPO, BizAppSuperviseScheduledDTO.class),
                applicationApi.findAllList().getData(), userApi.findAllList().getData());

        //初始化一个整形来记录执行值
        int[] doNum = new int[]{0};
        List<BizAppSuperviseScheduledDTO> pos = new ArrayList<>();
        bizApps.forEach(obj -> {
            Date thisDate = obj.getScheduledTime();

            obj.setScheduledTime(getSuperviseTime(obj.getScheduledTime(),
                    SuperviseTypeEnum.getEnum(obj.getSuperviseType()), +1));
            //查询出当前appId的所有记录
            Date beginDate = getSuperviseTime(thisDate,
                    SuperviseTypeEnum.getEnum(obj.getSuperviseType()), -1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(beginDate);
            List<LoginLogMaxDTO> loginList = loginLogApi.findByAppIdAndLoginDate(obj.getAppId(), date).getData();
            if (loginList != null && loginList.size() != 0) {
                //统计时间交叉数
                loginList.forEach(login -> {
                    loginList.forEach(mlogin -> {
                        if (login.getId() != mlogin.getId() &&
                                isOverlap(login.getLoginTime(), login.getLogoutTime(),
                                        mlogin.getLoginTime(), mlogin.getLogoutTime())) {
                            login.setNum(login.getNum() + 1);
                        }
                    });
                });

                //获取最大交叉数
                int num = loginList.stream().mapToInt(LoginLogMaxDTO::getNum).max().getAsInt();
                if (obj.getOnlineLimit() <= num) {
                    //执行预警
                    doNum[0]++;
                    //消息预警发送
                    String msg = TransUtil.splicingWarnMsg(obj, null, WarnConstat.APP_LOGIN_REASON
                            + "(上限人数:" + obj.getOnlineLimit() + ",当前人数:" + num + "),");
                    //获取发送id集合
                    StringBuffer idsBuff = new StringBuffer();
                    idsBuff.append(StringUtils.isEmpty(obj.getDutyUser()) ? "" : obj.getDutyUser() + ",");
                    idsBuff.append(StringUtils.isEmpty(obj.getConfirmUser()) ? "" : obj.getConfirmUser() + ",");
                    idsBuff.append(StringUtils.isEmpty(obj.getCopyUser()) ? "" : obj.getCopyUser() + ",");
                    String ids = idsBuff.toString();
                    ids = StringUtils.isEmpty(ids) ? "" : ids.substring(0, ids.length() - 1);
                    String[] msgIds = ids.split(",");

                    //获取执行实体
                    BbsAllMainMsgDTO msgDTO = bizCommon
                            .builderBbsAllMainMsgDTO(obj, SuperviseBizTypeEnum.APP_RUNNING_RES_MSG, msg);
                    //执行发送方式
                    if (obj.getRemindType() == 1) {
                        //发送消息
                        bizCommon.addSendBbsMsg(msgDTO, msgIds, null);
                    } else if (obj.getRemindType() == 2) {
                        //发送短信
                        Map<String, String> hashMap = new LinkedHashMap<>();
                        hashMap.put("{正文}", SuperviseBizTypeEnum.APP_RUNNING_RES_MSG.getMsg() + "通知," + msg);
                        bizCommon.addSendPhoneUserList(obj.getDutyUser(), obj.getConfirmUser(), obj.getCopyUser(), hashMap);
                    } else if (obj.getRemindType() == 3){
                        //消息短信都发送
                        bizCommon.addSendBbsMsg(msgDTO, msgIds, null);

                        Map<String, String> hashMap = new LinkedHashMap<>();
                        hashMap.put("{正文}", SuperviseBizTypeEnum.APP_RUNNING_RES_MSG.getMsg() + "通知," + msg);
                        bizCommon.addSendPhoneUserList(obj.getDutyUser(), obj.getConfirmUser(), obj.getCopyUser(), hashMap);
                    }
                    log.info(obj.getAppId() + "发生了一条应用运行预警:");
                }
            }
            obj.setScheduledTime(getSuperviseTime(new Date(),
                    SuperviseTypeEnum.getEnum(obj.getSuperviseType()), +1));
            pos.add(obj);
        });

        //更新当前列表的所有时间到下一个节点
        appSuperviseService.updateByIdSelective(dozerUtils.mapList(pos, BizAppSupervise.class));
        return Result.success(doNum[0]);
    }

    /**
     * 分页查询应用运行监管配置
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询应用运行监管配置", notes = "分页查询应用运行监管配置")
    @ApiResponses({
            @ApiResponse(code = 32007, message = "管理应用集合为空"),
    })
    @RequestMapping(value = "pageAppSupervise", method = RequestMethod.POST)
    public Result<PageInfo<BizAppSupervisePageResDTO>> pageAppSupervise(@RequestBody OpenApiReq<BizAppSupervisePageLikeDTO> openApiReq) {
        //获取模糊查询数据
        BizAppSupervisePageLikeDTO dto = openApiReq.getData();

        //验证
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_APPIDS_NULL, dto.getAppIds());
        if (dto.getAppIds().size() == 0) {
            return Result.success(new PageInfo<>(new ArrayList<>()));
        }

        Short[] types = new Short[]{SuperviseTypeEnum.HOUR.getValue(), SuperviseTypeEnum.DAY.getValue()
                , SuperviseTypeEnum.WEEK.getValue(), SuperviseTypeEnum.MONTH.getValue()};
        if (!Arrays.asList(types).contains(dto.getSuperviseType())) {
            dto.setSuperviseType(null);
        }

        //设置查询条件
        BizAppSuperviseExample superviseExample = new BizAppSuperviseExample();
        superviseExample.createCriteria().andAppIdEqualTo(dto.getAppId())
                .andSuperviseTypeEqualTo(dto.getSuperviseType())
                .andRunStatusEqualTo(dto.getRunStatus())
                .andAppIdIn(dto.getAppIds());
        superviseExample.setOrderByClause(" create_time desc");

        //设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //查询
        List list = appSuperviseService.find(superviseExample);
        return Result.success(new PageInfo<>(TransUtil.
                transAppName(dozerUtils.mapPage(list, BizAppSupervisePageResDTO.class)
                        , applicationApi.findAllList().getData(), userApi.findAllList().getData())));
    }

    /**
     * 新增应用运行监管配置
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "新增应用运行监管配置", notes = "新增应用运行监管配置")
    @ApiResponses({
            @ApiResponse(code = 56035, message = "应用id不能为空"),
            @ApiResponse(code = 32000, message = "责任人为空"),
            @ApiResponse(code = 32001, message = "确认人为空"),
            @ApiResponse(code = 32002, message = "同时在线数为空"),
            @ApiResponse(code = 32003, message = "监管方式为空"),
            @ApiResponse(code = 32004, message = "提醒方式为空"),
            @ApiResponse(code = 32005, message = "运行状态为空"),
    })
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody BizAppSuperviseSaveDTO dto) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_APP_ID, dto.getAppId());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_CONFIRM_USER_NULL, dto.getConfirmUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_DUTY_USER_NULL, dto.getDutyUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_ONLINE_LIMIT_NULL, dto.getOnlineLimit());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_REMIND_TYPE_NULL, dto.getRemindType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_SUPERVISE_TYPE_NULL, dto.getSuperviseType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_RUN_STATUS_NULL, dto.getRunStatus());

        //转换为实体
        BizAppSupervise po = dozerUtils.map(dto, BizAppSupervise.class);

        //识别监管方式，设置
        po.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(po.getSuperviseType()), 0));
        po.setCreateUser(BaseContextHandler.getAdminId());
        po.setUpdateUser(BaseContextHandler.getAdminId());
        if (StringUtils.isEmpty(po.getCopyUser())) {
            po.setCopyUser(null);
        }
        appSuperviseService.save(po);
        findOnlineMaxNum();

        return Result.success(true);
    }

    /**
     * 配置详情查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "配置详情查询", notes = "配置详情查询")
    @ApiResponses({
            @ApiResponse(code = 32006, message = "配置id为空"),
    })
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    public Result<BizAppSuperviseDetailDTO> getDetail(@RequestParam(value = "id") Long id) {
        //验证
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, id);

        //获取该条记录
        BizAppSupervise bizAppSupervise = appSuperviseService.getById(id);

        return Result.success(TransUtil.transAppName(dozerUtils.map(bizAppSupervise, BizAppSuperviseDetailDTO.class)
                , applicationApi.findAllList().getData(), userApi.findAllList().getData()));
    }

    /**
     * 配置修改
     *
     * @param dto
     * @return
     */
    @ApiResponses({
            @ApiResponse(code = 32006, message = "配置id为空"),
            @ApiResponse(code = 56035, message = "应用id不能为空"),
            @ApiResponse(code = 32000, message = "责任人为空"),
            @ApiResponse(code = 32001, message = "确认人为空"),
            @ApiResponse(code = 32002, message = "同时在线数为空"),
            @ApiResponse(code = 32003, message = "监管方式为空"),
            @ApiResponse(code = 32004, message = "提醒方式为空"),
            @ApiResponse(code = 32005, message = "运行状态为空"),
    })
    @ApiOperation(value = "配置修改", notes = "配置修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody BizAppSuperviseUpdateDTO dto) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_APP_ID, dto.getAppId());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_CONFIRM_USER_NULL, dto.getConfirmUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_DUTY_USER_NULL, dto.getDutyUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_ONLINE_LIMIT_NULL, dto.getOnlineLimit());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_REMIND_TYPE_NULL, dto.getRemindType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_SUPERVISE_TYPE_NULL, dto.getSuperviseType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_RUN_STATUS_NULL, dto.getRunStatus());
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, dto.getId());

        //转换dto并获取该id实际代表的原监控方式
        BizAppSupervise po = dozerUtils.map(dto, BizAppSupervise.class);
        BizAppSupervise appSupervise = appSuperviseService.getById(dto.getId());

        //对po做修改
        int tag = 0;
        po.setUpdateUser(BaseContextHandler.getAdminId());
        if (appSupervise.getSuperviseType() != po.getSuperviseType()) {
            po.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(po.getSuperviseType()), 0));
            if (appSuperviseService.updateByIdSelective(po) > 0) {
                findOnlineMaxNum();
                return Result.success(true);
            }
        } else {
            if (appSuperviseService.updateByIdSelective(po) > 0) {
                return Result.success(true);
            }
        }

        return Result.fail("fail");
    }

    /**
     * 配置删除
     *
     * @param id
     * @return
     */
    @ApiResponses({
            @ApiResponse(code = 32006, message = "配置id为空"),
    })
    @ApiOperation(value = "配置删除", notes = "配置删除")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //验证
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, id);

        //执行删除
        if (appSuperviseService.deleteById(id) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 判断两个时间是否有交集
     *
     * @param leftStartDate
     * @param leftEndDate
     * @param rightStartDate
     * @param rightEndDate
     * @return
     */
    private boolean isOverlap(Date leftStartDate, Date leftEndDate, Date rightStartDate, Date rightEndDate) {
        //当登出时间节点为空时会做出不同处理
        if (leftEndDate == null && rightEndDate != null) {
            if (leftStartDate.getTime() > rightEndDate.getTime()) {
                return false;
            }
            return true;
        } else if (leftEndDate != null && rightEndDate == null) {
            if (leftEndDate.getTime() < rightStartDate.getTime()) {
                return false;
            }
            return true;
        } else if (leftEndDate == null && rightEndDate == null) {
            return true;
        }
        return !((leftStartDate.getTime() > rightEndDate.getTime())
                || (leftEndDate.getTime() < rightStartDate.getTime()));
    }
}
