package com.hengyunsoft.platform.file.impl.analysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.dto.FileDataTypeDevViewDTO;
import com.hengyunsoft.platform.file.dto.FileDataViewDTO;
import com.hengyunsoft.platform.file.dto.FileDevDataTypeNum;
import com.hengyunsoft.platform.file.dto.FileDevViewDTO;
import com.hengyunsoft.platform.file.dto.FileShareViewDTO;
import com.hengyunsoft.platform.file.dto.FileTypeViewDTO;
import com.hengyunsoft.platform.file.entity.file.domain.DateTypeNumDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileDataTypeDevViewDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileDevViewDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareNumDO;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.repository.file.service.FileUserNumService;
import com.hengyunsoft.platform.file.repository.file.service.ShareService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author madengbo
 * @create 2018-09-06 08:51
 * @desc
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("file")
@Api(value = "云盘首页", description = "云盘首页数据概览")
public class FileDataApiImpl /*implements FileDataApi*/ {

    @Autowired
    private FileService  fileService;

    @Autowired
    private ShareService shareService;

    @Autowired
    private FileUserNumService fileUserNumService ;

    @Autowired
    private DozerUtils dozerUtils;

    
    @ApiOperation(value = "云盘首页数据概览", notes = "云盘首页数据概览")
    @RequestMapping(value = "/getMyFileDataView", method = RequestMethod.GET)
    public Result<FileDataViewDTO> getMyFileDataView() {
        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        //全部文件数量
        int fileNum = 0;
        //全部文件大小
        long fileSize = 0;

        FileDataViewDTO fileDataViewDTO = new FileDataViewDTO() ;

        List<DateTypeNumDO> dateTypeNumDOS = fileService.findByUserIdDataTypeNum(userId,appId);
        if(dateTypeNumDOS != null && dateTypeNumDOS.size()>0){
            for(DateTypeNumDO dtn:dateTypeNumDOS ){

                fileNum += Integer.parseInt(dtn.getNum());
                fileSize += dtn.getSize();

                if("DOC".equalsIgnoreCase(dtn.getDataType())){
                    fileDataViewDTO.setDocNum(Integer.parseInt(dtn.getNum()));
                }else if("AUDIO".equalsIgnoreCase(dtn.getDataType())){
                    fileDataViewDTO.setAudioNum(Integer.parseInt(dtn.getNum()));
                }else if("IMAGE".equalsIgnoreCase(dtn.getDataType())){
                    fileDataViewDTO.setImgNum(Integer.parseInt(dtn.getNum()));
                }else if("VIDEO".equalsIgnoreCase(dtn.getDataType())){
                    fileDataViewDTO.setVideoNum(Integer.parseInt(dtn.getNum()));
                }else if("OTHER".equalsIgnoreCase(dtn.getDataType())){
                    fileDataViewDTO.setOtherNum(Integer.parseInt(dtn.getNum()));
                }
            }
        }
        //全部文件数量
        fileDataViewDTO.setFileNum(fileNum);
        //全部文件大小
        fileDataViewDTO.setFileSize(getPrintSize(fileSize));

        //个人分享次数
        ShareExample shareExample = new ShareExample() ;
        shareExample.createCriteria().andAdminIdEqualTo(userId);
        int myShareNum = shareService.count(shareExample);
        fileDataViewDTO.setMyShareNum(myShareNum);

        return Result.success(fileDataViewDTO);
    }

    
    @ApiOperation(value = "文件类型情况", notes = "文件类型情况(大小)")
    @RequestMapping(value = "/getMyFileTypeView", method = RequestMethod.GET)
    public Result<FileTypeViewDTO> getMyFileTypeView() {
        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        FileTypeViewDTO fileTypeViewDTO = new FileTypeViewDTO();
        List<DateTypeNumDO> dateTypeNumDOS = fileService.findByUserIdDataTypeNum(userId, appId);
        if(dateTypeNumDOS != null && dateTypeNumDOS.size()>0){
            for(DateTypeNumDO dtn:dateTypeNumDOS ){
                if("DOC".equalsIgnoreCase(dtn.getDataType())){
                    fileTypeViewDTO.setDocSize(getPrintSize(dtn.getSize()));
                }else if("AUDIO".equalsIgnoreCase(dtn.getDataType())){
                    fileTypeViewDTO.setAudioSize(getPrintSize(dtn.getSize()));
                }else if("IMAGE".equalsIgnoreCase(dtn.getDataType())){
                    fileTypeViewDTO.setImgSize(getPrintSize(dtn.getSize()));
                }else if("VIDEO".equalsIgnoreCase(dtn.getDataType())){
                    fileTypeViewDTO.setVideoSize(getPrintSize(dtn.getSize()));
                }else if("OTHER".equalsIgnoreCase(dtn.getDataType())){
                    fileTypeViewDTO.setOtherSize(getPrintSize(dtn.getSize()));
                }
            }
        }

        return Result.success(fileTypeViewDTO);
    }

    
    @ApiOperation(value = "文件分享数量分析", notes = "文件分享数量分析")
    @RequestMapping(value = "/getFileShareData", method = RequestMethod.GET)
    public Result<FileShareViewDTO> getFileShareData() {

        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        FileShareViewDTO fileShareViewDTO = new FileShareViewDTO() ;
        List<FileShareNumDO> fileShareNumDOs = shareService.getMyShare(userId, appId);
        Integer shareNum=0;
        if(fileShareNumDOs != null && fileShareNumDOs.size()>0){
            for(FileShareNumDO dtn:fileShareNumDOs ){
                shareNum += dtn.getNum();
                if("DOC".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setShareDocNum(dtn.getNum());
                }else if("AUDIO".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setShareAudioNum(dtn.getNum());
                }else if("IMAGE".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setShareImgNum(dtn.getNum());
                }else if("VIDEO".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setShareVideoNum(dtn.getNum());
                }else if("OTHER".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setShareOthNum(dtn.getNum());
                }
            }
        }
        //总分享数
        fileShareViewDTO.setShareNum(shareNum);

        //全部文件数量
        int allNum = 0;
        //个人各类文件总数量
        List<DateTypeNumDO> dateTypeNumDOS = fileService.findByUserIdDataTypeNum(userId, appId);
        if(dateTypeNumDOS != null && dateTypeNumDOS.size()>0){
            for(DateTypeNumDO dtn:dateTypeNumDOS ){
                allNum += Integer.parseInt(dtn.getNum());
                if("DOC".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setDocNum(Integer.parseInt(dtn.getNum()));
                }else if("AUDIO".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setAudioNum(Integer.parseInt(dtn.getNum()));
                }else if("IMAGE".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setImgNum(Integer.parseInt(dtn.getNum()));
                }else if("VIDEO".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setVideoNum(Integer.parseInt(dtn.getNum()));
                }else if("OTHER".equalsIgnoreCase(dtn.getDataType())){
                    fileShareViewDTO.setOthNum(Integer.parseInt(dtn.getNum()));
                }
            }
        }

        //总分享数
        fileShareViewDTO.setAllNum(allNum);

        return Result.success(fileShareViewDTO);
    }

    
    @ApiOperation(value = "全部文件发展情况（统计数量）", notes = "全部文件发展情况（统计数量）")
    @RequestMapping(value = "/getFileDev", method = RequestMethod.GET)
    public Result<List<FileDevViewDTO>> getFileDev(@RequestParam(value = "startTime", required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime) {

        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        //默认获取进六个月的数据 yyyy-mm
        List<String> rqList = null;
        try {
            rqList = getYearMonth(startTime, endTime);
        } catch (ParseException e) {
            log.info("时间转换出错",e);
            e.printStackTrace();
            return Result.fail(e);
        }

        List<FileDevViewDTO> fileDevViewDTOS = new ArrayList<>();

        for(String yearMonth: rqList){

             FileDevViewDO fileDevViewDO  = fileUserNumService.getYearMonthNum(userId, yearMonth, appId);
             if(fileDevViewDO == null){
                 fileDevViewDO = new FileDevViewDO();
                 fileDevViewDO.setFYearMonth(yearMonth);
                 fileDevViewDO.setNum(0);
             }
             fileDevViewDTOS.add(dozerUtils.map(fileDevViewDO, FileDevViewDTO.class));

         }
        return Result.success(fileDevViewDTOS);
    }

    
    @ApiOperation(value = "个人各种类型文件发展状况分析（统计数量）", notes = "个人各种类型文件近六月发展状况分析（统计数量）(默认近六个月)")
    @RequestMapping(value = "/getFileDataTypeDev", method = RequestMethod.GET)
    public Result<List<FileDataTypeDevViewDTO>> getFileDataTypeDev(@RequestParam(value = "startTime",required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime) {
        //获得必要信息
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();

        //默认获取进六个月的数据 yyyy-mm
        List<String> rqList = null;
        try {
            rqList = getYearMonth(startTime, endTime);
        } catch (ParseException e) {
            log.info("时间转换出错",e);
            e.printStackTrace();
            return Result.fail("系统出错，联系管理员");
        }

        List<FileDataTypeDevViewDTO> fileDataTypeDevViewDTOS = new ArrayList<>();

        for(String yearMonth: rqList){

            FileDataTypeDevViewDTO fileDataTypeDevViewDTO = new FileDataTypeDevViewDTO();
            FileDevDataTypeNum fileDevDataTypeNum = new FileDevDataTypeNum();

            List<FileDataTypeDevViewDO> fileDataTypeDevViewDOS  = fileUserNumService.getFileDataType(userId, yearMonth, appId);

            if(fileDataTypeDevViewDOS != null && fileDataTypeDevViewDOS.size()>0){
                for(FileDataTypeDevViewDO dtn:fileDataTypeDevViewDOS ){
                    if("DOC".equalsIgnoreCase(dtn.getDataType())){
                        fileDevDataTypeNum.setDocNum(dtn.getNum());
                    }else if("AUDIO".equalsIgnoreCase(dtn.getDataType())){
                        fileDevDataTypeNum.setAudioNum(dtn.getNum());
                    }else if("IMAGE".equalsIgnoreCase(dtn.getDataType())){
                        fileDevDataTypeNum.setImgNum(dtn.getNum());
                    }else if("VIDEO".equalsIgnoreCase(dtn.getDataType())){
                        fileDevDataTypeNum.setVideoNum((dtn.getNum()));
                    }else if("OTHER".equalsIgnoreCase(dtn.getDataType())){
                        fileDevDataTypeNum.setOtherNum(dtn.getNum());
                    }
                }

            }
            fileDataTypeDevViewDTO.setFYearMonth(yearMonth);
            fileDataTypeDevViewDTO.setFileDevDataTypeNum(fileDevDataTypeNum);
            fileDataTypeDevViewDTOS.add(fileDataTypeDevViewDTO);
        }
        return Result.success(fileDataTypeDevViewDTOS);
    }

    /**
     * 默认获取最新的近六个月数据 yyyy-mm
     * 如果传入时间参数：返回 时间参数间的 yyyy-mm List
     * *@param startTime 开始日期
     *  @param endTime 结束日期
     * */
    private List<String> getYearMonth(String startTime, String endTime) throws ParseException {

        String dateString;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> rqList = new ArrayList<>();
        /**
         * tip:如果startTime 或是 endTime 不传或是为空 返回近六个月的年月
         * */
        if(startTime != null && !startTime.isEmpty() && endTime != null && !endTime.isEmpty()){
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(startTime));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(endTime));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                rqList.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }

        }else {
            //默认近六个月的数据
            for (int i = 0; i < 6; i++) {
                dateString = sdf.format(cal.getTime());
                String yearMonth = dateString.substring(0, 7);
                rqList.add(yearMonth);
                cal.add(Calendar.MONTH, -1);
            }
            // 倒序
            Collections.reverse(rqList);
        }
        return rqList;
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
