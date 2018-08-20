package com.eshequ.msa.sso.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshequ.msa.sso.entity.SsoUser;
import com.eshequ.msa.sso.service.LoginRemote;
import com.eshequ.msa.sso.service.LoginService;
import com.eshequ.msa.util.BeanUtil;
import com.eshequ.msa.util.VerifyCodeServlet;
import com.eshequ.msa.util.vericode.VeriCodeUtil;
import com.eshequ.msa.util.vericode.VeriCodeVO;
import com.google.gson.Gson;


@RestController
public class LoginController {
	@Autowired 
	private LoginService loginService;
	@Autowired
	private LoginRemote loginRemote;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 结果集
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void login(HttpServletResponse response,HttpServletRequest request, String reqUrl, String userName, String veriCode,String password,String tpSysName,RedirectAttributes res) throws IOException {
		tpSysName = "系统";
		HttpSession session = request.getSession();
		Map<String,String> result  = new HashMap<String,String>();
		String code = session.getAttribute("veriCode").toString();
		if(veriCode.equals(code)) {
		result = loginService.login(userName, password,tpSysName);
		if(result.get("result")=="00") {
			SsoUser user = loginService.selectUserByUserName(userName,tpSysName);//查询当前登录用户信息
			user.setSessionId(session.getId());
			
			session.setAttribute("isLogin", "true");
			
			String token = UUID.randomUUID().toString();//授权码
			user.setToken(token);
			session.setAttribute("token", token);
			
			System.out.println(session.getAttribute("token"));

			//用户信息 存储redis
			Gson gson = new Gson();
			String loginUserJson = gson.toJson(user);
			redisTemplate.opsForValue().set(session.getId(), loginUserJson);//用当前的sessionId作为唯一标识，存储用户信息(包括生成的token，和sessionId)
			redisTemplate.opsForValue().set("tokenSessionId", session.getId());//存储一个取得sso令牌sessionId的一个redis，用于检验token是否有效

//			http请求-->下发token到crm系统并且告知sessionId
			response.sendRedirect(reqUrl+"?token="+token+"&sessionId="+session.getId());
			return;
		}else {
			
			response.sendRedirect("http://192.168.0.101:9091/sso/index.html");
			return;
		}
		}else {
			//验证码不正确，跳转到登录页面
			response.sendRedirect("http://192.168.0.101:9091/sso/index.html");
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
		Map<String,String> result  = new HashMap<String,String>();
		Gson gson = new Gson();
		String loginRedis = (String) redisTemplate.opsForValue().get("loginUserRedis");
		
		if(loginRedis!=null) {
			SsoUser user = gson.fromJson(loginRedis, SsoUser.class);
			System.out.println(user.getUserName());
		}
		return result;
	}
		
	//获取验证码
		@RequestMapping(value = "/getCode",method = RequestMethod.GET)
		public String getCode1(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			OutputStream os = response.getOutputStream();
			VeriCodeVO vo = VeriCodeUtil.generateVeriCode();
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			System.out.println(vo.getVeriCode());
			session.setAttribute("veriCode", vo.getVeriCode());
			session.getAttribute("token");
			ImageIO.write(vo.getBufferedImage(), "jpeg", os);
			return vo.getVeriCode();
		}
	
	@RequestMapping(value = "/checkSsoToken",method = RequestMethod.POST)
	public String checkSsoToken(String ssoToken,String reqUrl,String sessionId,HttpServletResponse response,HttpServletRequest request) {
		HttpSession session = request.getSession();getClass();
		String s = session.getId();
		String isToken = "false";
		Gson gson = new Gson();
		String userJson = redisTemplate.opsForValue().get(sessionId).toString();
		SsoUser user =  gson.fromJson(userJson, SsoUser.class);
		if(user.getToken().equals(ssoToken)) {
			isToken = "true";
		}
		return isToken;
	}
	
	//sso登录认证中心
	@RequestMapping(value = "/ssoAuthentication",method = RequestMethod.GET)
	public void ssoAuthentication(String name,HttpServletResponse response,HttpServletRequest request,String reqUrl) throws IOException {
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
	
	//sso注销认证中心
	@RequestMapping(value = "/exitCenter",method = RequestMethod.GET)
	public void exitCenter(String sysName,String token,HttpServletResponse response,HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		Object ssoToken = session.getAttribute("token");//sso token
		String ii = session.getId();
		if(token.equals(ssoToken)) {
			//token验证成功，销毁sso全局会话
			session.removeAttribute("token");
			session.removeAttribute("isLogin");
			//将所有系统的session都注销掉（目前只注销crm）
			response.sendRedirect("http://localhost:9090/crm/distorySession");
			
			//注销所有会话后，返回到登录页面（据说，senRedirect后面的语句会继续执行，除非return）
			response.sendRedirect("http://localhost:9091/sso/index.html");
		}else{
			//跳转退出失败 提示页面
			response.sendRedirect("http://localhost:9091/sso/error.html");
		}
	}
	
	@RequestMapping(value = "/feign",method = RequestMethod.GET)
	public void feign(HttpSession httpSession) throws IOException {
		String pp = httpSession.getId();
		System.out.println(pp);
//		loginRemote.checkSsoToken("");
	}

	
}
