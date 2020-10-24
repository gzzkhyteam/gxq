package com.hengyunsoft.platform.exchange.impl.set.dataread.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

/***
 * http请求客户端
 */
public class ApiHttpClientUtill {

    private static final int CONNECT_TIMEOUT = 5000;//设置超时毫秒数

    private static final int SOCKET_TIMEOUT = 10000;//设置传输毫秒数

    private static final int REQUESTCONNECT_TIMEOUT = 3000;//获取请求超时毫秒数

    private static final int CONNECT_TOTAL = 200;//最大连接数

    private static final int CONNECT_ROUTE = 20;//设置每个路由的基础连接数

    private static final int VALIDATE_TIME = 30000;//设置重用连接时间

    private static final String RESPONSE_CONTENT = "通信失败";

    private static PoolingHttpClientConnectionManager manager = null;

    private static CloseableHttpClient client = null;

    static {
        manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(CONNECT_TOTAL);
        manager.setDefaultMaxPerRoute(CONNECT_ROUTE);
        manager.setValidateAfterInactivity(VALIDATE_TIME);
        SocketConfig config = SocketConfig.custom().setSoTimeout(SOCKET_TIMEOUT).build();
        manager.setDefaultSocketConfig(config);
        client = HttpClients.createMinimal(manager);

    }

    private static String res(HttpRequestBase method) {
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        String content = RESPONSE_CONTENT;
        try {
            response = client.execute(method, context);//执行GET/POST请求
            HttpEntity entity = response.getEntity();//获取响应实体
            if (entity != null) {
                Charset charset = ContentType.getOrDefault(entity).getCharset();
                content = EntityUtils.toString(entity, charset);
                EntityUtils.consume(entity);
            }
        } catch (ConnectTimeoutException cte) {
            System.out.printf("请求连接超时，由于 " + cte.getLocalizedMessage());
            cte.printStackTrace();
        } catch (SocketTimeoutException ste) {
            System.out.printf("请求通信超时，由于 " + ste.getLocalizedMessage());
            ste.printStackTrace();
        } catch (ClientProtocolException cpe) {
            System.out.printf("协议错误（比如构造HttpGet对象时传入协议不对(将'http'写成'htp')or响应内容不符合），由于 " + cpe.getLocalizedMessage());
            cpe.printStackTrace();
        } catch (IOException ie) {
            System.out.printf("实体转换异常或者网络异常， 由于 " + ie.getLocalizedMessage());
            ie.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

            } catch (IOException e) {
                System.out.printf("响应关闭异常， 由于 " + e.getLocalizedMessage());
            }

            if (method != null) {
                method.releaseConnection();
            }

        }

        return content;
    }

    public static String get(String url) {
        HttpGet get = new HttpGet(url);
        return res(get);
    }

    public static String get(String url, String cookie) {
        HttpGet get = new HttpGet(url);
        if (StringUtils.isNotBlank(cookie))
            get.addHeader("cookie", cookie);
        return res(get);
    }

//    public static byte[] getAsByte(String url) {
//        return get(url).getBytes();
//    }
//
//    private static String getHeaders(String url, String cookie, String headerName) {
//        HttpGet get = new HttpGet(url);
//        if (StringUtils.isNotBlank(cookie))
//            get.addHeader("cookie", cookie);
//        res(get);
//        Header[] headers = get.getHeaders(headerName);
//        return headers == null ? null : headers.toString();
//    }

    private static String getWithRealHeader(String url) {
        HttpGet get = new HttpGet(url);
        get.addHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json;");
        get.addHeader("Accept-Language", "zh-cn");
        get.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
        get.addHeader("Keep-Alive", "300");
        get.addHeader("Connection", "Keep-Alive");
        get.addHeader("Cache-Control", "no-cache");
        return res(get);
    }

    public static String post(String url, Map<String, String> param, String cookie) {
        HttpPost post = new HttpPost(url);
        for (Entry<String, String> en : param.entrySet()) {
            post.addHeader(en.getKey(), en.getValue());
        }
        if (StringUtils.isNotBlank(cookie))
            post.addHeader("cookie", cookie);
        return res(post);
    }

    public static String post(String url, String data) {
        HttpPost post = new HttpPost(url);
        if (StringUtils.isNotBlank(data))
            post.addHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(data, ContentType.APPLICATION_JSON));
        return res(post);
    }

    public static String post(String url, Map<String, String> param, String cookie, Map<String, String> headers) {
        HttpPost post = new HttpPost(url);
        String reqEntity = "";
        for (Entry<String, String> entry : param.entrySet()) {
            post.addHeader(entry.getKey(), entry.getValue());
            try {
                reqEntity += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8") + "&";
            } catch (UnsupportedEncodingException e) {
                System.out.printf("请求实体转换异常，不支持的字符集，由于 " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

        try {
            post.setEntity(new StringEntity(reqEntity));
        } catch (UnsupportedEncodingException e) {
            System.out.printf("请求设置实体异常，不支持的字符集， 由于 " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        if (StringUtils.isNotEmpty(cookie))
            post.addHeader("cookie", cookie);

        return res(post);
    }

    /**
     * 将json键值对分别解析到数组中
     *
     * @param json 需要解析的json对象
     * @param type 决定返回值的内容：键或值
     * @return type="key"：返回json对象中"键"的字符串， type="key""value":返回json对象中"值"的字符串
     */
    public static String[] analyzeJsonToArray(String json, String type) {
        //String string = jsonject.toString();
       // json = json.replaceAll("\\s*", "");//去除所有空白
        json = json.trim();
        json = json.replace("}", "");
        json = json.replace("{", "");
        json = json.replace("\"", "");
        String[] strings = json.split(",");

        if (type.equals("key")) {
            String[] stringsNum = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                stringsNum[i] = strings[i].split(":")[0].trim();
            }
            return stringsNum;
        } else if (type.equals("value")) {
            String[] stringsName = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                stringsName[i] = strings[i].split(":")[1].trim();
            }
            return stringsName;
        } else {
            return null;
        }
    }

}
