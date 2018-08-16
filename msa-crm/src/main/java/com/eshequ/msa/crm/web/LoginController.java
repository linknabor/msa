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

import com.eshequ.msa.crm.config.RedisConfig;
import com.eshequ.msa.crm.entity.SsoRole;
import com.eshequ.msa.crm.entity.SsoUser;
import com.eshequ.msa.crm.service.LoginRemote;
import com.eshequ.msa.crm.service.LoginService;
import com.eshequ.msa.util.BeanUtil;
import com.eshequ.msa.util.VerifyCodeServlet;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@RestController
public class LoginController {
	@Autowired 
	private LoginService loginService;
	@Autowired
	private BeanUtil beanUtil;
	

	
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
			//用户信息 存储session
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		return result;
	}
	
	public void aa() {
		
		
		
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
		if(httpSession.getAttribute("loginUser") != null) {
			result.put("loginUser", httpSession.getAttribute("loginUser").toString());
		}else {
			result.put("loginUser", "00");
		}
		return result;
	}
	
	/**
	 * 存储登录信息cookie
	 * @param request
	 * @param response
	 */
	public void cook(HttpServletRequest request,HttpServletResponse response) {
		Cookie c = new Cookie("cookie1", "hello#cookie");//创建cookie
//		c.setPath(request.getContextPath()+"/");//设置cookie路径
		//设置cookie保存的时间 单位：秒
    	c.setMaxAge(7*24*60*60);
    	//将cookie添加到响应
    	response.addCookie(c);
		
	}
	
	/**
	 * 获得登录信息的cookie
	 * @param request
	 * @param response
	 * @return
	 */
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
	/**
	 * 获得登录信息的redis
	 * @return
	 */
	@RequestMapping(value = "/getLoginUserRedis",method = RequestMethod.GET)
	public Map<String,String> getLoginUserRedis() {
		RedisTemplate<String, String> redisTemplate =  (RedisTemplate<String, String>)BeanUtil.getBean("redisTemplate");
		Map<String,String> result  = new HashMap<String,String>();
		Gson gson = new Gson();
		String loginRedis = redisTemplate.opsForValue().get("loginUserRedis");
		if(loginRedis!=null) {
			SsoUser user = gson.fromJson(loginRedis, SsoUser.class);
			System.out.println(user.getUserName());
		}
		return result;
	}
	
	
	//获取验证码
	@RequestMapping(value = "/getCode",method = RequestMethod.GET)
	public void getCode(HttpServletRequest res,HttpServletResponse req) {
		VerifyCodeServlet v = new VerifyCodeServlet();
		try {
			v.service(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/testconnect",method = RequestMethod.POST)
	public String testconnect(String a) {
		return a;
	} 
	
	//crm 验证是否登录
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public void index(HttpSession session, String token,String sessionId) {
		RedisTemplate<String, String> redisTemplate =  (RedisTemplate<String, String>)beanUtil.getBean("redisTemplate");
		String redisToken = redisTemplate.opsForValue().get(sessionId);
		//reids中的token和传回来的token作对比
		if(token.equals(redisToken)) {
			session.setAttribute("token", token);//crm 保存token
			session.setAttribute("isLogin", "true");
			System.out.println("登录成功");
			return;
		}else {
			System.out.println("登录失败,返回登录页面");
			return;
		}
	}
	
	//crm 验证token和sso的token是否一致
	@RequestMapping(value = "/saveCrmToken",method = RequestMethod.GET)
	public void saveCrmToken(HttpSession session, String token) {
		RedisTemplate<String, String> redisTemplate =  (RedisTemplate<String, String>)beanUtil.getBean("redisTemplate");
		redisTemplate.opsForValue().set("token", token);

	
	} 
	
	
}
