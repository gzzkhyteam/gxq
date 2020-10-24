package com.hengyunsoft.platform.hardware.impl.panel;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.hardware.dto.apply.StatisticsDiskTransDTO;
import com.hengyunsoft.platform.hardware.dto.apply.StatisticsMemTransDTO;
import com.hengyunsoft.platform.hardware.dto.panel.CpuMonthResDTO;
import com.hengyunsoft.platform.hardware.dto.panel.CpuMonthResRetDTO;
import com.hengyunsoft.platform.hardware.dto.panel.CpuResDTO;
import com.hengyunsoft.platform.hardware.dto.panel.OrgCpuResDTO;
import com.hengyunsoft.platform.hardware.dto.panel.StorageDiskDataDTO;
import com.hengyunsoft.platform.hardware.dto.panel.StorageMemDataDTO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.PanelOrgCpuCountDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.PanelOrgMonthCpuDO;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryService;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryTypeService;
import com.hengyunsoft.platform.hardware.repository.manage.example.DiskManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.example.ServerManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.DiskManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.MachineManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.ServerManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述：面板查看界面
 * 修改人：wz
 * 修改时间：2018/9/06
 * 修改内容：
 */
@Api(value = "API - PanelApi", description = "面板查看界面")
@RestController
@RequestMapping("panel")
@Slf4j
public class PanelApiImpl {
    @Autowired
    private MachineManageService machineManageService;
    @Autowired
    private ServerManageService serverManageService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private DiskManageService diskManageService;
    @Autowired
    private DictionaryTypeService dictionaryTypeService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private RoleApi roleApi;

    private static final String roleCode = "HARDWARE_DEPT_ROLE";

    @ApiOperation(value = "存储面板内存信息统计", notes = "存储面板内存信息统计")
    @RequestMapping(value = "/getStorageMemData", method = RequestMethod.GET)
    public Result<StorageMemDataDTO> getStorageMemData() {
        //获取所有基本的服务器信息
        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria();
        List<StatisticsMemTransDTO> list = dozerUtils
                .mapList(serverManageService.find(serverManageExample), StatisticsMemTransDTO.class);
        //初始化一些数据
        StorageMemDataDTO res = new StorageMemDataDTO();
        Date lastMonth = getLastMonth();

        //设置总内存
        res.setMemSize(list.stream()
                .filter(obj -> obj.getUseStatus() == 1).mapToInt(StatisticsMemTransDTO::getMemorySize).sum());

        //设置本月新增
        res.setMonthSave(list.stream().filter(obj -> obj.getUseStatus() == 1 &&
                isSameDate(obj.getCreateTime(), new Date())).mapToInt(StatisticsMemTransDTO::getMemorySize).sum());
        //获取上月新增
        int lastMonthSave = list.stream().filter(obj -> obj.getUseStatus() == 1 &&
                isSameDate(obj.getCreateTime(), lastMonth)).mapToInt(StatisticsMemTransDTO::getMemorySize).sum();

        //设置本月回收
        res.setMonthRemove(list.stream().filter(obj -> obj.getUseStatus() == 0 &&
                isSameDate(obj.getRevertTime(), new Date())).mapToInt(StatisticsMemTransDTO::getMemorySize).sum());

        //获取上月回收
        int lastMonthRemove = list.stream().filter(obj -> obj.getUseStatus() == 0 &&
                isSameDate(obj.getRevertTime(), lastMonth)).mapToInt(StatisticsMemTransDTO::getMemorySize).sum();

        //设置新增占比
        res.setSaveOccupationRatio(division2Float(res.getMonthSave(), res.getMemSize()));

        //设置回收占比
        res.setRemoveOccupationRatio(division2Float(res.getMonthRemove(), res.getMemSize()));

        //设置新增环比
        res.setSaveRingRatio(division2Float((res.getMonthSave().intValue() - lastMonthSave), lastMonthSave));

        //设置回收环比
        res.setRemoveRingRatio(division2Float((res.getMonthRemove().intValue() - lastMonthRemove), lastMonthRemove));

        //设置净增
        res.setNetGrowth(res.getMonthSave() - res.getMonthRemove());

        //设置净增占比
        res.setNetGrowthOccupationRatio(division2Float(res.getNetGrowth(), res.getMemSize()));

        return Result.success(res);
    }

