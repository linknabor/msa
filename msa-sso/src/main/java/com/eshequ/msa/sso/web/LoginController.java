package com.eshequ.msa.sso.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.eshequ.msa.sso.config.RedisConfig;
import com.eshequ.msa.sso.entity.SsoUser;
import com.eshequ.msa.sso.service.LoginRemote;
import com.eshequ.msa.sso.service.LoginService;
import com.eshequ.msa.util.BeanUtil;
import com.eshequ.msa.util.VerifyCodeServlet;
import com.google.gson.Gson;

@RestController
public class LoginController {
	@Autowired 
	private LoginService loginService;
	@Autowired
	private LoginRemote loginRemote;

	

	
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 结果集
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void login(HttpSession session1, HttpServletResponse response,HttpServletRequest request, String reqUrl, String userName,String password,String tpSysName) throws IOException {
		tpSysName = "系统";
		HttpSession session = request.getSession();
		Map<String,String> result  = new HashMap<String,String>();
		result = loginService.login(userName, password,tpSysName);
		String ii = session.getId();
		Object tokem = session.getAttribute("token");
		if(result.get("result")=="00") {
			SsoUser user = loginService.selectUserByUserName(userName,tpSysName);//查询当前登录用户信息
			user.setSessionId(session.getId());
			
			//用户信息 存储session
//			session.setAttribute("loginUser", user);
			session.setAttribute("isLogin", "true");
			
			String token = UUID.randomUUID().toString();//授权码
			user.setToken(token);
			session.setAttribute("token", token);
			
			System.out.println(session.getAttribute("token"));
			
			//用户信息 存储cookie
//			cook(request,response);
			
			//用户信息 存储redis
			RedisTemplate<String, String> redisTemplate =  (RedisTemplate<String, String>)BeanUtil.getBean("redisTemplate");
			Gson gson = new Gson();
			String loginUserJson = gson.toJson(user);
			redisTemplate.opsForValue().set(session.getId(), loginUserJson);//用当前的sessionId作为唯一标识，存储用户信息(包括生成的token，和sessionId)
			redisTemplate.opsForValue().set("tokenSessionId", session.getId());//存储一个取得sso令牌sessionId的一个redis，用于检验token是否有效

			System.out.println(redisTemplate.opsForValue().get("loginUserRedis"));
			System.out.println(redisTemplate.opsForValue().get(session.getId()));

			//获取新的验证码
//			getCode(request, response);
			
			
//			response.sendRedirect("/crm/loginSuccessController?token="+token+"&sessionId=");
//			http请求-->下发token到crm系统并且告知sessionId

			//跳转至客户端访问的页面
			//crm跳转到crm的认证去检测token是否真实有效，在crm认证中心，保存token建立会话
//			loginRemote.saveCrmToken(token);
			
			response.sendRedirect(reqUrl+"?token="+token+"&sessionId="+session.getId());
			
		}else {
			
			response.sendRedirect("http://localhost:9091/sso/index.html");
			return;
		}
		
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
			System.out.println(httpSession.getId());
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public void test(String token,String sessionId) {
		System.out.println(token);
	}
	
	//sso认证中心
	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public void test1(String name,HttpSession session1,HttpServletResponse response,HttpServletRequest request,String reqUrl) throws IOException {
		HttpSession session = request.getSession();
		Object token = session.getAttribute("token");//sso session
		String ii = session.getId();
		if(token==null) {
			//未登录 跳去登录页面
			response.sendRedirect("http://localhost:9091/sso/index.html?reqUrl="+reqUrl);
		}else{
			//sso token 存在，去crm校验token是否有效
//			loginRemote.saveCrmToken(token.toString());
			//跳转目标页面
			response.sendRedirect(reqUrl+"?token="+token+"&sessionId="+session.getId());
		}
	}
	@RequestMapping(value = "/feign",method = RequestMethod.GET)
	public void feign(HttpSession httpSession) throws IOException {
		String pp = httpSession.getId();
		loginRemote.saveCrmToken("");
	}
	
	
	
}
