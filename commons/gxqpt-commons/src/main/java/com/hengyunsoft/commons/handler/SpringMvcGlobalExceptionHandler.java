package com.hengyunsoft.commons.handler;

import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.exception.BaseException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringMvcGlobalExceptionHandler implements HandlerExceptionResolver{

	@Autowired(required=false)
	private ObjectMapper objectMapper ;

	private String errorUri = "error";

    /**
     * 所有的错误都使用ajax进行响应，默认为false；
     */
	private boolean allAjaxResponse = false;

    public void setAllAjaxResponse(boolean allAjaxResponse){

        this.allAjaxResponse = allAjaxResponse;
    }
	
    private final static Logger log = LoggerFactory.getLogger(SpringMvcGlobalExceptionHandler.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		log.error("Exception:", ex);
		
		boolean isAjaxRequest = allAjaxResponse || isAjaxRequest(request);
		
		return doResolveException(ex, isAjaxRequest,2);
	}

	private ModelAndView doResolveException(Throwable ex, boolean isAjaxRequest,int level) {
		
		if(level < 1) {
			return toModelAndView(ExceptionCode.SYSTEM_BUSY.getCode(), null, ExceptionCode.SYSTEM_BUSY.getMsg(),isAjaxRequest);
		}
		
		try {
			if (ex instanceof BaseException) {  //入参为 @RequestBody 时，json参数类型错误，json参数格式不对
				BaseException bizExce = (BaseException) ex;
                return toModelAndView(bizExce.getCode(), null, bizExce.getMessage(),isAjaxRequest);
            } else if (ex instanceof HttpMessageNotReadableException) {  //入参为 @RequestBody 时，json参数类型错误，json参数格式不对
                String message = ex.getMessage();
                if (message != null && !"".equals(message)) {
                    if (message.contains("Could not read document:")) {
//                        String msg = "无法正确的解析json类型的参数：" +
//                                message.substring(message.indexOf("Could not read document:") +
//                                        "Could not read document:".length(), message.indexOf(" at "));
                        String msg = "您输入的参数有误，导致系统无法正常解析，请认真检查。";
                        return toModelAndView(ExceptionCode.PARAM_EX.getCode(), null, msg,isAjaxRequest);
                    }
                }
                return toModelAndView(ExceptionCode.PARAM_EX.getCode(), null, ExceptionCode.PARAM_EX.getMsg(),isAjaxRequest);
            } else if (ex instanceof BindException){  //入参
                BindException eee = ((BindException) ex);
                StringBuilder msg = new StringBuilder();
                List<FieldError> fieldErrors = eee.getFieldErrors();
                fieldErrors.forEach((oe)->{
                    msg.append("参数对象[").append(oe.getObjectName()).append("]的字段[")
                            .append(oe.getField()).append("]的值[").append(oe.getRejectedValue()).append("]与实际类型不匹配.");

                });

                return toModelAndView(ExceptionCode.PARAM_EX.getCode(), null, msg.toString(),isAjaxRequest);
            }
            else if (ex instanceof MethodArgumentTypeMismatchException) {
                MethodArgumentTypeMismatchException eee = ((MethodArgumentTypeMismatchException) ex);
                StringBuilder msg = new StringBuilder("参数[").append(eee.getName()).append("]的值[")
                        .append(eee.getValue()).append("]与实际类型[").append(eee.getRequiredType().getName()).append("]不匹配");
                return toModelAndView(ExceptionCode.PARAM_EX.getCode(), null, msg.toString(),isAjaxRequest);
            } else if(ex instanceof IllegalStateException){ // 非法参数
                return toModelAndView(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg(),isAjaxRequest);

            } else if(ex instanceof MissingServletRequestParameterException){ // 缺少参数
                MissingServletRequestParameterException e = ((MissingServletRequestParameterException) ex);
                StringBuilder msg = new StringBuilder();
                msg.append("缺少必须的[").append(e.getParameterType()).append("] 类型的参数[").append(e.getParameterName()).append("]");
                return toModelAndView(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, msg.toString(),isAjaxRequest);
            }
            else if (ex instanceof NullPointerException) {
                return toModelAndView(ExceptionCode.NULL_POINT_EX.getCode(), null, ExceptionCode.NULL_POINT_EX.getMsg(),isAjaxRequest);
            } else if (ex instanceof IllegalArgumentException) {
                return toModelAndView(ExceptionCode.ILLEGALA_RGUMENT_EX.getCode(), null, ExceptionCode.ILLEGALA_RGUMENT_EX.getMsg(),isAjaxRequest);
            } else if (ex instanceof SQLException) {
                return toModelAndView(ExceptionCode.SQL_EX.getCode(), null, ExceptionCode.SQL_EX.getMsg(),isAjaxRequest);
            } else if (ex instanceof DataIntegrityViolationException){
                return toModelAndView(ExceptionCode.SQL_EX.getCode(), null, ExceptionCode.SQL_EX.getMsg(),isAjaxRequest);
            } else if(ex instanceof HttpMediaTypeNotSupportedException){
                HttpMediaTypeNotSupportedException e = ((HttpMediaTypeNotSupportedException) ex);
                MediaType contentType = e.getContentType();
                if(contentType != null) {
                    StringBuilder msg = new StringBuilder();
                    msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
                    return toModelAndView(ExceptionCode.MEDIA_TYPE_EX.getCode(), null, msg.toString(),isAjaxRequest);
                }
                return toModelAndView(ExceptionCode.MEDIA_TYPE_EX.getCode(), null, "无效的Content-Type类型",isAjaxRequest);
            } else if (ex instanceof ServletException){
                String msgs = "UT010016: Not a multi part request";
                if(msgs.equalsIgnoreCase(ex.getMessage())){
                    return toModelAndView(FileExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(), null, FileExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg(),isAjaxRequest);
                }
            } else if(ex instanceof MultipartException){
                return toModelAndView(FileExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(), null, FileExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg(),isAjaxRequest);
            }  else if(ex instanceof MyBatisSystemException){
            	Throwable mybaExce = ((MyBatisSystemException) ex).getRootCause();
            	return doResolveException(mybaExce, isAjaxRequest, level-1);
            } else {
            	
            	doResolveException(ex.getCause(), isAjaxRequest, level-1);
            }
        } catch (Exception e) {
            log.error("解析 Exception", e);
        }
        return toModelAndView(ExceptionCode.SYSTEM_BUSY.getCode(), null, ExceptionCode.SYSTEM_BUSY.getMsg(),isAjaxRequest);
	}
	
	
	
	
	private boolean isAjaxRequest(HttpServletRequest req) {
		
		return "application/json".equalsIgnoreCase(req.getContentType()) || "XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"));
	}

	protected ModelAndView toModelAndView(int errcode, Object data, String errmsg,boolean isAjaxRequest) {

		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setStatus(HttpStatus.OK);
		
		if(isAjaxRequest) {
			MappingJackson2JsonView view = null;
			if(objectMapper != null) {
				view = new MappingJackson2JsonView(objectMapper);
			} else {
				view = new MappingJackson2JsonView();
			}
			modelAndView.setView(view );
		} else {
			
			modelAndView.setViewName(errorUri );
		}
		Map<String, Object> model = modelAndView.getModel();
		model.put("errcode", errcode);
		model.put("data", data);
		model.put("errmsg", errmsg);
		return modelAndView;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public void setErrorUri(String errorUri) {
		this.errorUri = errorUri;
	}
}