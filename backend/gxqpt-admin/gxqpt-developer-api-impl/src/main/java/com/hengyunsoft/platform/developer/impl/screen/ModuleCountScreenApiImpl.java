package com.hengyunsoft.platform.developer.impl.screen;

import com.alibaba.fastjson.JSON;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.repository.core.service.LoginLogsService;
import com.hengyunsoft.platform.developer.api.screen.api.ModuleCountScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleUserInfosDTO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleCountDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationLinksDO;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@Api(value = "API - ModuleCountScreenApiImpl", description = "大屏查询功能分类统计数量")
@RestController
@RequestMapping("module")
@Slf4j
public class ModuleCountScreenApiImpl implements ModuleCountScreenApi {
    @Autowired
    private ServiceModuleService moduleService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private LoginLogsService loginLogService;

    @Autowired
    private ModuleUseJnlService moduleUseJnlService;

    public static Long LASTASKTIME = null;
    public static Double LASTASKPAGENUM = null;

    /**
     * 2018-5-12 大屏造数据
     * @return
     */
    @Override
    @RequestMapping(value = "/getServiceModuleCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询服务功能数量",
            notes = "查询服务功能数量")
    public Result<Map> getServiceModuleCount() {
        Map<String,String> map = new HashMap();
        map.put("zcpt","06");
        map.put("zcyy","09");
        map.put("zcfw","09");
        map.put("zcmk","06");
        return Result.success(map);
    }

    /**
     * 2018-5-13 应用集成大屏造数据
     * 获取单位对模块的使用信息
     * @return
     */
    @Override
    @ApiOperation(value = "获取单位对模块的使用信息",
            notes = "获取单位对模块的使用信息")
    @RequestMapping(value = "/getdeptUseModulesInfo", method = RequestMethod.GET)
    public Result<List<ModuleUserInfosDTO>> getdeptUseModulesInfo() {
        //30
        String [] unitModules = {
                "共享交换平台","大数据分析平台","统一监控平台","安全保障平台","统一运维平台","移动终端平台",
                "权限管理系统","云盘管理系统","标准管理系统","预警管理系统","消息管理系统","模块监控系统",
                "短信管理系统","日志管理系统","邮件管理系统","日志服务","消息队列服务","发布管道服务",
                "邮件管理服务","服务管理中心","文件服务","统一认证服务","预警管道服务","共享交换服务",
                "共性管理模块","共性管理工具","模块管理中心","日志模块","消息队列模块","统一认证模块"};
        //16
        String [] deptNames = {
                "党政办公室","组织与人力资源部","投资促进局","规划建设局",
                "财政局","创业服务中心","科技创新创业局","产业发展局","政务服务中心","监察审计局","社会事务局",
                "国土分局","国税局","地税分局","工商分局","质监分局"};
        List<ModuleUserInfosDTO> list = new ArrayList<>();
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        // 5分钟之前的时间
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -5);
        Date beforeD = beforeTime.getTime();

