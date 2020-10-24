package com.hengyunsoft.platform.file.impl.file;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.dto.RecycleSettingDTO;
import com.hengyunsoft.platform.file.dto.RecycleSettingSaveDTO;
import com.hengyunsoft.platform.file.entity.file.po.RecycleSetting;
import com.hengyunsoft.platform.file.repository.file.example.RecycleSettingExample;
import com.hengyunsoft.platform.file.repository.file.service.RecycleSettingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author madengbo
 * @create 2018-09-03 12:01
 * @desc 云盘设置回收站
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("recyclesetting")
@Api(value = "云盘设置", description = "云盘设置，用于云盘设置管理")
public class RecycleSettingApiImpl /*implements RecycleSettingApi*/ {

    @Autowired
    private RecycleSettingService recycleSettingService;

    @Autowired
    private DozerUtils dozerUtils;

    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "云盘设置", notes = "云盘设置管理")
    public Result<Boolean> saveOrUpdate(@RequestBody RecycleSettingSaveDTO recycleSettingSaveDTO) {
        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        RecycleSettingExample recycleSettingExample = new RecycleSettingExample() ;
        recycleSettingExample.createCriteria().andCreateUserEqualTo(userId);
        List<RecycleSetting> recycleSettings = recycleSettingService.find(recycleSettingExample);
        if(recycleSettings == null || recycleSettings.size() == 0){

            RecycleSetting recycleSetting = dozerUtils.map(recycleSettingSaveDTO, RecycleSetting.class);

            //保存
            //基本信息设置
            recycleSetting.setAppId(appId);
            recycleSetting.setCreateUser(userId);
            recycleSetting.setCreateTime(date);
            recycleSettingService.save(recycleSetting);
            return Result.success(true);
        }

        //更新数据
        RecycleSetting recycleSetting = dozerUtils.map(recycleSettingSaveDTO, RecycleSetting.class);
        recycleSetting.setId(recycleSettings.get(0).getId());
        recycleSetting.setUpdateTime(date);
        recycleSetting.setUpdateUser(userId);
        recycleSettingService.updateByIdSelective(recycleSetting);
        return Result.success(true);
    }

    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ApiOperation(value = "查找个人设置信息", notes = "查找个人设置信息")
    public Result<List<RecycleSettingDTO>> find() {
        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        //获取跟云盘设置
        RecycleSettingExample recycleSettingExample = new RecycleSettingExample() ;
        recycleSettingExample.createCriteria().andCreateUserEqualTo(userId);
        List<RecycleSetting> recycleSettings = recycleSettingService.find(recycleSettingExample);

        //数据转换
        List<RecycleSettingDTO> recycleSettingDTOS = dozerUtils.mapList(recycleSettings, RecycleSettingDTO.class);
        return Result.success(recycleSettingDTOS);
    }


}
