package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

/***
 * oracle数据库
 */
public class OracleDatabase extends MySqlDatabase {
    public OracleDatabase(String userName, String dbName, String port, String password, String host) throws Exception {
        super(userName, dbName, port, password, host);
    }

    @Override
    public String getdriverClassName() {
        return "oracle.jdbc.OracleDriver";
    }

    @Override
    protected String getUrl() {
        StringBuffer url = new StringBuffer("jdbc:oracle:thin:@");
        url.append(host);
        url.append(":");
        url.append(port);
        url.append(":");
        url.append(dbName);
        return url.toString();
    }

    @Override
    public String getGetTableSqlStr() {
        String sql = " SELECT TABLE_NAME,COMMENTS TABLE_COMMENT FROM user_tab_comments";
//       String  initSql = "select T1.TABLE_NAME,T1.COLUMN_NAME,T1.DATA_TYPE COLUMN_TYPE,T2.COMMENTS TABLE_COMMENT,T3.COMMENTS COLUMN_COMMENT from user_tab_columns T1 " +
//                "   LEFT JOIN user_tab_comments T2 ON T1.TABLE_NAME = T2.TABLE_NAME " +
//                "   LEFT JOIN user_col_comments T3 ON T3.TABLE_NAME = T1.TABLE_NAME AND T3.COLUMN_NAME = T1.COLUMN_NAME";
        return sql;
    }

    @Override
    protected String getGetTableFieldSqlStr(String table) {
        String sql = "  SELECT uc.COLUMN_NAME,uc.DATA_TYPE COLUMN_TYPE,(SELECT UCC.COMMENTS FROM user_col_comments ucc WHERE ucc.COLUMN_NAME = uc.COLUMN_NAME  AND ucc.TABLE_NAME = uc.TABLE_NAME) " +
                "  COLUMN_COMMENT FROM user_tab_columns uc     where  uc.TABLE_NAME = '" + table + "'";
        return sql;
    }

    @Override
    protected String pareseLimitSql(String sql, long nowPage, int pageSize) {
        long srart = (nowPage - 1) * pageSize + 1;
        long end = nowPage * pageSize;
        //SELECT * FROM TEST1 WHERE  1=1 AND rownum  >= 1 AND  rownum < 5
        int whereIndex = sql.lastIndexOf("WHERE");
        if(whereIndex > 0) {
            return sql + " AND rownum  >= " + srart + " AND  rownum < " + end;
        }else{
            return sql + " WHERE 1=1 AND rownum  >= " + srart + " AND  rownum < " + end;
        }

    }
}
