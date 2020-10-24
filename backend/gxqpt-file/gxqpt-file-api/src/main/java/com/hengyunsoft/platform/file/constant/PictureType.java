package com.hengyunsoft.platform.file.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PictureType {
    /**
     * 无
     */
    NULL(""),
    /**
     * 转型为gif
     */
    GIF(".gif"),
    /**
     * 转型为jpg
     */
    JPG(".jpg"),
    /**
     * 转型为png
     */
    PNG(".png"),;

    String type;
}
