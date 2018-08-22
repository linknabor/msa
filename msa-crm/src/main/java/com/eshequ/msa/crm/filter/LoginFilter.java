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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshequ.msa.crm.service.LoginRemote;

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
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession httpSession = request.getSession();
		String requestUri = request.getRequestURI();
		String ssoToken =request.getParameter("token");//url带来的token,就是sso创建的token
		String sessionId = request.getParameter("sessionId");//sso的sessionId
		String isToken = "";
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
