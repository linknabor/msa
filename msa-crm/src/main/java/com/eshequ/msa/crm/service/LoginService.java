package com.eshequ.msa.crm.service;

import java.util.Map;

import com.eshequ.msa.crm.entity.SsoUser;

public interface LoginService {
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	Map<String,String> login(String userName,String password);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 */
	SsoUser selectUserByUserName(String userName);
}
