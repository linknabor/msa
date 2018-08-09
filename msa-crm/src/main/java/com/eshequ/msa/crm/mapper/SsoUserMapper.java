package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.common.CommonMapper;
import com.eshequ.msa.crm.entity.SsoUser;

public interface SsoUserMapper  extends CommonMapper<SsoUser>{
	/**
	 * 验证登录信息是否有效
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	int validateLoginUser(String userName, String password);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 */
	SsoUser selectUserByUserName(String userName);
	
	
}