package com.hengyunsoft.platform.developer.impl.screen;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.screen.api.PlatformUseInfoScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.platform.PlatformUseInfoDTO;
import com.hengyunsoft.platform.developer.repository.core.service.DependRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "API - OrgScreenApiImpl", description = "大屏单位查询")
@RestController
@RequestMapping("/platformUse/")
@Slf4j
public class PlatformUseInfoScreenApiImpl implements PlatformUseInfoScreenApi{

    @Autowired
    private DependRelationService dependRelationService;
    @Autowired
    private DozerUtils dozerUtils;


    @Override
    @ApiOperation(value = "查询近5个月平台共性实施使用情况", notes = "查询近5个月平台共性实施使用情况")
    @RequestMapping(value = "/getUseInfo", method = RequestMethod.GET)
    public Result<List<List<PlatformUseInfoDTO>>> getUseInfo() {
        PlatformUseInfoDTO platformUseInfoDTO = new PlatformUseInfoDTO();

        String dateString;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateString = sdf.format(cal.getTime());
        List<String> rqList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            dateString = sdf.format(cal.getTime());
            String year = dateString.substring(0, 4);
            String month = dateString.substring(5, 7);
            String yearMonth = dateString.substring(0, 7);
            rqList.add(yearMonth + "-" + this.getDaysByYearMonth(Integer.parseInt(year),Integer.parseInt(month)));
            cal.add(Calendar.MONTH, -1);
        }

        // 倒序
        Collections.reverse(rqList);
        List<List<PlatformUseInfoDTO>> result = new ArrayList<>();

        for(int i = 0; i < rqList.size(); i++){
            List<PlatformUseInfoDTO> list = dozerUtils.mapList(dependRelationService.getUseInfo(rqList.get(i)),PlatformUseInfoDTO.class);
            result.add(list);
        }

        //String[] devData = result.toArray(new String[result.size()]);

        return Result.success(result);
    }

    /**
     * 查询指定年月的天数
     * @param year,month
     */
    public int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
}
