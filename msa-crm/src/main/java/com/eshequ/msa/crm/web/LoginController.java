package com.eshequ.msa.crm.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.crm.entity.SsoUser;
import com.eshequ.msa.crm.service.LoginService;

@RestController
public class LoginController {
	@Autowired 
	private LoginService loginService;

	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 结果集
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public Map<String,String> login(HttpServletRequest request,HttpServletResponse response,String userName,String password) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		Map<String,String> result  = new HashMap<String,String>();
		result = loginService.login(userName, password);
		if(result.get("result")=="00") {
			SsoUser user = loginService.selectUserByUserName(userName);//查询当前登录用户信息
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*60*2);//单位是秒
			session.setAttribute("loginUser", user);//存储session
			cook(request,response);
		}
		return result;
	}
	
	/**
	 * 获得session的登录用户
	 * @param request
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/getLoginUserSession",method = RequestMethod.GET)
	public Map<String,String> login(HttpServletRequest request,HttpSession httpSession) {
		Map<String,String> result  = new HashMap<String,String>();
		if(httpSession != null) {
			result.put("loginUser", httpSession.getAttribute("loginUser").toString());
		}
		return result;
	}
	
	public void cook(HttpServletRequest request,HttpServletResponse response) {
		Cookie c = new Cookie("cookie1", "hello#cookie");//创建cookie
//		c.setPath(request.getContextPath()+"/");//设置cookie路径
		//设置cookie保存的时间 单位：秒
    	c.setMaxAge(7*24*60*60);
    	//将cookie添加到响应
    	response.addCookie(c);
		
	}
	
	@RequestMapping(value = "/getCookie",method = RequestMethod.GET)
	public Map<String,String> getCookie(HttpServletRequest request,HttpServletResponse response) {
		Map<String,String> result  = new HashMap<String,String>();
		Cookie[] c = request.getCookies();
		for (Cookie cookie : c) {
			if(cookie.getName().equals("cookie1")) {
				System.out.println(cookie.getValue());
			}
		}
		return result;
	}
	
	
}
