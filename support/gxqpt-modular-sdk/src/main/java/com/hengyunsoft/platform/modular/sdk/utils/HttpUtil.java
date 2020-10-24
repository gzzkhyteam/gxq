package com.hengyunsoft.platform.modular.sdk.utils;

import com.hengyunsoft.platform.modular.sdk.dto.MdCategoryDefDTO;
import com.hengyunsoft.platform.modular.sdk.dto.MdTagDefDTO;
import com.hengyunsoft.platform.modular.sdk.dto.ModularVersionUploadDTO;
import com.hengyunsoft.platform.modular.sdk.dto.UpdateVersionDTO;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * HttpClient请求的工具类
 *
 * @author zkx
 * @create_time 2018-4-16
 */
public class HttpUtil {

    /**
     * POST 请求
     *
     * @param url   请求的地址
     * @param json  请求的参数
     * @param token 请求需要的凭证信息
     * @return respContent
     */
    public static String getResultByPost(String url, String json, String token) {
        String respContent = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpClient client = HttpClients.createDefault();
            StringEntity entity = new StringEntity(json, "utf-8");// 解决中文乱码问题
            httpPost.setHeader("token", token);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            HttpResponse resp = client.execute(httpPost);
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
     * 获取token的请求
     *
     * @param url       请求的地址
     * @param appId     应用id
     * @param appSecret 应用密码
     * @return respContent
     */
    public static String getTokenByPost(String url, String appId, String appSecret) {
        String respContent = "";
        MultipartEntityBuilder multipartEntity = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpClient client = HttpClients.createDefault();
            multipartEntity = MultipartEntityBuilder.create();
            //添加消息体信息
            multipartEntity.addPart("appId", new StringBody(appId, ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("appSecret", new StringBody(appSecret, ContentType.create("text/plain", Consts.UTF_8)));
            HttpEntity reqEntity = multipartEntity.build();
            httpPost.setEntity(reqEntity);
            //执行请求
            HttpResponse resp = client.execute(httpPost);
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
     * 上传jar包的请求
     * 模拟表单带上传文件的请求
     *
     * @param url                     请求的地址
     * @param modularVersionUploadDTO 请求所需要的参数实体类
     * @param postFile                请求所需要的文件
     * @param token                   请求需要的凭证信息
     * @return respContent
     */
    public static String uploadPost(String url, ModularVersionUploadDTO modularVersionUploadDTO, File postFile, String token) {
        String respContent = "";
        MultipartEntityBuilder multipartEntity = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("token", token);
            CloseableHttpClient client = HttpClients.createDefault();
            multipartEntity = MultipartEntityBuilder.create();
            //添加消息体信息
            multipartEntity.addPart("repName", new StringBody(modularVersionUploadDTO.getRepName(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("modularName", new StringBody(modularVersionUploadDTO.getModularName(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("groupId", new StringBody(modularVersionUploadDTO.getGroupId(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("artifactId", new StringBody(modularVersionUploadDTO.getArtifactId(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("classifier", new StringBody(modularVersionUploadDTO.getClassifier(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("version", new StringBody(modularVersionUploadDTO.getVersion(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("createCompanyId", new StringBody(modularVersionUploadDTO.getCreateCompanyId().toString(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("createCompanyName", new StringBody(modularVersionUploadDTO.getCreateCompanyName(), ContentType.create("text/plain", Consts.UTF_8)));

            List<MdCategoryDefDTO> lc = modularVersionUploadDTO.getMcList();
            List<MdTagDefDTO> lt = modularVersionUploadDTO.getMtList();

            Long cId = null;
            for (int i = 0; i < lc.size(); i++) {//分类数组传参
                cId = lc.get(i).getId();
                multipartEntity.addPart("modularCategory", new StringBody(cId.toString(), ContentType.create("text/plain", Consts.UTF_8)));
            }
            Long tId = null;
            for (int i = 0; i < lt.size(); i++) {//标签数组传参
                tId = lt.get(i).getId();
                multipartEntity.addPart("modularTag", new StringBody(tId.toString(), ContentType.create("text/plain", Consts.UTF_8)));
            }

            multipartEntity.addPart("description", new StringBody(modularVersionUploadDTO.getDescription(), ContentType.create("text/plain", Consts.UTF_8)));
            //添加file文件
            FileBody fundFileBin = new FileBody(postFile);
            multipartEntity.addPart("file", fundFileBin);
            HttpEntity reqEntity = multipartEntity.build();
            httpPost.setEntity(reqEntity);
            //执行请求
            HttpResponse resp = client.execute(httpPost);
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
     * 更新jar包的请求
     * 模拟表单带上传文件的请求
     *
     * @param url              请求的地址
     * @param updateVersionDTO 更新jar包所需的实体类
     * @param postFile         请求所需要的文件
     * @param token            请求需要的凭证信息
     * @return respContent
     */
    public static String updateVersionPost(String url, UpdateVersionDTO updateVersionDTO, File postFile, String token) {
        String respContent = null;
        MultipartEntityBuilder multipartEntity = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("token", token);
            CloseableHttpClient client = HttpClients.createDefault();
            multipartEntity = MultipartEntityBuilder.create();
            //添加消息体信息
            multipartEntity.addPart("repName", new StringBody(updateVersionDTO.getRepName(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("groupId", new StringBody(updateVersionDTO.getGroupId(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("artifactId", new StringBody(updateVersionDTO.getArtifactId(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("classifier", new StringBody(updateVersionDTO.getClassifier(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("version", new StringBody(updateVersionDTO.getVersion(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("createCompanyId", new StringBody(updateVersionDTO.getCreateCompanyId().toString(), ContentType.create("text/plain", Consts.UTF_8)));
            multipartEntity.addPart("createCompanyName", new StringBody(updateVersionDTO.getCreateCompanyName(), ContentType.create("text/plain", Consts.UTF_8)));

            //添加file文件
            FileBody fundFileBin = new FileBody(postFile);
            multipartEntity.addPart("file", fundFileBin);
            HttpEntity reqEntity = multipartEntity.build();
            httpPost.setEntity(reqEntity);
            //执行请求
            HttpResponse resp = client.execute(httpPost);
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
     * GET 请求
     *
     * @param url   请求的地址
     * @param url   请求的地址
     * @param json  请求所需要的参数
     * @param token 请求需要的凭证信息
     * @return respContent
     */
    public static String getResultByGet(String url, String json, String token) {

        String respContent = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("token", token);
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
     * @param token                请求需要的凭证信息
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getResultByDelete(String getResultByDeleteUrl, CookieStore cookiestore, String token) {

        String respContent = "fail";
        try {
            HttpDelete httpdelete = new HttpDelete(getResultByDeleteUrl);
            httpdelete.setHeader("token", token);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            httpClient.setCookieStore(cookiestore);
            HttpResponse resp = httpClient.execute(httpdelete);

            if (resp.getStatusLine().getStatusCode() == 200) {
                respContent = "sucess";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respContent;
    }
}
