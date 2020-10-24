package com.hengyunsoft.platform.ops.repository.fault.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaultManageExample extends com.hengyunsoft.db.example.BaseExample<FaultManageExample.Criteria> implements Serializable {
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

        public Criteria andFaultNameIsNull() {
            addCriterion("fault_name is null");
            return (Criteria) this;
        }

        public Criteria andFaultNameIsNotNull() {
            addCriterion("fault_name is not null");
            return (Criteria) this;
        }

        public Criteria andFaultNameEqualTo(String value) {
            addCriterion("fault_name =", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameNotEqualTo(String value) {
            addCriterion("fault_name <>", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameGreaterThan(String value) {
            addCriterion("fault_name >", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameGreaterThanOrEqualTo(String value) {
            addCriterion("fault_name >=", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameLessThan(String value) {
            addCriterion("fault_name <", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameLessThanOrEqualTo(String value) {
            addCriterion("fault_name <=", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameLike(String value) {
            addCriterion("fault_name like", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameNotLike(String value) {
            addCriterion("fault_name not like", value, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_name in", values, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_name not in", values, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameBetween(String value1, String value2) {
            addCriterion("fault_name between", value1, value2, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultNameNotBetween(String value1, String value2) {
            addCriterion("fault_name not between", value1, value2, "faultName");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNull() {
            addCriterion("fault_type is null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNotNull() {
            addCriterion("fault_type is not null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeEqualTo(String value) {
            addCriterion("fault_type =", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotEqualTo(String value) {
            addCriterion("fault_type <>", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThan(String value) {
            addCriterion("fault_type >", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_type >=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThan(String value) {
            addCriterion("fault_type <", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThanOrEqualTo(String value) {
            addCriterion("fault_type <=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLike(String value) {
            addCriterion("fault_type like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotLike(String value) {
            addCriterion("fault_type not like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_type in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_type not in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeBetween(String value1, String value2) {
            addCriterion("fault_type between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotBetween(String value1, String value2) {
            addCriterion("fault_type not between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIsNull() {
            addCriterion("fault_level is null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIsNotNull() {
            addCriterion("fault_level is not null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelEqualTo(String value) {
            addCriterion("fault_level =", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotEqualTo(String value) {
            addCriterion("fault_level <>", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelGreaterThan(String value) {
            addCriterion("fault_level >", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelGreaterThanOrEqualTo(String value) {
            addCriterion("fault_level >=", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLessThan(String value) {
            addCriterion("fault_level <", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLessThanOrEqualTo(String value) {
            addCriterion("fault_level <=", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLike(String value) {
            addCriterion("fault_level like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotLike(String value) {
            addCriterion("fault_level not like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_level in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_level not in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelBetween(String value1, String value2) {
            addCriterion("fault_level between", value1, value2, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotBetween(String value1, String value2) {
            addCriterion("fault_level not between", value1, value2, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(java.util.List<java.lang.String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("system_name is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("system_name is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("system_name =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("system_name <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("system_name >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("system_name >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("system_name <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("system_name <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("system_name like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("system_name not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(java.util.List<java.lang.String> values) {
            addCriterion("system_name in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("system_name not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("system_name between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("system_name not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andFaultHostIsNull() {
            addCriterion("fault_host is null");
            return (Criteria) this;
        }

        public Criteria andFaultHostIsNotNull() {
            addCriterion("fault_host is not null");
            return (Criteria) this;
        }

        public Criteria andFaultHostEqualTo(String value) {
            addCriterion("fault_host =", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostNotEqualTo(String value) {
            addCriterion("fault_host <>", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostGreaterThan(String value) {
            addCriterion("fault_host >", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostGreaterThanOrEqualTo(String value) {
            addCriterion("fault_host >=", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostLessThan(String value) {
            addCriterion("fault_host <", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostLessThanOrEqualTo(String value) {
            addCriterion("fault_host <=", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostLike(String value) {
            addCriterion("fault_host like", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostNotLike(String value) {
            addCriterion("fault_host not like", value, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_host in", values, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_host not in", values, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostBetween(String value1, String value2) {
            addCriterion("fault_host between", value1, value2, "faultHost");
            return (Criteria) this;
        }

        public Criteria andFaultHostNotBetween(String value1, String value2) {
            addCriterion("fault_host not between", value1, value2, "faultHost");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNull() {
            addCriterion("happen_time is null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNotNull() {
            addCriterion("happen_time is not null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeEqualTo(Date value) {
            addCriterion("happen_time =", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotEqualTo(Date value) {
            addCriterion("happen_time <>", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThan(Date value) {
            addCriterion("happen_time >", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("happen_time >=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThan(Date value) {
            addCriterion("happen_time <", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThanOrEqualTo(Date value) {
            addCriterion("happen_time <=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("happen_time in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("happen_time not in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeBetween(Date value1, Date value2) {
            addCriterion("happen_time between", value1, value2, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotBetween(Date value1, Date value2) {
            addCriterion("happen_time not between", value1, value2, "happenTime");
            return (Criteria) this;
        }

        public Criteria andFaultInfoIsNull() {
            addCriterion("fault_info is null");
            return (Criteria) this;
        }

        public Criteria andFaultInfoIsNotNull() {
            addCriterion("fault_info is not null");
            return (Criteria) this;
        }

        public Criteria andFaultInfoEqualTo(String value) {
            addCriterion("fault_info =", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoNotEqualTo(String value) {
            addCriterion("fault_info <>", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoGreaterThan(String value) {
            addCriterion("fault_info >", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoGreaterThanOrEqualTo(String value) {
            addCriterion("fault_info >=", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoLessThan(String value) {
            addCriterion("fault_info <", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoLessThanOrEqualTo(String value) {
            addCriterion("fault_info <=", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoLike(String value) {
            addCriterion("fault_info like", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoNotLike(String value) {
            addCriterion("fault_info not like", value, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_info in", values, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_info not in", values, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoBetween(String value1, String value2) {
            addCriterion("fault_info between", value1, value2, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andFaultInfoNotBetween(String value1, String value2) {
            addCriterion("fault_info not between", value1, value2, "faultInfo");
            return (Criteria) this;
        }

        public Criteria andIsTrueIsNull() {
            addCriterion("is_true is null");
            return (Criteria) this;
        }

        public Criteria andIsTrueIsNotNull() {
            addCriterion("is_true is not null");
            return (Criteria) this;
        }

        public Criteria andIsTrueEqualTo(String value) {
            addCriterion("is_true =", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotEqualTo(String value) {
            addCriterion("is_true <>", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueGreaterThan(String value) {
            addCriterion("is_true >", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueGreaterThanOrEqualTo(String value) {
            addCriterion("is_true >=", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLessThan(String value) {
            addCriterion("is_true <", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLessThanOrEqualTo(String value) {
            addCriterion("is_true <=", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLike(String value) {
            addCriterion("is_true like", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotLike(String value) {
            addCriterion("is_true not like", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueIn(java.util.List<java.lang.String> values) {
            addCriterion("is_true in", values, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_true not in", values, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueBetween(String value1, String value2) {
            addCriterion("is_true between", value1, value2, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotBetween(String value1, String value2) {
            addCriterion("is_true not between", value1, value2, "isTrue");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNull() {
            addCriterion("deal_opinion is null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNotNull() {
            addCriterion("deal_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionEqualTo(String value) {
            addCriterion("deal_opinion =", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotEqualTo(String value) {
            addCriterion("deal_opinion <>", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThan(String value) {
            addCriterion("deal_opinion >", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("deal_opinion >=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThan(String value) {
            addCriterion("deal_opinion <", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThanOrEqualTo(String value) {
            addCriterion("deal_opinion <=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLike(String value) {
            addCriterion("deal_opinion like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotLike(String value) {
            addCriterion("deal_opinion not like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_opinion in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_opinion not in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionBetween(String value1, String value2) {
            addCriterion("deal_opinion between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotBetween(String value1, String value2) {
            addCriterion("deal_opinion not between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealProcessIsNull() {
            addCriterion("deal_process is null");
            return (Criteria) this;
        }

        public Criteria andDealProcessIsNotNull() {
            addCriterion("deal_process is not null");
            return (Criteria) this;
        }

        public Criteria andDealProcessEqualTo(String value) {
            addCriterion("deal_process =", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessNotEqualTo(String value) {
            addCriterion("deal_process <>", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessGreaterThan(String value) {
            addCriterion("deal_process >", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessGreaterThanOrEqualTo(String value) {
            addCriterion("deal_process >=", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessLessThan(String value) {
            addCriterion("deal_process <", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessLessThanOrEqualTo(String value) {
            addCriterion("deal_process <=", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessLike(String value) {
            addCriterion("deal_process like", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessNotLike(String value) {
            addCriterion("deal_process not like", value, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_process in", values, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessNotIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_process not in", values, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessBetween(String value1, String value2) {
            addCriterion("deal_process between", value1, value2, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andDealProcessNotBetween(String value1, String value2) {
            addCriterion("deal_process not between", value1, value2, "dealProcess");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(java.util.List<java.lang.String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(java.util.List<java.lang.String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(java.util.List<java.lang.String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeIsNull() {
            addCriterion("is_join_knowledge is null");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeIsNotNull() {
            addCriterion("is_join_knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeEqualTo(Integer value) {
            addCriterion("is_join_knowledge =", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeNotEqualTo(Integer value) {
            addCriterion("is_join_knowledge <>", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeGreaterThan(Integer value) {
            addCriterion("is_join_knowledge >", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_join_knowledge >=", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeLessThan(Integer value) {
            addCriterion("is_join_knowledge <", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeLessThanOrEqualTo(Integer value) {
            addCriterion("is_join_knowledge <=", value, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_join_knowledge in", values, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_join_knowledge not in", values, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeBetween(Integer value1, Integer value2) {
            addCriterion("is_join_knowledge between", value1, value2, "isJoinKnowledge");
            return (Criteria) this;
        }

        public Criteria andIsJoinKnowledgeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_join_knowledge not between", value1, value2, "isJoinKnowledge");
            return (Criteria) this;
        }
    }

    /**
    b_yw_fault_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}