package com.hengyunsoft.platform.admin.repository.org.sdzzww.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SdzzwwEmpExample extends com.hengyunsoft.db.example.BaseExample<SdzzwwEmpExample.Criteria> implements Serializable {
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(java.util.List<java.lang.String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5IsNull() {
            addCriterion("passwordmd5 is null");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5IsNotNull() {
            addCriterion("passwordmd5 is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5EqualTo(String value) {
            addCriterion("passwordmd5 =", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5NotEqualTo(String value) {
            addCriterion("passwordmd5 <>", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5GreaterThan(String value) {
            addCriterion("passwordmd5 >", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5GreaterThanOrEqualTo(String value) {
            addCriterion("passwordmd5 >=", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5LessThan(String value) {
            addCriterion("passwordmd5 <", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5LessThanOrEqualTo(String value) {
            addCriterion("passwordmd5 <=", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5Like(String value) {
            addCriterion("passwordmd5 like", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5NotLike(String value) {
            addCriterion("passwordmd5 not like", value, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5In(java.util.List<java.lang.String> values) {
            addCriterion("passwordmd5 in", values, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5NotIn(java.util.List<java.lang.String> values) {
            addCriterion("passwordmd5 not in", values, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5Between(String value1, String value2) {
            addCriterion("passwordmd5 between", value1, value2, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordmd5NotBetween(String value1, String value2) {
            addCriterion("passwordmd5 not between", value1, value2, "passwordmd5");
            return (Criteria) this;
        }

        public Criteria andPasswordshaIsNull() {
            addCriterion("passwordsha is null");
            return (Criteria) this;
        }

        public Criteria andPasswordshaIsNotNull() {
            addCriterion("passwordsha is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordshaEqualTo(String value) {
            addCriterion("passwordsha =", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaNotEqualTo(String value) {
            addCriterion("passwordsha <>", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaGreaterThan(String value) {
            addCriterion("passwordsha >", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaGreaterThanOrEqualTo(String value) {
            addCriterion("passwordsha >=", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaLessThan(String value) {
            addCriterion("passwordsha <", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaLessThanOrEqualTo(String value) {
            addCriterion("passwordsha <=", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaLike(String value) {
            addCriterion("passwordsha like", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaNotLike(String value) {
            addCriterion("passwordsha not like", value, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaIn(java.util.List<java.lang.String> values) {
            addCriterion("passwordsha in", values, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaNotIn(java.util.List<java.lang.String> values) {
            addCriterion("passwordsha not in", values, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaBetween(String value1, String value2) {
            addCriterion("passwordsha between", value1, value2, "passwordsha");
            return (Criteria) this;
        }

        public Criteria andPasswordshaNotBetween(String value1, String value2) {
            addCriterion("passwordsha not between", value1, value2, "passwordsha");
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

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday_ =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday_ <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday_ >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday_ >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday_ <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday_ <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday_ like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday_ not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(java.util.List<java.lang.String> values) {
            addCriterion("birthday_ in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(java.util.List<java.lang.String> values) {
            addCriterion("birthday_ not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday_ between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
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

        public Criteria andMainorgidIsNull() {
            addCriterion("mainorgid is null");
            return (Criteria) this;
        }

        public Criteria andMainorgidIsNotNull() {
            addCriterion("mainorgid is not null");
            return (Criteria) this;
        }

        public Criteria andMainorgidEqualTo(String value) {
            addCriterion("mainorgid =", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidNotEqualTo(String value) {
            addCriterion("mainorgid <>", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidGreaterThan(String value) {
            addCriterion("mainorgid >", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidGreaterThanOrEqualTo(String value) {
            addCriterion("mainorgid >=", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidLessThan(String value) {
            addCriterion("mainorgid <", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidLessThanOrEqualTo(String value) {
            addCriterion("mainorgid <=", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidLike(String value) {
            addCriterion("mainorgid like", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidNotLike(String value) {
            addCriterion("mainorgid not like", value, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidIn(java.util.List<java.lang.String> values) {
            addCriterion("mainorgid in", values, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainorgid not in", values, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidBetween(String value1, String value2) {
            addCriterion("mainorgid between", value1, value2, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgidNotBetween(String value1, String value2) {
            addCriterion("mainorgid not between", value1, value2, "mainorgid");
            return (Criteria) this;
        }

        public Criteria andMainorgnameIsNull() {
            addCriterion("mainorgname is null");
            return (Criteria) this;
        }

        public Criteria andMainorgnameIsNotNull() {
            addCriterion("mainorgname is not null");
            return (Criteria) this;
        }

        public Criteria andMainorgnameEqualTo(String value) {
            addCriterion("mainorgname =", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameNotEqualTo(String value) {
            addCriterion("mainorgname <>", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameGreaterThan(String value) {
            addCriterion("mainorgname >", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameGreaterThanOrEqualTo(String value) {
            addCriterion("mainorgname >=", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameLessThan(String value) {
            addCriterion("mainorgname <", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameLessThanOrEqualTo(String value) {
            addCriterion("mainorgname <=", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameLike(String value) {
            addCriterion("mainorgname like", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameNotLike(String value) {
            addCriterion("mainorgname not like", value, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameIn(java.util.List<java.lang.String> values) {
            addCriterion("mainorgname in", values, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainorgname not in", values, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameBetween(String value1, String value2) {
            addCriterion("mainorgname between", value1, value2, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMainorgnameNotBetween(String value1, String value2) {
            addCriterion("mainorgname not between", value1, value2, "mainorgname");
            return (Criteria) this;
        }

        public Criteria andMaindeptidIsNull() {
            addCriterion("maindeptid is null");
            return (Criteria) this;
        }

        public Criteria andMaindeptidIsNotNull() {
            addCriterion("maindeptid is not null");
            return (Criteria) this;
        }

        public Criteria andMaindeptidEqualTo(String value) {
            addCriterion("maindeptid =", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidNotEqualTo(String value) {
            addCriterion("maindeptid <>", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidGreaterThan(String value) {
            addCriterion("maindeptid >", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidGreaterThanOrEqualTo(String value) {
            addCriterion("maindeptid >=", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidLessThan(String value) {
            addCriterion("maindeptid <", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidLessThanOrEqualTo(String value) {
            addCriterion("maindeptid <=", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidLike(String value) {
            addCriterion("maindeptid like", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidNotLike(String value) {
            addCriterion("maindeptid not like", value, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidIn(java.util.List<java.lang.String> values) {
            addCriterion("maindeptid in", values, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("maindeptid not in", values, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidBetween(String value1, String value2) {
            addCriterion("maindeptid between", value1, value2, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptidNotBetween(String value1, String value2) {
            addCriterion("maindeptid not between", value1, value2, "maindeptid");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameIsNull() {
            addCriterion("maindeptname is null");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameIsNotNull() {
            addCriterion("maindeptname is not null");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameEqualTo(String value) {
            addCriterion("maindeptname =", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameNotEqualTo(String value) {
            addCriterion("maindeptname <>", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameGreaterThan(String value) {
            addCriterion("maindeptname >", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("maindeptname >=", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameLessThan(String value) {
            addCriterion("maindeptname <", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameLessThanOrEqualTo(String value) {
            addCriterion("maindeptname <=", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameLike(String value) {
            addCriterion("maindeptname like", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameNotLike(String value) {
            addCriterion("maindeptname not like", value, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameIn(java.util.List<java.lang.String> values) {
            addCriterion("maindeptname in", values, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("maindeptname not in", values, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameBetween(String value1, String value2) {
            addCriterion("maindeptname between", value1, value2, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindeptnameNotBetween(String value1, String value2) {
            addCriterion("maindeptname not between", value1, value2, "maindeptname");
            return (Criteria) this;
        }

        public Criteria andMaindutyIsNull() {
            addCriterion("mainduty is null");
            return (Criteria) this;
        }

        public Criteria andMaindutyIsNotNull() {
            addCriterion("mainduty is not null");
            return (Criteria) this;
        }

        public Criteria andMaindutyEqualTo(String value) {
            addCriterion("mainduty =", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyNotEqualTo(String value) {
            addCriterion("mainduty <>", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyGreaterThan(String value) {
            addCriterion("mainduty >", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyGreaterThanOrEqualTo(String value) {
            addCriterion("mainduty >=", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyLessThan(String value) {
            addCriterion("mainduty <", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyLessThanOrEqualTo(String value) {
            addCriterion("mainduty <=", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyLike(String value) {
            addCriterion("mainduty like", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyNotLike(String value) {
            addCriterion("mainduty not like", value, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyIn(java.util.List<java.lang.String> values) {
            addCriterion("mainduty in", values, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainduty not in", values, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyBetween(String value1, String value2) {
            addCriterion("mainduty between", value1, value2, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutyNotBetween(String value1, String value2) {
            addCriterion("mainduty not between", value1, value2, "mainduty");
            return (Criteria) this;
        }

        public Criteria andMaindutynameIsNull() {
            addCriterion("maindutyname is null");
            return (Criteria) this;
        }

        public Criteria andMaindutynameIsNotNull() {
            addCriterion("maindutyname is not null");
            return (Criteria) this;
        }

        public Criteria andMaindutynameEqualTo(String value) {
            addCriterion("maindutyname =", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameNotEqualTo(String value) {
            addCriterion("maindutyname <>", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameGreaterThan(String value) {
            addCriterion("maindutyname >", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameGreaterThanOrEqualTo(String value) {
            addCriterion("maindutyname >=", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameLessThan(String value) {
            addCriterion("maindutyname <", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameLessThanOrEqualTo(String value) {
            addCriterion("maindutyname <=", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameLike(String value) {
            addCriterion("maindutyname like", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameNotLike(String value) {
            addCriterion("maindutyname not like", value, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameIn(java.util.List<java.lang.String> values) {
            addCriterion("maindutyname in", values, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("maindutyname not in", values, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameBetween(String value1, String value2) {
            addCriterion("maindutyname between", value1, value2, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMaindutynameNotBetween(String value1, String value2) {
            addCriterion("maindutyname not between", value1, value2, "maindutyname");
            return (Criteria) this;
        }

        public Criteria andMainpostIsNull() {
            addCriterion("mainpost is null");
            return (Criteria) this;
        }

        public Criteria andMainpostIsNotNull() {
            addCriterion("mainpost is not null");
            return (Criteria) this;
        }

        public Criteria andMainpostEqualTo(String value) {
            addCriterion("mainpost =", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostNotEqualTo(String value) {
            addCriterion("mainpost <>", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostGreaterThan(String value) {
            addCriterion("mainpost >", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostGreaterThanOrEqualTo(String value) {
            addCriterion("mainpost >=", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostLessThan(String value) {
            addCriterion("mainpost <", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostLessThanOrEqualTo(String value) {
            addCriterion("mainpost <=", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostLike(String value) {
            addCriterion("mainpost like", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostNotLike(String value) {
            addCriterion("mainpost not like", value, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostIn(java.util.List<java.lang.String> values) {
            addCriterion("mainpost in", values, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainpost not in", values, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostBetween(String value1, String value2) {
            addCriterion("mainpost between", value1, value2, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostNotBetween(String value1, String value2) {
            addCriterion("mainpost not between", value1, value2, "mainpost");
            return (Criteria) this;
        }

        public Criteria andMainpostnameIsNull() {
            addCriterion("mainpostname is null");
            return (Criteria) this;
        }

        public Criteria andMainpostnameIsNotNull() {
            addCriterion("mainpostname is not null");
            return (Criteria) this;
        }

        public Criteria andMainpostnameEqualTo(String value) {
            addCriterion("mainpostname =", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameNotEqualTo(String value) {
            addCriterion("mainpostname <>", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameGreaterThan(String value) {
            addCriterion("mainpostname >", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameGreaterThanOrEqualTo(String value) {
            addCriterion("mainpostname >=", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameLessThan(String value) {
            addCriterion("mainpostname <", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameLessThanOrEqualTo(String value) {
            addCriterion("mainpostname <=", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameLike(String value) {
            addCriterion("mainpostname like", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameNotLike(String value) {
            addCriterion("mainpostname not like", value, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameIn(java.util.List<java.lang.String> values) {
            addCriterion("mainpostname in", values, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainpostname not in", values, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameBetween(String value1, String value2) {
            addCriterion("mainpostname between", value1, value2, "mainpostname");
            return (Criteria) this;
        }

        public Criteria andMainpostnameNotBetween(String value1, String value2) {
            addCriterion("mainpostname not between", value1, value2, "mainpostname");
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

        public Criteria andMainmobileIsNull() {
            addCriterion("mainmobile is null");
            return (Criteria) this;
        }

        public Criteria andMainmobileIsNotNull() {
            addCriterion("mainmobile is not null");
            return (Criteria) this;
        }

        public Criteria andMainmobileEqualTo(String value) {
            addCriterion("mainmobile =", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileNotEqualTo(String value) {
            addCriterion("mainmobile <>", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileGreaterThan(String value) {
            addCriterion("mainmobile >", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileGreaterThanOrEqualTo(String value) {
            addCriterion("mainmobile >=", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileLessThan(String value) {
            addCriterion("mainmobile <", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileLessThanOrEqualTo(String value) {
            addCriterion("mainmobile <=", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileLike(String value) {
            addCriterion("mainmobile like", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileNotLike(String value) {
            addCriterion("mainmobile not like", value, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileIn(java.util.List<java.lang.String> values) {
            addCriterion("mainmobile in", values, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mainmobile not in", values, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileBetween(String value1, String value2) {
            addCriterion("mainmobile between", value1, value2, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andMainmobileNotBetween(String value1, String value2) {
            addCriterion("mainmobile not between", value1, value2, "mainmobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileIsNull() {
            addCriterion("submobile is null");
            return (Criteria) this;
        }

        public Criteria andSubmobileIsNotNull() {
            addCriterion("submobile is not null");
            return (Criteria) this;
        }

        public Criteria andSubmobileEqualTo(String value) {
            addCriterion("submobile =", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileNotEqualTo(String value) {
            addCriterion("submobile <>", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileGreaterThan(String value) {
            addCriterion("submobile >", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileGreaterThanOrEqualTo(String value) {
            addCriterion("submobile >=", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileLessThan(String value) {
            addCriterion("submobile <", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileLessThanOrEqualTo(String value) {
            addCriterion("submobile <=", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileLike(String value) {
            addCriterion("submobile like", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileNotLike(String value) {
            addCriterion("submobile not like", value, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileIn(java.util.List<java.lang.String> values) {
            addCriterion("submobile in", values, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileNotIn(java.util.List<java.lang.String> values) {
            addCriterion("submobile not in", values, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileBetween(String value1, String value2) {
            addCriterion("submobile between", value1, value2, "submobile");
            return (Criteria) this;
        }

        public Criteria andSubmobileNotBetween(String value1, String value2) {
            addCriterion("submobile not between", value1, value2, "submobile");
            return (Criteria) this;
        }

        public Criteria andIsorgadminIsNull() {
            addCriterion("isorgadmin is null");
            return (Criteria) this;
        }

        public Criteria andIsorgadminIsNotNull() {
            addCriterion("isorgadmin is not null");
            return (Criteria) this;
        }

        public Criteria andIsorgadminEqualTo(String value) {
            addCriterion("isorgadmin =", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminNotEqualTo(String value) {
            addCriterion("isorgadmin <>", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminGreaterThan(String value) {
            addCriterion("isorgadmin >", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminGreaterThanOrEqualTo(String value) {
            addCriterion("isorgadmin >=", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminLessThan(String value) {
            addCriterion("isorgadmin <", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminLessThanOrEqualTo(String value) {
            addCriterion("isorgadmin <=", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminLike(String value) {
            addCriterion("isorgadmin like", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminNotLike(String value) {
            addCriterion("isorgadmin not like", value, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminIn(java.util.List<java.lang.String> values) {
            addCriterion("isorgadmin in", values, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isorgadmin not in", values, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminBetween(String value1, String value2) {
            addCriterion("isorgadmin between", value1, value2, "isorgadmin");
            return (Criteria) this;
        }

        public Criteria andIsorgadminNotBetween(String value1, String value2) {
            addCriterion("isorgadmin not between", value1, value2, "isorgadmin");
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

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(String value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(String value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(String value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(String value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(String value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(String value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLike(String value) {
            addCriterion("usertype like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotLike(String value) {
            addCriterion("usertype not like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(java.util.List<java.lang.String> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(String value1, String value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(String value1, String value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
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

        public Criteria andIscommitteeIsNull() {
            addCriterion("iscommittee is null");
            return (Criteria) this;
        }

        public Criteria andIscommitteeIsNotNull() {
            addCriterion("iscommittee is not null");
            return (Criteria) this;
        }

        public Criteria andIscommitteeEqualTo(String value) {
            addCriterion("iscommittee =", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeNotEqualTo(String value) {
            addCriterion("iscommittee <>", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeGreaterThan(String value) {
            addCriterion("iscommittee >", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeGreaterThanOrEqualTo(String value) {
            addCriterion("iscommittee >=", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeLessThan(String value) {
            addCriterion("iscommittee <", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeLessThanOrEqualTo(String value) {
            addCriterion("iscommittee <=", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeLike(String value) {
            addCriterion("iscommittee like", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeNotLike(String value) {
            addCriterion("iscommittee not like", value, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeIn(java.util.List<java.lang.String> values) {
            addCriterion("iscommittee in", values, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("iscommittee not in", values, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeBetween(String value1, String value2) {
            addCriterion("iscommittee between", value1, value2, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIscommitteeNotBetween(String value1, String value2) {
            addCriterion("iscommittee not between", value1, value2, "iscommittee");
            return (Criteria) this;
        }

        public Criteria andIsdeputyIsNull() {
            addCriterion("isdeputy is null");
            return (Criteria) this;
        }

        public Criteria andIsdeputyIsNotNull() {
            addCriterion("isdeputy is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeputyEqualTo(String value) {
            addCriterion("isdeputy =", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyNotEqualTo(String value) {
            addCriterion("isdeputy <>", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyGreaterThan(String value) {
            addCriterion("isdeputy >", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyGreaterThanOrEqualTo(String value) {
            addCriterion("isdeputy >=", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyLessThan(String value) {
            addCriterion("isdeputy <", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyLessThanOrEqualTo(String value) {
            addCriterion("isdeputy <=", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyLike(String value) {
            addCriterion("isdeputy like", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyNotLike(String value) {
            addCriterion("isdeputy not like", value, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyIn(java.util.List<java.lang.String> values) {
            addCriterion("isdeputy in", values, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isdeputy not in", values, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyBetween(String value1, String value2) {
            addCriterion("isdeputy between", value1, value2, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsdeputyNotBetween(String value1, String value2) {
            addCriterion("isdeputy not between", value1, value2, "isdeputy");
            return (Criteria) this;
        }

        public Criteria andIsheaderIsNull() {
            addCriterion("isheader is null");
            return (Criteria) this;
        }

        public Criteria andIsheaderIsNotNull() {
            addCriterion("isheader is not null");
            return (Criteria) this;
        }

        public Criteria andIsheaderEqualTo(String value) {
            addCriterion("isheader =", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderNotEqualTo(String value) {
            addCriterion("isheader <>", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderGreaterThan(String value) {
            addCriterion("isheader >", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderGreaterThanOrEqualTo(String value) {
            addCriterion("isheader >=", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderLessThan(String value) {
            addCriterion("isheader <", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderLessThanOrEqualTo(String value) {
            addCriterion("isheader <=", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderLike(String value) {
            addCriterion("isheader like", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderNotLike(String value) {
            addCriterion("isheader not like", value, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderIn(java.util.List<java.lang.String> values) {
            addCriterion("isheader in", values, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isheader not in", values, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderBetween(String value1, String value2) {
            addCriterion("isheader between", value1, value2, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsheaderNotBetween(String value1, String value2) {
            addCriterion("isheader not between", value1, value2, "isheader");
            return (Criteria) this;
        }

        public Criteria andIsleaderIsNull() {
            addCriterion("isleader is null");
            return (Criteria) this;
        }

        public Criteria andIsleaderIsNotNull() {
            addCriterion("isleader is not null");
            return (Criteria) this;
        }

        public Criteria andIsleaderEqualTo(String value) {
            addCriterion("isleader =", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotEqualTo(String value) {
            addCriterion("isleader <>", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderGreaterThan(String value) {
            addCriterion("isleader >", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderGreaterThanOrEqualTo(String value) {
            addCriterion("isleader >=", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLessThan(String value) {
            addCriterion("isleader <", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLessThanOrEqualTo(String value) {
            addCriterion("isleader <=", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLike(String value) {
            addCriterion("isleader like", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotLike(String value) {
            addCriterion("isleader not like", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderIn(java.util.List<java.lang.String> values) {
            addCriterion("isleader in", values, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotIn(java.util.List<java.lang.String> values) {
            addCriterion("isleader not in", values, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderBetween(String value1, String value2) {
            addCriterion("isleader between", value1, value2, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotBetween(String value1, String value2) {
            addCriterion("isleader not between", value1, value2, "isleader");
            return (Criteria) this;
        }

        public Criteria andUserdutyIsNull() {
            addCriterion("userduty is null");
            return (Criteria) this;
        }

        public Criteria andUserdutyIsNotNull() {
            addCriterion("userduty is not null");
            return (Criteria) this;
        }

        public Criteria andUserdutyEqualTo(String value) {
            addCriterion("userduty =", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotEqualTo(String value) {
            addCriterion("userduty <>", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyGreaterThan(String value) {
            addCriterion("userduty >", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyGreaterThanOrEqualTo(String value) {
            addCriterion("userduty >=", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLessThan(String value) {
            addCriterion("userduty <", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLessThanOrEqualTo(String value) {
            addCriterion("userduty <=", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLike(String value) {
            addCriterion("userduty like", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotLike(String value) {
            addCriterion("userduty not like", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyIn(java.util.List<java.lang.String> values) {
            addCriterion("userduty in", values, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("userduty not in", values, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyBetween(String value1, String value2) {
            addCriterion("userduty between", value1, value2, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotBetween(String value1, String value2) {
            addCriterion("userduty not between", value1, value2, "userduty");
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

        public Criteria andDutylevelIsNull() {
            addCriterion("dutylevel is null");
            return (Criteria) this;
        }

        public Criteria andDutylevelIsNotNull() {
            addCriterion("dutylevel is not null");
            return (Criteria) this;
        }

        public Criteria andDutylevelEqualTo(String value) {
            addCriterion("dutylevel =", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelNotEqualTo(String value) {
            addCriterion("dutylevel <>", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelGreaterThan(String value) {
            addCriterion("dutylevel >", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelGreaterThanOrEqualTo(String value) {
            addCriterion("dutylevel >=", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelLessThan(String value) {
            addCriterion("dutylevel <", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelLessThanOrEqualTo(String value) {
            addCriterion("dutylevel <=", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelLike(String value) {
            addCriterion("dutylevel like", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelNotLike(String value) {
            addCriterion("dutylevel not like", value, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelIn(java.util.List<java.lang.String> values) {
            addCriterion("dutylevel in", values, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("dutylevel not in", values, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelBetween(String value1, String value2) {
            addCriterion("dutylevel between", value1, value2, "dutylevel");
            return (Criteria) this;
        }

        public Criteria andDutylevelNotBetween(String value1, String value2) {
            addCriterion("dutylevel not between", value1, value2, "dutylevel");
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

        public Criteria andGxqptEmpIdIsNull() {
            addCriterion("gxqpt_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdIsNotNull() {
            addCriterion("gxqpt_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdEqualTo(Long value) {
            addCriterion("gxqpt_emp_id =", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdNotEqualTo(Long value) {
            addCriterion("gxqpt_emp_id <>", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdGreaterThan(Long value) {
            addCriterion("gxqpt_emp_id >", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gxqpt_emp_id >=", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdLessThan(Long value) {
            addCriterion("gxqpt_emp_id <", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdLessThanOrEqualTo(Long value) {
            addCriterion("gxqpt_emp_id <=", value, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("gxqpt_emp_id in", values, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("gxqpt_emp_id not in", values, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdBetween(Long value1, Long value2) {
            addCriterion("gxqpt_emp_id between", value1, value2, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andGxqptEmpIdNotBetween(Long value1, Long value2) {
            addCriterion("gxqpt_emp_id not between", value1, value2, "gxqptEmpId");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(java.util.List<java.lang.String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEmpNoIsNull() {
            addCriterion("emp_no is null");
            return (Criteria) this;
        }

        public Criteria andEmpNoIsNotNull() {
            addCriterion("emp_no is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNoEqualTo(String value) {
            addCriterion("emp_no =", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotEqualTo(String value) {
            addCriterion("emp_no <>", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoGreaterThan(String value) {
            addCriterion("emp_no >", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoGreaterThanOrEqualTo(String value) {
            addCriterion("emp_no >=", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLessThan(String value) {
            addCriterion("emp_no <", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLessThanOrEqualTo(String value) {
            addCriterion("emp_no <=", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLike(String value) {
            addCriterion("emp_no like", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotLike(String value) {
            addCriterion("emp_no not like", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoIn(java.util.List<java.lang.String> values) {
            addCriterion("emp_no in", values, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("emp_no not in", values, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoBetween(String value1, String value2) {
            addCriterion("emp_no between", value1, value2, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotBetween(String value1, String value2) {
            addCriterion("emp_no not between", value1, value2, "empNo");
            return (Criteria) this;
        }
    }

    /**
    c_sdzzww_empaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}