    @ApiOperation(value = "存储面板磁盘信息统计", notes = "存储面板磁盘信息统计")
    @RequestMapping(value = "/getStorageDiskData", method = RequestMethod.GET)
    public Result<StorageDiskDataDTO> getStorageDiskData() {
        //获取所有基本的服务器信息
        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria();
        List<StatisticsMemTransDTO> listServer = dozerUtils
                .mapList(serverManageService.find(serverManageExample), StatisticsMemTransDTO.class);

        //获取所有基本的磁盘信息
        DiskManageExample diskManageExample = new DiskManageExample();
        diskManageExample.createCriteria()
                .andServerIdIn(listServer.stream().map(StatisticsMemTransDTO::getId).collect(Collectors.toList()));
        List<StatisticsDiskTransDTO> listDisk = dozerUtils
                .mapList(diskManageService.find(diskManageExample), StatisticsDiskTransDTO.class);
        List serverIds = listServer.stream().map(StatisticsMemTransDTO::getId).collect(Collectors.toList());

        //初始化一些数据
        StorageDiskDataDTO res = new StorageDiskDataDTO();
        Date lastMonth = getLastMonth();

        //设置总内存
        res.setMemSize((int) listDisk.stream()
                .filter(obj -> getServerManageJoinDisk(listServer, serverIds, obj.getServerId()) != null &&
                        getServerManageJoinDisk(listServer, serverIds, obj.getServerId())
                                .getUseStatus() == 1).mapToLong(StatisticsDiskTransDTO::getDiskSize).sum());
        //设置本月新增
        res.setMonthSave((int) listDisk.stream()
                .filter(obj -> getServerManageJoinDisk(listServer, serverIds, obj.getServerId()) != null &&
                        getServerManageJoinDisk(listServer, serverIds, obj.getServerId()).getUseStatus() == 1 &&
                        isSameDate(getServerManageJoinDisk(listServer, serverIds, obj.getServerId())
                                .getCreateTime(), new Date())).mapToLong(StatisticsDiskTransDTO::getDiskSize).sum());
        //设置本月回收
        res.setMonthRemove((int) listDisk.stream()
                .filter(obj -> getServerManageJoinDisk(listServer, serverIds, obj.getServerId()) != null &&
                        getServerManageJoinDisk(listServer, serverIds, obj.getServerId()).getUseStatus() == 0 &&
                        isSameDate(getServerManageJoinDisk(listServer, serverIds, obj.getServerId())
                                .getRevertTime(), new Date())).mapToLong(StatisticsDiskTransDTO::getDiskSize).sum());

        //获取上月新增
        int lastMonthSave = (int) listDisk.stream()
                .filter(obj -> getServerManageJoinDisk(listServer, serverIds, obj.getServerId()) != null &&
                        getServerManageJoinDisk(listServer, serverIds, obj.getServerId()).getUseStatus() == 1 &&
                        isSameDate(getServerManageJoinDisk(listServer, serverIds, obj.getServerId())
                                .getCreateTime(), lastMonth)).mapToLong(StatisticsDiskTransDTO::getDiskSize).sum();
        //获取上月回收
        int lastMonthRemove = (int) listDisk.stream()
                .filter(obj -> getServerManageJoinDisk(listServer, serverIds, obj.getServerId()) != null &&
                        getServerManageJoinDisk(listServer, serverIds, obj.getServerId()).getUseStatus() == 0 &&
                        isSameDate(getServerManageJoinDisk(listServer, serverIds, obj.getServerId())
                                .getRevertTime(), lastMonth)).mapToLong(StatisticsDiskTransDTO::getDiskSize).sum();

        //设置新增占比
        res.setSaveOccupationRatio(division2Float(res.getMonthSave(), res.getMemSize()));

        //设置回收占比
        res.setRemoveOccupationRatio(division2Float(res.getMonthRemove(), res.getMemSize()));

        //设置新增环比
        res.setSaveRingRatio(division2Float((res.getMonthSave().intValue() - lastMonthSave), lastMonthSave));

        //设置回收环比
        res.setRemoveRingRatio(division2Float((res.getMonthRemove().intValue() - lastMonthRemove), lastMonthRemove));

        //设置净增
        res.setNetGrowth(res.getMonthSave() - res.getMonthRemove());

        //设置净增占比
        res.setNetGrowthOccupationRatio(division2Float(res.getNetGrowth(), res.getMemSize()));

        return Result.success(res);
    }

