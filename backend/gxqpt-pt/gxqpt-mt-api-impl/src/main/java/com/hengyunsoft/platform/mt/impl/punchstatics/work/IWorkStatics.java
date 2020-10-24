package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;

import java.util.Map;

/***
 * 各个类型业务统计的接口
 */
public interface IWorkStatics {
    /***
     * 类型明天
     * @return
     */
    String getWorkName();


    /***
     * 执行统计
     * @param statics 统计对象
     * @param workId 业务表的主键id
     * @param param  参数
     */
    void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param);
}
