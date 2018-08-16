package com.eshequ.msa.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.eshequ.msa.crm.entity.SsoUser;
import com.eshequ.msa.util.BeanUtil;
import com.google.gson.Gson;

@Component("loginFilter")
public class LoginFilter implements Filter {

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
		Object ssoToken =request.getParameter("token");//url带来的token,就是sso创建的token
		Object sessionId = request.getParameter("sessionId");//sso的sessionId
		if (requestUri.contains("/actuator/health")) {
			//health check, do nothing
		}else {
			System.out.println(requestUri);
			System.out.println(httpSession.getId());
			Boolean isLogin = (Boolean) httpSession.getAttribute("isLogin");//根据是否有token判断是否登录(crm token)
			StringBuffer urlBuf = request.getRequestURL();
			String reqUrl  = urlBuf.toString();
			if(isLogin != null  || ssoToken != null) {
				if(isLogin == null) {				
					httpSession.setAttribute("isLogin", true);
				}
				
				String SsoUserJson =redisTemplate.opsForValue().get(sessionId);
				Gson gson = new Gson();
				SsoUser user= gson.fromJson(SsoUserJson, SsoUser.class);
				if(user.getToken().equals(ssoToken)) {
					//验证成功
					chain.doFilter(request, response);
					response.sendRedirect(reqUrl);
				}else {
					//失败
//					chain.doFilter(request, response);
					response.sendRedirect("http://localhost:9091/sso/index.html");
				}
				
				return;
				
			}else {
//				request.getRequestDispatcher("http://localhost:9091/sso/test1?reqUrl="+reqUrl).forward(request, response);
				//未登录，重定向到sso认证中心
				response.sendRedirect("http://localhost:9091/sso/test1?reqUrl="+reqUrl);
				return;
			}
			
			
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
