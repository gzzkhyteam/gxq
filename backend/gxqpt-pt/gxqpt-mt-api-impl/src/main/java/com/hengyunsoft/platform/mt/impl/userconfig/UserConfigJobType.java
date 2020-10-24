package com.hengyunsoft.platform.mt.impl.userconfig;

/***
 * 用户配置业务key
 */
public enum UserConfigJobType {
    now_unity_id(1, "用户当前单位id"),start_user_pt(2, "用户开始使用本系统的时候"),
    ;
    public long jobId;
    public String desc;

    UserConfigJobType(long jobId, String desc) {
        this.jobId = jobId;
        this.desc = desc;
    }
}
