package com.hengyunsoft.platform.exchange.repository.set.example;

import java.io.Serializable;
import java.util.Date;

public class ShareDbSourceExample extends com.hengyunsoft.db.example.BaseExample<ShareDbSourceExample.Criteria> implements Serializable {
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

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("unit_id like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("unit_id not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNull() {
            addCriterion("source_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNotNull() {
            addCriterion("source_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNameEqualTo(String value) {
            addCriterion("source_name =", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotEqualTo(String value) {
            addCriterion("source_name <>", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThan(String value) {
            addCriterion("source_name >", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_name >=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThan(String value) {
            addCriterion("source_name <", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThanOrEqualTo(String value) {
            addCriterion("source_name <=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLike(String value) {
            addCriterion("source_name like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotLike(String value) {
            addCriterion("source_name not like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameIn(java.util.List<java.lang.String> values) {
            addCriterion("source_name in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("source_name not in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameBetween(String value1, String value2) {
            addCriterion("source_name between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotBetween(String value1, String value2) {
            addCriterion("source_name not between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andDbNameIsNull() {
            addCriterion("db_name is null");
            return (Criteria) this;
        }

        public Criteria andDbNameIsNotNull() {
            addCriterion("db_name is not null");
            return (Criteria) this;
        }

        public Criteria andDbNameEqualTo(String value) {
            addCriterion("db_name =", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameNotEqualTo(String value) {
            addCriterion("db_name <>", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameGreaterThan(String value) {
            addCriterion("db_name >", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("db_name >=", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameLessThan(String value) {
            addCriterion("db_name <", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameLessThanOrEqualTo(String value) {
            addCriterion("db_name <=", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameLike(String value) {
            addCriterion("db_name like", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameNotLike(String value) {
            addCriterion("db_name not like", value, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameIn(java.util.List<java.lang.String> values) {
            addCriterion("db_name in", values, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_name not in", values, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameBetween(String value1, String value2) {
            addCriterion("db_name between", value1, value2, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbNameNotBetween(String value1, String value2) {
            addCriterion("db_name not between", value1, value2, "dbName");
            return (Criteria) this;
        }

        public Criteria andDbPortIsNull() {
            addCriterion("db_port is null");
            return (Criteria) this;
        }

        public Criteria andDbPortIsNotNull() {
            addCriterion("db_port is not null");
            return (Criteria) this;
        }

        public Criteria andDbPortEqualTo(String value) {
            addCriterion("db_port =", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotEqualTo(String value) {
            addCriterion("db_port <>", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortGreaterThan(String value) {
            addCriterion("db_port >", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortGreaterThanOrEqualTo(String value) {
            addCriterion("db_port >=", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLessThan(String value) {
            addCriterion("db_port <", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLessThanOrEqualTo(String value) {
            addCriterion("db_port <=", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortLike(String value) {
            addCriterion("db_port like", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotLike(String value) {
            addCriterion("db_port not like", value, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortIn(java.util.List<java.lang.String> values) {
            addCriterion("db_port in", values, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_port not in", values, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortBetween(String value1, String value2) {
            addCriterion("db_port between", value1, value2, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbPortNotBetween(String value1, String value2) {
            addCriterion("db_port not between", value1, value2, "dbPort");
            return (Criteria) this;
        }

        public Criteria andDbAddressIsNull() {
            addCriterion("db_address is null");
            return (Criteria) this;
        }

        public Criteria andDbAddressIsNotNull() {
            addCriterion("db_address is not null");
            return (Criteria) this;
        }

        public Criteria andDbAddressEqualTo(String value) {
            addCriterion("db_address =", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressNotEqualTo(String value) {
            addCriterion("db_address <>", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressGreaterThan(String value) {
            addCriterion("db_address >", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressGreaterThanOrEqualTo(String value) {
            addCriterion("db_address >=", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressLessThan(String value) {
            addCriterion("db_address <", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressLessThanOrEqualTo(String value) {
            addCriterion("db_address <=", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressLike(String value) {
            addCriterion("db_address like", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressNotLike(String value) {
            addCriterion("db_address not like", value, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("db_address in", values, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_address not in", values, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressBetween(String value1, String value2) {
            addCriterion("db_address between", value1, value2, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andDbAddressNotBetween(String value1, String value2) {
            addCriterion("db_address not between", value1, value2, "dbAddress");
            return (Criteria) this;
        }

        public Criteria andContTypeIsNull() {
            addCriterion("cont_type is null");
            return (Criteria) this;
        }

        public Criteria andContTypeIsNotNull() {
            addCriterion("cont_type is not null");
            return (Criteria) this;
        }

        public Criteria andContTypeEqualTo(Integer value) {
            addCriterion("cont_type =", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeNotEqualTo(Integer value) {
            addCriterion("cont_type <>", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeGreaterThan(Integer value) {
            addCriterion("cont_type >", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cont_type >=", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeLessThan(Integer value) {
            addCriterion("cont_type <", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cont_type <=", value, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cont_type in", values, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cont_type not in", values, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeBetween(Integer value1, Integer value2) {
            addCriterion("cont_type between", value1, value2, "contType");
            return (Criteria) this;
        }

        public Criteria andContTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cont_type not between", value1, value2, "contType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNull() {
            addCriterion("db_type is null");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNotNull() {
            addCriterion("db_type is not null");
            return (Criteria) this;
        }

        public Criteria andDbTypeEqualTo(Integer value) {
            addCriterion("db_type =", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotEqualTo(Integer value) {
            addCriterion("db_type <>", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThan(Integer value) {
            addCriterion("db_type >", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_type >=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThan(Integer value) {
            addCriterion("db_type <", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThanOrEqualTo(Integer value) {
            addCriterion("db_type <=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("db_type in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("db_type not in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeBetween(Integer value1, Integer value2) {
            addCriterion("db_type between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("db_type not between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNull() {
            addCriterion("server_type is null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNotNull() {
            addCriterion("server_type is not null");
            return (Criteria) this;
        }

        public Criteria andServerTypeEqualTo(Integer value) {
            addCriterion("server_type =", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotEqualTo(Integer value) {
            addCriterion("server_type <>", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThan(Integer value) {
            addCriterion("server_type >", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_type >=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThan(Integer value) {
            addCriterion("server_type <", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("server_type <=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("server_type in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("server_type not in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeBetween(Integer value1, Integer value2) {
            addCriterion("server_type between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("server_type not between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andDbAccountIsNull() {
            addCriterion("db_account is null");
            return (Criteria) this;
        }

        public Criteria andDbAccountIsNotNull() {
            addCriterion("db_account is not null");
            return (Criteria) this;
        }

        public Criteria andDbAccountEqualTo(String value) {
            addCriterion("db_account =", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountNotEqualTo(String value) {
            addCriterion("db_account <>", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountGreaterThan(String value) {
            addCriterion("db_account >", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountGreaterThanOrEqualTo(String value) {
            addCriterion("db_account >=", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountLessThan(String value) {
            addCriterion("db_account <", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountLessThanOrEqualTo(String value) {
            addCriterion("db_account <=", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountLike(String value) {
            addCriterion("db_account like", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountNotLike(String value) {
            addCriterion("db_account not like", value, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountIn(java.util.List<java.lang.String> values) {
            addCriterion("db_account in", values, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_account not in", values, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountBetween(String value1, String value2) {
            addCriterion("db_account between", value1, value2, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbAccountNotBetween(String value1, String value2) {
            addCriterion("db_account not between", value1, value2, "dbAccount");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIsNull() {
            addCriterion("db_password is null");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIsNotNull() {
            addCriterion("db_password is not null");
            return (Criteria) this;
        }

        public Criteria andDbPasswordEqualTo(String value) {
            addCriterion("db_password =", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotEqualTo(String value) {
            addCriterion("db_password <>", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordGreaterThan(String value) {
            addCriterion("db_password >", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("db_password >=", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLessThan(String value) {
            addCriterion("db_password <", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLessThanOrEqualTo(String value) {
            addCriterion("db_password <=", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLike(String value) {
            addCriterion("db_password like", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotLike(String value) {
            addCriterion("db_password not like", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIn(java.util.List<java.lang.String> values) {
            addCriterion("db_password in", values, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_password not in", values, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordBetween(String value1, String value2) {
            addCriterion("db_password between", value1, value2, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotBetween(String value1, String value2) {
            addCriterion("db_password not between", value1, value2, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    /**
    b_share_db_sourceaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}