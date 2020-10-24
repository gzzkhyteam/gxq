package com.hengyunsoft.platform.jobs;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/16
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private InterfacesConfigActuator actuator;
    @Autowired
    private SmsSendApi smsSendApi;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @IgnoreToken
    @ApiIgnore
    public Result<String> test() {
        actuator.saveExchangeApiSynchronization();
        actuator.saveServiceApiSynchronization();

        return Result.success("执行");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @IgnoreToken
    @ApiIgnore
    public Result<String> test2() {
        SmsSendDTO sms = new SmsSendDTO();
        sms.setAppId("45aj6315");
        sms.setAppName("安全保障平台");
        sms.setReceiver("15218869970");

        sms.setChannelId("888");  //事先申请
        sms.setTemplateId("644693885025");   //事先申请
        JSONObject param = new JSONObject();
        param.put("1", "aaa");
        param.put("2", "aaaa");

        param.put("3", "5分钟内预警阀值超出阀值");

        sms.setTemplateParams(param.toJSONString());
//            sms.setTopic("主题");

        Result<String> result = smsSendApi.send(sms);
        log.info("发短信接口{}", result);

        return Result.success("执行");
    }
}
