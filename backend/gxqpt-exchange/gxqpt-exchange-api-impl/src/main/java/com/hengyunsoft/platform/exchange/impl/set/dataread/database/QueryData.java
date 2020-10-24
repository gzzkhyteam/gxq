package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 所有的数据查询返回
 */
@Data
public class QueryData {
    /**
     * 总条数
     */
    private Integer records;

    /**
     * 查询返回数据的列名称,自定义sql不能获得字段注释
     */
    private List<DataSetElementDTO> fileds;
    /**
     * 返回的行数据,key:列名,value:值
     */
    private List<List<Object>> rowData;
    /***
     * 提醒消息
     */
    private String msg;

    public QueryData() {
        rowData = new ArrayList<>();
    }

    public void addRow(List<Object> row) {
        rowData.add(row);
    }

    public Map<String, DataSetElementDTO> getDataSetElementMp() {
        Map<String, DataSetElementDTO> map = new HashMap<>();
        for (DataSetElementDTO ele : fileds) {
            map.put(ele.getFieldCode(), ele);
        }
        return map;
    }

    public List<String> getElementCodeList() {
        List<String> list = new ArrayList<>();
        for (DataSetElementDTO ele : fileds) {
            list.add(ele.getFieldCode());
        }
        return list;
    }
}
