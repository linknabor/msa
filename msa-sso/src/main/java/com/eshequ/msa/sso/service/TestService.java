package com.eshequ.msa.sso.service;

public interface TestService {

//	@Autowired
//	private SpServeBillPayTradeMapper spServeBillPayTradeMapper;
	
	String testQuery(String num);
	
	long testKeyGen();
	
	String testHttp();
	
	String testMultiDataSource();
	
}