    @ApiOperation(value = "存储面板部门内存统计图", notes = "存储面板部门内存统计图")
    @RequestMapping(value = "/findMemByDpm", method = RequestMethod.GET)
    public Result<Map<String, List<String>>> findMemByDpm() {
        //获取所有基本的服务器信息
        List<StatisticsMemTransDTO> list = dozerUtils
                .mapList(serverManageService.findServerManage(), StatisticsMemTransDTO.class);
        Map<String, List<StatisticsMemTransDTO>> collect = list.stream()
                .collect(Collectors.groupingBy(StatisticsMemTransDTO::getManageUid, Collectors.toList()));

        //提取分组数据
        Map<String, List<String>> res = new HashMap<>();
        List<String> names = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        collect.values().forEach(obj -> {
            names.add(obj.get(0).getOrgname());
            values.add(obj.stream().mapToInt(StatisticsMemTransDTO::getMemorySize).sum()+"");
        });

        //设置图表返回数据x,y
        res.put("x", names);
        res.put("y", values);

        return Result.success(res);
    }

    @ApiOperation(value = "存储面板部门磁盘统计图", notes = "存储面板部门磁盘统计图")
    @RequestMapping(value = "/findDiskByDpm", method = RequestMethod.GET)
    public Result<Map<String, List<String>>> findDiskByDpm() {
        //获取所有基本的服务器信息
        List<StatisticsDiskTransDTO> listDisk = dozerUtils
                .mapList(diskManageService.findDiskByDpm(), StatisticsDiskTransDTO.class);
        //提取分组数据
        Map<String, List<String>> res = new HashMap<>();
        List<String> names = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        if(listDisk !=null && listDisk.size()>0) {
        	for(StatisticsDiskTransDTO en: listDisk) {
        		names.add(en.getOrgname());
        		values.add(en.getDiskSize()+"");
        	}
        }
        //设置图表返回数据x,y
        res.put("x", names);
        res.put("y", values);

        return Result.success(res);
    }

    /**
     * 存储面板部门近一年内存统计图
     *
     * @return
     */
    @ApiOperation(value = "存储面板部门近一年内存统计图", notes = "存储面板近一年部门内存统计图")
    @RequestMapping(value = "/findMemByDpmAndLastYare", method = RequestMethod.GET)
    public Result<Map<String, List>> findMemByDpmAndLastYare() {
        //获取所有基本的服务器信息
        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria().andManageUidIsNotNull().andUseStatusEqualTo(1);
        List<StatisticsMemTransDTO> list = dozerUtils
                .mapList(serverManageService.find(serverManageExample), StatisticsMemTransDTO.class);
        Map<String, List<StatisticsMemTransDTO>> collect = list.stream()
                .collect(Collectors.groupingBy(StatisticsMemTransDTO::getManageUid, Collectors.toList()));

        //获取包括这个月在内过去12个月
        List<Date> datas = getLastYearMonth();

        //提取分组数据
        Map<String, List> res = new HashMap<>();
        List names = new ArrayList();
        List<Map<String, Object>> series = new ArrayList();
        collect.values().forEach(obj -> {
            Map<String, Object> map = new HashMap();
            List nums = new ArrayList();
            //加入legend
            names.add(obj.get(0).getOrgname());
            datas.forEach(data -> {
                nums.add(obj.stream().filter(mobj -> isLagerDate(data, mobj.getCreateTime())).mapToInt(StatisticsMemTransDTO::getMemorySize).sum());
            });
            map.put("name", obj.get(0).getOrgname());
            map.put("data", nums);
            //加入series
            series.add(map);
        });
        //获取月份
        List months = new ArrayList();
        List<String> namess = getNewList(names);
        List<Map<String, Object>> seriess = new ArrayList();
        for(String name :  namess) {
        	List<List<Integer>> listData = new ArrayList<>();
        	int i = 0;
        	for(Map<String, Object> map :series) {
        		String st = map.get("name").toString();
        		if(name.equals(st)) {
        			listData.add(i,(List<Integer>) map.get("data"));
        			i++;
        		}
        	}
        	Map<String, Object> maps = new HashMap<>();
        	List mergeListData = mergeListData(listData);
        	maps.put("name", name);
        	maps.put("data", mergeListData);
        	seriess.add(maps);
        }
        datas.forEach(
                obj -> {
                    months.add((obj.getMonth() + 1) + "月");
                }
        );

        //设置图表返回数据统计图参数
        res.put("legend", namess);
        res.put("xAxis", months);
        res.put("series", seriess);

        return Result.success(res);
    }

