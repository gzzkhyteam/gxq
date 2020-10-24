package com.hengyunsoft.platform.supervise.dto.supervise;//package com.hengyunsoft.platform.piping.api.msgs;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.hystrix.PowerSuperviseTempApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${gxqpt.piping.feign.server:gxqpt-piping-server}",
path = "powersupervisetemp",
fallback = PowerSuperviseTempApiHystrix.class)
public interface PowerSuperviseTempApi {

    /**
     * 权责监管临时数据保存
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Result<PowerSuperviseTempSaveDTO> save(@RequestBody PowerSuperviseTempSaveDTO dto);
    }
