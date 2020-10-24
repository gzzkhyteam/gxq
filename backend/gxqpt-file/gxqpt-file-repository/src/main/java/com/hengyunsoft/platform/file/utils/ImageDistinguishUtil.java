package com.hengyunsoft.platform.file.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.exception.BizException;


@Slf4j
public class ImageDistinguishUtil {
    public static String general(MultipartFile file, String api, String clientId, String clientSecret, String tokenHost) {
        String otherHost = api;
        String params = "";
        InputStream in = null;
        byte[] data = null;
        /*获取图片的byte数组*/
        try {
            in = file.getInputStream();
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Base64转码为String*/
        String imgStr = Base64.getEncoder().encodeToString(data);
        try {
            /*拼接转型类型及数值传参的编码*/
            params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /*调用获取token方法*/
        String accessToken = getAuth(clientId, clientSecret, tokenHost);
        String result = null;
        try {
            /*调用post访问接口方法并获取结果*/
            result = post(otherHost, accessToken, params);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
//        JSONObject jsonObject = new JSONObject(result);
//        log.info("result:{}", jsonObject.toString());
//        if (jsonObject.get("error_code") != null &&
//                "216201".equals(jsonObject.get("error_code").toString())) {
//            throw new BizException(FileExceptionCode.IMAGE_DATA_TYPE_ERROR.getCode(), FileExceptionCode.IMAGE_DATA_TYPE_ERROR.getMsg());
//        }
        return result;

    }

    public static String post(String requestUrl, String accessToken, String params) throws IOException {
        /*url拼接*/
        String generalUrl = requestUrl + "?access_token=" + accessToken;
        URL url = null;
        DataOutputStream out = null;
        BufferedReader in = null;
        url = new URL(generalUrl);
        HttpURLConnection connection = null;
        /*打开URL链接*/
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(params);
        out.flush();
        out.close();
        /*建立真实链接*/
        connection.connect();
        /*获得所有响应头字段*/
        Map<String, List<String>> heads = connection.getHeaderFields();
        /*遍历所有头字段*/
        for (String key : heads.keySet()) {
            System.out.println(key + heads.get(key));
        }
        /*定义BufferReader读取URL的响应*/
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        System.out.println("result" + result);
        return result;
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk, String tokenHost) {
        // 获取token地址
        String authHost = tokenHost;
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
