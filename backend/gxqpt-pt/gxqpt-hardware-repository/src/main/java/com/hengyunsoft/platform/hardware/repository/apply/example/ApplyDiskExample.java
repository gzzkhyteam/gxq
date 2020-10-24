package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyDiskExample extends com.hengyunsoft.db.example.BaseExample<ApplyDiskExample.Criteria> implements Serializable {
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

        public Criteria andApplyServeridIsNull() {
            addCriterion("apply_serverid is null");
            return (Criteria) this;
        }

        public Criteria andApplyServeridIsNotNull() {
            addCriterion("apply_serverid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyServeridEqualTo(Long value) {
            addCriterion("apply_serverid =", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridNotEqualTo(Long value) {
            addCriterion("apply_serverid <>", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridGreaterThan(Long value) {
            addCriterion("apply_serverid >", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_serverid >=", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridLessThan(Long value) {
            addCriterion("apply_serverid <", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridLessThanOrEqualTo(Long value) {
            addCriterion("apply_serverid <=", value, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_serverid in", values, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_serverid not in", values, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridBetween(Long value1, Long value2) {
            addCriterion("apply_serverid between", value1, value2, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andApplyServeridNotBetween(Long value1, Long value2) {
            addCriterion("apply_serverid not between", value1, value2, "applyServerid");
            return (Criteria) this;
        }

        public Criteria andDiskTypeIsNull() {
            addCriterion("disk_type is null");
            return (Criteria) this;
        }

        public Criteria andDiskTypeIsNotNull() {
            addCriterion("disk_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiskTypeEqualTo(Integer value) {
            addCriterion("disk_type =", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotEqualTo(Integer value) {
            addCriterion("disk_type <>", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeGreaterThan(Integer value) {
            addCriterion("disk_type >", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("disk_type >=", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeLessThan(Integer value) {
            addCriterion("disk_type <", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("disk_type <=", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("disk_type in", values, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("disk_type not in", values, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeBetween(Integer value1, Integer value2) {
            addCriterion("disk_type between", value1, value2, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("disk_type not between", value1, value2, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIsNull() {
            addCriterion("disk_size is null");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIsNotNull() {
            addCriterion("disk_size is not null");
            return (Criteria) this;
        }

        public Criteria andDiskSizeEqualTo(Long value) {
            addCriterion("disk_size =", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotEqualTo(Long value) {
            addCriterion("disk_size <>", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeGreaterThan(Long value) {
            addCriterion("disk_size >", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("disk_size >=", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeLessThan(Long value) {
            addCriterion("disk_size <", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeLessThanOrEqualTo(Long value) {
            addCriterion("disk_size <=", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIn(java.util.List<java.lang.Long> values) {
            addCriterion("disk_size in", values, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("disk_size not in", values, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeBetween(Long value1, Long value2) {
            addCriterion("disk_size between", value1, value2, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotBetween(Long value1, Long value2) {
            addCriterion("disk_size not between", value1, value2, "diskSize");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
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
    }

    /**
    b_hd_apply_diskaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}