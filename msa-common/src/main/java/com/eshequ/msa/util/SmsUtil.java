package com.eshequ.msa.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.util.http.HttpClientProxy;

@Component
public class SmsUtil {
	
	@Autowired
	private HttpClientProxy httpClientProxy;
	
	@Value("${sms.account}")
	private String account;
	
	@Value("${sms.password}")
	private String password;
	
	@Value("${sms.url}")
	private String url;
	
	/**
	 * 请求的参数封装成ap的键值对形式
	 * @param map
	 * @return
	 */
	public String send(Map<String, String> map) {
	
		if (map == null) {
			throw new BusinessException("短信内容不能为空。");
		}
		map.put("account", account);
		map.put("pswd", password);
		map.put("needstatus", String.valueOf(true));
		return httpClientProxy.doPost(url, map, "utf-8");
		
	}
	

}
