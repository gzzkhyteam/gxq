package com.hengyunsoft.platform.mail.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/25
 */
@Getter
@AllArgsConstructor
public enum FolderType {

    INBOX(1, "收件箱"),
    SENDED(2, "已发送"),
    DRAFT(3, "草稿箱"),
    DELETE(4, "回收站"),
    SPAM(5, "垃圾邮件夹"),
    ABNORMAL(6, "异常邮件"),
    VIRUSES(7, "病毒邮件"),
    TRASH(7, "垃圾邮件"),

    ;
    private int code;
    private String describe;

}
