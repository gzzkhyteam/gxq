package com.hengyunsoft.platform.mt.repository.feedback.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedBackExample extends com.hengyunsoft.db.example.BaseExample<FeedBackExample.Criteria> implements Serializable {
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

        public Criteria andAppliIdIsNull() {
            addCriterion("appli_id is null");
            return (Criteria) this;
        }

        public Criteria andAppliIdIsNotNull() {
            addCriterion("appli_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppliIdEqualTo(Long value) {
            addCriterion("appli_id =", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdNotEqualTo(Long value) {
            addCriterion("appli_id <>", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdGreaterThan(Long value) {
            addCriterion("appli_id >", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdGreaterThanOrEqualTo(Long value) {
            addCriterion("appli_id >=", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdLessThan(Long value) {
            addCriterion("appli_id <", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdLessThanOrEqualTo(Long value) {
            addCriterion("appli_id <=", value, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("appli_id in", values, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("appli_id not in", values, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdBetween(Long value1, Long value2) {
            addCriterion("appli_id between", value1, value2, "appliId");
            return (Criteria) this;
        }

        public Criteria andAppliIdNotBetween(Long value1, Long value2) {
            addCriterion("appli_id not between", value1, value2, "appliId");
            return (Criteria) this;
        }

        public Criteria andFbTitleIsNull() {
            addCriterion("fb_title is null");
            return (Criteria) this;
        }

        public Criteria andFbTitleIsNotNull() {
            addCriterion("fb_title is not null");
            return (Criteria) this;
        }

        public Criteria andFbTitleEqualTo(String value) {
            addCriterion("fb_title =", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotEqualTo(String value) {
            addCriterion("fb_title <>", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleGreaterThan(String value) {
            addCriterion("fb_title >", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleGreaterThanOrEqualTo(String value) {
            addCriterion("fb_title >=", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLessThan(String value) {
            addCriterion("fb_title <", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLessThanOrEqualTo(String value) {
            addCriterion("fb_title <=", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLike(String value) {
            addCriterion("fb_title like", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotLike(String value) {
            addCriterion("fb_title not like", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_title in", values, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_title not in", values, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleBetween(String value1, String value2) {
            addCriterion("fb_title between", value1, value2, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotBetween(String value1, String value2) {
            addCriterion("fb_title not between", value1, value2, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbContentIsNull() {
            addCriterion("fb_content is null");
            return (Criteria) this;
        }

        public Criteria andFbContentIsNotNull() {
            addCriterion("fb_content is not null");
            return (Criteria) this;
        }

        public Criteria andFbContentEqualTo(String value) {
            addCriterion("fb_content =", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotEqualTo(String value) {
            addCriterion("fb_content <>", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentGreaterThan(String value) {
            addCriterion("fb_content >", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentGreaterThanOrEqualTo(String value) {
            addCriterion("fb_content >=", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLessThan(String value) {
            addCriterion("fb_content <", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLessThanOrEqualTo(String value) {
            addCriterion("fb_content <=", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLike(String value) {
            addCriterion("fb_content like", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotLike(String value) {
            addCriterion("fb_content not like", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_content in", values, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_content not in", values, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentBetween(String value1, String value2) {
            addCriterion("fb_content between", value1, value2, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotBetween(String value1, String value2) {
            addCriterion("fb_content not between", value1, value2, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyIsNull() {
            addCriterion("fb_emergency is null");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyIsNotNull() {
            addCriterion("fb_emergency is not null");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyEqualTo(Integer value) {
            addCriterion("fb_emergency =", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyNotEqualTo(Integer value) {
            addCriterion("fb_emergency <>", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyGreaterThan(Integer value) {
            addCriterion("fb_emergency >", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fb_emergency >=", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyLessThan(Integer value) {
            addCriterion("fb_emergency <", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyLessThanOrEqualTo(Integer value) {
            addCriterion("fb_emergency <=", value, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fb_emergency in", values, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fb_emergency not in", values, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyBetween(Integer value1, Integer value2) {
            addCriterion("fb_emergency between", value1, value2, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbEmergencyNotBetween(Integer value1, Integer value2) {
            addCriterion("fb_emergency not between", value1, value2, "fbEmergency");
            return (Criteria) this;
        }

        public Criteria andFbStateIsNull() {
            addCriterion("fb_state is null");
            return (Criteria) this;
        }

        public Criteria andFbStateIsNotNull() {
            addCriterion("fb_state is not null");
            return (Criteria) this;
        }

        public Criteria andFbStateEqualTo(Integer value) {
            addCriterion("fb_state =", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateNotEqualTo(Integer value) {
            addCriterion("fb_state <>", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateGreaterThan(Integer value) {
            addCriterion("fb_state >", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fb_state >=", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateLessThan(Integer value) {
            addCriterion("fb_state <", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateLessThanOrEqualTo(Integer value) {
            addCriterion("fb_state <=", value, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fb_state in", values, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fb_state not in", values, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateBetween(Integer value1, Integer value2) {
            addCriterion("fb_state between", value1, value2, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbStateNotBetween(Integer value1, Integer value2) {
            addCriterion("fb_state not between", value1, value2, "fbState");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdIsNull() {
            addCriterion("fb_close_id is null");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdIsNotNull() {
            addCriterion("fb_close_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdEqualTo(Long value) {
            addCriterion("fb_close_id =", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdNotEqualTo(Long value) {
            addCriterion("fb_close_id <>", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdGreaterThan(Long value) {
            addCriterion("fb_close_id >", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fb_close_id >=", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdLessThan(Long value) {
            addCriterion("fb_close_id <", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdLessThanOrEqualTo(Long value) {
            addCriterion("fb_close_id <=", value, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("fb_close_id in", values, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("fb_close_id not in", values, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdBetween(Long value1, Long value2) {
            addCriterion("fb_close_id between", value1, value2, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseIdNotBetween(Long value1, Long value2) {
            addCriterion("fb_close_id not between", value1, value2, "fbCloseId");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameIsNull() {
            addCriterion("fb_close_name is null");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameIsNotNull() {
            addCriterion("fb_close_name is not null");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameEqualTo(String value) {
            addCriterion("fb_close_name =", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameNotEqualTo(String value) {
            addCriterion("fb_close_name <>", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameGreaterThan(String value) {
            addCriterion("fb_close_name >", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameGreaterThanOrEqualTo(String value) {
            addCriterion("fb_close_name >=", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameLessThan(String value) {
            addCriterion("fb_close_name <", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameLessThanOrEqualTo(String value) {
            addCriterion("fb_close_name <=", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameLike(String value) {
            addCriterion("fb_close_name like", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameNotLike(String value) {
            addCriterion("fb_close_name not like", value, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_close_name in", values, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fb_close_name not in", values, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameBetween(String value1, String value2) {
            addCriterion("fb_close_name between", value1, value2, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseNameNotBetween(String value1, String value2) {
            addCriterion("fb_close_name not between", value1, value2, "fbCloseName");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeIsNull() {
            addCriterion("fb_close_time is null");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeIsNotNull() {
            addCriterion("fb_close_time is not null");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeEqualTo(Date value) {
            addCriterion("fb_close_time =", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeNotEqualTo(Date value) {
            addCriterion("fb_close_time <>", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeGreaterThan(Date value) {
            addCriterion("fb_close_time >", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fb_close_time >=", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeLessThan(Date value) {
            addCriterion("fb_close_time <", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("fb_close_time <=", value, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("fb_close_time in", values, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("fb_close_time not in", values, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeBetween(Date value1, Date value2) {
            addCriterion("fb_close_time between", value1, value2, "fbCloseTime");
            return (Criteria) this;
        }

        public Criteria andFbCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("fb_close_time not between", value1, value2, "fbCloseTime");
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
    b_feedbackaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}