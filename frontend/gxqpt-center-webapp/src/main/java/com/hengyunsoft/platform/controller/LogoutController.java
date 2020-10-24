package com.hengyunsoft.platform.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.platform.security.CasFilterExt;

@Controller
@RequestMapping("logout")
public class LogoutController {

	@Autowired
	private CasFilterExt casFilter;
	
	@RequestMapping("")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {

		casFilter.casLogout(request, response);
	}
}