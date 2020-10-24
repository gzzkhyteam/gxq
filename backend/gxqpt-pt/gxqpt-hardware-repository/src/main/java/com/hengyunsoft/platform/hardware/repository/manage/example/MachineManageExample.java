package com.hengyunsoft.platform.hardware.repository.manage.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MachineManageExample extends com.hengyunsoft.db.example.BaseExample<MachineManageExample.Criteria> implements Serializable {
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

        public Criteria andClusterIsNull() {
            addCriterion("cluster is null");
            return (Criteria) this;
        }

        public Criteria andClusterIsNotNull() {
            addCriterion("cluster is not null");
            return (Criteria) this;
        }

        public Criteria andClusterEqualTo(String value) {
            addCriterion("cluster =", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterNotEqualTo(String value) {
            addCriterion("cluster <>", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterGreaterThan(String value) {
            addCriterion("cluster >", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterGreaterThanOrEqualTo(String value) {
            addCriterion("cluster >=", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterLessThan(String value) {
            addCriterion("cluster <", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterLessThanOrEqualTo(String value) {
            addCriterion("cluster <=", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterLike(String value) {
            addCriterion("cluster like", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterNotLike(String value) {
            addCriterion("cluster not like", value, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterIn(java.util.List<java.lang.String> values) {
            addCriterion("cluster in", values, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cluster not in", values, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterBetween(String value1, String value2) {
            addCriterion("cluster between", value1, value2, "cluster");
            return (Criteria) this;
        }

        public Criteria andClusterNotBetween(String value1, String value2) {
            addCriterion("cluster not between", value1, value2, "cluster");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(java.util.List<java.lang.String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andCpuTypeIsNull() {
            addCriterion("cpu_type is null");
            return (Criteria) this;
        }

        public Criteria andCpuTypeIsNotNull() {
            addCriterion("cpu_type is not null");
            return (Criteria) this;
        }

        public Criteria andCpuTypeEqualTo(String value) {
            addCriterion("cpu_type =", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeNotEqualTo(String value) {
            addCriterion("cpu_type <>", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeGreaterThan(String value) {
            addCriterion("cpu_type >", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_type >=", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeLessThan(String value) {
            addCriterion("cpu_type <", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeLessThanOrEqualTo(String value) {
            addCriterion("cpu_type <=", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeLike(String value) {
            addCriterion("cpu_type like", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeNotLike(String value) {
            addCriterion("cpu_type not like", value, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_type in", values, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_type not in", values, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeBetween(String value1, String value2) {
            addCriterion("cpu_type between", value1, value2, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuTypeNotBetween(String value1, String value2) {
            addCriterion("cpu_type not between", value1, value2, "cpuType");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNull() {
            addCriterion("cpu_count is null");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNotNull() {
            addCriterion("cpu_count is not null");
            return (Criteria) this;
        }

        public Criteria andCpuCountEqualTo(Integer value) {
            addCriterion("cpu_count =", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotEqualTo(Integer value) {
            addCriterion("cpu_count <>", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThan(Integer value) {
            addCriterion("cpu_count >", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpu_count >=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThan(Integer value) {
            addCriterion("cpu_count <", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThanOrEqualTo(Integer value) {
            addCriterion("cpu_count <=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cpu_count in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cpu_count not in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountBetween(Integer value1, Integer value2) {
            addCriterion("cpu_count between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotBetween(Integer value1, Integer value2) {
            addCriterion("cpu_count not between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andMemoryIsNull() {
            addCriterion("memory is null");
            return (Criteria) this;
        }

        public Criteria andMemoryIsNotNull() {
            addCriterion("memory is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryEqualTo(Integer value) {
            addCriterion("memory =", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualTo(Integer value) {
            addCriterion("memory <>", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThan(Integer value) {
            addCriterion("memory >", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory >=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThan(Integer value) {
            addCriterion("memory <", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualTo(Integer value) {
            addCriterion("memory <=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory not in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryBetween(Integer value1, Integer value2) {
            addCriterion("memory between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotBetween(Integer value1, Integer value2) {
            addCriterion("memory not between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andNetcardCountIsNull() {
            addCriterion("netcard_count is null");
            return (Criteria) this;
        }

        public Criteria andNetcardCountIsNotNull() {
            addCriterion("netcard_count is not null");
            return (Criteria) this;
        }

        public Criteria andNetcardCountEqualTo(Integer value) {
            addCriterion("netcard_count =", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountNotEqualTo(Integer value) {
            addCriterion("netcard_count <>", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountGreaterThan(Integer value) {
            addCriterion("netcard_count >", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("netcard_count >=", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountLessThan(Integer value) {
            addCriterion("netcard_count <", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountLessThanOrEqualTo(Integer value) {
            addCriterion("netcard_count <=", value, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("netcard_count in", values, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("netcard_count not in", values, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountBetween(Integer value1, Integer value2) {
            addCriterion("netcard_count between", value1, value2, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andNetcardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("netcard_count not between", value1, value2, "netcardCount");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIsNull() {
            addCriterion("disk_size is null");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIsNotNull() {
            addCriterion("disk_size is not null");
            return (Criteria) this;
        }

        public Criteria andDiskSizeEqualTo(Long value) {
            addCriterion("disk_size =", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotEqualTo(Long value) {
            addCriterion("disk_size <>", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeGreaterThan(Long value) {
            addCriterion("disk_size >", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("disk_size >=", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeLessThan(Long value) {
            addCriterion("disk_size <", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeLessThanOrEqualTo(Long value) {
            addCriterion("disk_size <=", value, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeIn(java.util.List<java.lang.Long> values) {
            addCriterion("disk_size in", values, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("disk_size not in", values, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeBetween(Long value1, Long value2) {
            addCriterion("disk_size between", value1, value2, "diskSize");
            return (Criteria) this;
        }

        public Criteria andDiskSizeNotBetween(Long value1, Long value2) {
            addCriterion("disk_size not between", value1, value2, "diskSize");
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
    b_hd_machine_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}