package com.hengyunsoft.platform.supervise.impl.analysis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.supervise.dto.analysis.AppOptPageListDTO;
import com.hengyunsoft.platform.supervise.entity.po.AppOptLogConfig;
import com.hengyunsoft.platform.supervise.repository.example.AppOptLogConfigExample;
import com.hengyunsoft.platform.supervise.repository.service.AppOptLogConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.hengyunsoft.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luchanghong
 * @create 2019-04-19 17:25
 * @desc
 **/
@Api(value = "API - appOptConfig.java", description = "应用选择配置")
@RestController
@Slf4j
@RequestMapping("appOptConfig")
public class AppOptLogConfigApiImpl {
    @Autowired
    private AppOptLogConfigService appOptLogConfigService;


    @ApiOperation(value="应用选择配置分页列表查询",notes = "应用选择配置分页列表查询")
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    @ApiResponses({
    })
    public Result<PageInfo<AppOptLogConfig>> pageList(@RequestBody OpenApiReq<AppOptPageListDTO> appOptPageListDTO ){
        PageHelper.startPage(appOptPageListDTO.getPageNo(), appOptPageListDTO.getPageSize());
        AppOptLogConfigExample ae = new AppOptLogConfigExample();
        if (appOptPageListDTO!=null && appOptPageListDTO.getData()!=null) {
            ae.createCriteria().andAppIdEqualTo(appOptPageListDTO.getData().getAppId()).andStoreDayEqualTo(appOptPageListDTO.getData().getStoreDay())
                    .andStoreRatesEqualTo(appOptPageListDTO.getData().getStoreRates())
            .andTypeEqualTo(appOptPageListDTO.getData().getType());
        }
        List<AppOptLogConfig> appOptLogConfigs = appOptLogConfigService.find(ae);
        Result<PageInfo<AppOptLogConfig>> success = Result.success(new PageInfo<AppOptLogConfig>(appOptLogConfigs));
        return success;
    }

    @ApiOperation(value="应用选择配置查询",notes = "应用选择配置查询")
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ApiResponses({
    })
    public Result<AppOptLogConfig> findById(@RequestParam Long id){
        AppOptLogConfig byId=null;
        if (id!=null) {
            byId = appOptLogConfigService.getById(id);
        }
        Result<AppOptLogConfig> success = Result.success(byId);
        return  success;
    }
    @ApiOperation(value="删除应用选择配置",notes = "删除应用选择配置")
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    @ApiResponses({
    })
    public Result<Boolean> deleteById(@RequestParam Long id){
        Result<Boolean> success=null;
        if (id!=null) {
            appOptLogConfigService.deleteById(id);
            success =Result.success(true);
        }else {
            success =Result.success(false);
        }
        return  success;
    }
    @ApiOperation(value="保存应用选择配置",notes = "保存应用选择配置")
    @RequestMapping(value = "/saveData",method = RequestMethod.POST)
    @ApiResponses({
    })
    public Result<Boolean>saveData(@RequestBody AppOptLogConfig appOptLogConfig ){
        Result<Boolean> success=null;
        if (appOptLogConfig!=null) {
            appOptLogConfigService.save(appOptLogConfig);
            success =Result.success(true);
        }else {
        success =Result.success(false);
    }
        return  success;
    }
    @ApiOperation(value="修改应用选择配置",notes = "修改应用选择配置")
    @RequestMapping(value = "/updateData",method = RequestMethod.POST)
    @ApiResponses({
    })
    public Result<Boolean>updateData(@RequestBody AppOptLogConfig appOptLogConfig ){
        Result<Boolean> success=null;
        if (appOptLogConfig!=null && appOptLogConfig.getId()!=null) {
            appOptLogConfigService.updateById(appOptLogConfig);
            success =Result.success(true);
        }else {
            success =Result.success(false);
        }
        return  success;
    }
}