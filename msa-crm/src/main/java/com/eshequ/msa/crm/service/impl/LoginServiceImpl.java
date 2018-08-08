package com.eshequ.msa.crm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.crm.entity.SsoUser;
import com.eshequ.msa.crm.mapper.SsoUserMapper;
import com.eshequ.msa.crm.service.LoginService;
import com.eshequ.msa.crm.web.TestController;
import com.eshequ.msa.util.MD5Util;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private SsoUserMapper ssoUserMapper;
	
	//登录
	@Override
	public Map<String, String> login(String userName, String password) {
		Map<String,String> result  = new HashMap<String,String>();
		try {
			password = MD5Util.MD5Encode(password, null);//md5加密后匹配数据库中的密码
			int count = ssoUserMapper.validateLoginUser(userName,password);
			if(count > 0) {
				result.put("result", "00");
			}else {
				result.put("result", "01");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.put("result", "99");
		}
		return result;
	}

	//根据用户名查询用户
	@Override
	public SsoUser selectUserByUserName(String userName) {
			return ssoUserMapper.selectUserByUserName(userName);
	}

}
