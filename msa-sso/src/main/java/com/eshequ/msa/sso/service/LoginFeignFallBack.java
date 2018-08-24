package com.eshequ.msa.sso.service;

import org.springframework.web.bind.annotation.RequestParam;

public class LoginFeignFallBack implements LoginRemote{

	@Override
	public String testFeign(String token, String sessionId) {
		System.out.println("FallBack:报错了，你晓得不？？？？？？？");
		return "错误";
	}

	@Override
	public String cancellation(String token,String sessionId) {
		// TODO Auto-generated method stub
		System.out.println("FallBack:哈喽你好，你错了。");
		return null;
	}


}
