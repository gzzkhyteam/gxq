package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据库的一张表
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = "DatabaseTable", description = "数据库的一张表")
public class DatabaseTableDTO {

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "表注释")
    private String comment;

    @ApiModelProperty(value = "字段列表")
    private List<DataSetElementDTO> fieldList = new ArrayList<>();

    @ApiModelProperty(value = "提示消息")
    private String msg;

    public void addField(DataSetElementDTO databaseFieldDTO) {
        fieldList.add(databaseFieldDTO);
    }


    public Map<String, DataSetElementDTO> getDataSetElementMap() {
        Map<String, DataSetElementDTO> resMap = new HashMap<>();
        for (DataSetElementDTO ds : fieldList) {
            if (ds.getFieldCode().equals("key_id") || ds.getFieldCode().equals("synctime")) {
                continue;
            }
            resMap.put(ds.getFieldCode(), ds);
        }
        return resMap;
    }

    public DataSetElementDTO isContaint(String fieldCode){
        for (DataSetElementDTO f : this.getFieldList()){
            if (f.getFieldCode().equals(fieldCode)) {
                return f;
            }
        }
        return null;
    }
}
