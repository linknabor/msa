package com.eshequ.msa.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eshequ.msa.crm.mapper.SpServeBillPayTradeMapper;
import com.eshequ.msa.crm.model.SpServeBillPayTrade;
import com.eshequ.msa.crm.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private SpServeBillPayTradeMapper billPayTradeMapper;
	
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
	
	
}
