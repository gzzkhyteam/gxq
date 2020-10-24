package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgDeptDutyInfoDO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 单位名称
     */
    private String orgName;

    /**
     *部门id
     */
    private String deptId;

    /**
     *部门名称
     */
    private String deptName;

    /**
     *职务id
     */
    private String dutyId;

    /**
     *职务名称
     */
    private String dutyName;

    /**
     *岗位id
     */
    private String postId;

    /**
     *岗位名称
     */
    private String postName;
    /**
     *用户姓名
     */
    private String userName;
    /**
     *用户头像
     */
    private String  photo;
    /**
     * 体系编码
     */
    private String systemCode;

}
