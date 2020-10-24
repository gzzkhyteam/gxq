package com.hengyunsoft.platform.mail.repository.core.example;

import java.io.Serializable;
import java.util.Date;

public class SetParamExample extends com.hengyunsoft.db.example.BaseExample<SetParamExample.Criteria> implements Serializable {
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

        public Criteria andIsReceiptIsNull() {
            addCriterion("is_receipt is null");
            return (Criteria) this;
        }

        public Criteria andIsReceiptIsNotNull() {
            addCriterion("is_receipt is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceiptEqualTo(Integer value) {
            addCriterion("is_receipt =", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptNotEqualTo(Integer value) {
            addCriterion("is_receipt <>", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptGreaterThan(Integer value) {
            addCriterion("is_receipt >", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_receipt >=", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptLessThan(Integer value) {
            addCriterion("is_receipt <", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptLessThanOrEqualTo(Integer value) {
            addCriterion("is_receipt <=", value, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_receipt in", values, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_receipt not in", values, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptBetween(Integer value1, Integer value2) {
            addCriterion("is_receipt between", value1, value2, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiptNotBetween(Integer value1, Integer value2) {
            addCriterion("is_receipt not between", value1, value2, "isReceipt");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeIsNull() {
            addCriterion("default_code is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeIsNotNull() {
            addCriterion("default_code is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeEqualTo(String value) {
            addCriterion("default_code =", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeNotEqualTo(String value) {
            addCriterion("default_code <>", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeGreaterThan(String value) {
            addCriterion("default_code >", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("default_code >=", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeLessThan(String value) {
            addCriterion("default_code <", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeLessThanOrEqualTo(String value) {
            addCriterion("default_code <=", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeLike(String value) {
            addCriterion("default_code like", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeNotLike(String value) {
            addCriterion("default_code not like", value, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("default_code in", values, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("default_code not in", values, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeBetween(String value1, String value2) {
            addCriterion("default_code between", value1, value2, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCodeNotBetween(String value1, String value2) {
            addCriterion("default_code not between", value1, value2, "defaultCode");
            return (Criteria) this;
        }

        public Criteria andLoginPageIsNull() {
            addCriterion("login_page is null");
            return (Criteria) this;
        }

        public Criteria andLoginPageIsNotNull() {
            addCriterion("login_page is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPageEqualTo(String value) {
            addCriterion("login_page =", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageNotEqualTo(String value) {
            addCriterion("login_page <>", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageGreaterThan(String value) {
            addCriterion("login_page >", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageGreaterThanOrEqualTo(String value) {
            addCriterion("login_page >=", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageLessThan(String value) {
            addCriterion("login_page <", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageLessThanOrEqualTo(String value) {
            addCriterion("login_page <=", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageLike(String value) {
            addCriterion("login_page like", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageNotLike(String value) {
            addCriterion("login_page not like", value, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageIn(java.util.List<java.lang.String> values) {
            addCriterion("login_page in", values, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageNotIn(java.util.List<java.lang.String> values) {
            addCriterion("login_page not in", values, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageBetween(String value1, String value2) {
            addCriterion("login_page between", value1, value2, "loginPage");
            return (Criteria) this;
        }

        public Criteria andLoginPageNotBetween(String value1, String value2) {
            addCriterion("login_page not between", value1, value2, "loginPage");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapIsNull() {
            addCriterion("clear_trash_gap is null");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapIsNotNull() {
            addCriterion("clear_trash_gap is not null");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapEqualTo(Integer value) {
            addCriterion("clear_trash_gap =", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapNotEqualTo(Integer value) {
            addCriterion("clear_trash_gap <>", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapGreaterThan(Integer value) {
            addCriterion("clear_trash_gap >", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapGreaterThanOrEqualTo(Integer value) {
            addCriterion("clear_trash_gap >=", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapLessThan(Integer value) {
            addCriterion("clear_trash_gap <", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapLessThanOrEqualTo(Integer value) {
            addCriterion("clear_trash_gap <=", value, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clear_trash_gap in", values, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clear_trash_gap not in", values, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapBetween(Integer value1, Integer value2) {
            addCriterion("clear_trash_gap between", value1, value2, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearTrashGapNotBetween(Integer value1, Integer value2) {
            addCriterion("clear_trash_gap not between", value1, value2, "clearTrashGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapIsNull() {
            addCriterion("clear_viruse_gap is null");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapIsNotNull() {
            addCriterion("clear_viruse_gap is not null");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapEqualTo(Integer value) {
            addCriterion("clear_viruse_gap =", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapNotEqualTo(Integer value) {
            addCriterion("clear_viruse_gap <>", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapGreaterThan(Integer value) {
            addCriterion("clear_viruse_gap >", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapGreaterThanOrEqualTo(Integer value) {
            addCriterion("clear_viruse_gap >=", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapLessThan(Integer value) {
            addCriterion("clear_viruse_gap <", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapLessThanOrEqualTo(Integer value) {
            addCriterion("clear_viruse_gap <=", value, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clear_viruse_gap in", values, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clear_viruse_gap not in", values, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapBetween(Integer value1, Integer value2) {
            addCriterion("clear_viruse_gap between", value1, value2, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andClearViruseGapNotBetween(Integer value1, Integer value2) {
            addCriterion("clear_viruse_gap not between", value1, value2, "clearViruseGap");
            return (Criteria) this;
        }

        public Criteria andAutoForwardIsNull() {
            addCriterion("auto_forward is null");
            return (Criteria) this;
        }

        public Criteria andAutoForwardIsNotNull() {
            addCriterion("auto_forward is not null");
            return (Criteria) this;
        }

        public Criteria andAutoForwardEqualTo(Integer value) {
            addCriterion("auto_forward =", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardNotEqualTo(Integer value) {
            addCriterion("auto_forward <>", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardGreaterThan(Integer value) {
            addCriterion("auto_forward >", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_forward >=", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardLessThan(Integer value) {
            addCriterion("auto_forward <", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardLessThanOrEqualTo(Integer value) {
            addCriterion("auto_forward <=", value, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_forward in", values, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_forward not in", values, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardBetween(Integer value1, Integer value2) {
            addCriterion("auto_forward between", value1, value2, "autoForward");
            return (Criteria) this;
        }

        public Criteria andAutoForwardNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_forward not between", value1, value2, "autoForward");
            return (Criteria) this;
        }

        public Criteria andForwardAddressIsNull() {
            addCriterion("forward_address is null");
            return (Criteria) this;
        }

        public Criteria andForwardAddressIsNotNull() {
            addCriterion("forward_address is not null");
            return (Criteria) this;
        }

        public Criteria andForwardAddressEqualTo(String value) {
            addCriterion("forward_address =", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressNotEqualTo(String value) {
            addCriterion("forward_address <>", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressGreaterThan(String value) {
            addCriterion("forward_address >", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressGreaterThanOrEqualTo(String value) {
            addCriterion("forward_address >=", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressLessThan(String value) {
            addCriterion("forward_address <", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressLessThanOrEqualTo(String value) {
            addCriterion("forward_address <=", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressLike(String value) {
            addCriterion("forward_address like", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressNotLike(String value) {
            addCriterion("forward_address not like", value, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("forward_address in", values, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("forward_address not in", values, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressBetween(String value1, String value2) {
            addCriterion("forward_address between", value1, value2, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andForwardAddressNotBetween(String value1, String value2) {
            addCriterion("forward_address not between", value1, value2, "forwardAddress");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalIsNull() {
            addCriterion("save_copy_local is null");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalIsNotNull() {
            addCriterion("save_copy_local is not null");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalEqualTo(Integer value) {
            addCriterion("save_copy_local =", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalNotEqualTo(Integer value) {
            addCriterion("save_copy_local <>", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalGreaterThan(Integer value) {
            addCriterion("save_copy_local >", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalGreaterThanOrEqualTo(Integer value) {
            addCriterion("save_copy_local >=", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalLessThan(Integer value) {
            addCriterion("save_copy_local <", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalLessThanOrEqualTo(Integer value) {
            addCriterion("save_copy_local <=", value, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalIn(java.util.List<java.lang.Integer> values) {
            addCriterion("save_copy_local in", values, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("save_copy_local not in", values, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalBetween(Integer value1, Integer value2) {
            addCriterion("save_copy_local between", value1, value2, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andSaveCopyLocalNotBetween(Integer value1, Integer value2) {
            addCriterion("save_copy_local not between", value1, value2, "saveCopyLocal");
            return (Criteria) this;
        }

        public Criteria andAutoReplyIsNull() {
            addCriterion("auto_reply is null");
            return (Criteria) this;
        }

        public Criteria andAutoReplyIsNotNull() {
            addCriterion("auto_reply is not null");
            return (Criteria) this;
        }

        public Criteria andAutoReplyEqualTo(Integer value) {
            addCriterion("auto_reply =", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyNotEqualTo(Integer value) {
            addCriterion("auto_reply <>", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyGreaterThan(Integer value) {
            addCriterion("auto_reply >", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_reply >=", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyLessThan(Integer value) {
            addCriterion("auto_reply <", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyLessThanOrEqualTo(Integer value) {
            addCriterion("auto_reply <=", value, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_reply in", values, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_reply not in", values, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyBetween(Integer value1, Integer value2) {
            addCriterion("auto_reply between", value1, value2, "autoReply");
            return (Criteria) this;
        }

        public Criteria andAutoReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_reply not between", value1, value2, "autoReply");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(java.util.List<java.lang.String> values) {
            addCriterion("reply_content in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("reply_content not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andCurrSignIsNull() {
            addCriterion("curr_sign is null");
            return (Criteria) this;
        }

        public Criteria andCurrSignIsNotNull() {
            addCriterion("curr_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCurrSignEqualTo(Long value) {
            addCriterion("curr_sign =", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignNotEqualTo(Long value) {
            addCriterion("curr_sign <>", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignGreaterThan(Long value) {
            addCriterion("curr_sign >", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignGreaterThanOrEqualTo(Long value) {
            addCriterion("curr_sign >=", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignLessThan(Long value) {
            addCriterion("curr_sign <", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignLessThanOrEqualTo(Long value) {
            addCriterion("curr_sign <=", value, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignIn(java.util.List<java.lang.Long> values) {
            addCriterion("curr_sign in", values, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("curr_sign not in", values, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignBetween(Long value1, Long value2) {
            addCriterion("curr_sign between", value1, value2, "currSign");
            return (Criteria) this;
        }

        public Criteria andCurrSignNotBetween(Long value1, Long value2) {
            addCriterion("curr_sign not between", value1, value2, "currSign");
            return (Criteria) this;
        }

        public Criteria andIsLoggedIsNull() {
            addCriterion("is_logged is null");
            return (Criteria) this;
        }

        public Criteria andIsLoggedIsNotNull() {
            addCriterion("is_logged is not null");
            return (Criteria) this;
        }

        public Criteria andIsLoggedEqualTo(Boolean value) {
            addCriterion("is_logged =", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedNotEqualTo(Boolean value) {
            addCriterion("is_logged <>", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedGreaterThan(Boolean value) {
            addCriterion("is_logged >", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_logged >=", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedLessThan(Boolean value) {
            addCriterion("is_logged <", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_logged <=", value, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_logged in", values, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_logged not in", values, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_logged between", value1, value2, "isLogged");
            return (Criteria) this;
        }

        public Criteria andIsLoggedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_logged not between", value1, value2, "isLogged");
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
    }

    /**
    mail_set_paramaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}