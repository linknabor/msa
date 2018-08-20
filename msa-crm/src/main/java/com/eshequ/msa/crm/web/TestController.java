package com.eshequ.msa.crm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.crm.service.TestService;

@RestController
public class TestController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/testQuery/{num}", method = RequestMethod.GET)
	public String testQuery(@PathVariable String num) {
		
		logger.info("num is : " + num);
		return testService.testQuery(num);
	}
	
	@RequestMapping(value = "/testKeyGen", method = RequestMethod.GET)
	public long testQuery() {
		
		return testService.testKeyGen();
	}
	
	@RequestMapping(value = "/testHttp", method = RequestMethod.GET)
	public String testHttp() {
		
		return testService.testHttp();
	}
	
	
}
