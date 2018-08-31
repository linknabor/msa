package com.eshequ.msa.sso.service;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoUser;

public interface UserService {
	/**
	 * 新增用户
	 * 
	 * @param ssoUser
	 * @return
	 */
	BaseResult<?> addUser(SsoUser ssoUser);

	/**
	 * 编辑用户
	 * 
	 * @param ssoUser
	 * @return
	 */
	BaseResult<?> updateUser(SsoUser ssoUser);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	BaseResult<?> deleteUser(Long userId);

	/**
	 * 重置密码
	 * 
	 * @param userId
	 * @return
	 */
	BaseResult<?> resetPassWord(String userId);

}
