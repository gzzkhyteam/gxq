package com.hengyunsoft.platform.mt.impl.appr;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mt.api.appr.dto.ApprApplyInfoDTO;
import com.hengyunsoft.platform.mt.api.appr.dto.CreateApprApplyDTO;
import com.hengyunsoft.platform.mt.entity.apprwork.po.*;
import com.hengyunsoft.platform.mt.impl.punchstatics.PunchStaticsManager;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.apprwork.service.*;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;

public enum ApprAppWork {
    //加班，加班申请必须一天申请一次，不能跨天
    overtime("overtime", "加班") {
        @Override
        public Long createApprApp(CreateApprApplyDTO dto, Long applyId) {
            ApprOverTimeService apprOverTimeppr = SpringUtil.getBean(ApprOverTimeService.class);
            DozerUtils dozerUtils = SpringUtil.getBean(DozerUtils.class);
            Long userId = BaseContextHandler.getAdminId();

            ApprOverTime apprOverTime = dozerUtils.map(dto, ApprOverTime.class);
            //判断是否跨天
            boolean crossDays = DateUtils.isCrossDays(apprOverTime.getStartTime(), apprOverTime.getEndTime());
            if (crossDays) {
                BizAssert.fail(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_OVER_TIME_NOT_SAME_DAY);
            }

            apprOverTime.setCreateUser(userId);
            apprOverTime.setApplyId(applyId);
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_STARTTIME, apprOverTime.getStartTime());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENDTIME, apprOverTime.getEndTime());
            // BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_CONTENT, apprOverTime.getContent());

            apprOverTimeppr.saveSelective(apprOverTime);

