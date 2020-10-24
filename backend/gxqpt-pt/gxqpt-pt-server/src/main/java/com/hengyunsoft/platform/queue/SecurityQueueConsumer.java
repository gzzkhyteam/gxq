package com.hengyunsoft.platform.queue;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.BooleanStatus;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.platform.queue.dto.InterfacesWarnSmsDTO;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecord;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecordMain;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceAccessStatMapper;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceConfigExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceCallRecordService;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceConfigService;
import com.hengyunsoft.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 安全保障平台消息队列 消费者
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Component
@Slf4j
public class SecurityQueueConsumer {
    /**
     * 接口调用记录
     */
    private final static String INTERFACE_CALL_RECORD_QUEUE = "security.interface.call.record";
    /**
     * 短信发送
     */
    private final static String WARN_SMS_QUEUE = "security.interface.warn.sms";

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;
    /**
     * 创建bean 的作用和 init 方法中的一样。
     * 没有这个，启动会报错
     *
     * @return
     */
    @Bean
    public Queue interfaceCallRecordQueue() {
        return new Queue(keyPrefix + INTERFACE_CALL_RECORD_QUEUE);
    }

    @Bean
    public Queue warnSmsQueue() {
        return new Queue(keyPrefix + WARN_SMS_QUEUE);
    }
//    @PostConstruct
//    public void init() {
//        try {
//            cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(INTERFACE_CALL_RECORD_QUEUE, true, false, false, null);
//            cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(WARN_SMS_QUEUE, true, false, false, null);
//        } catch (Exception e) {
//            log.error("初始化 消息队列 出错：{}", e);
//        }
//    }

    @Autowired
    private InterfaceConfigService interfaceConfigService;
    @Autowired
    private InterfaceCallRecordService interfaceCallRecordService;
    @Autowired
    private InterfaceAccessStatMapper interfaceAccessStatMapper;
    @Autowired
    private SmsSendApi smsSendApi;
    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @RabbitListener(queues = "${spring.redis.key-prefix}" +  WARN_SMS_QUEUE)
    @RabbitHandler
    public void saveWarnSms(String dto) {
        log.warn("预警短信  : {} ", dto);
        try {

            InterfacesWarnSmsDTO warnSms = JSONUtils.parse(dto, InterfacesWarnSmsDTO.class);

            if (warnSms == null || warnSms.getId() == null) {
                return;
            }

            InterfaceConfig ic = interfaceConfigService.getById(warnSms.getId());

            if (ic.getIsSmsNotify() && !ic.getIsNotify()) {


                if (StringUtils.isEmpty(ic.getMobile())) {
                    return;
                }
                String[] mobiles = StringUtils.split(ic.getMobile(), ";");

                if (mobiles == null || mobiles.length <= 0) {
                    return;
                }
                boolean flag = false;
                for (String mobile : mobiles) {
                    SmsSendDTO sms = new SmsSendDTO();
                    sms.setAppId("45aj6315");
                    sms.setAppName("安全保障平台");
//            sms.setContext("");
//            sms.setDraft(0);
//            sms.setMsgId(1);
                    sms.setReceiver(mobile);
//            sms.setSender("admin");
//            sms.setSenderName("admin");
//            sms.setStartTime();

//            ic.getUpperLimitCountByDay();
//            ic.getErrorCountMinute();
//            ic.getApiName();
//            ic.getApiUrl();
                    //尊敬的用户，您的接口：【接口名】，地址：【地址】，【描述】

                    sms.setChannelId("888");  //事先申请
                    sms.setTemplateId("644693885025");   //事先申请
                    JSONObject param = new JSONObject();
                    param.put("1", StringUtils.isEmpty(ic.getApiName()) ? "未知接口" : ic.getApiName());
                    param.put("2", ic.getApiUrl());
                    if (warnSms.getStatus() == InterfacesWarnSmsDTO.UPPER_DAY) {
                        param.put("3", "每日上限超出阀值");
                    } else {
                        param.put("3", "5分钟内预警阀值超出阀值");
                    }
                    sms.setTemplateParams(param.toJSONString());
//            sms.setTopic("主题");

                    Result<String> result = smsSendApi.send(sms);
                    if (result.isSuccess()) {
                        flag = true;
                    }
                    log.warn("接口id:{}, 发短信接口{}, 接收人{}", ic.getId(), result, sms.getReceiver());
                }

                if (flag) {
                    ic.setIsNotify(BooleanStatus.TRUE.getVal());
                    interfaceConfigService.updateByIdSelective(ic);
                }
            }
        } catch (Exception e) {
            log.error("发送预警短信出错", e);
        }

    }


