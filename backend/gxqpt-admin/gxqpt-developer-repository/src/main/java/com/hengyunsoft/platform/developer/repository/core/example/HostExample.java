package com.hengyunsoft.platform.developer.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HostExample extends com.hengyunsoft.db.example.BaseExample<HostExample.Criteria> implements Serializable {
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

        public Criteria andDomainNameIsNull() {
            addCriterion("domain_name is null");
            return (Criteria) this;
        }

        public Criteria andDomainNameIsNotNull() {
            addCriterion("domain_name is not null");
            return (Criteria) this;
        }

        public Criteria andDomainNameEqualTo(String value) {
            addCriterion("domain_name =", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotEqualTo(String value) {
            addCriterion("domain_name <>", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThan(String value) {
            addCriterion("domain_name >", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThanOrEqualTo(String value) {
            addCriterion("domain_name >=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThan(String value) {
            addCriterion("domain_name <", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThanOrEqualTo(String value) {
            addCriterion("domain_name <=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLike(String value) {
            addCriterion("domain_name like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotLike(String value) {
            addCriterion("domain_name not like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameIn(java.util.List<java.lang.String> values) {
            addCriterion("domain_name in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("domain_name not in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameBetween(String value1, String value2) {
            addCriterion("domain_name between", value1, value2, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotBetween(String value1, String value2) {
            addCriterion("domain_name not between", value1, value2, "domainName");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIsNull() {
            addCriterion("ip_addr_public is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIsNotNull() {
            addCriterion("ip_addr_public is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicEqualTo(String value) {
            addCriterion("ip_addr_public =", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotEqualTo(String value) {
            addCriterion("ip_addr_public <>", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThan(String value) {
            addCriterion("ip_addr_public >", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicGreaterThanOrEqualTo(String value) {
            addCriterion("ip_addr_public >=", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThan(String value) {
            addCriterion("ip_addr_public <", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLessThanOrEqualTo(String value) {
            addCriterion("ip_addr_public <=", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicLike(String value) {
            addCriterion("ip_addr_public like", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotLike(String value) {
            addCriterion("ip_addr_public not like", value, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_addr_public in", values, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_addr_public not in", values, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicBetween(String value1, String value2) {
            addCriterion("ip_addr_public between", value1, value2, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrPublicNotBetween(String value1, String value2) {
            addCriterion("ip_addr_public not between", value1, value2, "ipAddrPublic");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNull() {
            addCriterion("ip_addr is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNotNull() {
            addCriterion("ip_addr is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualTo(String value) {
            addCriterion("ip_addr =", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualTo(String value) {
            addCriterion("ip_addr <>", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThan(String value) {
            addCriterion("ip_addr >", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ip_addr >=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThan(String value) {
            addCriterion("ip_addr <", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualTo(String value) {
            addCriterion("ip_addr <=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLike(String value) {
            addCriterion("ip_addr like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotLike(String value) {
            addCriterion("ip_addr not like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_addr in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_addr not in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrBetween(String value1, String value2) {
            addCriterion("ip_addr between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotBetween(String value1, String value2) {
            addCriterion("ip_addr not between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andHostNameIsNull() {
            addCriterion("host_name is null");
            return (Criteria) this;
        }

        public Criteria andHostNameIsNotNull() {
            addCriterion("host_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostNameEqualTo(String value) {
            addCriterion("host_name =", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotEqualTo(String value) {
            addCriterion("host_name <>", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThan(String value) {
            addCriterion("host_name >", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThanOrEqualTo(String value) {
            addCriterion("host_name >=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThan(String value) {
            addCriterion("host_name <", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThanOrEqualTo(String value) {
            addCriterion("host_name <=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLike(String value) {
            addCriterion("host_name like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotLike(String value) {
            addCriterion("host_name not like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameIn(java.util.List<java.lang.String> values) {
            addCriterion("host_name in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("host_name not in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameBetween(String value1, String value2) {
            addCriterion("host_name between", value1, value2, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotBetween(String value1, String value2) {
            addCriterion("host_name not between", value1, value2, "hostName");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNull() {
            addCriterion("os_type is null");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNotNull() {
            addCriterion("os_type is not null");
            return (Criteria) this;
        }

        public Criteria andOsTypeEqualTo(String value) {
            addCriterion("os_type =", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotEqualTo(String value) {
            addCriterion("os_type <>", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThan(String value) {
            addCriterion("os_type >", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("os_type >=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThan(String value) {
            addCriterion("os_type <", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThanOrEqualTo(String value) {
            addCriterion("os_type <=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLike(String value) {
            addCriterion("os_type like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotLike(String value) {
            addCriterion("os_type not like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("os_type in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("os_type not in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeBetween(String value1, String value2) {
            addCriterion("os_type between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotBetween(String value1, String value2) {
            addCriterion("os_type not between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNull() {
            addCriterion("os_version is null");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNotNull() {
            addCriterion("os_version is not null");
            return (Criteria) this;
        }

        public Criteria andOsVersionEqualTo(String value) {
            addCriterion("os_version =", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotEqualTo(String value) {
            addCriterion("os_version <>", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThan(String value) {
            addCriterion("os_version >", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("os_version >=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThan(String value) {
            addCriterion("os_version <", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanOrEqualTo(String value) {
            addCriterion("os_version <=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLike(String value) {
            addCriterion("os_version like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotLike(String value) {
            addCriterion("os_version not like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionIn(java.util.List<java.lang.String> values) {
            addCriterion("os_version in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("os_version not in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionBetween(String value1, String value2) {
            addCriterion("os_version between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotBetween(String value1, String value2) {
            addCriterion("os_version not between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIsNull() {
            addCriterion("cpu_info is null");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIsNotNull() {
            addCriterion("cpu_info is not null");
            return (Criteria) this;
        }

        public Criteria andCpuInfoEqualTo(String value) {
            addCriterion("cpu_info =", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotEqualTo(String value) {
            addCriterion("cpu_info <>", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoGreaterThan(String value) {
            addCriterion("cpu_info >", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_info >=", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLessThan(String value) {
            addCriterion("cpu_info <", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLessThanOrEqualTo(String value) {
            addCriterion("cpu_info <=", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLike(String value) {
            addCriterion("cpu_info like", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotLike(String value) {
            addCriterion("cpu_info not like", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_info in", values, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cpu_info not in", values, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoBetween(String value1, String value2) {
            addCriterion("cpu_info between", value1, value2, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotBetween(String value1, String value2) {
            addCriterion("cpu_info not between", value1, value2, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNull() {
            addCriterion("cpu_count is null");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNotNull() {
            addCriterion("cpu_count is not null");
            return (Criteria) this;
        }

        public Criteria andCpuCountEqualTo(Short value) {
            addCriterion("cpu_count =", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotEqualTo(Short value) {
            addCriterion("cpu_count <>", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThan(Short value) {
            addCriterion("cpu_count >", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThanOrEqualTo(Short value) {
            addCriterion("cpu_count >=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThan(Short value) {
            addCriterion("cpu_count <", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThanOrEqualTo(Short value) {
            addCriterion("cpu_count <=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountIn(java.util.List<java.lang.Short> values) {
            addCriterion("cpu_count in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("cpu_count not in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountBetween(Short value1, Short value2) {
            addCriterion("cpu_count between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotBetween(Short value1, Short value2) {
            addCriterion("cpu_count not between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andServerProviderIsNull() {
            addCriterion("server_provider is null");
            return (Criteria) this;
        }

        public Criteria andServerProviderIsNotNull() {
            addCriterion("server_provider is not null");
            return (Criteria) this;
        }

        public Criteria andServerProviderEqualTo(String value) {
            addCriterion("server_provider =", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderNotEqualTo(String value) {
            addCriterion("server_provider <>", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderGreaterThan(String value) {
            addCriterion("server_provider >", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderGreaterThanOrEqualTo(String value) {
            addCriterion("server_provider >=", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderLessThan(String value) {
            addCriterion("server_provider <", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderLessThanOrEqualTo(String value) {
            addCriterion("server_provider <=", value, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderIn(java.util.List<java.lang.String> values) {
            addCriterion("server_provider in", values, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderNotIn(java.util.List<java.lang.String> values) {
            addCriterion("server_provider not in", values, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderBetween(String value1, String value2) {
            addCriterion("server_provider between", value1, value2, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andServerProviderNotBetween(String value1, String value2) {
            addCriterion("server_provider not between", value1, value2, "serverProvider");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("mem is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("mem is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(Integer value) {
            addCriterion("mem =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(Integer value) {
            addCriterion("mem <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(Integer value) {
            addCriterion("mem >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(Integer value) {
            addCriterion("mem >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(Integer value) {
            addCriterion("mem <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(Integer value) {
            addCriterion("mem <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(java.util.List<java.lang.Integer> values) {
            addCriterion("mem in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("mem not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(Integer value1, Integer value2) {
            addCriterion("mem between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(Integer value1, Integer value2) {
            addCriterion("mem not between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andHarddiskIsNull() {
            addCriterion("harddisk is null");
            return (Criteria) this;
        }

        public Criteria andHarddiskIsNotNull() {
            addCriterion("harddisk is not null");
            return (Criteria) this;
        }

        public Criteria andHarddiskEqualTo(Integer value) {
            addCriterion("harddisk =", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskNotEqualTo(Integer value) {
            addCriterion("harddisk <>", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskGreaterThan(Integer value) {
            addCriterion("harddisk >", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskGreaterThanOrEqualTo(Integer value) {
            addCriterion("harddisk >=", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskLessThan(Integer value) {
            addCriterion("harddisk <", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskLessThanOrEqualTo(Integer value) {
            addCriterion("harddisk <=", value, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskIn(java.util.List<java.lang.Integer> values) {
            addCriterion("harddisk in", values, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("harddisk not in", values, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskBetween(Integer value1, Integer value2) {
            addCriterion("harddisk between", value1, value2, "harddisk");
            return (Criteria) this;
        }

        public Criteria andHarddiskNotBetween(Integer value1, Integer value2) {
            addCriterion("harddisk not between", value1, value2, "harddisk");
            return (Criteria) this;
        }

        public Criteria andVirtualHostIsNull() {
            addCriterion("virtual_host is null");
            return (Criteria) this;
        }

        public Criteria andVirtualHostIsNotNull() {
            addCriterion("virtual_host is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualHostEqualTo(Short value) {
            addCriterion("virtual_host =", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostNotEqualTo(Short value) {
            addCriterion("virtual_host <>", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostGreaterThan(Short value) {
            addCriterion("virtual_host >", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostGreaterThanOrEqualTo(Short value) {
            addCriterion("virtual_host >=", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostLessThan(Short value) {
            addCriterion("virtual_host <", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostLessThanOrEqualTo(Short value) {
            addCriterion("virtual_host <=", value, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostIn(java.util.List<java.lang.Short> values) {
            addCriterion("virtual_host in", values, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("virtual_host not in", values, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostBetween(Short value1, Short value2) {
            addCriterion("virtual_host between", value1, value2, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andVirtualHostNotBetween(Short value1, Short value2) {
            addCriterion("virtual_host not between", value1, value2, "virtualHost");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdIsNull() {
            addCriterion("physical_host_id is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdIsNotNull() {
            addCriterion("physical_host_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdEqualTo(Long value) {
            addCriterion("physical_host_id =", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdNotEqualTo(Long value) {
            addCriterion("physical_host_id <>", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdGreaterThan(Long value) {
            addCriterion("physical_host_id >", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdGreaterThanOrEqualTo(Long value) {
            addCriterion("physical_host_id >=", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdLessThan(Long value) {
            addCriterion("physical_host_id <", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdLessThanOrEqualTo(Long value) {
            addCriterion("physical_host_id <=", value, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("physical_host_id in", values, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("physical_host_id not in", values, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdBetween(Long value1, Long value2) {
            addCriterion("physical_host_id between", value1, value2, "physicalHostId");
            return (Criteria) this;
        }

        public Criteria andPhysicalHostIdNotBetween(Long value1, Long value2) {
            addCriterion("physical_host_id not between", value1, value2, "physicalHostId");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(java.util.List<java.lang.String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
    c_hostaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}