package com.hengyunsoft.platform.mt.repository.app.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationExample extends com.hengyunsoft.db.example.BaseExample<ApplicationExample.Criteria> implements Serializable {
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

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Integer value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Integer value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Integer value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Integer value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Integer value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Integer value1, Integer value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNull() {
            addCriterion("show_url is null");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNotNull() {
            addCriterion("show_url is not null");
            return (Criteria) this;
        }

        public Criteria andShowUrlEqualTo(String value) {
            addCriterion("show_url =", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotEqualTo(String value) {
            addCriterion("show_url <>", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThan(String value) {
            addCriterion("show_url >", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThanOrEqualTo(String value) {
            addCriterion("show_url >=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThan(String value) {
            addCriterion("show_url <", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThanOrEqualTo(String value) {
            addCriterion("show_url <=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLike(String value) {
            addCriterion("show_url like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotLike(String value) {
            addCriterion("show_url not like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("show_url in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("show_url not in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlBetween(String value1, String value2) {
            addCriterion("show_url between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotBetween(String value1, String value2) {
            addCriterion("show_url not between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andIconPathIsNull() {
            addCriterion("icon_path is null");
            return (Criteria) this;
        }

        public Criteria andIconPathIsNotNull() {
            addCriterion("icon_path is not null");
            return (Criteria) this;
        }

        public Criteria andIconPathEqualTo(String value) {
            addCriterion("icon_path =", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotEqualTo(String value) {
            addCriterion("icon_path <>", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathGreaterThan(String value) {
            addCriterion("icon_path >", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathGreaterThanOrEqualTo(String value) {
            addCriterion("icon_path >=", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLessThan(String value) {
            addCriterion("icon_path <", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLessThanOrEqualTo(String value) {
            addCriterion("icon_path <=", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLike(String value) {
            addCriterion("icon_path like", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotLike(String value) {
            addCriterion("icon_path not like", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathIn(java.util.List<java.lang.String> values) {
            addCriterion("icon_path in", values, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("icon_path not in", values, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathBetween(String value1, String value2) {
            addCriterion("icon_path between", value1, value2, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotBetween(String value1, String value2) {
            addCriterion("icon_path not between", value1, value2, "iconPath");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andAppPathIsNull() {
            addCriterion("app_path is null");
            return (Criteria) this;
        }

        public Criteria andAppPathIsNotNull() {
            addCriterion("app_path is not null");
            return (Criteria) this;
        }

        public Criteria andAppPathEqualTo(String value) {
            addCriterion("app_path =", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotEqualTo(String value) {
            addCriterion("app_path <>", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathGreaterThan(String value) {
            addCriterion("app_path >", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathGreaterThanOrEqualTo(String value) {
            addCriterion("app_path >=", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLessThan(String value) {
            addCriterion("app_path <", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLessThanOrEqualTo(String value) {
            addCriterion("app_path <=", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLike(String value) {
            addCriterion("app_path like", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotLike(String value) {
            addCriterion("app_path not like", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathIn(java.util.List<java.lang.String> values) {
            addCriterion("app_path in", values, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_path not in", values, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathBetween(String value1, String value2) {
            addCriterion("app_path between", value1, value2, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotBetween(String value1, String value2) {
            addCriterion("app_path not between", value1, value2, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppDescIsNull() {
            addCriterion("app_desc is null");
            return (Criteria) this;
        }

        public Criteria andAppDescIsNotNull() {
            addCriterion("app_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAppDescEqualTo(String value) {
            addCriterion("app_desc =", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotEqualTo(String value) {
            addCriterion("app_desc <>", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescGreaterThan(String value) {
            addCriterion("app_desc >", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescGreaterThanOrEqualTo(String value) {
            addCriterion("app_desc >=", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLessThan(String value) {
            addCriterion("app_desc <", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLessThanOrEqualTo(String value) {
            addCriterion("app_desc <=", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLike(String value) {
            addCriterion("app_desc like", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotLike(String value) {
            addCriterion("app_desc not like", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescIn(java.util.List<java.lang.String> values) {
            addCriterion("app_desc in", values, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_desc not in", values, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescBetween(String value1, String value2) {
            addCriterion("app_desc between", value1, value2, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotBetween(String value1, String value2) {
            addCriterion("app_desc not between", value1, value2, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameIsNull() {
            addCriterion("app_package_name is null");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameIsNotNull() {
            addCriterion("app_package_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameEqualTo(String value) {
            addCriterion("app_package_name =", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameNotEqualTo(String value) {
            addCriterion("app_package_name <>", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameGreaterThan(String value) {
            addCriterion("app_package_name >", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_package_name >=", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameLessThan(String value) {
            addCriterion("app_package_name <", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameLessThanOrEqualTo(String value) {
            addCriterion("app_package_name <=", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameLike(String value) {
            addCriterion("app_package_name like", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameNotLike(String value) {
            addCriterion("app_package_name not like", value, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameIn(java.util.List<java.lang.String> values) {
            addCriterion("app_package_name in", values, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_package_name not in", values, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameBetween(String value1, String value2) {
            addCriterion("app_package_name between", value1, value2, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppPackageNameNotBetween(String value1, String value2) {
            addCriterion("app_package_name not between", value1, value2, "appPackageName");
            return (Criteria) this;
        }

        public Criteria andAppStartActIsNull() {
            addCriterion("app_start_act is null");
            return (Criteria) this;
        }

        public Criteria andAppStartActIsNotNull() {
            addCriterion("app_start_act is not null");
            return (Criteria) this;
        }

        public Criteria andAppStartActEqualTo(String value) {
            addCriterion("app_start_act =", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActNotEqualTo(String value) {
            addCriterion("app_start_act <>", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActGreaterThan(String value) {
            addCriterion("app_start_act >", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActGreaterThanOrEqualTo(String value) {
            addCriterion("app_start_act >=", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActLessThan(String value) {
            addCriterion("app_start_act <", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActLessThanOrEqualTo(String value) {
            addCriterion("app_start_act <=", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActLike(String value) {
            addCriterion("app_start_act like", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActNotLike(String value) {
            addCriterion("app_start_act not like", value, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActIn(java.util.List<java.lang.String> values) {
            addCriterion("app_start_act in", values, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_start_act not in", values, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActBetween(String value1, String value2) {
            addCriterion("app_start_act between", value1, value2, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andAppStartActNotBetween(String value1, String value2) {
            addCriterion("app_start_act not between", value1, value2, "appStartAct");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andAppOrderIsNull() {
            addCriterion("app_order is null");
            return (Criteria) this;
        }

        public Criteria andAppOrderIsNotNull() {
            addCriterion("app_order is not null");
            return (Criteria) this;
        }

        public Criteria andAppOrderEqualTo(Integer value) {
            addCriterion("app_order =", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderNotEqualTo(Integer value) {
            addCriterion("app_order <>", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderGreaterThan(Integer value) {
            addCriterion("app_order >", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_order >=", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderLessThan(Integer value) {
            addCriterion("app_order <", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderLessThanOrEqualTo(Integer value) {
            addCriterion("app_order <=", value, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderIn(java.util.List<java.lang.Integer> values) {
            addCriterion("app_order in", values, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("app_order not in", values, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderBetween(Integer value1, Integer value2) {
            addCriterion("app_order between", value1, value2, "appOrder");
            return (Criteria) this;
        }

        public Criteria andAppOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("app_order not between", value1, value2, "appOrder");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIsNull() {
            addCriterion("create_type is null");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIsNotNull() {
            addCriterion("create_type is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTypeEqualTo(Integer value) {
            addCriterion("create_type =", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotEqualTo(Integer value) {
            addCriterion("create_type <>", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeGreaterThan(Integer value) {
            addCriterion("create_type >", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_type >=", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeLessThan(Integer value) {
            addCriterion("create_type <", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("create_type <=", value, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("create_type in", values, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("create_type not in", values, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeBetween(Integer value1, Integer value2) {
            addCriterion("create_type between", value1, value2, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_type not between", value1, value2, "createType");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNull() {
            addCriterion("create_emp is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNotNull() {
            addCriterion("create_emp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpEqualTo(String value) {
            addCriterion("create_emp =", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotEqualTo(String value) {
            addCriterion("create_emp <>", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThan(String value) {
            addCriterion("create_emp >", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThanOrEqualTo(String value) {
            addCriterion("create_emp >=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThan(String value) {
            addCriterion("create_emp <", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThanOrEqualTo(String value) {
            addCriterion("create_emp <=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLike(String value) {
            addCriterion("create_emp like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotLike(String value) {
            addCriterion("create_emp not like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIn(java.util.List<java.lang.String> values) {
            addCriterion("create_emp in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_emp not in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpBetween(String value1, String value2) {
            addCriterion("create_emp between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotBetween(String value1, String value2) {
            addCriterion("create_emp not between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNull() {
            addCriterion("audit_user is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNotNull() {
            addCriterion("audit_user is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserEqualTo(Long value) {
            addCriterion("audit_user =", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotEqualTo(Long value) {
            addCriterion("audit_user <>", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThan(Long value) {
            addCriterion("audit_user >", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_user >=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThan(Long value) {
            addCriterion("audit_user <", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThanOrEqualTo(Long value) {
            addCriterion("audit_user <=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("audit_user in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("audit_user not in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserBetween(Long value1, Long value2) {
            addCriterion("audit_user between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotBetween(Long value1, Long value2) {
            addCriterion("audit_user not between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditContentIsNull() {
            addCriterion("audit_content is null");
            return (Criteria) this;
        }

        public Criteria andAuditContentIsNotNull() {
            addCriterion("audit_content is not null");
            return (Criteria) this;
        }

        public Criteria andAuditContentEqualTo(String value) {
            addCriterion("audit_content =", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotEqualTo(String value) {
            addCriterion("audit_content <>", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentGreaterThan(String value) {
            addCriterion("audit_content >", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_content >=", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLessThan(String value) {
            addCriterion("audit_content <", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLessThanOrEqualTo(String value) {
            addCriterion("audit_content <=", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLike(String value) {
            addCriterion("audit_content like", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotLike(String value) {
            addCriterion("audit_content not like", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_content in", values, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_content not in", values, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentBetween(String value1, String value2) {
            addCriterion("audit_content between", value1, value2, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotBetween(String value1, String value2) {
            addCriterion("audit_content not between", value1, value2, "auditContent");
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
    b_applicationaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}