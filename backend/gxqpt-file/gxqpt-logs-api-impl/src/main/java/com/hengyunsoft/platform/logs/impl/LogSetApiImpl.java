package com.hengyunsoft.platform.logs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.LogsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.logs.dto.LogPatternSetDTO;
import com.hengyunsoft.platform.logs.dto.LogPatternSetQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogPatternSetSaveDTO;
import com.hengyunsoft.platform.logs.dto.LogPatternSetUpdateDTO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogPatternSetService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "文件设置", description = "日志文件设置管理")
public class LogSetApiImpl /*implements LogSetApi*/{
    @Autowired
    private LogPatternSetService logPatternSetService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private DozerUtils dozerUtils;
    /**
     * 分页查询日志文件格式
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询文件格式", notes = "分页查询文件格式")
    @RequestMapping(value = "/set/pageQueryPattern", method = RequestMethod.POST)
    public Result<PageInfo<LogPatternSetDTO>> pageQueryPattern(@RequestBody OpenApiReq<LogPatternSetQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }
        LogPatternSetQueryDTO data = openApiReq.getData();
        LogPatternSetExample example = new LogPatternSetExample();
        if (data != null) {
            String appIds = data.getAppId();
            List<String> appIdList = new ArrayList();
            if (null != appIds && !"".equals(appIds)) {
                String[] appIdArray = appIds.split(",");
                for (int m = 0; m < appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if (null != appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            example.createCriteria()
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList);
        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogPatternSet> lists = logPatternSetService.pageQueryPattern(example);
        List<LogPatternSetDTO> pageList = dozerUtils.mapPage(lists, LogPatternSetDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "保存文件格式", notes = "保存文件格式")
    @ApiResponses({
            @ApiResponse(code = 65006, message = "实体对象未获取到值")
    })
    @RequestMapping(value = "/set/save", method = RequestMethod.POST)
    public Result<LogPatternSetDTO> save(@RequestBody LogPatternSetSaveDTO logPatternSetSaveDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logPatternSetSaveDTO);

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogPatternSet logPatternSet = new LogPatternSet();
        logPatternSet.setAppId(logPatternSetSaveDTO.getAppId());
        logPatternSet.setLogType(logPatternSetSaveDTO.getLogType());
        logPatternSet.setLogPattern(logPatternSetSaveDTO.getLogPattern());
        logPatternSet.setLogExportType(logPatternSetSaveDTO.getLogExportType());
        logPatternSet.setCreateTime(Calendar.getInstance().getTime());
        logPatternSet.setCreateUser(adminId);
        logPatternSet.setCreateUserName(userName);
        logPatternSet=logPatternSetService.save(logPatternSet);
        return Result.success(dozerUtils.map(logPatternSet, LogPatternSetDTO.class));
    }
    @ApiOperation(value = "更新日志格式设置", notes = "更新日志格式设置")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "日志格式id不能为空"),
            @ApiResponse(code = 65006, message = "实体对象未获取到值")
    })

    @RequestMapping(value = "/set/updatePattern", method = RequestMethod.POST)
    public Result<Boolean> updateSetDay(@RequestBody LogPatternSetUpdateDTO logPatternSetUpdateDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logPatternSetUpdateDTO);
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, logPatternSetUpdateDTO.getId());
        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        LogPatternSet logPatternSet = dozerUtils.map(logPatternSetUpdateDTO, LogPatternSet.class);
        logPatternSet.setAppId(logPatternSetUpdateDTO.getAppId());
        logPatternSet.setLogType(logPatternSetUpdateDTO.getLogType());
        logPatternSet.setLogPattern(logPatternSetUpdateDTO.getLogPattern());
        logPatternSet.setLogExportType(logPatternSetUpdateDTO.getLogExportType());
        logPatternSet.setUpdateTime(Calendar.getInstance().getTime());
        logPatternSet.setUpdateUser(adminId);
        logPatternSet.setCreateUserName(userName);
        logPatternSet.setCreateUserName(logPatternSetUpdateDTO.getCreateUserName());
        logPatternSet.setCreateUser(logPatternSetUpdateDTO.getCreateUser());
        logPatternSet.setCreateTime(logPatternSetUpdateDTO.getCreateTime());
        int i = logPatternSetService.updateById(logPatternSet);
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" + logPatternSetUpdateDTO.getId());
        }
    }
    @ApiOperation(value = "根据id删除日志文件格式", notes = "根据id删除日志文件格式")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/set/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logPatternSetService.deleteById(id);
        if(i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        }else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "根据ids批量删除日志文件格式", notes = "根据ids批量删除日志文件格式")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @RequestMapping(value = "/set/deleteBatch", method = RequestMethod.GET)
    public Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, ids);

        String[] idArray = ids.split(",");
        List<Long> list = new ArrayList<Long>();
        for(int m=0; m<idArray.length; m++) {
            String id = idArray[m];
            if(id != null && !id.equals("")) {
                list.add(Long.valueOf(id));
            }
        }
        int i=logPatternSetService.deleteByIds(list);
        if(i == 0) {
            return Result.fail("未找到要删除的数据，ids：" + ids);
        }else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "根据id查询日志文件格式", notes = "根据id查询日志文件格式")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @RequestMapping(value = "/set/get", method = RequestMethod.GET)
    public Result<LogPatternSetDTO> get(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        LogPatternSet logPatternSet = logPatternSetService.getById(id);
        return Result.success(dozerUtils.map(logPatternSet, LogPatternSetDTO.class));
    }

    /**
     * 根据appId和logType查询日志格式是否存在
     *
     * @param logPatternSetSaveDTO
     * @return
     */
    @RequestMapping(value = "/set/isExist", method = RequestMethod.POST)
    public Result<Integer> isExist(@RequestBody LogPatternSetSaveDTO logPatternSetSaveDTO) {
        LogPatternSetExample example = new LogPatternSetExample();
        example.createCriteria().andAppIdEqualTo(logPatternSetSaveDTO.getAppId()).andLogTypeEqualTo(logPatternSetSaveDTO.getLogType());
        int count = logPatternSetService.count(example);
        return Result.success(count);
    }
}