        for(int i=0;i<20;i++){
            int randApp = new Random().nextInt(30);
            int randDept = new Random().nextInt(16);
            ModuleUserInfosDTO moduleUserInfosDTO = new ModuleUserInfosDTO();
            moduleUserInfosDTO.setDeptName(deptNames[randDept]);
            moduleUserInfosDTO.setModuleName(unitModules[randApp]);
            long date = random(now.getTime(),beforeD.getTime());
            Date before = new Date(date);
            String t = time.format(before);
            moduleUserInfosDTO.setTime(t);
            list.add(moduleUserInfosDTO);
        }
        return Result.success(list);
    }

    private  long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

    /**
     * 2018-5-13 大屏造数据
     * @return
     */
    @Override
    @ApiOperation(value = "查询雷达图数据",
            notes = "查询雷达图数据")
    @RequestMapping(value = "/getRadarCount", method = RequestMethod.GET)
    public Result<Map> getRadarCount() {
        //页面访问量计算公式：（随机数*10*时间间隔<本次与上次间隔>） 7-18点
        //页面访问量计算公式：（随机数*2*时间间隔<本次与上次间隔>） 0-7点
        Long nowAskTime = System.currentTimeMillis()/(60*1000);
        if(LASTASKTIME == null){
            LASTASKTIME = nowAskTime - 100;
        }
        Long diff = nowAskTime - LASTASKTIME;
        LASTASKTIME = nowAskTime;
        Random random = new Random();
        Double rand = random.nextDouble();
        if(LASTASKPAGENUM==null){
            LASTASKPAGENUM = 0.0;
        }
        double askPageNum = LASTASKPAGENUM;
        int nowHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(nowHour>=7 && nowHour <=18){
            askPageNum += rand*10*diff+1;
        }else{
            askPageNum += rand*2*diff+1;
        }
        LASTASKPAGENUM = askPageNum;
        LASTASKTIME = System.currentTimeMillis()/(60*1000);
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
        Date nowTime=new Date();
        String nowDay = time.format(nowTime);
        String tmp = nowDay.substring(nowDay.lastIndexOf("-")+1,nowDay.length());
        String rmp = nowDay.substring(0,nowDay.lastIndexOf("-")+1);
        int itmp = (Integer.parseInt(tmp)+1);
        String nextDay = rmp+itmp;
        // 查询  访问用户数就是当天的登录次数,停留时间就是退出时间减去登录时间总和
        Map<String,String> map = loginLogService.getLoginAskCount(nowDay,nextDay);
        //查询 活跃用户数就是当天的登录用户数
        int num = loginLogService.getLoginCount(nowDay,nextDay);
        //当天功能使用次数
        SimpleDateFormat ntime=new SimpleDateFormat("yyyy-M-dd");
        String nDay = ntime.format(nowTime);
        String tmp1 = nDay.substring(nDay.lastIndexOf("-")+1,nDay.length());
        String rmp1 = nDay.substring(0,nDay.lastIndexOf("-")+1);
        int itmp1 = (Integer.parseInt(tmp1)+1);
        String nextDay1 = rmp1+itmp1;
        int count = moduleUseJnlService.getDayUserModuleCount(nDay,nextDay1);
        Map resutl = new HashMap();
        resutl.put("fwyhs",map.get("askCount"));
        resutl.put("yhtlsj",map.get("stayTime"));
        resutl.put("hyyhs",num);
        resutl.put("gnsy",count);
        BigDecimal bd1=new BigDecimal(askPageNum).setScale(0, BigDecimal.ROUND_HALF_UP);
        resutl.put("ymfw",bd1.toString());
        return Result.success(resutl);
    }

    /**
     * 查询功能分类统计数量
     * @param top
     * @return
     */
    @Override
    @ApiOperation(value = "查询功能分类统计数量",
            notes = "查询功能分类统计数量")
    @ApiResponses({
    })
    @RequestMapping(value = "/getModuleCount", method = RequestMethod.GET)
    public Result<List<ModuleCountDTO>> getModuleCount(@RequestParam(value = "appId" ,required = false) String appId) {
        /*List<ModuleCountDO> list =  moduleService.getModuleCount(top);*/
        //大屏造数据
        String [] name = {"支撑平台","支撑应用","支撑服务","支撑模块"};
        String [] appIds = {
                "1016187584545","1016191778881","1016191778913","1016191778945","1016191778977","1016191779009",
                "1016191779041","1016191779073","1016191779105","1016191779137","1016191779169","1016191779201",
                "1016191779233"};
        List<ModuleCountDO> list = new ArrayList<>();
        List<ModuleCountDO> listall = new ArrayList<>();
        for(int i=0;i< name.length;i++){
            ModuleCountDO moduleCountDO = new ModuleCountDO();
            moduleCountDO.setName(name[i]);
            moduleCountDO.setTypeName(name[i]);
            if(i==0){
                moduleCountDO.setNum(25);
            }else if(i==1){
                moduleCountDO.setNum(30);
            }else if(i==2){
                moduleCountDO.setNum(35);
            }else{
                moduleCountDO.setNum(10);
            }
            listall.add(moduleCountDO);
        }
        Map<String,List<ModuleCountDO>> map = new HashMap<>();
        map.put("all",listall);
        int [] num ={
                0,0,50,50,
                0,0,50,50,
                0,0,100,0,
                26,31,31,12,
                28,28,33,11,
                28,28,39,5,
                21,33,33,13,
                25,25,24,26,
                38,25,37,0,
                27,27,32,14,
                25,35,35,5,
                24,35,35,6,
                26,30,34,10
                };
        for(int i =0;i<appIds.length;i++){
            List<ModuleCountDO> lists = new ArrayList<>();
            for(int j=0;j< name.length;j++){
                ModuleCountDO moduleCountDO = new ModuleCountDO();
                moduleCountDO.setName(name[j]);
                moduleCountDO.setTypeName(name[j]);
                if(j==0){
                    moduleCountDO.setNum(num[i*4+0]);
                }else if(j==1){
                    moduleCountDO.setNum(num[i*4+1]);
                }else if(j==2){
                    moduleCountDO.setNum(num[i*4+2]);
                }else{
                    moduleCountDO.setNum(num[i*4+3]);
                }
                lists.add(moduleCountDO);
            }
            map.put(appIds[i],lists);
        }
        if(appId==null || "".equals(appId)){
            list = map.get("all");
        }else{
            list = map.get(appId);
        }

        List<ModuleCountDTO> rlist = dozerUtils.mapList(list,ModuleCountDTO.class);
        return Result.success(rlist);
    }

    /**
     * 查询功能应用关系-力引导布局数据
     * @return
     */
    @Override
    @ApiOperation(value = "大屏查询功能应用关系-力引导布局数据",
            notes = "大屏查询功能应用关系-力引导布局数据")
    @ApiResponses({
    })
    @RequestMapping(value = "/getModuleRelation", method = RequestMethod.GET)
    public Result<Map> getModuleRelation(@RequestParam(value="appId",required = false)String appId) {
      /*  List<ModuleRelationDO> list = moduleService.getNodesDate();
        List<ModuleRelationLinksDO> links = moduleService.getLinksDate();*/
        //大屏造数据
        List<ModuleRelationDO> list = new ArrayList<>();
        List<ModuleRelationLinksDO> links = new ArrayList<>();
        int [] symbolSize = {35,35,30,25,20,15};
        //13
        String [] appNames = {
                "大数据精准招商安商","大数据精准政务服务","大数据精准权力监督","大数据精准综合治税",
                "大数据精准经济监测","大数据精准市场监管","大数据精准信用评估","大数据精准生态监测",
                "大数据精准国土监测","大数据精准安全监管","大数据精准结对帮扶","大数据精准移动办公","智慧质监"};

        String [] appIds = {
                "1016187584545","1016191778881","1016191778913","1016191778945","1016191778977","1016191779009",
                "1016191779041","1016191779073","1016191779105","1016191779137","1016191779169","1016191779201",
                "1016191779233"};

        for(int i = 0;i<appNames.length;i++){
            ModuleRelationDO relationDO = new ModuleRelationDO();
            relationDO.setId(appIds[i]);
            relationDO.setName(appNames[i]);
            relationDO.setCategory(0);
            relationDO.setDraggable(true);
            relationDO.setSymbolSize(symbolSize[0]);
            list.add(relationDO);
        }

        //16
        String [] deptNames = {"党政办公室","组织与人力资源部","投资促进局","规划建设局",
                "财政局","创业服务中心","科技创新创业局","产业发展局","政务服务中心","监察审计局","社会事务局",
                "国土分局","国税局","地税分局","工商分局","质监分局"};

        String [] deptIds = {
                "1473521909793","1473521909825","1473521909857","1473521909889","1473521909921",
                "1473521909953","1473521909985","1473521910017","1473521910049","1473521910081",
                "1473521910113","1473526104449","1473526104481","1473526104513","1473526104545",
                "1473526104577"};

        for(int i = 0;i<deptNames.length;i++){
            ModuleRelationDO relationDO = new ModuleRelationDO();
            relationDO.setId(deptIds[i]);
            relationDO.setName(deptNames[i]);
            relationDO.setCategory(1);
            relationDO.setDraggable(true);
            relationDO.setSymbolSize(symbolSize[1]);
            list.add(relationDO);
        }

        //30
        String [] unitModules = {
                "共享交换平台","大数据分析平台","统一监控平台","安全保障平台","统一运维平台","移动终端平台",
                "权限管理系统","云盘管理系统","标准管理系统","预警管理系统","消息管理系统","模块监控系统",
                "短信管理系统","日志管理系统","邮件管理系统","日志服务","消息队列服务","发布管道服务",
                "邮件管理服务","服务管理中心","文件服务","统一认证服务","预警管道服务","共享交换服务",
                "共性管理模块","共性管理工具","模块管理中心","日志模块","消息队列模块","统一认证模块"};

        String [] unitModuleIds = {
                "1782738583585","1782738583617","1782738583649","1782738583681","1782742778017","1782742778049",
                "1782742778081","1782742778113","1782742778145","1782742778177","1782742778209","1782742778241",
                "1782742778273","1782742778305","1782742778337","1782742778369","1782742778401","1782742778433",
                "1782742778465","1782742778497","1782742778529","1782742778561","1782742778593","1782742778625",
                "1782742778657","1782742778689","1782742778721","1782742778753","1782742778785","1782742778817"};

        for(int i = 0;i<unitModules.length;i++){
            ModuleRelationDO relationDO = new ModuleRelationDO();
            relationDO.setId(unitModuleIds[i]);
            relationDO.setName(unitModules[i]);
            relationDO.setCategory(2);
            relationDO.setDraggable(true);
            if(i<=5){
                relationDO.setSymbolSize(symbolSize[2]);
            }else if(i>=6 && i<=14){
                relationDO.setSymbolSize(symbolSize[3]);
            }else if(i>=15 && i<=23){
                relationDO.setSymbolSize(symbolSize[4]);
            }else{
                relationDO.setSymbolSize(symbolSize[5]);
            }
            list.add(relationDO);
        }

        //应用与组件关系
        for(int i=0;i<unitModuleIds.length;i++){
            for(int j=0;j<appIds.length;j++){
                if(gxs[i][j] == 1){
                    ModuleRelationLinksDO relation = new ModuleRelationLinksDO();
                    relation.setSource(appIds[j]);
                    relation.setTarget(unitModuleIds[i]);
                    relation.setValue("调用");
                    links.add(relation);
                }
            }
        }

        //关系数据
        //党政办公室 管理  大数据精准移动办公
        ModuleRelationLinksDO relation1 = new ModuleRelationLinksDO();
        relation1.setSource(deptIds[0]);
        relation1.setTarget(appIds[11]);
        relation1.setValue("管理");
        links.add(relation1);

        //组织与人力资源部（组织人事部、团工委） 管理 大数据精准结对帮扶
        ModuleRelationLinksDO relation2 = new ModuleRelationLinksDO();
        relation2.setSource(deptIds[1]);
        relation2.setTarget(appIds[10]);
        relation2.setValue("管理");
        links.add(relation2);

        //投资促进局（商务局） 管理 大数据精准招商安商
        ModuleRelationLinksDO relation3 = new ModuleRelationLinksDO();
        relation3.setSource(deptIds[2]);
        relation3.setTarget(appIds[0]);
        relation3.setValue("管理");
        links.add(relation3);

        //规划建设局（生态文明建设局） 管理 大数据精准生态监测
        ModuleRelationLinksDO relation4 = new ModuleRelationLinksDO();
        relation4.setSource(deptIds[3]);
        relation4.setTarget(appIds[7]);
        relation4.setValue("管理");
        links.add(relation4);

        //财政局 管理 大数据精准综合治税
        ModuleRelationLinksDO relation5 = new ModuleRelationLinksDO();
        relation5.setSource(deptIds[4]);
        relation5.setTarget(appIds[3]);
        relation5.setValue("管理");
        links.add(relation5);

        //产业发展局 管理 大数据精准经济监测
        ModuleRelationLinksDO relation7 = new ModuleRelationLinksDO();
        relation7.setSource(deptIds[7]);
        relation7.setTarget(appIds[4]);
        relation7.setValue("管理");
        links.add(relation7);

        //产业发展局 管理 大数据精准结对帮扶
        ModuleRelationLinksDO relation7_1 = new ModuleRelationLinksDO();
        relation7_1.setSource(deptIds[7]);
        relation7_1.setTarget(appIds[10]);
        relation7_1.setValue("管理");
        links.add(relation7_1);

        //政务服务中心 管理 大数据精准政务服务
        ModuleRelationLinksDO relation8 = new ModuleRelationLinksDO();
        relation8.setSource(deptIds[8]);
        relation8.setTarget(appIds[1]);
        relation8.setValue("管理");
        links.add(relation8);

        //政务服务中心 管理 大数据精准权力监督
        ModuleRelationLinksDO relation8_1 = new ModuleRelationLinksDO();
        relation8_1.setSource(deptIds[8]);
        relation8_1.setTarget(appIds[2]);
        relation8_1.setValue("管理");
        links.add(relation8_1);

        //监察审计局 管理 大数据精准权力监督
        ModuleRelationLinksDO relation9 = new ModuleRelationLinksDO();
        relation9.setSource(deptIds[9]);
        relation9.setTarget(appIds[2]);
        relation9.setValue("管理");
        links.add(relation9);

        //社会事务局（城市管理局） 管理 大数据精准生态监测
        ModuleRelationLinksDO relation10 = new ModuleRelationLinksDO();
        relation10.setSource(deptIds[10]);
        relation10.setTarget(appIds[7]);
        relation10.setValue("管理");
        links.add(relation10);
        //社会事务局（城市管理局） 管理 大数据精准安全监管
        ModuleRelationLinksDO relation10_1 = new ModuleRelationLinksDO();
        relation10_1.setSource(deptIds[10]);
        relation10_1.setTarget(appIds[9]);
        relation10_1.setValue("管理");
        links.add(relation10_1);
        //社会事务局（城市管理局） 管理 大数据精准结对帮扶
        ModuleRelationLinksDO relation10_2 = new ModuleRelationLinksDO();
        relation10_2.setSource(deptIds[10]);
        relation10_2.setTarget(appIds[10]);
        relation10_2.setValue("管理");
        links.add(relation10_2);

        //国土分局 管理 大数据精准国土监测
        ModuleRelationLinksDO relation11 = new ModuleRelationLinksDO();
        relation11.setSource(deptIds[11]);
        relation11.setTarget(appIds[8]);
        relation11.setValue("管理");
        links.add(relation11);

        //国税局 管理 大数据精准综合治税
        ModuleRelationLinksDO relation12 = new ModuleRelationLinksDO();
        relation12.setSource(deptIds[12]);
        relation12.setTarget(appIds[3]);
        relation12.setValue("管理");
        links.add(relation12);

        //地税分局 管理 大数据精准综合治税
        ModuleRelationLinksDO relation13 = new ModuleRelationLinksDO();
        relation13.setSource(deptIds[13]);
        relation13.setTarget(appIds[3]);
        relation13.setValue("管理");
        links.add(relation13);

        //工商分局 管理 大数据精准市场监管
        ModuleRelationLinksDO relation14 = new ModuleRelationLinksDO();
        relation14.setSource(deptIds[14]);
        relation14.setTarget(appIds[5]);
        relation14.setValue("管理");
        links.add(relation14);

        //工商分局 管理 大数据精准信用评估
        ModuleRelationLinksDO relation14_1 = new ModuleRelationLinksDO();
        relation14_1.setSource(deptIds[14]);
        relation14_1.setTarget(appIds[6]);
        relation14_1.setValue("管理");
        links.add(relation14_1);

        //质监分局 管理 智慧质监
        ModuleRelationLinksDO relation15 = new ModuleRelationLinksDO();
        relation15.setSource(deptIds[15]);
        relation15.setTarget(appIds[12]);
        relation15.setValue("管理");
        links.add(relation15);

        //根据appId查询数据
        List<ModuleRelationLinksDO> newRelations = new ArrayList<>();
        Set<ModuleRelationDO> newList = new HashSet<>();
        if(appId!=null && !"".equals(appId)){
            for(ModuleRelationLinksDO dos:links){
                if(appId.equals(dos.getSource())||appId.equals(dos.getTarget())){
                    newRelations.add(dos);
                }
            }
            for(ModuleRelationDO rDo:list){
                for(ModuleRelationLinksDO relLinks:newRelations){
                    if(relLinks.getSource().equals(rDo.getId())||relLinks.getTarget().equals(rDo.getId())){
                        newList.add(rDo);
                    }
                }
            }
            links = newRelations;
            list = new ArrayList<>(newList);
        }

        String jlist = JSON.toJSONString(list);
        String jlink = JSON.toJSONString(links);
        Map map = new HashMap<>();
        map.put("result",jlist);
        map.put("links",jlink);
        return Result.success(map);
    }


    //接入应用和平台应用关系数组从excle中取得
    int[][] gxs = {
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,1,1,1,1,0,1,1,1,0,1},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,1,1,1,1,1,1,1,0,1,1},
            {0,0,0,0,0,0,0,0,0,1,1,0,1},
            {0,0,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,0,1,1,1,1},
            {0,0,0,1,0,0,1,1,0,1,1,1,1},
            {0,0,0,1,1,1,1,0,1,1,1,0,1},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,0,0,0,1,0,1},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,0,0,1,1,1,0,1,1,0,1},
            {0,0,0,0,0,0,1,0,0,0,0,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,1,1,1,1,0,1,1,1,0,1},
            {0,0,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,0,1,1,1,1},
            {0,0,0,1,0,0,1,0,0,1,0,0,0},
            {1,1,0,0,1,0,1,1,0,1,0,0,1}
    };
}
