/**
 * 
 */
package com.eshequ.http;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exception.AppSysException;
import exception.BusinessException;



/**
 * @author davidhardson
 *
 */
@Component
public class HttpClientProxy {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientProxy.class);

	@Autowired
	private CloseableHttpClient httpClient;
	
	@Autowired
	private RequestConfig requestConfig;
	
	/**
	 * 
	 */
	public HttpClientProxy() {
		// TODO Auto-generated constructor stub
	}

	
	public String doPost(String url, Object obj) {
		
		return doPost(url, obj, Charset.defaultCharset().name());
		
	}
	
	public String doPost(String url, Object obj, String encoding) {
		
		HttpConfig config = new HttpConfig(encoding);
		return doPost(url, obj, config);
		
	}
	
	/**
	 * POST with json	目前只支持json，用map的自行转换一下
	 * @param requestUrl
	 * @param json
	 * @param charset
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String doPost(String requestUrl, Object obj, HttpConfig httpConfig) {
		
        String httpStr = "";
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
        
	        if (obj instanceof HashMap || obj instanceof TreeMap) {//键值形式
	        	
	    		httpPost.setEntity(new UrlEncodedFormEntity(assembleRequestParams((Map<String,String>)obj), Charset.forName(httpConfig.getRequestEncoding())));
	    		
	    	} else if(obj instanceof String) {//json形式
	    		
	    		if (((String) obj).startsWith("<") && (((String) obj).endsWith(">"))) {	//xml
	    			StringEntity stringEntity = new StringEntity(obj.toString(), httpConfig.getRequestEncoding());//解决中文乱码问题
        			stringEntity.setContentType("text/xml");
        			httpPost.setEntity(stringEntity);
				}else {
					StringEntity stringEntity = new StringEntity(obj.toString(), httpConfig.getRequestEncoding());//解决中文乱码问题
		             stringEntity.setContentType("application/json");
		             httpPost.setEntity(stringEntity);
					
				}
				 
	    	} else {
				throw new BusinessException("invalid post object ! ");
			} 
	        httpPost.setHeader("Accept", "application/json");
	    	response = httpClient.execute(httpPost);
	        HttpEntity entity = response.getEntity();
	        logger.info("response statusCode "+response.getStatusLine().getStatusCode());
			httpStr = EntityUtils.toString(entity, httpConfig.getResponseEncoding());
			
		} catch (Exception e) {
			
			throw new AppSysException(e);
		
		}
        
        return httpStr;
    
	}
		
	/**
	 * 组装http请求参数
	 * 
	 * @param params
	 * @param menthod
	 * @return
	 */
	private List<NameValuePair> assembleRequestParams(Map<String, String> params) {
		
		List<NameValuePair> nameValueList = new ArrayList<NameValuePair>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
            nameValueList.add(pair);
        }
		return nameValueList;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
