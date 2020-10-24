package com.hengyunsoft.platform.mail.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamineRuleExample extends com.hengyunsoft.db.example.BaseExample<ExamineRuleExample.Criteria> implements Serializable {
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

        public Criteria andSourceIpIsNull() {
            addCriterion("source_ip is null");
            return (Criteria) this;
        }

        public Criteria andSourceIpIsNotNull() {
            addCriterion("source_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIpEqualTo(String value) {
            addCriterion("source_ip =", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotEqualTo(String value) {
            addCriterion("source_ip <>", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpGreaterThan(String value) {
            addCriterion("source_ip >", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpGreaterThanOrEqualTo(String value) {
            addCriterion("source_ip >=", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLessThan(String value) {
            addCriterion("source_ip <", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLessThanOrEqualTo(String value) {
            addCriterion("source_ip <=", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLike(String value) {
            addCriterion("source_ip like", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotLike(String value) {
            addCriterion("source_ip not like", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpIn(java.util.List<java.lang.String> values) {
            addCriterion("source_ip in", values, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("source_ip not in", values, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpBetween(String value1, String value2) {
            addCriterion("source_ip between", value1, value2, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotBetween(String value1, String value2) {
            addCriterion("source_ip not between", value1, value2, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andCcIpIsNull() {
            addCriterion("cc_ip is null");
            return (Criteria) this;
        }

        public Criteria andCcIpIsNotNull() {
            addCriterion("cc_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCcIpEqualTo(String value) {
            addCriterion("cc_ip =", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpNotEqualTo(String value) {
            addCriterion("cc_ip <>", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpGreaterThan(String value) {
            addCriterion("cc_ip >", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpGreaterThanOrEqualTo(String value) {
            addCriterion("cc_ip >=", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpLessThan(String value) {
            addCriterion("cc_ip <", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpLessThanOrEqualTo(String value) {
            addCriterion("cc_ip <=", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpLike(String value) {
            addCriterion("cc_ip like", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpNotLike(String value) {
            addCriterion("cc_ip not like", value, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpIn(java.util.List<java.lang.String> values) {
            addCriterion("cc_ip in", values, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cc_ip not in", values, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpBetween(String value1, String value2) {
            addCriterion("cc_ip between", value1, value2, "ccIp");
            return (Criteria) this;
        }

        public Criteria andCcIpNotBetween(String value1, String value2) {
            addCriterion("cc_ip not between", value1, value2, "ccIp");
            return (Criteria) this;
        }

        public Criteria andFormDeptIsNull() {
            addCriterion("form_dept is null");
            return (Criteria) this;
        }

        public Criteria andFormDeptIsNotNull() {
            addCriterion("form_dept is not null");
            return (Criteria) this;
        }

        public Criteria andFormDeptEqualTo(String value) {
            addCriterion("form_dept =", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptNotEqualTo(String value) {
            addCriterion("form_dept <>", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptGreaterThan(String value) {
            addCriterion("form_dept >", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptGreaterThanOrEqualTo(String value) {
            addCriterion("form_dept >=", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptLessThan(String value) {
            addCriterion("form_dept <", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptLessThanOrEqualTo(String value) {
            addCriterion("form_dept <=", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptLike(String value) {
            addCriterion("form_dept like", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptNotLike(String value) {
            addCriterion("form_dept not like", value, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptIn(java.util.List<java.lang.String> values) {
            addCriterion("form_dept in", values, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptNotIn(java.util.List<java.lang.String> values) {
            addCriterion("form_dept not in", values, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptBetween(String value1, String value2) {
            addCriterion("form_dept between", value1, value2, "formDept");
            return (Criteria) this;
        }

        public Criteria andFormDeptNotBetween(String value1, String value2) {
            addCriterion("form_dept not between", value1, value2, "formDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptIsNull() {
            addCriterion("cc_dept is null");
            return (Criteria) this;
        }

        public Criteria andCcDeptIsNotNull() {
            addCriterion("cc_dept is not null");
            return (Criteria) this;
        }

        public Criteria andCcDeptEqualTo(String value) {
            addCriterion("cc_dept =", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptNotEqualTo(String value) {
            addCriterion("cc_dept <>", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptGreaterThan(String value) {
            addCriterion("cc_dept >", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptGreaterThanOrEqualTo(String value) {
            addCriterion("cc_dept >=", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptLessThan(String value) {
            addCriterion("cc_dept <", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptLessThanOrEqualTo(String value) {
            addCriterion("cc_dept <=", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptLike(String value) {
            addCriterion("cc_dept like", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptNotLike(String value) {
            addCriterion("cc_dept not like", value, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptIn(java.util.List<java.lang.String> values) {
            addCriterion("cc_dept in", values, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cc_dept not in", values, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptBetween(String value1, String value2) {
            addCriterion("cc_dept between", value1, value2, "ccDept");
            return (Criteria) this;
        }

        public Criteria andCcDeptNotBetween(String value1, String value2) {
            addCriterion("cc_dept not between", value1, value2, "ccDept");
            return (Criteria) this;
        }

        public Criteria andMailFromIsNull() {
            addCriterion("mail_from is null");
            return (Criteria) this;
        }

        public Criteria andMailFromIsNotNull() {
            addCriterion("mail_from is not null");
            return (Criteria) this;
        }

        public Criteria andMailFromEqualTo(String value) {
            addCriterion("mail_from =", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromNotEqualTo(String value) {
            addCriterion("mail_from <>", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromGreaterThan(String value) {
            addCriterion("mail_from >", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromGreaterThanOrEqualTo(String value) {
            addCriterion("mail_from >=", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromLessThan(String value) {
            addCriterion("mail_from <", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromLessThanOrEqualTo(String value) {
            addCriterion("mail_from <=", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromLike(String value) {
            addCriterion("mail_from like", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromNotLike(String value) {
            addCriterion("mail_from not like", value, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_from in", values, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_from not in", values, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromBetween(String value1, String value2) {
            addCriterion("mail_from between", value1, value2, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailFromNotBetween(String value1, String value2) {
            addCriterion("mail_from not between", value1, value2, "mailFrom");
            return (Criteria) this;
        }

        public Criteria andMailCcIsNull() {
            addCriterion("mail_cc is null");
            return (Criteria) this;
        }

        public Criteria andMailCcIsNotNull() {
            addCriterion("mail_cc is not null");
            return (Criteria) this;
        }

        public Criteria andMailCcEqualTo(String value) {
            addCriterion("mail_cc =", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcNotEqualTo(String value) {
            addCriterion("mail_cc <>", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcGreaterThan(String value) {
            addCriterion("mail_cc >", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcGreaterThanOrEqualTo(String value) {
            addCriterion("mail_cc >=", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcLessThan(String value) {
            addCriterion("mail_cc <", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcLessThanOrEqualTo(String value) {
            addCriterion("mail_cc <=", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcLike(String value) {
            addCriterion("mail_cc like", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcNotLike(String value) {
            addCriterion("mail_cc not like", value, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_cc in", values, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_cc not in", values, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcBetween(String value1, String value2) {
            addCriterion("mail_cc between", value1, value2, "mailCc");
            return (Criteria) this;
        }

        public Criteria andMailCcNotBetween(String value1, String value2) {
            addCriterion("mail_cc not between", value1, value2, "mailCc");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(java.util.List<java.lang.String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(java.util.List<java.lang.String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(java.util.List<java.lang.String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNull() {
            addCriterion("attachment_name is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNotNull() {
            addCriterion("attachment_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameEqualTo(String value) {
            addCriterion("attachment_name =", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotEqualTo(String value) {
            addCriterion("attachment_name <>", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThan(String value) {
            addCriterion("attachment_name >", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_name >=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThan(String value) {
            addCriterion("attachment_name <", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThanOrEqualTo(String value) {
            addCriterion("attachment_name <=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLike(String value) {
            addCriterion("attachment_name like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotLike(String value) {
            addCriterion("attachment_name not like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_name in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_name not in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameBetween(String value1, String value2) {
            addCriterion("attachment_name between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotBetween(String value1, String value2) {
            addCriterion("attachment_name not between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andMailLengthIsNull() {
            addCriterion("mail_length is null");
            return (Criteria) this;
        }

        public Criteria andMailLengthIsNotNull() {
            addCriterion("mail_length is not null");
            return (Criteria) this;
        }

        public Criteria andMailLengthEqualTo(String value) {
            addCriterion("mail_length =", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthNotEqualTo(String value) {
            addCriterion("mail_length <>", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthGreaterThan(String value) {
            addCriterion("mail_length >", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthGreaterThanOrEqualTo(String value) {
            addCriterion("mail_length >=", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthLessThan(String value) {
            addCriterion("mail_length <", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthLessThanOrEqualTo(String value) {
            addCriterion("mail_length <=", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthLike(String value) {
            addCriterion("mail_length like", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthNotLike(String value) {
            addCriterion("mail_length not like", value, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_length in", values, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_length not in", values, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthBetween(String value1, String value2) {
            addCriterion("mail_length between", value1, value2, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailLengthNotBetween(String value1, String value2) {
            addCriterion("mail_length not between", value1, value2, "mailLength");
            return (Criteria) this;
        }

        public Criteria andMailHeadIsNull() {
            addCriterion("mail_head is null");
            return (Criteria) this;
        }

        public Criteria andMailHeadIsNotNull() {
            addCriterion("mail_head is not null");
            return (Criteria) this;
        }

        public Criteria andMailHeadEqualTo(String value) {
            addCriterion("mail_head =", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadNotEqualTo(String value) {
            addCriterion("mail_head <>", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadGreaterThan(String value) {
            addCriterion("mail_head >", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadGreaterThanOrEqualTo(String value) {
            addCriterion("mail_head >=", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadLessThan(String value) {
            addCriterion("mail_head <", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadLessThanOrEqualTo(String value) {
            addCriterion("mail_head <=", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadLike(String value) {
            addCriterion("mail_head like", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadNotLike(String value) {
            addCriterion("mail_head not like", value, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_head in", values, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_head not in", values, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadBetween(String value1, String value2) {
            addCriterion("mail_head between", value1, value2, "mailHead");
            return (Criteria) this;
        }

        public Criteria andMailHeadNotBetween(String value1, String value2) {
            addCriterion("mail_head not between", value1, value2, "mailHead");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentIsNull() {
            addCriterion("is_attachment is null");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentIsNotNull() {
            addCriterion("is_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentEqualTo(String value) {
            addCriterion("is_attachment =", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentNotEqualTo(String value) {
            addCriterion("is_attachment <>", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentGreaterThan(String value) {
            addCriterion("is_attachment >", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("is_attachment >=", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentLessThan(String value) {
            addCriterion("is_attachment <", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentLessThanOrEqualTo(String value) {
            addCriterion("is_attachment <=", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentLike(String value) {
            addCriterion("is_attachment like", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentNotLike(String value) {
            addCriterion("is_attachment not like", value, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentIn(java.util.List<java.lang.String> values) {
            addCriterion("is_attachment in", values, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_attachment not in", values, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentBetween(String value1, String value2) {
            addCriterion("is_attachment between", value1, value2, "isAttachment");
            return (Criteria) this;
        }

        public Criteria andIsAttachmentNotBetween(String value1, String value2) {
            addCriterion("is_attachment not between", value1, value2, "isAttachment");
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
    mail_examine_ruleaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}