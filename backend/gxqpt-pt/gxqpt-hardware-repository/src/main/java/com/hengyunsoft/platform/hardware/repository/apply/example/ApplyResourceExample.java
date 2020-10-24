package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyResourceExample extends com.hengyunsoft.db.example.BaseExample<ApplyResourceExample.Criteria> implements Serializable {
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

        public Criteria andCpuModelIsNull() {
            addCriterion("cpu_model is null");
            return (Criteria) this;
        }

        public Criteria andCpuModelIsNotNull() {
            addCriterion("cpu_model is not null");
            return (Criteria) this;
        }

        public Criteria andCpuModelEqualTo(String value) {
            addCriterion("cpu_model =", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelNotEqualTo(String value) {
            addCriterion("cpu_model <>", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelGreaterThan(String value) {
            addCriterion("cpu_model >", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_model >=", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelLessThan(String value) {
            addCriterion("cpu_model <", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelLessThanOrEqualTo(String value) {
            addCriterion("cpu_model <=", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelLike(String value) {
            addCriterion("cpu_model like", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelNotLike(String value) {
            addCriterion("cpu_model not like", value, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_model in", values, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_model not in", values, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelBetween(String value1, String value2) {
            addCriterion("cpu_model between", value1, value2, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andCpuModelNotBetween(String value1, String value2) {
            addCriterion("cpu_model not between", value1, value2, "cpuModel");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNull() {
            addCriterion("memory_size is null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNotNull() {
            addCriterion("memory_size is not null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeEqualTo(Integer value) {
            addCriterion("memory_size =", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotEqualTo(Integer value) {
            addCriterion("memory_size <>", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThan(Integer value) {
            addCriterion("memory_size >", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory_size >=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThan(Integer value) {
            addCriterion("memory_size <", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThanOrEqualTo(Integer value) {
            addCriterion("memory_size <=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory_size in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory_size not in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeBetween(Integer value1, Integer value2) {
            addCriterion("memory_size between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotBetween(Integer value1, Integer value2) {
            addCriterion("memory_size not between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemoryModelIsNull() {
            addCriterion("memory_model is null");
            return (Criteria) this;
        }

        public Criteria andMemoryModelIsNotNull() {
            addCriterion("memory_model is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryModelEqualTo(String value) {
            addCriterion("memory_model =", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelNotEqualTo(String value) {
            addCriterion("memory_model <>", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelGreaterThan(String value) {
            addCriterion("memory_model >", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelGreaterThanOrEqualTo(String value) {
            addCriterion("memory_model >=", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelLessThan(String value) {
            addCriterion("memory_model <", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelLessThanOrEqualTo(String value) {
            addCriterion("memory_model <=", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelLike(String value) {
            addCriterion("memory_model like", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelNotLike(String value) {
            addCriterion("memory_model not like", value, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelIn(java.util.List<java.lang.String> values) {
            addCriterion("memory_model in", values, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("memory_model not in", values, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelBetween(String value1, String value2) {
            addCriterion("memory_model between", value1, value2, "memoryModel");
            return (Criteria) this;
        }

        public Criteria andMemoryModelNotBetween(String value1, String value2) {
            addCriterion("memory_model not between", value1, value2, "memoryModel");
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

        public Criteria andDiskModelIsNull() {
            addCriterion("disk_model is null");
            return (Criteria) this;
        }

        public Criteria andDiskModelIsNotNull() {
            addCriterion("disk_model is not null");
            return (Criteria) this;
        }

        public Criteria andDiskModelEqualTo(String value) {
            addCriterion("disk_model =", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelNotEqualTo(String value) {
            addCriterion("disk_model <>", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelGreaterThan(String value) {
            addCriterion("disk_model >", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelGreaterThanOrEqualTo(String value) {
            addCriterion("disk_model >=", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelLessThan(String value) {
            addCriterion("disk_model <", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelLessThanOrEqualTo(String value) {
            addCriterion("disk_model <=", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelLike(String value) {
            addCriterion("disk_model like", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelNotLike(String value) {
            addCriterion("disk_model not like", value, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_model in", values, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("disk_model not in", values, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelBetween(String value1, String value2) {
            addCriterion("disk_model between", value1, value2, "diskModel");
            return (Criteria) this;
        }

        public Criteria andDiskModelNotBetween(String value1, String value2) {
            addCriterion("disk_model not between", value1, value2, "diskModel");
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

        public Criteria andNetcardModelIsNull() {
            addCriterion("netcard_model is null");
            return (Criteria) this;
        }

        public Criteria andNetcardModelIsNotNull() {
            addCriterion("netcard_model is not null");
            return (Criteria) this;
        }

        public Criteria andNetcardModelEqualTo(String value) {
            addCriterion("netcard_model =", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelNotEqualTo(String value) {
            addCriterion("netcard_model <>", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelGreaterThan(String value) {
            addCriterion("netcard_model >", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelGreaterThanOrEqualTo(String value) {
            addCriterion("netcard_model >=", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelLessThan(String value) {
            addCriterion("netcard_model <", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelLessThanOrEqualTo(String value) {
            addCriterion("netcard_model <=", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelLike(String value) {
            addCriterion("netcard_model like", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelNotLike(String value) {
            addCriterion("netcard_model not like", value, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelIn(java.util.List<java.lang.String> values) {
            addCriterion("netcard_model in", values, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("netcard_model not in", values, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelBetween(String value1, String value2) {
            addCriterion("netcard_model between", value1, value2, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andNetcardModelNotBetween(String value1, String value2) {
            addCriterion("netcard_model not between", value1, value2, "netcardModel");
            return (Criteria) this;
        }

        public Criteria andChangeMachineIsNull() {
            addCriterion("change_machine is null");
            return (Criteria) this;
        }

        public Criteria andChangeMachineIsNotNull() {
            addCriterion("change_machine is not null");
            return (Criteria) this;
        }

        public Criteria andChangeMachineEqualTo(Integer value) {
            addCriterion("change_machine =", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineNotEqualTo(Integer value) {
            addCriterion("change_machine <>", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineGreaterThan(Integer value) {
            addCriterion("change_machine >", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_machine >=", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineLessThan(Integer value) {
            addCriterion("change_machine <", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineLessThanOrEqualTo(Integer value) {
            addCriterion("change_machine <=", value, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineIn(java.util.List<java.lang.Integer> values) {
            addCriterion("change_machine in", values, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("change_machine not in", values, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineBetween(Integer value1, Integer value2) {
            addCriterion("change_machine between", value1, value2, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeMachineNotBetween(Integer value1, Integer value2) {
            addCriterion("change_machine not between", value1, value2, "changeMachine");
            return (Criteria) this;
        }

        public Criteria andChangeModelIsNull() {
            addCriterion("change_model is null");
            return (Criteria) this;
        }

        public Criteria andChangeModelIsNotNull() {
            addCriterion("change_model is not null");
            return (Criteria) this;
        }

        public Criteria andChangeModelEqualTo(String value) {
            addCriterion("change_model =", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelNotEqualTo(String value) {
            addCriterion("change_model <>", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelGreaterThan(String value) {
            addCriterion("change_model >", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelGreaterThanOrEqualTo(String value) {
            addCriterion("change_model >=", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelLessThan(String value) {
            addCriterion("change_model <", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelLessThanOrEqualTo(String value) {
            addCriterion("change_model <=", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelLike(String value) {
            addCriterion("change_model like", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelNotLike(String value) {
            addCriterion("change_model not like", value, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelIn(java.util.List<java.lang.String> values) {
            addCriterion("change_model in", values, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("change_model not in", values, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelBetween(String value1, String value2) {
            addCriterion("change_model between", value1, value2, "changeModel");
            return (Criteria) this;
        }

        public Criteria andChangeModelNotBetween(String value1, String value2) {
            addCriterion("change_model not between", value1, value2, "changeModel");
            return (Criteria) this;
        }

        public Criteria andLightCountIsNull() {
            addCriterion("light_count is null");
            return (Criteria) this;
        }

        public Criteria andLightCountIsNotNull() {
            addCriterion("light_count is not null");
            return (Criteria) this;
        }

        public Criteria andLightCountEqualTo(Integer value) {
            addCriterion("light_count =", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotEqualTo(Integer value) {
            addCriterion("light_count <>", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountGreaterThan(Integer value) {
            addCriterion("light_count >", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("light_count >=", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountLessThan(Integer value) {
            addCriterion("light_count <", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountLessThanOrEqualTo(Integer value) {
            addCriterion("light_count <=", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("light_count in", values, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("light_count not in", values, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountBetween(Integer value1, Integer value2) {
            addCriterion("light_count between", value1, value2, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotBetween(Integer value1, Integer value2) {
            addCriterion("light_count not between", value1, value2, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightModelIsNull() {
            addCriterion("light_model is null");
            return (Criteria) this;
        }

        public Criteria andLightModelIsNotNull() {
            addCriterion("light_model is not null");
            return (Criteria) this;
        }

        public Criteria andLightModelEqualTo(String value) {
            addCriterion("light_model =", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelNotEqualTo(String value) {
            addCriterion("light_model <>", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelGreaterThan(String value) {
            addCriterion("light_model >", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelGreaterThanOrEqualTo(String value) {
            addCriterion("light_model >=", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelLessThan(String value) {
            addCriterion("light_model <", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelLessThanOrEqualTo(String value) {
            addCriterion("light_model <=", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelLike(String value) {
            addCriterion("light_model like", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelNotLike(String value) {
            addCriterion("light_model not like", value, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelIn(java.util.List<java.lang.String> values) {
            addCriterion("light_model in", values, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("light_model not in", values, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelBetween(String value1, String value2) {
            addCriterion("light_model between", value1, value2, "lightModel");
            return (Criteria) this;
        }

        public Criteria andLightModelNotBetween(String value1, String value2) {
            addCriterion("light_model not between", value1, value2, "lightModel");
            return (Criteria) this;
        }

        public Criteria andVideocardCountIsNull() {
            addCriterion("videocard_count is null");
            return (Criteria) this;
        }

        public Criteria andVideocardCountIsNotNull() {
            addCriterion("videocard_count is not null");
            return (Criteria) this;
        }

        public Criteria andVideocardCountEqualTo(Integer value) {
            addCriterion("videocard_count =", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountNotEqualTo(Integer value) {
            addCriterion("videocard_count <>", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountGreaterThan(Integer value) {
            addCriterion("videocard_count >", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("videocard_count >=", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountLessThan(Integer value) {
            addCriterion("videocard_count <", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountLessThanOrEqualTo(Integer value) {
            addCriterion("videocard_count <=", value, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("videocard_count in", values, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("videocard_count not in", values, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountBetween(Integer value1, Integer value2) {
            addCriterion("videocard_count between", value1, value2, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("videocard_count not between", value1, value2, "videocardCount");
            return (Criteria) this;
        }

        public Criteria andVideocardModelIsNull() {
            addCriterion("videocard_model is null");
            return (Criteria) this;
        }

        public Criteria andVideocardModelIsNotNull() {
            addCriterion("videocard_model is not null");
            return (Criteria) this;
        }

        public Criteria andVideocardModelEqualTo(String value) {
            addCriterion("videocard_model =", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelNotEqualTo(String value) {
            addCriterion("videocard_model <>", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelGreaterThan(String value) {
            addCriterion("videocard_model >", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelGreaterThanOrEqualTo(String value) {
            addCriterion("videocard_model >=", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelLessThan(String value) {
            addCriterion("videocard_model <", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelLessThanOrEqualTo(String value) {
            addCriterion("videocard_model <=", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelLike(String value) {
            addCriterion("videocard_model like", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelNotLike(String value) {
            addCriterion("videocard_model not like", value, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelIn(java.util.List<java.lang.String> values) {
            addCriterion("videocard_model in", values, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("videocard_model not in", values, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelBetween(String value1, String value2) {
            addCriterion("videocard_model between", value1, value2, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andVideocardModelNotBetween(String value1, String value2) {
            addCriterion("videocard_model not between", value1, value2, "videocardModel");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(java.util.List<java.lang.String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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
    b_hd_resource_applyaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}