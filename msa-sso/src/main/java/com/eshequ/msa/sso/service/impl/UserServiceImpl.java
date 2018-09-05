package com.eshequ.msa.sso.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.codes.InfoStatus;
import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.mapper.SsoUserMapper;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.UserService;
import com.eshequ.msa.util.DateUtil;
import com.eshequ.msa.util.MD5Util;
import com.eshequ.msa.util.SnowFlake;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final String PASSWORD_POSTFIX = "sso";
	private final String INITIAL_PASSWORD="11111111";
	@Autowired
	private SsoUserMapper ssoUserMapper;
                     
	@Autowired
	private SnowFlake snowFlake;

	@Override
	public BaseResult<?> addUser(SsoUser ssoUser) {
		if (ssoUserMapper.getUserByUserName(ssoUser.getUserName()) > 0) {
			return BaseResult.fail(0, "用户名重复！");
		}
		ssoUser.setUserId(snowFlake.nextId());
		ssoUser.setCreateDate(DateUtil.getSysDate());
		ssoUser.setCreateTime(DateUtil.getSysTime());
		ssoUser.setStatus(String.valueOf(InfoStatus.ZhengChang));
		ssoUser.setPassword(MD5Util.MD5Encode(INITIAL_PASSWORD+ "-" + PASSWORD_POSTFIX, null));
		int count = ssoUserMapper.insertSelective(ssoUser);
		if (count > 0) {
			return BaseResult.successResult("添加用户成功！");
		}
		return BaseResult.fail(0, "添加用户失败！");
	}

	@Override
	public BaseResult<?> updateUser(SsoUser ssoUser) {
		if (ssoUserMapper.updateByPrimaryKeySelective(ssoUser) > 0) {
			return BaseResult.successResult("编辑用户成功！");
		}
		return BaseResult.fail(0, "编辑用户失败！");
	}

	@Override
	public BaseResult<?> deleteUser(Long userId) {
		if (ssoUserMapper.deleteByPrimaryKey(userId) > 0) {
			return BaseResult.successResult("删除用户成功！");
		}
		return BaseResult.fail(0, "删除用户失败！");
	}

	@Override
	public BaseResult<?> resetPassWord(String userId) {
		String password = MD5Util.MD5Encode(INITIAL_PASSWORD + "-" + PASSWORD_POSTFIX, null);
		int count = ssoUserMapper.updatePswdByUserId(password, userId);
		if (count > 0) {
			return BaseResult.successResult("重置密码成功！");
		}
		return BaseResult.fail(0, "重置密码失败！");
	}

	@Override
	public BaseResult<?> forbiddenOrOpenUser(String userId,String status) {
		int count = ssoUserMapper.updateStatusByUserId(status, userId);
			if(status.equals(String.valueOf(InfoStatus.ZhengChang))){
				if(count>0){
					return BaseResult.successResult("解禁用户成功！");	
				}else{
					return BaseResult.fail(0,"解禁用户失败！");
				}
			}else{
				if(count>0){
					return BaseResult.successResult("禁用用户成功！");
				}else{
					return BaseResult.fail(0,"禁用用户失败！");
				}
			}
	}

	@Override
	public List<SsoUser> getUser(SsoUser ssoUser, String startDate, String endDate) {
		Map<String,String> map=new HashMap<>();
		map.put("startDate", startDate);
		map.put("realName", ssoUser.getRealName());
		map.put("endDate", endDate);
		map.put("status", ssoUser.getStatus());
		map.put("orgName", ssoUser.getOrgName());
		return ssoUserMapper.getUserList(map);
	}

	@Override
	public BaseResult<?> updatePassword(String userId, String oldPassword, String newPassword) {
		oldPassword=MD5Util.MD5Encode(oldPassword + "-" + PASSWORD_POSTFIX, null);
		newPassword=MD5Util.MD5Encode(newPassword + "-" + PASSWORD_POSTFIX, null);
		if(ssoUserMapper.selectUserByIdAndPswd(userId, oldPassword)<=0){
			return BaseResult.fail(0,"原密码错误！");
		}
		if(ssoUserMapper.updatePswdByUserId(newPassword, userId)>0){
			return BaseResult.successResult("修改密码成功！");
		}
		return BaseResult.fail(0,"修改密码失败！");
	}

	@Override
	public SsoUser getUserById(String userId) {
		SsoUser su=new SsoUser();
		su.setUserId(Long.parseLong(userId));
		su=ssoUserMapper.selectOne(su);
		su.setPassword(null);
		return su;
	}

}
