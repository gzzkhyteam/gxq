package com.hengyunsoft.platform.file.config;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/06/04
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.exception.BizException;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.tasks.UnsupportedFormatException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice(value = {
        "com.hengyunsoft.platform.file.open",
})
@ResponseBody  //返回结果为json
@Slf4j
public class FileExceptionHandler {


    @ExceptionHandler(UnsupportedFormatException.class)
    public Result imageExceptionHandler(UnsupportedFormatException ex) {
        log.error("UnsupportedFormatException:", ex);
        return new Result(FileExceptionCode.IMAGE_DATA_TYPE_ERROR.getCode(), null, FileExceptionCode.IMAGE_DATA_TYPE_ERROR.getMsg());
    }

//    @ExceptionHandler(Exception.class)
//    public Result handleException(Exception ex,HttpServletRequest request) {
//        if(ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException){
//            request.setAttribute("error", "文件超过长度");
//
//            return Result.fail("文件超过长度");
//        }
//
//       if( ex instanceof MultipartException){
//            return Result.fail("文件过大");
//       }
//        return Result.fail("aaa");
//    }
    /**
     * 异常处理
     * @param ex
     * @param request
     * @Description:
     */
//    @ExceptionHandler(Exception.class)
//    public void handleException(Exception ex,HttpServletRequest request,HttpServletResponse response){
//        StringBuffer sb = new StringBuffer();
//        sb.append("<script language='javascript'>history.go(-1);alert('");
//        if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException){
//            sb.append("文件大小不应大于"+((MaxUploadSizeExceededException)ex).getMaxUploadSize()/1000+"kb");
//        } else{
//            sb.append("上传异常！");
//        }
//        sb.append("！');</script>");
//        try {
//            System.out.println(sb.toString());
//            response.setContentType("text/html; charset=utf-8");
//            response.getWriter().println(sb.toString());
//            response.getWriter().flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return;
//    }
}
