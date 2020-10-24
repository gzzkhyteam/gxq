package com.hengyunsoft.platform.mt.repository.appr.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprPersonExample extends com.hengyunsoft.db.example.BaseExample<ApprPersonExample.Criteria> implements Serializable {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdIsNull() {
            addCriterion("appr_user_id is null");
            return (Criteria) this;
        }

        public Criteria andApprUserIdIsNotNull() {
            addCriterion("appr_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(Long value) {
            addCriterion("appr_user_id =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdNotEqualTo(Long value) {
            addCriterion("appr_user_id <>", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdGreaterThan(Long value) {
            addCriterion("appr_user_id >", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("appr_user_id >=", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdLessThan(Long value) {
            addCriterion("appr_user_id <", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdLessThanOrEqualTo(Long value) {
            addCriterion("appr_user_id <=", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("appr_user_id in", values, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("appr_user_id not in", values, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdBetween(Long value1, Long value2) {
            addCriterion("appr_user_id between", value1, value2, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdNotBetween(Long value1, Long value2) {
            addCriterion("appr_user_id not between", value1, value2, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserNameIsNull() {
            addCriterion("appr_user_name is null");
            return (Criteria) this;
        }

        public Criteria andApprUserNameIsNotNull() {
            addCriterion("appr_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andApprUserNameEqualTo(String value) {
            addCriterion("appr_user_name =", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameNotEqualTo(String value) {
            addCriterion("appr_user_name <>", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameGreaterThan(String value) {
            addCriterion("appr_user_name >", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("appr_user_name >=", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameLessThan(String value) {
            addCriterion("appr_user_name <", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameLessThanOrEqualTo(String value) {
            addCriterion("appr_user_name <=", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameLike(String value) {
            addCriterion("appr_user_name like", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameNotLike(String value) {
            addCriterion("appr_user_name not like", value, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_user_name in", values, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_user_name not in", values, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameBetween(String value1, String value2) {
            addCriterion("appr_user_name between", value1, value2, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserNameNotBetween(String value1, String value2) {
            addCriterion("appr_user_name not between", value1, value2, "apprUserName");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexIsNull() {
            addCriterion("appr_user_index is null");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexIsNotNull() {
            addCriterion("appr_user_index is not null");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexEqualTo(Integer value) {
            addCriterion("appr_user_index =", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexNotEqualTo(Integer value) {
            addCriterion("appr_user_index <>", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexGreaterThan(Integer value) {
            addCriterion("appr_user_index >", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("appr_user_index >=", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexLessThan(Integer value) {
            addCriterion("appr_user_index <", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexLessThanOrEqualTo(Integer value) {
            addCriterion("appr_user_index <=", value, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexIn(java.util.List<java.lang.Integer> values) {
            addCriterion("appr_user_index in", values, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("appr_user_index not in", values, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexBetween(Integer value1, Integer value2) {
            addCriterion("appr_user_index between", value1, value2, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andApprUserIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("appr_user_index not between", value1, value2, "apprUserIndex");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNull() {
            addCriterion("agree is null");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNotNull() {
            addCriterion("agree is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeEqualTo(Integer value) {
            addCriterion("agree =", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotEqualTo(Integer value) {
            addCriterion("agree <>", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThan(Integer value) {
            addCriterion("agree >", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agree >=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThan(Integer value) {
            addCriterion("agree <", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThanOrEqualTo(Integer value) {
            addCriterion("agree <=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("agree in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("agree not in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeBetween(Integer value1, Integer value2) {
            addCriterion("agree between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotBetween(Integer value1, Integer value2) {
            addCriterion("agree not between", value1, value2, "agree");
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

        public Criteria andApprTimeIsNull() {
            addCriterion("appr_time is null");
            return (Criteria) this;
        }

        public Criteria andApprTimeIsNotNull() {
            addCriterion("appr_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprTimeEqualTo(Date value) {
            addCriterion("appr_time =", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotEqualTo(Date value) {
            addCriterion("appr_time <>", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeGreaterThan(Date value) {
            addCriterion("appr_time >", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appr_time >=", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeLessThan(Date value) {
            addCriterion("appr_time <", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeLessThanOrEqualTo(Date value) {
            addCriterion("appr_time <=", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("appr_time in", values, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("appr_time not in", values, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeBetween(Date value1, Date value2) {
            addCriterion("appr_time between", value1, value2, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotBetween(Date value1, Date value2) {
            addCriterion("appr_time not between", value1, value2, "apprTime");
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
    }

    /**
    b_appr_personaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}