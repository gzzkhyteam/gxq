package com.hengyunsoft.platform.exchange.impl.set.dataread.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataResDTO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.json.AbsApi;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.json.JsonApi;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.json.XmlApi;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.QueryData;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiElementService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetFilterWareService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetWareService;
import com.hengyunsoft.utils.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/***
 * 数据API远程调用管理
 */
@Service
@Slf4j
public class ApiDataDescManager {
    @Autowired
    private ShareDataApiService shareDataApiService;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private ShareDataSetService shareDataSetService;
    @Autowired
    private ShareDataApiElementService shareDataApiElementService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private ShareDataSetWareService shareDataSetWareService;
    /***
     * 得到API返回的数据字段
     * @param type 1:json 2:xml
     * @param url api地址
     * @return
     */
    public Set<String> getApiFieldNames(int type, String url) {
        try {
            AbsApi api = null;
            if (type == 1) {
                api = new JsonApi(url, RequestMethod.GET);

            }
            if (type == 2) {
                api = new XmlApi(url, RequestMethod.GET);
            }
            return api.getApiFieldNames();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /***
     * 得到API返回的数据和字段
     * @param type 1:josn 2.xml
     * @param url
     * @return
     * @throws Exception
     */
    public QueryData executeQuery(int type, String url) {
        try {
            AbsApi api = null;
            if (type == 1) {
                api = new JsonApi(url, RequestMethod.GET);
            }
            if (type == 2) {
                api = new XmlApi(url, RequestMethod.GET);
            }
            QueryData queryData = api.queryData();
            return queryData;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public Result<QueryDataResDTO> queryDataByAPIId(Long apiId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DIR_FIELD, apiId);

        //找到api
        ShareDataApi api = shareDataApiService.getById(apiId);
        if (api == null) {
            return Result.fail(ExchangeExceptionCode.SHARE_API_NOT_EXIST);
        }
        ShareDataDirectory dataDirectory = dataDirectoryService.getById(api.getDirId());

        //找到数据集
        ShareDataSetWare shareDataSet = shareDataSetWareService.getById(dataDirectory.getSetId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        if (shareDataSet.getSetType() != 3) {
            return Result.fail(ExchangeExceptionCode.DATA_SET_IS_NOT_API);
        }

        //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
        if (shareDataSet.getStatus() != 3) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
        }

        //找到对应的目录字段
        ShareDataApiElementExample sdaExample = new ShareDataApiElementExample();
        ShareDataApiElementExample.Criteria sdaExampleCriteria = sdaExample.createCriteria();
        sdaExampleCriteria.andApiIdEqualTo(apiId);
        List<ShareDataApiElement> shareDataApiElements = shareDataApiElementService.find(sdaExample);
        List<ShareDataElement> shareDataElements = new ArrayList<>();
        for (ShareDataApiElement sda : shareDataApiElements) {
            ShareDataElement dataElement = dataElementService.getById(sda.getFieldId());
            if (dataElement != null) {
                shareDataElements.add(dataElement);
            }
        }

        //拿到数据
        int apiDataType = shareDataSet.getApiDataType();//API数据类型:1,jason;2,xml
        String apiUrl = shareDataSet.getApiUrl();
        QueryData queryData = executeQuery(apiDataType, apiUrl);
        //过滤和重命名字段
        filterFields(shareDataElements, queryData);

        QueryDataResDTO resDTO = new QueryDataResDTO();
        resDTO.setRecords(queryData.getRecords());
        resDTO.setRowData(queryData.getRowData());
        resDTO.setFileds(queryData.getFileds());

        return Result.success(resDTO);
    }

    /***
     * 过滤字段
     * @param shareDataElements
     * @param queryData
     */
    public void filterFields(List<ShareDataElement> shareDataElements, QueryData queryData) {
        List<Integer> hasIndex = new ArrayList<>();
        List<DataSetElementDTO> fileds = queryData.getFileds();
        for (int i = 0; i < fileds.size(); i++) {
            DataSetElementDTO dsed = fileds.get(i);
            for (ShareDataElement sdse1 : shareDataElements) {
                if (dsed.getFieldCode().equals(sdse1.getSetField())) {
                    dsed.setFieldCode(sdse1.getFieldCode());
                    dsed.setFieldName(sdse1.getFieldName());
                    hasIndex.add(i);
                }
            }
        }
        List<List<Object>> rowData = queryData.getRowData();
        List<List<Object>> resRowData = new ArrayList<>();
        for (List<Object> row : rowData) {
            List<Object> resRow = new ArrayList<>();
            for (int i = 0; i < hasIndex.size(); i++) {
                Object v = row.get(hasIndex.get(i).intValue());
                resRow.add(v);
            }
            resRowData.add(resRow);
        }
        queryData.setRowData(resRowData);

        List<DataSetElementDTO> resFileds = new ArrayList<>();
        for (int i = 0; i < hasIndex.size(); i++) {
            DataSetElementDTO vs = queryData.getFileds().get(hasIndex.get(i).intValue());
            resFileds.add(vs);
        }
        queryData.setFileds(resFileds);
    }

}
