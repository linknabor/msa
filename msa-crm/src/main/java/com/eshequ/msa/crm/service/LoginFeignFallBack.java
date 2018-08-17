package com.eshequ.msa.crm.service;

public class LoginFeignFallBack implements LoginRemote{

	@Override
	public String testRemote(String name) {
		System.out.println("错误");
		return "错误";
	}
	

}
