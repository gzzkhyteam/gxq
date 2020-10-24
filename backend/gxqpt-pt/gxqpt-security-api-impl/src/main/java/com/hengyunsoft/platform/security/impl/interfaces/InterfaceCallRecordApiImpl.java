package com.hengyunsoft.platform.security.impl.interfaces;

/**
 * @author luchanghong
 * @create 2018-09-04 14:40
 * @desc 接口调用记录
 **/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.security.dto.interfaces.InterCallListConditionDTO;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceCallMainListDTO;
import com.hengyunsoft.platform.security.dto.interfaces.PageInterCallListDTO;
import com.hengyunsoft.platform.security.entity.interfaces.domain.InterCallMonthDO;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecordMain;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordExample;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordMainExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceCallRecordMainService;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceCallRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：接口调用记录Api
 * 修改人：luchanghong
 * 修改时间：2018/9/4
 */
@Api(value = "API - InterfaceCallRecordController.java", description = "接口调用记录")
@RestController
@RequestMapping("interfaceCall")
@Slf4j
public class InterfaceCallRecordApiImpl {
    @Autowired
    private InterfaceCallRecordService interfaceCallRecordService;
    @Autowired
    private InterfaceCallRecordMainService interfaceCallRecordMainService;
    @Autowired
    private DozerUtils dozerUtils;

    @RequestMapping(value = "/findInterCallMonthCount", method = GET)
    @ApiOperation(value = "前十二月每月接口调用记录", notes = "前十二月每月接口调用记录)")
    @ApiResponses({
    })
    public Result<List<InterCallMonthDO>> findInterCallMonthCount() {
        List<InterCallMonthDO> list = interfaceCallRecordService.findInterCallMonthCount();
        Result<List<InterCallMonthDO>> aTrue = Result.success(list, "true");
        return aTrue;
    }

    @RequestMapping(value = "pageInterCallList", method = POST)
    @ApiOperation(value = "接口调用列表查询", notes = "接口调用列表查询")
    @ApiResponses({
    })
    public Result<PageInfo<PageInterCallListDTO>> pageInterCallList(@RequestBody OpenApiReq<InterCallListConditionDTO> openApiReq) {
        InterCallListConditionDTO dto = openApiReq.getData();

        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        InterfaceCallRecordMainExample example = new InterfaceCallRecordMainExample();
//        InterfaceCallRecordMainExample.Criteria criteria = example.createCriteria();
        example.createCriteria().andAppIdEqualTo(dto.getAppId()).andAccountEqualTo(dto.getAccount())
                .andUserNameLike("%"+dto.getUserName()+"%").andCreateTimeGreaterThanOrEqualTo(dto.getStartTime())
                .andCreateTimeLessThanOrEqualTo(dto.getEndTime());

        example.setOrderByClause("id desc");

        List<InterfaceCallRecordMain> list = interfaceCallRecordMainService.find(example);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, PageInterCallListDTO.class)));
    }
    @RequestMapping(value = "pageInterCallMainList", method = POST)
    @ApiOperation(value = "接口应用调用列表查询", notes = "接口应用调用列表查询")
    @ApiResponses({
    })
public  Result<PageInfo<InterfaceCallRecordMain>> pageInterCallMainList(@RequestBody OpenApiReq<InterfaceCallMainListDTO> openApiReq){
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        InterfaceCallRecordMainExample ir = new InterfaceCallRecordMainExample();
        InterfaceCallRecordMainExample.Criteria criteria = ir.createCriteria();
        if (openApiReq!=null&&openApiReq.getData()!=null){
            criteria.andCreateTimeBetween(openApiReq.getData().getStartTime(),openApiReq.getData().getEndTime())
                    .andNameLike(InterfaceCallRecordExample.fullLike(openApiReq.getData().getName())).andUserNameLike(InterfaceCallRecordExample.fullLike(openApiReq.getData().getUserName()));
            if (openApiReq.getData().getType().equals("application")) {
                criteria.andConsumerAppIdEqualTo(openApiReq.getData().getAppId());
            }else if(openApiReq.getData().getType().equals("service")){
                criteria.andAppIdEqualTo(openApiReq.getData().getAppId());
            }
        }
        List<InterfaceCallRecordMain> interfaceCallRecordMains = interfaceCallRecordMainService.find(ir);
        Result<PageInfo<InterfaceCallRecordMain>> success = Result.success(new PageInfo<>(interfaceCallRecordMains));
        return  success;
    }

    @RequestMapping(value = "findById", method = GET)
    @ApiOperation(value = "查询接口调用数据", notes = "查询接口调用数据")
    @ApiResponses({
    })
    public Result<InterfaceCallRecord> findById(@RequestParam Long id){
        InterfaceCallRecord byId=null;
        if (id !=null) {
            byId = interfaceCallRecordService.getById(id);
        }
        Result<InterfaceCallRecord> success = Result.success(byId);
        return  success;
    }
}