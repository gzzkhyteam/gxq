package com.hengyunsoft.platform.admin.impl.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogMaxDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.ResponseLoginLogListDTO;
import com.hengyunsoft.platform.admin.entity.core.po.LoginLogs;
import com.hengyunsoft.platform.admin.repository.core.example.LoginLogsExample;
import com.hengyunsoft.platform.admin.repository.core.service.LoginLogsService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginLogApiImpl implements LoginLogApi {

    @Autowired
    private LoginLogsService loginLogsService;

    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @IgnoreToken
    public Result<Long> addLoginLog(@RequestBody LoginLogDTO loginLogDTO) {

        LoginLogs loginLog = dozerUtils.map(loginLogDTO, LoginLogs.class);
        loginLog = loginLogsService.saveLogSetMasterLogId(loginLog);
        return Result.success(loginLog.getId());
    }

    @Override
    @IgnoreToken
    public void saveLogoutLog(Long masterLogId, long logoutTime) {

        LoginLogs entity = new LoginLogs();
        entity.setMasterLoginId(masterLogId);
        entity.setLogoutTime(new Date(logoutTime));
        loginLogsService.updateByMasterLoginIdSelective(entity);
    }

    @IgnoreToken
    @Override
    public Result<List<LoginLogMaxDTO>> findByAppId(@RequestParam("appId") String appId,
                                                    @RequestParam("beginDate")String beginDate) {
        //时间格式修改
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(beginDate);
        } catch (ParseException e) {
            //e.printStackTrace();
            log.error("Exception",e);
        }

        LoginLogsExample example = new LoginLogsExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andLoginTimeGreaterThanOrEqualTo(date);
        return Result.success(dozerUtils.mapList(loginLogsService.find(example), LoginLogMaxDTO.class));
    }

    @IgnoreToken
    @Override
    public Result<List<LoginLogMaxDTO>> findByAppIdAndLoginDate(@RequestParam("appId") String appId,
                                                                @RequestParam("beginDate") String beginDate) {
        //时间格式修改
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(beginDate);
        } catch (ParseException e) {
            //e.printStackTrace();
            log.error("Exception",e);
        }

        LoginLogsExample example = new LoginLogsExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andLoginTimeGreaterThanOrEqualTo(date);
        return Result.success(dozerUtils.mapList(loginLogsService.findByAppIdAndLoginDate(appId, beginDate), LoginLogMaxDTO.class));
    }

    @Override
    public Result<PageInfo<ResponseLoginLogListDTO>> page(@RequestBody OpenApiReq<LoginLogListDTO> openApiReq) {
        String appId = openApiReq.getData().getAppId();
        String userName = openApiReq.getData().getUserName();
        String account = openApiReq.getData().getAccount();
        Date startLginTime = openApiReq.getData().getStartLginTime();
        Date endLginTime = openApiReq.getData().getEndLginTime();
        Date startLogoutTime = openApiReq.getData().getStartLogoutTime();
        Date endLogoutTime = openApiReq.getData().getEndLogoutTime();
        LoginLogsExample example = new LoginLogsExample();
        example.createCriteria().andAppIdEqualTo(appId).andUserNameLike(BaseExample.fullLike(userName))
                .andAccountLike(BaseExample.fullLike(account)).andLoginTimeBetween(startLginTime,endLginTime)
                .andLogoutTimeBetween(startLogoutTime,endLogoutTime);
        example.setOrderByClause("login_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LoginLogs> loginLogsList = loginLogsService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(loginLogsList,ResponseLoginLogListDTO.class)));
    }
}
