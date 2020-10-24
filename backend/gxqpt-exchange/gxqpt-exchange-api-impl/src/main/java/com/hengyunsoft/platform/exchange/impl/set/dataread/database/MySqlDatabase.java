package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbColumnType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MySqlDatabase extends AbsDatabase {

    public MySqlDatabase(String host, String port, String dbName, String userName, String password) throws Exception {
        super(userName, dbName, port, password, host);
    }

    @Override
    public String getdriverClassName() {
        return "com.mysql.jdbc.Driver";
    }


    /***
     * 使用了请关闭掉
     * @return
     * @throws Exception
     */
    @Override
    protected Connection getConnection() throws Exception {
        Class.forName(getdriverClassName());
        String url = getUrl();
        DriverManager.setLoginTimeout(3);
        Connection conn = DriverManager.getConnection(url.toString(), userName, password);
        return conn;
    }

    protected String getUrl() {
        //jdbc:mysql://localhost:3306/lucenedemo
        StringBuffer url = new StringBuffer("jdbc:mysql://");
        url.append(host);
        url.append(":");
        url.append(port);
        url.append("/");
        url.append(dbName);
        return url.toString();
    }

    @Override
    protected String pareseLimitSql(String sql, long nowPage, int pageSize) {
        long srart = (nowPage - 1) * pageSize;
        return sql + " limit " + srart + "," + pageSize;
    }


    public String getGetTableSqlStr() {
        return "SELECT\n" +
                "\tt.TABLE_NAME,\n" +
                "\tt.TABLE_COMMENT\n" +
                "FROM\n" +
                "\tINFORMATION_SCHEMA. TABLES t\n" +
                "WHERE   t.`TABLE_SCHEMA` = '" + dbName + "' ; ";
    }

    @Override
    public List<DatabaseTableDTO> getAllTableInfo() throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String getTableSql = getGetTableSqlStr();
        try {
            connection = getConnection();
            List<DatabaseTableDTO> list = new ArrayList<>();
            stmt = connection.prepareStatement(getTableSql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String tableComment = rs.getString("TABLE_COMMENT");
                DatabaseTableDTO table = new DatabaseTableDTO();
                table.setTableName(tableName);
                table.setComment(tableComment);
                list.add(table);
            }
            rs.close();
            stmt.close();
            return list;
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

    protected String getGetTableFieldSqlStr(String table) {
        return "SELECT\n" +
                "\tc.COLUMN_NAME,\n" +
                "\tc.COLUMN_COMMENT,\n" +
                "\tc.COLUMN_TYPE\n" +
                "FROM\n" +
                "\tINFORMATION_SCHEMA. COLUMNS c\n" +
                "WHERE c.`TABLE_SCHEMA` = '" + dbName + "'AND c.`TABLE_NAME` = '" + table + "';";
    }

    public DatabaseTableDTO getTableInfo(String table) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            String getTableFieldSql = getGetTableFieldSqlStr(table);

            stmt = connection.prepareStatement(getTableFieldSql);
            rs = stmt.executeQuery();
            List<DataSetElementDTO> fieldList = new ArrayList<>();
            DatabaseTableDTO rtable = new DatabaseTableDTO();
            while (rs.next()) {
                DataSetElementDTO databaseFieldDTO = new DataSetElementDTO();
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("COLUMN_TYPE");
                int startInd = columnType.indexOf("(");
                String columnTypeName = columnType.toLowerCase();
                if (startInd > 0) {
                    columnTypeName = columnType.substring(0, startInd);
                }

                //目前支持的所有字段类型
                Map<String, ShareDbColumnType> allType = typeService.getAllShareDbColumnType();
                ShareDbColumnType shareDbColumnType = allType.get(columnTypeName);
                if (shareDbColumnType == null) {
                    String msg = "字段:" + columnName + " 的类型:" + columnTypeName + "当前还不支持";
                    rtable.setMsg(msg);
                    return rtable;
                }
                Integer precision;
                Integer scale = null;
                if (startInd > 0) {
                    int idouIndex = columnType.indexOf(",");
                    if (idouIndex > 0) {
                        precision = Integer.parseInt(columnType.substring(startInd + 1, idouIndex));
                        scale = Integer.parseInt(columnType.substring(idouIndex + 1, columnType.length() - 1));
                    } else {
                        precision = Integer.parseInt(columnType.substring(startInd + 1, columnType.length() - 1));
                    }
                    databaseFieldDTO.setPrecision(precision);
                    databaseFieldDTO.setScale(scale);
                }


                String columnComment = rs.getString("COLUMN_COMMENT");

                databaseFieldDTO.setFieldCode(columnName);
                databaseFieldDTO.setFieldName(columnComment);
                databaseFieldDTO.setFieldType(shareDbColumnType.getMysqlType());
                fieldList.add(databaseFieldDTO);
            }
            rtable.setTableName(table);
            rtable.setFieldList(fieldList);

            rs.close();
            stmt.close();

            return rtable;
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
}

