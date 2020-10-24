package com.hengyunsoft.platform.modular.sdk.utils;

import java.io.*;
import java.util.Properties;

/**
 * 读取属性文件的工具类
 *
 * @author zhoukx
 * @create_time 2018-4-17
 */
public class PropertiesUtil {

    /**
     * 功能：从config.properties文件中读取出一个key对应的value
     *
     * @param keyName key值
     * @return 返回value值
     */
    public static String getValue(String keyName) {
        Properties props = new Properties();
        try {
            InputStream ips = PropertiesUtil.class.getResourceAsStream("/config.properties");
            BufferedReader ipss = new BufferedReader(new InputStreamReader(ips));
            props.load(ipss);
            String value = props.getProperty(keyName);
            return value;
        } catch (FileNotFoundException e) {
            System.out.println("无法找到文件:" + "/config.properties");
            return null;
        } catch (IOException e) {
            System.out.println("读文件出错:" + "/config.properties" + "---" + e.getMessage());
            return null;
        }
    }

}
