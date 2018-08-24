package com.eshequ.msa.sso.service;

import java.util.Map;

import com.eshequ.msa.sso.model.SsoUser;

public interface LoginService {
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	Map<String,String> login(String userName,String password,String tpSysName);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	SsoUser selectUserByUserName(String userName,String tpSysName);
}
