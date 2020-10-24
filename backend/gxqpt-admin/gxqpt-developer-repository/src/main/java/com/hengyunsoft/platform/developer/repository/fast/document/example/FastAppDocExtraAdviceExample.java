package com.hengyunsoft.platform.developer.repository.fast.document.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastAppDocExtraAdviceExample extends com.hengyunsoft.db.example.BaseExample<FastAppDocExtraAdviceExample.Criteria> implements Serializable {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(java.util.List<java.lang.String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andLeadNameIsNull() {
            addCriterion("lead_name is null");
            return (Criteria) this;
        }

        public Criteria andLeadNameIsNotNull() {
            addCriterion("lead_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeadNameEqualTo(String value) {
            addCriterion("lead_name =", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameNotEqualTo(String value) {
            addCriterion("lead_name <>", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameGreaterThan(String value) {
            addCriterion("lead_name >", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameGreaterThanOrEqualTo(String value) {
            addCriterion("lead_name >=", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameLessThan(String value) {
            addCriterion("lead_name <", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameLessThanOrEqualTo(String value) {
            addCriterion("lead_name <=", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameLike(String value) {
            addCriterion("lead_name like", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameNotLike(String value) {
            addCriterion("lead_name not like", value, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameIn(java.util.List<java.lang.String> values) {
            addCriterion("lead_name in", values, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lead_name not in", values, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameBetween(String value1, String value2) {
            addCriterion("lead_name between", value1, value2, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadNameNotBetween(String value1, String value2) {
            addCriterion("lead_name not between", value1, value2, "leadName");
            return (Criteria) this;
        }

        public Criteria andLeadIdIsNull() {
            addCriterion("lead_id is null");
            return (Criteria) this;
        }

        public Criteria andLeadIdIsNotNull() {
            addCriterion("lead_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeadIdEqualTo(Long value) {
            addCriterion("lead_id =", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotEqualTo(Long value) {
            addCriterion("lead_id <>", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdGreaterThan(Long value) {
            addCriterion("lead_id >", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lead_id >=", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdLessThan(Long value) {
            addCriterion("lead_id <", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdLessThanOrEqualTo(Long value) {
            addCriterion("lead_id <=", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("lead_id in", values, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("lead_id not in", values, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdBetween(Long value1, Long value2) {
            addCriterion("lead_id between", value1, value2, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotBetween(Long value1, Long value2) {
            addCriterion("lead_id not between", value1, value2, "leadId");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameIsNull() {
            addCriterion("coordination_name is null");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameIsNotNull() {
            addCriterion("coordination_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameEqualTo(String value) {
            addCriterion("coordination_name =", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameNotEqualTo(String value) {
            addCriterion("coordination_name <>", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameGreaterThan(String value) {
            addCriterion("coordination_name >", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameGreaterThanOrEqualTo(String value) {
            addCriterion("coordination_name >=", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameLessThan(String value) {
            addCriterion("coordination_name <", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameLessThanOrEqualTo(String value) {
            addCriterion("coordination_name <=", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameLike(String value) {
            addCriterion("coordination_name like", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameNotLike(String value) {
            addCriterion("coordination_name not like", value, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameIn(java.util.List<java.lang.String> values) {
            addCriterion("coordination_name in", values, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("coordination_name not in", values, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameBetween(String value1, String value2) {
            addCriterion("coordination_name between", value1, value2, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationNameNotBetween(String value1, String value2) {
            addCriterion("coordination_name not between", value1, value2, "coordinationName");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdIsNull() {
            addCriterion("coordination_id is null");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdIsNotNull() {
            addCriterion("coordination_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdEqualTo(Long value) {
            addCriterion("coordination_id =", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdNotEqualTo(Long value) {
            addCriterion("coordination_id <>", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdGreaterThan(Long value) {
            addCriterion("coordination_id >", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coordination_id >=", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdLessThan(Long value) {
            addCriterion("coordination_id <", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdLessThanOrEqualTo(Long value) {
            addCriterion("coordination_id <=", value, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("coordination_id in", values, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("coordination_id not in", values, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdBetween(Long value1, Long value2) {
            addCriterion("coordination_id between", value1, value2, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andCoordinationIdNotBetween(Long value1, Long value2) {
            addCriterion("coordination_id not between", value1, value2, "coordinationId");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomIsNull() {
            addCriterion("undertake_room is null");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomIsNotNull() {
            addCriterion("undertake_room is not null");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomEqualTo(String value) {
            addCriterion("undertake_room =", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomNotEqualTo(String value) {
            addCriterion("undertake_room <>", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomGreaterThan(String value) {
            addCriterion("undertake_room >", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomGreaterThanOrEqualTo(String value) {
            addCriterion("undertake_room >=", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomLessThan(String value) {
            addCriterion("undertake_room <", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomLessThanOrEqualTo(String value) {
            addCriterion("undertake_room <=", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomLike(String value) {
            addCriterion("undertake_room like", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomNotLike(String value) {
            addCriterion("undertake_room not like", value, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomIn(java.util.List<java.lang.String> values) {
            addCriterion("undertake_room in", values, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomNotIn(java.util.List<java.lang.String> values) {
            addCriterion("undertake_room not in", values, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomBetween(String value1, String value2) {
            addCriterion("undertake_room between", value1, value2, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andUndertakeRoomNotBetween(String value1, String value2) {
            addCriterion("undertake_room not between", value1, value2, "undertakeRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomIsNull() {
            addCriterion("coordination_room is null");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomIsNotNull() {
            addCriterion("coordination_room is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomEqualTo(String value) {
            addCriterion("coordination_room =", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomNotEqualTo(String value) {
            addCriterion("coordination_room <>", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomGreaterThan(String value) {
            addCriterion("coordination_room >", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomGreaterThanOrEqualTo(String value) {
            addCriterion("coordination_room >=", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomLessThan(String value) {
            addCriterion("coordination_room <", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomLessThanOrEqualTo(String value) {
            addCriterion("coordination_room <=", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomLike(String value) {
            addCriterion("coordination_room like", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomNotLike(String value) {
            addCriterion("coordination_room not like", value, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomIn(java.util.List<java.lang.String> values) {
            addCriterion("coordination_room in", values, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomNotIn(java.util.List<java.lang.String> values) {
            addCriterion("coordination_room not in", values, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomBetween(String value1, String value2) {
            addCriterion("coordination_room between", value1, value2, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andCoordinationRoomNotBetween(String value1, String value2) {
            addCriterion("coordination_room not between", value1, value2, "coordinationRoom");
            return (Criteria) this;
        }

        public Criteria andAgentIsNull() {
            addCriterion("agent_ is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("agent_ is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(String value) {
            addCriterion("agent_ =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(String value) {
            addCriterion("agent_ <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(String value) {
            addCriterion("agent_ >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("agent_ >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(String value) {
            addCriterion("agent_ <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(String value) {
            addCriterion("agent_ <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLike(String value) {
            addCriterion("agent_ like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotLike(String value) {
            addCriterion("agent_ not like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(java.util.List<java.lang.String> values) {
            addCriterion("agent_ in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("agent_ not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(String value1, String value2) {
            addCriterion("agent_ between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(String value1, String value2) {
            addCriterion("agent_ not between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNull() {
            addCriterion("urgency_degree is null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNotNull() {
            addCriterion("urgency_degree is not null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeEqualTo(String value) {
            addCriterion("urgency_degree =", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotEqualTo(String value) {
            addCriterion("urgency_degree <>", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThan(String value) {
            addCriterion("urgency_degree >", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("urgency_degree >=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThan(String value) {
            addCriterion("urgency_degree <", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThanOrEqualTo(String value) {
            addCriterion("urgency_degree <=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLike(String value) {
            addCriterion("urgency_degree like", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotLike(String value) {
            addCriterion("urgency_degree not like", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIn(java.util.List<java.lang.String> values) {
            addCriterion("urgency_degree in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("urgency_degree not in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeBetween(String value1, String value2) {
            addCriterion("urgency_degree between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotBetween(String value1, String value2) {
            addCriterion("urgency_degree not between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitIsNull() {
            addCriterion("finish_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitIsNotNull() {
            addCriterion("finish_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitEqualTo(Date value) {
            addCriterion("finish_time_limit =", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitNotEqualTo(Date value) {
            addCriterion("finish_time_limit <>", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitGreaterThan(Date value) {
            addCriterion("finish_time_limit >", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time_limit >=", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitLessThan(Date value) {
            addCriterion("finish_time_limit <", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitLessThanOrEqualTo(Date value) {
            addCriterion("finish_time_limit <=", value, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitIn(java.util.List<java.util.Date> values) {
            addCriterion("finish_time_limit in", values, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitNotIn(java.util.List<java.util.Date> values) {
            addCriterion("finish_time_limit not in", values, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitBetween(Date value1, Date value2) {
            addCriterion("finish_time_limit between", value1, value2, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLimitNotBetween(Date value1, Date value2) {
            addCriterion("finish_time_limit not between", value1, value2, "finishTimeLimit");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content_ is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content_ is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content_ =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content_ <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content_ >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content_ >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content_ <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content_ <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content_ like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content_ not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(java.util.List<java.lang.String> values) {
            addCriterion("content_ in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content_ not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content_ between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content_ not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIsNull() {
            addCriterion("attachment_url is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIsNotNull() {
            addCriterion("attachment_url is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlEqualTo(String value) {
            addCriterion("attachment_url =", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotEqualTo(String value) {
            addCriterion("attachment_url <>", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlGreaterThan(String value) {
            addCriterion("attachment_url >", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_url >=", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLessThan(String value) {
            addCriterion("attachment_url <", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLessThanOrEqualTo(String value) {
            addCriterion("attachment_url <=", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLike(String value) {
            addCriterion("attachment_url like", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotLike(String value) {
            addCriterion("attachment_url not like", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_url in", values, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_url not in", values, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlBetween(String value1, String value2) {
            addCriterion("attachment_url between", value1, value2, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotBetween(String value1, String value2) {
            addCriterion("attachment_url not between", value1, value2, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_ =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc_ <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc_ >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc_ >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc_ <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc_ <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_ like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_ not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc_ between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc_ not between", value1, value2, "desc");
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
    b_fast_app_doc_extra_adviceaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}