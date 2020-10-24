package com.hengyunsoft.platform.mt.entity.punchstatics.po;

/**
 * com.hengyunsoft.platform.admin.api.core.dto.emp
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：用户简要要信息dto
 * 修改人：gbl
 * 修改时间：2018/7/26
 * 修改内容：
 */
public class SimpEmp {

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long gxqptEmpId;
    /**
     * 启用标记
     *
     * @mbggenerated
     */
    private String isenable;
    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;
    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    private String mainorgid;
    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    private String mainorgname;

    /***
     * 所属部门名称
     */
    private String maindeptname;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    private String maindutyname;

    public Long getGxqptEmpId() {
        return gxqptEmpId;
    }

    public void setGxqptEmpId(Long gxqptEmpId) {
        this.gxqptEmpId = gxqptEmpId;
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainorgid() {
        return mainorgid;
    }

    public void setMainorgid(String mainorgid) {
        this.mainorgid = mainorgid;
    }

    public String getMainorgname() {
        return mainorgname;
    }

    public void setMainorgname(String mainorgname) {
        this.mainorgname = mainorgname;
    }

    public String getMaindeptname() {
        return maindeptname;
    }

    public void setMaindeptname(String maindeptname) {
        this.maindeptname = maindeptname;
    }

    public String getMaindutyname() {
        return maindutyname;
    }

    public void setMaindutyname(String maindutyname) {
        this.maindutyname = maindutyname;
    }
}
