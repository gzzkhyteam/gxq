package com.hengyunsoft.platform.file.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.hengyunsoft.platform.file.config.SwfProperties.SWF_PREFIX;


/**
 * @author tyh
 * @createTime 2018-04-04 16:10
 */
@ConfigurationProperties(prefix = SWF_PREFIX)
@Data
@NoArgsConstructor
@Configuration
public class SwfProperties {
    public static final String SWF_PREFIX = "gxqpt.swf-conver";
    /**
     * 部署环境 1:window 2：linux
     */
    private Integer env = 1;
    /**
     * 服务器上 pdf2swf 工具的路径
     */
    private String swfToolsPath;
    /**
     * 服务器上office的安装路径
     */
    private String officeHome;
    /**
     * xpdf中文路径
     */
    private String xpdfChineseSimplified = "/usr/local/xpdf-chinese-simplified";
    /**
     * 文件编码
     */
    private String fileEncode = "UTF-8";
}
