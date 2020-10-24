package com.hengyunsoft.platform.warn.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.WarnExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.warn.api.warn.dto.*;
import com.hengyunsoft.platform.warn.constant.GetUserInfo;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.repository.dao.GxqptDutyMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendeeMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnMapper;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.utils.DNameUtils;
import com.hengyunsoft.platform.warn.utils.TreesUtils;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zjr
 * @date 2018/03/27
 */
@Api(value = "API - GxqptWarnApiImpl", description = "预警台账")
@RestController
@RequestMapping("warn")
@Slf4j
@WarnSendModule
public class GxqptWarnApiImpl {

    @Autowired
    private GxqptWarnService gxqptWarnService;
    @Autowired
    private GxqptSendeeService gxqptSendeeService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private TreesUtils treesUtils;
    @Autowired
    private DNameUtils dNameUtils;
    @Autowired
    private GxqptWarnMapper gxqptWarnMapper;
    @Autowired
    private GxqptSendeeMapper gxqptSendeeMapper;
    @Autowired
    private GxqptDutyMapper gxqptDutyMapper;
    @Autowired
    private RoleApi roleApi;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    //系统管理员编码
    private final String code = "admin_YJ";
    /**
     * 根据id获取预警信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取预警信息", notes = "根据id获取预警信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<Map<String, Object>> getById(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, id);
        //2.查询
        Map<String, Object> map = new HashMap<String, Object>();
        GxqptWarn warn = gxqptWarnMapper.selectByPrimaryKey(id);
        if (warn != null) {
            map.put("warn", warn);
        } else {
            return Result.fail("详情不存在");
        }
        List<Map<String, Object>> sendeelist = gxqptSendeeMapper.getSenList(id);
        List<Map<String, Object>> dutylist = gxqptDutyMapper.getDutyList(id);
        map.put("list", sendeelist);
        map.put("list1", dutylist);
        return Result.success(map);

    }

    /**
     * 根据id获取确认人信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取确认人信息", notes = "根据id获取确认人信息")
    @RequestMapping(value = "/getConById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<List<GxqptSendeeDTO>> getConById(@RequestParam(value = "id") Long id){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, id);
        //2.查询
        List<GxqptSendeeDO> conlist = gxqptSendeeMapper.getConList(id,GxqptSendee.RECTYPE1);
        //3.转换
        List<GxqptSendeeDTO> list = dozerUtils.mapList(conlist,GxqptSendeeDTO.class);
        return Result.success(list);
    }

    /**
     * 根据id获取责任人信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取责任人信息", notes = "根据id获取责任人信息")
    @RequestMapping(value = "/getHanById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<List<GxqptSendeeDTO>> getHanById(@RequestParam(value = "id") Long id){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, id);
        //2.查询
        List<GxqptSendeeDO> hanlist = gxqptSendeeMapper.getConList(id,GxqptSendee.RECTYPE3);
        //3.转换
        List<GxqptSendeeDTO> list = dozerUtils.mapList(hanlist,GxqptSendeeDTO.class);
        return Result.success(list);
    }

    /**
     * 获取预警台账分页列表
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "获取预警台账分页列表", notes = "获取预警台账分页列表")
    @RequestMapping(value = "/findWarnList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptWarnPagingDTO>> findWarnList(@RequestBody OpenApiReq<QueryWarnDTO> openApiReq) {
        QueryWarnDTO queryWarnDTO = openApiReq.getData();
        Long adminId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        //获取系统用户的管理员 2019/03/12 madengbo
       /* Result<List<Long>> users = roleApi.findUsersByAppIdAndCode(appId, code);
        if(users.getErrcode() == 0 && users.getData().size() > 0){
            if(users.getData().contains(adminId)){
                queryWarnDTO.setIsAdmin(true);
            }
        }else{
            queryWarnDTO.setIsAdmin(false);
        }*/

