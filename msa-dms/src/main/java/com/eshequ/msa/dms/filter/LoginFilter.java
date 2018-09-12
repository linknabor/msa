package com.eshequ.msa.dms.filter;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.eshequ.msa.dms.service.login.LoginRemote;

@Component("loginFilter")
public class LoginFilter implements Filter {
	@Autowired
	private LoginRemote loginRemote;
	
	@Value("${sso.login.url}")
	private String ssoUrlLogin;
	
	@Value("${common.login.url}")
	private String commonLoginUrl;
	
	private static final String validateURI = "/sso/?reqUrl";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
