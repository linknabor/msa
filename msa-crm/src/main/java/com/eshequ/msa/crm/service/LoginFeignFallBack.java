package com.eshequ.msa.crm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginFeignFallBack implements LoginRemote{
	private static final Logger logger = LoggerFactory.getLogger(LoginFeignFallBack.class);

	@Override
	public String checkSsoToken(String token, String reqUrl,String sessionId) {
		logger.error("sso验证时，发生运行异常！！！");
		System.out.println("错误");
		return "error";
	}

	
	

}
