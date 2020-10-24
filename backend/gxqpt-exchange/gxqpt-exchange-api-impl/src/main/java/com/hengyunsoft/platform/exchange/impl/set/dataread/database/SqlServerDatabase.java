package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbColumnType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * sql数据库，由于现在的数据查询都是把数据拿到本地仓库之后才查询数据，
 * 现在只是那个表结构或者字段名称的时间需要执行sql，所有这里没有实现分页查询
 */
public class SqlServerDatabase extends MySqlDatabase {

    public SqlServerDatabase(String host, String port, String dbName, String userName, String password) throws Exception {
        super(host, port, dbName, userName, password);
    }

    @Override
    public String getdriverClassName() {
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    @Override
    protected String getUrl() {
        // String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
        //       "databaseName=AdventureWorks;user=MyUserName;password=*****;";
        StringBuffer url = new StringBuffer("jdbc:sqlserver://");
        url.append(host);
        url.append(":");
        url.append(port);
        url.append(";databaseName=");
        url.append(dbName);
        url.append(";");
        url.append("user=");
        url.append(userName);
        url.append(";");
        url.append("password=");
        url.append(password);
        return url.toString();
    }

    @Override
    public String getGetTableSqlStr() {
        String sql = " select s.name TABLE_NAME,s.name TABLE_COMMENT from sysobjects s  where xtype='U'";
//       String  initSql = "select T1.TABLE_NAME,T1.COLUMN_NAME,T1.DATA_TYPE COLUMN_TYPE,T2.COMMENTS TABLE_COMMENT,T3.COMMENTS COLUMN_COMMENT from user_tab_columns T1 " +
//                "   LEFT JOIN user_tab_comments T2 ON T1.TABLE_NAME = T2.TABLE_NAME " +
//                "   LEFT JOIN user_col_comments T3 ON T3.TABLE_NAME = T1.TABLE_NAME AND T3.COLUMN_NAME = T1.COLUMN_NAME";
        return sql;
    }

    @Override
    protected String getGetTableFieldSqlStr(String table) {
        String sql = "select a.name as COLUMN_NAME,b.name as COLUMN_TYPE,b.length,b.scale from syscolumns a,systypes b where a.id=object_id('" + table + "') and a.xtype=b.xtype";
        return sql;
    }

    @Override
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
                String columnTypeName = columnType;
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
                if (shareDbColumnType.getIsLength() > 0) {
                    precision = rs.getInt("length");
                    databaseFieldDTO.setPrecision(precision);
                }
                if (shareDbColumnType.getIsScale() > 0) {
                    scale = rs.getInt("scale");
                    databaseFieldDTO.setScale(scale);
                }
                databaseFieldDTO.setFieldCode(columnName);
                databaseFieldDTO.setFieldName(columnName);
                databaseFieldDTO.setFieldType(columnTypeName);
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

    @Override
    protected String pareseLimitSql(String sql, long nowPage, int pageSize) {
        //拿pageSize条数据，未实现分页查询
        //long srart = (nowPage - 1) * pageSize + 1;
        //long end = nowPage * pageSize;
        StringBuffer sb = new StringBuffer("select top ");
        sb.append(pageSize);
        sb.append(" *  ");
        sb.append("(");
        sb.append(sql);
        sb.append(")");
        return sb.toString();
    }
}
