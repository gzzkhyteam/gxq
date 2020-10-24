package com.hengyunsoft.platform.hardware.repository.manage.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiskManageExample extends com.hengyunsoft.db.example.BaseExample<DiskManageExample.Criteria> implements Serializable {
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

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Long value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Long value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Long value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Long value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Long value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Long value1, Long value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Long value1, Long value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andDiskIdIsNull() {
            addCriterion("disk_id is null");
            return (Criteria) this;
        }

        public Criteria andDiskIdIsNotNull() {
            addCriterion("disk_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiskIdEqualTo(String value) {
            addCriterion("disk_id =", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdNotEqualTo(String value) {
            addCriterion("disk_id <>", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdGreaterThan(String value) {
            addCriterion("disk_id >", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdGreaterThanOrEqualTo(String value) {
            addCriterion("disk_id >=", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdLessThan(String value) {
            addCriterion("disk_id <", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdLessThanOrEqualTo(String value) {
            addCriterion("disk_id <=", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdLike(String value) {
            addCriterion("disk_id like", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdNotLike(String value) {
            addCriterion("disk_id not like", value, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_id in", values, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_id not in", values, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdBetween(String value1, String value2) {
            addCriterion("disk_id between", value1, value2, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskIdNotBetween(String value1, String value2) {
            addCriterion("disk_id not between", value1, value2, "diskId");
            return (Criteria) this;
        }

        public Criteria andDiskNameIsNull() {
            addCriterion("disk_name is null");
            return (Criteria) this;
        }

        public Criteria andDiskNameIsNotNull() {
            addCriterion("disk_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiskNameEqualTo(String value) {
            addCriterion("disk_name =", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotEqualTo(String value) {
            addCriterion("disk_name <>", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameGreaterThan(String value) {
            addCriterion("disk_name >", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameGreaterThanOrEqualTo(String value) {
            addCriterion("disk_name >=", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLessThan(String value) {
            addCriterion("disk_name <", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLessThanOrEqualTo(String value) {
            addCriterion("disk_name <=", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLike(String value) {
            addCriterion("disk_name like", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotLike(String value) {
            addCriterion("disk_name not like", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_name in", values, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_name not in", values, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameBetween(String value1, String value2) {
            addCriterion("disk_name between", value1, value2, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotBetween(String value1, String value2) {
            addCriterion("disk_name not between", value1, value2, "diskName");
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

        public Criteria andDiskPathIsNull() {
            addCriterion("disk_path is null");
            return (Criteria) this;
        }

        public Criteria andDiskPathIsNotNull() {
            addCriterion("disk_path is not null");
            return (Criteria) this;
        }

        public Criteria andDiskPathEqualTo(String value) {
            addCriterion("disk_path =", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotEqualTo(String value) {
            addCriterion("disk_path <>", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathGreaterThan(String value) {
            addCriterion("disk_path >", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathGreaterThanOrEqualTo(String value) {
            addCriterion("disk_path >=", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLessThan(String value) {
            addCriterion("disk_path <", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLessThanOrEqualTo(String value) {
            addCriterion("disk_path <=", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLike(String value) {
            addCriterion("disk_path like", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotLike(String value) {
            addCriterion("disk_path not like", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_path in", values, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_path not in", values, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathBetween(String value1, String value2) {
            addCriterion("disk_path between", value1, value2, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotBetween(String value1, String value2) {
            addCriterion("disk_path not between", value1, value2, "diskPath");
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

        public Criteria andDiskTypeEqualTo(String value) {
            addCriterion("disk_type =", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotEqualTo(String value) {
            addCriterion("disk_type <>", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeGreaterThan(String value) {
            addCriterion("disk_type >", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("disk_type >=", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeLessThan(String value) {
            addCriterion("disk_type <", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeLessThanOrEqualTo(String value) {
            addCriterion("disk_type <=", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeLike(String value) {
            addCriterion("disk_type like", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotLike(String value) {
            addCriterion("disk_type not like", value, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_type in", values, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_type not in", values, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeBetween(String value1, String value2) {
            addCriterion("disk_type between", value1, value2, "diskType");
            return (Criteria) this;
        }

        public Criteria andDiskTypeNotBetween(String value1, String value2) {
            addCriterion("disk_type not between", value1, value2, "diskType");
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
    b_hd_disk_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}