package com.hengyunsoft.platform.exchange.impl.set;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetFileDTO;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.impl.set
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集api调用测试
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：新增基础接口
 */
@Api(value = "API - ApiTestImpl.java", description = "数据集api调用测试")
@RestController
@RequestMapping("apiTest")
@Slf4j
public class ApiTestImpl {

//    @RequestMapping(value = "/testJsonApi", method = RequestMethod.GET)
//    @IgnoreToken
//    public String testJsonApi() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("errcode", 0);
//        jsonObject.put("errmsg", "ok");
//
//        JSONObject data = new JSONObject();
//        data.put("records", 1);
//
//        JSONArray rows = new JSONArray();
//        JSONObject one = new JSONObject();
//        one.put("id", "ffb7f738acf911e79acf00ff685c09c9");
//        one.put("trainName", "测试结果");
//        one.put("trainDesc", "哈哈哈哈哈");
//        one.put("trainType", 1);
//        one.put("trainHour", 50);
//        rows.add(one);
//
//        data.put("rows", rows);
//        jsonObject.put("data", data);
//        String st1 = jsonObject.toString();
//        String str2 = jsonObject.toJSONString();
//        return str2;
//    }

    @RequestMapping(value = "/testJsonApi", method = RequestMethod.GET)
    @IgnoreToken
    public ResultTest testJsonApi() {
        ResultTest res = new ResultTest();
        res.errcode = 0;
        res.errmsg = "ok";
        res.records = 12;
        TestData td = new TestData();
        List<DataSetElementDTO> fields = new ArrayList<>();
        DataSetElementDTO eles1 = new DataSetElementDTO();
        eles1.setFieldCode("busId");
        eles1.setFieldName("文件编号");
        eles1.setFieldType("VARCHAR(300)");

        DataSetElementDTO eles2 = new DataSetElementDTO();
        eles2.setFieldCode("filePath");
        eles2.setFieldName("附件路径");
        eles2.setFieldType("VARCHAR(300)");

        DataSetElementDTO eles3 = new DataSetElementDTO();
        eles3.setFieldCode("fileSize");
        eles3.setFieldName("附件大小");
        eles3.setFieldType("DOUBLE(10,2)");

        DataSetElementDTO eles4 = new DataSetElementDTO();
        eles4.setFieldCode("fileType");
        eles4.setFieldName("附件类型");
        eles4.setFieldType("VARCHAR(20)");

        DataSetElementDTO eles5 = new DataSetElementDTO();
        eles5.setFieldCode("newName");
        eles5.setFieldName("上传到文件服务器上传的文件名称");
        eles5.setFieldType("VARCHAR(200)");

        DataSetElementDTO eles6 = new DataSetElementDTO();
        eles6.setFieldCode("oldName");
        eles6.setFieldName("原附件名称");
        eles6.setFieldType("VARCHAR(200)");
        fields.add(eles1);
        fields.add(eles2);
        fields.add(eles3);
        fields.add(eles4);
        fields.add(eles5);
        fields.add(eles6);

        List<DataSetFileDTO> list = new ArrayList<>();
        DataSetFileDTO dto = new DataSetFileDTO();
        dto.setBusId(121L);
        dto.setFilePath("www.baidu.com/file.jpg");
        dto.setFileSize(111.3);
        dto.setFileType("jsp");
        dto.setNewName("file.jpg");
        dto.setOldName("file.jpg");
        list.add(dto);
        td.rows = list;
        td.fields = fields;
        res.data = td;
        // String str = JSON.toJSON(res).toString();
        return res;
    }

    public static class ResultTest {

        private int errcode;
        private int records;

        private TestData data;

        private String errmsg = "ok";

        public int getErrcode() {
            return errcode;
        }

        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public TestData getData() {
            return data;
        }

        public void setData(TestData data) {
            this.data = data;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }

    private static class TestData {
        private List<DataSetElementDTO> fields;
        private List<DataSetFileDTO> rows;

        public List<DataSetFileDTO> getRows() {
            return rows;
        }

        public void setRows(List<DataSetFileDTO> rows) {
            this.rows = rows;
        }

        public List<DataSetElementDTO> getFields() {
            return fields;
        }

        public void setFields(List<DataSetElementDTO> fields) {
            this.fields = fields;
        }
    }
}
