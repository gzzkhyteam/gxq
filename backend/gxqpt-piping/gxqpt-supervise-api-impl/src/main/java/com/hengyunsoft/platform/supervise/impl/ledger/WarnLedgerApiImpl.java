package com.hengyunsoft.platform.supervise.impl.ledger;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.WarnExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.supervise.dto.ledger.*;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.dao.GxqptDutyMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendeeMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnTypeMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：预警台账API
 * 修改人：sxy
 * 修改时间：2018/7/4
 * 修改内容：新增基础接口
 */
@Api(value = "API - WarnLedgerApiImpl.java", description = "预警台账API")
@RestController
@RequestMapping("warnledger")
@Slf4j
public class WarnLedgerApiImpl {


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    private GxqptWarnTypeMapper warnTypeMapper;

    @Autowired
    private GxqptWarnMapper warnMapper;

    @Autowired
    private GxqptSendeeMapper sendeeMapper;

    @Autowired
    private GxqptDutyMapper dutyMapper;

    @Autowired
    private GxqptWarnTypeService warnTypeService;

    @Autowired
    private GxqptWarnTypeService gxqptWarnTypeService;


    /**
     * 获取资源下面所有字节点ID
     * @param typeId
     * @return
     */
    public  List<Long> getTypeList(Long typeId){
        //2.所传参数不为空是，查询
        String rootId = null;
        //2.1.查询所有的父id、id、类型名称
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        gxqptWarnTypeExample.createCriteria().andIsEnableEqualTo(true);
        gxqptWarnTypeExample.setOrderByClause("parent_id");
        List<GxqptWarnType> typeListAll = gxqptWarnTypeService.find(gxqptWarnTypeExample);
        List<Long> typeIdList = new ArrayList<Long>();
        if (typeListAll != null) {
            List<WarnTreeDTO> treeList = dozerUtils.mapList(typeListAll, WarnTreeDTO.class);

            if (typeId != null) {
                for (WarnTreeDTO tree : treeList) {
                    if (tree.getId() == typeId) {
                        tree.setChecked(true);
                        break;
                    }
                }
            }
            if (typeId!=null){
                List<WarnTreeDTO> treeList1 = TreeUtil.build(treeList, typeId);
                //2.2根据父类查询子类

                List<WarnTreeDTO> trees = new ArrayList<>();
                trees =  selectId(treeList1,trees);

                if (trees!=null && trees.size()!=0){
                    for (WarnTreeDTO warnTreeDTO : trees){
                        typeIdList.add(warnTreeDTO.getId());
                    }
                }else {
                    GxqptWarnType gxqptWarnType = warnTypeMapper.selectByPrimaryKey(typeId);
                    if (gxqptWarnType!=null){
                        Long id = gxqptWarnType.getId();
                        typeIdList.add(id);
                    }
                }

            }
        }
        return typeIdList;
    }


    /**
     * 查询预警类型子类递归
     * @param treeNodes
     * @param tree
     * @return
     */
    public static List<WarnTreeDTO> selectId(List<WarnTreeDTO> treeNodes, List<WarnTreeDTO> tree){
        for (WarnTreeDTO node : treeNodes){
            List<WarnTreeDTO> child = node.getChildren();
            if(child!=null && child.size()>0){
                selectId(child,tree);
            }
            tree.add(node);
        }
        return tree;
    }


