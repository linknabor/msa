package com.eshequ.msa.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.eshequ.msa.crm.mapper.SpServeBillPayTradeMapper;
import com.eshequ.msa.crm.model.SpServeBillPayTrade;
//import com.eshequ.msa.sso.mapper.SpServeBillPayTradeMapper;
//import com.eshequ.msa.sso.model.SpServeBillPayTrade;
import com.eshequ.msa.crm.service.TestService;
import com.eshequ.msa.util.SnowFlake;
import com.eshequ.msa.util.http.HttpClientProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private SpServeBillPayTradeMapper billPayTradeMapper;
	
	@Autowired
	private SnowFlake snowFlag;
	
	@Autowired
	private HttpClientProxy httpClientProxy;
	
	@Override
	public String testQuery(String num) {
		String retStr = "";
		if (StringUtils.isEmpty(num)) {
			 retStr = "no params!";
		}else {
			List<SpServeBillPayTrade> list = billPayTradeMapper.getBillTradeByCsp("130409100000004002");
			ObjectMapper mapper = new ObjectMapper();
			try {
				retStr = mapper.writeValueAsString(list.get((0)));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	
	
	
}
