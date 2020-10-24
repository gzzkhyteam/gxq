package com.hengyunsoft.platform.mt.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.emp.GxqptEmpOrgResDTO;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.impl.userconfig.UserConfigJobType;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnityUtil {

    /**
     * 得到用户当前设置的单位id
     *
     * @param userId
     * @return
     */
    public static String getUnityId(Long userId) {
        GxqptEmpOrgResDTO emp = getEmp(userId);
        if (emp == null) {
            return "-1";
        } else {
            return emp.getMainorgid();
        }
    }

    public static GxqptEmpOrgResDTO getEmp(Long userId) {
        UserApi userApi = SpringUtil.getBean(UserApi.class);
        UserConfigService userConfigService = SpringUtil.getBean(UserConfigService.class);
        Result<GxqptEmpOrgResDTO> mainOrgRes = userApi.getMainOrg(userId);
        if (!mainOrgRes.isSuccess()) {
            log.error("调用消息接口 userApi的getMainOrg失败,错误码:{},错误消息:{}", mainOrgRes.getErrcode(), mainOrgRes.getErrmsg());
            return null;
        }
        GxqptEmpOrgResDTO mainOrg = mainOrgRes.getData();
        UserConfig uc = userConfigService.getUserConfigByidAndType(userId, UserConfigJobType.now_unity_id.jobId);
        if (uc == null) {
            uc = new UserConfig();
            uc.setUserId(userId);
            uc.setJobId(UserConfigJobType.now_unity_id.jobId);
            userConfigService.saveSelective(uc);
        } else {
            uc.setJobValue(mainOrg.getMainorgid());
            userConfigService.updateByIdSelective(uc);
        }
        return mainOrg;
    }
}
