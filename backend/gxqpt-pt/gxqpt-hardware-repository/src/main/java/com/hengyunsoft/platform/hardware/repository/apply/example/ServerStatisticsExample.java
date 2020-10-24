package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerStatisticsExample extends com.hengyunsoft.db.example.BaseExample<ServerStatisticsExample.Criteria> implements Serializable {
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

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Long value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Long value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Long value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Long value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Long value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Long value1, Long value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Long value1, Long value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCpuIsNull() {
            addCriterion("cpu is null");
            return (Criteria) this;
        }

        public Criteria andCpuIsNotNull() {
            addCriterion("cpu is not null");
            return (Criteria) this;
        }

        public Criteria andCpuEqualTo(Byte value) {
            addCriterion("cpu =", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotEqualTo(Byte value) {
            addCriterion("cpu <>", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThan(Byte value) {
            addCriterion("cpu >", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThanOrEqualTo(Byte value) {
            addCriterion("cpu >=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThan(Byte value) {
            addCriterion("cpu <", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThanOrEqualTo(Byte value) {
            addCriterion("cpu <=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuIn(java.util.List<java.lang.Byte> values) {
            addCriterion("cpu in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("cpu not in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuBetween(Byte value1, Byte value2) {
            addCriterion("cpu between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotBetween(Byte value1, Byte value2) {
            addCriterion("cpu not between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("mem is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("mem is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(Byte value) {
            addCriterion("mem =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(Byte value) {
            addCriterion("mem <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(Byte value) {
            addCriterion("mem >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(Byte value) {
            addCriterion("mem >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(Byte value) {
            addCriterion("mem <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(Byte value) {
            addCriterion("mem <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(java.util.List<java.lang.Byte> values) {
            addCriterion("mem in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("mem not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(Byte value1, Byte value2) {
            addCriterion("mem between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(Byte value1, Byte value2) {
            addCriterion("mem not between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andDiskIsNull() {
            addCriterion("disk is null");
            return (Criteria) this;
        }

        public Criteria andDiskIsNotNull() {
            addCriterion("disk is not null");
            return (Criteria) this;
        }

        public Criteria andDiskEqualTo(Byte value) {
            addCriterion("disk =", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotEqualTo(Byte value) {
            addCriterion("disk <>", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskGreaterThan(Byte value) {
            addCriterion("disk >", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskGreaterThanOrEqualTo(Byte value) {
            addCriterion("disk >=", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskLessThan(Byte value) {
            addCriterion("disk <", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskLessThanOrEqualTo(Byte value) {
            addCriterion("disk <=", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskIn(java.util.List<java.lang.Byte> values) {
            addCriterion("disk in", values, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("disk not in", values, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskBetween(Byte value1, Byte value2) {
            addCriterion("disk between", value1, value2, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotBetween(Byte value1, Byte value2) {
            addCriterion("disk not between", value1, value2, "disk");
            return (Criteria) this;
        }

        public Criteria andWideUpIsNull() {
            addCriterion("wide_up is null");
            return (Criteria) this;
        }

        public Criteria andWideUpIsNotNull() {
            addCriterion("wide_up is not null");
            return (Criteria) this;
        }

        public Criteria andWideUpEqualTo(Double value) {
            addCriterion("wide_up =", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotEqualTo(Double value) {
            addCriterion("wide_up <>", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpGreaterThan(Double value) {
            addCriterion("wide_up >", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpGreaterThanOrEqualTo(Double value) {
            addCriterion("wide_up >=", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpLessThan(Double value) {
            addCriterion("wide_up <", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpLessThanOrEqualTo(Double value) {
            addCriterion("wide_up <=", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_up in", values, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_up not in", values, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpBetween(Double value1, Double value2) {
            addCriterion("wide_up between", value1, value2, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotBetween(Double value1, Double value2) {
            addCriterion("wide_up not between", value1, value2, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideDownIsNull() {
            addCriterion("wide_down is null");
            return (Criteria) this;
        }

        public Criteria andWideDownIsNotNull() {
            addCriterion("wide_down is not null");
            return (Criteria) this;
        }

        public Criteria andWideDownEqualTo(Double value) {
            addCriterion("wide_down =", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotEqualTo(Double value) {
            addCriterion("wide_down <>", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownGreaterThan(Double value) {
            addCriterion("wide_down >", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownGreaterThanOrEqualTo(Double value) {
            addCriterion("wide_down >=", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownLessThan(Double value) {
            addCriterion("wide_down <", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownLessThanOrEqualTo(Double value) {
            addCriterion("wide_down <=", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_down in", values, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_down not in", values, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownBetween(Double value1, Double value2) {
            addCriterion("wide_down between", value1, value2, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotBetween(Double value1, Double value2) {
            addCriterion("wide_down not between", value1, value2, "wideDown");
            return (Criteria) this;
        }
    }

    /**
    b_hd_server_statisticsaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}