package com.eshequ.msa.crm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginFeignFallBack implements LoginRemote{
	private static final Logger logger = LoggerFactory.getLogger(LoginFeignFallBack.class);


	@Override
	public String checkSsoToken(String token, String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
