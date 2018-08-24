package com.eshequ.msa.sso.service;

import java.util.Map;

<<<<<<< HEAD
import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.entity.SsoUser;
=======
import com.eshequ.msa.sso.model.SsoUser;
>>>>>>> 5be8fa73112b2a00315dfd8b5b56013c358dbe29

public interface LoginService {
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	BaseResult login(String userName,String password,String tpSysName);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	SsoUser selectUserByUserName(String userName,String tpSysName);
}
