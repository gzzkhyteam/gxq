package com.hengyunsoft.platform.admin.repository.org.sdzzww.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SdzzwwOrgExample extends com.hengyunsoft.db.example.BaseExample<SdzzwwOrgExample.Criteria> implements Serializable {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(java.util.List<java.lang.String> values) {
            addCriterion("name_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("name_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(java.util.List<java.lang.String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andElseNameIsNull() {
            addCriterion("else_name is null");
            return (Criteria) this;
        }

        public Criteria andElseNameIsNotNull() {
            addCriterion("else_name is not null");
            return (Criteria) this;
        }

        public Criteria andElseNameEqualTo(String value) {
            addCriterion("else_name =", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameNotEqualTo(String value) {
            addCriterion("else_name <>", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameGreaterThan(String value) {
            addCriterion("else_name >", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameGreaterThanOrEqualTo(String value) {
            addCriterion("else_name >=", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameLessThan(String value) {
            addCriterion("else_name <", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameLessThanOrEqualTo(String value) {
            addCriterion("else_name <=", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameLike(String value) {
            addCriterion("else_name like", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameNotLike(String value) {
            addCriterion("else_name not like", value, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameIn(java.util.List<java.lang.String> values) {
            addCriterion("else_name in", values, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("else_name not in", values, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameBetween(String value1, String value2) {
            addCriterion("else_name between", value1, value2, "elseName");
            return (Criteria) this;
        }

        public Criteria andElseNameNotBetween(String value1, String value2) {
            addCriterion("else_name not between", value1, value2, "elseName");
            return (Criteria) this;
        }

        public Criteria andForTypeIsNull() {
            addCriterion("for_type is null");
            return (Criteria) this;
        }

        public Criteria andForTypeIsNotNull() {
            addCriterion("for_type is not null");
            return (Criteria) this;
        }

        public Criteria andForTypeEqualTo(String value) {
            addCriterion("for_type =", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeNotEqualTo(String value) {
            addCriterion("for_type <>", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeGreaterThan(String value) {
            addCriterion("for_type >", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeGreaterThanOrEqualTo(String value) {
            addCriterion("for_type >=", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeLessThan(String value) {
            addCriterion("for_type <", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeLessThanOrEqualTo(String value) {
            addCriterion("for_type <=", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeLike(String value) {
            addCriterion("for_type like", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeNotLike(String value) {
            addCriterion("for_type not like", value, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("for_type in", values, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("for_type not in", values, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeBetween(String value1, String value2) {
            addCriterion("for_type between", value1, value2, "forType");
            return (Criteria) this;
        }

        public Criteria andForTypeNotBetween(String value1, String value2) {
            addCriterion("for_type not between", value1, value2, "forType");
            return (Criteria) this;
        }

        public Criteria andForClassIsNull() {
            addCriterion("for_class is null");
            return (Criteria) this;
        }

        public Criteria andForClassIsNotNull() {
            addCriterion("for_class is not null");
            return (Criteria) this;
        }

        public Criteria andForClassEqualTo(String value) {
            addCriterion("for_class =", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassNotEqualTo(String value) {
            addCriterion("for_class <>", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassGreaterThan(String value) {
            addCriterion("for_class >", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassGreaterThanOrEqualTo(String value) {
            addCriterion("for_class >=", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassLessThan(String value) {
            addCriterion("for_class <", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassLessThanOrEqualTo(String value) {
            addCriterion("for_class <=", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassLike(String value) {
            addCriterion("for_class like", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassNotLike(String value) {
            addCriterion("for_class not like", value, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassIn(java.util.List<java.lang.String> values) {
            addCriterion("for_class in", values, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassNotIn(java.util.List<java.lang.String> values) {
            addCriterion("for_class not in", values, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassBetween(String value1, String value2) {
            addCriterion("for_class between", value1, value2, "forClass");
            return (Criteria) this;
        }

        public Criteria andForClassNotBetween(String value1, String value2) {
            addCriterion("for_class not between", value1, value2, "forClass");
            return (Criteria) this;
        }

        public Criteria andForindustryIsNull() {
            addCriterion("forindustry is null");
            return (Criteria) this;
        }

        public Criteria andForindustryIsNotNull() {
            addCriterion("forindustry is not null");
            return (Criteria) this;
        }

        public Criteria andForindustryEqualTo(String value) {
            addCriterion("forindustry =", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryNotEqualTo(String value) {
            addCriterion("forindustry <>", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryGreaterThan(String value) {
            addCriterion("forindustry >", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryGreaterThanOrEqualTo(String value) {
            addCriterion("forindustry >=", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryLessThan(String value) {
            addCriterion("forindustry <", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryLessThanOrEqualTo(String value) {
            addCriterion("forindustry <=", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryLike(String value) {
            addCriterion("forindustry like", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryNotLike(String value) {
            addCriterion("forindustry not like", value, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryIn(java.util.List<java.lang.String> values) {
            addCriterion("forindustry in", values, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forindustry not in", values, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryBetween(String value1, String value2) {
            addCriterion("forindustry between", value1, value2, "forindustry");
            return (Criteria) this;
        }

        public Criteria andForindustryNotBetween(String value1, String value2) {
            addCriterion("forindustry not between", value1, value2, "forindustry");
            return (Criteria) this;
        }

        public Criteria andOrgadminIsNull() {
            addCriterion("orgadmin is null");
            return (Criteria) this;
        }

        public Criteria andOrgadminIsNotNull() {
            addCriterion("orgadmin is not null");
            return (Criteria) this;
        }

        public Criteria andOrgadminEqualTo(String value) {
            addCriterion("orgadmin =", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminNotEqualTo(String value) {
            addCriterion("orgadmin <>", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminGreaterThan(String value) {
            addCriterion("orgadmin >", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminGreaterThanOrEqualTo(String value) {
            addCriterion("orgadmin >=", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminLessThan(String value) {
            addCriterion("orgadmin <", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminLessThanOrEqualTo(String value) {
            addCriterion("orgadmin <=", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminLike(String value) {
            addCriterion("orgadmin like", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminNotLike(String value) {
            addCriterion("orgadmin not like", value, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminIn(java.util.List<java.lang.String> values) {
            addCriterion("orgadmin in", values, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgadmin not in", values, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminBetween(String value1, String value2) {
            addCriterion("orgadmin between", value1, value2, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andOrgadminNotBetween(String value1, String value2) {
            addCriterion("orgadmin not between", value1, value2, "orgadmin");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(java.util.List<java.lang.String> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeIsNull() {
            addCriterion("telcode is null");
            return (Criteria) this;
        }

        public Criteria andTelcodeIsNotNull() {
            addCriterion("telcode is not null");
            return (Criteria) this;
        }

        public Criteria andTelcodeEqualTo(String value) {
            addCriterion("telcode =", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotEqualTo(String value) {
            addCriterion("telcode <>", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThan(String value) {
            addCriterion("telcode >", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("telcode >=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThan(String value) {
            addCriterion("telcode <", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThanOrEqualTo(String value) {
            addCriterion("telcode <=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLike(String value) {
            addCriterion("telcode like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotLike(String value) {
            addCriterion("telcode not like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeIn(java.util.List<java.lang.String> values) {
            addCriterion("telcode in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("telcode not in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeBetween(String value1, String value2) {
            addCriterion("telcode between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotBetween(String value1, String value2) {
            addCriterion("telcode not between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeIsNull() {
            addCriterion("faxcode is null");
            return (Criteria) this;
        }

        public Criteria andFaxcodeIsNotNull() {
            addCriterion("faxcode is not null");
            return (Criteria) this;
        }

        public Criteria andFaxcodeEqualTo(String value) {
            addCriterion("faxcode =", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeNotEqualTo(String value) {
            addCriterion("faxcode <>", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeGreaterThan(String value) {
            addCriterion("faxcode >", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("faxcode >=", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeLessThan(String value) {
            addCriterion("faxcode <", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeLessThanOrEqualTo(String value) {
            addCriterion("faxcode <=", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeLike(String value) {
            addCriterion("faxcode like", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeNotLike(String value) {
            addCriterion("faxcode not like", value, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeIn(java.util.List<java.lang.String> values) {
            addCriterion("faxcode in", values, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("faxcode not in", values, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeBetween(String value1, String value2) {
            addCriterion("faxcode between", value1, value2, "faxcode");
            return (Criteria) this;
        }

        public Criteria andFaxcodeNotBetween(String value1, String value2) {
            addCriterion("faxcode not between", value1, value2, "faxcode");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status_ like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status_ not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSortvalueIsNull() {
            addCriterion("sortvalue is null");
            return (Criteria) this;
        }

        public Criteria andSortvalueIsNotNull() {
            addCriterion("sortvalue is not null");
            return (Criteria) this;
        }

        public Criteria andSortvalueEqualTo(Integer value) {
            addCriterion("sortvalue =", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueNotEqualTo(Integer value) {
            addCriterion("sortvalue <>", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueGreaterThan(Integer value) {
            addCriterion("sortvalue >", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortvalue >=", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueLessThan(Integer value) {
            addCriterion("sortvalue <", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueLessThanOrEqualTo(Integer value) {
            addCriterion("sortvalue <=", value, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sortvalue in", values, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sortvalue not in", values, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueBetween(Integer value1, Integer value2) {
            addCriterion("sortvalue between", value1, value2, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andSortvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("sortvalue not between", value1, value2, "sortvalue");
            return (Criteria) this;
        }

        public Criteria andDescrptionIsNull() {
            addCriterion("descrption is null");
            return (Criteria) this;
        }

        public Criteria andDescrptionIsNotNull() {
            addCriterion("descrption is not null");
            return (Criteria) this;
        }

        public Criteria andDescrptionEqualTo(String value) {
            addCriterion("descrption =", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionNotEqualTo(String value) {
            addCriterion("descrption <>", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionGreaterThan(String value) {
            addCriterion("descrption >", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionGreaterThanOrEqualTo(String value) {
            addCriterion("descrption >=", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionLessThan(String value) {
            addCriterion("descrption <", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionLessThanOrEqualTo(String value) {
            addCriterion("descrption <=", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionLike(String value) {
            addCriterion("descrption like", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionNotLike(String value) {
            addCriterion("descrption not like", value, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionIn(java.util.List<java.lang.String> values) {
            addCriterion("descrption in", values, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("descrption not in", values, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionBetween(String value1, String value2) {
            addCriterion("descrption between", value1, value2, "descrption");
            return (Criteria) this;
        }

        public Criteria andDescrptionNotBetween(String value1, String value2) {
            addCriterion("descrption not between", value1, value2, "descrption");
            return (Criteria) this;
        }

        public Criteria andForareaIsNull() {
            addCriterion("forarea is null");
            return (Criteria) this;
        }

        public Criteria andForareaIsNotNull() {
            addCriterion("forarea is not null");
            return (Criteria) this;
        }

        public Criteria andForareaEqualTo(String value) {
            addCriterion("forarea =", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaNotEqualTo(String value) {
            addCriterion("forarea <>", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaGreaterThan(String value) {
            addCriterion("forarea >", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaGreaterThanOrEqualTo(String value) {
            addCriterion("forarea >=", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaLessThan(String value) {
            addCriterion("forarea <", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaLessThanOrEqualTo(String value) {
            addCriterion("forarea <=", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaLike(String value) {
            addCriterion("forarea like", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaNotLike(String value) {
            addCriterion("forarea not like", value, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaIn(java.util.List<java.lang.String> values) {
            addCriterion("forarea in", values, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forarea not in", values, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaBetween(String value1, String value2) {
            addCriterion("forarea between", value1, value2, "forarea");
            return (Criteria) this;
        }

        public Criteria andForareaNotBetween(String value1, String value2) {
            addCriterion("forarea not between", value1, value2, "forarea");
            return (Criteria) this;
        }

        public Criteria andForcityIsNull() {
            addCriterion("forcity is null");
            return (Criteria) this;
        }

        public Criteria andForcityIsNotNull() {
            addCriterion("forcity is not null");
            return (Criteria) this;
        }

        public Criteria andForcityEqualTo(String value) {
            addCriterion("forcity =", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityNotEqualTo(String value) {
            addCriterion("forcity <>", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityGreaterThan(String value) {
            addCriterion("forcity >", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityGreaterThanOrEqualTo(String value) {
            addCriterion("forcity >=", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityLessThan(String value) {
            addCriterion("forcity <", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityLessThanOrEqualTo(String value) {
            addCriterion("forcity <=", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityLike(String value) {
            addCriterion("forcity like", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityNotLike(String value) {
            addCriterion("forcity not like", value, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityIn(java.util.List<java.lang.String> values) {
            addCriterion("forcity in", values, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forcity not in", values, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityBetween(String value1, String value2) {
            addCriterion("forcity between", value1, value2, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcityNotBetween(String value1, String value2) {
            addCriterion("forcity not between", value1, value2, "forcity");
            return (Criteria) this;
        }

        public Criteria andForcountyIsNull() {
            addCriterion("forcounty is null");
            return (Criteria) this;
        }

        public Criteria andForcountyIsNotNull() {
            addCriterion("forcounty is not null");
            return (Criteria) this;
        }

        public Criteria andForcountyEqualTo(String value) {
            addCriterion("forcounty =", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyNotEqualTo(String value) {
            addCriterion("forcounty <>", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyGreaterThan(String value) {
            addCriterion("forcounty >", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyGreaterThanOrEqualTo(String value) {
            addCriterion("forcounty >=", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyLessThan(String value) {
            addCriterion("forcounty <", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyLessThanOrEqualTo(String value) {
            addCriterion("forcounty <=", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyLike(String value) {
            addCriterion("forcounty like", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyNotLike(String value) {
            addCriterion("forcounty not like", value, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyIn(java.util.List<java.lang.String> values) {
            addCriterion("forcounty in", values, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forcounty not in", values, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyBetween(String value1, String value2) {
            addCriterion("forcounty between", value1, value2, "forcounty");
            return (Criteria) this;
        }

        public Criteria andForcountyNotBetween(String value1, String value2) {
            addCriterion("forcounty not between", value1, value2, "forcounty");
            return (Criteria) this;
        }

        public Criteria andFortownIsNull() {
            addCriterion("fortown is null");
            return (Criteria) this;
        }

        public Criteria andFortownIsNotNull() {
            addCriterion("fortown is not null");
            return (Criteria) this;
        }

        public Criteria andFortownEqualTo(String value) {
            addCriterion("fortown =", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownNotEqualTo(String value) {
            addCriterion("fortown <>", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownGreaterThan(String value) {
            addCriterion("fortown >", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownGreaterThanOrEqualTo(String value) {
            addCriterion("fortown >=", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownLessThan(String value) {
            addCriterion("fortown <", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownLessThanOrEqualTo(String value) {
            addCriterion("fortown <=", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownLike(String value) {
            addCriterion("fortown like", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownNotLike(String value) {
            addCriterion("fortown not like", value, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownIn(java.util.List<java.lang.String> values) {
            addCriterion("fortown in", values, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fortown not in", values, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownBetween(String value1, String value2) {
            addCriterion("fortown between", value1, value2, "fortown");
            return (Criteria) this;
        }

        public Criteria andFortownNotBetween(String value1, String value2) {
            addCriterion("fortown not between", value1, value2, "fortown");
            return (Criteria) this;
        }

        public Criteria andForgkIsNull() {
            addCriterion("forgk is null");
            return (Criteria) this;
        }

        public Criteria andForgkIsNotNull() {
            addCriterion("forgk is not null");
            return (Criteria) this;
        }

        public Criteria andForgkEqualTo(String value) {
            addCriterion("forgk =", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkNotEqualTo(String value) {
            addCriterion("forgk <>", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkGreaterThan(String value) {
            addCriterion("forgk >", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkGreaterThanOrEqualTo(String value) {
            addCriterion("forgk >=", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkLessThan(String value) {
            addCriterion("forgk <", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkLessThanOrEqualTo(String value) {
            addCriterion("forgk <=", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkLike(String value) {
            addCriterion("forgk like", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkNotLike(String value) {
            addCriterion("forgk not like", value, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkIn(java.util.List<java.lang.String> values) {
            addCriterion("forgk in", values, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forgk not in", values, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkBetween(String value1, String value2) {
            addCriterion("forgk between", value1, value2, "forgk");
            return (Criteria) this;
        }

        public Criteria andForgkNotBetween(String value1, String value2) {
            addCriterion("forgk not between", value1, value2, "forgk");
            return (Criteria) this;
        }

        public Criteria andFornodetypeIsNull() {
            addCriterion("fornodetype is null");
            return (Criteria) this;
        }

        public Criteria andFornodetypeIsNotNull() {
            addCriterion("fornodetype is not null");
            return (Criteria) this;
        }

        public Criteria andFornodetypeEqualTo(String value) {
            addCriterion("fornodetype =", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeNotEqualTo(String value) {
            addCriterion("fornodetype <>", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeGreaterThan(String value) {
            addCriterion("fornodetype >", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeGreaterThanOrEqualTo(String value) {
            addCriterion("fornodetype >=", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeLessThan(String value) {
            addCriterion("fornodetype <", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeLessThanOrEqualTo(String value) {
            addCriterion("fornodetype <=", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeLike(String value) {
            addCriterion("fornodetype like", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeNotLike(String value) {
            addCriterion("fornodetype not like", value, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeIn(java.util.List<java.lang.String> values) {
            addCriterion("fornodetype in", values, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fornodetype not in", values, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeBetween(String value1, String value2) {
            addCriterion("fornodetype between", value1, value2, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andFornodetypeNotBetween(String value1, String value2) {
            addCriterion("fornodetype not between", value1, value2, "fornodetype");
            return (Criteria) this;
        }

        public Criteria andOrgdutyIsNull() {
            addCriterion("orgduty is null");
            return (Criteria) this;
        }

        public Criteria andOrgdutyIsNotNull() {
            addCriterion("orgduty is not null");
            return (Criteria) this;
        }

        public Criteria andOrgdutyEqualTo(String value) {
            addCriterion("orgduty =", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyNotEqualTo(String value) {
            addCriterion("orgduty <>", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyGreaterThan(String value) {
            addCriterion("orgduty >", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyGreaterThanOrEqualTo(String value) {
            addCriterion("orgduty >=", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyLessThan(String value) {
            addCriterion("orgduty <", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyLessThanOrEqualTo(String value) {
            addCriterion("orgduty <=", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyLike(String value) {
            addCriterion("orgduty like", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyNotLike(String value) {
            addCriterion("orgduty not like", value, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyIn(java.util.List<java.lang.String> values) {
            addCriterion("orgduty in", values, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgduty not in", values, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyBetween(String value1, String value2) {
            addCriterion("orgduty between", value1, value2, "orgduty");
            return (Criteria) this;
        }

        public Criteria andOrgdutyNotBetween(String value1, String value2) {
            addCriterion("orgduty not between", value1, value2, "orgduty");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("isdelete like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("isdelete not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(java.util.List<java.lang.String> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsenableIsNull() {
            addCriterion("isenable is null");
            return (Criteria) this;
        }

        public Criteria andIsenableIsNotNull() {
            addCriterion("isenable is not null");
            return (Criteria) this;
        }

        public Criteria andIsenableEqualTo(String value) {
            addCriterion("isenable =", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotEqualTo(String value) {
            addCriterion("isenable <>", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableGreaterThan(String value) {
            addCriterion("isenable >", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableGreaterThanOrEqualTo(String value) {
            addCriterion("isenable >=", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableLessThan(String value) {
            addCriterion("isenable <", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableLessThanOrEqualTo(String value) {
            addCriterion("isenable <=", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableLike(String value) {
            addCriterion("isenable like", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotLike(String value) {
            addCriterion("isenable not like", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableIn(java.util.List<java.lang.String> values) {
            addCriterion("isenable in", values, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isenable not in", values, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableBetween(String value1, String value2) {
            addCriterion("isenable between", value1, value2, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotBetween(String value1, String value2) {
            addCriterion("isenable not between", value1, value2, "isenable");
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

        public Criteria andLogidIsNull() {
            addCriterion("logid is null");
            return (Criteria) this;
        }

        public Criteria andLogidIsNotNull() {
            addCriterion("logid is not null");
            return (Criteria) this;
        }

        public Criteria andLogidEqualTo(String value) {
            addCriterion("logid =", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotEqualTo(String value) {
            addCriterion("logid <>", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThan(String value) {
            addCriterion("logid >", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThanOrEqualTo(String value) {
            addCriterion("logid >=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThan(String value) {
            addCriterion("logid <", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThanOrEqualTo(String value) {
            addCriterion("logid <=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLike(String value) {
            addCriterion("logid like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotLike(String value) {
            addCriterion("logid not like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidIn(java.util.List<java.lang.String> values) {
            addCriterion("logid in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("logid not in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidBetween(String value1, String value2) {
            addCriterion("logid between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotBetween(String value1, String value2) {
            addCriterion("logid not between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNull() {
            addCriterion("otherid is null");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNotNull() {
            addCriterion("otherid is not null");
            return (Criteria) this;
        }

        public Criteria andOtheridEqualTo(String value) {
            addCriterion("otherid =", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotEqualTo(String value) {
            addCriterion("otherid <>", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThan(String value) {
            addCriterion("otherid >", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThanOrEqualTo(String value) {
            addCriterion("otherid >=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThan(String value) {
            addCriterion("otherid <", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThanOrEqualTo(String value) {
            addCriterion("otherid <=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLike(String value) {
            addCriterion("otherid like", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotLike(String value) {
            addCriterion("otherid not like", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridIn(java.util.List<java.lang.String> values) {
            addCriterion("otherid in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotIn(java.util.List<java.lang.String> values) {
            addCriterion("otherid not in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridBetween(String value1, String value2) {
            addCriterion("otherid between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotBetween(String value1, String value2) {
            addCriterion("otherid not between", value1, value2, "otherid");
            return (Criteria) this;
        }
    }

    /**
    c_sdzzww_orgaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}