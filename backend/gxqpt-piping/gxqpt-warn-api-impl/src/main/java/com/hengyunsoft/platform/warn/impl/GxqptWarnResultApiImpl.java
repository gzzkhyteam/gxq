package com.hengyunsoft.platform.warn.impl;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.warn.api.warnresult.dto.GxqptWarnResultPagingDTO;
import com.hengyunsoft.platform.warn.api.warnresult.dto.QueryWarnResultDTO;
import com.hengyunsoft.platform.warn.entity.domain.DutyerMessageDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnResultPagingDO;
import com.hengyunsoft.platform.warn.entity.domain.QueryWarnResultDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.utils.TreesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 预警处理结果台账
 * @author zjr
 * @date 2018/07/03
 */
@Api(value = "API - GxqptWarnResultApiImpl", description = "预警处理结果台账")
@RestController
@RequestMapping("warnresult")
@Slf4j
@WarnSendModule
public class GxqptWarnResultApiImpl {

    @Autowired
    private GxqptWarnService gxqptWarnService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private TreesUtils treesUtils;
    @Autowired
    private GxqptSendeeService gxqptSendeeService;

    /**
     * 预警处理结果台账分页
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "预警处理结果台账分页", notes = "预警处理结果台账分页")
    @RequestMapping(value = "/findWarnResultList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptWarnResultPagingDTO>> findWarnResultList(@RequestBody OpenApiReq<QueryWarnResultDTO> openApiReq) {

        QueryWarnResultDTO queryWarnResultDTO = openApiReq.getData();

        QueryWarnResultDO queryWarnResultDO = dozerUtils.map(queryWarnResultDTO, QueryWarnResultDO.class);
        //查询预警类型子类
        List<Long> TypeList = treesUtils.getAllTypeIdList(queryWarnResultDTO.getTypeId());
        queryWarnResultDTO.setTypeList(TypeList);
        //设置查询条件
        queryWarnResultDO.setUserId(BaseContextHandler.getAdminId());
        //级别为空  或是 -1 查询全部
        if(String.valueOf(queryWarnResultDTO.getLevel()).isEmpty() || queryWarnResultDTO.getLevel().equals(-1)){
            queryWarnResultDO.setLevel(null);
        }

        List<GxqptWarnResultPagingDO> warnResultList = gxqptWarnService.findResultList(queryWarnResultDO);
        //为责任人添加责任人姓名及处理备注
        if (warnResultList.size()!=0) {
            for (int i = 0; i < warnResultList.size(); i++) {
                Long ids = Long.valueOf(warnResultList.get(i).getWarnId());
                DutyerMessageDO dlist = gxqptSendeeService.getDListByWarnId(ids, GxqptSendee.RECTYPE3);
                if (dlist == null) {
                    warnResultList.get(i).setDutyName(null);
                    warnResultList.get(i).setRemarks(null);
                } else {
                    String dName = dlist.getRecName();
                    warnResultList.get(i).setDutyName(dName);
                    String remarks = dlist.getRemarks();
                    if (StringUtils.isEmpty(remarks)) {
                        warnResultList.get(i).setRemarks(null);
                    } else {
                        warnResultList.get(i).setRemarks(remarks);
                    }
                }
            }
        }
        //转换
        List<GxqptWarnResultPagingDTO> paging = dozerUtils.mapPage(warnResultList, GxqptWarnResultPagingDTO.class);
        return Result.success(new PageInfo<>(paging));
    }
}
