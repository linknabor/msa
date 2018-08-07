package com.eshequ.crm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.crm.service.TestService;

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
	
}
