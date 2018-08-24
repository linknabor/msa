package com.eshequ.msa.sso.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.entity.SsoUser;
import com.eshequ.msa.sso.service.LoginRemote;
import com.eshequ.msa.sso.service.LoginService;
import com.eshequ.msa.util.vericode.VeriCodeUtil;
import com.eshequ.msa.util.vericode.VeriCodeVO;
import com.google.gson.Gson;


@RestController
public class LoginController extends BaseController{
	@Autowired 
	private LoginService loginService;
	@Autowired
	private LoginRemote loginRemote;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Value("${crm.localhost.ip}")
	private String crmLocalhostIp;
	@Value("${sso.localhost.ip}")
	private String ssoLocalhostIp;
	
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 结果集
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public BaseResult login(HttpServletResponse response,HttpServletRequest request, String reqUrl,@RequestParam("userName") String userName, String veriCode,String password,String tpSysName,RedirectAttributes res) throws IOException {
		tpSysName = "系统";
		HttpSession session = request.getSession();
		BaseResult result = new BaseResult();
//		List<String> allowedOrigins = Arrays.asList("http://192.168.0.115:9090", "http://localhost:9090", "http://login.stalary.com");
		String origin = request.getHeader("Origin");
//		response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
//		String code = session.getAttribute("veriCode").toString();
		String sessionId = session.getId();
		Object code = redisTemplate.opsForValue().get(sessionId+"code");//redis中的验证码
		if(code == null) {
			//验证码过期，请重新生成验证码
			result.fail(3, "验证码过期！");
		}
		if(code.equals(veriCode)) {
			result = loginService.login(userName, password,tpSysName);
		if(result.isSuccess()) {
			SsoUser user = loginService.selectUserByUserName(userName,tpSysName);//查询当前登录用户信息
			user.setSessionId(sessionId);
			session.setAttribute("isLogin", "true");
			String token = UUID.randomUUID().toString();//授权码
			user.setToken(token);
			session.setAttribute("token", token);
			System.out.println(session.getAttribute("token"));
			//用户信息 存储redis
			Gson gson = new Gson();
			String loginUserJson = gson.toJson(user);
			redisTemplate.opsForValue().set(sessionId, loginUserJson);//用当前的sessionId作为唯一标识，存储用户信息(包括生成的token，和sessionId)
			redisTemplate.opsForValue().set("tokenSessionId", sessionId);//存储一个取得sso令牌sessionId的一个redis，用于检验token是否有效
//			http请求-->下发token到crm系统并且告知sessionId
			response.sendRedirect(reqUrl+"?token="+token+"&sessionId="+sessionId);
			return result;
		}else {
			//不存在用户，到登录页面
			response.sendRedirect("http://"+ssoLocalhostIp+"/sso/login.html");
			return result;
		}
		}else {
			//验证码不正确，跳转到登录页面
			result.fail(2, "验证码不正确！");
			return result;
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
		public String getCode(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
 			Object code = redisTemplate.opsForValue().get(session.getId()+"code");//
			OutputStream os = response.getOutputStream();
			VeriCodeVO vo = VeriCodeUtil.generateVeriCode();
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			System.out.println("验证码："+vo.getVeriCode());
			Long lon = redisTemplate.getExpire(session.getId()+"code",TimeUnit.SECONDS);
			System.out.println("验证码有效时间剩余："+lon+"秒");
			redisTemplate.opsForValue().set(session.getId()+"code", vo.getVeriCode());//存储验证码到reids
			redisTemplate.expire(session.getId()+"code", 600, TimeUnit.SECONDS);//设置超时时间10秒 第三个参数控制时间单位，详情查看TimeUnit
			ImageIO.write(vo.getBufferedImage(), "jpeg", os);
			return vo.getVeriCode();
		}
	
	//检查token是否有效
	@RequestMapping(value = "/checkSsoToken",method = RequestMethod.POST)
	public String checkSsoToken(String ssoToken,String sessionId,HttpServletResponse response,HttpServletRequest request) {
		HttpSession session = request.getSession();
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
			response.sendRedirect("http://"+ssoLocalhostIp+"/sso/login.html?reqUrl="+reqUrl);
		}else{
			//跳转目标页面
			response.sendRedirect(reqUrl+"?token="+token+"&sessionId="+session.getId());
		}
	}
	
	//sso注销认证中心
	@RequestMapping(value = "/exitCenter",method = RequestMethod.GET)
	public void exitCenter(String sysName,String token,HttpServletResponse response,HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		String ssoToken = (String)session.getAttribute("token");//sso的token
//		String ssoToken = (String)redisTemplate.opsForValue().get(session.getId());//sso token
		String sessionId = session.getId();
		String s = loginRemote.testFeign(ssoToken,sessionId);
		if(token.equals(ssoToken)) {
			//token验证成功，销毁sso全局会话
			session.removeAttribute("token");//删除sso的session token
			session.removeAttribute("isLogin");//删除sso登录状态
			redisTemplate.delete(session.getId());//删除redis中存储的sso的token	
			
			//将所有系统的session都注销掉（目前只注销crm）
//			String s = loginRemote.testFeign(ssoToken,sessionId);//这是sso-->crm的会话
			//注销所有会话后，返回到登录页面（据说，senRedirect后面的语句会继续执行，除非return）
//			response.sendRedirect("http://"+ssoLocalhostIp+"/sso/login.html");
		}else{
			//跳转退出失败 提示页面
//			response.sendRedirect("http://"+ssoLocalhostIp+"/sso/error.html");
		}
	}
	
	@RequestMapping(value = "/feign",method = RequestMethod.GET)
	public void feign(HttpSession httpSession) throws IOException {
		String ssoToken = (String)httpSession.getAttribute("token");//sso的token
		String sessionId = httpSession.getId();
		System.out.println("oidhsailtlsiljbbv(*^%*(&(*$&*(&&(");
		loginRemote.cancellation(ssoToken,sessionId);
	}

	
}
