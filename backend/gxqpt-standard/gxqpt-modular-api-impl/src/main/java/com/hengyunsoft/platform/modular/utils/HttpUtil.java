package com.hengyunsoft.platform.modular.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;


/**
 * Http请求
 * get post delete
 *
 * @author zkx
 */
public class HttpUtil {


    /**
     * POST 请求
     *
     * @param url  请求的地址
     * @param json 参数
     */
    public static String getResultByPost(String url, String json) {
        String respContent = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpClient client = HttpClients.createDefault();
            StringEntity entity = new StringEntity(json, "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            HttpResponse resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == 204) {
                HttpEntity he = resp.getEntity();
                respContent = EntityUtils.toString(he, "UTF-8");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respContent;
    }

    /**
     * GET 请求
     *
     * @param url  请求的地址
     * @param json 参数
     */
    public static String getResultByGet(String url, String json) {

        String respContent = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpClient client = HttpClients.createDefault();
            StringEntity entity = new StringEntity(json, "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            HttpResponse resp = client.execute(httpGet);
            if (resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = resp.getEntity();
                respContent = EntityUtils.toString(he, "UTF-8");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respContent;
    }

    /**
     * DELETE 请求
     *
     * @param getResultByDeleteUrl nexus服务删除相应文件的请求地址
     * @param cookiestore          登录认证需要的信息
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getResultByDelete(String getResultByDeleteUrl, CookieStore cookiestore) {

        String respContent = "fail";
        try {
            HttpDelete httpdelete = new HttpDelete(getResultByDeleteUrl);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            httpClient.setCookieStore(cookiestore);
            HttpResponse resp = httpClient.execute(httpdelete);

            if (resp.getStatusLine().getStatusCode() == 204) {
                respContent = "sucess";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respContent;
    }

    /**
     * 请求
     *
     * @param url      nexus服务获取认证信息的请求地址
     * @param username 登录用户名
     * @param password 登录密码
     */
    public static CookieStore getCookieStore(String url, String username, String password) {
        //登录nexus认证,通过用户名和密码获取回话id
        HttpPost httpPostcookie = new HttpPost(url);
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("username", username));
        nvp.add(new BasicNameValuePair("password", password));
        CookieStore cookiestore = null;
        try {
            httpPostcookie.setEntity(new UrlEncodedFormEntity(nvp, "UTF-8"));
            DefaultHttpClient httpclientc = new DefaultHttpClient();

            //执行httpclientc请求
            HttpResponse responsec = httpclientc.execute(httpPostcookie);
            //获取Cookie中存储的会话信息
            cookiestore = httpclientc.getCookieStore();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cookiestore;
    }

    /**
     * 上传文件到nexus仓库 的方法
     *
     * @param cookiestore cookiestore
     * @param uploadUrl   上传的请求路径
     * @param file        需要进入仓库的文件句柄
     * @param params      其他需要传递的参数
     * @throws ClientProtocolException
     * @throws IOException
     * @author zx
     */
    public static Boolean uploadToResp(CookieStore cookiestore, String uploadUrl, File file, Map<String, String> params)
            throws IOException {
        Boolean result = false;
        HttpPost httpPost = new HttpPost(uploadUrl);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        // 上传的文件
        builder.addBinaryBody("maven2.asset1", file);
        setUploadParams(builder, params);
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(cookiestore);
        HttpResponse response = httpClient.execute(httpPost);
        if (null == response || response.getStatusLine() == null) {
            return result;
        } else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
            return result;
        }
        result = true;
        return result;
    }

    /**
     * 装载上传文件到nexus仓库所需要的参数
     *
     * @param multipartEntityBuilder
     * @param params
     * @author zx
     */
    private static void setUploadParams(MultipartEntityBuilder multipartEntityBuilder,
                                        Map<String, String> params) {
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                multipartEntityBuilder
                        .addPart(key, new StringBody(params.get(key),
                                ContentType.TEXT_PLAIN));
            }
        }
    }


}