        QueryWarnDO queryWarnDO = dozerUtils.map(queryWarnDTO, QueryWarnDO.class);
        //level  status 为空 或是 为-1 查询全部数据
        if(String.valueOf(queryWarnDO.getLevel()).isEmpty() || queryWarnDO.getLevel().equals(-1)){
            queryWarnDO.setLevel(null);
        }
        if(queryWarnDO.getStatus().isEmpty() || queryWarnDO.getStatus().equalsIgnoreCase("-1")){
            queryWarnDO.setStatus(null);
        }
        //查询预警类型子类
        List<Long> TypeList = treesUtils.getAllTypeIdList(queryWarnDTO.getTypeId());
        queryWarnDO.setTypeList(TypeList);
        //设置查询条件
        queryWarnDO.setUserId(BaseContextHandler.getAdminId());
        //查询
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<GxqptWarnPagingDO> warnList = gxqptWarnService.findList(queryWarnDO);

        //为列表信息添加责任人
        if (warnList.size()!=0){
            //查询列表中的预警id
            Set<Long> wID = new HashSet<Long>();
            for (GxqptWarnPagingDO gwp : warnList){
                Long wid = gwp.getWarnId();
                wID.add(wid);
            }
            //查询责任人，并添加到列表中
            Map<String, Object> dName = dNameUtils.getDutyName(wID,GxqptSendee.RECTYPE3);
            for(int i = 0; i<warnList.size();i++){
                String ids = String.valueOf(warnList.get(i).getWarnId());
                warnList.get(i).setDName((String)dName.get(ids));
            }
        }
        //转换
        List<GxqptWarnPagingDTO> paging = dozerUtils.mapPage(warnList, GxqptWarnPagingDTO.class);
        return Result.success(new PageInfo<>(paging));
    }


    /**
     * 根据预警id查询预警责任人人
     *
     * @return
     */
    @ApiOperation(value = "根据预警id查询预警责任人人", notes = "根据预警id查询预警责任人人")
    @RequestMapping(value = "/getDutyer", method = RequestMethod.GET)
    public Result<DutyerDTO> getDutyer(@RequestParam(value = "warnId") Long warnId) {
        //1.查询
        DutyerDO dutyer = gxqptSendeeMapper.getDutyer(warnId,GxqptSendee.RECTYPE3);
        //2.转换
        DutyerDTO duty = dozerUtils.map(dutyer,DutyerDTO.class);
        return Result.success(duty);
    }

    /**
     * 根据ID确认预警信息
     *
     * @param confirmGxqptWarnDTO
     * @return
     */
    @ApiOperation(value = "根据ID确认预警信息", notes = "根据ID确认预警信息")
    @RequestMapping(value = "/updateModeById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = GxqptWarn.class)
            }
    )
    public Result<Boolean> updateModeById(@RequestBody ConfirmGxqptWarnDTO confirmGxqptWarnDTO) {
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, confirmGxqptWarnDTO.getId());
        //2.转换
        GxqptWarn gxqptWarn = dozerUtils.map(confirmGxqptWarnDTO, GxqptWarn.class);
        //3.查询预警责任人的信息
        GxqptSendee duList = gxqptSendeeMapper.getDuList(gxqptWarn.getId(),GxqptSendee.RECTYPE3);
        //查询抄送人信息
        List<GxqptSendee> csr = gxqptSendeeService.getCsr(confirmGxqptWarnDTO.getWarnId(),GxqptSendee.RECTYPE2);
        //4.查询预警确认人最高级别
        Integer leve = gxqptSendeeMapper.getLeveList(gxqptWarn.getId(),GxqptSendee.RECTYPE1);
        //5.查询接收人信息
        GxqptSendee gxqptSendee = gxqptSendeeMapper.getByUserId(BaseContextHandler.getAdminId(),gxqptWarn.getId(),GxqptSendee.RECTYPE1);

        //6.最高级别确认人进行确认
        if (confirmGxqptWarnDTO.getHandlerLeve() == leve) {
            gxqptWarn.setUpdateUser(BaseContextHandler.getAdminId().toString());
            gxqptWarn.setLevel(confirmGxqptWarnDTO.getLevel());
            if (confirmGxqptWarnDTO.getResult()){
                gxqptWarn.setStatus(GxqptWarn.STATUS2);
            }else {
                gxqptWarn.setStatus(GxqptWarn.STATUS3);
            }
            Date nowDate = new Date();
            gxqptWarn.setHanTime(nowDate);
            gxqptWarn.setUpdateTime(nowDate);
            int result = gxqptWarnService.updateByIdSelective(gxqptWarn);
            if (result > 0) {
                if (confirmGxqptWarnDTO.getResult()==false&&confirmGxqptWarnDTO.getRemarks()==""){
                    return Result.fail("确认信息不能为空!");
                }else{
                    gxqptSendee.setStatus(GxqptSendee.STATUS2);
                    gxqptSendee.setWhoHandle(GxqptSendee.UNWHOHANDLE);
                    gxqptSendee.setResult(confirmGxqptWarnDTO.getResult());
                    gxqptSendee.setRemarks(confirmGxqptWarnDTO.getRemarks());
                    gxqptSendee.setUpdateUser(BaseContextHandler.getAdminId().toString());
                    gxqptSendee.setUpdateTime(nowDate);
                    gxqptSendeeService.updateByIdSelective(gxqptSendee);
//                    //消息更新
//                    updateBacklogReqDTO = builderUpdateBacklogReqDTO(gxqptSendee);
//                    msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
                }

                //设置确认时长
                ConfirmTimeDO confirmt1 = gxqptSendeeService.getConfirmt(gxqptWarn.getId(),GxqptSendee.RECTYPE1,leve);
                gxqptWarn.setConfirmCostTime(confirmt1.getConfirmTime());
                //如果确认不属实，设置处理时长为null
                if (confirmGxqptWarnDTO.getResult() == false){
                    gxqptWarn.setHandleCostTime(null);
                }
                gxqptWarnService.updateByIdSelective(gxqptWarn);
                //判断确认结果是否属实，如果属实给对应此预警信息的抄送人的预警状态设置为“已确认”，否则给对应此预警信息的抄送人的预警状态设置为“已处理”
                if (csr.size()!=0){
                    for (GxqptSendee csrl : csr){
                        csrl.setUpdateTime(nowDate);
                        csrl.setUpdateUser((BaseContextHandler.getAdminId().toString()));
                        if (confirmGxqptWarnDTO.getResult()){
                            csrl.setStatus(GxqptSendee.STATUS2);
                        }else {
                            csrl.setStatus(GxqptSendee.STATUS3);
                        }
                        gxqptSendeeService.updateByIdSelective(csrl);
                    }
                }

                //6.1.指定责任人
                if (confirmGxqptWarnDTO.getResult()){
                    if (duList==null){
                        duList = new GxqptSendee();
                        if (confirmGxqptWarnDTO.getUserId()!=null){
                            duList.setWarnId(confirmGxqptWarnDTO.getWarnId());
                            duList.setUserId(confirmGxqptWarnDTO.getUserId());
                            duList.setRecName(confirmGxqptWarnDTO.getRecName());
                            duList.setRecType(GxqptSendee.RECTYPE3);
                            duList.setRecTime(nowDate);
                            duList.setStatus(GxqptSendee.STATUS2);
                            duList.setWhoHandle(GxqptSendee.WHOHANDLE);
                            duList.setUpdateTime(nowDate);
                            duList.setCreateTime(nowDate);
                            duList.setUpdateUser(BaseContextHandler.getAdminId().toString());
                            duList.setCreateUser(BaseContextHandler.getAdminId().toString());
                            //2019-4-25 增加 预警人员的 部门信息
                            GxqptSendee sendee = sendeeSingleDeal(duList);
                            gxqptSendeeService.save(sendee);
//                            //消息通知
//                            List<Long> handlerUserIds1 = new ArrayList<>();
//                            BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
//                            handlerUserIds1.add(duList.getUserId());
//                            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(gxqptSendee,gxqptWarn.getId(),gxqptWarn.getContent(),gxqptWarn.getTitle());
//                            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,null,handlerUserIds1);
                        }else{
                            return Result.fail("责任人不能为空！");
                        }
                    }else if(!duList.getUserId().equals(confirmGxqptWarnDTO.getUserId())){
                        //修改预警责任人
                        duList.setUserId(confirmGxqptWarnDTO.getUserId());
                        duList.setRecName(confirmGxqptWarnDTO.getRecName());
                        duList.setStatus(GxqptSendee.STATUS2);
                        duList.setRecTime(nowDate);
                        duList.setWhoHandle(GxqptSendee.WHOHANDLE);
                        duList.setUpdateTime(nowDate);
                        duList.setUpdateUser(BaseContextHandler.getAdminId().toString());
                        GxqptSendee sendee = sendeeSingleDeal(duList);
                        gxqptSendeeService.updateByIdSelective(sendee);
//                        //消息通知
//                        List<Long> handlerUserIds2 = new ArrayList<>();
//                        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
//                        handlerUserIds2.add(duList.getUserId());
//                        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(gxqptSendee,gxqptWarn.getId(),gxqptWarn.getContent(),gxqptWarn.getTitle());
//                        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,null,handlerUserIds2);
                    }else{
                        duList.setStatus(GxqptSendee.STATUS2);
                        duList.setWhoHandle(GxqptSendee.WHOHANDLE);
                        duList.setUpdateTime(nowDate);
                        duList.setUpdateUser(BaseContextHandler.getAdminId().toString());
                        gxqptSendeeService.updateByIdSelective(duList);
                    }
                }
                return Result.success(true);
            } else {
                return Result.success(false);
            }
        }

        //7.不是最高级别确认人确认，且确认结果属实
        if (confirmGxqptWarnDTO.getResult()) {
            Date nowDate = new Date();
            gxqptWarn.setHanTime(nowDate);
            gxqptWarn.setUpdateUser(BaseContextHandler.getAdminId().toString());
            gxqptWarn.setUpdateTime(nowDate);
            gxqptWarn.setLevel(confirmGxqptWarnDTO.getLevel());
            int result = gxqptWarnService.updateByIdSelective(gxqptWarn);
            if(result>0){
                Long warnid = gxqptSendee.getWarnId();
                gxqptSendee.setWhoHandle(GxqptSendee.UNWHOHANDLE);
                gxqptSendee.setResult(true);
                gxqptSendee.setRemarks(confirmGxqptWarnDTO.getRemarks());
                gxqptSendee.setStatus(GxqptSendee.STATUS2);
                gxqptSendee.setUpdateUser(BaseContextHandler.getAdminId().toString());
                gxqptSendee.setUpdateTime(nowDate);
                gxqptSendeeService.updateByIdSelective(gxqptSendee);
                Integer leve1 = gxqptSendee.getHandlerLeve() + 1;
                gxqptSendeeService.updateByWarnId(warnid, leve1);
//                //消息更新
//                updateBacklogReqDTO = builderUpdateBacklogReqDTO(gxqptSendee);
//                msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
                //7.1.指定责任人
                if (duList==null){
                    duList = new GxqptSendee();
                    if (confirmGxqptWarnDTO.getUserId() != null){
                        duList.setWarnId(confirmGxqptWarnDTO.getWarnId());
                        duList.setUserId(confirmGxqptWarnDTO.getUserId());
                        duList.setRecName(confirmGxqptWarnDTO.getRecName());
                        duList.setRecType(GxqptSendee.RECTYPE3);
                        duList.setRecTime(nowDate);
                        duList.setStatus(GxqptSendee.STATUS1);
                        duList.setWhoHandle(GxqptSendee.UNWHOHANDLE);
                        duList.setCreateTime(nowDate);
                        duList.setCreateUser(BaseContextHandler.getAdminId().toString());

                        GxqptSendee sendee = sendeeSingleDeal(duList);
                        gxqptSendeeService.save(sendee);
//                        //消息通知
//                        List<Long> handlerUserIds3 = new ArrayList<>();
//                        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
//                        handlerUserIds3.add(duList.getUserId());
//                        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(gxqptSendee,gxqptWarn.getId(),gxqptWarn.getContent(),gxqptWarn.getTitle());
//                        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,null,handlerUserIds3);
                    }
                }else if (!duList.getUserId().equals(confirmGxqptWarnDTO.getUserId()) ){
                    //修改责任人信息
                    duList.setUserId(confirmGxqptWarnDTO.getUserId());
                    duList.setRecName(confirmGxqptWarnDTO.getRecName());
                    duList.setRecTime(nowDate);
                    duList.setStatus(GxqptSendee.STATUS1);
                    duList.setWhoHandle(GxqptSendee.UNWHOHANDLE);
                    duList.setUpdateTime(nowDate);
                    duList.setUpdateUser(BaseContextHandler.getAdminId().toString());
                    GxqptSendee sendee = sendeeSingleDeal(duList);
                    gxqptSendeeService.updateByIdSelective(sendee);
//                    //消息通知
//                    List<Long> handlerUserIds4 = new ArrayList<>();
//                    BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
//                    handlerUserIds4.add(duList.getUserId());
//                    bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(gxqptSendee,gxqptWarn.getId(),gxqptWarn.getContent(),gxqptWarn.getTitle());
//                    msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,null,handlerUserIds4);
                }
            }
        } else{//8.不是最高级别确认人确认，且确认结果不属实
            gxqptWarn.setStatus(GxqptWarn.STATUS3);
            gxqptWarn.setLevel(confirmGxqptWarnDTO.getLevel());
            gxqptWarn.setUpdateUser(BaseContextHandler.getAdminId().toString());
            Date nowDate = new Date();
            gxqptWarn.setHanTime(nowDate);
            gxqptWarn.setUpdateTime(nowDate);
            int result = gxqptWarnService.updateByIdSelective(gxqptWarn);
            if (result > 0) {
                if (confirmGxqptWarnDTO.getRemarks()!=""){
                    gxqptSendee.setStatus(GxqptSendee.STATUS2);
                    gxqptSendee.setWhoHandle(GxqptSendee.UNWHOHANDLE);
                    Long warnid = gxqptSendee.getWarnId();
                    gxqptSendeeService.updateByWarnIdAndLeve(warnid, gxqptSendee.getHandlerLeve());
                    gxqptSendee.setResult(false);
                    gxqptSendee.setRemarks(confirmGxqptWarnDTO.getRemarks());
                    gxqptSendee.setUpdateUser(BaseContextHandler.getAdminId().toString());
                    gxqptSendee.setUpdateTime(nowDate);
                    gxqptSendeeService.updateByIdSelective(gxqptSendee);
//                    //消息更新
                    if (csr!=null){
                        gxqptSendeeMapper.updateStatusByWarnId(confirmGxqptWarnDTO.getWarnId(),GxqptSendee.RECTYPE2);
                    }
                    //设置确认时长和处理时长
                    ConfirmTimeDO confirmt2 = gxqptSendeeService.getConfirmtNo(gxqptWarn.getId(),GxqptSendee.RECTYPE1);
                    gxqptWarn.setConfirmCostTime(confirmt2.getConfirmTime());
                    gxqptWarn.setHandleCostTime(null);
                    gxqptWarnService.updateByIdSelective(gxqptWarn);
                }else {
                    return Result.fail("确认信息不能为空!");
                }
            } else {
                return Result.fail("确认操作失败");
            }
        }
        return Result.success(true);
    }