    /**
     * 存储面板部门近一年磁盘统计图
     *
     * @return
     */
    @ApiOperation(value = "存储面板部门近一年磁盘统计图", notes = "存储面板部门近一年磁盘统计图")
    @RequestMapping(value = "/findDiskByDpmAndLastYare", method = RequestMethod.GET)
    public Result<Map<String, List>> findDiskByDpmAndLastYare() {
        //获取所有基本的服务器信息
        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria().andManageUidIsNotNull().andUseStatusEqualTo(1);
        List<StatisticsMemTransDTO> listMem = dozerUtils
                .mapList(serverManageService.find(serverManageExample), StatisticsMemTransDTO.class);
        Map<String, List<StatisticsMemTransDTO>> collect = listMem.stream()
                .collect(Collectors.groupingBy(StatisticsMemTransDTO::getManageUid, Collectors.toList()));

        //获取所有磁盘信息
        DiskManageExample diskManageExample = new DiskManageExample();
        diskManageExample.createCriteria().andServerIdIn(listMem.stream()
                .map(StatisticsMemTransDTO::getId).collect(Collectors.toList()));
        List<StatisticsDiskTransDTO> listDisk = dozerUtils
                .mapList(diskManageService.find(diskManageExample), StatisticsDiskTransDTO.class);

        //获取包括这个月在内过去12个月
        List<Date> datas = getLastYearMonth();

        //提取分组数据
        Map<String, List> res = new HashMap<>();
        List names = new ArrayList();
        List x = new ArrayList();
        List<Map<String, Object>> series = new ArrayList();
        collect.values().forEach(obj -> {
            Map<String, Object> map = new HashMap();
            List<Integer> nums = new ArrayList<>();
            //加入legend
            names.add(obj.get(0).getOrgname());
            datas.forEach(data -> {
                nums.add(listDisk.stream().filter(disk -> {
                    StatisticsMemTransDTO mobj = getServerManageJoinDisk(obj, null, disk.getServerId());
                    if (mobj != null && isLagerDate(data, mobj.getCreateTime())) {
                        return true;
                    }
                    return false;
                }).mapToInt(StatisticsDiskTransDTO::getDiskSize).sum());
            });
            map.put("name", obj.get(0).getOrgname());
            map.put("data", nums);
            //加入series
            series.add(map);
        });
        //获取月份
        List months = new ArrayList();
        List<String> namess = getNewList(names);
        List<Map<String, Object>> seriess = new ArrayList();
        for(String name :  namess) {
        	List<List<Integer>> listData = new ArrayList<>();
        	int i = 0;
        	for(Map<String, Object> map :series) {
        		String st = map.get("name").toString();
        		if(name.equals(st)) {
        			listData.add(i,(List<Integer>) map.get("data"));
        			i++;
        		}
        	}
        	Map<String, Object> maps = new HashMap<>();
        	List mergeListData = mergeListData(listData);
        	maps.put("name", name);
        	maps.put("data", mergeListData);
        	seriess.add(maps);
        }
        datas.forEach(
                obj -> {
                    months.add((obj.getMonth() + 1) + "月");
                }
        );

        //设置图表返回数据统计图参数
        res.put("legend", namess);
        res.put("xAxis", months);
        res.put("series", seriess);

        return Result.success(res);
    }
    
    private List mergeListData(List listData) {
    	if(listData==null || listData.size()==0) {
    		for(int i =0;i<12;i++) {
    			listData.add(0);
    		}
    		return listData;
    	}
    	List<Integer> object = (List<Integer>) listData.get(0);
    	for(int i =1;i<listData.size();i++) {
    		List<Integer> object2 = (List<Integer>) listData.get(i);
    		for(int j =0;j<object2.size();j++) {
    			object.set(j, object.get(j)+object2.get(j));
    		}
    	}
    	return object;
    }
    /**
     * 数据去重
     * @param li
     * @return
     */
    private List<String> getNewList(List<String> li){
        List<String> list = new ArrayList<String>();//创建新的list
        for(int i=0; i<li.size(); i++){
            String str = li.get(i);  //获取传入集合对象的每一个元素
            if(!list.contains(str)){   //查看新集合中是否有指定的元素，如果没有则加入
                list.add(str);
            }
        }
        return list;  //返回集合
    }
    /**
     * @param a
     * @param b
     * @return
     */
    private float division2Float(int a, int b) {
        if (b == 0) {
            return 0;
        }
        float temp = (float) a * 100 / b;
        return (float) (Math.round(temp * 100)) / 100;
    }

