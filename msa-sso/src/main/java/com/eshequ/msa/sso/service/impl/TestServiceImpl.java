package com.eshequ.msa.sso.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.codes.mapper.CodeInfoMapper;
import com.eshequ.msa.codes.model.CodeInfo;
import com.eshequ.msa.sso.mapper.SsoUserMapper;
import com.eshequ.msa.sso.model.SsoUser;
//import com.eshequ.msa.sso.mapper.SpServeBillPayTradeMapper;
//import com.eshequ.msa.sso.model.SpServeBillPayTrade;
import com.eshequ.msa.sso.service.TestService;
import com.eshequ.msa.util.SnowFlake;
import com.eshequ.msa.util.http.HttpUtil;

@Service
public class TestServiceImpl implements TestService {

//	@Autowired
//	private SpServeBillPayTradeMapper billPayTradeMapper;
	
	@Autowired
	private SnowFlake snowFlag;
	
	@Autowired
	private HttpUtil httpClientProxy;
	
	@Autowired
	private SsoUserMapper ssoUserMapper;
	
	@Autowired
	private CodeInfoMapper codeInfoMapper;
	
	@Override
	public String testQuery(String num) {
		String retStr = "";
//		if (StringUtils.isEmpty(num)) {
//			 retStr = "no params!";
//		}else {
//			List<SpServeBillPayTrade> list = billPayTradeMapper.getBillTradeByCsp("130409100000004002");
//			ObjectMapper mapper = new ObjectMapper();
//			try {
//				retStr = mapper.writeValueAsString(list.get((0)));
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return retStr;
		
	}

	@Override
	public long testKeyGen() {
		return snowFlag.nextId();
	}

	@Override
	public String testHttp() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "hello");
		return httpClientProxy.doPost("http://localhost:9090/crm/testQuery/4", map, "utf-8");
	}

	@Override
	public String testMultiDataSource() {

		List<SsoUser> list = ssoUserMapper.selectAll();
		List<CodeInfo> codeList = codeInfoMapper.selectAll();
		return codeList.get(0).getCiSpClassname();
	}
	
	
	
	
}
