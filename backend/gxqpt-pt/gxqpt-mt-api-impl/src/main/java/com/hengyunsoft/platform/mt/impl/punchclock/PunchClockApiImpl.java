package com.hengyunsoft.platform.mt.impl.punchclock;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.*;
import com.hengyunsoft.platform.mt.entity.file.po.File;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.SimpEmp;
import com.hengyunsoft.platform.mt.impl.punchstatics.PunchStaticsManager;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.file.example.FileExample;
import com.hengyunsoft.platform.mt.repository.file.service.FileService;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockHisService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import com.hengyunsoft.platform.mt.utils.HolidayUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.punchclock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：打卡
 * 修改人：gbl
 * 修改时间：2018/7/4
 * 修改内容：新增基础接口
 */
@Api(value = "API - PunchClockApiImpl.java", description = "打卡")
@RestController
@RequestMapping("punchClock")
@Slf4j
public class PunchClockApiImpl /*implements PunchClockApi */ {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private PunchClockService punchClockService;
    @Autowired
    private PunchClockHisService punchClockHisService;
    @Autowired
    private FileService fileService;
    @Autowired
    private PunchClockRuleService punchClockRuleService;
    @Autowired
    private PunchStaticsManager punchStaticsManager;
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;

    /**
     * 描述：创建打卡
     * 参数： CreatePunchClockDTO
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/4
     * 修改内容：
     */

