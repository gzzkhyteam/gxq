package com.hengyunsoft.platform.modular.repository.modular.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModularLogExample extends com.hengyunsoft.db.example.BaseExample<ModularLogExample.Criteria> implements Serializable {
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

        public Criteria andModularIdIsNull() {
            addCriterion("modular_id is null");
            return (Criteria) this;
        }

        public Criteria andModularIdIsNotNull() {
            addCriterion("modular_id is not null");
            return (Criteria) this;
        }

        public Criteria andModularIdEqualTo(Long value) {
            addCriterion("modular_id =", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotEqualTo(Long value) {
            addCriterion("modular_id <>", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThan(Long value) {
            addCriterion("modular_id >", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThanOrEqualTo(Long value) {
            addCriterion("modular_id >=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThan(Long value) {
            addCriterion("modular_id <", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThanOrEqualTo(Long value) {
            addCriterion("modular_id <=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("modular_id in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("modular_id not in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdBetween(Long value1, Long value2) {
            addCriterion("modular_id between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotBetween(Long value1, Long value2) {
            addCriterion("modular_id not between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(java.util.List<java.lang.String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
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

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Integer value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Integer value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Integer value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Integer value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Integer value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Integer value1, Integer value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeIsNull() {
            addCriterion("time_consume is null");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeIsNotNull() {
            addCriterion("time_consume is not null");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeEqualTo(Integer value) {
            addCriterion("time_consume =", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeNotEqualTo(Integer value) {
            addCriterion("time_consume <>", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeGreaterThan(Integer value) {
            addCriterion("time_consume >", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_consume >=", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeLessThan(Integer value) {
            addCriterion("time_consume <", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeLessThanOrEqualTo(Integer value) {
            addCriterion("time_consume <=", value, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("time_consume in", values, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("time_consume not in", values, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeBetween(Integer value1, Integer value2) {
            addCriterion("time_consume between", value1, value2, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andTimeConsumeNotBetween(Integer value1, Integer value2) {
            addCriterion("time_consume not between", value1, value2, "timeConsume");
            return (Criteria) this;
        }

        public Criteria andOriginaLogIsNull() {
            addCriterion("origina_log is null");
            return (Criteria) this;
        }

        public Criteria andOriginaLogIsNotNull() {
            addCriterion("origina_log is not null");
            return (Criteria) this;
        }

        public Criteria andOriginaLogEqualTo(String value) {
            addCriterion("origina_log =", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogNotEqualTo(String value) {
            addCriterion("origina_log <>", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogGreaterThan(String value) {
            addCriterion("origina_log >", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogGreaterThanOrEqualTo(String value) {
            addCriterion("origina_log >=", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogLessThan(String value) {
            addCriterion("origina_log <", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogLessThanOrEqualTo(String value) {
            addCriterion("origina_log <=", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogLike(String value) {
            addCriterion("origina_log like", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogNotLike(String value) {
            addCriterion("origina_log not like", value, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogIn(java.util.List<java.lang.String> values) {
            addCriterion("origina_log in", values, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogNotIn(java.util.List<java.lang.String> values) {
            addCriterion("origina_log not in", values, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogBetween(String value1, String value2) {
            addCriterion("origina_log between", value1, value2, "originaLog");
            return (Criteria) this;
        }

        public Criteria andOriginaLogNotBetween(String value1, String value2) {
            addCriterion("origina_log not between", value1, value2, "originaLog");
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
    }

    /**
    modular_logaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}