package com.eshequ.msa.sso.service;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.MsaBaseCity;
import com.eshequ.msa.sso.model.SsoOrgInfo;
import com.eshequ.msa.sso.model.SsoRole;
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

	/**
	 * 禁用或解禁用户
	 * 
	 * @param userId
	 * @param status
	 * @return
	 */
	BaseResult<?> forbiddenOrOpenUser(String userId, String status);

	/**
	 * 根据条件查询用户信息
	 * 
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SsoUser> getUser(SsoUser ssoUser, String startDate, String endDate);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	BaseResult<?> updatePassword(String userId, String oldPassword, String newPassword);

	/**
	 * 根据id获取用户信息
	 * @param userId
	 * @return
	 */
	SsoUser getUserById(String userId);
	
    /**
     * 获取所有机构信息
     * @return
     */
	List<SsoOrgInfo> getOrgInfoList();
	
    /**
     * 根据id获取机构信息
     * @param orgId
     * @return
     */
	SsoOrgInfo getOrgInfoById(String orgId);
	
    /**
     * 根据机构id获取相关角色
     * @param orgId
     * @return
     */
	List<SsoRole> getRoleByOrgId(String orgId);
    /**
     * 获取所有城市
     * @return
     */
	List<MsaBaseCity> getCityList();

}
