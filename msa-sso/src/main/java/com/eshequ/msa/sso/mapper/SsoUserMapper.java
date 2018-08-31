package com.eshequ.msa.sso.mapper;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoUser;

public interface SsoUserMapper  extends CommonMapper<SsoUser>{
	/**
	 * 验证登录信息是否有效
	 * @param userName 用户名
	 * @param password 密码
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	int validateLoginUser(@Param("userName")String userName, @Param("password")String password,@Param("tpSysName")String tpSysName);
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @param tpSysName 第三方系统名称
	 * @return
	 */
	SsoUser selectUserByUserName(@Param("userName")String userName,@Param("tpSysName")String tpSysName);
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	int getUserByUserName(@Param("userName")String userName);
	
	/**
	 * 根据用户id重置密码
	 * @param userName
	 * @return
	 */
	int updatePswdByUserId(@Param("userId")String password,@Param("userId")String userId);
	
	
}