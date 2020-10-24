package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 短信服务异常代码
 * 45000~49999, 每个子模块加500， 每个异常代码+1
 */
public enum SmsExceptionCode implements BaseExceptionCode {
    MSG_PARAM_ERROR(45000, "消息中心请求参数错误"),
    SMS_PARAM_ERROR(45100, "操作短信模板参数错误"),
    SMS_CHANNELID_NULL(45101, "短信模板渠道ID为空"),
    SMS_CONTENT_NULL(45102, "短信模板内容为空"),
    SMS_TEMPLATEPARAM_NULL(45103, "短信模板参数为空"),
    SMS_TEMPLATECODE_NULL(45104, "短信模板编码为空"),
    SMS_SIGNNAME_NULL(45105, "短信模板签名为空"),
    SMS_NAME_NULL(45106, "短信模板名称为空"),
    SMS_UPDATEUSER_NULL(45107, "短信模板更新人为空"),
    SMS_TEMPLATEID_NULL(45108, "短信模板ID为空"),
    SMS_RECORDPARAM_ERROR(45110, "操作短信记录参数错误"),
    SMS_MSGID_NULL(45111, "短信信息ID为空"),
    SMS_ID_NULL(45112, "短信记录ID为空"),
    SMS_MESSAGE_NULL(45113, "短信信息为空"),
    SMS_APPID_NULL(45114, "应用程序ID为空"),
    SMS_SENDER_NULL(45115, "短信发送者为空"),
    SMS_RECEIVER_NULL(45116, "短信接收人为空"),
    SMS_MESSAGECHANNELID_NULL(45117, "短信发送渠道为空"),
    SMS_MESSAGETEMPLATEID_NULL(45118, "短信信息模板ID为空"),
    SMS_TEMPLATEPARAMS_NULL(45119, "短信信息模板参数为空"),
    SMS_ACCOUNTPARAM_ERROR(45120, "操作短信账号参数错误"),
    SMS_ACCOUNT_NULL(45121, "服务账号为空"),
    SMS_CHANNELNAME_NULL(45122, "短信渠道名称为空"),
    SMS_CHANNELSERVER_NULL(45123, "渠道服务商名称为空"),
    SMS_APPIDSERVER_NULL(45124, "第三方APPID不能为空"),
    SMS_APPSECRET_NULL(45125, "第三方申请密钥为空"),
    SMS_APPNAME_NULL(45126, "应用程序名称为空"),
    SMS_RECORD_SOURCE_TYPE_NULL(45127, "短信记录来源类型不能为空"),
    SMS_ENTITY_NULL(45128, "入参实体不能为空"),
    CONTACT_ID_NULL(45129, "联系人ID为空"),
    SMS_CONTEXT_NULL(45130, "短信内容不能为空"),
    SMS_TOPIC_NULL(45131, "短信主题不能为空");

    private int code;
    private String msg;

    SmsExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}