//    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(GxqptSendee gxqptSendee,Long id,String content,String title) {
//
//        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
//
//        bbsAllMainMsgDTO.setAppId("35kj6310");
//        bbsAllMainMsgDTO.setAppName("预警管理系统");
//        bbsAllMainMsgDTO.setBizId(id.toString());
//        bbsAllMainMsgDTO.setBizType("send_warn");
//        bbsAllMainMsgDTO.setBriefTpye("send_warn");
//        bbsAllMainMsgDTO.setClientFlag("gxqpt");
//        bbsAllMainMsgDTO.setContent("您有一条新的预警信息："+content+".");
//        bbsAllMainMsgDTO.setSingleHandleIs(false);
//        bbsAllMainMsgDTO.setTitle("预警信息："+title);
//        bbsAllMainMsgDTO.setDetailedType("WARN_SEND");
//        bbsAllMainMsgDTO.setDetailedTypeDesc("发送预警");
//        bbsAllMainMsgDTO.setHandlerNeedIs(false);
//        bbsAllMainMsgDTO.setHandlerUrl("/#/ledgerList");
//        bbsAllMainMsgDTO.setSenderName("系统自动通知");
//        return bbsAllMainMsgDTO;
//    }

//    private UpdateBacklogReqDTO builderUpdateBacklogReqDTO(GxqptSendee gxqptSendee){
//        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
//        updateBacklogReqDTO.setReceiveId(gxqptSendee.getUserId());
//        updatebacklogreqdto.setappid("35kj6310");
//        updateBacklogReqDTO.setBizId("congfirm_warn");
//        updateBacklogReqDTO.setClientFlag("gxqpt");
//        updateBacklogReqDTO.setBizType("congfirm_warn");
//        return updateBacklogReqDTO;
//    }

    /**
     * 根据ID处理预警信息
     * @param handleGxqptWarnDto
     * @return
     */
    @ApiOperation(value = "根据ID处理预警信息", notes = "根据ID处理预警信息")
    @RequestMapping(value = "/updateHandleById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = GxqptWarn.class)
            }
    )
    public Result<Boolean> updateHandleById(@RequestBody HandleGxqptWarnDTO handleGxqptWarnDto){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, handleGxqptWarnDto.getId());
        //2.转换
        GxqptWarn gxqptWarn = dozerUtils.map(handleGxqptWarnDto, GxqptWarn.class);
        //3.处理
