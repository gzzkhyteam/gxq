package com.hengyunsoft.platform.file.impl.analysis;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.dto.*;
import com.hengyunsoft.platform.file.entity.file.domain.FileDownLoadDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileUpDO;
import com.hengyunsoft.platform.file.entity.file.domain.QueryFileShareDO;
import com.hengyunsoft.platform.file.repository.file.dao.FileDownloadWaterMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileStatisMapper;
import com.hengyunsoft.platform.file.repository.file.dao.ShareMapper;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zjr
 * @createTime 2018-09-06
 */
@RestController
@Slf4j
@RequestMapping("/fileDU")
@Api(value = "文件下载上传统计", description = "文件下载上传统计")
public class FileDownUpApiImpl {

    @Autowired
    private FileStatisMapper fileStatisMapper;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private FileDownloadWaterMapper fileDownloadWaterMapper;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 常用文件排名
     * @return
     */
    @ApiOperation(value = "常用文件排名", notes = "常用文件排名")
    @RequestMapping(value = "/findDown", method = RequestMethod.POST)
    public Result<List<FileDownDTO>> findDown (){
        //查询
        List<FileDownLoadDO> downList = fileStatisMapper.findDown(BaseContextHandler.getAdminId());
        //转换
        List<FileDownDTO> list = dozerUtils.mapList(downList,FileDownDTO.class);
        //赋值
        for (int i=0;i<list.size();i++){
            list.get(i).setUserName(BaseContextHandler.getName());
        }
        return Result.success(list);
    }

    /**
     * 近半年个人分享情况
     * @param queryFileShareDto
     * @return
     */
    @ApiOperation(value = "近半年个人分享情况", notes = "近半年个人分享情况")
    @RequestMapping(value = "/getFileShare", method = RequestMethod.POST)
    public Result<List<FileShareDTO>> getFileShare (@RequestBody QueryFileShareDTO queryFileShareDto){
        QueryFileShareDO queryFileShareDo = new QueryFileShareDO();
        //如果所传参数为空
        if (queryFileShareDto == null||queryFileShareDto.getCreateTimeEnd() == null||queryFileShareDto.getCreateTimeEnd() == ""
                ||queryFileShareDto.getCreateTimeStart() == null||queryFileShareDto.getCreateTimeStart() == ""
                ||(queryFileShareDto.getCreateTimeEnd() == null&&queryFileShareDto.getCreateTimeStart() == null)
                ||(queryFileShareDto.getCreateTimeEnd() == ""&&queryFileShareDto.getCreateTimeStart() == "")){
            List<FileShareDO> shareList1 = shareMapper.findShareN(BaseContextHandler.getAdminId());
            //转换
            List<FileShareDTO> list1 = dozerUtils.mapList(shareList1,FileShareDTO.class);
            return Result.success(list1);
        }else {//如果所传参数不为空
            queryFileShareDo.setUserId(BaseContextHandler.getAdminId());
            queryFileShareDo.setCreateTimeEnd(queryFileShareDto.getCreateTimeEnd());
            queryFileShareDo.setCreateTimeStart(queryFileShareDto.getCreateTimeStart());
            List<FileShareDO> shareList = shareMapper.findShare(queryFileShareDo);
            //转换
            List<FileShareDTO> list = dozerUtils.mapList(shareList,FileShareDTO.class);
            return Result.success(list);
        }
    }

    /**
     * 近30天个人上传文件大小情况
     * @return
     */
    @ApiOperation(value = "近30天个人上传文件大小情况", notes = "近30天个人上传文件大小情况")
    @RequestMapping(value = "/getFileUp", method = RequestMethod.POST)
    public Result<List<FileUpDTO>> getFileUp(){
        //查询
        List<FileUpDO> upList = fileMapper.fileUp(BaseContextHandler.getAdminId());
        //转换
        List<FileUpDTO> list = dozerUtils.mapList(upList,FileUpDTO.class);
        return Result.success(list);
    }

    /**
     * 近30天个人下载文件大小情况
     * @return
     */
    @ApiOperation(value = "近30天个人下载文件大小情况", notes = "近30天个人下载文件大小情况")
    @RequestMapping(value = "/getFileDown", method = RequestMethod.POST)
    public Result<List<FileUpDTO>> getFileDown(){
        //查询
        List<FileUpDO> downList = fileDownloadWaterMapper.fileDown(BaseContextHandler.getAdminId());
        //转换
        List<FileUpDTO> list = dozerUtils.mapList(downList,FileUpDTO.class);
        return Result.success(list);
    }
}
