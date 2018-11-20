package com.eshequ.msa.sso.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.mapper.SsoUserMapper;
import com.eshequ.msa.sso.service.LoginService;
import com.eshequ.msa.util.MD5Util;
import com.eshequ.msa.util.http.HttpUtil;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private SsoUserMapper ssoUserMapper;
	@Autowired
	private HttpUtil httpClientProxy;
	
	//登录
	@Override
	public BaseResult login(String userName, String password,String tpSysName) {
		try {
			password = MD5Util.MD5Encode(password, null);//md5加密后匹配数据库中的密码
			int count = ssoUserMapper.validateLoginUser(userName,password,tpSysName);
			if(count > 0) {
				//存在用户
				return BaseResult.successResult(1);
			}else {
				//没有用户
				return BaseResult.fail(0, "没有查询到匹配的用户");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return BaseResult.fail(99, "查询用户信息时，发生错误！");
		}
	}

	//根据用户名查询用户
	@Override
	public SsoUser selectUserByUserName(String userName,String tpSysName) {
			return ssoUserMapper.selectUserByUserName(userName,tpSysName);
	}

}
