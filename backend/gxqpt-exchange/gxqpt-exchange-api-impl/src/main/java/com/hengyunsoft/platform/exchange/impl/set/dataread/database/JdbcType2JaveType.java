package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/***
 * sql类型和jdbc类型
 */
@Slf4j
public class JdbcType2JaveType {
    private static Map<String, Integer> jdbcTypes; // Name to value
    private static Map<Integer, String> valueNames;//
    private static Map<Integer, Class<?>> jdbcJavaTypes; // jdbc type to java type

    static {
        jdbcTypes = new HashMap<>();
        jdbcJavaTypes = new HashMap<>();
        valueNames = new HashMap<>();
        Field[] fields = Types.class.getFields();
        for (int i = 0, len = fields.length; i < len; ++i) {
            if (Modifier.isStatic(fields[i].getModifiers())) {
                try {
                    String name = fields[i].getName();
                    Integer value = (Integer) fields[i].get(Types.class);
                    jdbcTypes.put(name, value);
                    valueNames.put(value, name);
                } catch (Exception e) {
                    log.error("", e);
                }
            }
        }
        //补充Types没有的类型 NUMBER
        jdbcTypes.put("INT", Types.INTEGER);
        jdbcTypes.put("NUMBER", Types.BIGINT);
        // 初始化jdbcJavaTypes：

        jdbcJavaTypes.put(Integer.valueOf(Types.LONGNVARCHAR), String.class);  // -16 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.NCHAR), String.class);    // -15 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.NVARCHAR), String.class);   // -9 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.ROWID), String.class);    // -8 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.BIT), Boolean.class);    // -7 布尔
        jdbcJavaTypes.put(Integer.valueOf(Types.TINYINT), Byte.class);    // -6 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.BIGINT), Long.class);    // -5 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.LONGVARBINARY), Blob.class);  // -4 二进制
        jdbcJavaTypes.put(Integer.valueOf(Types.VARBINARY), Blob.class);   // -3 二进制
        jdbcJavaTypes.put(Integer.valueOf(Types.BINARY), Blob.class);    // -2 二进制
        jdbcJavaTypes.put(Integer.valueOf(Types.LONGVARCHAR), String.class);  // -1 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.NULL), String.class);    // 0 /

        jdbcJavaTypes.put(Integer.valueOf(Types.VARCHAR), String.class);    // 1 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.CHAR), String.class);    // 1 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.NUMERIC), BigDecimal.class);  // 2 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.DECIMAL), BigDecimal.class);  // 3 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.INTEGER), Integer.class);   // 4 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.SMALLINT), Short.class);   // 5 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.FLOAT), BigDecimal.class);   // 6 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.REAL), BigDecimal.class);   // 7 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.DOUBLE), BigDecimal.class);  // 8 数字
        jdbcJavaTypes.put(Integer.valueOf(Types.VARCHAR), String.class);   // 12 字符串
        jdbcJavaTypes.put(Integer.valueOf(Types.BOOLEAN), Boolean.class);   // 16 布尔

        jdbcJavaTypes.put(Integer.valueOf(Types.DATALINK), String.class);   // 70 /

        jdbcJavaTypes.put(Integer.valueOf(Types.DATE), Date.class);    // 91 日期
        jdbcJavaTypes.put(Integer.valueOf(Types.TIME), Date.class);    // 92 日期
        jdbcJavaTypes.put(Integer.valueOf(Types.TIMESTAMP), Date.class);   // 93 日期
        jdbcJavaTypes.put(Integer.valueOf(Types.OTHER), Object.class);    // 1111 其他类型？
        //  jdbcJavaTypes.put(Integer.valueOf(Types.JAVA_OBJECT), Object.class);  // 2000
        //  jdbcJavaTypes.put(Integer.valueOf(Types.DISTINCT), String.class);   // 2001
        //  jdbcJavaTypes.put(Integer.valueOf(Types.STRUCT), String.class);   // 2002
        //  jdbcJavaTypes.put(Integer.valueOf(Types.ARRAY), String.class);    // 2003
        jdbcJavaTypes.put(Integer.valueOf(Types.BLOB), Blob.class);    // 2004 二进制
        jdbcJavaTypes.put(Integer.valueOf(Types.CLOB), Clob.class);    // 2005 大文本
        //  jdbcJavaTypes.put(Integer.valueOf(Types.REF), String.class);    // 2006
        //  jdbcJavaTypes.put(Integer.valueOf(Types.SQLXML), String.class);   // 2009
        jdbcJavaTypes.put(Integer.valueOf(Types.NCLOB), Clob.class);    // 2011 大文本
    }

    /**
     * 根据jdbcTypename类型名称获得对应的java类型,如果找不到就报错
     *
     * @param jdbcTypeName
     * @return
     */
    public static Class<?> jdbcTypeToJavaType(String jdbcTypeName) throws Exception {
        for (Map.Entry<String, Integer> en : jdbcTypes.entrySet()) {
            String upperCase = jdbcTypeName.toUpperCase();
            if (upperCase.indexOf(en.getKey()) > -1) {
                return jdbcJavaTypes.get(en.getValue());
            }
        }
        throw new Exception("该数据库类型:" + jdbcTypeName + " 找不到对应的JDBC类型");
    }

    /***
     * 根据jdbc type的value得到type的name
     * @param jdbcType
     * @return
     */
    public static String getNameByJdbcType(int jdbcType) {
        return valueNames.get(jdbcType);
    }

    public static boolean isJavaNumberType(int jdbcType) {
        Class<?> type = jdbcJavaTypes.get(jdbcType);
        return (type == null) ? false : (Number.class.isAssignableFrom(type)) ? true : false;
    }

}
