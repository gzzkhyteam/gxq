package com.hengyunsoft.platform.developer.impl.screen;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import com.hengyunsoft.platform.developer.api.screen.api.OrgScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgMonthNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgTitleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author wz
 * @create 2018-04-30 21:37
 * @desc 单位大屏Api实现
 **/
@Api(value = "API - OrgScreenApiImpl", description = "大屏单位查询")
@RestController
@RequestMapping("org")
@Slf4j
public class OrgScreenApiImpl implements OrgScreenApi {
    @Autowired
    private GxqptSystemService systemService;
    @Autowired
    private GxqptOrgService orgService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 查询接入横幅
     *
     * @return
     */
    @Override
    @ApiOperation(value = "查询接入横幅", notes = "查询接入横幅")
    @RequestMapping(value = "/findTitle", method = RequestMethod.GET)
    public Result<OrgTitleDTO> findTitle() {
        //1.查出所有体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        List systemList = systemService.find(systemExample);

        //2.返回查询字符串并规划个数
        OrgTitleDTO orgTitle = new OrgTitleDTO();
        List list = orgService.findAll(systemList);
        orgTitle.setAccess(list.get(0) != null ? list.get(0).toString().split(",").length : 0);
        orgTitle.setOrgNum(list.get(1) != null ? list.get(1).toString().split(",").length : 0);
        orgTitle.setAppNum(list.get(2) != null ? list.get(2).toString().split(",").length : 0);

        return Result.success(orgTitle);
    }

    @Override
    @ApiOperation(value = "查询前7个月中每个月应用被调用的的次数", notes = "查询前7个月中每个月应用被调用的的次数")
    @RequestMapping(value = "/findAppUseNum", method = RequestMethod.GET)
    public Result<List<OrgMonthNumDTO>> findAppUseNum() {
        //获取近七个月的数据
        List<String> yearMonth = getYearMonth();
        List<OrgMonthNumDTO> orgMonthNumDTOs = dozerUtils.mapList(orgService.findNum(yearMonth), OrgMonthNumDTO.class);
        return Result.success(orgMonthNumDTOs);
    }

    //获取最新的近七个月数据 yyyy-mm
    private List<String> getYearMonth(){
        String dateString;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        List<String> rqList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            dateString = sdf.format(cal.getTime());
            String yearMonth = dateString.substring(0, 6);
            rqList.add(yearMonth);
            cal.add(Calendar.MONTH, -1);
        }
        // 倒序
        Collections.reverse(rqList);
        return rqList;
    }

}
