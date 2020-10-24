package com.hengyunsoft.platform.exchange.repository.set.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShareDbColumnTypeExample extends com.hengyunsoft.db.example.BaseExample<ShareDbColumnTypeExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeIsNull() {
            addCriterion("mysql_type is null");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeIsNotNull() {
            addCriterion("mysql_type is not null");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeEqualTo(String value) {
            addCriterion("mysql_type =", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeNotEqualTo(String value) {
            addCriterion("mysql_type <>", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeGreaterThan(String value) {
            addCriterion("mysql_type >", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mysql_type >=", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeLessThan(String value) {
            addCriterion("mysql_type <", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeLessThanOrEqualTo(String value) {
            addCriterion("mysql_type <=", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeLike(String value) {
            addCriterion("mysql_type like", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeNotLike(String value) {
            addCriterion("mysql_type not like", value, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("mysql_type in", values, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mysql_type not in", values, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeBetween(String value1, String value2) {
            addCriterion("mysql_type between", value1, value2, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andMysqlTypeNotBetween(String value1, String value2) {
            addCriterion("mysql_type not between", value1, value2, "mysqlType");
            return (Criteria) this;
        }

        public Criteria andIsLengthIsNull() {
            addCriterion("is_length is null");
            return (Criteria) this;
        }

        public Criteria andIsLengthIsNotNull() {
            addCriterion("is_length is not null");
            return (Criteria) this;
        }

        public Criteria andIsLengthEqualTo(Integer value) {
            addCriterion("is_length =", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthNotEqualTo(Integer value) {
            addCriterion("is_length <>", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthGreaterThan(Integer value) {
            addCriterion("is_length >", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_length >=", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthLessThan(Integer value) {
            addCriterion("is_length <", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthLessThanOrEqualTo(Integer value) {
            addCriterion("is_length <=", value, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_length in", values, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_length not in", values, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthBetween(Integer value1, Integer value2) {
            addCriterion("is_length between", value1, value2, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("is_length not between", value1, value2, "isLength");
            return (Criteria) this;
        }

        public Criteria andIsScaleIsNull() {
            addCriterion("is_scale is null");
            return (Criteria) this;
        }

        public Criteria andIsScaleIsNotNull() {
            addCriterion("is_scale is not null");
            return (Criteria) this;
        }

        public Criteria andIsScaleEqualTo(Integer value) {
            addCriterion("is_scale =", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotEqualTo(Integer value) {
            addCriterion("is_scale <>", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleGreaterThan(Integer value) {
            addCriterion("is_scale >", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_scale >=", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleLessThan(Integer value) {
            addCriterion("is_scale <", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleLessThanOrEqualTo(Integer value) {
            addCriterion("is_scale <=", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_scale in", values, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_scale not in", values, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleBetween(Integer value1, Integer value2) {
            addCriterion("is_scale between", value1, value2, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_scale not between", value1, value2, "isScale");
            return (Criteria) this;
        }
    }

    /**
    b_share_db_column_typeaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}