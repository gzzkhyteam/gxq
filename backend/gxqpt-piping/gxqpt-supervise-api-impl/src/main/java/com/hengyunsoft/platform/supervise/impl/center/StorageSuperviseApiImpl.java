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
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageHistoryPageLikeDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageHistoryPageResDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSupervisePageDetailDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSupervisePageLikeDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSupervisePageResDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSuperviseSaveDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSuperviseScheduledDTO;
import com.hengyunsoft.platform.supervise.dto.center.storage.DataStorageSuperviseUpdateDTO;
import com.hengyunsoft.platform.supervise.entity.po.DataStorageHistory;
import com.hengyunsoft.platform.supervise.entity.po.DataStorageSupervise;
import com.hengyunsoft.platform.supervise.impl.constant.ScriptEnum;
import com.hengyunsoft.platform.supervise.impl.constant.SuperviseTypeEnum;
import com.hengyunsoft.platform.supervise.impl.constant.WarnConstat;
import com.hengyunsoft.platform.supervise.impl.manager.BizCommon;
import com.hengyunsoft.platform.supervise.repository.example.DataStorageHistoryExample;
import com.hengyunsoft.platform.supervise.repository.example.DataStorageSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.DataStorageHistoryService;
import com.hengyunsoft.platform.supervise.repository.service.DataStorageSuperviseService;
import com.hengyunsoft.platform.supervise.util.TransUtil;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.hengyunsoft.commons.exception.core.WarnExceptionCode.BIZ_APP_ID_NON_EXISTENT;
import static com.hengyunsoft.commons.exception.core.WarnExceptionCode.BIZ_APP_ID_NULL;
import static com.hengyunsoft.platform.supervise.util.TransUtil.getSuperviseTime;
import static com.hengyunsoft.platform.supervise.util.TransUtil.transAppName;

/**
 * 数据存储监管配置中心
 */
@Api(value = "StorageSuperviseApi", description = "数据存储监管配置中心")
@RestController
@Slf4j
@RequestMapping("storagesupervise")
public class StorageSuperviseApiImpl {
    @Autowired
    DataStorageSuperviseService storageSuperviseService;
    @Autowired
    DataStorageHistoryService storageHistoryService;
    @Autowired
    ApplicationApi applicationApi;
    @Autowired
    UserApi userApi;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    BizCommon bizCommon;


    @Value("${gxqpt.hostname.gate}")
    private String hostname;
    @Value("${gxqpt.port.gate}")
    private String port;

