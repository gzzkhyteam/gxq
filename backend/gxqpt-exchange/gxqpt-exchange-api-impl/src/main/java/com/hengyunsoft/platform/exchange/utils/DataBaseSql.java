package com.hengyunsoft.platform.exchange.utils;

import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.AbsDatabase;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.MySqlDatabase;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("jdbc")
@Component
@Slf4j
/***
 * 数据仓库执行工具类
 */
public class DataBaseSql {
    //配置文件 读取jdbc的配置文件
    //private static Connection conn;
    // private static PreparedStatement ps;
    private static String ip;
    private static String port;
    private static String userName;
    private static String pwd;
    private static String dbName;

    /***
     * 得到数据集过度表名称
     * @return
     */
    public static String getOverTableName() {
        String tableName = ShareUtil.automaticCode("data_croe");
        tableName = "over_" + tableName;
        return tableName;
    }

    /***
     * 从过度表名解析出正式表名称
     * @param overTableName
     * @return
     */
    public static String getFormalTableName(String overTableName) {
        int over_ = overTableName.indexOf("_");
        return overTableName.substring(over_ + 1);
    }

    /***
     * 得到本地数据集对象
     * @return
     * @throws Exception
     */
    public static AbsDatabase createLocalMySqlDatabase() throws Exception {
        AbsDatabase adb = new MySqlDatabase(ip, port, dbName, userName, pwd);
        return adb;
    }

    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection conn = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");
            StringBuffer url = new StringBuffer("jdbc:mysql");
            url.append("://");
            url.append(ip);
            url.append(":");
            url.append(port);
            url.append("/");
            url.append(dbName);
            url.append("?useUnicode=true&characterEncoding=utf-8");
            String urls = url.toString();
         /*   String urls = "jdbc:mysql://192.168.1.211:3306/create_table_test?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(urls, "root", "r!o@o#t$>?.123");*/
            conn = DriverManager.getConnection(urls, userName, pwd);
        } catch (Exception e) {
            log.error("数据仓库连接失败", e);
        }
        return conn;  //返回所建立的数据库连接
    }

    /***
     * 建表
     * @param tabName 表名称
     * @param tabComment 表注释
     * @param connection
     * @throws Exception
     */
    public static void createTable(String tabName, String tabComment, Connection connection) throws Exception {
        try {
            String sqlSave = "create table " + tabName + "( `synctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT  '数据插入时间'," +
                    " `key_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '校验字段主键', PRIMARY KEY (`key_id`)) DEFAULT CHARSET=utf8mb4 COMMENT='" + tabComment + "'";
            System.out.println("建表语句是：" + sqlSave);
            PreparedStatement ps = connection.prepareStatement(sqlSave);
            ps.executeUpdate(sqlSave);
            ps.close();
        } catch (SQLException e) {
            log.error("数据仓库连接失败", e);
            throw new Exception(e);
        } finally {

        }
    }

    /***
     * 添加表字段
     * @param tabName
     * @param tabField
     * @param conn
     * @return 是否成功
     * @throws Exception
     */
    public static boolean alterTableAdd(String tabName, DataSetElementDTO tabField, Connection conn) {
        try {
            String sqlAdd = "alter table " + tabName + " add ( ";
            //添加字段
            sqlAdd += "`" + tabField.getFieldCode() + "` " + tabField.getHasLengthFieldType()
                    + " COMMENT  '" + tabField.getFieldName() + "' ";
            sqlAdd += " ) ";
            log.info("新增表字段语句是：" + sqlAdd);
            PreparedStatement ps = conn.prepareStatement(sqlAdd);
            ps.executeUpdate(sqlAdd);
            ps.close();
            return true;
        } catch (Exception e) {
            log.error("新增表字段失败", e);
            return false;
        }
    }


    /***
     *刪除字段
     * @param tabName
     * @param tabField
     * @param conn
     * @return 是否成功
     */
    public static boolean dropTableElement(String tabName, DataSetElementDTO tabField, Connection conn) {
        try {
            String sqlDelete = "alter table " + tabName;
            sqlDelete += " drop column " + "`" + tabField.getFieldCode() + "` ";
            log.info("删除表字段语句是：" + sqlDelete);
            PreparedStatement ps = conn.prepareStatement(sqlDelete);
            ps.executeUpdate(sqlDelete);
            ps.close();
            return true;
        } catch (SQLException e) {
            log.error("建删除表字段语句失败", e);
            return false;
        }
    }

    /***
     *  修改字段
     * @param tabName
     * @param oldField
     * @param nowField
     * @param conn
     * @return 是否成功
     */
    public static boolean alterModify(String tabName, DataSetElementDTO oldField, DataSetElementDTO nowField, Connection conn) {
        //修改字段alter table over_data_croe180913154506 change column `newname` `newname` varchar(200);
        try {
            log.info("修改表{}的字段{}",tabName,nowField.getFieldCode());
            String sqlUpdate = "alter table " + tabName + " change column  " + "`"
                    + oldField.getFieldCode() + "`" + "  `" + nowField.getFieldCode() + "`  " + nowField.getHasLengthFieldType();
            log.info("修改表字段语句是：" + sqlUpdate);
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.executeUpdate(sqlUpdate);
            ps.close();
            return true;
        } catch (SQLException e) {
            log.error("修改表字段失败", e);
            return false;
        }
    }

    /**
     * 判断表是否存在
     *
     * @param tabName
     * @return
     */
    public static boolean exitTable(String tabName, Connection conn) throws Exception {
        boolean flag = false;
        try {
            ResultSet rs = conn.getMetaData().getTables(null, null, tabName, null);
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {

        }
        return flag;
    }

    /**
     * 删除数据表
     * 如果执行成功则返回false
     *
     * @param tabName
     * @return
     */
    public static boolean dropTable(String tabName, Connection conn) throws Exception {
        boolean flag = true;
        // 是否存在
        Boolean bool = exitTable(tabName, conn);
        try {
            if (bool) {
                String sql = "drop table " + tabName + " ";
                //预处理SQL 防止注入
                PreparedStatement ps = conn.prepareStatement(sql);
                //执行
                flag = ps.execute();
                //关闭流
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("删除数据失败" + e.getMessage());
        } finally {

        }
        return flag;
    }

    protected static String getGetTableFieldSqlStr(String table) {
        return "SELECT\n" +
                "\tc.COLUMN_NAME,\n" +
                "\tc.COLUMN_COMMENT,\n" +
                "\tc.COLUMN_TYPE\n" +
                "FROM\n" +
                "\tINFORMATION_SCHEMA. COLUMNS c\n" +
                "WHERE c.`TABLE_SCHEMA` = '" + dbName + "'AND c.`TABLE_NAME` = '" + table + "';";
    }

    public static DatabaseTableDTO getTableInfo(String table) throws Exception {
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
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("COLUMN_TYPE");
                String columnComment = rs.getString("COLUMN_COMMENT");
                //Class<?> typeClass = JdbcType2JaveType.jdbcTypeToJavaType(columnType);
                DataSetElementDTO databaseFieldDTO = new DataSetElementDTO();
                databaseFieldDTO.setFieldCode(columnName);
                databaseFieldDTO.setFieldName(columnComment);
                databaseFieldDTO.setFieldType(columnType);
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

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        //建表===========================================
        //表名
     /*  String tabName = "tabletset";
       List<ShareDataElement> elements=new ArrayList<>();*/
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
