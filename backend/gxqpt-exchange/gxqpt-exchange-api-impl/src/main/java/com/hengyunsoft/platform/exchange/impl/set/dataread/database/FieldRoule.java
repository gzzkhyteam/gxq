package com.hengyunsoft.platform.exchange.impl.set.dataread.database;

/***
 * 字段参数规则
 */
public enum FieldRoule {
    ///筛选规则:1,大于；2，小于；3，等于；4，模糊
    more(1, ">") {
        @Override
        public String getAndSql(String value) {
            return " > '" + value + "' ";
        }
    },
    less(2, "<") {
        @Override
        public String getAndSql(String value) {
            return " < '" + value + "' ";
        }
    },
    equal(3, "=") {
        @Override
        public String getAndSql(String value) {
            return " = '" + value + "' ";
        }
    },
    like(4, "like") {
        @Override
        public String getAndSql(String value) {
            return " LIKE '%" + value + "%'" + " ";
        }
    },
    lessOrEqual(5, "<=") {
        @Override
        public String getAndSql(String value) {
            return " <=  '" + value + "' ";
        }
    },//小于等于
    moreOrEqual(6, ">=") {
        @Override
        public String getAndSql(String value) {
            return " >= '" + value + "' ";
        }
    },//大于等于
    ;


    /**
     * id
     */
    public final int id;
    /**
     * 运算符
     */
    public final String operator;

    FieldRoule(int id, String operator) {
        this.id = id;
        this.operator = operator;
    }

    /***
     * 得到查询的 and 语句
     * @param value
     * @return
     */
    public abstract String getAndSql(String value);

    public static FieldRoule getFieldRouleById(int id) {
        FieldRoule fr = null;
        for (FieldRoule f : values()) {
            if (f.id == id) {
                fr = f;
                break;
            }
        }
        return fr;
    }
}
