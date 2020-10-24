package com.hengyunsoft.platform.mail.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.mail.api.UserSendMailApi;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.dto.open.MailBeanDTO;
import org.springframework.stereotype.Component;

/**
 * 描述:熔断实现默认响应超时
 * @author zjr
 * @date 2018/08/08
 * @return
 */
@Component
public class UserSendMailHystrix implements UserSendMailApi {


    @Override
    public Result<MailBeanDTO> saveSendEmail(SendMailInfoDTO mailInfoFB) {
        return Result.timeout();
    }
}
