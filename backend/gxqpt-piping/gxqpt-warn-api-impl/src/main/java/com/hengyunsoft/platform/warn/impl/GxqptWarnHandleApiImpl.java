package com.hengyunsoft.platform.warn.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.warn.api.warnhandle.dto.GxqptWarnHandlePagingDTO;
import com.hengyunsoft.platform.warn.api.warnhandle.dto.QueryWarnHandleDTO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnHandlePagingDO;
import com.hengyunsoft.platform.warn.entity.domain.QueryWarnHandleDO;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.utils.TreesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 预警处理台账
 * @author zjr
 * @date 2018/03/27
 */
@Api(value = "API - GxqptWarnHandleApiImpl", description = "预警处理台账")
@RestController
@RequestMapping("warnhandle")
@Slf4j
@WarnSendModule
public class GxqptWarnHandleApiImpl {

    @Autowired
    private GxqptWarnService gxqptWarnService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private TreesUtils treesUtils;
    @Autowired
    private GxqptSendeeService gxqptSendeeService;

    /**
     * 获取预警处理台账分页列表
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "获取预警处理台账分页列表", notes = "获取预警处理台账分页列表")
    @RequestMapping(value = "/findWarnHandleList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptWarnHandlePagingDTO>> findWarnHandleList(@RequestBody OpenApiReq<QueryWarnHandleDTO> openApiReq) {

        QueryWarnHandleDTO queryWarnHandleDTO = openApiReq.getData();
        List<Long> warnId = gxqptSendeeService.getWarnId(BaseContextHandler.getAdminId());

        QueryWarnHandleDO queryWarnHandleDO = dozerUtils.map(queryWarnHandleDTO, QueryWarnHandleDO.class);
        //查询预警类型子类
        List<Long> TypeList = treesUtils.getAllTypeIdList(queryWarnHandleDTO.getTypeId());
        queryWarnHandleDO.setTypeList(TypeList);
        //设置查询条件
        queryWarnHandleDO.setWarnId(warnId);
        //级别为空  或是 -1 查询全部
        if(String.valueOf(queryWarnHandleDTO.getLevel()).isEmpty() || queryWarnHandleDTO.getLevel().equals(-1)){
            queryWarnHandleDO.setLevel(null);
        }
        //查询
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<GxqptWarnHandlePagingDO> warnHandleList = gxqptWarnService.findHandleList(queryWarnHandleDO);
        //转换
        List<GxqptWarnHandlePagingDTO> paging1 = dozerUtils.mapPage(warnHandleList, GxqptWarnHandlePagingDTO.class);
        return Result.success(new PageInfo<>(paging1));

    }

}
