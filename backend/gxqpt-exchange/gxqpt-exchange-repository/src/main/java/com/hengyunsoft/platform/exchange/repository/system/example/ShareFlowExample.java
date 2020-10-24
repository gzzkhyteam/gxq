package com.hengyunsoft.platform.exchange.repository.system.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareFlowExample extends com.hengyunsoft.db.example.BaseExample<ShareFlowExample.Criteria> implements Serializable {
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

        public Criteria andProcNameIsNull() {
            addCriterion("proc_name is null");
            return (Criteria) this;
        }

        public Criteria andProcNameIsNotNull() {
            addCriterion("proc_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcNameEqualTo(String value) {
            addCriterion("proc_name =", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotEqualTo(String value) {
            addCriterion("proc_name <>", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThan(String value) {
            addCriterion("proc_name >", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThanOrEqualTo(String value) {
            addCriterion("proc_name >=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThan(String value) {
            addCriterion("proc_name <", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThanOrEqualTo(String value) {
            addCriterion("proc_name <=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLike(String value) {
            addCriterion("proc_name like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotLike(String value) {
            addCriterion("proc_name not like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameIn(java.util.List<java.lang.String> values) {
            addCriterion("proc_name in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("proc_name not in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameBetween(String value1, String value2) {
            addCriterion("proc_name between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotBetween(String value1, String value2) {
            addCriterion("proc_name not between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcCodeIsNull() {
            addCriterion("proc_code is null");
            return (Criteria) this;
        }

        public Criteria andProcCodeIsNotNull() {
            addCriterion("proc_code is not null");
            return (Criteria) this;
        }

        public Criteria andProcCodeEqualTo(String value) {
            addCriterion("proc_code =", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeNotEqualTo(String value) {
            addCriterion("proc_code <>", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeGreaterThan(String value) {
            addCriterion("proc_code >", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("proc_code >=", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeLessThan(String value) {
            addCriterion("proc_code <", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeLessThanOrEqualTo(String value) {
            addCriterion("proc_code <=", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeLike(String value) {
            addCriterion("proc_code like", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeNotLike(String value) {
            addCriterion("proc_code not like", value, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("proc_code in", values, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("proc_code not in", values, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeBetween(String value1, String value2) {
            addCriterion("proc_code between", value1, value2, "procCode");
            return (Criteria) this;
        }

        public Criteria andProcCodeNotBetween(String value1, String value2) {
            addCriterion("proc_code not between", value1, value2, "procCode");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(java.util.List<java.lang.String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNull() {
            addCriterion("node_code is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("node_code is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("node_code =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("node_code <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("node_code >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("node_code >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("node_code <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("node_code <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("node_code like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("node_code not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("node_code in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("node_code not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("node_code between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("node_code not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNull() {
            addCriterion("time_limit is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNotNull() {
            addCriterion("time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitEqualTo(Integer value) {
            addCriterion("time_limit =", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotEqualTo(Integer value) {
            addCriterion("time_limit <>", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThan(Integer value) {
            addCriterion("time_limit >", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_limit >=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThan(Integer value) {
            addCriterion("time_limit <", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("time_limit <=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIn(java.util.List<java.lang.Integer> values) {
            addCriterion("time_limit in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("time_limit not in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitBetween(Integer value1, Integer value2) {
            addCriterion("time_limit between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("time_limit not between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIsNull() {
            addCriterion("handle_role is null");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIsNotNull() {
            addCriterion("handle_role is not null");
            return (Criteria) this;
        }

        public Criteria andHandleRoleEqualTo(String value) {
            addCriterion("handle_role =", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotEqualTo(String value) {
            addCriterion("handle_role <>", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleGreaterThan(String value) {
            addCriterion("handle_role >", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleGreaterThanOrEqualTo(String value) {
            addCriterion("handle_role >=", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLessThan(String value) {
            addCriterion("handle_role <", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLessThanOrEqualTo(String value) {
            addCriterion("handle_role <=", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLike(String value) {
            addCriterion("handle_role like", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotLike(String value) {
            addCriterion("handle_role not like", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_role in", values, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_role not in", values, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleBetween(String value1, String value2) {
            addCriterion("handle_role between", value1, value2, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotBetween(String value1, String value2) {
            addCriterion("handle_role not between", value1, value2, "handleRole");
            return (Criteria) this;
        }

        public Criteria andMoreUserIsNull() {
            addCriterion("more_user is null");
            return (Criteria) this;
        }

        public Criteria andMoreUserIsNotNull() {
            addCriterion("more_user is not null");
            return (Criteria) this;
        }

        public Criteria andMoreUserEqualTo(Integer value) {
            addCriterion("more_user =", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserNotEqualTo(Integer value) {
            addCriterion("more_user <>", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserGreaterThan(Integer value) {
            addCriterion("more_user >", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("more_user >=", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserLessThan(Integer value) {
            addCriterion("more_user <", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserLessThanOrEqualTo(Integer value) {
            addCriterion("more_user <=", value, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserIn(java.util.List<java.lang.Integer> values) {
            addCriterion("more_user in", values, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("more_user not in", values, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserBetween(Integer value1, Integer value2) {
            addCriterion("more_user between", value1, value2, "moreUser");
            return (Criteria) this;
        }

        public Criteria andMoreUserNotBetween(Integer value1, Integer value2) {
            addCriterion("more_user not between", value1, value2, "moreUser");
            return (Criteria) this;
        }

        public Criteria andIndexNoIsNull() {
            addCriterion("index_no is null");
            return (Criteria) this;
        }

        public Criteria andIndexNoIsNotNull() {
            addCriterion("index_no is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNoEqualTo(Integer value) {
            addCriterion("index_no =", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotEqualTo(Integer value) {
            addCriterion("index_no <>", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoGreaterThan(Integer value) {
            addCriterion("index_no >", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_no >=", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoLessThan(Integer value) {
            addCriterion("index_no <", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoLessThanOrEqualTo(Integer value) {
            addCriterion("index_no <=", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoIn(java.util.List<java.lang.Integer> values) {
            addCriterion("index_no in", values, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("index_no not in", values, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoBetween(Integer value1, Integer value2) {
            addCriterion("index_no between", value1, value2, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotBetween(Integer value1, Integer value2) {
            addCriterion("index_no not between", value1, value2, "indexNo");
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
    b_share_flowaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}