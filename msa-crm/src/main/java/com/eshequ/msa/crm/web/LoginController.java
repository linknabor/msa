package com.eshequ.msa.crm.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.crm.model.SsoUser;
import com.eshequ.msa.crm.service.LoginRemote;
import com.eshequ.msa.util.BeanUtil;
import com.eshequ.msa.util.VerifyCodeServlet;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@RestController
public class LoginController {	
	//退出登录
	@RequestMapping(value = "/exit",method = RequestMethod.GET)
	public void exit(HttpSession httpSession,HttpServletResponse response) throws IOException {
		Object token = httpSession.getAttribute("token");//取出存在crm里的token
		response.sendRedirect("http://localhost:9091/sso/exitCenter?sysName=crm&token="+token);//去注销认证中心
	}
	
	//注销会话
	@RequestMapping(value = "/distorySession",method = RequestMethod.GET)
	public void distorySession(HttpSession httpSession,HttpServletResponse response) throws IOException {
		httpSession.removeAttribute("token");
		httpSession.removeAttribute("isLogin");
	}
	
	@RequestMapping(value = "/testFeign",method = RequestMethod.GET)
	public void saveCrmToken() {
		Gson gson = new Gson();
		Object o = new Object();
		o=1;
		SsoUser u = (SsoUser)o;

	}
	
	
}
