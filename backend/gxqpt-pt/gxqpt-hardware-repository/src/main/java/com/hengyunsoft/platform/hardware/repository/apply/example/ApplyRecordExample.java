package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyRecordExample extends com.hengyunsoft.db.example.BaseExample<ApplyRecordExample.Criteria> implements Serializable {
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

        public Criteria andApplyKeyidIsNull() {
            addCriterion("apply_keyid is null");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidIsNotNull() {
            addCriterion("apply_keyid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidEqualTo(Long value) {
            addCriterion("apply_keyid =", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotEqualTo(Long value) {
            addCriterion("apply_keyid <>", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidGreaterThan(Long value) {
            addCriterion("apply_keyid >", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_keyid >=", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidLessThan(Long value) {
            addCriterion("apply_keyid <", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidLessThanOrEqualTo(Long value) {
            addCriterion("apply_keyid <=", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_keyid in", values, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_keyid not in", values, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidBetween(Long value1, Long value2) {
            addCriterion("apply_keyid between", value1, value2, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotBetween(Long value1, Long value2) {
            addCriterion("apply_keyid not between", value1, value2, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyUidIsNull() {
            addCriterion("apply_uid is null");
            return (Criteria) this;
        }

        public Criteria andApplyUidIsNotNull() {
            addCriterion("apply_uid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUidEqualTo(String value) {
            addCriterion("apply_uid =", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotEqualTo(String value) {
            addCriterion("apply_uid <>", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidGreaterThan(String value) {
            addCriterion("apply_uid >", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidGreaterThanOrEqualTo(String value) {
            addCriterion("apply_uid >=", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLessThan(String value) {
            addCriterion("apply_uid <", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLessThanOrEqualTo(String value) {
            addCriterion("apply_uid <=", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLike(String value) {
            addCriterion("apply_uid like", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotLike(String value) {
            addCriterion("apply_uid not like", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uid in", values, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uid not in", values, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidBetween(String value1, String value2) {
            addCriterion("apply_uid between", value1, value2, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotBetween(String value1, String value2) {
            addCriterion("apply_uid not between", value1, value2, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIsNull() {
            addCriterion("apply_uname is null");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIsNotNull() {
            addCriterion("apply_uname is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUnameEqualTo(String value) {
            addCriterion("apply_uname =", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotEqualTo(String value) {
            addCriterion("apply_uname <>", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameGreaterThan(String value) {
            addCriterion("apply_uname >", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_uname >=", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLessThan(String value) {
            addCriterion("apply_uname <", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLessThanOrEqualTo(String value) {
            addCriterion("apply_uname <=", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLike(String value) {
            addCriterion("apply_uname like", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotLike(String value) {
            addCriterion("apply_uname not like", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uname in", values, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uname not in", values, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameBetween(String value1, String value2) {
            addCriterion("apply_uname between", value1, value2, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotBetween(String value1, String value2) {
            addCriterion("apply_uname not between", value1, value2, "applyUname");
            return (Criteria) this;
        }

        public Criteria andPassFlagIsNull() {
            addCriterion("pass_flag is null");
            return (Criteria) this;
        }

        public Criteria andPassFlagIsNotNull() {
            addCriterion("pass_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPassFlagEqualTo(String value) {
            addCriterion("pass_flag =", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagNotEqualTo(String value) {
            addCriterion("pass_flag <>", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagGreaterThan(String value) {
            addCriterion("pass_flag >", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagGreaterThanOrEqualTo(String value) {
            addCriterion("pass_flag >=", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagLessThan(String value) {
            addCriterion("pass_flag <", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagLessThanOrEqualTo(String value) {
            addCriterion("pass_flag <=", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagLike(String value) {
            addCriterion("pass_flag like", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagNotLike(String value) {
            addCriterion("pass_flag not like", value, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagIn(java.util.List<java.lang.String> values) {
            addCriterion("pass_flag in", values, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagNotIn(java.util.List<java.lang.String> values) {
            addCriterion("pass_flag not in", values, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagBetween(String value1, String value2) {
            addCriterion("pass_flag between", value1, value2, "passFlag");
            return (Criteria) this;
        }

        public Criteria andPassFlagNotBetween(String value1, String value2) {
            addCriterion("pass_flag not between", value1, value2, "passFlag");
            return (Criteria) this;
        }

        public Criteria andApprOpinionIsNull() {
            addCriterion("appr_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprOpinionIsNotNull() {
            addCriterion("appr_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprOpinionEqualTo(String value) {
            addCriterion("appr_opinion =", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionNotEqualTo(String value) {
            addCriterion("appr_opinion <>", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionGreaterThan(String value) {
            addCriterion("appr_opinion >", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("appr_opinion >=", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionLessThan(String value) {
            addCriterion("appr_opinion <", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionLessThanOrEqualTo(String value) {
            addCriterion("appr_opinion <=", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionLike(String value) {
            addCriterion("appr_opinion like", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionNotLike(String value) {
            addCriterion("appr_opinion not like", value, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_opinion in", values, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_opinion not in", values, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionBetween(String value1, String value2) {
            addCriterion("appr_opinion between", value1, value2, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andApprOpinionNotBetween(String value1, String value2) {
            addCriterion("appr_opinion not between", value1, value2, "apprOpinion");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNull() {
            addCriterion("step_code is null");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNotNull() {
            addCriterion("step_code is not null");
            return (Criteria) this;
        }

        public Criteria andStepCodeEqualTo(String value) {
            addCriterion("step_code =", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotEqualTo(String value) {
            addCriterion("step_code <>", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThan(String value) {
            addCriterion("step_code >", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("step_code >=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThan(String value) {
            addCriterion("step_code <", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThanOrEqualTo(String value) {
            addCriterion("step_code <=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLike(String value) {
            addCriterion("step_code like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotLike(String value) {
            addCriterion("step_code not like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("step_code in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("step_code not in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeBetween(String value1, String value2) {
            addCriterion("step_code between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotBetween(String value1, String value2) {
            addCriterion("step_code not between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(java.util.List<java.lang.String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andScodeIsNull() {
            addCriterion("scode is null");
            return (Criteria) this;
        }

        public Criteria andScodeIsNotNull() {
            addCriterion("scode is not null");
            return (Criteria) this;
        }

        public Criteria andScodeEqualTo(String value) {
            addCriterion("scode =", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotEqualTo(String value) {
            addCriterion("scode <>", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeGreaterThan(String value) {
            addCriterion("scode >", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeGreaterThanOrEqualTo(String value) {
            addCriterion("scode >=", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLessThan(String value) {
            addCriterion("scode <", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLessThanOrEqualTo(String value) {
            addCriterion("scode <=", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLike(String value) {
            addCriterion("scode like", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotLike(String value) {
            addCriterion("scode not like", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeIn(java.util.List<java.lang.String> values) {
            addCriterion("scode in", values, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("scode not in", values, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeBetween(String value1, String value2) {
            addCriterion("scode between", value1, value2, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotBetween(String value1, String value2) {
            addCriterion("scode not between", value1, value2, "scode");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(java.util.List<java.lang.String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
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
    b_hd_apply_recordaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}