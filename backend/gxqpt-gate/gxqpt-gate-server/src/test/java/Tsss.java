import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

import com.alibaba.fastjson.JSONArray;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
public class Tsss {

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

    public static void main(String[] args) {


        System.out.println("开始");


        for( int i = 0; i<5; i ++){
            Runnable t = () -> {
                String token = "p54k8Rr86UNUvmzyNz0zfzDCbWxktOzAj0B_TUrz6MpinVXi4h695fVihsfHx468R9H1TiVOPoXkH5H5vE8bTqNRjz8OpqJMVKhGzC6Yl9B4vkjclGtQ2hpBF_Xw0mNoLkL2vNbsnqbvlf8uxUvKjVvqvYvZLhlcLAzbD8tUjpTxNh4jfwPAjA8HRIBXnhf9HX6_TiFKRhTOruJ95xb1rkLjd4lMxTHEDfDbxInzlZRnz0rrJUpuBsRfDDJvxwl9hSH4bLRzrgpYVzpsNGbw0zZ0hcjfrKdwLZpG5fve07nTRcNr5v0W5OV76.v6xfzJBKB1PxbWhsHFdtVRVq8sRvp9PNbrbOdIv2rKrxDmVqhgn6jP8rVEfvfiDPvcjNr24ZppnFp9FSRj8LfB4tJSBlLVVz8An_0iBahR4z6qLWtQtn5yDPBSF38jX9BmR90OfYTulyHm6mVkLBHHlkj22IxZJqNtRXXl6ZxUByF0rgD8JKJSLztKV.TbdkhftuTApaNrPAT1xtDIJNdEXax35HZy6olgLGtFPG0tJrx9JHLKvYhh0CLTRgd5fYzbtpVaZ9P9fs4.og7Nqmow3PGDEmQayHLwhWlWzqBfllFofUNet9pTfFdHPitkRnrjnjr9ldlnplJfpAFarOHo8Ef5t80fz8b6Ra6dhehCd5hRlhbzRjvohndct7bnj8xqppRt8zTiPwdqT7Zq173.y5bom7o._u9_jd.4_53gW.ozZ..zjyN.rXK9SomWZgv7DWkiB1yU5KwqxEsm.WzG5UmW.lV47u5k9U1mKyM57gWoUAVUemBo_mwBoAzmCX7XZKBHd0M";
                String result = getResultByGet("http://127.0.0.1:10003/api/admin/fastEntry/getList", "", token);
                System.out.println(result);
            };
            Thread t1 = new Thread(t);
            t1.start();
        }



        System.out.println("结束");
    }
}
