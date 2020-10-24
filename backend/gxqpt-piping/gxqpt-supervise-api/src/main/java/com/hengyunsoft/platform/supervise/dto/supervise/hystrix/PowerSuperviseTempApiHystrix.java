package com.hengyunsoft.platform.supervise.dto.supervise.hystrix;//package com.hengyunsoft.platform.piping.api.msgs.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import org.springframework.stereotype.Component;

@Component
public class PowerSuperviseTempApiHystrix implements PowerSuperviseTempApi {

    @Override
    public Result<PowerSuperviseTempSaveDTO> save(PowerSuperviseTempSaveDTO dto) {
        return Result.timeout();
    }
}
