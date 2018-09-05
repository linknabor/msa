package com.eshequ.msa.sso.mapper;

import java.util.List;
import java.util.Map;

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
	 * @param password
	 * @param userId
	 * @return
	 */
	int updatePswdByUserId(@Param("password")String password,@Param("userId")String userId);
	
	/**
	 * 根据用户id更改用户状态
	 * @param status
	 * @param userId
	 * @return
	 */
	int updateStatusByUserId(@Param("status")String status,@Param("userId")String userId);
	/**
	 * 条件查询用户信息
	 * @param ssoUser
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SsoUser> getUserList(Map<String,String> map);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	int  updatePassword(@Param("userId")String userId, @Param("newPassword")String newPassword);
	
	/**
	 * 查询用户密码是否正确
	 * @param userId
	 * @param password
	 * @return
	 */
	int  selectUserByIdAndPswd(@Param("userId")String userId,@Param("password")String password);
}