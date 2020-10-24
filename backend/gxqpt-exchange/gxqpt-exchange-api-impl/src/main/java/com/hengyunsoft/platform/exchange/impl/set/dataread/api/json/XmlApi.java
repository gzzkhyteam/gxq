package com.hengyunsoft.platform.exchange.impl.set.dataread.api.json;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.QueryData;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * 返回xml类型的api
 *  {fieldCode:"id",fieldName:"主键",fieldType:"INTEGER",fieldLength:20},
 {fieldCode:"name",fieldName:"姓名",fieldType:"VARCHAR",fieldLength:20},
 *
 <?xml version="1.0" encoding="UTF-8" ?>
 <errcode>0</errcode>
 <errmsg>ok</errmsg>
 <data>
 <records>12</records>
 <fields>
 <field fieldCode = "id" fieldName="主键" fieldType="BIGINT(20)" ></field>
 <field fieldCode = "name" fieldName="名称" fieldType="VARCHAR(60)" ></field>
 </fields>
 <rows>
 <row>
 <id>ffb7f738acf911e79acf00ff685c09c9</id>
 <trainName>付费测试结果</trainName>
 <trainDesc>哈哈哈哈</trainDesc>
 <trainType>1</trainType>
 <trainHour>50</trainHour>
 </row>
 </rows>
 </data>
 */
public class XmlApi extends AbsApi {

    public XmlApi(String apiUrl, RequestMethod requestMethod) {
        super(apiUrl, requestMethod);
    }

    @Override
    public Set<String> getApiFieldNames() throws Exception {
        String res = httpReq();

        InputStream stream2 = new ByteArrayInputStream(res
                .getBytes("UTF-8"));
        // 得到DOM解析器的工厂实例
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // 从DOM工厂中获得DOM解析器
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        // 把要解析的xml文档读入DOM解析器
        Document doc = dbBuilder.parse(new InputSource(stream2));

        String errcode = doc.getElementsByTagName("errcode").item(0).getTextContent();
        if (!errcode.equals("0")) {
            return null;
        }
        Set<String> nameSet = new HashSet<>();
        Node fields = doc.getElementsByTagName("field").item(0);
        NodeList nodes = fields.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String name = item.getAttributes().getNamedItem("fieldCode").getTextContent();
            nameSet.add(name);
        }
        return nameSet;
    }

    @Override
    public QueryData queryData() throws Exception {
        String res = httpReq();
        InputStream stream2 = new ByteArrayInputStream(res
                .getBytes("UTF-8"));

        // 得到DOM解析器的工厂实例
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // 从DOM工厂中获得DOM解析器
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        // 把要解析的xml文档读入DOM解析器
        Document doc = dbBuilder.parse(new InputSource(stream2));

        String errcode = doc.getElementsByTagName("errcode").item(0).getTextContent();
        if (!errcode.equals("0")) {
            return null;
        }
        QueryData queryData = new QueryData();

        String recordsStr = doc.getElementsByTagName("records").item(0).getTextContent();
        queryData.setRecords(Integer.parseInt(recordsStr));

        List<DataSetElementDTO> fileds = new ArrayList<>();
        List<List<Object>> rowDatas = new ArrayList<>();
        //字段
        Node fields = doc.getElementsByTagName("field").item(0);
        NodeList nodes = fields.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String fieldCode = item.getAttributes().getNamedItem("fieldCode").getTextContent();
            String fieldName = item.getAttributes().getNamedItem("fieldName").getTextContent();
            String fieldType = item.getAttributes().getNamedItem("fieldType").getTextContent();
            DataSetElementDTO ds = new DataSetElementDTO();
            ds.setFieldCode(fieldCode);
            ds.setFieldName(fieldName);
            ds.setFieldType(fieldType);
            fileds.add(ds);
        }
        //数据
        NodeList rows = doc.getElementsByTagName("row");
        for (int i = 0; i < rows.getLength(); i++) {
            Node row = rows.item(i);
            NodeList childNodes = row.getChildNodes();
            List<Object> rowData = new ArrayList<>();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                rowData.add(item.getTextContent());
            }
            rowDatas.add(rowData);
        }

        queryData.setFileds(fileds);
        queryData.setRowData(rowDatas);

        return queryData;
    }
}
