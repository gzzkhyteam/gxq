package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbColumnType;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDbColumnTypeService;
import com.hengyunsoft.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbsDatabase {
    /***
     * 数据库地址,只是主机名或者ip地址
     */
    protected String host;
    /***
     * 端口号
     */
    protected String port;
    /***
     * 用户名
     */
    protected String userName;
    /***
     * 密码
     */
    protected String password;
    /***
     * 数据库名称
     */
    protected String dbName;

    protected ShareDbColumnTypeService typeService;

    public AbsDatabase(String userName, String dbName, String port, String password, String host) throws Exception {
        this.userName = userName;
        this.dbName = dbName;
        this.port = port;
        this.password = password;
        this.host = host;
        this.typeService = SpringUtil.getBean(ShareDbColumnTypeService.class);
    }

    public AbsDatabase() {
    }

    public abstract String getdriverClassName();


    /***
     * 得到数据库的一张表
     * @param tableName
     * @return
     */
    public abstract DatabaseTableDTO getTableInfo(String tableName) throws Exception;

    /***
     * 得到索引数据库信息(不包含字段)
     * @return
     */
    public abstract List<DatabaseTableDTO> getAllTableInfo() throws Exception;

    /**
     * 获得数据库连接
     */
    protected abstract Connection getConnection() throws Exception;

    /***
     * 给sql加上分页参数
     * @param sql
     * @return
     */
    protected abstract String pareseLimitSql(String sql, long nowPage, int pageSize);

    /***
     * 获取表的数据条数
     * @param table
     * @return
     */
    protected long getTableCount(String table) throws Exception {
        String sql = getTableCountSql(table);
        return getSqlCount(sql);
    }

    private String getTableCountSql(String table) {
        return "SELECT COUNT(1) FROM " + table + ";";
    }

    /***
     * 获取sql查询的总条数
     * @return
     * @throws Exception
     */
    protected Long getSqlCount(String sql) throws Exception {
        Connection connection = null;
        int indexOf = sql.lastIndexOf("FROM");
        if (indexOf < 0) {
            indexOf = sql.lastIndexOf("from");
        }
        String from = sql.substring(indexOf);
        String exeSql = "SELECT COUNT(1) " + from;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(exeSql);
            rs = stmt.executeQuery();
            long count = 0;
            while (rs.next()) {
                count = rs.getLong(1);
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /***
     * 执行sql语句
     * @param sql
     * @return
     * @throws Exception
     */
    public QueryData executeQuery(String sql) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        QueryData queryData = new QueryData();
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            //获得sql查询的列名称
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<DataSetElementDTO> columnNames = new ArrayList<>();
            //目前支持的所有字段类型
            Map<String, ShareDbColumnType> allType = typeService.getAllShareDbColumnType();

            for (int i = 1; i <= columnCount; i++) {
                DataSetElementDTO df = new DataSetElementDTO();
                String columnName = metaData.getColumnLabel(i);
                String columnTypeName = metaData.getColumnTypeName(i);
                ShareDbColumnType shareDbColumnType = allType.get(columnTypeName.toLowerCase());
                if (shareDbColumnType == null) {
                    queryData.setMsg("字段:" + columnTypeName + " 的类型:" + columnTypeName + "当前还不支持");
                    return queryData;
                }
                if(shareDbColumnType.getMysqlType().equals("varchar")){
                    int precision = metaData.getPrecision(i);
                    if(precision > 16383){
                        shareDbColumnType = allType.get("text");
                    }
                    if(precision > 65535){
                        shareDbColumnType = allType.get("longtext");
                    }
                }
                if (shareDbColumnType.getIsLength() == 1) {
                    int precision = metaData.getPrecision(i);
                    df.setPrecision(precision);
                    if (shareDbColumnType.getIsScale() == 1) {
                        int scale = metaData.getScale(i);
                        df.setScale(scale);
                    }
                }
                df.setFieldName(columnName);
                df.setFieldCode(columnName);
                df.setFieldType(shareDbColumnType.getMysqlType());

                columnNames.add(df);
            }
            queryData.setFileds(columnNames);

            while (rs.next()) {
                //获得行数据
                // Map<String,Object> row = new HashMap<>();
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    row.add(value);
                    //row.put(columnNames.get(i-1).getFieldCode(),value);
                }
                queryData.addRow(row);
            }
            queryData.setRecords(queryData.getRowData().size());
            rs.close();
            stmt.close();
            return queryData;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            queryData.setMsg("执行sql失败，请检测sql语句的字段、表名称是否正确！请写可以执行的sql!");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return queryData;
    }


    /***
     * 根据sql查询list
     * @param sql
     * @return
     * @throws Exception
     */
    public List<Object> queryArrayBysql(String sql, int nowPage, int pageSize) throws Exception {
        String limitSql = pareseLimitSql(sql, nowPage, pageSize);
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(limitSql);
            rs = stmt.executeQuery();

            // json数组
            List<Object> array = new ArrayList<>();

            // 获取列数
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 遍历ResultSet中的每条数据
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject();
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    jsonObj.put(columnName, value);
                }
                array.add(jsonObj);
            }
            rs.close();
            stmt.close();
            return array;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }


    /***
     * 根据sql查询list总数
     * @param sql
     * @return
     * @throws Exception
     */
    public int queryArrayCountBysql(String sql) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            int columnCount = rs.getInt("totalNum");
            return columnCount;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public String toString() {
        return "DataBase{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + password + '\'' +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}
