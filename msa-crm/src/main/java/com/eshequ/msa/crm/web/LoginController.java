package com.eshequ.msa.crm.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {	
	//退出登录
	@RequestMapping(value = "/exit",method = RequestMethod.GET)
	public void exit(HttpSession httpSession,HttpServletResponse response) throws IOException {
		Object token = httpSession.getAttribute("token");//取出存在crm里的token
		
		//返回前端，退出登录页面的过渡页，从页面中访问sso注销中心
		response.sendRedirect("http://localhost:9091/crm/exit.html?sysName=crm&token="+token);//去注销认证中心
	}
	
	//注销会话
	@RequestMapping(value = "/distorySession",method = RequestMethod.GET)
	public void distorySession(HttpSession httpSession,HttpServletResponse response) throws IOException {
		httpSession.removeAttribute("token");
		httpSession.removeAttribute("isLogin");
	}
	
	@RequestMapping(value = "/testFeign",method = RequestMethod.POST)
	public String saveCrmToken(String name,HttpSession httpSession) {
		String s = "sdkgjskaldjgkladshlasj";
		System.out.println(s);
		return s;
	}
	
	@RequestMapping(value = "/cancellation",method = RequestMethod.POST)
	public String cancellation() {
			String s = "aaaaaaaaa";
			System.out.println(s);

		
		return "";
	}
	
	
	
}
