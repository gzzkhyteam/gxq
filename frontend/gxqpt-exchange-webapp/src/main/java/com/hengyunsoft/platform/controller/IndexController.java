package com.hengyunsoft.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping
public class IndexController {

	@Value("${gxqpt.variable.gate-url}${server.context-path:}")
	String contextPath;

	@RequestMapping
	public void main(HttpServletResponse response) throws IOException {
		response.sendRedirect(contextPath + "/module/index");
	}

	@RequestMapping("index")
	public void index(HttpServletResponse response) throws IOException {
		response.sendRedirect(contextPath + "/module/index");
	}

	@PostMapping("refreshToken")
	@ResponseBody
    public String token(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return loginController.setUserTokenToCookie(request, response);
    }
	@Autowired
	private LoginController loginController;
}
