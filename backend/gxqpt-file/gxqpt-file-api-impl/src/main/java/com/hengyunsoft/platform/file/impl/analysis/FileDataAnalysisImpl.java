package com.hengyunsoft.platform.file.impl.analysis;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationSelectDTO;
import com.hengyunsoft.platform.file.entity.file.domain.ShareFileRateDO;
import com.hengyunsoft.platform.file.entity.file.po.FileUserSize;
import com.hengyunsoft.platform.file.repository.file.example.FileUserSizeExample;
import com.hengyunsoft.platform.file.repository.file.service.FileUserSizeService;
import com.hengyunsoft.platform.file.repository.file.service.ShareFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：文件数据分析API
 * 修改人：wt
 * 修改时间：2018/9/6
 * 修改内容：
 */
@Api(value = "API - FileDataAnalysisImpl.java", description = "文件数据分析API")
@RestController
@RequestMapping("dataapi/file/")
@Slf4j
public class FileDataAnalysisImpl {
    @Autowired
    private ShareFileService shareFileService;
    @Autowired
    private FileUserSizeService fileUserSizeService;
    @Autowired
    private ApplicationApi applicationApi;


    /**
     * 描述：文件大小发展情况分析
     * 参数：
     * 返回值：Map<String,Object>
     * 修改人：wt
     * 修改时间：2018/9/6
     * 修改内容：
     */
    @ApiOperation(value = "文件大小发展情况分析", notes = "文件大小发展情况分析")
    @RequestMapping(value = "/sizeAnalysis", method = RequestMethod.GET)
    public Result<Map<String,Object>> querySizeAnalysis(@RequestParam String startDate,@RequestParam String endDate) {
        Map<String,Object> result = new HashMap<String,Object>();
        Long userId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        String[] yearMonthArray = DateUtils.getLatest6Month();
        if(startDate != null && endDate != null && !startDate.isEmpty() && !endDate.isEmpty()){
            yearMonthArray = getYearMonthSection(startDate,endDate);
        }
        result.put("yearMonthArray",yearMonthArray);
        List<Long> allFileList = new ArrayList<Long>();
        List<Long> imageFileList = new ArrayList<Long>();
        List<Long> docFileList = new ArrayList<Long>();
        List<Long> videoFileList = new ArrayList<Long>();
        List<Long> audioFileList = new ArrayList<Long>();
        List<Long> otherFileList = new ArrayList<Long>();
        for (String yearMonth : yearMonthArray){
            FileUserSizeExample example = new FileUserSizeExample();
            example.createCriteria().andAppIdEqualTo(appId).andCreateUserEqualTo(userId).andFyearMonthEqualTo(yearMonth);
            List<FileUserSize> fileUserSizeList = fileUserSizeService.find(example);
            Long allLong = 0l,imageLong = 0l,docLong = 0l,videoLong = 0l,audioLong = 0l,otherLong = 0l;
            for (FileUserSize curr : fileUserSizeList){
                Long size = Long.parseLong(curr.getSize());
                allLong += size;
                switch (curr.getDataType()){
                    case "IMAGE":
                        imageLong += size;break;
                    case "DOC":
                        docLong += size;break;
                    case "VIDEO":
                        videoLong += size;break;
                    case "AUDIO":
                        audioLong += size;break;
                    case "OTHER":
                        otherLong += size;break;
                    default:
                        break;
                }
            }
            allFileList.add(allLong);
            imageFileList.add(imageLong);
            docFileList.add(docLong);
            videoFileList.add(videoLong);
            audioFileList.add(audioLong);
            otherFileList.add(otherLong);
        }
        result.put("allFileList",allFileList);
        result.put("imageFileList",imageFileList);
        result.put("docFileList",docFileList);
        result.put("videoFileList",videoFileList);
        result.put("audioFileList",audioFileList);
        result.put("otherFileList",otherFileList);
        return Result.success(result);
    }

