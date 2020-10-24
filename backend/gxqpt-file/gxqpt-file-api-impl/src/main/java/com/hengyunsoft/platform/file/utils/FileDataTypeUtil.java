package com.hengyunsoft.platform.file.utils;

import com.hengyunsoft.platform.file.constant.DataType;

public class FileDataTypeUtil {

    public static DataType getDataType(String mime) {
        if (mime == null || "".equals(mime)) {
            return DataType.OTHER;
        }
        if (mime.contains("image")) {
            return DataType.IMAGE;
        } else if (mime.contains("text")
                || mime.startsWith("application/vnd.ms-excel")
                || mime.startsWith("application/msword")
                || mime.startsWith("application/pdf")
                || mime.startsWith("application/vnd.ms-project")
                || mime.startsWith("application/vnd.ms-works")
                || mime.startsWith("application/x-javascript")
                || mime.startsWith("application/vnd.openxmlformats-officedocument")
                || mime.startsWith("application/vnd.ms-word.document.macroEnabled")
                || mime.startsWith("application/vnd.ms-word.template.macroEnabled")
                || mime.startsWith("application/vnd.ms-powerpoint")
                ) {
            return DataType.DOC;
        } else if (mime.contains("video")) {
            return DataType.VIDEO;
        } else if (mime.contains("application/x-director")) {
            return DataType.DIR;
        } else if(mime.contains("audio")){
            return DataType.AUDIO;
        }else {
            return DataType.OTHER;
        }
    }
}
