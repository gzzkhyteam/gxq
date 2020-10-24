package com.hengyunsoft.platform.developer.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DependRelationExample extends com.hengyunsoft.db.example.BaseExample<DependRelationExample.Criteria> implements Serializable {
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

        public Criteria andConsumeTypeIsNull() {
            addCriterion("consume_type is null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeIsNotNull() {
            addCriterion("consume_type is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeEqualTo(String value) {
            addCriterion("consume_type =", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNotEqualTo(String value) {
            addCriterion("consume_type <>", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeGreaterThan(String value) {
            addCriterion("consume_type >", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("consume_type >=", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeLessThan(String value) {
            addCriterion("consume_type <", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeLessThanOrEqualTo(String value) {
            addCriterion("consume_type <=", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeLike(String value) {
            addCriterion("consume_type like", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNotLike(String value) {
            addCriterion("consume_type not like", value, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("consume_type in", values, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("consume_type not in", values, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeBetween(String value1, String value2) {
            addCriterion("consume_type between", value1, value2, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNotBetween(String value1, String value2) {
            addCriterion("consume_type not between", value1, value2, "consumeType");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIsNull() {
            addCriterion("consume_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIsNotNull() {
            addCriterion("consume_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdEqualTo(Long value) {
            addCriterion("consume_id =", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotEqualTo(Long value) {
            addCriterion("consume_id <>", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThan(Long value) {
            addCriterion("consume_id >", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("consume_id >=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThan(Long value) {
            addCriterion("consume_id <", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThanOrEqualTo(Long value) {
            addCriterion("consume_id <=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("consume_id in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("consume_id not in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdBetween(Long value1, Long value2) {
            addCriterion("consume_id between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotBetween(Long value1, Long value2) {
            addCriterion("consume_id not between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andProducerTypeIsNull() {
            addCriterion("producer_type is null");
            return (Criteria) this;
        }

        public Criteria andProducerTypeIsNotNull() {
            addCriterion("producer_type is not null");
            return (Criteria) this;
        }

        public Criteria andProducerTypeEqualTo(String value) {
            addCriterion("producer_type =", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeNotEqualTo(String value) {
            addCriterion("producer_type <>", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeGreaterThan(String value) {
            addCriterion("producer_type >", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("producer_type >=", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeLessThan(String value) {
            addCriterion("producer_type <", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeLessThanOrEqualTo(String value) {
            addCriterion("producer_type <=", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeLike(String value) {
            addCriterion("producer_type like", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeNotLike(String value) {
            addCriterion("producer_type not like", value, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("producer_type in", values, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("producer_type not in", values, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeBetween(String value1, String value2) {
            addCriterion("producer_type between", value1, value2, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerTypeNotBetween(String value1, String value2) {
            addCriterion("producer_type not between", value1, value2, "producerType");
            return (Criteria) this;
        }

        public Criteria andProducerIdIsNull() {
            addCriterion("producer_id is null");
            return (Criteria) this;
        }

        public Criteria andProducerIdIsNotNull() {
            addCriterion("producer_id is not null");
            return (Criteria) this;
        }

        public Criteria andProducerIdEqualTo(Long value) {
            addCriterion("producer_id =", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotEqualTo(Long value) {
            addCriterion("producer_id <>", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdGreaterThan(Long value) {
            addCriterion("producer_id >", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("producer_id >=", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdLessThan(Long value) {
            addCriterion("producer_id <", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdLessThanOrEqualTo(Long value) {
            addCriterion("producer_id <=", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("producer_id in", values, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("producer_id not in", values, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdBetween(Long value1, Long value2) {
            addCriterion("producer_id between", value1, value2, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotBetween(Long value1, Long value2) {
            addCriterion("producer_id not between", value1, value2, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerNameIsNull() {
            addCriterion("producer_name is null");
            return (Criteria) this;
        }

        public Criteria andProducerNameIsNotNull() {
            addCriterion("producer_name is not null");
            return (Criteria) this;
        }

        public Criteria andProducerNameEqualTo(String value) {
            addCriterion("producer_name =", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameNotEqualTo(String value) {
            addCriterion("producer_name <>", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameGreaterThan(String value) {
            addCriterion("producer_name >", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameGreaterThanOrEqualTo(String value) {
            addCriterion("producer_name >=", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameLessThan(String value) {
            addCriterion("producer_name <", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameLessThanOrEqualTo(String value) {
            addCriterion("producer_name <=", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameLike(String value) {
            addCriterion("producer_name like", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameNotLike(String value) {
            addCriterion("producer_name not like", value, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameIn(java.util.List<java.lang.String> values) {
            addCriterion("producer_name in", values, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("producer_name not in", values, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameBetween(String value1, String value2) {
            addCriterion("producer_name between", value1, value2, "producerName");
            return (Criteria) this;
        }

        public Criteria andProducerNameNotBetween(String value1, String value2) {
            addCriterion("producer_name not between", value1, value2, "producerName");
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

        public Criteria andReduceTimeIsNull() {
            addCriterion("reduce_time is null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIsNotNull() {
            addCriterion("reduce_time is not null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeEqualTo(Double value) {
            addCriterion("reduce_time =", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotEqualTo(Double value) {
            addCriterion("reduce_time <>", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThan(Double value) {
            addCriterion("reduce_time >", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("reduce_time >=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThan(Double value) {
            addCriterion("reduce_time <", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThanOrEqualTo(Double value) {
            addCriterion("reduce_time <=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIn(java.util.List<java.lang.Double> values) {
            addCriterion("reduce_time in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("reduce_time not in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeBetween(Double value1, Double value2) {
            addCriterion("reduce_time between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotBetween(Double value1, Double value2) {
            addCriterion("reduce_time not between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNull() {
            addCriterion("reduce_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNotNull() {
            addCriterion("reduce_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceCostEqualTo(Integer value) {
            addCriterion("reduce_cost =", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotEqualTo(Integer value) {
            addCriterion("reduce_cost <>", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThan(Integer value) {
            addCriterion("reduce_cost >", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost >=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThan(Integer value) {
            addCriterion("reduce_cost <", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost <=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_cost in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_cost not in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost between", value1, value2, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost not between", value1, value2, "reduceCost");
            return (Criteria) this;
        }
    }

    /**
    c_depend_relationaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}