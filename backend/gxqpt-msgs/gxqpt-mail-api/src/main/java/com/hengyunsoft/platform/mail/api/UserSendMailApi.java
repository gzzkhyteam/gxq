package com.hengyunsoft.platform.mail.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.mail.api.hystrix.UserSendMailHystrix;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.dto.open.MailBeanDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zjr
 * @date 2018/08/08
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = UserSendMailHystrix.class,
        path = "/api/mail")
public interface UserSendMailApi {

    @RequestMapping(value = "/send/email", method = RequestMethod.POST)
    Result<MailBeanDTO> saveSendEmail(@RequestBody SendMailInfoDTO mailInfoFB);
}
