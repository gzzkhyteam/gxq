package com.hengyunsoft.platform.mt.repository.version.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientVersionExample extends com.hengyunsoft.db.example.BaseExample<ClientVersionExample.Criteria> implements Serializable {
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

        public Criteria andVerNameIsNull() {
            addCriterion("ver_name is null");
            return (Criteria) this;
        }

        public Criteria andVerNameIsNotNull() {
            addCriterion("ver_name is not null");
            return (Criteria) this;
        }

        public Criteria andVerNameEqualTo(String value) {
            addCriterion("ver_name =", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameNotEqualTo(String value) {
            addCriterion("ver_name <>", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameGreaterThan(String value) {
            addCriterion("ver_name >", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameGreaterThanOrEqualTo(String value) {
            addCriterion("ver_name >=", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameLessThan(String value) {
            addCriterion("ver_name <", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameLessThanOrEqualTo(String value) {
            addCriterion("ver_name <=", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameLike(String value) {
            addCriterion("ver_name like", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameNotLike(String value) {
            addCriterion("ver_name not like", value, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameIn(java.util.List<java.lang.String> values) {
            addCriterion("ver_name in", values, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ver_name not in", values, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameBetween(String value1, String value2) {
            addCriterion("ver_name between", value1, value2, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNameNotBetween(String value1, String value2) {
            addCriterion("ver_name not between", value1, value2, "verName");
            return (Criteria) this;
        }

        public Criteria andVerNumberIsNull() {
            addCriterion("ver_number is null");
            return (Criteria) this;
        }

        public Criteria andVerNumberIsNotNull() {
            addCriterion("ver_number is not null");
            return (Criteria) this;
        }

        public Criteria andVerNumberEqualTo(Integer value) {
            addCriterion("ver_number =", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberNotEqualTo(Integer value) {
            addCriterion("ver_number <>", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberGreaterThan(Integer value) {
            addCriterion("ver_number >", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ver_number >=", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberLessThan(Integer value) {
            addCriterion("ver_number <", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ver_number <=", value, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ver_number in", values, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ver_number not in", values, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberBetween(Integer value1, Integer value2) {
            addCriterion("ver_number between", value1, value2, "verNumber");
            return (Criteria) this;
        }

        public Criteria andVerNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ver_number not between", value1, value2, "verNumber");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeIsNull() {
            addCriterion("down_qr_code is null");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeIsNotNull() {
            addCriterion("down_qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeEqualTo(String value) {
            addCriterion("down_qr_code =", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeNotEqualTo(String value) {
            addCriterion("down_qr_code <>", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeGreaterThan(String value) {
            addCriterion("down_qr_code >", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("down_qr_code >=", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeLessThan(String value) {
            addCriterion("down_qr_code <", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeLessThanOrEqualTo(String value) {
            addCriterion("down_qr_code <=", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeLike(String value) {
            addCriterion("down_qr_code like", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeNotLike(String value) {
            addCriterion("down_qr_code not like", value, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("down_qr_code in", values, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("down_qr_code not in", values, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeBetween(String value1, String value2) {
            addCriterion("down_qr_code between", value1, value2, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andDownQrCodeNotBetween(String value1, String value2) {
            addCriterion("down_qr_code not between", value1, value2, "downQrCode");
            return (Criteria) this;
        }

        public Criteria andPwUpdateIsNull() {
            addCriterion("pw_update is null");
            return (Criteria) this;
        }

        public Criteria andPwUpdateIsNotNull() {
            addCriterion("pw_update is not null");
            return (Criteria) this;
        }

        public Criteria andPwUpdateEqualTo(Integer value) {
            addCriterion("pw_update =", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateNotEqualTo(Integer value) {
            addCriterion("pw_update <>", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateGreaterThan(Integer value) {
            addCriterion("pw_update >", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pw_update >=", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateLessThan(Integer value) {
            addCriterion("pw_update <", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("pw_update <=", value, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pw_update in", values, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pw_update not in", values, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateBetween(Integer value1, Integer value2) {
            addCriterion("pw_update between", value1, value2, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPwUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("pw_update not between", value1, value2, "pwUpdate");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andApkFileIdIsNull() {
            addCriterion("apk_file_id is null");
            return (Criteria) this;
        }

        public Criteria andApkFileIdIsNotNull() {
            addCriterion("apk_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andApkFileIdEqualTo(String value) {
            addCriterion("apk_file_id =", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdNotEqualTo(String value) {
            addCriterion("apk_file_id <>", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdGreaterThan(String value) {
            addCriterion("apk_file_id >", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("apk_file_id >=", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdLessThan(String value) {
            addCriterion("apk_file_id <", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdLessThanOrEqualTo(String value) {
            addCriterion("apk_file_id <=", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdLike(String value) {
            addCriterion("apk_file_id like", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdNotLike(String value) {
            addCriterion("apk_file_id not like", value, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_id in", values, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_id not in", values, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdBetween(String value1, String value2) {
            addCriterion("apk_file_id between", value1, value2, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileIdNotBetween(String value1, String value2) {
            addCriterion("apk_file_id not between", value1, value2, "apkFileId");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIsNull() {
            addCriterion("apk_file_name is null");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIsNotNull() {
            addCriterion("apk_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andApkFileNameEqualTo(String value) {
            addCriterion("apk_file_name =", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotEqualTo(String value) {
            addCriterion("apk_file_name <>", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameGreaterThan(String value) {
            addCriterion("apk_file_name >", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("apk_file_name >=", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLessThan(String value) {
            addCriterion("apk_file_name <", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLessThanOrEqualTo(String value) {
            addCriterion("apk_file_name <=", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLike(String value) {
            addCriterion("apk_file_name like", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotLike(String value) {
            addCriterion("apk_file_name not like", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_name in", values, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_name not in", values, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameBetween(String value1, String value2) {
            addCriterion("apk_file_name between", value1, value2, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotBetween(String value1, String value2) {
            addCriterion("apk_file_name not between", value1, value2, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFilePathIsNull() {
            addCriterion("apk_file_path is null");
            return (Criteria) this;
        }

        public Criteria andApkFilePathIsNotNull() {
            addCriterion("apk_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andApkFilePathEqualTo(String value) {
            addCriterion("apk_file_path =", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathNotEqualTo(String value) {
            addCriterion("apk_file_path <>", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathGreaterThan(String value) {
            addCriterion("apk_file_path >", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("apk_file_path >=", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathLessThan(String value) {
            addCriterion("apk_file_path <", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathLessThanOrEqualTo(String value) {
            addCriterion("apk_file_path <=", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathLike(String value) {
            addCriterion("apk_file_path like", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathNotLike(String value) {
            addCriterion("apk_file_path not like", value, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_path in", values, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_path not in", values, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathBetween(String value1, String value2) {
            addCriterion("apk_file_path between", value1, value2, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFilePathNotBetween(String value1, String value2) {
            addCriterion("apk_file_path not between", value1, value2, "apkFilePath");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeIsNull() {
            addCriterion("apk_file_size is null");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeIsNotNull() {
            addCriterion("apk_file_size is not null");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeEqualTo(String value) {
            addCriterion("apk_file_size =", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeNotEqualTo(String value) {
            addCriterion("apk_file_size <>", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeGreaterThan(String value) {
            addCriterion("apk_file_size >", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("apk_file_size >=", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeLessThan(String value) {
            addCriterion("apk_file_size <", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeLessThanOrEqualTo(String value) {
            addCriterion("apk_file_size <=", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeLike(String value) {
            addCriterion("apk_file_size like", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeNotLike(String value) {
            addCriterion("apk_file_size not like", value, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_size in", values, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apk_file_size not in", values, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeBetween(String value1, String value2) {
            addCriterion("apk_file_size between", value1, value2, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andApkFileSizeNotBetween(String value1, String value2) {
            addCriterion("apk_file_size not between", value1, value2, "apkFileSize");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIsNull() {
            addCriterion("update_content is null");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIsNotNull() {
            addCriterion("update_content is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateContentEqualTo(String value) {
            addCriterion("update_content =", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotEqualTo(String value) {
            addCriterion("update_content <>", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentGreaterThan(String value) {
            addCriterion("update_content >", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentGreaterThanOrEqualTo(String value) {
            addCriterion("update_content >=", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLessThan(String value) {
            addCriterion("update_content <", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLessThanOrEqualTo(String value) {
            addCriterion("update_content <=", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLike(String value) {
            addCriterion("update_content like", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotLike(String value) {
            addCriterion("update_content not like", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIn(java.util.List<java.lang.String> values) {
            addCriterion("update_content in", values, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_content not in", values, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentBetween(String value1, String value2) {
            addCriterion("update_content between", value1, value2, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotBetween(String value1, String value2) {
            addCriterion("update_content not between", value1, value2, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIsNull() {
            addCriterion("update_num is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIsNotNull() {
            addCriterion("update_num is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumEqualTo(Integer value) {
            addCriterion("update_num =", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotEqualTo(Integer value) {
            addCriterion("update_num <>", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThan(Integer value) {
            addCriterion("update_num >", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_num >=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThan(Integer value) {
            addCriterion("update_num <", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThanOrEqualTo(Integer value) {
            addCriterion("update_num <=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_num in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_num not in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumBetween(Integer value1, Integer value2) {
            addCriterion("update_num between", value1, value2, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotBetween(Integer value1, Integer value2) {
            addCriterion("update_num not between", value1, value2, "updateNum");
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
    b_client_versionaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}