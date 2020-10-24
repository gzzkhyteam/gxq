package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 文件服务（gxqpt-file 项目）相关的异常代码
 * 60000~64999, 每个子模块加500， 每个异常代码+1
 */
public enum FileExceptionCode implements BaseExceptionCode {
    // 文件夹相关 start
    FOLDER_NULL(60000, "文件夹为空"),
    FOLDER_NAME_EMPTY(60001, "文件夹名称为空"),
    FOLDER_PARENT_NULL(60002, "父文件夹为空"),

    FILE_NULL(60100, "文件为空"),
    FILE_NAME_EMPTY(60101, "文件名称为空"),
    FILE_FOLDER_NULL(60102, "文件夹为空"),
    FILE_ID_NULL(60103, "文件id为空"),
    FILE_CANT_NULL(60104, "文件不能为空"),
    // 文件夹相关 end


    //分享文件相关 start
    SHARE_ISPWD_NULL(60500, "分享文件加密标识为空"),
    SHARE_VALID_NULL(60501, "分享文件保存期限标识为空"),
    SHARE_FILES_NULL(60502, "分享文件列表为空"),
    //分享文件相关 end

    // 截取图片 start
    IMAGE_WIDTH_TOO_SMALL(61000, "图片宽度不能小于或等于0"),
    IMAGE_HEIGHT_TOO_SMALL(61001, "图片高度不能小于或等于0"),
    //截取图片 end

    //视频截图start
    VIDEO_FORMAT(61500, "文件格式必须是视频"),
    VIDEO_FORMAT_PARAM_ERROR(61501, "视频截图的参数不合理"),
    VIDEO_FORMAT_TIME_PARAM_ERROR(61502, "视频截图时长参数不合理，请输入0-3600的任意数字"),
    VIDEO_FORMAT_SIZE_PARAM_ERROR(61503, "视频大小参数不合理，请参考正确格式:500x300"),
    //视频截图end


    FILE_NOT_EXIST(62000, "文件不存在"),
    FILE_DELETE_TYPE(62001, "只能删除文件"),
    CONVER_ERROR(62002, "转换失败，请联系管理员"),

    //图片start
    COMMON_USER_ID_NULL(62500, "用户ID不能为空"),
    VIDEO_SCREENSHOT_TIME_NULL(62501,"视频截图时间不为空"),
    IMAGE_QUALITY_NULL(62502,"压缩品质不能为空"),
    RORATE_ANGLE_NULL(62503,"旋转角度不能为空"),
    RORATE_BETWEEN(62504,"旋转角度不在0 ~ 360范围之内"),
    IMAGE_QUALITY_BETWEEN(62505,"压缩品质不在0 ~ 1范围之内"),
    IMAGE_TYPE_NOT_MATCH(62506,"图片格式不支持或非图片传入"),

    //图片end


    //FileOpenApi start
    PARSE_DATE_EX(63000, "解析日期类型的参数出现异常，请检查日期类型的参数格式是否正确"),
    REQUIRED_FILE_PARAM_EX(63001, "请求中必须至少包含一个有效文件"),
    IMAGE_DATA_TYPE_ERROR(63002, "图片类型错误"),
    IMAGE_MIME_TYPE_ERROR(63003, "转换的图片类型只能为(jpg,png,gif)"),
    IMAGE_MINE_TYPE_SIZE_ERROR(63004, "图片类型错误或者图片的尺寸过小无法识别"),
    FILE_IDS_NULL(63005, "文件ids[]不能为空"),
    IMAGE_SIZE_BIG_4(63006, "文件大小不能超过4M"),
    IMAGE_SIZE_BIG_128(63006, "文件大小不能超过128M"),
    //FileOpenApi end

    ;
    private int code;
    private String msg;

    FileExceptionCode(int code, String msg) {
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