            return apprOverTime.getId();
        }

        @Override
        public Long setWorkInfo(Long applyId, ApprApplyInfoDTO res) {
            ApprOverTimeService service = SpringUtil.getBean(ApprOverTimeService.class);
            ApprOverTime unique = service.getApprOverTimeByApplyId(applyId);
            res.setStartTime(unique.getStartTime());
            res.setEndTime(unique.getEndTime());
            res.setContent(unique.getContent());
            return unique.getId();
        }

        @Override
        public void statics(Long applyId, String unitId, boolean isCancel) {
            PunchStaticsManager punchStaticsManager = SpringUtil.getBean(PunchStaticsManager.class);
            ApprOverTimeService apprOverTimeService = SpringUtil.getBean(ApprOverTimeService.class);
            ApprOverTime apprOverTime = apprOverTimeService.getApprOverTimeByApplyId(applyId);
            if (isCancel) {
                punchStaticsManager.saveStatics(apprOverTime.getCreateUser(), unitId, apprOverTime.getStartTime(), StaticsConst.TYPE_WORK_CANCEL, applyId, null);
            } else {
                punchStaticsManager.saveStatics(apprOverTime.getCreateUser(), unitId, apprOverTime.getStartTime(), StaticsConst.TYPE_WORK_OVERTIME, apprOverTime.getId(), null);
            }

        }
    },
    //请假，1：可以跨天请，2：去权限系统判断每天是否是假期，假期不算请假时间，3：每天的请假时间按照正常上班时间和申请请假时间取
    //4:统计是按天，所有要分别每天执行统计  5:如果请假了又来打卡，不管他，还是算请假了
    leave("leave", "请假") {
        @Override
        public Long createApprApp(CreateApprApplyDTO dto, Long applyId) {
            ApprLeaveService apprLeaveService = SpringUtil.getBean(ApprLeaveService.class);
            DozerUtils dozerUtils = SpringUtil.getBean(DozerUtils.class);
            Long userId = BaseContextHandler.getAdminId();
            ApprLeave apprLeave = dozerUtils.map(dto, ApprLeave.class);

            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_STARTTIME, apprLeave.getStartTime());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENDTIME, apprLeave.getEndTime());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_LEAVETYPE, apprLeave.getLeaveType());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_LEAVEHOUR, apprLeave.getLeaveHour());
            // BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_LEAVEREASON, apprLeave.getLeaveReason());

            apprLeave.setApplyId(applyId);
            apprLeave.setCreateUser(userId);
            apprLeaveService.saveSelective(apprLeave);

            return apprLeave.getId();
        }

        @Override
        public Long setWorkInfo(Long applyId, ApprApplyInfoDTO res) {
            ApprLeaveService service = SpringUtil.getBean(ApprLeaveService.class);
            ApprLeave unique = service.getApprLeaveByApplyId(applyId);
            res.setStartTime(unique.getStartTime());
            res.setEndTime(unique.getEndTime());
            res.setContent(unique.getLeaveReason());
            res.setLeaveType(unique.getLeaveType());
            return unique.getId();
        }

        @Override
        public void statics(Long applyId, String unitId, boolean isCancel) {
            PunchStaticsManager punchStaticsManager = SpringUtil.getBean(PunchStaticsManager.class);
            ApprLeaveService apprLeaveService = SpringUtil.getBean(ApprLeaveService.class);
            ApprLeave apprLeave = apprLeaveService.getApprLeaveByApplyId(applyId);

            //一天统计一次
            int days = DateUtils.getDistDates(apprLeave.getStartTime(), apprLeave.getEndTime());
            for (int i = 0; i <= days; i++) {
                Date date = DateUtils.addDays(apprLeave.getStartTime(), i);
                if (isCancel) {
                    punchStaticsManager.saveStatics(apprLeave.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_CANCEL, applyId, null);
                } else {
                    punchStaticsManager.saveStatics(apprLeave.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_LEAVE, apprLeave.getId(), null);
                }
            }

        }
    },
    //出差
    //1:出差不需要打外勤卡
    //2:出差可以夸天申请
    business("business", "出差") {
        @Override
        public Long createApprApp(CreateApprApplyDTO dto, Long applyId) {
            ApprBusinessService service = SpringUtil.getBean(ApprBusinessService.class);
            DozerUtils dozerUtils = SpringUtil.getBean(DozerUtils.class);
            Long userId = BaseContextHandler.getAdminId();
            ApprBusiness en = dozerUtils.map(dto, ApprBusiness.class);

            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_STARTTIME, en.getStartTime());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENDTIME, en.getEndTime());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_PROVINCE, en.getProvince());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_CITY, en.getCity());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ADDRESS, en.getAddress());
            //BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_VEHICLE, en.getVehicle());
            //BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENTOURAGE, en.getEntourage());
            //BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENTOURAGEPHONE, en.getEntouragePhone());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_BUSINESSHOUR, en.getBusinessHour());
            //BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_BUSINESSREASON, en.getBusinessReason());

            en.setApplyId(applyId);
            en.setCreateUser(userId);
            service.saveSelective(en);

            return en.getId();
        }

        @Override
        public Long setWorkInfo(Long applyId, ApprApplyInfoDTO res) {
            ApprBusinessService service = SpringUtil.getBean(ApprBusinessService.class);
            ApprBusiness unique = service.getApprBusinessByApplyId(applyId);
            res.setStartTime(unique.getStartTime());
            res.setEndTime(unique.getEndTime());
            res.setContent(unique.getBusinessReason());
            res.setBusinessType(unique.getLeaveType());
            return unique.getId();
        }

        @Override
        public void statics(Long applyId, String unitId, boolean isCancel) {
            PunchStaticsManager punchStaticsManager = SpringUtil.getBean(PunchStaticsManager.class);
            ApprBusinessService apprBusinessService = SpringUtil.getBean(ApprBusinessService.class);

            ApprBusiness apprBusiness = apprBusinessService.getApprBusinessByApplyId(applyId);
            //一天统计一次
            int days = DateUtils.getDistDates(apprBusiness.getStartTime(), apprBusiness.getEndTime());
            for (int i = 0; i <= days; i++) {
                Date date = DateUtils.addDays(apprBusiness.getStartTime(), i);
                if (isCancel) {
                    punchStaticsManager.saveStatics(apprBusiness.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_CANCEL, applyId, null);
                } else {
                    punchStaticsManager.saveStatics(apprBusiness.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_BUSINESS, apprBusiness.getId(), null);
                }
            }
        }
    },
    //外勤
    //1:外勤不可以跨天申请，只能一天一天申请
    //2:外勤需要打卡，时间和正常上班时间一样
    outside("outside", "外勤") {
        @Override
        public Long createApprApp(CreateApprApplyDTO dto, Long applyId) {
            ApprOutsideService service = SpringUtil.getBean(ApprOutsideService.class);
            DozerUtils dozerUtils = SpringUtil.getBean(DozerUtils.class);
            Long userId = BaseContextHandler.getAdminId();
            ApprOutside en = dozerUtils.map(dto, ApprOutside.class);
            //判断是否跨天
            boolean crossDays = DateUtils.isCrossDays(en.getStartTime(), en.getEndTime());
            if (crossDays) {
                BizAssert.fail(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_OTU_WORK_NOT_SAME_DAY);
            }
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_STARTTIME, en.getStartTime());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_ENDTIME, en.getEndTime());
            //BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_DESCRIPTION, en.getDescription());

            en.setApplyId(applyId);
            en.setCreateUser(userId);
            service.saveSelective(en);

            return en.getId();
        }

        @Override
        public Long setWorkInfo(Long applyId, ApprApplyInfoDTO res) {
            ApprOutsideService service = SpringUtil.getBean(ApprOutsideService.class);
            ApprOutside unique = service.getApprOutsideByApplyid(applyId);
            res.setStartTime(unique.getStartTime());
            res.setEndTime(unique.getEndTime());
            res.setContent(unique.getDescription());

            return unique.getId();
        }

        @Override
        public void statics(Long applyId, String unitId, boolean isCancel) {
            PunchStaticsManager punchStaticsManager = SpringUtil.getBean(PunchStaticsManager.class);
            ApprOutsideService apprOutsideService = SpringUtil.getBean(ApprOutsideService.class);

            ApprOutside apprOutside = apprOutsideService.getApprOutsideByApplyid(applyId);
            //一天统计一次
            int days = DateUtils.getDistDates(apprOutside.getStartTime(), apprOutside.getEndTime());
            for (int i = 0; i <= days; i++) {
                Date date = DateUtils.addDays(apprOutside.getStartTime(), i);
                if (isCancel) {
                    punchStaticsManager.saveStatics(apprOutside.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_CANCEL, applyId, null);
                } else {
                    punchStaticsManager.saveStatics(apprOutside.getCreateUser(), unitId, date, StaticsConst.TYPE_WORK_OUTSIDE, apprOutside.getId(), null);
                }
            }
        }
    },
    //supply:补签
    supply("supply", "补签") {
        @Override
        public Long createApprApp(CreateApprApplyDTO dto, Long applyId) {
            ApprAttenceSupplyService service = SpringUtil.getBean(ApprAttenceSupplyService.class);
            DozerUtils dozerUtils = SpringUtil.getBean(DozerUtils.class);
            Long userId = BaseContextHandler.getAdminId();
            ApprAttenceSupply en = dozerUtils.map(dto, ApprAttenceSupply.class);
            en.setEndTime(dto.getDate());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_SUPPLYTYPE, en.getSupplyType());
            BizAssert.assertNotNull(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_DATA, en.getEndTime());
            //BizAssert.assertNotEmpty(MtExceptionCode.CREATEAPPRAPPLY_CREATEAPPRAPPLYDTO_REASON, en.getReason());

            en.setApplyId(applyId);
            en.setCreateUser(userId);
            service.saveSelective(en);

            return en.getId();
        }

        @Override
        public Long setWorkInfo(Long applyId, ApprApplyInfoDTO res) {
            ApprAttenceSupplyService service = SpringUtil.getBean(ApprAttenceSupplyService.class);
            ApprAttenceSupply unique = service.getApprAttenceSupplyByApplyId(applyId);
            res.setDate(unique.getEndTime());
            res.setContent(unique.getReason());
            res.setSupplyType(unique.getSupplyType());
            return unique.getId();
        }

        @Override
        public void statics(Long applyId, String unitId, boolean isCancel) {
            PunchStaticsManager punchStaticsManager = SpringUtil.getBean(PunchStaticsManager.class);
            ApprAttenceSupplyService apprAttenceSupplyService = SpringUtil.getBean(ApprAttenceSupplyService.class);

            ApprAttenceSupply apprAttenceSupply = apprAttenceSupplyService.getApprAttenceSupplyByApplyId(applyId);

            if (isCancel) {
                punchStaticsManager.saveStatics(apprAttenceSupply.getCreateUser(), unitId, apprAttenceSupply.getEndTime(),
                        StaticsConst.TYPE_WORK_CANCEL, applyId, null);
            } else {
                punchStaticsManager.saveStatics(apprAttenceSupply.getCreateUser(), unitId, apprAttenceSupply.getEndTime(),
                        StaticsConst.TYPE_WORK_SUPPLY, apprAttenceSupply.getId(), null);
            }


        }
    },;

    ApprAppWork(String name, String chineseName) {
        this.name = name;
        this.chineseName = chineseName;
    }

    public String name;
    public String chineseName;

    /***
     * 创建审批业务数据
     * @param dto 参数
     * @param applyId 流程申请成功的id
     * @return 返回 数据主键
     */
    public abstract Long createApprApp(CreateApprApplyDTO dto, Long applyId);


    /***
     * 设置详情返回的基本信息
     * @param applyId
     * @param res
     * @return 返回该记录的主键
     */
    public abstract Long setWorkInfo(Long applyId, ApprApplyInfoDTO res);


    /***
     * 执行统计
     * @param applyId 审批申请id
     * @param unitId 单位id
     * @param isCancel 是否是撤销
     */
    public abstract void statics(Long applyId, String unitId, boolean isCancel);

    public static ApprAppWork getApprAppWorkByName(String name) {
        ApprAppWork aaw = null;
        for (ApprAppWork aw : values()) {
            if (aw.name.equals(name)) {
                aaw = aw;
                break;
            }
        }
        return aaw;
    }

}
