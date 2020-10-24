package com.hengyunsoft.platform.exchange.entity.screen.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusInfoDetailDO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id  ;//'id',
    private String investorEnterpriseName  ;//'企业名称',
    private String companyName  ;//'企业名称',
    private String legalRepresentative  ;//'法定代表人',
    private String registerNoView ;//'工商注册号（展示呈现时所用字段）',
    private String registerTime  ;//'成立日期',
    private String organizationCode ;//'组织机构代码',
    private String creditCodeView ;//'统一信用代码（展示呈现时所用字段）',
    private String businessTerm  ;//'经营起止日期',
    private String statusKeyword ;//'经营状态（标准）',
    private String registerCapital ;//'注册资本',
    private String registerCapitalUnit ;//'注册资金单位',
    private String companyType  ;//'企业类型',
    private String industryType ;//'行业',
    private String email ;//'邮箱',
    private String tel ;//'电话',
    private String website ;//'网址',
    private String approveDate ;//'核准日期',
    private String staffAmount ;//'员工人数',
    private String address ;//'地址',
    private String registerAddress ;//'注册地址',
    private String registerAuthority ;//'登记机关',
    private String businessScope ;//'经营范围',
}
