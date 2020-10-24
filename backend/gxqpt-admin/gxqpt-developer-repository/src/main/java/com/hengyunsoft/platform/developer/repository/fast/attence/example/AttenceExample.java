package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttenceExample extends com.hengyunsoft.db.example.BaseExample<AttenceExample.Criteria> implements Serializable {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInRemarkIsNull() {
            addCriterion("in_remark is null");
            return (Criteria) this;
        }

        public Criteria andInRemarkIsNotNull() {
            addCriterion("in_remark is not null");
            return (Criteria) this;
        }

        public Criteria andInRemarkEqualTo(String value) {
            addCriterion("in_remark =", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotEqualTo(String value) {
            addCriterion("in_remark <>", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkGreaterThan(String value) {
            addCriterion("in_remark >", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("in_remark >=", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLessThan(String value) {
            addCriterion("in_remark <", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLessThanOrEqualTo(String value) {
            addCriterion("in_remark <=", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLike(String value) {
            addCriterion("in_remark like", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotLike(String value) {
            addCriterion("in_remark not like", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkIn(java.util.List<java.lang.String> values) {
            addCriterion("in_remark in", values, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_remark not in", values, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkBetween(String value1, String value2) {
            addCriterion("in_remark between", value1, value2, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotBetween(String value1, String value2) {
            addCriterion("in_remark not between", value1, value2, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInPictureIsNull() {
            addCriterion("in_picture is null");
            return (Criteria) this;
        }

        public Criteria andInPictureIsNotNull() {
            addCriterion("in_picture is not null");
            return (Criteria) this;
        }

        public Criteria andInPictureEqualTo(String value) {
            addCriterion("in_picture =", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureNotEqualTo(String value) {
            addCriterion("in_picture <>", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureGreaterThan(String value) {
            addCriterion("in_picture >", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureGreaterThanOrEqualTo(String value) {
            addCriterion("in_picture >=", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureLessThan(String value) {
            addCriterion("in_picture <", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureLessThanOrEqualTo(String value) {
            addCriterion("in_picture <=", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureLike(String value) {
            addCriterion("in_picture like", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureNotLike(String value) {
            addCriterion("in_picture not like", value, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureIn(java.util.List<java.lang.String> values) {
            addCriterion("in_picture in", values, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_picture not in", values, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureBetween(String value1, String value2) {
            addCriterion("in_picture between", value1, value2, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInPictureNotBetween(String value1, String value2) {
            addCriterion("in_picture not between", value1, value2, "inPicture");
            return (Criteria) this;
        }

        public Criteria andInDeptIdIsNull() {
            addCriterion("in_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andInDeptIdIsNotNull() {
            addCriterion("in_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andInDeptIdEqualTo(String value) {
            addCriterion("in_dept_id =", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdNotEqualTo(String value) {
            addCriterion("in_dept_id <>", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdGreaterThan(String value) {
            addCriterion("in_dept_id >", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_dept_id >=", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdLessThan(String value) {
            addCriterion("in_dept_id <", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdLessThanOrEqualTo(String value) {
            addCriterion("in_dept_id <=", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdLike(String value) {
            addCriterion("in_dept_id like", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdNotLike(String value) {
            addCriterion("in_dept_id not like", value, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdIn(java.util.List<java.lang.String> values) {
            addCriterion("in_dept_id in", values, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_dept_id not in", values, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdBetween(String value1, String value2) {
            addCriterion("in_dept_id between", value1, value2, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInDeptIdNotBetween(String value1, String value2) {
            addCriterion("in_dept_id not between", value1, value2, "inDeptId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdIsNull() {
            addCriterion("in_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andInEmpIdIsNotNull() {
            addCriterion("in_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andInEmpIdEqualTo(String value) {
            addCriterion("in_emp_id =", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdNotEqualTo(String value) {
            addCriterion("in_emp_id <>", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdGreaterThan(String value) {
            addCriterion("in_emp_id >", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_emp_id >=", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdLessThan(String value) {
            addCriterion("in_emp_id <", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdLessThanOrEqualTo(String value) {
            addCriterion("in_emp_id <=", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdLike(String value) {
            addCriterion("in_emp_id like", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdNotLike(String value) {
            addCriterion("in_emp_id not like", value, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdIn(java.util.List<java.lang.String> values) {
            addCriterion("in_emp_id in", values, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_emp_id not in", values, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdBetween(String value1, String value2) {
            addCriterion("in_emp_id between", value1, value2, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInEmpIdNotBetween(String value1, String value2) {
            addCriterion("in_emp_id not between", value1, value2, "inEmpId");
            return (Criteria) this;
        }

        public Criteria andInLatitudeIsNull() {
            addCriterion("in_latitude is null");
            return (Criteria) this;
        }

        public Criteria andInLatitudeIsNotNull() {
            addCriterion("in_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andInLatitudeEqualTo(Double value) {
            addCriterion("in_latitude =", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeNotEqualTo(Double value) {
            addCriterion("in_latitude <>", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeGreaterThan(Double value) {
            addCriterion("in_latitude >", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("in_latitude >=", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeLessThan(Double value) {
            addCriterion("in_latitude <", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("in_latitude <=", value, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("in_latitude in", values, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("in_latitude not in", values, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeBetween(Double value1, Double value2) {
            addCriterion("in_latitude between", value1, value2, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("in_latitude not between", value1, value2, "inLatitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeIsNull() {
            addCriterion("in_longitude is null");
            return (Criteria) this;
        }

        public Criteria andInLongitudeIsNotNull() {
            addCriterion("in_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andInLongitudeEqualTo(Double value) {
            addCriterion("in_longitude =", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeNotEqualTo(Double value) {
            addCriterion("in_longitude <>", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeGreaterThan(Double value) {
            addCriterion("in_longitude >", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("in_longitude >=", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeLessThan(Double value) {
            addCriterion("in_longitude <", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("in_longitude <=", value, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("in_longitude in", values, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("in_longitude not in", values, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeBetween(Double value1, Double value2) {
            addCriterion("in_longitude between", value1, value2, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("in_longitude not between", value1, value2, "inLongitude");
            return (Criteria) this;
        }

        public Criteria andInAddressIsNull() {
            addCriterion("in_address is null");
            return (Criteria) this;
        }

        public Criteria andInAddressIsNotNull() {
            addCriterion("in_address is not null");
            return (Criteria) this;
        }

        public Criteria andInAddressEqualTo(String value) {
            addCriterion("in_address =", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressNotEqualTo(String value) {
            addCriterion("in_address <>", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressGreaterThan(String value) {
            addCriterion("in_address >", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressGreaterThanOrEqualTo(String value) {
            addCriterion("in_address >=", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressLessThan(String value) {
            addCriterion("in_address <", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressLessThanOrEqualTo(String value) {
            addCriterion("in_address <=", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressLike(String value) {
            addCriterion("in_address like", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressNotLike(String value) {
            addCriterion("in_address not like", value, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("in_address in", values, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_address not in", values, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressBetween(String value1, String value2) {
            addCriterion("in_address between", value1, value2, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAddressNotBetween(String value1, String value2) {
            addCriterion("in_address not between", value1, value2, "inAddress");
            return (Criteria) this;
        }

        public Criteria andInAutoSignIsNull() {
            addCriterion("in_auto_sign is null");
            return (Criteria) this;
        }

        public Criteria andInAutoSignIsNotNull() {
            addCriterion("in_auto_sign is not null");
            return (Criteria) this;
        }

        public Criteria andInAutoSignEqualTo(Integer value) {
            addCriterion("in_auto_sign =", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignNotEqualTo(Integer value) {
            addCriterion("in_auto_sign <>", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignGreaterThan(Integer value) {
            addCriterion("in_auto_sign >", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_auto_sign >=", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignLessThan(Integer value) {
            addCriterion("in_auto_sign <", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignLessThanOrEqualTo(Integer value) {
            addCriterion("in_auto_sign <=", value, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_auto_sign in", values, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_auto_sign not in", values, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignBetween(Integer value1, Integer value2) {
            addCriterion("in_auto_sign between", value1, value2, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andInAutoSignNotBetween(Integer value1, Integer value2) {
            addCriterion("in_auto_sign not between", value1, value2, "inAutoSign");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(java.util.List<java.lang.Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andInSignTypeIsNull() {
            addCriterion("in_sign_type is null");
            return (Criteria) this;
        }

        public Criteria andInSignTypeIsNotNull() {
            addCriterion("in_sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andInSignTypeEqualTo(Integer value) {
            addCriterion("in_sign_type =", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeNotEqualTo(Integer value) {
            addCriterion("in_sign_type <>", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeGreaterThan(Integer value) {
            addCriterion("in_sign_type >", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_sign_type >=", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeLessThan(Integer value) {
            addCriterion("in_sign_type <", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_sign_type <=", value, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_sign_type in", values, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_sign_type not in", values, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_sign_type between", value1, value2, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInSignTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_sign_type not between", value1, value2, "inSignType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeIsNull() {
            addCriterion("in_handle_type is null");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeIsNotNull() {
            addCriterion("in_handle_type is not null");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeEqualTo(Integer value) {
            addCriterion("in_handle_type =", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeNotEqualTo(Integer value) {
            addCriterion("in_handle_type <>", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeGreaterThan(Integer value) {
            addCriterion("in_handle_type >", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_handle_type >=", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeLessThan(Integer value) {
            addCriterion("in_handle_type <", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_handle_type <=", value, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_handle_type in", values, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("in_handle_type not in", values, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_handle_type between", value1, value2, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andInHandleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_handle_type not between", value1, value2, "inHandleType");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIsNull() {
            addCriterion("out_remark is null");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIsNotNull() {
            addCriterion("out_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOutRemarkEqualTo(String value) {
            addCriterion("out_remark =", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotEqualTo(String value) {
            addCriterion("out_remark <>", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkGreaterThan(String value) {
            addCriterion("out_remark >", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("out_remark >=", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLessThan(String value) {
            addCriterion("out_remark <", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLessThanOrEqualTo(String value) {
            addCriterion("out_remark <=", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLike(String value) {
            addCriterion("out_remark like", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotLike(String value) {
            addCriterion("out_remark not like", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIn(java.util.List<java.lang.String> values) {
            addCriterion("out_remark in", values, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_remark not in", values, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkBetween(String value1, String value2) {
            addCriterion("out_remark between", value1, value2, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotBetween(String value1, String value2) {
            addCriterion("out_remark not between", value1, value2, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutPictureIsNull() {
            addCriterion("out_picture is null");
            return (Criteria) this;
        }

        public Criteria andOutPictureIsNotNull() {
            addCriterion("out_picture is not null");
            return (Criteria) this;
        }

        public Criteria andOutPictureEqualTo(String value) {
            addCriterion("out_picture =", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureNotEqualTo(String value) {
            addCriterion("out_picture <>", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureGreaterThan(String value) {
            addCriterion("out_picture >", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureGreaterThanOrEqualTo(String value) {
            addCriterion("out_picture >=", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureLessThan(String value) {
            addCriterion("out_picture <", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureLessThanOrEqualTo(String value) {
            addCriterion("out_picture <=", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureLike(String value) {
            addCriterion("out_picture like", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureNotLike(String value) {
            addCriterion("out_picture not like", value, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureIn(java.util.List<java.lang.String> values) {
            addCriterion("out_picture in", values, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_picture not in", values, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureBetween(String value1, String value2) {
            addCriterion("out_picture between", value1, value2, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutPictureNotBetween(String value1, String value2) {
            addCriterion("out_picture not between", value1, value2, "outPicture");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdIsNull() {
            addCriterion("out_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdIsNotNull() {
            addCriterion("out_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdEqualTo(String value) {
            addCriterion("out_dept_id =", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdNotEqualTo(String value) {
            addCriterion("out_dept_id <>", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdGreaterThan(String value) {
            addCriterion("out_dept_id >", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_dept_id >=", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdLessThan(String value) {
            addCriterion("out_dept_id <", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdLessThanOrEqualTo(String value) {
            addCriterion("out_dept_id <=", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdLike(String value) {
            addCriterion("out_dept_id like", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdNotLike(String value) {
            addCriterion("out_dept_id not like", value, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdIn(java.util.List<java.lang.String> values) {
            addCriterion("out_dept_id in", values, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_dept_id not in", values, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdBetween(String value1, String value2) {
            addCriterion("out_dept_id between", value1, value2, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutDeptIdNotBetween(String value1, String value2) {
            addCriterion("out_dept_id not between", value1, value2, "outDeptId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdIsNull() {
            addCriterion("out_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdIsNotNull() {
            addCriterion("out_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdEqualTo(String value) {
            addCriterion("out_emp_id =", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdNotEqualTo(String value) {
            addCriterion("out_emp_id <>", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdGreaterThan(String value) {
            addCriterion("out_emp_id >", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_emp_id >=", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdLessThan(String value) {
            addCriterion("out_emp_id <", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdLessThanOrEqualTo(String value) {
            addCriterion("out_emp_id <=", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdLike(String value) {
            addCriterion("out_emp_id like", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdNotLike(String value) {
            addCriterion("out_emp_id not like", value, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdIn(java.util.List<java.lang.String> values) {
            addCriterion("out_emp_id in", values, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_emp_id not in", values, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdBetween(String value1, String value2) {
            addCriterion("out_emp_id between", value1, value2, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutEmpIdNotBetween(String value1, String value2) {
            addCriterion("out_emp_id not between", value1, value2, "outEmpId");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeIsNull() {
            addCriterion("out_latitude is null");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeIsNotNull() {
            addCriterion("out_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeEqualTo(Double value) {
            addCriterion("out_latitude =", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeNotEqualTo(Double value) {
            addCriterion("out_latitude <>", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeGreaterThan(Double value) {
            addCriterion("out_latitude >", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("out_latitude >=", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeLessThan(Double value) {
            addCriterion("out_latitude <", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("out_latitude <=", value, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_latitude in", values, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_latitude not in", values, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeBetween(Double value1, Double value2) {
            addCriterion("out_latitude between", value1, value2, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("out_latitude not between", value1, value2, "outLatitude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeIsNull() {
            addCriterion("out_longtude is null");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeIsNotNull() {
            addCriterion("out_longtude is not null");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeEqualTo(Double value) {
            addCriterion("out_longtude =", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeNotEqualTo(Double value) {
            addCriterion("out_longtude <>", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeGreaterThan(Double value) {
            addCriterion("out_longtude >", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeGreaterThanOrEqualTo(Double value) {
            addCriterion("out_longtude >=", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeLessThan(Double value) {
            addCriterion("out_longtude <", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeLessThanOrEqualTo(Double value) {
            addCriterion("out_longtude <=", value, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_longtude in", values, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_longtude not in", values, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeBetween(Double value1, Double value2) {
            addCriterion("out_longtude between", value1, value2, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutLongtudeNotBetween(Double value1, Double value2) {
            addCriterion("out_longtude not between", value1, value2, "outLongtude");
            return (Criteria) this;
        }

        public Criteria andOutAddressIsNull() {
            addCriterion("out_address is null");
            return (Criteria) this;
        }

        public Criteria andOutAddressIsNotNull() {
            addCriterion("out_address is not null");
            return (Criteria) this;
        }

        public Criteria andOutAddressEqualTo(String value) {
            addCriterion("out_address =", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotEqualTo(String value) {
            addCriterion("out_address <>", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressGreaterThan(String value) {
            addCriterion("out_address >", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressGreaterThanOrEqualTo(String value) {
            addCriterion("out_address >=", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLessThan(String value) {
            addCriterion("out_address <", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLessThanOrEqualTo(String value) {
            addCriterion("out_address <=", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLike(String value) {
            addCriterion("out_address like", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotLike(String value) {
            addCriterion("out_address not like", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("out_address in", values, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_address not in", values, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressBetween(String value1, String value2) {
            addCriterion("out_address between", value1, value2, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotBetween(String value1, String value2) {
            addCriterion("out_address not between", value1, value2, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeIsNull() {
            addCriterion("out_sign_type is null");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeIsNotNull() {
            addCriterion("out_sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeEqualTo(Integer value) {
            addCriterion("out_sign_type =", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeNotEqualTo(Integer value) {
            addCriterion("out_sign_type <>", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeGreaterThan(Integer value) {
            addCriterion("out_sign_type >", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_sign_type >=", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeLessThan(Integer value) {
            addCriterion("out_sign_type <", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_sign_type <=", value, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_sign_type in", values, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_sign_type not in", values, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_sign_type between", value1, value2, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutSignTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_sign_type not between", value1, value2, "outSignType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeIsNull() {
            addCriterion("out_handle_type is null");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeIsNotNull() {
            addCriterion("out_handle_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeEqualTo(Integer value) {
            addCriterion("out_handle_type =", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeNotEqualTo(Integer value) {
            addCriterion("out_handle_type <>", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeGreaterThan(Integer value) {
            addCriterion("out_handle_type >", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_handle_type >=", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeLessThan(Integer value) {
            addCriterion("out_handle_type <", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_handle_type <=", value, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_handle_type in", values, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_handle_type not in", values, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_handle_type between", value1, value2, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutHandleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_handle_type not between", value1, value2, "outHandleType");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignIsNull() {
            addCriterion("out_auto_sign is null");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignIsNotNull() {
            addCriterion("out_auto_sign is not null");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignEqualTo(Integer value) {
            addCriterion("out_auto_sign =", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignNotEqualTo(Integer value) {
            addCriterion("out_auto_sign <>", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignGreaterThan(Integer value) {
            addCriterion("out_auto_sign >", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_auto_sign >=", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignLessThan(Integer value) {
            addCriterion("out_auto_sign <", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignLessThanOrEqualTo(Integer value) {
            addCriterion("out_auto_sign <=", value, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_auto_sign in", values, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("out_auto_sign not in", values, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignBetween(Integer value1, Integer value2) {
            addCriterion("out_auto_sign between", value1, value2, "outAutoSign");
            return (Criteria) this;
        }

        public Criteria andOutAutoSignNotBetween(Integer value1, Integer value2) {
            addCriterion("out_auto_sign not between", value1, value2, "outAutoSign");
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
    b_attenceaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}