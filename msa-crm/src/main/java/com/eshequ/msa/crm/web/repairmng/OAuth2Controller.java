package com.eshequ.msa.crm.web.repairmng;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshequ.msa.common.Constants;
import com.eshequ.msa.crm.model.repairmng.AccessToken;
import com.eshequ.msa.crm.model.repairmng.UserInfo;
import com.eshequ.msa.crm.util.QiYeWeiXinUtil;
import com.eshequ.msa.crm.web.BaseController;
import com.eshequ.msa.util.http.HttpClientProxy;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/oauth")
public class OAuth2Controller extends BaseController {
	@Autowired
	private HttpClientProxy httpClientProxy;
	@Value("${qyweixin.cropid}")
	private String cropid;
	@Value("${qyweixin.agentid}")
	private String agentid;
	@Autowired
	private QiYeWeiXinUtil qiYeWeiXinUtil;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	private static Logger log = LoggerFactory.getLogger(OAuth2Controller.class);

	@RequestMapping("/getCode")
	public String getCode(HttpServletRequest request) {
		String requestUrl = request.getServerName();
		log.info(requestUrl);
		String contextPath = request.getContextPath();
		log.info(contextPath);
		String backUrl = "http://" + requestUrl + contextPath + "/oauth" + "/oauthBackUrl";
		log.info(backUrl);
		String redirect_uri = "";
		try {
			redirect_uri = URLEncoder.encode(backUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		log.info(redirect_uri);
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + cropid + "&redirect_uri="
				+ redirect_uri + "&response_type=code&scope=snsapi_userinfo&agentid=" + agentid
				+ "&state=STATE#wechat_redirect";
		return "redirect:" + oauth2Url;
	}

	@RequestMapping("/oauthBackUrl")
	@ResponseBody
	public UserInfo oauthBackUrl(HttpServletRequest request, @RequestParam String code) {
		AccessToken accessToken = qiYeWeiXinUtil.getAccessToken();
		String userId = qiYeWeiXinUtil.getUserId(accessToken.getAccess_token(), code);
		String response = getUserInfo(accessToken.getAccess_token(), userId);
		JSONObject jsonObject=JSONObject.fromObject(response);
		UserInfo user=new UserInfo();
		user.setUserid(jsonObject.getString("userid"));
		user.setGender(jsonObject.getString("gender"));
		user.setPosition(jsonObject.getString("position"));
		user.setMobile(jsonObject.getString("mobile"));
		user.setName(jsonObject.getString("name"));
		user.setAvatar(jsonObject.getString("avatar"));
		redisTemplate.opsForValue().set("userId", userId);
		redisTemplate.opsForValue().set(userId, user);
		return user;
	}
    
	@RequestMapping("/getAccessToke")
	@ResponseBody
	public String getAccessToke() {
		AccessToken accessToken = qiYeWeiXinUtil.getAccessToken();
		return accessToken.getAccess_token();
	}
	@RequestMapping("/getuser")
	@ResponseBody
	public UserInfo getuser(){
		 String userId=(String) redisTemplate.opsForValue().get("userId");
		 return (UserInfo) redisTemplate.opsForValue().get(userId);
	}
	/*public String getUserInfo(String accessToken, String userTicket) {
		String url = Constants.GET_UserInfo_URL.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user_ticket", userTicket);
		return httpClientProxy.doPost(url, jsonObject.toString(), "utf-8");
	}*/
	
	public String getUserInfo(String accessToken, String userId) {
		String url = Constants.GET_USERINFO.replace("ACCESS_TOKEN", accessToken).replace("USERID", userId);
		return httpClientProxy.doGet(url);
	}
}
