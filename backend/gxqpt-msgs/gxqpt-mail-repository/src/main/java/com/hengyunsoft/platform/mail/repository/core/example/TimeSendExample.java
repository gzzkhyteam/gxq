package com.hengyunsoft.platform.mail.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeSendExample extends com.hengyunsoft.db.example.BaseExample<TimeSendExample.Criteria> implements Serializable {
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

        public Criteria andMailNameIsNull() {
            addCriterion("mail_name is null");
            return (Criteria) this;
        }

        public Criteria andMailNameIsNotNull() {
            addCriterion("mail_name is not null");
            return (Criteria) this;
        }

        public Criteria andMailNameEqualTo(String value) {
            addCriterion("mail_name =", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotEqualTo(String value) {
            addCriterion("mail_name <>", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameGreaterThan(String value) {
            addCriterion("mail_name >", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameGreaterThanOrEqualTo(String value) {
            addCriterion("mail_name >=", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLessThan(String value) {
            addCriterion("mail_name <", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLessThanOrEqualTo(String value) {
            addCriterion("mail_name <=", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLike(String value) {
            addCriterion("mail_name like", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotLike(String value) {
            addCriterion("mail_name not like", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_name in", values, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_name not in", values, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameBetween(String value1, String value2) {
            addCriterion("mail_name between", value1, value2, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotBetween(String value1, String value2) {
            addCriterion("mail_name not between", value1, value2, "mailName");
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

        public Criteria andMailToIsNull() {
            addCriterion("mail_to is null");
            return (Criteria) this;
        }

        public Criteria andMailToIsNotNull() {
            addCriterion("mail_to is not null");
            return (Criteria) this;
        }

        public Criteria andMailToEqualTo(String value) {
            addCriterion("mail_to =", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotEqualTo(String value) {
            addCriterion("mail_to <>", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToGreaterThan(String value) {
            addCriterion("mail_to >", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToGreaterThanOrEqualTo(String value) {
            addCriterion("mail_to >=", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLessThan(String value) {
            addCriterion("mail_to <", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLessThanOrEqualTo(String value) {
            addCriterion("mail_to <=", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLike(String value) {
            addCriterion("mail_to like", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotLike(String value) {
            addCriterion("mail_to not like", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_to in", values, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_to not in", values, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToBetween(String value1, String value2) {
            addCriterion("mail_to between", value1, value2, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotBetween(String value1, String value2) {
            addCriterion("mail_to not between", value1, value2, "mailTo");
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

        public Criteria andIsReplySignIsNull() {
            addCriterion("is_reply_sign is null");
            return (Criteria) this;
        }

        public Criteria andIsReplySignIsNotNull() {
            addCriterion("is_reply_sign is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplySignEqualTo(Integer value) {
            addCriterion("is_reply_sign =", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignNotEqualTo(Integer value) {
            addCriterion("is_reply_sign <>", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignGreaterThan(Integer value) {
            addCriterion("is_reply_sign >", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_reply_sign >=", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignLessThan(Integer value) {
            addCriterion("is_reply_sign <", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignLessThanOrEqualTo(Integer value) {
            addCriterion("is_reply_sign <=", value, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_reply_sign in", values, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_reply_sign not in", values, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignBetween(Integer value1, Integer value2) {
            addCriterion("is_reply_sign between", value1, value2, "isReplySign");
            return (Criteria) this;
        }

        public Criteria andIsReplySignNotBetween(Integer value1, Integer value2) {
            addCriterion("is_reply_sign not between", value1, value2, "isReplySign");
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

        public Criteria andMailTypeIsNull() {
            addCriterion("mail_type is null");
            return (Criteria) this;
        }

        public Criteria andMailTypeIsNotNull() {
            addCriterion("mail_type is not null");
            return (Criteria) this;
        }

        public Criteria andMailTypeEqualTo(String value) {
            addCriterion("mail_type =", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotEqualTo(String value) {
            addCriterion("mail_type <>", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThan(String value) {
            addCriterion("mail_type >", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mail_type >=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThan(String value) {
            addCriterion("mail_type <", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThanOrEqualTo(String value) {
            addCriterion("mail_type <=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLike(String value) {
            addCriterion("mail_type like", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotLike(String value) {
            addCriterion("mail_type not like", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_type in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mail_type not in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeBetween(String value1, String value2) {
            addCriterion("mail_type between", value1, value2, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotBetween(String value1, String value2) {
            addCriterion("mail_type not between", value1, value2, "mailType");
            return (Criteria) this;
        }
    }

    /**
    mail_time_sendaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}