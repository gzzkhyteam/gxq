package com.hengyunsoft.utils;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class UploadFileUtil {

    private static RequestConfig REQUEST_CONFIG = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build();


    public static Result uploadFile(String serverUrl, String token, Long userId, String fileName, byte[] contents) {
        if (token == null || "".equals(token)) {
            throw new RuntimeException("token不能为空");
        }
        if (userId == null) {
            userId = -1L;
        }
        try {
            HttpClient httpclient = HttpClients.createMinimal();
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("file", new ByteArrayBody(contents, fileName))
                    .addPart("userId",new StringBody(String.valueOf(userId),Consts.UTF_8))
                    .build();
            HttpPost post = new HttpPost(serverUrl);
            post.setHeader("token", token);
            post.setHeader("_user_id", String.valueOf(userId));

            post.setEntity(reqEntity);
            post.setConfig(REQUEST_CONFIG);
            HttpResponse response = httpclient.execute(post);
            HttpEntity entity = response.getEntity();
            String out = EntityUtils.toString(entity, "UTF-8");
            System.out.println("out=" + out);
            post.releaseConnection();
            return JSONObject.parseObject(out, Result.class);
        } catch (IOException var12) {
            var12.printStackTrace();

            System.out.println("var12=" + var12.getMessage());
            throw new RuntimeException("文件上传失败：" + var12.getMessage());
        }
    }


}
