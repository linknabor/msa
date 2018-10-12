package com.eshequ.msa.ops.web.enterprisewechatmng;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshequ.msa.common.Constants;
import com.eshequ.msa.ops.model.enterprisewechatmng.AccessToken;
import com.eshequ.msa.ops.util.QiYeWeiXinUtil;
import com.eshequ.msa.util.http.HttpClientProxy;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/oauth")
public class OAuth2Controller {
	@Autowired
	private HttpClientProxy httpClientProxy;
	@Value("${qyweixin.cropid}")
	private String cropid;
	@Value("${qyweixin.agentid}")
	private String agentid;
	@Autowired
	private QiYeWeiXinUtil QiYeWeiXinUtil;

	private static Logger log = LoggerFactory.getLogger(OAuth2Controller.class);

	@RequestMapping("/getCode")
	public String getCode(HttpServletRequest request) {
		String requestUrl = request.getServerName();
		log.info(requestUrl);
		String contextPath = request.getContextPath();
		log.info(contextPath);
		String backUrl = "http://" + requestUrl + contextPath +"/oauth" +"/oauthBackUrl";
		log.info(backUrl);
		String redirect_uri = "";
		try {
			redirect_uri = URLEncoder.encode(backUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		log.info(redirect_uri);
		String oauth2Url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+cropid +"&redirect_uri="+ redirect_uri+ "&response_type=code&scope=snsapi_userinfo&agentid="
				+agentid+"&state=STATE#wechat_redirect";
		return "redirect:" + oauth2Url;
	}

	@RequestMapping("/oauthBackUrl")
	@ResponseBody
	public String oauthBackUrl(HttpServletRequest request, @RequestParam String code) {
		AccessToken accessToken = QiYeWeiXinUtil.getAccessToken();
		String response = "";
		if (accessToken != null) {
			String url = Constants.GET_OAUTH2_URL.replace("ACCESS_TOKEN", accessToken.getAccess_token()).replace("CODE",
					code);
			response = httpClientProxy.doGet(url);
			JSONObject jsonObject=JSONObject.fromObject(response);
			String userTicket=jsonObject.getString("user_ticket");
			response=getUserInfo(accessToken.getAccess_token(),userTicket);
		}

		return response;
	}
	
	public String getUserInfo(String accessToken,String userTicket){
		String url=Constants.GET_UserInfo_URL.replace("ACCESS_TOKEN",accessToken);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user_ticket", userTicket);
		return httpClientProxy.doPost(url, jsonObject.toString(), "utf-8");
	}
}
