package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 全局错误码 10000-15000
 *
 * 预警异常编码    范围： 30000~34999
 * 标准服务异常编码 范围：35000~39999
 * 邮件服务异常编码 范围：40000~44999
 * 短信服务异常编码 范围：45000~49999
 * 权限服务异常编码 范围：50000-59999
 * 文件服务异常编码 范围：60000~64999
 * 日志服务异常编码 范围：65000~69999
 * 消息服务异常编码 范围：70000~74999
 * 开发者平台异常编码 范围：75000~79999
 * 搜索服务异常编码 范围：80000-84999
 * 共享交换异常编码 范围：85000-89999
 * 移动终端平台 异常码 范围：90000-94999
 *
 * 安全保障平台    范围：        95000-99999
 * 软硬件平台 异常编码 范围：    100000-104999
 * 运维服务平台 异常编码 范围：  105000-109999
 * 统一监管平台异常 编码 范围：  110000-114999
 * 认证方面的异常编码  范围：115000-115999
 * 
 * @author tyh
 * @createTime 2017-12-13 16:22
 */
public enum ExceptionCode implements BaseExceptionCode {

    //系统相关 start
    SYSTEM_BUSY(-1, "系统繁忙"),
    SYSTEM_TIMEOUT(-2, "服务超时"),
    PARAM_EX(-3, "参数类型解析异常"),
    SQL_EX(-4, "数据库异常"),
    NULL_POINT_EX(-5, "空指针异常"),
    ILLEGALA_RGUMENT_EX(-6, "无效参数异常"),
    MEDIA_TYPE_EX(-7, "请求类型异常"),
    LOAD_RESOURCES_ERROR(-8, "加载资源出错"),


    OK(200, "OK"),
    BAD_REQUEST(400, "错误的请求"),
    /**
     * {@code 401 Unauthorized}.
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1: Authentication, section 3.1</a>
     */
    UNAUTHORIZED(401, "未经授权"),
    /**
     * {@code 404 Not Found}.
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1: Semantics and Content, section 6.5.4</a>
     */
    NOT_FOUND(404, "没有找到资源"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),

    TOO_MANY_REQUESTS(429, "请求超过次数限制"),
    INTERNAL_SERVER_ERROR(500, "内部服务错误"),
    BAD_GATEWAY(502, "网关错误"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    //系统相关 end

    //DB相关 10000 start
    DB_REMOVE_ERROR(10000, "无法软删除"),
    //DB相关 end

    //jwt token 相关 start
    //过期
    JWT_TOKEN_EXPIRED(40001, "token超时，请检查 token 的有效期"),
    //签名错误
    JWT_SIGNATURE(40002, "不合法的token，请认真比对 token 的签名"),
    //token 为空
    JWT_ILLEGAL_ARGUMENT(40003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(40004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(40005, "解析token失败"),
    JWT_APPID_SECRET_INVALID(40006, "获取 access_token 时 AppSecret 错误，或者 AppId 无效！"),
    JWT_APPID_ENABLED(40007, "AppId 已经被禁用！请联系管理员"),
    //jwt token 相关 end


    //体系管理相关 start
    SYSTEM_ID_NULL(56500,"体系id不能为空"),
    //体系管理相关 end

    //正则匹配 start
    REGEX_PHONE_INVALID(57000, "电话号码格式不正确"),
    //正则匹配 end
    ;



    private int code;
    private String msg;

    ExceptionCode(int code, String msg) {
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
