package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataResDTO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiElementService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
import com.hengyunsoft.platform.exchange.repository.set.service.*;
import com.hengyunsoft.platform.exchange.utils.DataBaseSql;
import com.hengyunsoft.utils.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@Service
@Slf4j
public class DataBaseDescManager {
    @Autowired
    private ShareDbSourceService shareDbSourceService;
    @Autowired
    private ShareDataSetService shareDataSetService;
    @Autowired
    private ShareDataSetWareService shareDataSetWareService;
    @Autowired
    private ShareDataApiService shareDataApiService;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private ShareDataApiElementService shareDataApiElementService;
    @Autowired
    private DataElementWareService dataElementWareService;
    @Autowired
    private ShareDataSetFilterWareService shareDataSetFilterWareService;
    @Autowired
    private ShareDataSetElementWareService shareDataSetElementWareService;


    /***
     * 获取所有表信息，不获取字段
     * @param id
     * @return
     * @throws Exception
     */
    public List<DatabaseTableDTO> getAllTableNamesInfo(long id) {
        try {
            AbsDatabase database = getAbsDatabase(id);
            List<DatabaseTableDTO> allTableInfo = database.getAllTableInfo();
            return allTableInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;
    }

    /***
     * 获得表数据的总条数
     * @param id
     * @param table
     * @return
     */
    public long getTableCount(long id, String table) {
        try {
            AbsDatabase database = getAbsDatabase(id);
            return database.getTableCount(table);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return -1;
    }

    /***
     * sql语句返回的总条数
     * @param id
     * @param sql
     * @return
     */
    public long getSqlCount(long id, String sql) {
        try {
            AbsDatabase database = getAbsDatabase(id);
            return database.getSqlCount(sql);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return -1;
    }

    /***
     * 得到指定数据库指定表的信息
     * @param id 数据源id
     * @param table 表名称
     * @return
     */
    public DatabaseTableDTO getTableInfo(long id, String table) {
        try {
            AbsDatabase dataBase = getAbsDatabase(id);
            DatabaseTableDTO tableInfo = dataBase.getTableInfo(table);
            return tableInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;

    }

    /***
     * 测试数据源连接
     * @param dbSource
     * @return true 成功 false失败
     */
    public boolean testConnection(ShareDbSource dbSource) {
        int type = dbSource.getDbType();  // 数据库类型:1,orcale;2,mysql;3,sqlserver;
        String host = dbSource.getDbAddress();
        String port = dbSource.getDbPort();
        String dbName = dbSource.getDbName();
        String userName = dbSource.getDbAccount();
        String password = dbSource.getDbPassword();
        AbsDatabase adb;
        Connection connection = null;
        try {
            if (type == 1) {
                adb = new OracleDatabase(host, port, dbName, userName, password);
            } else if (type == 2) {
                adb = new MySqlDatabase(host, port, dbName, userName, password);
            } else if (type == 3) {
                adb = new SqlServerDatabase(host, port, dbName, userName, password);
            }else{
                return false;
            }
            connection = adb.getConnection();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private AbsDatabase getAbsDatabase(long id) throws Exception {
        ShareDbSource dbSource = shareDbSourceService.getById(id);
        int type = dbSource.getDbType();  // 数据库类型:1,orcale;2,mysql;3,sqlserver;
        String host = dbSource.getDbAddress();
        String port = dbSource.getDbPort();
        String dbName = dbSource.getDbName();
        String userName = dbSource.getDbAccount();
        String password = dbSource.getDbPassword();
        AbsDatabase adb = null;
        if (type == 1) {
            adb = new OracleDatabase(host, port, dbName, userName, password);
        } else if (type == 2) {
            adb = new MySqlDatabase(host, port, dbName, userName, password);
        } else if (type == 3) {
            adb = new SqlServerDatabase(host, port, dbName, userName, password);
        }
        return adb;
    }


    /***
     * 执行数据库查询
     * @param id 数据源id
     * @param selectSql
     * @return 描述数据库的JSON字符串
     * @throws Exception
     */
    public QueryData executeQuery(long id, String selectSql, long nowPage, int pageSize) throws Exception {
        try {
            AbsDatabase dataBase = getAbsDatabase(id);
            String limitSql = dataBase.pareseLimitSql(selectSql, nowPage, pageSize);
            QueryData data = dataBase.executeQuery(limitSql);
            return data;
        } catch (Exception e) {
            log.error("读取数据源数据错误", e);
            throw e;
        }
    }


    /***
     * 执行数据库查询不加分页
     * @param id 数据源id
     * @param selectSql
     * @return 描述数据库的JSON字符串
     * @throws Exception
     */
    public QueryData executeQuery(long id, String selectSql) {
        try {
            AbsDatabase dataBase = getAbsDatabase(id);
            QueryData data = dataBase.executeQuery(selectSql);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;
    }

    /***
     * 根据数据集id获得对应数据化员的数据库连接，用了请关闭掉
     * @param setId
     * @return
     * @throws Exception
     */
    public Connection getConnection(Long setId) throws Exception {
        ShareDataSet dataSet = shareDataSetService.getById(setId);
        if (dataSet.getSetType() != 4) {
            return null;
        }
        AbsDatabase database = getAbsDatabase(dataSet.getDbId());
        return database.getConnection();
    }

    /***
     * 根据api Id 查询数据
     * @param apiId
     * @param andSql
     * @return
     */
    public QueryDataResDTO queryDataByAPIId(Long apiId, StringBuilder andSql) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DIR_FIELD, apiId);

        //找到api
        ShareDataApi api = shareDataApiService.getById(apiId);
        if (api == null) {
            BizAssert.fail(ExchangeExceptionCode.SHARE_API_NOT_EXIST);
        }
        ShareDataDirectory dataDirectory = dataDirectoryService.getById(api.getDirId());

        //找到数据集
        ShareDataSetWare shareDataSet = shareDataSetWareService.getById(dataDirectory.getSetId());
        if (shareDataSet == null) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        if (shareDataSet.getSetType() != 4) {
            BizAssert.fail(ExchangeExceptionCode.DATA_SET_IS_NOT_DATABASE);
        }

        //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
        if (shareDataSet.getStatus() != 3) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
        }


        //找到对应的目录字段
        ShareDataApiElementExample sdaExample = new ShareDataApiElementExample();
        ShareDataApiElementExample.Criteria sdaExampleCriteria = sdaExample.createCriteria();
        sdaExampleCriteria.andApiIdEqualTo(apiId);
        List<ShareDataApiElement> shareDataApiElements = shareDataApiElementService.find(sdaExample);
        List<ShareDataElementWare> shareDataElements = new ArrayList<>();
        for (ShareDataApiElement sda : shareDataApiElements) {
            ShareDataElementWare dataElement = dataElementWareService.getById(sda.getFieldId());
            if (dataElement != null && StringUtils.isNotEmpty(dataElement.getSetField())) {
                shareDataElements.add(dataElement);
            }
        }

        String querySQL = getQuerySQL(shareDataSet, shareDataElements) + andSql;

        //拿到数据
        //QueryData queryData = executeQuery(shareDataSet.getDbId(), querySQL);
        QueryData queryData = executeLocalQueryResQueryData(querySQL, 1, 3);
        //过滤和重命名字段
        filterFields(shareDataElements, queryData);

        QueryDataResDTO resDTO = new QueryDataResDTO();
        resDTO.setRecords(queryData.getRecords());
        resDTO.setRowData(queryData.getRowData());
        resDTO.setFileds(queryData.getFileds());

        return resDTO;
    }

    /***
     * 过滤字段
     * @param shareDataElements
     * @param queryData
     */
    public void filterFields(List<ShareDataElementWare> shareDataElements, QueryData queryData) {
        List<Integer> hasIndex = new ArrayList<>();
        List<DataSetElementDTO> fileds = queryData.getFileds();
        for (int i = 0; i < fileds.size(); i++) {
            DataSetElementDTO dsed = fileds.get(i);
            for (ShareDataElementWare sdse1 : shareDataElements) {
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

    private String getQuerySQL(ShareDataSetWare
                                       shareDataSet, List<ShareDataElementWare> setElements) {
        setElements.sort(new Comparator<ShareDataElementWare>() {
            @Override
            public int compare(ShareDataElementWare o1, ShareDataElementWare o2) {
                return (int) (o1.getCreateTime().getTime() - o2.getCreateTime().getTime());
            }
        });
        //SELECT * FROM users WHERE 1=1
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT");
        for (int i = 0; i < setElements.size(); i++) {
            ShareDataElementWare sd = setElements.get(i);
            String setField = sd.getSetField();
            sb.append(" " + setField + " ");
            if (i < setElements.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(" FROM ");
        sb.append(shareDataSet.getFormalTableCode());

        sb.append(" WHERE 1=1 ");

//        for (ShareDataSetFilterWare ssf : dataSetFilterList) {
//            String fieldCode = ssf.getFieldCode();
//            sb.append(" AND ");
//            sb.append(fieldCode);
//            Integer scrRule = ssf.getScrRule();
//            FieldRoule rule = FieldRoule.getFieldRouleById(scrRule);
//            sb.append(" " + rule.getAndSql(ssf.getScrValue()) + "  ");
//        }
        return sb.toString();
    }

//    private String getQuerySQL(ShareDataSetWare
//                                       shareDataSet, List<ShareDataSetElementWare> setElements, List<ShareDataSetFilterWare> dataSetFilterList) {
//        //SELECT * FROM users WHERE 1=1
//        StringBuffer sb = new StringBuffer();
//        if (shareDataSet.getSetMode() == 1) {
//            sb.append("SELECT");
//            for (int i = 0; i < setElements.size(); i++) {
//                ShareDataSetElementWare sd = setElements.get(i);
//                String setField = sd.getFieldCode();
//                sb.append(" " + setField + " ");
//                if (i < setElements.size() - 1) {
//                    sb.append(",");
//                }
//            }
//            sb.append(" FROM ");
//            sb.append(shareDataSet.getTableCode());
//        } else {
//            sb.append(shareDataSet.getSqlCode());
//
//        }
//        sb.append(" WHERE 1=1 ");
//
//        for (ShareDataSetFilterWare ssf : dataSetFilterList) {
//            String fieldCode = ssf.getFieldCode();
//            sb.append(" AND ");
//            sb.append(fieldCode);
//            Integer scrRule = ssf.getScrRule();
//            FieldRoule rule = FieldRoule.getFieldRouleById(scrRule);
//            sb.append(" " + rule.getAndSql(ssf.getScrValue()) + "  ");
//        }
//        return sb.toString();
//    }

    /***
     * 执行本地仓库查询
     * @param sql
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Object> executeLocalQuery(String sql, Integer pageNo, Integer pageSize) {
        try {
            if (ObjectUtils.isEmpty(pageNo) || pageNo == 0){
                pageNo = 1;
            }
            if (ObjectUtils.isEmpty(pageSize) || pageSize == 0){
                pageSize = Integer.MAX_VALUE;
            }
            AbsDatabase dataBase = DataBaseSql.createLocalMySqlDatabase();
            List<Object> data = dataBase.queryArrayBysql(sql, pageNo, pageSize);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;
    }

    /***
     * 执行本地仓库查询
     * @param sql
     * @param pageNo
     * @param pageSize
     * @return
     */
    public QueryData executeLocalQueryResQueryData(String sql, int pageNo, int pageSize) {
        try {
            AbsDatabase dataBase = DataBaseSql.createLocalMySqlDatabase();
            String limitSql = dataBase.pareseLimitSql(sql, pageNo, pageSize);
            QueryData queryData = dataBase.executeQuery(limitSql);
            return queryData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;
    }

    /***
     * 本地仓库查询数量
     * @param sql
     * @return
     */
    public int executeLocalQueryCount(String sql) {
        try {
            AbsDatabase dataBase = DataBaseSql.createLocalMySqlDatabase();
            int count = dataBase.queryArrayCountBysql(sql);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return 0;
    }

    /***
     * 得到本地仓库数据库指定表的信息
     * @param table 表名称
     * @return
     */
    public DatabaseTableDTO getLocalTableInfo(String table) {
        try {
            AbsDatabase dataBase = DataBaseSql.createLocalMySqlDatabase();
            DatabaseTableDTO tableInfo = dataBase.getTableInfo(table);
            return tableInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取数据源数据错误", e);
        }
        return null;

    }
}
