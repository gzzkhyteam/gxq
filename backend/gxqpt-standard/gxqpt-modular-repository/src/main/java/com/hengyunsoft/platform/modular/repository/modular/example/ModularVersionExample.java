package com.hengyunsoft.platform.modular.repository.modular.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModularVersionExample extends com.hengyunsoft.db.example.BaseExample<ModularVersionExample.Criteria> implements Serializable {
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

        public Criteria andRepNameIsNull() {
            addCriterion("rep_name is null");
            return (Criteria) this;
        }

        public Criteria andRepNameIsNotNull() {
            addCriterion("rep_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepNameEqualTo(String value) {
            addCriterion("rep_name =", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotEqualTo(String value) {
            addCriterion("rep_name <>", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameGreaterThan(String value) {
            addCriterion("rep_name >", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameGreaterThanOrEqualTo(String value) {
            addCriterion("rep_name >=", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLessThan(String value) {
            addCriterion("rep_name <", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLessThanOrEqualTo(String value) {
            addCriterion("rep_name <=", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLike(String value) {
            addCriterion("rep_name like", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotLike(String value) {
            addCriterion("rep_name not like", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameIn(java.util.List<java.lang.String> values) {
            addCriterion("rep_name in", values, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rep_name not in", values, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameBetween(String value1, String value2) {
            addCriterion("rep_name between", value1, value2, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotBetween(String value1, String value2) {
            addCriterion("rep_name not between", value1, value2, "repName");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(java.util.List<java.lang.String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdIsNull() {
            addCriterion("artifact_id is null");
            return (Criteria) this;
        }

        public Criteria andArtifactIdIsNotNull() {
            addCriterion("artifact_id is not null");
            return (Criteria) this;
        }

        public Criteria andArtifactIdEqualTo(String value) {
            addCriterion("artifact_id =", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdNotEqualTo(String value) {
            addCriterion("artifact_id <>", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdGreaterThan(String value) {
            addCriterion("artifact_id >", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdGreaterThanOrEqualTo(String value) {
            addCriterion("artifact_id >=", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdLessThan(String value) {
            addCriterion("artifact_id <", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdLessThanOrEqualTo(String value) {
            addCriterion("artifact_id <=", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdLike(String value) {
            addCriterion("artifact_id like", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdNotLike(String value) {
            addCriterion("artifact_id not like", value, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdIn(java.util.List<java.lang.String> values) {
            addCriterion("artifact_id in", values, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("artifact_id not in", values, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdBetween(String value1, String value2) {
            addCriterion("artifact_id between", value1, value2, "artifactId");
            return (Criteria) this;
        }

        public Criteria andArtifactIdNotBetween(String value1, String value2) {
            addCriterion("artifact_id not between", value1, value2, "artifactId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version_ is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version_ is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version_ =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version_ <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version_ >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version_ >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version_ <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version_ <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version_ like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version_ not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(java.util.List<java.lang.String> values) {
            addCriterion("version_ in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("version_ not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version_ between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version_ not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andClassifierIsNull() {
            addCriterion("classifier is null");
            return (Criteria) this;
        }

        public Criteria andClassifierIsNotNull() {
            addCriterion("classifier is not null");
            return (Criteria) this;
        }

        public Criteria andClassifierEqualTo(String value) {
            addCriterion("classifier =", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierNotEqualTo(String value) {
            addCriterion("classifier <>", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierGreaterThan(String value) {
            addCriterion("classifier >", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierGreaterThanOrEqualTo(String value) {
            addCriterion("classifier >=", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierLessThan(String value) {
            addCriterion("classifier <", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierLessThanOrEqualTo(String value) {
            addCriterion("classifier <=", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierLike(String value) {
            addCriterion("classifier like", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierNotLike(String value) {
            addCriterion("classifier not like", value, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierIn(java.util.List<java.lang.String> values) {
            addCriterion("classifier in", values, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierNotIn(java.util.List<java.lang.String> values) {
            addCriterion("classifier not in", values, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierBetween(String value1, String value2) {
            addCriterion("classifier between", value1, value2, "classifier");
            return (Criteria) this;
        }

        public Criteria andClassifierNotBetween(String value1, String value2) {
            addCriterion("classifier not between", value1, value2, "classifier");
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

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
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

        public Criteria andCreateCompanyIdIsNull() {
            addCriterion("create_company_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdIsNotNull() {
            addCriterion("create_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdEqualTo(Long value) {
            addCriterion("create_company_id =", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdNotEqualTo(Long value) {
            addCriterion("create_company_id <>", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdGreaterThan(Long value) {
            addCriterion("create_company_id >", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_company_id >=", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdLessThan(Long value) {
            addCriterion("create_company_id <", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("create_company_id <=", value, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_company_id in", values, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_company_id not in", values, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdBetween(Long value1, Long value2) {
            addCriterion("create_company_id between", value1, value2, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("create_company_id not between", value1, value2, "createCompanyId");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIsNull() {
            addCriterion("create_company_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIsNotNull() {
            addCriterion("create_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameEqualTo(String value) {
            addCriterion("create_company_name =", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotEqualTo(String value) {
            addCriterion("create_company_name <>", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameGreaterThan(String value) {
            addCriterion("create_company_name >", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_company_name >=", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLessThan(String value) {
            addCriterion("create_company_name <", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("create_company_name <=", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLike(String value) {
            addCriterion("create_company_name like", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotLike(String value) {
            addCriterion("create_company_name not like", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIn(java.util.List<java.lang.String> values) {
            addCriterion("create_company_name in", values, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_company_name not in", values, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameBetween(String value1, String value2) {
            addCriterion("create_company_name between", value1, value2, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotBetween(String value1, String value2) {
            addCriterion("create_company_name not between", value1, value2, "createCompanyName");
            return (Criteria) this;
        }
    }

    /**
    modular_versionaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}