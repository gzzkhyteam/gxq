package com.hengyunsoft.platform.supervise.repository.example;

import java.io.Serializable;
import java.util.Date;

public class DataStorageHistoryExample extends com.hengyunsoft.db.example.BaseExample<DataStorageHistoryExample.Criteria> implements Serializable {
    //------------- 手动新增字段，请写在此后面 -------------
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

        public Criteria andStorageIdIsNull() {
            addCriterion("storage_id is null");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("storage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorageIdEqualTo(Long value) {
            addCriterion("storage_id =", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThan(Long value) {
            addCriterion("storage_id >", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("storage_id >=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThan(Long value) {
            addCriterion("storage_id <", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(Long value) {
            addCriterion("storage_id <=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("storage_id in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("storage_id not in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdBetween(Long value1, Long value2) {
            addCriterion("storage_id between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumIsNull() {
            addCriterion("db_space_num is null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumIsNotNull() {
            addCriterion("db_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumEqualTo(Double value) {
            addCriterion("db_space_num =", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumGreaterThan(Double value) {
            addCriterion("db_space_num >", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("db_space_num >=", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumLessThan(Double value) {
            addCriterion("db_space_num <", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("db_space_num <=", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_num in", values, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_num not in", values, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumBetween(Double value1, Double value2) {
            addCriterion("db_space_num between", value1, value2, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIsNull() {
            addCriterion("log_space_num is null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIsNotNull() {
            addCriterion("log_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumEqualTo(Double value) {
            addCriterion("log_space_num =", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumGreaterThan(Double value) {
            addCriterion("log_space_num >", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("log_space_num >=", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumLessThan(Double value) {
            addCriterion("log_space_num <", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("log_space_num <=", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_num in", values, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_num not in", values, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumBetween(Double value1, Double value2) {
            addCriterion("log_space_num between", value1, value2, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIsNull() {
            addCriterion("file_space_num is null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIsNotNull() {
            addCriterion("file_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumEqualTo(Double value) {
            addCriterion("file_space_num =", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumGreaterThan(Double value) {
            addCriterion("file_space_num >", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("file_space_num >=", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumLessThan(Double value) {
            addCriterion("file_space_num <", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("file_space_num <=", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_num in", values, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_num not in", values, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumBetween(Double value1, Double value2) {
            addCriterion("file_space_num between", value1, value2, "fileSpaceNum");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
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

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
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

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
    b_data_storage_historyaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}