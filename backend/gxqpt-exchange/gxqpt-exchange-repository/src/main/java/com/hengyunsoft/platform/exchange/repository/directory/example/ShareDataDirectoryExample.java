package com.hengyunsoft.platform.exchange.repository.directory.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareDataDirectoryExample extends com.hengyunsoft.db.example.BaseExample<ShareDataDirectoryExample.Criteria> implements Serializable {
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

        public Criteria andApplyCodeIsNull() {
            addCriterion("apply_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNotNull() {
            addCriterion("apply_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeEqualTo(String value) {
            addCriterion("apply_code =", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotEqualTo(String value) {
            addCriterion("apply_code <>", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThan(String value) {
            addCriterion("apply_code >", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_code >=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThan(String value) {
            addCriterion("apply_code <", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_code <=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLike(String value) {
            addCriterion("apply_code like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotLike(String value) {
            addCriterion("apply_code not like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_code in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_code not in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeBetween(String value1, String value2) {
            addCriterion("apply_code between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotBetween(String value1, String value2) {
            addCriterion("apply_code not between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andDirNameIsNull() {
            addCriterion("dir_name is null");
            return (Criteria) this;
        }

        public Criteria andDirNameIsNotNull() {
            addCriterion("dir_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirNameEqualTo(String value) {
            addCriterion("dir_name =", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameNotEqualTo(String value) {
            addCriterion("dir_name <>", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameGreaterThan(String value) {
            addCriterion("dir_name >", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameGreaterThanOrEqualTo(String value) {
            addCriterion("dir_name >=", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameLessThan(String value) {
            addCriterion("dir_name <", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameLessThanOrEqualTo(String value) {
            addCriterion("dir_name <=", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameLike(String value) {
            addCriterion("dir_name like", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameNotLike(String value) {
            addCriterion("dir_name not like", value, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_name in", values, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_name not in", values, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameBetween(String value1, String value2) {
            addCriterion("dir_name between", value1, value2, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirNameNotBetween(String value1, String value2) {
            addCriterion("dir_name not between", value1, value2, "dirName");
            return (Criteria) this;
        }

        public Criteria andDirCodeIsNull() {
            addCriterion("dir_code is null");
            return (Criteria) this;
        }

        public Criteria andDirCodeIsNotNull() {
            addCriterion("dir_code is not null");
            return (Criteria) this;
        }

        public Criteria andDirCodeEqualTo(String value) {
            addCriterion("dir_code =", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeNotEqualTo(String value) {
            addCriterion("dir_code <>", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeGreaterThan(String value) {
            addCriterion("dir_code >", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dir_code >=", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeLessThan(String value) {
            addCriterion("dir_code <", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeLessThanOrEqualTo(String value) {
            addCriterion("dir_code <=", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeLike(String value) {
            addCriterion("dir_code like", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeNotLike(String value) {
            addCriterion("dir_code not like", value, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_code in", values, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_code not in", values, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeBetween(String value1, String value2) {
            addCriterion("dir_code between", value1, value2, "dirCode");
            return (Criteria) this;
        }

        public Criteria andDirCodeNotBetween(String value1, String value2) {
            addCriterion("dir_code not between", value1, value2, "dirCode");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrIsNull() {
            addCriterion("unit_abbr is null");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrIsNotNull() {
            addCriterion("unit_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrEqualTo(String value) {
            addCriterion("unit_abbr =", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrNotEqualTo(String value) {
            addCriterion("unit_abbr <>", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrGreaterThan(String value) {
            addCriterion("unit_abbr >", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("unit_abbr >=", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrLessThan(String value) {
            addCriterion("unit_abbr <", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrLessThanOrEqualTo(String value) {
            addCriterion("unit_abbr <=", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrLike(String value) {
            addCriterion("unit_abbr like", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrNotLike(String value) {
            addCriterion("unit_abbr not like", value, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_abbr in", values, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_abbr not in", values, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrBetween(String value1, String value2) {
            addCriterion("unit_abbr between", value1, value2, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andUnitAbbrNotBetween(String value1, String value2) {
            addCriterion("unit_abbr not between", value1, value2, "unitAbbr");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(java.util.List<java.lang.String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("unit_id like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("unit_id not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
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

        public Criteria andDirTypeIsNull() {
            addCriterion("dir_type is null");
            return (Criteria) this;
        }

        public Criteria andDirTypeIsNotNull() {
            addCriterion("dir_type is not null");
            return (Criteria) this;
        }

        public Criteria andDirTypeEqualTo(Integer value) {
            addCriterion("dir_type =", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeNotEqualTo(Integer value) {
            addCriterion("dir_type <>", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeGreaterThan(Integer value) {
            addCriterion("dir_type >", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dir_type >=", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeLessThan(Integer value) {
            addCriterion("dir_type <", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dir_type <=", value, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("dir_type in", values, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("dir_type not in", values, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeBetween(Integer value1, Integer value2) {
            addCriterion("dir_type between", value1, value2, "dirType");
            return (Criteria) this;
        }

        public Criteria andDirTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dir_type not between", value1, value2, "dirType");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNull() {
            addCriterion("data_count is null");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNotNull() {
            addCriterion("data_count is not null");
            return (Criteria) this;
        }

        public Criteria andDataCountEqualTo(Integer value) {
            addCriterion("data_count =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Integer value) {
            addCriterion("data_count <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Integer value) {
            addCriterion("data_count >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_count >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Integer value) {
            addCriterion("data_count <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Integer value) {
            addCriterion("data_count <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Integer value1, Integer value2) {
            addCriterion("data_count between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Integer value1, Integer value2) {
            addCriterion("data_count not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountIsNull() {
            addCriterion("see_count is null");
            return (Criteria) this;
        }

        public Criteria andSeeCountIsNotNull() {
            addCriterion("see_count is not null");
            return (Criteria) this;
        }

        public Criteria andSeeCountEqualTo(Integer value) {
            addCriterion("see_count =", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotEqualTo(Integer value) {
            addCriterion("see_count <>", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountGreaterThan(Integer value) {
            addCriterion("see_count >", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("see_count >=", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountLessThan(Integer value) {
            addCriterion("see_count <", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountLessThanOrEqualTo(Integer value) {
            addCriterion("see_count <=", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("see_count in", values, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("see_count not in", values, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountBetween(Integer value1, Integer value2) {
            addCriterion("see_count between", value1, value2, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("see_count not between", value1, value2, "seeCount");
            return (Criteria) this;
        }

        public Criteria andDownCountIsNull() {
            addCriterion("down_count is null");
            return (Criteria) this;
        }

        public Criteria andDownCountIsNotNull() {
            addCriterion("down_count is not null");
            return (Criteria) this;
        }

        public Criteria andDownCountEqualTo(Integer value) {
            addCriterion("down_count =", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountNotEqualTo(Integer value) {
            addCriterion("down_count <>", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountGreaterThan(Integer value) {
            addCriterion("down_count >", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("down_count >=", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountLessThan(Integer value) {
            addCriterion("down_count <", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountLessThanOrEqualTo(Integer value) {
            addCriterion("down_count <=", value, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("down_count in", values, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("down_count not in", values, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountBetween(Integer value1, Integer value2) {
            addCriterion("down_count between", value1, value2, "downCount");
            return (Criteria) this;
        }

        public Criteria andDownCountNotBetween(Integer value1, Integer value2) {
            addCriterion("down_count not between", value1, value2, "downCount");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNull() {
            addCriterion("opt_type is null");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNotNull() {
            addCriterion("opt_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptTypeEqualTo(Integer value) {
            addCriterion("opt_type =", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotEqualTo(Integer value) {
            addCriterion("opt_type <>", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThan(Integer value) {
            addCriterion("opt_type >", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_type >=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThan(Integer value) {
            addCriterion("opt_type <", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opt_type <=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("opt_type in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("opt_type not in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeBetween(Integer value1, Integer value2) {
            addCriterion("opt_type between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_type not between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsBottomIsNull() {
            addCriterion("is_bottom is null");
            return (Criteria) this;
        }

        public Criteria andIsBottomIsNotNull() {
            addCriterion("is_bottom is not null");
            return (Criteria) this;
        }

        public Criteria andIsBottomEqualTo(Integer value) {
            addCriterion("is_bottom =", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomNotEqualTo(Integer value) {
            addCriterion("is_bottom <>", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomGreaterThan(Integer value) {
            addCriterion("is_bottom >", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bottom >=", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomLessThan(Integer value) {
            addCriterion("is_bottom <", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomLessThanOrEqualTo(Integer value) {
            addCriterion("is_bottom <=", value, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_bottom in", values, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_bottom not in", values, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomBetween(Integer value1, Integer value2) {
            addCriterion("is_bottom between", value1, value2, "isBottom");
            return (Criteria) this;
        }

        public Criteria andIsBottomNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bottom not between", value1, value2, "isBottom");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeIsNull() {
            addCriterion("special_type is null");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeIsNotNull() {
            addCriterion("special_type is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeEqualTo(String value) {
            addCriterion("special_type =", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeNotEqualTo(String value) {
            addCriterion("special_type <>", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeGreaterThan(String value) {
            addCriterion("special_type >", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("special_type >=", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeLessThan(String value) {
            addCriterion("special_type <", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeLessThanOrEqualTo(String value) {
            addCriterion("special_type <=", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeLike(String value) {
            addCriterion("special_type like", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeNotLike(String value) {
            addCriterion("special_type not like", value, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("special_type in", values, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("special_type not in", values, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeBetween(String value1, String value2) {
            addCriterion("special_type between", value1, value2, "specialType");
            return (Criteria) this;
        }

        public Criteria andSpecialTypeNotBetween(String value1, String value2) {
            addCriterion("special_type not between", value1, value2, "specialType");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(java.util.List<java.lang.String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(java.util.List<java.lang.String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andThemeOneIsNull() {
            addCriterion("theme_one is null");
            return (Criteria) this;
        }

        public Criteria andThemeOneIsNotNull() {
            addCriterion("theme_one is not null");
            return (Criteria) this;
        }

        public Criteria andThemeOneEqualTo(String value) {
            addCriterion("theme_one =", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneNotEqualTo(String value) {
            addCriterion("theme_one <>", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneGreaterThan(String value) {
            addCriterion("theme_one >", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneGreaterThanOrEqualTo(String value) {
            addCriterion("theme_one >=", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneLessThan(String value) {
            addCriterion("theme_one <", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneLessThanOrEqualTo(String value) {
            addCriterion("theme_one <=", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneLike(String value) {
            addCriterion("theme_one like", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneNotLike(String value) {
            addCriterion("theme_one not like", value, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_one in", values, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_one not in", values, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneBetween(String value1, String value2) {
            addCriterion("theme_one between", value1, value2, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeOneNotBetween(String value1, String value2) {
            addCriterion("theme_one not between", value1, value2, "themeOne");
            return (Criteria) this;
        }

        public Criteria andThemeTwoIsNull() {
            addCriterion("theme_two is null");
            return (Criteria) this;
        }

        public Criteria andThemeTwoIsNotNull() {
            addCriterion("theme_two is not null");
            return (Criteria) this;
        }

        public Criteria andThemeTwoEqualTo(String value) {
            addCriterion("theme_two =", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoNotEqualTo(String value) {
            addCriterion("theme_two <>", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoGreaterThan(String value) {
            addCriterion("theme_two >", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoGreaterThanOrEqualTo(String value) {
            addCriterion("theme_two >=", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoLessThan(String value) {
            addCriterion("theme_two <", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoLessThanOrEqualTo(String value) {
            addCriterion("theme_two <=", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoLike(String value) {
            addCriterion("theme_two like", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoNotLike(String value) {
            addCriterion("theme_two not like", value, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_two in", values, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_two not in", values, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoBetween(String value1, String value2) {
            addCriterion("theme_two between", value1, value2, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeTwoNotBetween(String value1, String value2) {
            addCriterion("theme_two not between", value1, value2, "themeTwo");
            return (Criteria) this;
        }

        public Criteria andThemeThreeIsNull() {
            addCriterion("theme_three is null");
            return (Criteria) this;
        }

        public Criteria andThemeThreeIsNotNull() {
            addCriterion("theme_three is not null");
            return (Criteria) this;
        }

        public Criteria andThemeThreeEqualTo(String value) {
            addCriterion("theme_three =", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeNotEqualTo(String value) {
            addCriterion("theme_three <>", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeGreaterThan(String value) {
            addCriterion("theme_three >", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeGreaterThanOrEqualTo(String value) {
            addCriterion("theme_three >=", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeLessThan(String value) {
            addCriterion("theme_three <", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeLessThanOrEqualTo(String value) {
            addCriterion("theme_three <=", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeLike(String value) {
            addCriterion("theme_three like", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeNotLike(String value) {
            addCriterion("theme_three not like", value, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_three in", values, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("theme_three not in", values, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeBetween(String value1, String value2) {
            addCriterion("theme_three between", value1, value2, "themeThree");
            return (Criteria) this;
        }

        public Criteria andThemeThreeNotBetween(String value1, String value2) {
            addCriterion("theme_three not between", value1, value2, "themeThree");
            return (Criteria) this;
        }

        public Criteria andIndustryOneIsNull() {
            addCriterion("industry_one is null");
            return (Criteria) this;
        }

        public Criteria andIndustryOneIsNotNull() {
            addCriterion("industry_one is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryOneEqualTo(String value) {
            addCriterion("industry_one =", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotEqualTo(String value) {
            addCriterion("industry_one <>", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneGreaterThan(String value) {
            addCriterion("industry_one >", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneGreaterThanOrEqualTo(String value) {
            addCriterion("industry_one >=", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLessThan(String value) {
            addCriterion("industry_one <", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLessThanOrEqualTo(String value) {
            addCriterion("industry_one <=", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLike(String value) {
            addCriterion("industry_one like", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotLike(String value) {
            addCriterion("industry_one not like", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_one in", values, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_one not in", values, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneBetween(String value1, String value2) {
            addCriterion("industry_one between", value1, value2, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotBetween(String value1, String value2) {
            addCriterion("industry_one not between", value1, value2, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIsNull() {
            addCriterion("industry_two is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIsNotNull() {
            addCriterion("industry_two is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoEqualTo(String value) {
            addCriterion("industry_two =", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotEqualTo(String value) {
            addCriterion("industry_two <>", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoGreaterThan(String value) {
            addCriterion("industry_two >", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoGreaterThanOrEqualTo(String value) {
            addCriterion("industry_two >=", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLessThan(String value) {
            addCriterion("industry_two <", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLessThanOrEqualTo(String value) {
            addCriterion("industry_two <=", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLike(String value) {
            addCriterion("industry_two like", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotLike(String value) {
            addCriterion("industry_two not like", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_two in", values, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_two not in", values, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoBetween(String value1, String value2) {
            addCriterion("industry_two between", value1, value2, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotBetween(String value1, String value2) {
            addCriterion("industry_two not between", value1, value2, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeIsNull() {
            addCriterion("industry_three is null");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeIsNotNull() {
            addCriterion("industry_three is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeEqualTo(String value) {
            addCriterion("industry_three =", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeNotEqualTo(String value) {
            addCriterion("industry_three <>", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeGreaterThan(String value) {
            addCriterion("industry_three >", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_three >=", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeLessThan(String value) {
            addCriterion("industry_three <", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeLessThanOrEqualTo(String value) {
            addCriterion("industry_three <=", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeLike(String value) {
            addCriterion("industry_three like", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeNotLike(String value) {
            addCriterion("industry_three not like", value, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_three in", values, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("industry_three not in", values, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeBetween(String value1, String value2) {
            addCriterion("industry_three between", value1, value2, "industryThree");
            return (Criteria) this;
        }

        public Criteria andIndustryThreeNotBetween(String value1, String value2) {
            addCriterion("industry_three not between", value1, value2, "industryThree");
            return (Criteria) this;
        }

        public Criteria andServiceOneIsNull() {
            addCriterion("service_one is null");
            return (Criteria) this;
        }

        public Criteria andServiceOneIsNotNull() {
            addCriterion("service_one is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOneEqualTo(String value) {
            addCriterion("service_one =", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneNotEqualTo(String value) {
            addCriterion("service_one <>", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneGreaterThan(String value) {
            addCriterion("service_one >", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneGreaterThanOrEqualTo(String value) {
            addCriterion("service_one >=", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneLessThan(String value) {
            addCriterion("service_one <", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneLessThanOrEqualTo(String value) {
            addCriterion("service_one <=", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneLike(String value) {
            addCriterion("service_one like", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneNotLike(String value) {
            addCriterion("service_one not like", value, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneIn(java.util.List<java.lang.String> values) {
            addCriterion("service_one in", values, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_one not in", values, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneBetween(String value1, String value2) {
            addCriterion("service_one between", value1, value2, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceOneNotBetween(String value1, String value2) {
            addCriterion("service_one not between", value1, value2, "serviceOne");
            return (Criteria) this;
        }

        public Criteria andServiceTwoIsNull() {
            addCriterion("service_two is null");
            return (Criteria) this;
        }

        public Criteria andServiceTwoIsNotNull() {
            addCriterion("service_two is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTwoEqualTo(String value) {
            addCriterion("service_two =", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoNotEqualTo(String value) {
            addCriterion("service_two <>", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoGreaterThan(String value) {
            addCriterion("service_two >", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoGreaterThanOrEqualTo(String value) {
            addCriterion("service_two >=", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoLessThan(String value) {
            addCriterion("service_two <", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoLessThanOrEqualTo(String value) {
            addCriterion("service_two <=", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoLike(String value) {
            addCriterion("service_two like", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoNotLike(String value) {
            addCriterion("service_two not like", value, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoIn(java.util.List<java.lang.String> values) {
            addCriterion("service_two in", values, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_two not in", values, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoBetween(String value1, String value2) {
            addCriterion("service_two between", value1, value2, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceTwoNotBetween(String value1, String value2) {
            addCriterion("service_two not between", value1, value2, "serviceTwo");
            return (Criteria) this;
        }

        public Criteria andServiceThreeIsNull() {
            addCriterion("service_three is null");
            return (Criteria) this;
        }

        public Criteria andServiceThreeIsNotNull() {
            addCriterion("service_three is not null");
            return (Criteria) this;
        }

        public Criteria andServiceThreeEqualTo(String value) {
            addCriterion("service_three =", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeNotEqualTo(String value) {
            addCriterion("service_three <>", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeGreaterThan(String value) {
            addCriterion("service_three >", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeGreaterThanOrEqualTo(String value) {
            addCriterion("service_three >=", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeLessThan(String value) {
            addCriterion("service_three <", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeLessThanOrEqualTo(String value) {
            addCriterion("service_three <=", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeLike(String value) {
            addCriterion("service_three like", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeNotLike(String value) {
            addCriterion("service_three not like", value, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeIn(java.util.List<java.lang.String> values) {
            addCriterion("service_three in", values, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_three not in", values, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeBetween(String value1, String value2) {
            addCriterion("service_three between", value1, value2, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andServiceThreeNotBetween(String value1, String value2) {
            addCriterion("service_three not between", value1, value2, "serviceThree");
            return (Criteria) this;
        }

        public Criteria andOpenWayIsNull() {
            addCriterion("open_way is null");
            return (Criteria) this;
        }

        public Criteria andOpenWayIsNotNull() {
            addCriterion("open_way is not null");
            return (Criteria) this;
        }

        public Criteria andOpenWayEqualTo(Integer value) {
            addCriterion("open_way =", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayNotEqualTo(Integer value) {
            addCriterion("open_way <>", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayGreaterThan(Integer value) {
            addCriterion("open_way >", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_way >=", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayLessThan(Integer value) {
            addCriterion("open_way <", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayLessThanOrEqualTo(Integer value) {
            addCriterion("open_way <=", value, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayIn(java.util.List<java.lang.Integer> values) {
            addCriterion("open_way in", values, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("open_way not in", values, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayBetween(Integer value1, Integer value2) {
            addCriterion("open_way between", value1, value2, "openWay");
            return (Criteria) this;
        }

        public Criteria andOpenWayNotBetween(Integer value1, Integer value2) {
            addCriterion("open_way not between", value1, value2, "openWay");
            return (Criteria) this;
        }

        public Criteria andShareWayIsNull() {
            addCriterion("share_way is null");
            return (Criteria) this;
        }

        public Criteria andShareWayIsNotNull() {
            addCriterion("share_way is not null");
            return (Criteria) this;
        }

        public Criteria andShareWayEqualTo(Integer value) {
            addCriterion("share_way =", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotEqualTo(Integer value) {
            addCriterion("share_way <>", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayGreaterThan(Integer value) {
            addCriterion("share_way >", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_way >=", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayLessThan(Integer value) {
            addCriterion("share_way <", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayLessThanOrEqualTo(Integer value) {
            addCriterion("share_way <=", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayIn(java.util.List<java.lang.Integer> values) {
            addCriterion("share_way in", values, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("share_way not in", values, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayBetween(Integer value1, Integer value2) {
            addCriterion("share_way between", value1, value2, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotBetween(Integer value1, Integer value2) {
            addCriterion("share_way not between", value1, value2, "shareWay");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(Integer value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(Integer value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(Integer value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(Integer value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason_ is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason_ is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason_ =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason_ <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason_ >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason_ >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason_ <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason_ <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason_ like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason_ not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("reason_ in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("reason_ not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason_ between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason_ not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andSetIdIsNull() {
            addCriterion("set_id is null");
            return (Criteria) this;
        }

        public Criteria andSetIdIsNotNull() {
            addCriterion("set_id is not null");
            return (Criteria) this;
        }

        public Criteria andSetIdEqualTo(Long value) {
            addCriterion("set_id =", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotEqualTo(Long value) {
            addCriterion("set_id <>", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThan(Long value) {
            addCriterion("set_id >", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("set_id >=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThan(Long value) {
            addCriterion("set_id <", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThanOrEqualTo(Long value) {
            addCriterion("set_id <=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("set_id in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("set_id not in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdBetween(Long value1, Long value2) {
            addCriterion("set_id between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotBetween(Long value1, Long value2) {
            addCriterion("set_id not between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andDataSheetIsNull() {
            addCriterion("data_sheet is null");
            return (Criteria) this;
        }

        public Criteria andDataSheetIsNotNull() {
            addCriterion("data_sheet is not null");
            return (Criteria) this;
        }

        public Criteria andDataSheetEqualTo(Integer value) {
            addCriterion("data_sheet =", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetNotEqualTo(Integer value) {
            addCriterion("data_sheet <>", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetGreaterThan(Integer value) {
            addCriterion("data_sheet >", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_sheet >=", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetLessThan(Integer value) {
            addCriterion("data_sheet <", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetLessThanOrEqualTo(Integer value) {
            addCriterion("data_sheet <=", value, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_sheet in", values, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_sheet not in", values, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetBetween(Integer value1, Integer value2) {
            addCriterion("data_sheet between", value1, value2, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataSheetNotBetween(Integer value1, Integer value2) {
            addCriterion("data_sheet not between", value1, value2, "dataSheet");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(Integer value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(Integer value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(Integer value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(Integer value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(Integer value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(Integer value1, Integer value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
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
    b_share_data_directoryaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}