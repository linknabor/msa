package com.eshequ.msa.crm.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.eshequ.msa.common.Constants;
import com.eshequ.msa.crm.model.repairmng.AccessToken;
import com.eshequ.msa.util.http.HttpClientProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

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
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public  AccessToken getAccessToken() {
		AccessToken accessToken=null;
		if(redisTemplate.opsForValue().get("accessToken") == null){
			Map<Object, Object> params = new HashMap<>();
			params.put("corpid",cropid);
			params.put("corpsecret",corpsecret);
			String result=httpClientProxy.doGet(Constants.ACCESS_TOKER_URL, params);
			log.info("企业微信获取到的accessToken:"+result);
			 ObjectMapper objectMapper = new ObjectMapper();
			 try {
				 accessToken = objectMapper.readValue(result, AccessToken.class);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			} 
			 if("0".equals(accessToken.getErrcode())){
				 redisTemplate.opsForValue().set("accessToken", accessToken);
				 redisTemplate.expire("accessToken", accessToken.getExpires_in()-100, TimeUnit.SECONDS);
			 }
		}else{
			accessToken=(AccessToken) redisTemplate.opsForValue().get("accessToken");
			log.info("redis获取到的accessToken:"+accessToken);
		}
		
		return accessToken;
	}
	
	public String getUserTicket(String accessToken,String code){
		String userTicket="";
		if(redisTemplate.opsForValue().get("userTicket") == null){
			String url = Constants.GET_OAUTH2_URL.replace("ACCESS_TOKEN", accessToken).replace("CODE",
					code);
			String response = httpClientProxy.doGet(url);
			JSONObject jsonObject=JSONObject.fromObject(response);
			userTicket=jsonObject.getString("user_ticket");
			log.info("企业微信返回userTicket："+userTicket);
			if("0".equals(jsonObject.getString("errcode"))){
				 redisTemplate.opsForValue().set("userTicket", userTicket);
				 redisTemplate.expire("userTicket", Long.parseLong(jsonObject.getString("expires_in"))-100, TimeUnit.SECONDS);
			}
		}else{
			userTicket=(String) redisTemplate.opsForValue().get("userTicket");
			log.info("redis返回userTicket："+userTicket);
		}
		return userTicket;
	}
	
	public String getUserId(String accessToken,String code){
		String userId="";
		if(redisTemplate.opsForValue().get("userId") == null){
			String url = Constants.GET_OAUTH2_URL.replace("ACCESS_TOKEN", accessToken).replace("CODE",
					code);
			String response = httpClientProxy.doGet(url);
			JSONObject jsonObject=JSONObject.fromObject(response);
			userId=jsonObject.getString("UserId");
			log.info("企业微信返回userId："+userId);
			if("0".equals(jsonObject.getString("errcode"))){
				 redisTemplate.opsForValue().set("userId", userId);
				 redisTemplate.expire("userTicket", Long.parseLong(jsonObject.getString("expires_in"))-100, TimeUnit.SECONDS);
			}
		}else{
			userId=(String) redisTemplate.opsForValue().get("userId");
			log.info("redis返回userId："+userId);
		}
		return userId;
	}
}
