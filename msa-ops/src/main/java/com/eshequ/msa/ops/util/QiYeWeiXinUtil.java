package com.eshequ.msa.ops.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.eshequ.msa.common.Constants;
import com.eshequ.msa.ops.model.enterprisewechatmng.AccessToken;
import com.eshequ.msa.util.http.HttpClientProxy;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class QiYeWeiXinUtil {
	private static Logger log = LoggerFactory.getLogger(QiYeWeiXinUtil.class);

	@Autowired
	private HttpClientProxy httpClientProxy;

	@Value("${qyweixin.cropid}")
	private String cropid;

	@Value("${qyweixin.agentid}")
	private String agentid;

	@Value("${qyweixin.corpsecret}")
	private String corpsecret;

	public  AccessToken getAccessToken() {
		AccessToken accessToken=null;
		Map<Object, Object> params = new HashMap<>();
		params.put("corpid",cropid);
		params.put("corpsecret",corpsecret);
		String result=httpClientProxy.doGet(Constants.ACCESS_TOKER_URL, params);
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 accessToken = objectMapper.readValue(result, AccessToken.class);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} 
		return accessToken;
	}
}