//        GxqptSendee gxqptSendee = gxqptSendeeMapper.getByUserId(1329795700641l,gxqptWarn.getId(),GxqptSendee.RECTYPE3);
        GxqptSendee gxqptSendee = gxqptSendeeMapper.getByUserId(BaseContextHandler.getAdminId(),gxqptWarn.getId(),GxqptSendee.RECTYPE3);

        UpdateBacklogReqDTO updateBacklogReqDTO = null;
        //查询抄送人信息
        List<GxqptSendee> csr = gxqptSendeeService.getCsr(handleGxqptWarnDto.getWarnId(),GxqptSendee.RECTYPE2);
        gxqptWarn.setUpdateUser(BaseContextHandler.getAdminId().toString());
//        gxqptWarn.setUpdateUser("1329795700641l");
        gxqptWarn.setStatus(GxqptWarn.STATUS4);
        gxqptWarn.setLevel(handleGxqptWarnDto.getLevel());
        Date nowDate = new Date();
        gxqptWarn.setHanTime(nowDate);
        gxqptWarn.setUpdateTime(nowDate);
        int result = gxqptWarnService.updateByIdSelective(gxqptWarn);
        if (result > 0) {
            gxqptSendee.setStatus(GxqptSendee.STATUS3);
            gxqptSendee.setWhoHandle(GxqptSendee.UNWHOHANDLE);
            gxqptSendee.setResult(handleGxqptWarnDto.getResult());
            gxqptSendee.setRemarks(handleGxqptWarnDto.getRemarks());
            gxqptSendee.setUpdateUser(BaseContextHandler.getAdminId().toString());
            gxqptSendee.setUpdateTime(nowDate);
            gxqptSendeeService.updateByIdSelective(gxqptSendee);
//            //消息更新
            //更改抄送人预警状态
            if (csr.size()!=0){
                for (GxqptSendee csrl : csr){
                    csrl.setStatus(GxqptSendee.STATUS3);
                    gxqptSendeeService.updateByIdSelective(csrl);
                }
            }
            //设置处理时长
            ConfirmTimeDO hantime = gxqptSendeeService.getConfirmti(gxqptWarn.getId(),GxqptSendee.RECTYPE3);
            gxqptWarn.setHandleCostTime(hantime.getHandleTime());
            gxqptWarnService.updateByIdSelective(gxqptWarn);
            return Result.success(true);
        }else {
            return Result.fail("处理失败");
        }
    }

    /**
     * 对预警人员添加 部门 信息
     * */
    private GxqptSendee sendeeSingleDeal(GxqptSendee duList){
        List<String> useIds = new ArrayList<>();
        useIds.add(duList.getUserId().toString());
        GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
        dto.setUserIds(useIds);
        dto.setPageNo(1);
        dto.setPageSize(useIds.size());
        List<GxqptEmpRetDTO> empDate = gxqptEmpApi.findEmpByUserIdsNoToken(dto).getData().getList();
        log.info("预警人员信息查询返回 empDate.toString:{}",empDate.toString());
        if(!empDate.isEmpty()){
            for(GxqptEmpRetDTO user : empDate){
                if(duList.getUserId().equals(user.getGxqptEmpId())){
                    //部门相关的信息
                    duList.setDepartmentId(user.getMaindeptid());
                    duList.setDepartmentName(user.getMaindeptname());
                    //应用相关信息
                    duList.setOrgId(user.getMainorgid());
                    duList.setOrgName(user.getMainorgname());
                    log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys02 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duList.getUserId(),duList.getDepartmentId(),duList.getOrgId());
                    break;
                }
            }
        }
        return duList;
    }
}
