package com.hengyunsoft.platform.exchange.impl.set.dataread.api.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.QueryData;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * 根据api url 的调用返回字段
 *json格式规则:{
 "errcode": 0,
 "errmsg": "ok",
 "data": {
 "records": 12,
 "fields":[
 {fieldCode:"id",fieldName:"主键",fieldType:"INTEGER(20)"},
 {fieldCode:"name",fieldName:"姓名",fieldType:"VARCHAR(200)"},
 ]
 "rows": [{
 "id": "ffb7f738acf911e79acf00ff685c09c9",
 "trainName": "付费测试结果",
 "trainDesc": "哈哈哈哈",
 "trainType": 1,
 "trainHour": 50
 }]
 }
 }
 */
public class JsonApi extends AbsApi {
    public JsonApi(String apiUrl, RequestMethod requestMethod) {
        super(apiUrl, requestMethod);
    }

    /***
     * 得到字段名称
     * @return
     * @throws Exception
     */
    public Set<String> getApiFieldNames() throws Exception {
        String res = httpReq();
        JSONObject jsonObject = JSON.parseObject(res);
        int errcode = jsonObject.getInteger("errcode");
        if (errcode != 0) {
            return null;
        }
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray rows = data.getJSONArray("rows");
        JSONObject row1 = rows.getJSONObject(0);
        return row1.keySet();
    }

    /***
     * 得到字段名称和数据
     * @return
     */
    public QueryData queryData() throws Exception {
        String res = httpReq();
        JSONObject jsonObject = JSON.parseObject(res);

        int errcode = jsonObject.getInteger("errcode");
        if (errcode != 0) {
            return null;
        }
        QueryData queryData = new QueryData();
        Integer records = jsonObject.getInteger("records");
        queryData.setRecords(records);

        JSONObject data = jsonObject.getJSONObject("data");
        //字段
        JSONArray fields = data.getJSONArray("fields");
        List<DataSetElementDTO> fileds = new ArrayList<>();
        for (int i = 0; i <= fields.size(); i++) {
            JSONObject fieldObj = fields.getJSONObject(i);
            DataSetElementDTO ds = new DataSetElementDTO();
            ds.setFieldCode(fieldObj.getString("fieldCode"));
            ds.setFieldName(fieldObj.getString("fieldName"));
            ds.setFieldType(fieldObj.getString("fieldType"));
            fileds.add(ds);
        }
        queryData.setFileds(fileds);

        //行数据
        JSONArray rows = data.getJSONArray("rows");
        for (int i = 0; i < rows.size(); i++) {
            JSONObject row = rows.getJSONObject(i);
            // Map<String, Object> rowValue = new HashMap<>();
            List<Object> rowValue = new ArrayList<>();
            for (Map.Entry<String, Object> en : row.entrySet()) {
                // rowValue.put(en.getKey(), en.getValue());
                rowValue.add(en.getValue());
            }
            queryData.addRow(rowValue);
        }
        queryData.setRecords(rows.size());
        return queryData;
    }

}