    /**
     * 存储空间阀值统计
     *
     * @return
     */
    public Result<Integer> findSpaceNum() {
        //找出所有的条目
        DataStorageSuperviseExample dataStorageSuperviseExample = new DataStorageSuperviseExample();
        dataStorageSuperviseExample.createCriteria().
                andRunStatusEqualTo(true).
                andScheduledTimeLessThanOrEqualTo(new Date());
        List<DataStorageSupervise> dataStorageSupervises = storageSuperviseService.find(dataStorageSuperviseExample);
        if (dataStorageSupervises.size() == 0) {
            return Result.success(0);
        }

        //替换对应的其他模块id
        List<DataStorageSuperviseScheduledDTO> list = transAppName(dozerUtils
                        .mapPage(dataStorageSupervises, DataStorageSuperviseScheduledDTO.class),
                applicationApi.findAllList().getData(), userApi.findAllList().getData());
        int num = 0;
        Date date = new Date();
        List<DataStorageSuperviseScheduledDTO> pos = new ArrayList<>();
        List<DataStorageHistory> histories = new ArrayList<>();
        list.forEach(obj -> {
            StringBuffer buffer = new StringBuffer();
            if (obj.getDbSpaceNum() != null
                    && obj.getDbSpaceLimit()!=null
                    && (obj.getDbSpaceNum() >= obj.getDbSpaceLimit())) {
                //数据库阀值操作
                buffer.append(WarnConstat.STRING_DB_SIZE);
            }
            if (obj.getFileSpaceNum() != null
                    && obj.getFileSpaceLimit()!=null
                    && (obj.getFileSpaceNum() >= obj.getFileSpaceLimit())){
                //文件阀值操作
                buffer.append(WarnConstat.STRING_FILE_SIZE);
            }
            if (obj.getLogSpaceNum() != null
                    && obj.getLogSpaceLimit() != null
                    && (obj.getLogSpaceNum() >= obj.getLogSpaceLimit())) {
                //日志阀值操作
                buffer.append(WarnConstat.STRING_LOG_SIZE);
            }

            // 筛入历史记录
            DataStorageHistory dataStorageHistory = new DataStorageHistory();
            dataStorageHistory.setLogSpaceNum(obj.getLogSpaceNum());
            dataStorageHistory.setFileSpaceNum(obj.getFileSpaceNum());
            dataStorageHistory.setDbSpaceNum(obj.getDbSpaceNum());
            dataStorageHistory.setStorageId(obj.getId());
            dataStorageHistory.setCreateTime(date);
            dataStorageHistory.setUpdateTime(date);
            histories.add(dataStorageHistory);

            if (!StringUtils.isEmpty(buffer.toString())) {
                //消息预警发送
                String msg = TransUtil.splicingWarnMsg(obj, buffer.toString(), WarnConstat.STORAGE_SIZE_REASON);
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
                        .builderBbsAllMainMsgDTO(obj, SuperviseBizTypeEnum.DATA_STORAGE_RES_MSG, msg);
                //执行发送方式
                if (obj.getRemindType() == 1) {
                    //发送消息
                    bizCommon.addSendBbsMsg(msgDTO, msgIds, null);
                } else if (obj.getRemindType() == 2){
                    //发送短信
                    Map<String, String> hashMap = new LinkedHashMap<>();
                    hashMap.put("{正文}", SuperviseBizTypeEnum.DATA_STORAGE_RES_MSG.getMsg() + "通知," + msg);
                    bizCommon.addSendPhoneUserList(obj.getDutyUser(), obj.getConfirmUser(), obj.getCopyUser(), hashMap);
                } else if (obj.getRemindType() == 3){
                    //消息短信都发送
                    bizCommon.addSendBbsMsg(msgDTO, msgIds, null);

                    Map<String, String> hashMap = new LinkedHashMap<>();
                    hashMap.put("{正文}", SuperviseBizTypeEnum.DATA_STORAGE_RES_MSG.getMsg() + "通知," + msg);
                    bizCommon.addSendPhoneUserList(obj.getDutyUser(), obj.getConfirmUser(), obj.getCopyUser(), hashMap);
                }
                log.info(obj.getId() + "发生了一条数据存储预警:");
            }
            obj.setScheduledTime(getSuperviseTime(new Date(),
                    SuperviseTypeEnum.getEnum(obj.getSuperviseType()), +1));
            pos.add(obj);
        });

        //保存实体
        num = storageSuperviseService.updateByIdSelective(dozerUtils.mapList(pos, DataStorageSupervise.class));
        if (!histories.isEmpty()){
            storageHistoryService.save(histories);
        }

        return Result.success(num);
    }

