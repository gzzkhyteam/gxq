package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import lombok.Data;

/**
 * 移动端需要新增
 */
@Data
public class OrgInfosDO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 体系编码
     */
    private String orgName;


    /**
     * 部门id
     *
     * @mbggenerated
     */
    private String deptId;

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    private String deptName;

    /**
     * 职务
     *
     * @mbggenerated
     */
    private String dutyName;

    /**
     *岗位
     */
    private String postName;
}
