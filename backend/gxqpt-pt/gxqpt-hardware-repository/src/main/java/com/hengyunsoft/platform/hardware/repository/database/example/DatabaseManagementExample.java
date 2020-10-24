package com.hengyunsoft.platform.hardware.repository.database.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManagementExample extends com.hengyunsoft.db.example.BaseExample<DatabaseManagementExample.Criteria> implements Serializable {
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

        public Criteria andInstanceDiIsNull() {
            addCriterion("instance_DI is null");
            return (Criteria) this;
        }

        public Criteria andInstanceDiIsNotNull() {
            addCriterion("instance_DI is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceDiEqualTo(String value) {
            addCriterion("instance_DI =", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiNotEqualTo(String value) {
            addCriterion("instance_DI <>", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiGreaterThan(String value) {
            addCriterion("instance_DI >", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiGreaterThanOrEqualTo(String value) {
            addCriterion("instance_DI >=", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiLessThan(String value) {
            addCriterion("instance_DI <", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiLessThanOrEqualTo(String value) {
            addCriterion("instance_DI <=", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiLike(String value) {
            addCriterion("instance_DI like", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiNotLike(String value) {
            addCriterion("instance_DI not like", value, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiIn(java.util.List<java.lang.String> values) {
            addCriterion("instance_DI in", values, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiNotIn(java.util.List<java.lang.String> values) {
            addCriterion("instance_DI not in", values, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiBetween(String value1, String value2) {
            addCriterion("instance_DI between", value1, value2, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andInstanceDiNotBetween(String value1, String value2) {
            addCriterion("instance_DI not between", value1, value2, "instanceDi");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin_ is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin_ is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(String value) {
            addCriterion("admin_ =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(String value) {
            addCriterion("admin_ <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(String value) {
            addCriterion("admin_ >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(String value) {
            addCriterion("admin_ >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(String value) {
            addCriterion("admin_ <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(String value) {
            addCriterion("admin_ <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLike(String value) {
            addCriterion("admin_ like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotLike(String value) {
            addCriterion("admin_ not like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(java.util.List<java.lang.String> values) {
            addCriterion("admin_ in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(java.util.List<java.lang.String> values) {
            addCriterion("admin_ not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(String value1, String value2) {
            addCriterion("admin_ between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(String value1, String value2) {
            addCriterion("admin_ not between", value1, value2, "admin");
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

        public Criteria andTypeIsNull() {
            addCriterion("type_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("type_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("type_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressIsNull() {
            addCriterion("host_IP_address is null");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressIsNotNull() {
            addCriterion("host_IP_address is not null");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressEqualTo(String value) {
            addCriterion("host_IP_address =", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressNotEqualTo(String value) {
            addCriterion("host_IP_address <>", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressGreaterThan(String value) {
            addCriterion("host_IP_address >", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("host_IP_address >=", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressLessThan(String value) {
            addCriterion("host_IP_address <", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressLessThanOrEqualTo(String value) {
            addCriterion("host_IP_address <=", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressLike(String value) {
            addCriterion("host_IP_address like", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressNotLike(String value) {
            addCriterion("host_IP_address not like", value, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("host_IP_address in", values, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("host_IP_address not in", values, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressBetween(String value1, String value2) {
            addCriterion("host_IP_address between", value1, value2, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andHostIpAddressNotBetween(String value1, String value2) {
            addCriterion("host_IP_address not between", value1, value2, "hostIpAddress");
            return (Criteria) this;
        }

        public Criteria andCharacterSetIsNull() {
            addCriterion("character_set is null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetIsNotNull() {
            addCriterion("character_set is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetEqualTo(String value) {
            addCriterion("character_set =", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNotEqualTo(String value) {
            addCriterion("character_set <>", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetGreaterThan(String value) {
            addCriterion("character_set >", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetGreaterThanOrEqualTo(String value) {
            addCriterion("character_set >=", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetLessThan(String value) {
            addCriterion("character_set <", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetLessThanOrEqualTo(String value) {
            addCriterion("character_set <=", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetLike(String value) {
            addCriterion("character_set like", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNotLike(String value) {
            addCriterion("character_set not like", value, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetIn(java.util.List<java.lang.String> values) {
            addCriterion("character_set in", values, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNotIn(java.util.List<java.lang.String> values) {
            addCriterion("character_set not in", values, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetBetween(String value1, String value2) {
            addCriterion("character_set between", value1, value2, "characterSet");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNotBetween(String value1, String value2) {
            addCriterion("character_set not between", value1, value2, "characterSet");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port_ is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port_ is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port_ =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port_ <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port_ >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port_ >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port_ <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port_ <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port_ like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port_ not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(java.util.List<java.lang.String> values) {
            addCriterion("port_ in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(java.util.List<java.lang.String> values) {
            addCriterion("port_ not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port_ between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port_ not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code_ is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code_ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code_ =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code_ <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code_ >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code_ >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code_ <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code_ <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code_ like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code_ not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("code_ in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("code_ not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code_ between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code_ not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemIsNull() {
            addCriterion("associated_service_system is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemIsNotNull() {
            addCriterion("associated_service_system is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemEqualTo(String value) {
            addCriterion("associated_service_system =", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemNotEqualTo(String value) {
            addCriterion("associated_service_system <>", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemGreaterThan(String value) {
            addCriterion("associated_service_system >", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemGreaterThanOrEqualTo(String value) {
            addCriterion("associated_service_system >=", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemLessThan(String value) {
            addCriterion("associated_service_system <", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemLessThanOrEqualTo(String value) {
            addCriterion("associated_service_system <=", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemLike(String value) {
            addCriterion("associated_service_system like", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemNotLike(String value) {
            addCriterion("associated_service_system not like", value, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemIn(java.util.List<java.lang.String> values) {
            addCriterion("associated_service_system in", values, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemNotIn(java.util.List<java.lang.String> values) {
            addCriterion("associated_service_system not in", values, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemBetween(String value1, String value2) {
            addCriterion("associated_service_system between", value1, value2, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andAssociatedServiceSystemNotBetween(String value1, String value2) {
            addCriterion("associated_service_system not between", value1, value2, "associatedServiceSystem");
            return (Criteria) this;
        }

        public Criteria andIsReleaseIsNull() {
            addCriterion("is_release is null");
            return (Criteria) this;
        }

        public Criteria andIsReleaseIsNotNull() {
            addCriterion("is_release is not null");
            return (Criteria) this;
        }

        public Criteria andIsReleaseEqualTo(Integer value) {
            addCriterion("is_release =", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotEqualTo(Integer value) {
            addCriterion("is_release <>", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseGreaterThan(Integer value) {
            addCriterion("is_release >", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_release >=", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseLessThan(Integer value) {
            addCriterion("is_release <", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("is_release <=", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_release in", values, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_release not in", values, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseBetween(Integer value1, Integer value2) {
            addCriterion("is_release between", value1, value2, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_release not between", value1, value2, "isRelease");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("orgid is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(String value) {
            addCriterion("orgid =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(String value) {
            addCriterion("orgid <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(String value) {
            addCriterion("orgid >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("orgid >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(String value) {
            addCriterion("orgid <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(String value) {
            addCriterion("orgid <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLike(String value) {
            addCriterion("orgid like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotLike(String value) {
            addCriterion("orgid not like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(java.util.List<java.lang.String> values) {
            addCriterion("orgid in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgid not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(String value1, String value2) {
            addCriterion("orgid between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(String value1, String value2) {
            addCriterion("orgid not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(java.util.List<java.lang.String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
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
    b_hd_database_managementaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}