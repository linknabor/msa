package com.eshequ.msa.crm.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.eshequ.msa.crm.service.LoginRemote;
import com.eshequ.msa.util.BeanUtil;

@Component("loginFilter")
public class LoginFilter implements Filter {
	@Autowired
	private LoginRemote loginRemote;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		RedisTemplate<String, String> redisTemplate =  (RedisTemplate<String, String>)BeanUtil.getBean("redisTemplate");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession httpSession = request.getSession();
		String requestUri = request.getRequestURI();
		String ssoToken =request.getParameter("token");//url带来的token,就是sso创建的token
		String sessionId = request.getParameter("sessionId");//sso的sessionId
		String isToken = "";
		
		
		if (requestUri.contains("/actuator/health")) {
			//health check, do nothing
		}else {
			System.out.println(requestUri);
			System.out.println(httpSession.getId());
			Boolean isLogin = (Boolean) httpSession.getAttribute("isLogin");//根据是否有token判断是否登录(crm token)
			StringBuffer urlBuf = request.getRequestURL();
			String reqUrl  = urlBuf.toString();
			
			if(isLogin != null) {
				//如果发现crm是登录状态，直接去目标页面
//				response.setHeader("location", reqUrl);
				chain.doFilter(request, response);
			}else if(ssoToken != null && ssoToken != "") {
				isToken = loginRemote.checkSsoToken(ssoToken, reqUrl,sessionId);//检验token是否真实
				if(isToken.equals("true")) {
					//真实有效
					//如果未登录，设置为登录状态
					if(isLogin == null) {				
						httpSession.setAttribute("isLogin", true);
						httpSession.setAttribute("token", ssoToken);//储存token到crm，方便之后注销
					}
//					response.setHeader("location", reqUrl);
					chain.doFilter(request, response);
//					response.sendRedirect(reqUrl);
					return;
				}else {
					//失败 登录页面
					response.sendRedirect("http://192.168.0.101:9091/sso/index.html");
					return;
				}	
			}
			else {
				//未登录，重定向到sso认证中心
				response.sendRedirect("http://192.168.0.101:9091/sso/ssoAuthentication?reqUrl="+reqUrl);
				return;
			}
			
			
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