    @RequestMapping(value = "createPunchClock", method = RequestMethod.POST)
    @ApiOperation(value = "创建打卡", notes = "创建打卡")
    @ApiResponses({
            @ApiResponse(code = 93009, message = "创建打卡，不能为空"),
            @ApiResponse(code = 93010, message = " 打卡类型:1,签到；2，签退，不能为空"),
            @ApiResponse(code = 93011, message = "考勤类型:1,内勤；2，外勤，不能为空"),
            @ApiResponse(code = 93012, message = "是否自动签到:1,手动；2，自动，不能为空"),
            @ApiResponse(code = 93013, message = "是否自动签退:1,手动；2，自动，不能为空"),
            @ApiResponse(code = 93014, message = "签到经度，不能为空"),
            @ApiResponse(code = 93015, message = "签到纬度，不能为空"),
            @ApiResponse(code = 93016, message = "签到地点，不能为空"),
            @ApiResponse(code = 93017, message = "签退经度，不能为空"),
            @ApiResponse(code = 93018, message = " 签退纬度，不能为空"),
            @ApiResponse(code = 93019, message = "签退地点，不能为空"),
            //@ApiResponse(code = 93020,message = "打卡图片，不能为空"),
    })
    public Result<Boolean> saveCreatePunchClock(@RequestBody CreatePunchClockDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO, dto);
        BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_ADCETYPE, dto.getAdceType());
        BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_CLOCKTYPE, dto.getClockType());
        if (dto.getClockType() == 1) {//签到
            BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_AUTOSIGNINFLAG, dto.getAutoSignInFlag());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNINLNG, dto.getSignInLng());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNINLAT, dto.getSignInLat());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNLOCATION, dto.getSignLocation());
        } else {//签退
            BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_AUTOSIGNOFFFLAG, dto.getAutoSignOffFlag());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNOFFLNG, dto.getSignOffLng());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNOFFLAT, dto.getSignOffLat());
            BizAssert.assertNotEmpty(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO_SIGNOFFLOCATION, dto.getSignOffLocation());
        }
        Long userId = BaseContextHandler.getAdminId();
        String unityId = getUnityId(userId);

        //打卡记录数据(一天一条)
        PunchClock pc = dozerUtils.map(dto, PunchClock.class);
        pc.setUserId(userId);
        pc.setUnitId(unityId);
        //打卡历史记录数据(打一次一条)
        PunchClockHis pcHis = new PunchClockHis();
        pcHis.setAdceType(pc.getAdceType());
        pcHis.setUnitId(unityId);
        pcHis.setClockType(dto.getClockType());
        pcHis.setCreateUser(userId);
        pcHis.setUserId(userId);
        pcHis.setClockTime(new Date());
        pcHis.setLateReason(dto.getLateReason());
        pcHis.setOutterReason(dto.getOutterReason());

        PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);//本单位考勤规则
        if (rule == null) {
            return Result.fail(MtExceptionCode.UNIOTY_HAS_ATEPUNCHCLOCK_ROLE);
        }

        pc.setStatus(1);
        pcHis.setStatus(1);
        if (dto.getClockType() == 1) {//签到
            signIn(pc, pcHis, rule);
        } else {//签退
            signoff(pc, pcHis, rule);
        }

        //图片
        if (dto.getImages() != null && dto.getImages().size() > 0) {
            List<File> files = dozerUtils.mapList(dto.getImages(), File.class);
            for (File f : files) {
                f.setTableId(pcHis.getId());
                f.setCreateUser(userId);
            }
            fileService.save(files);
        }
        //统计
        Map<String, String> map = new HashMap<>();
        map.put("clockType", String.valueOf(dto.getClockType()));
        map.put("adceType", String.valueOf(dto.getAdceType()));
        punchStaticsManager.saveStatics(userId, unityId, new Date(), StaticsConst.TYPE_WORK_PUNCH_CLOCK, pc.getId(), map);
        return Result.success(true);
    }

    /***
     * 签退
     * @param pc
     * @param pcHis
     * @param rule
     */
    private void signoff(PunchClock pc, PunchClockHis pcHis, PunchClockRule rule) {
        Date nowTime = new Date();
        Date outTime = DateUtils.getTodayTime(rule.getOutTime());
        Date singDate = new Date();//签退日期 默认是今天
        //最晚签退时间为第二天0点前,0点前必须签退，否则只能补签了
//        Date lastTime = DateUtils.getTodayTime("23:59:59");
//        if (nowTime.before(lastTime)) {
//            singDate = DateUtils.addDays(singDate, -1);
//        } else {
//
//        }
        if (nowTime.before(outTime)) {
            pc.setStatus(3);//签退状态
            pcHis.setStatus(3);//签到状态
        }
        Long userId = BaseContextHandler.getAdminId();
        String unityId = getUnityId(userId);
        PunchClock oldPc = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, unityId, singDate);

        pc.setSignOffTime(new Date());
        pcHis.setAutoFlag(pc.getAutoSignOffFlag());
        pcHis.setLat(pc.getSignOffLat());
        pcHis.setLng(pc.getSignOffLng());
        pcHis.setLocation(pc.getSignOffLocation());
        pc.setClockDate(singDate);
        pcHis.setClockDate(singDate);
        //保存
        if (oldPc == null) {
            pc.setCreateUser(userId);
            punchClockService.saveSelective(pc);
        } else {
            pc.setId(oldPc.getId());
            pc.setUpdateUser(userId);
            punchClockService.updateByIdSelective(pc);
        }
        punchClockHisService.saveSelective(pcHis);
    }

    /***
     * 签到
     * @param pc
     * @param pcHis
     * @param rule
     */
    private void signIn(PunchClock pc, PunchClockHis pcHis, PunchClockRule rule) {
        Date nowTime = new Date();
        Date nowDate = nowTime;
        Long userId = BaseContextHandler.getAdminId();
        String unityId = getUnityId(userId);
        Date inTime = DateUtils.getTodayTime(rule.getInTime());
        PunchClock oldPc = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, unityId, new Date());
        if (oldPc != null && oldPc.getSignInTime() != null && oldPc.getSignInTime().before(nowTime)) {
            pc.setSignInTime(oldPc.getSignInTime());
        } else {
            pc.setSignInTime(new Date());
            if (nowTime.after(inTime)) {
                pc.setStatus(2);//签到状态
                pcHis.setStatus(2);//签到状态
            }

        }
        pcHis.setAutoFlag(pc.getAutoSignInFlag());
        pcHis.setLat(pc.getSignInLat());
        pcHis.setLng(pc.getSignInLng());
        pcHis.setLocation(pc.getSignLocation());
        pc.setClockDate(new Date());
        pcHis.setClockDate(nowDate);
        //保存
        if (oldPc == null) {
            pc.setCreateUser(userId);
            punchClockService.saveSelective(pc);
        } else {
            pc.setId(oldPc.getId());
            pc.setUpdateUser(userId);
            punchClockService.updateByIdSelective(pc);
        }
        punchClockHisService.saveSelective(pcHis);
    }

    /**
     * 描述：得到今天的打卡记录
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/13
     * 修改内容：
     */

    @RequestMapping(value = "getTodayPunchClock", method = RequestMethod.GET)
    @ApiOperation(value = "得到今天的打卡记录", notes = "得到今天的打卡记录")
    public Result<PunchClockDTO> getTodayPunchClock() {
        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        PunchClockExample example = new PunchClockExample();
        PunchClockExample.Criteria criteria = example.createCriteria();
        criteria.andClockDateEqualTo(new Date());
        criteria.andUserIdEqualTo(userId);
        criteria.andUnitIdEqualTo(unityId);//只看本单位的
        PunchClock punchClock = punchClockService.getUnique(example);
        PunchClockDTO punchClockDTO = new PunchClockDTO();
        if (punchClock != null) {
            punchClockDTO.setSignInTime(punchClock.getSignInTime());
            punchClockDTO.setSignOffTime(punchClock.getSignOffTime());
        }
        return Result.success(punchClockDTO);
    }

    /**
     * 描述：分页查询打卡记录
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/9
     * 修改内容：
     */

    @RequestMapping(value = "findPunchclockPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询打卡记录", notes = "分页查询打卡记录")
    @ApiResponses({
            @ApiResponse(code = 93022, message = "查询打卡记录参数不能为空"),
    })
    public Result<PageInfo<PunchClockHisDTO>> getFindPunchclockPage(@RequestBody OpenApiReq<QueryPunchclockParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.QUERY_PUNCHCLOCK_PARAM, openApiReq);

        Map<String, Object> param = new HashMap<>();
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);
        param.put("createUser", userId);//只看自己的
        param.put("unitId", unitId);//只看本单位的
        if (openApiReq.getData() != null) {
            param.put("adceType", openApiReq.getData().getAdceType());
            param.put("clockType", openApiReq.getData().getClockType());
            param.put("startCreateTime", openApiReq.getData().getStartCreateTime());
            param.put("endCreateTime", openApiReq.getData().getEndCreateTime());
//            if (openApiReq.getData().getFromApp() != null && openApiReq.getData().getFromApp()) {//app端 只看自己的
//                param.put("createUser", userId);
//            }
        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<PunchClockHis> list = punchClockHisService.findPageList(param);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, PunchClockHisDTO.class)));
    }

    /**
     * 描述：查看打卡记录详情
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/9
     * 修改内容：
     */
    @RequestMapping(value = "getBaseInfoPunchClockHis", method = RequestMethod.POST)
    @ApiOperation(value = "查看打卡记录详情", notes = "查看打卡记录详情")
    @ApiResponses({
            @ApiResponse(code = 93023, message = "打卡记录id不能为空"),
            @ApiResponse(code = 93024, message = "打卡记录不存在"),
    })
    public Result<PunchClockHisInfoDTO> getBaseInfoPunchClockHis(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.QUERY_PUNCHCLOCK_PARAM, id);
        PunchClockHis punchClockHis = punchClockHisService.getById(id);
        if (punchClockHis == null) {
            return Result.fail(MtExceptionCode.PUNCHCLOCK_IS_NOT_HAS);
        }
        PunchClockHisInfoDTO res = dozerUtils.map(punchClockHis, PunchClockHisInfoDTO.class);
        //查询图片
        FileExample fileExample = new FileExample();
        FileExample.Criteria fileCriteria = fileExample.createCriteria();
        fileCriteria.andTableIdEqualTo(punchClockHis.getId());
        List<File> files = fileService.find(fileExample);
        List<FileDTO> images = dozerUtils.mapList(files, FileDTO.class);
        res.setImageList(images);
        return Result.success(res);
    }

    /**
     * 得到单位id
     *
     * @param userId
     * @return
     */
    public String getUnityId(Long userId) {
//        Long adminId = BaseContextHandler.getAdminId();
//        UserConfig userConfig = userConfigService.getUserConfigByidAndType(adminId, UserConfigJobType.now_unity_id.jobId);
//        if (userConfig == null) {
//            return "-1";
//        }
//        return userConfig.getJobValue();
        return UnityUtil.getUnityId(userId);
    }

    @RequestMapping(value = "batchCreatePunchClock", method = RequestMethod.POST)
    @ApiOperation(value = "批量打卡", notes = "批量打卡")
    @ApiResponses({

    })
    public Result<Boolean> batchCreatePunchClock(@RequestBody BatchCreateClockDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEPUNCHCLOCK_CREATEPUNCHCLOCKDTO, dto);
        List<SimpEmp> list = punchAttendanceStaticsService.queryAllSimpEmpByProvider();
        String startDay = dto.getStartDay();
        List<Long> exceptUserIds = dto.getExceptUserIds();
        Date startDate = DateUtils.parse(startDay, DateUtils.DEFAULT_DATE_FORMAT);
        for (int i = 0; i < dto.getDays(); i++) {
            Date date = DateUtils.addDays(startDate, i);
            boolean holiday = HolidayUtil.isHoliday("", date);
            log.info("生成{}打卡数据,是否是节假日{},用户数{}", date, holiday, list.size());
            if (holiday) {
                continue;
            }
            for (SimpEmp e : list) {
                Long userId = e.getGxqptEmpId();
                String unityId = e.getMainorgid().trim();
                log.info("当前生成用户id:{},单位id:{}",userId,unityId);
                if (exceptUserIds != null && exceptUserIds.contains(userId)) {
                    continue;
                }

                String singStr = randomTime(1);
                Date singDate = DateUtils.getDateTime(date, singStr);

                String singOffStr = randomTime(2);
                Date singOffDate = DateUtils.getDateTime(date, singOffStr);
                //打卡记录数据(一天一条)
                PunchClock pc = dozerUtils.map(dto, PunchClock.class);
                pc.setUserId(userId);
                pc.setAdceType(1);
                pc.setUnitId(unityId);
                pc.setAdceType(1);
                pc.setClockDate(date);
                pc.setSignInTime(singDate);
                pc.setSignOffTime(singOffDate);
                pc.setCreateUser(userId);
                pc.setUserId(userId);
                pc.setStatus(1);
                //签到打卡历史记录数据
                PunchClockHis spcHis = new PunchClockHis();
                spcHis.setAdceType(pc.getAdceType());
                spcHis.setUnitId(unityId);
                spcHis.setClockType(1);
                spcHis.setCreateUser(userId);
                spcHis.setUserId(userId);
                spcHis.setClockTime(singDate);
                spcHis.setStatus(pc.getStatus());
                spcHis.setLocation(pc.getSignLocation());
                spcHis.setLat(pc.getSignInLat());
                spcHis.setLng(pc.getSignInLng());
                //签到打卡历史记录数据
                PunchClockHis opcHis = new PunchClockHis();
                opcHis.setAdceType(pc.getAdceType());
                opcHis.setUnitId(unityId);
                opcHis.setClockType(2);
                opcHis.setCreateUser(userId);
                opcHis.setUserId(userId);
                opcHis.setClockTime(singOffDate);
                opcHis.setStatus(pc.getStatus());
                opcHis.setLocation(pc.getSignOffLocation());
                opcHis.setLat(pc.getSignOffLat());
                opcHis.setLng(pc.getSignOffLng());

                punchClockService.saveSelective(pc);
                punchClockHisService.saveSelective(spcHis);
                punchClockHisService.saveSelective(opcHis);
                //统计
                Map<String, String> map = new HashMap<>();
                map.put("unityId", unityId);
                //打卡类型:1,签到；2，签退
                map.put("clockType", String.valueOf(1));
                //考勤类型:1,内勤；2，外勤
                map.put("adceType", String.valueOf(1));


                //统计签到
                punchStaticsManager.saveStatics(userId, unityId, date, StaticsConst.TYPE_WORK_PUNCH_CLOCK, pc.getId(), map);
                //统计签退
                map.put("clockType", String.valueOf(2));
                punchStaticsManager.saveStatics(userId, unityId, date, StaticsConst.TYPE_WORK_PUNCH_CLOCK, pc.getId(), map);
            }
        }
        return Result.success(true);
    }

    private String randomTime(int type) {
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        // randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
        //int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        if (type == 1) {
            sb.append("08:");
            int min = rand.nextInt(30) + 30;
            sb.append(min + ":");
        } else if (type == 2) {
            sb.append("17:");
            int min = rand.nextInt(31);
            if (min < 10) {
                sb.append("0" + min + ":");
            } else {
                sb.append(min + ":");
            }
        }

        int sec = rand.nextInt(58) + 2;
        if (sec < 10) {
            sb.append("0" + sec);
        } else {
            sb.append(sec);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        for(int i=0;i<30;i++){
//            System.out.println(randomTime(1));
//        }
//
//    }
}