    /**
     * 数据存储配置新增
     *
     * @param dto
     * @return
     */
    @ApiResponses({
            @ApiResponse(code = 56035, message = "应用id不能为空"),
            @ApiResponse(code = 32000, message = "责任人为空"),
            @ApiResponse(code = 32001, message = "确认人为空"),
            @ApiResponse(code = 32002, message = "同时在线数为空"),
            @ApiResponse(code = 32003, message = "监管方式为空"),
            @ApiResponse(code = 32004, message = "提醒方式为空"),
            @ApiResponse(code = 32005, message = "运行状态为空"),
    })
    @ApiOperation(value = "数据存储配置新增", notes = "数据存储配置新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody DataStorageSuperviseSaveDTO dto) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_APP_ID, dto.getAppId());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_CONFIRM_USER_NULL, dto.getConfirmUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_DUTY_USER_NULL, dto.getDutyUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_REMIND_TYPE_NULL, dto.getRemindType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_SUPERVISE_TYPE_NULL, dto.getSuperviseType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_RUN_STATUS_NULL, dto.getRunStatus());

        //为PO设置一些初始信息
        DataStorageSupervise po = dozerUtils.map(dto, DataStorageSupervise.class);
        po.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(po.getSuperviseType()), 0));
        po.setUpdateUser(BaseContextHandler.getAdminId());
        po.setCreateUser(BaseContextHandler.getAdminId());
        po.setDbSpaceNum(-1d);
        po.setFileSpaceNum(-1d);
        po.setLogSpaceNum(-1d);
        if (StringUtils.isEmpty(po.getCopyUser())) {
            po.setCopyUser(null);
        }
        //持久化
        storageSuperviseService.save(po);

        return Result.success(true);
    }

    /**
     * 数据存储配置脚本修改
     *
     * @param dbSpaceNum
     * @param logSpaceNum
     * @param fileSpaceNum
     * @param id
     * @return
     */
    @IgnoreToken
    @ApiResponses({
            @ApiResponse(code = 32006, message = "配置id为空"),
    })
    @ApiOperation(value = "数据存储配置脚本修改", notes = "数据存储配置脚本修改")
    @RequestMapping(value = "/updateScript", method = RequestMethod.GET)
    public Result<Boolean> updateScript(@RequestParam(value = "dbSpaceNum") Double dbSpaceNum,
                                        @RequestParam(value = "logSpaceNum") Double logSpaceNum,
                                        @RequestParam(value = "fileSpaceNum") Double fileSpaceNum,
                                        @RequestParam(value = "id") Long id) {
        //验证
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_ID_NULL, id);

        //转换实体
        DataStorageSupervise po = new DataStorageSupervise();
        po.setId(id);
        po.setLogSpaceNum(logSpaceNum);
        po.setFileSpaceNum(fileSpaceNum);
        po.setDbSpaceNum(dbSpaceNum);

        //持久化
        if (storageSuperviseService.updateByIdSelective(po) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 数据存储配置分页查询
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "数据存储配置分页查询", notes = "数据存储配置分页查询")
    @ApiResponses({
            @ApiResponse(code = 32007, message = "管理应用集合为空"),
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<DataStorageSupervisePageResDTO>> page(
            @RequestBody OpenApiReq<DataStorageSupervisePageLikeDTO> openApiReq) {
        //获取模糊查询数据
        DataStorageSupervisePageLikeDTO dto = openApiReq.getData();

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
        DataStorageSuperviseExample dataStorageSuperviseExample = new DataStorageSuperviseExample();
        dataStorageSuperviseExample.createCriteria().andAppIdEqualTo(dto.getAppId())
                .andSuperviseTypeEqualTo(dto.getSuperviseType())
                .andRunStatusEqualTo(dto.getRunStatus())
                .andAppIdIn(dto.getAppIds());
        dataStorageSuperviseExample.setOrderByClause(" create_time desc");

        //设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //查询
        List list = storageSuperviseService.find(dataStorageSuperviseExample);

        //名词转换
        return Result.success(new PageInfo<>(TransUtil
                .transAppName(dozerUtils.mapPage(list, DataStorageSupervisePageResDTO.class)
                        , applicationApi.findAllList().getData(), userApi.findAllList().getData())));
    }

    /**
     * 数据存储历史分页查询
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "数据存储历史分页查询", notes = "数据存储历史分页查询")
    @ApiResponses({
            @ApiResponse(code = 32008, message = "配置id不存在"),
    })
    @RequestMapping(value = "/pageHistory", method = RequestMethod.POST)
    public Result<PageInfo<DataStorageHistoryPageResDTO>> pageHistory(
            @RequestBody OpenApiReq<DataStorageHistoryPageLikeDTO> openApiReq) {
        //获取模糊查询数据
        DataStorageHistoryPageLikeDTO dto = openApiReq.getData();

        //验证
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_ID_NON_EXISTENT, dto.getStorageId());

        DataStorageHistoryExample example = new DataStorageHistoryExample();
        DataStorageHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andStorageIdEqualTo(dto.getStorageId());
        example.setOrderByClause(" create_time desc ");
        if (dto.getStartTime() != null){
            criteria.andCreateTimeGreaterThanOrEqualTo(dto.getStartTime());
        }
        if (dto.getEndTime() != null){
            criteria.andCreateTimeLessThanOrEqualTo(dto.getEndTime());
        }

        //设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //查询
        List<DataStorageHistoryPageResDTO> list = dozerUtils.mapPage(storageHistoryService.find(example),DataStorageHistoryPageResDTO.class);
        String nullTag = "-1.0";
        list.forEach(obj -> {
            obj.setDbSpaceNum(nullTag.equals(obj.getDbSpaceNum()) ? "未配置" : obj.getDbSpaceNum());
            obj.setFileSpaceNum(nullTag.equals(obj.getFileSpaceNum()) ? "未配置" : obj.getFileSpaceNum());
            obj.setLogSpaceNum(nullTag.equals(obj.getLogSpaceNum()) ? "未配置" : obj.getLogSpaceNum());
        });

        //名词转换
        return Result.success(new PageInfo<>(list));
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
    public Result<DataStorageSupervisePageDetailDTO> getDetail(@RequestParam(value = "id") Long id) {
        //验证
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, id);

        //获取该条记录
        DataStorageSupervise dataStorageSupervise = storageSuperviseService.getById(id);

        return Result.success(TransUtil
                .transAppName(dozerUtils.map(dataStorageSupervise, DataStorageSupervisePageDetailDTO.class)
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
    public Result<Boolean> update(@RequestBody DataStorageSuperviseUpdateDTO dto) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_APP_ID, dto.getAppId());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_CONFIRM_USER_NULL, dto.getConfirmUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_DUTY_USER_NULL, dto.getDutyUser());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_REMIND_TYPE_NULL, dto.getRemindType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_SUPERVISE_TYPE_NULL, dto.getSuperviseType());
        BizAssert.assertNotNull(WarnExceptionCode.BIZ_APP_RUN_STATUS_NULL, dto.getRunStatus());
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, dto.getId());

        //转换dto并获取该id实际代表的原监控方式
        DataStorageSupervise po = dozerUtils.map(dto, DataStorageSupervise.class);
        DataStorageSupervise appSupervise = storageSuperviseService.getById(dto.getId());

        //对po做修改
        po.setUpdateUser(BaseContextHandler.getAdminId());
        if (appSupervise.getSuperviseType() != po.getSuperviseType()) {
            po.setScheduledTime(getSuperviseTime(new Date(), SuperviseTypeEnum.getEnum(po.getSuperviseType()), 0));
            if (storageSuperviseService.updateByIdSelective(po) > 0) {
//                findSpaceNum();
                return Result.success(true);
            }
        } else {
            if (storageSuperviseService.updateByIdSelective(po) > 0) {
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
        if (storageSuperviseService.deleteById(id) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 脚本模板下载
     *
     * @param id
     * @param response
     * @throws IOException
     */

    @ApiResponses({
            @ApiResponse(code = 32006, message = "配置id为空"),
    })
    @ApiOperation(value = "脚本模板下载", notes = "脚本模板下载")
    @RequestMapping(value = "/downloadScript", method = RequestMethod.GET)
    public void downloadScript(@RequestParam(value = "id") Long id, HttpServletResponse response) throws IOException {
        //验证
        BizAssert.assertNotNull(BIZ_APP_ID_NULL, id);

        //设置替换信息
        Map<String, String> mapstring = new HashMap<>();
        mapstring.put(ScriptEnum.ID.getMsg(), id.toString());
        mapstring.put(ScriptEnum.IP.getMsg(), hostname + ":" + port);

        //查询该id对应的配置
        DataStorageSupervise dataStorageSupervise = storageSuperviseService.getById(id);
        if (dataStorageSupervise == null || dataStorageSupervise.getId() == null) {
            BizAssert.fail(BIZ_APP_ID_NON_EXISTENT.getCode(), BIZ_APP_ID_NON_EXISTENT.getMsg());
        }

        //配置三个存储路径
        mapstring.put(ScriptEnum.DBURL.getMsg(), dataStorageSupervise.getDbSpaceUrl());
        mapstring.put(ScriptEnum.FILEURL.getMsg(), dataStorageSupervise.getFileSpaceUrl());
        mapstring.put(ScriptEnum.LOGURL.getMsg(), dataStorageSupervise.getLogSpaceUrl());

        //设置返回头
        response.setContentType("text/plain");
        String fileName = "demoscript";
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".sh");
        BufferedReader reader = null;
        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();
        String enter = "\n";
        ServletOutputStream outSTr = null;
        outSTr = response.getOutputStream();
        buff = new BufferedOutputStream(outSTr);
        //读取内容并写入返回内容
        try {
            ClassPathResource resource = new ClassPathResource("/script/DataStorageScript.sh");
            InputStream inputStream = resource.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            if (inputStream != null) {
                String temp = null;
                while ((temp = reader.readLine()) != null) {
                    for (Map.Entry<String, String> entry : mapstring.entrySet()) {
                        if (temp.indexOf("{" + entry.getKey() + "}") != -1) {
                            temp = temp.replace("{" + entry.getKey() + "}", entry.getValue());
                        }
                    }
                    write.append(temp);
                    write.append(enter);
                }
                buff.write(write.toString().getBytes("UTF-8"));
                buff.flush();
                buff.close();
            }
        } finally {
            outSTr.close();
        }
    }
}
