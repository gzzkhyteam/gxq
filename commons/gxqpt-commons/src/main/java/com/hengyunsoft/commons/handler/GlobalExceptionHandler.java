package com.hengyunsoft.commons.handler;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.exception.BaseException;
import com.hengyunsoft.exception.BizException;

import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import java.sql.DataTruncation;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

/**
 * @author tyh
 * @createTime 2017-12-13 17:04
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody  //返回结果为json
public class GlobalExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    public Result baseExceptionHandler(BizException ex) {
        log.error("BizException:", ex);
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result otherExceptionHandler(Exception ex) {
        log.error("Exception:", ex);
        return doResolveException(ex,3);

    }

    private Result doResolveException(Throwable ex,  int level) {

        if(level < 1) {
            return toResult(ExceptionCode.SYSTEM_BUSY.getCode(),  ExceptionCode.SYSTEM_BUSY.getMsg());
        }

        try {
            if (ex instanceof BaseException) {  //入参为 @RequestBody 时，json参数类型错误，json参数格式不对
                BaseException bizExce = (BaseException) ex;
                return toResult(bizExce.getCode(),  bizExce.getMessage());
            } else if (ex instanceof HttpMessageNotReadableException) {  //入参为 @RequestBody 时，json参数类型错误，json参数格式不对
                String message = ex.getMessage();
                if (message != null && !"".equals(message)) {
                    if (message.contains("Could not read document:")) {
//                        String msg = "无法正确的解析json类型的参数：" +
//                                message.substring(message.indexOf("Could not read document:") +
//                                        "Could not read document:".length(), message.indexOf(" at "));
                        String msg = "您输入的参数有误，导致系统无法正常解析，请认真检查。";
                        return toResult(ExceptionCode.PARAM_EX.getCode(),  msg);
                    }
                }
                return toResult(ExceptionCode.PARAM_EX.getCode(),  ExceptionCode.PARAM_EX.getMsg());
            } else if (ex instanceof BindException){  //入参
                BindException eee = ((BindException) ex);
                StringBuilder msg = new StringBuilder();
                List<FieldError> fieldErrors = eee.getFieldErrors();
                fieldErrors.forEach((oe)->{
                    msg.append("参数对象[").append(oe.getObjectName()).append("]的字段[")
                            .append(oe.getField()).append("]的值[").append(oe.getRejectedValue()).append("]与实际类型不匹配.");

                });

                return toResult(ExceptionCode.PARAM_EX.getCode(),  msg.toString());
            }
            else if (ex instanceof MethodArgumentTypeMismatchException) {
                MethodArgumentTypeMismatchException eee = ((MethodArgumentTypeMismatchException) ex);
                StringBuilder msg = new StringBuilder("参数[").append(eee.getName()).append("]的值[")
                        .append(eee.getValue()).append("]与实际类型[").append(eee.getRequiredType().getName()).append("]不匹配");
                return toResult(ExceptionCode.PARAM_EX.getCode(),  msg.toString());
            } else if(ex instanceof IllegalStateException){ // 非法参数
                return toResult(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(),  ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg());

            } else if(ex instanceof MissingServletRequestParameterException){ // 缺少参数
                MissingServletRequestParameterException e = ((MissingServletRequestParameterException) ex);
                StringBuilder msg = new StringBuilder();
                msg.append("缺少必须的[").append(e.getParameterType()).append("] 类型的参数[").append(e.getParameterName()).append("]");
                return toResult(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(),  msg.toString());
            }
            else if (ex instanceof NullPointerException) {
                return toResult(ExceptionCode.NULL_POINT_EX.getCode(),  ExceptionCode.NULL_POINT_EX.getMsg());
            } else if (ex instanceof IllegalArgumentException) {
                return toResult(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(),  ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg());
            } else if (ex instanceof DataTruncation){
                return toResult(ExceptionCode.SQL_EX.getCode(),  "数据长度太长");
            } else if (ex instanceof SQLException) {
                return toResult(ExceptionCode.SQL_EX.getCode(),  ExceptionCode.SQL_EX.getMsg());
            } else if(ex instanceof HttpMediaTypeNotSupportedException){
                HttpMediaTypeNotSupportedException e = ((HttpMediaTypeNotSupportedException) ex);
                MediaType contentType = e.getContentType();
                if(contentType != null) {
                    StringBuilder msg = new StringBuilder();
                    msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
                    return toResult(ExceptionCode.MEDIA_TYPE_EX.getCode(),  msg.toString());
                }
                return toResult(ExceptionCode.MEDIA_TYPE_EX.getCode(),  "无效的Content-Type类型");
            } else if (ex instanceof ServletException){
                String msgs = "UT010016: Not a multi part request";
                if(msgs.equalsIgnoreCase(ex.getMessage())){
                    return toResult(FileExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(),  FileExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg());
                }
            } else if(ex instanceof MultipartException){
                return toResult(FileExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(),  FileExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg());
            }  else if(ex instanceof MyBatisSystemException){
                Throwable mybaExce = ((MyBatisSystemException) ex).getRootCause();
                return doResolveException(mybaExce, level-1);
            } else {
            	Throwable cause = ex.getCause();
            	if(cause != null) {
            		return doResolveException(cause, level-1);
                } else {
                	return toResult(ExceptionCode.SYSTEM_BUSY.getCode(),  ExceptionCode.SYSTEM_BUSY.getMsg());
                }
            }
        } catch (Exception e) {
            log.error("解析 Exception", e);
        }
        return toResult(ExceptionCode.SYSTEM_BUSY.getCode(),  ExceptionCode.SYSTEM_BUSY.getMsg());
    }

    public Result toResult(int code,String errMsg){

        return new Result(code,null,errMsg);
    }


}