    /**
     * 获取预警台账分页列表
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "获取预警台账分页列表", notes = "获取预警台账分页列表")
    @RequestMapping(value = "/getWarnLedgerList", method = RequestMethod.POST)
    public Result<PageInfo<QueryWarnLedgerResDTO>> getWarnLedgerList(@RequestBody OpenApiReq<WarnLedgerPagingReqDO> openApiReq) {

        //1.组装
        WarnLedgerPagingReqDO dto = openApiReq.getData();
        dto.setUserId(BaseContextHandler.getAdminId());
        if("0".equals(dto.getTypeId())){
            dto.setTypeId(null);
        }
        List<Long> TypeList = getTypeList(dto.getTypeId());
        if(TypeList.size()==0){
            TypeList = null;
        }
        dto.setTypeList(TypeList);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询
        log.info("根据userId[{}],查询预警台账分页,",dto.getUserId());
        List<QueryWarnLedgerResDO> list = warnMapper.getWarnLedgerList(dto);
        List<QueryWarnLedgerResDTO> listDto = dozerUtils.mapPage(list, QueryWarnLedgerResDTO.class);
        if(listDto.size() <= 0){
            return Result.success(new PageInfo<>(listDto));
        }
        for(QueryWarnLedgerResDTO li:listDto){
            List<GxqptSendee> sendeeList = sendeeMapper.getSendeeList(li.getId());
            li.setRecName(sendeeList.get(sendeeList.size()-1).getRecName());//设置接收人名字
            li.setRecType(sendeeList.get(sendeeList.size()-1).getRecType());//设置接收人类型
        }
        //3.转换
        List<QueryWarnLedgerResDTO> pageList = dozerUtils.mapPage(list, QueryWarnLedgerResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 获取预警处理台账分页列表
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "获取预警处理台账分页列表", notes = "获取预警处理台账分页列表")
    @RequestMapping(value = "/getWarnHandleLedgerList", method = RequestMethod.POST)
    public Result<PageInfo<QueryWarnHandleLedgerResDTO>> getWarnHandleLedgerList(@RequestBody OpenApiReq<WarnLedgerHandlePagingReqDO> openApiReq) {

        //1.组装
        WarnLedgerHandlePagingReqDO dto = openApiReq.getData();
        dto.setUserId(BaseContextHandler.getAdminId());
        if("0".equals(dto.getTypeId())){
            dto.setTypeId(null);
        }
        List<Long> TypeList = getTypeList(dto.getTypeId());
        if(TypeList.size()==0){
            TypeList = null;
        }
        dto.setTypeList(TypeList);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询
        log.info("根据userId[{}],查询预警处理台账分页,",dto.getUserId());
        List<QueryWarnHandleLedgerResDO> list = warnMapper.getWarnHandleLedgerList(dto);
        List<QueryWarnHandleLedgerResDTO> listDto = dozerUtils.mapPage(list, QueryWarnHandleLedgerResDTO.class);

        if(listDto.size() <= 0){
            return Result.success(new PageInfo<>(listDto));
        }

        //3.转换
        List<QueryWarnHandleLedgerResDTO> pageList = dozerUtils.mapPage(listDto, QueryWarnHandleLedgerResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 获取预警处理结果台账分页列表
     * 查询抄送人（登录用户-boss）相关的预警信息
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "获取预警处理结果台账分页列表", notes = "获取预警处理结果台账分页列表")
    @RequestMapping(value = "/getWarnHandleResultLedgerList", method = RequestMethod.POST)
    public Result<PageInfo<QueryWarnHandleResultLedgerResDTO>> getWarnHandleResultLedgerList(@RequestBody OpenApiReq<WarnLedgerHandleResultPagingReqDO> openApiReq) {

        //1.组装
        WarnLedgerHandleResultPagingReqDO dto = openApiReq.getData();
        dto.setUserId(BaseContextHandler.getAdminId());
        if("0".equals(dto.getTypeId())){
            dto.setTypeId(null);
        }
        log.info("根据userId[{}],查询预警处理结果台账分页,",dto.getUserId());
        List<Long> TypeList = getTypeList(dto.getTypeId());
        if(TypeList.size()==0){
            TypeList = null;
        }
        dto.setTypeList(TypeList);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询
        List<QueryWarnHandleResultLedgerResDO> list = warnMapper.getWarnHandleResultLedgerList(dto);
        List<QueryWarnHandleResultLedgerResDTO> listDto = dozerUtils.mapPage(list, QueryWarnHandleResultLedgerResDTO.class);
        if(listDto.size() <= 0){
            return Result.success(new PageInfo<>(listDto));
        }
        for(QueryWarnHandleResultLedgerResDTO li:listDto){
            List<GxqptSendee> sendeeList = sendeeMapper.getSendeeList(li.getId());
            li.setRecName(sendeeList.get(sendeeList.size()-1).getRecName());//设置接收人名字
            li.setRecType(sendeeList.get(sendeeList.size()-1).getRecType());//设置接收人类型
            li.setRemarks(sendeeList.get(sendeeList.size()-1).getRemarks());//设置处理信息
        }
        //3.转换
        List<QueryWarnHandleResultLedgerResDTO> pageList = dozerUtils.mapPage(list, QueryWarnHandleResultLedgerResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 查询预警类型
     * @return
     */
    @ApiOperation(value = "查询预警类型", notes = "查询预警类型")
    @RequestMapping(value = "/getWarnType", method = RequestMethod.GET)
    public Result<List<Map<String,Object>>> getWarnType(){
        return Result.success(warnTypeMapper.getWarnTypeList());
    }

