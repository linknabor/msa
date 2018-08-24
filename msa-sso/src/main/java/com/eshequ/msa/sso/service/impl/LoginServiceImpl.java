package com.eshequ.msa.sso.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.sso.mapper.SsoUserMapper;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.LoginService;
import com.eshequ.msa.sso.web.TestController;
import com.eshequ.msa.util.MD5Util;
import com.eshequ.msa.util.http.HttpClientProxy;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private SsoUserMapper ssoUserMapper;
	@Autowired
	private HttpClientProxy httpClientProxy;
	
	//登录
	@Override
	public Map<String, String> login(String userName, String password,String tpSysName) {
		Map<String,String> result  = new HashMap<String,String>();
		try {
			password = MD5Util.MD5Encode(password, null);//md5加密后匹配数据库中的密码
			int count = ssoUserMapper.validateLoginUser(userName,password,tpSysName);
			if(count > 0) {
				//存在用户
				result.put("result", "01");
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("a", "a");
//				String a =  httpClientProxy.doPost("http://localhost:9090/crm/testconnect", map, "utf-8");
//				System.out.println(a);
			}else {
				//没有用户
				result.put("result", "00");
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
	public SsoUser selectUserByUserName(String userName,String tpSysName) {
			return ssoUserMapper.selectUserByUserName(userName,tpSysName);
	}

}