    @RabbitListener(queues = "${spring.redis.key-prefix}" + INTERFACE_CALL_RECORD_QUEUE)
    @RabbitHandler
    public void saveProcess(String dto) {
        try {

            InterfaceCallRecord record = JSONUtils.parse(dto, InterfaceCallRecord.class);
            InterfaceCallRecordMain recordMain = JSONUtils.parse(dto, InterfaceCallRecordMain.class);
            log.debug("接口调用记录  : {} ", dto);

            if (record == null) {
                return;
            }
            InterfaceConfigExample example = new InterfaceConfigExample();

            InterfaceConfigExample example2 = new InterfaceConfigExample();
            InterfaceConfigExample.Criteria criteria = example2.createCriteria();
            criteria.andApiUrlEqualTo(record.getUrl()).andMethodEqualTo(record.getMethod());
            example.or(criteria);

            criteria = example2.createCriteria();
            criteria.andApiUrlEqualTo(record.getUri()).andMethodEqualTo(record.getMethod());
            example.or(criteria);

            criteria = example2.createCriteria();
            criteria.andApiUrlEqualTo(record.getZuulUri()).andMethodEqualTo(record.getMethod());
            example.or(criteria);
            InterfaceConfig config = interfaceConfigService.getUnique(example);

            LocalDateTime createTime = DateUtils.date2LocalDateTime(record.getCreateTime());
            if (config != null) {
//                record.setAppId(config.getAppId());
//                recordMain.setAppId(config.getAppId());
                record.setInterfaceConfigId(config.getId());
                record.setModularName(config.getModularName());

                //对内，对内接口名称设置
                if(StringUtils.isNotEmpty(config.getApiName())){
//                    record.setName(config.getApiName());//对外
                    recordMain.setName(config.getApiName());
                }else{
//                    record.setName(record.getName());//对内
                    recordMain.setName(record.getName());//对内
                }

                InterfaceAccessStat accessStat = new InterfaceAccessStat();
                accessStat.setInterfaceConfigId(config.getId());
                accessStat.setCreateTime(record.getCreateTime());
                accessStat.setStatSum(1);
                accessStat.setStatDate(createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                accessStat.setStatHour(Integer.valueOf(createTime.format(DateTimeFormatter.ofPattern("HH"))));
                interfaceAccessStatMapper.saveOrUpdate(accessStat);
            }

            record.setCreateHour(createTime.format(DateTimeFormatter.ofPattern("HH")));
            record.setCreateMonth(createTime.format(DateTimeFormatter.ofPattern("yyyyMM")));
            record.setCreateDate(createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            record.setErrMsg(sub(record.getErrMsg(), LENGTH1));
            record.setHeaders(sub(record.getHeaders(), LENGTH1));
            record.setResponseBody(sub(record.getResponseBody(), LENGTH1));
            record.setCookies(sub(record.getCookies(), LENGTH2));
            record.setRequestQueryParams(sub(record.getRequestQueryParams(), LENGTH2));
            record.setQueryString(sub(record.getQueryString(), LENGTH2));

            interfaceCallRecordService.saveMain(record,recordMain);  //记录所有的接口
        } catch (Exception e) {
            log.error("存储调用记录出错", e);
        }
    }

    private final static int LENGTH1 = 5000;
    private final static int LENGTH2 = 500;

    private static String sub(String val, int length) {
        if (val != null && val.length() > length) {
            return StringUtils.substring(val, 0, length);
        }
        return val;
    }

}
