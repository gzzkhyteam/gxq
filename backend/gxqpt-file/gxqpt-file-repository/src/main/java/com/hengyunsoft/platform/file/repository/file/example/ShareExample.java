package com.hengyunsoft.platform.file.repository.file.example;

import java.io.Serializable;
import java.util.Date;

public class ShareExample extends com.hengyunsoft.db.example.BaseExample<ShareExample.Criteria> implements Serializable {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
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

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNull() {
            addCriterion("share_name is null");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNotNull() {
            addCriterion("share_name is not null");
            return (Criteria) this;
        }

        public Criteria andShareNameEqualTo(String value) {
            addCriterion("share_name =", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotEqualTo(String value) {
            addCriterion("share_name <>", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThan(String value) {
            addCriterion("share_name >", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThanOrEqualTo(String value) {
            addCriterion("share_name >=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThan(String value) {
            addCriterion("share_name <", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThanOrEqualTo(String value) {
            addCriterion("share_name <=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLike(String value) {
            addCriterion("share_name like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotLike(String value) {
            addCriterion("share_name not like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameIn(java.util.List<java.lang.String> values) {
            addCriterion("share_name in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("share_name not in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameBetween(String value1, String value2) {
            addCriterion("share_name between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotBetween(String value1, String value2) {
            addCriterion("share_name not between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andSharePasswordIsNull() {
            addCriterion("share_password is null");
            return (Criteria) this;
        }

        public Criteria andSharePasswordIsNotNull() {
            addCriterion("share_password is not null");
            return (Criteria) this;
        }

        public Criteria andSharePasswordEqualTo(String value) {
            addCriterion("share_password =", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotEqualTo(String value) {
            addCriterion("share_password <>", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordGreaterThan(String value) {
            addCriterion("share_password >", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("share_password >=", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordLessThan(String value) {
            addCriterion("share_password <", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordLessThanOrEqualTo(String value) {
            addCriterion("share_password <=", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordLike(String value) {
            addCriterion("share_password like", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotLike(String value) {
            addCriterion("share_password not like", value, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordIn(java.util.List<java.lang.String> values) {
            addCriterion("share_password in", values, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotIn(java.util.List<java.lang.String> values) {
            addCriterion("share_password not in", values, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordBetween(String value1, String value2) {
            addCriterion("share_password between", value1, value2, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotBetween(String value1, String value2) {
            addCriterion("share_password not between", value1, value2, "sharePassword");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(java.util.List<java.lang.String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(java.util.List<java.lang.String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
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

        public Criteria andDownloadTimesIsNull() {
            addCriterion("download_times is null");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesIsNotNull() {
            addCriterion("download_times is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesEqualTo(Integer value) {
            addCriterion("download_times =", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesNotEqualTo(Integer value) {
            addCriterion("download_times <>", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesGreaterThan(Integer value) {
            addCriterion("download_times >", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("download_times >=", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesLessThan(Integer value) {
            addCriterion("download_times <", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesLessThanOrEqualTo(Integer value) {
            addCriterion("download_times <=", value, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesIn(java.util.List<java.lang.Integer> values) {
            addCriterion("download_times in", values, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("download_times not in", values, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesBetween(Integer value1, Integer value2) {
            addCriterion("download_times between", value1, value2, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andDownloadTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("download_times not between", value1, value2, "downloadTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesIsNull() {
            addCriterion("save_times is null");
            return (Criteria) this;
        }

        public Criteria andSaveTimesIsNotNull() {
            addCriterion("save_times is not null");
            return (Criteria) this;
        }

        public Criteria andSaveTimesEqualTo(Integer value) {
            addCriterion("save_times =", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesNotEqualTo(Integer value) {
            addCriterion("save_times <>", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesGreaterThan(Integer value) {
            addCriterion("save_times >", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("save_times >=", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesLessThan(Integer value) {
            addCriterion("save_times <", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesLessThanOrEqualTo(Integer value) {
            addCriterion("save_times <=", value, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesIn(java.util.List<java.lang.Integer> values) {
            addCriterion("save_times in", values, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("save_times not in", values, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesBetween(Integer value1, Integer value2) {
            addCriterion("save_times between", value1, value2, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("save_times not between", value1, value2, "saveTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesIsNull() {
            addCriterion("brows_times is null");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesIsNotNull() {
            addCriterion("brows_times is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesEqualTo(Integer value) {
            addCriterion("brows_times =", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesNotEqualTo(Integer value) {
            addCriterion("brows_times <>", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesGreaterThan(Integer value) {
            addCriterion("brows_times >", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("brows_times >=", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesLessThan(Integer value) {
            addCriterion("brows_times <", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesLessThanOrEqualTo(Integer value) {
            addCriterion("brows_times <=", value, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesIn(java.util.List<java.lang.Integer> values) {
            addCriterion("brows_times in", values, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("brows_times not in", values, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesBetween(Integer value1, Integer value2) {
            addCriterion("brows_times between", value1, value2, "browsTimes");
            return (Criteria) this;
        }

        public Criteria andBrowsTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("brows_times not between", value1, value2, "browsTimes");
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
            addCriterion("create_user =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(Long value) {
            addCriterion("create_user like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(Long value) {
            addCriterion("create_user not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createName");
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
            addCriterion("update_user =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(Long value) {
            addCriterion("update_user like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(Long value) {
            addCriterion("update_user not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateName");
            return (Criteria) this;
        }
    }

    /**
    f_shareaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}