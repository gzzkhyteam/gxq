package com.hengyunsoft.platform.developer.impl.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.FindModuleNameDTO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceAssignModuleExample;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleService;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luchanghong
 * @create 2018-04-30 21:21
 * @desc 功能模块api实现层
 **/
@Api(value = "API - ServiceModuleApiImpl.java", description = "功能模块")
@RestController
@RequestMapping("serviceModule")
@Slf4j
public class ServiceModuleApiImpl implements ServiceModuleApi {

    @Autowired
    private ServiceModuleService serviceModuleService;
    @Autowired
    private ServiceAssignModuleService serviceAssignModuleService;
    @Autowired
    private DozerUtils dozerUtils;

    //统一认证功能code
    private static final String CODE_TYRZ = "sys_login_auth";

    /**
     * 查询功能模块名称
     *
     * @param pageSize
     * @return
     */
    @Override
    @ApiOperation(value = "查询功能模块名称(用于大屏接口)", notes = "查询功能模块名称(用于大屏接口)")
    @ApiResponses({
    })
    @RequestMapping(value = "/findModuleName", method = RequestMethod.GET)
    public Result<List<FindModuleNameDTO>> findModuleName(@RequestParam(value = "pageSize", required = false) Integer pageSize) {
        List<ServiceModule> moduleName = serviceModuleService.findModuleName(pageSize);
        List<FindModuleNameDTO> findModuleNameDTOS = dozerUtils.mapPage(moduleName, FindModuleNameDTO.class);
        Result<List<FindModuleNameDTO>> result = Result.success(findModuleNameDTOS, "数据查询成功");
        return result;

    }

    @Override
    @AppToken
    public Result<List<Long>> getConsumerModuleIdsUsable(String consumerAppId) {


        List<Long> moduleIds = serviceAssignModuleService.getConsumerModuleIdsUsable(consumerAppId);

        return Result.success(moduleIds);
    }

    @Override
    @ApiOperation(value = "获取近12月统一认证接入情况", notes = "获取近12月统一认证接入情况")
    @RequestMapping(value = "/findTyrzJoinLastYear", method = RequestMethod.GET)
    public Result<Map> findTyrzJoinLastYear() {
        //实例化返回参数
        Map res = new HashMap<>();
        List resDate = new ArrayList();
        List resValue = new ArrayList();

        //获取统一认证功能
        ServiceModuleExample moduleExample = new ServiceModuleExample();
        moduleExample.createCriteria().andCodeEqualTo(CODE_TYRZ);
        ServiceModule serviceModule = serviceModuleService.getUnique(moduleExample);

        //获取功能接入数据
        if (serviceModule != null){
            ServiceAssignModuleExample assignModuleExample = new ServiceAssignModuleExample();
            assignModuleExample.createCriteria().andModuleIdEqualTo(serviceModule.getId());
            List<ServiceAssignModule> assigns = serviceAssignModuleService.find(assignModuleExample);

            //获取近12个月
            List<Date> dates = getLastYearMonth();
            dates.forEach(date -> {
                resDate.add((1900 + date.getYear()) + "年" + (date.getMonth() + 1) + "月");
                resValue.add(assigns.stream().filter(obj -> isLagerDate(date, obj.getCreateTime())).count());
            });
        }
        res.put("xAxis", resDate);
        res.put("data", resValue);
        return Result.success(res);
    }

    /**
     * 获得过去12个月(包括本月)
     *
     * @return
     */
    private List<Date> getLastYearMonth() {
        List<Date> dates = new ArrayList<>();
        Date date = new Date();
        dates.add(date);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 11; i++) {
            cal.setTime(date);
            cal.add(cal.MONTH, -1);
            date = cal.getTime();
            dates.add(date);
        }
        Collections.reverse(dates);
        return dates;
    }

    /**
     * 判断data1>data2
     *
     * @param date1
     * @param date2
     * @return
     */
    private boolean isLagerDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            boolean isSameYear = cal1.get(Calendar.YEAR) >= cal2
                    .get(Calendar.YEAR);
            boolean isSameMonth = isSameYear
                    && cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH);
//            boolean isSameDate = isSameMonth
//                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2
//                    .get(Calendar.DAY_OF_MONTH);

            return isSameMonth;
        } catch (Exception e) {
            log.error("[RatingEngine] error occurred: ERROR ", e);
        }
        return false;
    }
}