package com.hengyunsoft.platform.exchange.repository.system.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareSystemExample extends com.hengyunsoft.db.example.BaseExample<ShareSystemExample.Criteria> implements Serializable {
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

        public Criteria andSysNameIsNull() {
            addCriterion("sys_name is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("sys_name =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("sys_name <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("sys_name >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_name >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("sys_name <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("sys_name <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("sys_name like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("sys_name not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_name in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_name not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("sys_name between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("sys_name not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andContractorIsNull() {
            addCriterion("contractor is null");
            return (Criteria) this;
        }

        public Criteria andContractorIsNotNull() {
            addCriterion("contractor is not null");
            return (Criteria) this;
        }

        public Criteria andContractorEqualTo(String value) {
            addCriterion("contractor =", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotEqualTo(String value) {
            addCriterion("contractor <>", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThan(String value) {
            addCriterion("contractor >", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThanOrEqualTo(String value) {
            addCriterion("contractor >=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThan(String value) {
            addCriterion("contractor <", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThanOrEqualTo(String value) {
            addCriterion("contractor <=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLike(String value) {
            addCriterion("contractor like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotLike(String value) {
            addCriterion("contractor not like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorIn(java.util.List<java.lang.String> values) {
            addCriterion("contractor in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotIn(java.util.List<java.lang.String> values) {
            addCriterion("contractor not in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorBetween(String value1, String value2) {
            addCriterion("contractor between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotBetween(String value1, String value2) {
            addCriterion("contractor not between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andContNameIsNull() {
            addCriterion("cont_name is null");
            return (Criteria) this;
        }

        public Criteria andContNameIsNotNull() {
            addCriterion("cont_name is not null");
            return (Criteria) this;
        }

        public Criteria andContNameEqualTo(String value) {
            addCriterion("cont_name =", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotEqualTo(String value) {
            addCriterion("cont_name <>", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThan(String value) {
            addCriterion("cont_name >", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThanOrEqualTo(String value) {
            addCriterion("cont_name >=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThan(String value) {
            addCriterion("cont_name <", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThanOrEqualTo(String value) {
            addCriterion("cont_name <=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLike(String value) {
            addCriterion("cont_name like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotLike(String value) {
            addCriterion("cont_name not like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameIn(java.util.List<java.lang.String> values) {
            addCriterion("cont_name in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cont_name not in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameBetween(String value1, String value2) {
            addCriterion("cont_name between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotBetween(String value1, String value2) {
            addCriterion("cont_name not between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andContTelIsNull() {
            addCriterion("cont_tel is null");
            return (Criteria) this;
        }

        public Criteria andContTelIsNotNull() {
            addCriterion("cont_tel is not null");
            return (Criteria) this;
        }

        public Criteria andContTelEqualTo(String value) {
            addCriterion("cont_tel =", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelNotEqualTo(String value) {
            addCriterion("cont_tel <>", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelGreaterThan(String value) {
            addCriterion("cont_tel >", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelGreaterThanOrEqualTo(String value) {
            addCriterion("cont_tel >=", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelLessThan(String value) {
            addCriterion("cont_tel <", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelLessThanOrEqualTo(String value) {
            addCriterion("cont_tel <=", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelLike(String value) {
            addCriterion("cont_tel like", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelNotLike(String value) {
            addCriterion("cont_tel not like", value, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelIn(java.util.List<java.lang.String> values) {
            addCriterion("cont_tel in", values, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cont_tel not in", values, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelBetween(String value1, String value2) {
            addCriterion("cont_tel between", value1, value2, "contTel");
            return (Criteria) this;
        }

        public Criteria andContTelNotBetween(String value1, String value2) {
            addCriterion("cont_tel not between", value1, value2, "contTel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUserReftIsNull() {
            addCriterion("user_reft is null");
            return (Criteria) this;
        }

        public Criteria andUserReftIsNotNull() {
            addCriterion("user_reft is not null");
            return (Criteria) this;
        }

        public Criteria andUserReftEqualTo(Integer value) {
            addCriterion("user_reft =", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftNotEqualTo(Integer value) {
            addCriterion("user_reft <>", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftGreaterThan(Integer value) {
            addCriterion("user_reft >", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_reft >=", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftLessThan(Integer value) {
            addCriterion("user_reft <", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftLessThanOrEqualTo(Integer value) {
            addCriterion("user_reft <=", value, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftIn(java.util.List<java.lang.Integer> values) {
            addCriterion("user_reft in", values, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("user_reft not in", values, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftBetween(Integer value1, Integer value2) {
            addCriterion("user_reft between", value1, value2, "userReft");
            return (Criteria) this;
        }

        public Criteria andUserReftNotBetween(Integer value1, Integer value2) {
            addCriterion("user_reft not between", value1, value2, "userReft");
            return (Criteria) this;
        }

        public Criteria andNetworkIsNull() {
            addCriterion("network is null");
            return (Criteria) this;
        }

        public Criteria andNetworkIsNotNull() {
            addCriterion("network is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkEqualTo(Integer value) {
            addCriterion("network =", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotEqualTo(Integer value) {
            addCriterion("network <>", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkGreaterThan(Integer value) {
            addCriterion("network >", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkGreaterThanOrEqualTo(Integer value) {
            addCriterion("network >=", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkLessThan(Integer value) {
            addCriterion("network <", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkLessThanOrEqualTo(Integer value) {
            addCriterion("network <=", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkIn(java.util.List<java.lang.Integer> values) {
            addCriterion("network in", values, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("network not in", values, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkBetween(Integer value1, Integer value2) {
            addCriterion("network between", value1, value2, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotBetween(Integer value1, Integer value2) {
            addCriterion("network not between", value1, value2, "network");
            return (Criteria) this;
        }

        public Criteria andHasKeyIsNull() {
            addCriterion("has_key is null");
            return (Criteria) this;
        }

        public Criteria andHasKeyIsNotNull() {
            addCriterion("has_key is not null");
            return (Criteria) this;
        }

        public Criteria andHasKeyEqualTo(Integer value) {
            addCriterion("has_key =", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyNotEqualTo(Integer value) {
            addCriterion("has_key <>", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyGreaterThan(Integer value) {
            addCriterion("has_key >", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_key >=", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyLessThan(Integer value) {
            addCriterion("has_key <", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyLessThanOrEqualTo(Integer value) {
            addCriterion("has_key <=", value, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_key in", values, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_key not in", values, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyBetween(Integer value1, Integer value2) {
            addCriterion("has_key between", value1, value2, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("has_key not between", value1, value2, "hasKey");
            return (Criteria) this;
        }

        public Criteria andHasVpnIsNull() {
            addCriterion("has_vpn is null");
            return (Criteria) this;
        }

        public Criteria andHasVpnIsNotNull() {
            addCriterion("has_vpn is not null");
            return (Criteria) this;
        }

        public Criteria andHasVpnEqualTo(Integer value) {
            addCriterion("has_vpn =", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnNotEqualTo(Integer value) {
            addCriterion("has_vpn <>", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnGreaterThan(Integer value) {
            addCriterion("has_vpn >", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_vpn >=", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnLessThan(Integer value) {
            addCriterion("has_vpn <", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnLessThanOrEqualTo(Integer value) {
            addCriterion("has_vpn <=", value, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_vpn in", values, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_vpn not in", values, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnBetween(Integer value1, Integer value2) {
            addCriterion("has_vpn between", value1, value2, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andHasVpnNotBetween(Integer value1, Integer value2) {
            addCriterion("has_vpn not between", value1, value2, "hasVpn");
            return (Criteria) this;
        }

        public Criteria andSysArchIsNull() {
            addCriterion("sys_arch is null");
            return (Criteria) this;
        }

        public Criteria andSysArchIsNotNull() {
            addCriterion("sys_arch is not null");
            return (Criteria) this;
        }

        public Criteria andSysArchEqualTo(Integer value) {
            addCriterion("sys_arch =", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchNotEqualTo(Integer value) {
            addCriterion("sys_arch <>", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchGreaterThan(Integer value) {
            addCriterion("sys_arch >", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_arch >=", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchLessThan(Integer value) {
            addCriterion("sys_arch <", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchLessThanOrEqualTo(Integer value) {
            addCriterion("sys_arch <=", value, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sys_arch in", values, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sys_arch not in", values, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchBetween(Integer value1, Integer value2) {
            addCriterion("sys_arch between", value1, value2, "sysArch");
            return (Criteria) this;
        }

        public Criteria andSysArchNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_arch not between", value1, value2, "sysArch");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(java.util.List<java.lang.String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(java.util.List<java.lang.String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(java.util.List<java.lang.String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkIsNull() {
            addCriterion("lange_frwork is null");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkIsNotNull() {
            addCriterion("lange_frwork is not null");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkEqualTo(String value) {
            addCriterion("lange_frwork =", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkNotEqualTo(String value) {
            addCriterion("lange_frwork <>", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkGreaterThan(String value) {
            addCriterion("lange_frwork >", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkGreaterThanOrEqualTo(String value) {
            addCriterion("lange_frwork >=", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkLessThan(String value) {
            addCriterion("lange_frwork <", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkLessThanOrEqualTo(String value) {
            addCriterion("lange_frwork <=", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkLike(String value) {
            addCriterion("lange_frwork like", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkNotLike(String value) {
            addCriterion("lange_frwork not like", value, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkIn(java.util.List<java.lang.String> values) {
            addCriterion("lange_frwork in", values, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lange_frwork not in", values, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkBetween(String value1, String value2) {
            addCriterion("lange_frwork between", value1, value2, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andLangeFrworkNotBetween(String value1, String value2) {
            addCriterion("lange_frwork not between", value1, value2, "langeFrwork");
            return (Criteria) this;
        }

        public Criteria andHasInstructionIsNull() {
            addCriterion("has_instruction is null");
            return (Criteria) this;
        }

        public Criteria andHasInstructionIsNotNull() {
            addCriterion("has_instruction is not null");
            return (Criteria) this;
        }

        public Criteria andHasInstructionEqualTo(Integer value) {
            addCriterion("has_instruction =", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionNotEqualTo(Integer value) {
            addCriterion("has_instruction <>", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionGreaterThan(Integer value) {
            addCriterion("has_instruction >", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_instruction >=", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionLessThan(Integer value) {
            addCriterion("has_instruction <", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionLessThanOrEqualTo(Integer value) {
            addCriterion("has_instruction <=", value, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_instruction in", values, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_instruction not in", values, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionBetween(Integer value1, Integer value2) {
            addCriterion("has_instruction between", value1, value2, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andHasInstructionNotBetween(Integer value1, Integer value2) {
            addCriterion("has_instruction not between", value1, value2, "hasInstruction");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventIsNull() {
            addCriterion("sys_run_envent is null");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventIsNotNull() {
            addCriterion("sys_run_envent is not null");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventEqualTo(String value) {
            addCriterion("sys_run_envent =", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventNotEqualTo(String value) {
            addCriterion("sys_run_envent <>", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventGreaterThan(String value) {
            addCriterion("sys_run_envent >", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventGreaterThanOrEqualTo(String value) {
            addCriterion("sys_run_envent >=", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventLessThan(String value) {
            addCriterion("sys_run_envent <", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventLessThanOrEqualTo(String value) {
            addCriterion("sys_run_envent <=", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventLike(String value) {
            addCriterion("sys_run_envent like", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventNotLike(String value) {
            addCriterion("sys_run_envent not like", value, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_run_envent in", values, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_run_envent not in", values, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventBetween(String value1, String value2) {
            addCriterion("sys_run_envent between", value1, value2, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andSysRunEnventNotBetween(String value1, String value2) {
            addCriterion("sys_run_envent not between", value1, value2, "sysRunEnvent");
            return (Criteria) this;
        }

        public Criteria andDataAddressIsNull() {
            addCriterion("data_address is null");
            return (Criteria) this;
        }

        public Criteria andDataAddressIsNotNull() {
            addCriterion("data_address is not null");
            return (Criteria) this;
        }

        public Criteria andDataAddressEqualTo(String value) {
            addCriterion("data_address =", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressNotEqualTo(String value) {
            addCriterion("data_address <>", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressGreaterThan(String value) {
            addCriterion("data_address >", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressGreaterThanOrEqualTo(String value) {
            addCriterion("data_address >=", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressLessThan(String value) {
            addCriterion("data_address <", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressLessThanOrEqualTo(String value) {
            addCriterion("data_address <=", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressLike(String value) {
            addCriterion("data_address like", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressNotLike(String value) {
            addCriterion("data_address not like", value, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("data_address in", values, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("data_address not in", values, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressBetween(String value1, String value2) {
            addCriterion("data_address between", value1, value2, "dataAddress");
            return (Criteria) this;
        }

        public Criteria andDataAddressNotBetween(String value1, String value2) {
            addCriterion("data_address not between", value1, value2, "dataAddress");
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

        public Criteria andDbTypeEqualTo(String value) {
            addCriterion("db_type =", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotEqualTo(String value) {
            addCriterion("db_type <>", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThan(String value) {
            addCriterion("db_type >", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("db_type >=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThan(String value) {
            addCriterion("db_type <", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThanOrEqualTo(String value) {
            addCriterion("db_type <=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLike(String value) {
            addCriterion("db_type like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotLike(String value) {
            addCriterion("db_type not like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("db_type in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_type not in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeBetween(String value1, String value2) {
            addCriterion("db_type between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotBetween(String value1, String value2) {
            addCriterion("db_type not between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNull() {
            addCriterion("data_count is null");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNotNull() {
            addCriterion("data_count is not null");
            return (Criteria) this;
        }

        public Criteria andDataCountEqualTo(Integer value) {
            addCriterion("data_count =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Integer value) {
            addCriterion("data_count <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Integer value) {
            addCriterion("data_count >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_count >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Integer value) {
            addCriterion("data_count <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Integer value) {
            addCriterion("data_count <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Integer value1, Integer value2) {
            addCriterion("data_count between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Integer value1, Integer value2) {
            addCriterion("data_count not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andHasDictIsNull() {
            addCriterion("has_dict is null");
            return (Criteria) this;
        }

        public Criteria andHasDictIsNotNull() {
            addCriterion("has_dict is not null");
            return (Criteria) this;
        }

        public Criteria andHasDictEqualTo(Integer value) {
            addCriterion("has_dict =", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictNotEqualTo(Integer value) {
            addCriterion("has_dict <>", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictGreaterThan(Integer value) {
            addCriterion("has_dict >", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_dict >=", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictLessThan(Integer value) {
            addCriterion("has_dict <", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictLessThanOrEqualTo(Integer value) {
            addCriterion("has_dict <=", value, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_dict in", values, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("has_dict not in", values, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictBetween(Integer value1, Integer value2) {
            addCriterion("has_dict between", value1, value2, "hasDict");
            return (Criteria) this;
        }

        public Criteria andHasDictNotBetween(Integer value1, Integer value2) {
            addCriterion("has_dict not between", value1, value2, "hasDict");
            return (Criteria) this;
        }

        public Criteria andShareChainIsNull() {
            addCriterion("share_chain is null");
            return (Criteria) this;
        }

        public Criteria andShareChainIsNotNull() {
            addCriterion("share_chain is not null");
            return (Criteria) this;
        }

        public Criteria andShareChainEqualTo(Integer value) {
            addCriterion("share_chain =", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainNotEqualTo(Integer value) {
            addCriterion("share_chain <>", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainGreaterThan(Integer value) {
            addCriterion("share_chain >", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_chain >=", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainLessThan(Integer value) {
            addCriterion("share_chain <", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainLessThanOrEqualTo(Integer value) {
            addCriterion("share_chain <=", value, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainIn(java.util.List<java.lang.Integer> values) {
            addCriterion("share_chain in", values, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("share_chain not in", values, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainBetween(Integer value1, Integer value2) {
            addCriterion("share_chain between", value1, value2, "shareChain");
            return (Criteria) this;
        }

        public Criteria andShareChainNotBetween(Integer value1, Integer value2) {
            addCriterion("share_chain not between", value1, value2, "shareChain");
            return (Criteria) this;
        }

        public Criteria andDataDemandIsNull() {
            addCriterion("data_demand is null");
            return (Criteria) this;
        }

        public Criteria andDataDemandIsNotNull() {
            addCriterion("data_demand is not null");
            return (Criteria) this;
        }

        public Criteria andDataDemandEqualTo(String value) {
            addCriterion("data_demand =", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandNotEqualTo(String value) {
            addCriterion("data_demand <>", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandGreaterThan(String value) {
            addCriterion("data_demand >", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandGreaterThanOrEqualTo(String value) {
            addCriterion("data_demand >=", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandLessThan(String value) {
            addCriterion("data_demand <", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandLessThanOrEqualTo(String value) {
            addCriterion("data_demand <=", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandLike(String value) {
            addCriterion("data_demand like", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandNotLike(String value) {
            addCriterion("data_demand not like", value, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandIn(java.util.List<java.lang.String> values) {
            addCriterion("data_demand in", values, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandNotIn(java.util.List<java.lang.String> values) {
            addCriterion("data_demand not in", values, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandBetween(String value1, String value2) {
            addCriterion("data_demand between", value1, value2, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andDataDemandNotBetween(String value1, String value2) {
            addCriterion("data_demand not between", value1, value2, "dataDemand");
            return (Criteria) this;
        }

        public Criteria andMajorDataIsNull() {
            addCriterion("major_data is null");
            return (Criteria) this;
        }

        public Criteria andMajorDataIsNotNull() {
            addCriterion("major_data is not null");
            return (Criteria) this;
        }

        public Criteria andMajorDataEqualTo(String value) {
            addCriterion("major_data =", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataNotEqualTo(String value) {
            addCriterion("major_data <>", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataGreaterThan(String value) {
            addCriterion("major_data >", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataGreaterThanOrEqualTo(String value) {
            addCriterion("major_data >=", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataLessThan(String value) {
            addCriterion("major_data <", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataLessThanOrEqualTo(String value) {
            addCriterion("major_data <=", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataLike(String value) {
            addCriterion("major_data like", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataNotLike(String value) {
            addCriterion("major_data not like", value, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataIn(java.util.List<java.lang.String> values) {
            addCriterion("major_data in", values, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataNotIn(java.util.List<java.lang.String> values) {
            addCriterion("major_data not in", values, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataBetween(String value1, String value2) {
            addCriterion("major_data between", value1, value2, "majorData");
            return (Criteria) this;
        }

        public Criteria andMajorDataNotBetween(String value1, String value2) {
            addCriterion("major_data not between", value1, value2, "majorData");
            return (Criteria) this;
        }

        public Criteria andSysPurposeIsNull() {
            addCriterion("sys_purpose is null");
            return (Criteria) this;
        }

        public Criteria andSysPurposeIsNotNull() {
            addCriterion("sys_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andSysPurposeEqualTo(String value) {
            addCriterion("sys_purpose =", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeNotEqualTo(String value) {
            addCriterion("sys_purpose <>", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeGreaterThan(String value) {
            addCriterion("sys_purpose >", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_purpose >=", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeLessThan(String value) {
            addCriterion("sys_purpose <", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeLessThanOrEqualTo(String value) {
            addCriterion("sys_purpose <=", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeLike(String value) {
            addCriterion("sys_purpose like", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeNotLike(String value) {
            addCriterion("sys_purpose not like", value, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_purpose in", values, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sys_purpose not in", values, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeBetween(String value1, String value2) {
            addCriterion("sys_purpose between", value1, value2, "sysPurpose");
            return (Criteria) this;
        }

        public Criteria andSysPurposeNotBetween(String value1, String value2) {
            addCriterion("sys_purpose not between", value1, value2, "sysPurpose");
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
    b_share_systemaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}