    /**
     * 根据开始日期-结束日期获取区间年月数组
     * @param start 开始日期
     * @param end 结束日期
     * @return
     */
    private String[] getYearMonthSection(String start,String end){
        List<String> result = new ArrayList<String>();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(start));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(end));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        }catch (Exception ex){
            log.error("获取日期区间报错",ex);
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * 描述：文件分享占比
     * 参数：
     * 返回值：Map<String,Object>
     * 修改人：wt
     * 修改时间：2018/9/6
     * 修改内容：
     */
    @ApiOperation(value = "文件分享占比", notes = "文件分享占比")
    @RequestMapping(value = "/shareRate", method = RequestMethod.GET)
    public Result<Map<String,Object>> querySizeShareRate() {
        Map<String,Object> result = new HashMap<String,Object>();
        Long userId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        List<ShareFileRateDO> shareFileSizeY = shareFileService.findFileShareRateY(userId, appId);
        List<ShareFileRateDO> shareFileSizeN = shareFileService.findFileShareRateN(userId, appId);
        Long allDidNot = 0l,allNot = 0l;
        Long imageDidNot = 0l,imageNot = 0l;
        Long docDidNot = 0l,docNot = 0l;
        Long videoDidNot = 0l,videoNot = 0l;
        Long audioDidNot = 0l,audioNot = 0l;
        Long otherDidNot = 0l,otherNot = 0l;
        for (ShareFileRateDO didNot:shareFileSizeY){
            Long size = Long.parseLong(didNot.getSize());
            allDidNot += size;
            switch (didNot.getDataType()){
                case "IMAGE":
                    imageDidNot += size;break;
                case "DOC":
                    docDidNot += size;break;
                case "VIDEO":
                    videoDidNot += size;break;
                case "AUDIO":
                    audioDidNot += size;break;
                case "OTHER":
                    otherDidNot += size;break;
                default:
                    break;
            }
        }
        for (ShareFileRateDO not:shareFileSizeN){
            Long size = Long.parseLong(not.getSize());
            allNot += size;
            switch (not.getDataType()){
                case "IMAGE":
                    imageNot += size;break;
                case "DOC":
                    docNot += size;break;
                case "VIDEO":
                    videoNot += size;break;
                case "AUDIO":
                    audioNot += size;break;
                case "OTHER":
                    otherNot += size;break;
                default:
                    break;
            }
        }

        Map<String,Object> allMap = new HashMap<String,Object>();
        allMap.put("allDidNot",allDidNot);
        allMap.put("allNot",allNot);
        result.put("allShare",allMap);
        Map<String,Object> imageMap = new HashMap<String,Object>();
        imageMap.put("imageDidNot",imageDidNot);
        imageMap.put("imageNot",imageNot);
        result.put("imageShare",imageMap);
        Map<String,Object> docMap = new HashMap<String,Object>();
        docMap.put("docDidNot",docDidNot);
        docMap.put("docNot",docNot);
        result.put("docShare",docMap);
        Map<String,Object> videoMap = new HashMap<String,Object>();
        videoMap.put("videoDidNot",videoDidNot);
        videoMap.put("videoNot",videoNot);
        result.put("videoShare",videoMap);
        Map<String,Object> audioMap = new HashMap<String,Object>();
        audioMap.put("audioDidNot",audioDidNot);
        audioMap.put("audioNot",audioNot);
        result.put("audioShare",audioMap);
        Map<String,Object> otherMap = new HashMap<String,Object>();
        otherMap.put("otherDidNot",otherDidNot);
        otherMap.put("otherNot",otherNot);
        result.put("otherShare",otherMap);
        return Result.success(result);
    }

    /**
     * 描述：磁盘空间分析
     * 参数：
     * 返回值：Map<String,Object>
     * 修改人：wt
     * 修改时间：2018/9/7
     * 修改内容：
     */
    @ApiOperation(value = "磁盘空间分析", notes = "磁盘空间分析")
    @RequestMapping(value = "/diskspace", method = RequestMethod.GET)
    public Result<Map<String,Object>> queryDiskSpace() {
        Map<String,Object> result = new HashMap<String,Object>();
        Long userId = BaseContextHandler.getAdminId();
        FileUserSizeExample example = new FileUserSizeExample();
        example.createCriteria().andIdIsNotNull();
        List<FileUserSize> fileUserSizeList = fileUserSizeService.find(example);
        Long imageAll = 0l,docAll = 0l,videoAll = 0l,audioAll =0l,otherAll = 0l;
        Long userCount = 0l,imgageUser = 0l,docUser = 0l,videoUser = 0l,audioUser = 0l,otherUser = 0l;
        for (FileUserSize fileUserSize : fileUserSizeList){
            Long size = Long.parseLong(fileUserSize.getSize());
            switch (fileUserSize.getDataType()){
                case "IMAGE":
                    imageAll += size;
                    if(userId.equals(fileUserSize.getCreateUser())){
                        imgageUser += size;
                        userCount += size;
                    }
                    break;
                case "DOC":
                    docAll += size;
                    if(userId.equals(fileUserSize.getCreateUser())){
                        docUser += size;
                        userCount += size;
                    }
                    break;
                case "VIDEO":
                    videoAll += size;
                    if(userId.equals(fileUserSize.getCreateUser())){
                        videoUser += size;
                        userCount += size;
                    }
                    break;
                case "AUDIO":
                    audioAll += size;
                    if(userId.equals(fileUserSize.getCreateUser())){
                        audioUser += size;
                        userCount += size;
                    }
                    break;
                case "OTHER":
                    otherAll += size;
                    if(userId.equals(fileUserSize.getCreateUser())){
                        otherUser += size;
                        userCount += size;
                    }
                    break;
                default:
                    break;
            }
        }
        result.put("userAllCount",getPrintSize(userCount));
        Map<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("image",getPrintSize(imgageUser));
        userMap.put("doc",getPrintSize(docUser));
        userMap.put("video",getPrintSize(videoUser));
        userMap.put("audio",getPrintSize(audioUser));
        userMap.put("other",getPrintSize(otherUser));
        result.put("userDiskSpace",userMap);
        Map<String,Object> allMap = new HashMap<String,Object>();
        allMap.put("image",getPrintSize(imageAll));
        allMap.put("doc",getPrintSize(docAll));
        allMap.put("video",getPrintSize(videoAll));
        allMap.put("audio",getPrintSize(audioAll));
        allMap.put("other",getPrintSize(otherAll));
        result.put("allDiskSapce",allMap);
        return Result.success(result);
    }

    /**
     * 描述：多系统文件分析
     * 参数：
     * 返回值：Map<String,Object>
     * 修改人：wt
     * 修改时间：2018/9/7
     * 修改内容：
     */
    @ApiOperation(value = "多系统文件分析", notes = "多系统文件分析")
    @RequestMapping(value = "/systemAnalysis", method = RequestMethod.GET)
    public Result<Map<String,Object>> querySystemAnalysis() {
        Map<String,Object> result = new HashMap<String,Object>();
        Long userId = BaseContextHandler.getAdminId();
        List<ApplicationSelectDTO> jryyList = applicationApi.findAppTypeAll("jryy").getData();
        Map<String,Object> jryyMap = getSystemSizeData(jryyList,userId);
        List<ApplicationSelectDTO> zcptList = applicationApi.findAppTypeAll("zcpt").getData();
        Map<String,Object> zcptMap = getSystemSizeData(zcptList,userId);
        List<ApplicationSelectDTO> zcyyList = applicationApi.findAppTypeAll("zcyy").getData();
        Map<String,Object> zcyyMap = getSystemSizeData(zcyyList,userId);
        result.put("jryy",jryyMap);
        result.put("zcpt",zcptMap);
        result.put("zcyy",zcyyMap);
        return Result.success(result);
    }

    private Map<String,Object> getSystemSizeData(List<ApplicationSelectDTO> list,Long userId){
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> systemList = new ArrayList<String>();
        List<String> sizeList = new ArrayList<String>();
        for (ApplicationSelectDTO dto : list){
            systemList.add(dto.getName());
            FileUserSizeExample example = new FileUserSizeExample();
            example.createCriteria().andAppIdEqualTo(dto.getAppId());
            List<FileUserSize> fileUserSizeList = fileUserSizeService.find(example);
            Long sizeCount = 0l;
            for (FileUserSize fileUserSize:fileUserSizeList){
                Long size = Long.parseLong(fileUserSize.getSize());
                sizeCount += size;
            }
            sizeList.add(sizeCount.toString());
        }
        map.put("system",systemList);
        map.put("size",sizeList);
        return map;
    }



    /**
     * 计算字节数
     * @param size
     * @return
     */
    public static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "-B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "-KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "-MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "-GB";
        }
    }
}
