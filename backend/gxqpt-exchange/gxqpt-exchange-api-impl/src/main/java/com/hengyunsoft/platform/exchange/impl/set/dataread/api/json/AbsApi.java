package com.hengyunsoft.platform.exchange.impl.set.dataread.api.json;

import com.hengyunsoft.platform.exchange.impl.set.dataread.api.ApiHttpClientUtill;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.QueryData;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/***
 * 一个api
 */
public abstract class AbsApi {
    /***
     * api地址
     */
    protected String apiUrl;
    /**
     * 请求类型
     */
    protected RequestMethod requestMethod;


    public AbsApi(String apiUrl, RequestMethod requestMethod) {
        this.apiUrl = apiUrl;
        this.requestMethod = requestMethod;
    }

    /***
     * 发生http请求获得数据
     * @return
     */
    public String httpReq() {
        String res = "";
        // JSONObject js = new JSONObject();
        //js.put("page", nowPage);//查询页
        if (requestMethod == RequestMethod.GET) {
            res = ApiHttpClientUtill.get(apiUrl);
        } else if (requestMethod == RequestMethod.POST) {
            // res = ApiHttpClientUtill.post(apiUrl, js.toJSONString());
            res = ApiHttpClientUtill.post(apiUrl, null);
        }
        return res;
    }

    /***
     *得到字段名称
     * @return
     * @throws Exception
     */
    public abstract Set<String> getApiFieldNames() throws Exception;

    /***
     * 查询数据,得到字段名称和数据
     * @return
     */
    public abstract QueryData queryData() throws  Exception;
}