    /**
     * 查找磁盘于服务器上的关联
     *
     * @param list
     * @param ids
     * @param id
     * @return
     */
    private StatisticsMemTransDTO getServerManageJoinDisk(List<StatisticsMemTransDTO> list, List ids, Long id) {
        if (ids == null) {
            ids = list.stream().map(StatisticsMemTransDTO::getId).collect(Collectors.toList());
        }
        if (!ids.contains(id)) {
            return null;
        }
        return list.get(ids.indexOf(id));
    }

    /**
     * 获取上一个月
     *
     * @return
     */
    private Date getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, -1);
        return cal.getTime();
    }

    private Date getLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(cal.MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获得过去12个月(包括本月)
     *
     * @return
     */
    private List<Date> getLastYearMonth() {
        List<Date> dates = new ArrayList<>();
        Date date = new Date();
        dates.add(date);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 11; i++) {
            cal.setTime(date);
            cal.add(cal.MONTH, -1);
            date = cal.getTime();
            dates.add(date);
        }
        Collections.reverse(dates);
        return dates;
    }

    /**
     * 判断两个月份相同否
     *
     * @param date1
     * @param date2
     * @return
     */
    private boolean isSameDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                    .get(Calendar.YEAR);
            boolean isSameMonth = isSameYear
                    && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
//            boolean isSameDate = isSameMonth
//                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2
//                    .get(Calendar.DAY_OF_MONTH);

            return isSameMonth;
        } catch (Exception e) {
            log.error("[RatingEngine] error occurred: ERROR ", e);
        }
        return false;
    }

    /**
     * 判断data1>data2
     *
     * @param date1
     * @param date2
     * @return
     */
    private boolean isLagerDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            boolean isSameYear = cal1.get(Calendar.YEAR) >= cal2
                    .get(Calendar.YEAR);
            boolean isSameMonth = isSameYear
                    && cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH);
