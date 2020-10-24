package com.hengyunsoft.platform.file.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseFileModel {
    /**
     * 文件在服务器的相对路径
     * 文件的完整路径=absolutePath + filename
     * linux eg: 2015/01/01
     * win eg: 2015\\01\\01
     */
    private String relativePath;
    /**
     * 文件在服务器的绝对路径
     * 文件的完整路径=absolutePath + filename
     * linux eg: /home/tyh/file/RELATIVEPATH
     * win eg: d:\\file
     */
    private String absolutePath;
    /**
     * 新文件名
     */
    private String filename;
    /**
     * 后缀
     */
    private String ext;
}
