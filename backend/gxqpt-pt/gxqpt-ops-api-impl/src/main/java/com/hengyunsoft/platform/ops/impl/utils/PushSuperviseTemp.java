package com.hengyunsoft.platform.ops.impl.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class PushSuperviseTemp {

    @Autowired
    PowerSuperviseTempApi powerSuperviseTempApi;

    /**
     * 2019-04-29 统一监管推送
     *
     * @param bizId
     * @param startTime
     * @param endTime
     * @param code
     * @param desc
     * @param stepName
     */
    public void pushSupervise(Long bizId, Date startTime, Date endTime, String code, String desc, String stepName) {
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(bizId);
        sts.setStartTime(startTime);
        if (endTime != null) {
            sts.setEndTime(endTime);
        }
        sts.setCode(code);
        sts.setDesc(desc);
        sts.setName(stepName);
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.info("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
    }

}
