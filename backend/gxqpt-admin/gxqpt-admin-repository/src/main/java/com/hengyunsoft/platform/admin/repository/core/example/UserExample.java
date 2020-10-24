package com.hengyunsoft.platform.admin.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample extends com.hengyunsoft.db.example.BaseExample<UserExample.Criteria> implements Serializable {
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

        public Criteria andAccountIsNull() {
            addCriterion("account_ is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account_ is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account_ =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account_ <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account_ >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account_ >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account_ <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account_ <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account_ like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account_ not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(java.util.List<java.lang.String> values) {
            addCriterion("account_ in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("account_ not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account_ between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account_ not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password_ is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password_ is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password_ =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password_ <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password_ >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password_ >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password_ <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password_ <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password_ like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password_ not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(java.util.List<java.lang.String> values) {
            addCriterion("password_ in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(java.util.List<java.lang.String> values) {
            addCriterion("password_ not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password_ between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password_ not between", value1, value2, "password");
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

        public Criteria andSexIsNull() {
            addCriterion("sex_ is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex_ is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex_ =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex_ <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex_ >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex_ >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex_ <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex_ <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex_ like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex_ not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(java.util.List<java.lang.String> values) {
            addCriterion("sex_ in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sex_ not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex_ between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex_ not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday_ is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday_ is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday_ =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday_ <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday_ >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday_ >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday_ <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday_ <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(java.util.List<java.util.Date> values) {
            addCriterion("birthday_ in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(java.util.List<java.util.Date> values) {
            addCriterion("birthday_ not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday_ between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday_ not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation_ is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation_ is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation_ =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation_ <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation_ >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation_ >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation_ <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation_ <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation_ like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation_ not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(java.util.List<java.lang.String> values) {
            addCriterion("nation_ in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("nation_ not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation_ between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation_ not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(java.util.List<java.lang.String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andOfficetelIsNull() {
            addCriterion("officetel is null");
            return (Criteria) this;
        }

        public Criteria andOfficetelIsNotNull() {
            addCriterion("officetel is not null");
            return (Criteria) this;
        }

        public Criteria andOfficetelEqualTo(String value) {
            addCriterion("officetel =", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelNotEqualTo(String value) {
            addCriterion("officetel <>", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelGreaterThan(String value) {
            addCriterion("officetel >", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelGreaterThanOrEqualTo(String value) {
            addCriterion("officetel >=", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelLessThan(String value) {
            addCriterion("officetel <", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelLessThanOrEqualTo(String value) {
            addCriterion("officetel <=", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelLike(String value) {
            addCriterion("officetel like", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelNotLike(String value) {
            addCriterion("officetel not like", value, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelIn(java.util.List<java.lang.String> values) {
            addCriterion("officetel in", values, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("officetel not in", values, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelBetween(String value1, String value2) {
            addCriterion("officetel between", value1, value2, "officetel");
            return (Criteria) this;
        }

        public Criteria andOfficetelNotBetween(String value1, String value2) {
            addCriterion("officetel not between", value1, value2, "officetel");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone_ is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone_ is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone_ =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone_ <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone_ >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone_ >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone_ <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone_ <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone_ like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone_ not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(java.util.List<java.lang.String> values) {
            addCriterion("phone_ in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("phone_ not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone_ between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone_ not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNull() {
            addCriterion("work_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNotNull() {
            addCriterion("work_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDescEqualTo(String value) {
            addCriterion("work_desc =", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotEqualTo(String value) {
            addCriterion("work_desc <>", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThan(String value) {
            addCriterion("work_desc >", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThanOrEqualTo(String value) {
            addCriterion("work_desc >=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThan(String value) {
            addCriterion("work_desc <", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThanOrEqualTo(String value) {
            addCriterion("work_desc <=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLike(String value) {
            addCriterion("work_desc like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotLike(String value) {
            addCriterion("work_desc not like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescIn(java.util.List<java.lang.String> values) {
            addCriterion("work_desc in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("work_desc not in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescBetween(String value1, String value2) {
            addCriterion("work_desc between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotBetween(String value1, String value2) {
            addCriterion("work_desc not between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(String value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(String value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(String value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(String value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(String value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLike(String value) {
            addCriterion("work_status like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotLike(String value) {
            addCriterion("work_status not like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(String value1, String value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(String value1, String value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andLoginableIsNull() {
            addCriterion("loginable is null");
            return (Criteria) this;
        }

        public Criteria andLoginableIsNotNull() {
            addCriterion("loginable is not null");
            return (Criteria) this;
        }

        public Criteria andLoginableEqualTo(Boolean value) {
            addCriterion("loginable =", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableNotEqualTo(Boolean value) {
            addCriterion("loginable <>", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableGreaterThan(Boolean value) {
            addCriterion("loginable >", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("loginable >=", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableLessThan(Boolean value) {
            addCriterion("loginable <", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableLessThanOrEqualTo(Boolean value) {
            addCriterion("loginable <=", value, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("loginable in", values, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("loginable not in", values, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableBetween(Boolean value1, Boolean value2) {
            addCriterion("loginable between", value1, value2, "loginable");
            return (Criteria) this;
        }

        public Criteria andLoginableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("loginable not between", value1, value2, "loginable");
            return (Criteria) this;
        }

        public Criteria andOwnSystemIsNull() {
            addCriterion("own_system is null");
            return (Criteria) this;
        }

        public Criteria andOwnSystemIsNotNull() {
            addCriterion("own_system is not null");
            return (Criteria) this;
        }

        public Criteria andOwnSystemEqualTo(String value) {
            addCriterion("own_system =", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemNotEqualTo(String value) {
            addCriterion("own_system <>", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemGreaterThan(String value) {
            addCriterion("own_system >", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemGreaterThanOrEqualTo(String value) {
            addCriterion("own_system >=", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemLessThan(String value) {
            addCriterion("own_system <", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemLessThanOrEqualTo(String value) {
            addCriterion("own_system <=", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemLike(String value) {
            addCriterion("own_system like", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemNotLike(String value) {
            addCriterion("own_system not like", value, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemIn(java.util.List<java.lang.String> values) {
            addCriterion("own_system in", values, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemNotIn(java.util.List<java.lang.String> values) {
            addCriterion("own_system not in", values, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemBetween(String value1, String value2) {
            addCriterion("own_system between", value1, value2, "ownSystem");
            return (Criteria) this;
        }

        public Criteria andOwnSystemNotBetween(String value1, String value2) {
            addCriterion("own_system not between", value1, value2, "ownSystem");
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

        public Criteria andTypeIsNull() {
            addCriterion("type_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type_ like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type_ not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("type_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("type_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNull() {
            addCriterion("sort_value is null");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNotNull() {
            addCriterion("sort_value is not null");
            return (Criteria) this;
        }

        public Criteria andSortValueEqualTo(Integer value) {
            addCriterion("sort_value =", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotEqualTo(Integer value) {
            addCriterion("sort_value <>", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThan(Integer value) {
            addCriterion("sort_value >", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_value >=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThan(Integer value) {
            addCriterion("sort_value <", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThanOrEqualTo(Integer value) {
            addCriterion("sort_value <=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sort_value in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sort_value not in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueBetween(Integer value1, Integer value2) {
            addCriterion("sort_value between", value1, value2, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_value not between", value1, value2, "sortValue");
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
    c_useraddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}