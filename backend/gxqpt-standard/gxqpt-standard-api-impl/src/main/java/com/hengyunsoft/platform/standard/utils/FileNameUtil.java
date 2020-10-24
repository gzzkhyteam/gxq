package com.hengyunsoft.platform.standard.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author luosh
 * @date Created on 2019/4/11 10:32
 * @description 文件名称工具类
 */
public class FileNameUtil {

    /**
     * 重命名文件名称
     */
    public static String renameFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return "fn" + getRandomTimestamp();
        }

        fileName = fileName.replace(".", "").replace(" ", "");
        // 文件名过长
        if (fileName.length() > 50) {
            return fileName.substring(0, 50) + getRandomTimestamp();
        } else {
            return fileName + getRandomTimestamp();
        }
    }

    /**
     * 时间戳字段截取
     */
    private static String getRandomTimestamp() {
        return (System.currentTimeMillis() + "").substring(7);
    }

}