    /**
     * 获取预警类型树
     * @param id
     * @return
     */
    @ApiOperation(value = "获取预警类型树", notes = "获取预警类型树")
    @RequestMapping(value = "/findWarnTypeTree", method = RequestMethod.GET)
    public Result<List<WarnTypeTreeDTO>> findWarnTypeTree(@RequestParam(value = "id") Long id){
        String rootId = "";
        GxqptWarnTypeExample example = new GxqptWarnTypeExample();
        example.createCriteria().andIsEnableEqualTo(true);
        example.setOrderByClause("parent_id");
        List<GxqptWarnType> list = warnTypeService.find(example);
        if (list != null&&list.size()>0) {
            List<WarnTypeTreeDTO> treeList = dozerUtils.mapList(list, WarnTypeTreeDTO.class);
            if (id != null) {
                for (WarnTypeTreeDTO tree : treeList) {
                    if (tree.getId() == id) {
                        tree.setChecked(true);
                        break;
                    }
                }
            }
            //获取根Id
            for (WarnTypeTreeDTO dto : treeList) {
                if (("-1").equals(dto.getParentId().toString())) {
                    rootId = dto.getId().toString();
                }
            }
            return Result.success(TreeUtil.build(treeList, rootId));
        } else {
            return Result.success(null);
        }
    }

    /**
     * 根据ID查询预警信息详情
     *
     * @param warnId
     * @return
     */
    @ApiOperation(value = "根据ID查询预警信息详情", notes = "根据ID查询预警信息详情")
    @RequestMapping(value = "/getByWarnId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<Map<String, Object>> getByWarnId(@RequestParam(value = "warnId") Long warnId) {

        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, warnId);

        //2.查询
        Map<String, Object> hashMap = new HashMap<String, Object>();
        GxqptWarn warn = warnMapper.selectByPrimaryKey(warnId);
        if (warn == null) {
            return Result.fail("详情不存在");
        }

        //查询预警接收信息
        List<GxqptSendee> sendeeList = sendeeMapper.getSendeeList(warnId);
        List<Map<String, Object>> dutyList = dutyMapper.getDutyList(warnId);

        //3.组装数据
        hashMap.put("sendeeList", sendeeList);
        hashMap.put("dutyList", dutyList);
        hashMap.put("warn", warn);
        return Result.success(hashMap);
    }

    /**
     * 根据ID查询预警台账流程信息
     *
     * @param warnId
     * @return
     */
    @ApiOperation(value = "根据ID查询预警台账流程信息", notes = "根据ID查询预警台账流程信息")
    @RequestMapping(value = "/getProcessMsg", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<Map<String, Object>> getProcessMsg(@RequestParam(value = "warnId") Long warnId) {

        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, warnId);

        //2.查询预警接收信息
        List<GxqptSendee> sendeeList = sendeeMapper.getSendeeList(warnId);
        int count = sendeeList.size();
        if(count <= 0){
            return Result.fail("查询预警信息无数据.");
        }
        Map<String, Object> hashMap = new HashMap<String, Object>();

        //最后一个环节状态  -- 预警状态 1、未确认 2、已确认 3、已处理
        //String lastStatus = sendeeList.get(count-1).getStatus();
        String lastType = sendeeList.get(count-1).getRecType();

        //存在责任人
        if("3".equals(lastType)){
            hashMap.put("list",sendeeList);
            return Result.success(hashMap);
        }

        //不存在责任人
        GxqptSendee extSendee = new GxqptSendee();
        extSendee.setRecName("待定");
        //接收人类型 1、确认人 2、抄送人 3、责任人
        extSendee.setRecType("3");
        extSendee.setStatus("未处理");
        extSendee.setHandlerLeve(666);//处理人虚拟级别
        sendeeList.add(extSendee);
        hashMap.put("list",sendeeList);

        //3.数据返回
        return Result.success(hashMap);
    }

    /**
     * 根据ID查询预警台账结果流程信息
     *
     * @param warnId
     * @return
     */
    @ApiOperation(value = "根据ID查询预警台账结果流程信息", notes = "根据ID查询预警台账结果流程信息")
    @RequestMapping(value = "/getProcessResultMsg", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 30000, message = "预警信息id为空"),
    })
    public Result<Map<String, Object>> getProcessResultMsg(@RequestParam(value = "warnId") Long warnId) {

        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, warnId);

        //2.查询预警接收信息
        List<GxqptSendee> sendeeList = sendeeMapper.getSendeeList(warnId);
        int count = sendeeList.size();
        if(count <= 0){
            return Result.fail("查询预警信息无数据.");
        }
        Map<String, Object> hashMap = new HashMap<String, Object>();

        //3.数据返回
        hashMap.put("list",sendeeList);
        return Result.success(hashMap);
    }
}
