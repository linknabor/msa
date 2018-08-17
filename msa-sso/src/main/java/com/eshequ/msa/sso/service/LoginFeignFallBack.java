package com.eshequ.msa.sso.service;

public class LoginFeignFallBack implements LoginRemote{

	@Override
	public String testFeign(String name) {
		System.out.println("FallBack:报错了，你晓得不？？？？？？？");
		return "错误";
	}

}