//            boolean isSameDate = isSameMonth
//                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2
//                    .get(Calendar.DAY_OF_MONTH);

            return isSameMonth;
        } catch (Exception e) {
            log.error("[RatingEngine] error occurred: ERROR ", e);
        }
        return false;
    }


    /**
     * 查询计算资源面板cpu增比等情况
     *
     * @return
     */
    @ApiOperation(value = "查询计算资源面板cpu增比等情况", notes = "查询计算资源面板cpu增比等情况")
    @ApiResponses({
    })
    @RequestMapping(value = "getPanelCpuRes", method = RequestMethod.GET)
    public Result<CpuResDTO> getPanelCpuRes() {
        //总数
        int allCount = serverManageService.getAllSumOfCpu();
        String startTime = getMonthDate(0, 0);
        String endTime = getMonthDate(1, 0);

        String pstartTime = getMonthDate(0, 1);
        String pendTime = getMonthDate(1, 1);
        //本月新增
        int addCount = serverManageService.getMonthAddCpuRes(startTime, endTime);
        //上月新增
        int per_addCount = serverManageService.getMonthAddCpuRes(pstartTime, pendTime);
        //本月回收
        int subCount = serverManageService.getMonthSubCpuRes(startTime, endTime);
        int per_subCount = serverManageService.getMonthSubCpuRes(pstartTime, pendTime);

        //新增占比
        float add_percent = 0;
        //回收占比
        float sub_percent = 0;
        //新增环比
        float ciraddPercent = 0;
        //回收环比
        float cirsubPercent = 0;
        //净增占比
        float j_add_percent = 0;
        if (allCount != 0) {
            add_percent = Math.round((addCount / (float) allCount) * 100);
            sub_percent = Math.round((subCount / (float) allCount) * 100);
        }

        if (per_addCount != 0) {
            ciraddPercent = Math.round(((addCount - per_addCount) / (float) per_addCount) * 100);
        }
        if (subCount != 0) {
            cirsubPercent = Math.round(((subCount - per_subCount) / (float) subCount) * 100);
        }

        //净增
        int add = addCount - subCount;
        if (allCount != 0) {
            j_add_percent = Math.round((add / (float) allCount) * 100);
        }

        CpuResDTO dto = new CpuResDTO();
        dto.setCpu(allCount);
        dto.setCurMonAdd(addCount);
        dto.setCurMonSub(subCount);
        dto.setAddPercent(add_percent);
        dto.setSubPercent(sub_percent);
        dto.setCiraddPercent(ciraddPercent);
        dto.setRevertPercent(cirsubPercent);
        dto.setJadd(add);
        dto.setJaddPercent(j_add_percent);
        return Result.success(dto);
    }

    /**
     * 查询各单位计算资源面板cpu等情况
     *
     * @return
     */
    @ApiOperation(value = "查询各单位计算资源面板cpu等情况", notes = "查询各单位计算资源面板cpu等情况")
    @ApiResponses({
    })
    @RequestMapping(value = "getPanelOrgCpuRes", method = RequestMethod.GET)
    public Result<List<OrgCpuResDTO>> getPanelOrgCpuRes() {
        List<PanelOrgCpuCountDO> dos = serverManageService.getPanelOrgCpuRes();
        List<OrgCpuResDTO> list = dozerUtils.mapList(dos, OrgCpuResDTO.class);
        return Result.success(list);
    }

    /**
     * 查询各单位每月计算资源cpu情况
     *
     * @return
     */
    @ApiOperation(value = "查询各单位每月计算资源cpu情况", notes = "查询各单位每月计算资源cpu情况")
    @ApiResponses({
    })
    @RequestMapping(value = "getPanelMonthOrgCpuRes", method = RequestMethod.GET)
    public Result<CpuMonthResRetDTO> getPanelMonthOrgCpuRes() {
        CpuMonthResRetDTO retDTO = new CpuMonthResRetDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //当前月份
        SimpleDateFormat sdfnow = new SimpleDateFormat("M");
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Date nowd = now.getTime();
        String nowMonth = sdfnow.format(nowd);
        //大于当前月份的个数
        int numb = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -11);
        Date m = c.getTime();
        String startMonth = sdf.format(m);
        String endMonth = sdf.format(new Date());
        //坐标12月
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            Calendar tmp = Calendar.getInstance();
            tmp.setTime(new Date());
            tmp.add(Calendar.MONTH, (i - 12));
            String month = sdf.format(tmp.getTime());
            months[i - 1] = month;
            //获取大于当前月份的月份的个数，跨年情况
            String cur = sdfnow.format(tmp.getTime());
            if (Integer.parseInt(cur) > Integer.parseInt(nowMonth)) {
                numb++;
            }
        }
        retDTO.setMonths(months);
        Set<String> org = new HashSet<>();
        List<PanelOrgMonthCpuDO> dos = serverManageService.getPanelMonthOrgCpuRes(startMonth, endMonth);
        dos.forEach(d -> org.add(d.getOrgname()));
        List<CpuMonthResDTO> cpuRes = new ArrayList<>();
        org.forEach(o -> {
            CpuMonthResDTO dto = new CpuMonthResDTO();
            dto.setCpuCount(new int[12]);
            dto.setOrgname(o);
            cpuRes.add(dto);
        });
        for (CpuMonthResDTO dt : cpuRes) {
            for (PanelOrgMonthCpuDO d : dos) {
                if (dt.getOrgname().equals(d.getOrgname())) {
                    if (Integer.parseInt(d.getNum()) > Integer.parseInt(nowMonth)) {
                        int index = Integer.parseInt(d.getNum()) - Integer.parseInt(nowMonth);
                        dt.getCpuCount()[index - 1] = getSumArray(dt.getCpuCount(), index - 1) + d.getCpuCount();
                    } else {
                        int index = numb + Integer.parseInt(d.getNum());
                        dt.getCpuCount()[index - 1] = getSumArray(dt.getCpuCount(), index - 1) + d.getCpuCount();
                    }
                }
            }
        }

        retDTO.setOrgCpuRes(cpuRes);
        return Result.success(retDTO);
    }

    /**
     * 数组求和，计算0到index索引之和
     *
     * @param sourece
     * @param index
     * @return
     */
    private int getSumArray(int[] sourece, int index) {
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += sourece[i];
        }
        return sum;
    }

    /**
     * type 0获取本月开始日期，1获取本月结束日期
     * monthType 0获取本月，其他获取上月
     */
    private String getMonthDate(int type, int monthType) {
        String date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if (monthType == 1) {
            c.add(Calendar.MONTH, -1);
        }
        if (type == 0) {
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            date = format.format(c.getTime());
        } else if (type == 1) {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            c.set(Calendar.MILLISECOND, 999);
            date = format.format(c.getTime());
        }
        return date;
    }
}