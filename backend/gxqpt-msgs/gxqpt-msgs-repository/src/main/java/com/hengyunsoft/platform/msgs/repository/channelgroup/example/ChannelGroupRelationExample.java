package com.hengyunsoft.platform.msgs.repository.channelgroup.example;

import java.io.Serializable;

public class ChannelGroupRelationExample extends com.hengyunsoft.db.example.BaseExample<ChannelGroupRelationExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

		private static final long serialVersionUID = 1L;

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

        public Criteria andChannelGroupIdIsNull() {
            addCriterion("channel_group_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdIsNotNull() {
            addCriterion("channel_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdEqualTo(Long value) {
            addCriterion("channel_group_id =", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdNotEqualTo(Long value) {
            addCriterion("channel_group_id <>", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdGreaterThan(Long value) {
            addCriterion("channel_group_id >", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_group_id >=", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdLessThan(Long value) {
            addCriterion("channel_group_id <", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_group_id <=", value, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("channel_group_id in", values, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("channel_group_id not in", values, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdBetween(Long value1, Long value2) {
            addCriterion("channel_group_id between", value1, value2, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_group_id not between", value1, value2, "channelGroupId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }
    }

    /**
    channel_group_relationaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
		private static final long serialVersionUID = 1L;

		public Criteria() {
            super();
        }
    }
}