package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 消息服务异常代码
 * 从70000~74999, 每个子模块加500， 每个异常代码+1
 */
public enum MsgExceptionCode implements BaseExceptionCode {

//    一、渠道组名称 长度32 ，必填；描述最长100 description ，不必填；其它渠道名字不为空
//    二、消息：1、标题 title 当是微博类型时，title必填，最长100，其它类型时不必填；
//            2、消息文本内容msg_txt 必填，最长1000；其它渠道名字不为空  ；
//            3、常用联系人contact_person 当是短信类型，必填，其它类型可空 250

    ID_NULL(70000, "ID不允许为空"),
    USERID_NULL(70001, "用户ID不允许为空"),
    // 渠道start
    CHANNELTYPE_EMPTY(70501, "渠道分类为空"),
    CHANNEL_NAME_EMPTY(70502, "渠道名称为空"),
    CHANNEL_NAME_LENG(70503, "渠道名称长度最长"),
    CHANNEL_APPID_EMPTY(70504, "应用系统ID为空"),
    CHANNEL_APPID_LENG(70505, "应用系统ID长度最长"),
    CHANNEL_APPPSECRET_EMPTY(70506, "密钥为空"),
    CHANNEL_APPPSECRET_LENG(70507, "密钥长度最长"),
    // 渠道end

    // 渠道组start
    CHANNELGROUP_NAME_EMPTY(71002, "渠道群组名称为空"),
    CHANNELGROUP_NAME_LENG(71003, "渠道群组名称长度最长32"),
    CHANNELGROUP_NAME_DECRIPTION(71004, "渠道群组描述长度最长100"),
    // 渠道组end

    // 消息start
    MESSAGE_CONTACTPERSON_EMPTY(71501, "联系人为空"),
    MESSAGE_CONTACTPERSON_LENG(71502, "联系人长度最长250"),
    MESSAGE_TITLE_EMPTY(71503, "标题为空"),
    MESSAGE_TITLE_LENG(71504, "标题长度最长32"),
    MESSAGE_MSGTXT_EMPTY(71505, "消息文本内容为空"),
    MESSAGE_MSGTXT_LENG(71506, "消息文本内容长度最长1000"),
    // 消息end


    // 站内消息start
    BBS_MESSAGE_BIZ_ID_EMPTY(75501, "业务id不能为空"),
    BBS_MESSAGE_BIZ_TYPE_EMPTY(75502, "业务类型不能为空"),
    BBS_MESSAGE_CLIENT_FLAG_EMPTY(75503, "客户端标识不能为空"),
    BBS_MESSAGE_BRIEF_TPYE_EMPTY(75504, "简要类型，粗粒度的类型不能为空"),
    BBS_MESSAGE_DETAILED_TYPE_EMPTY(75505, "详细类型不能为空"),
    BBS_MESSAGE_DETAILED_TYPE_DESC_EMPTY(75506, "详细类型描述不能为空"),
    BBS_MESSAGE_TITLE_EMPTY(75507, "标题不能为空"),
    BBS_MESSAGE_CONTENT_EMPTY(75508, "内容不能为空"),
    BBS_MESSAGE_SENDER_NAME_EMPTY(75509, "作者名称不能为空"),
    BBS_MESSAGE_HANDLER_URL_EMPTY(75510, "处理地址不能为空"),
    BBS_MESSAGE_HANDLER_PARAMS_EMPTY(75511, "处理参数不能为空"),
    BBS_MESSAGE_SINGLE_HANDLE_IS_EMPTY(75512, "是否单人处理不能为空"),
    BBS_MESSAGE_MAIN_HANDLER_NEED_IS_EMPTY(75513, "主信息是否需要操作不能为空"),
    BBS_MESSAGE_APP_ID_EMPTY(75514, "应用ID不能为空"),
    BBS_MESSAGE_APP_NAME_EMPTY(75515, "应用名称不能为空"),

    BBS_MESSAGE_RECEIVE_ID_EMPTY(75516, "接收人id不能为空"),
    BBS_MESSAGE_RECEIVE_HANDLER_NEED_IS_EMPTY(75517, "接收人是否需要处理不能为空"),

    BBS_MESSAGE_MSG_ID_EMPTY(75518, "消息id不能为空"),
    BBS_MESSAGE_FINISH_IS_EMPTY(75519, "是否处理完成标识不能为空"),
    BBS_MESSAGE_IDS_EMPTY(75520, "id集合不能为空"),
    BBS_MESSAGE_USER_ID_EMPTY(75521, "用户ID不能为空"),
    BBS_MESSAGE_CONDITIONS_EMPTY(75522, "筛选条件不能为空"),
    BBS_MESSAGE_USER_TYPE_EMPTY(75523, "用户类型不能为空"),
    BBS_MESSAGE_APP_ROLE_ID_EMPTY(75524, "应用角色ID不能为空"),
    BBS_MESSAGE_APP_ROLE_CODE_EMPTY(75525, "应用角色编码不能为空"),

    // 站内消息end


    ;
    private int code;
    private String msg;

    MsgExceptionCode(int code, String msg) {
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
