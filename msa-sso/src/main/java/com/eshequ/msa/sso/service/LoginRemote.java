package com.eshequ.msa.sso.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "msa-crm")
public interface LoginRemote {
	//项目名/controller/接口名
	@RequestMapping(value="/crm/testFeign",method=RequestMethod.POST)
	String testFeign(@RequestParam("token") String token,@RequestParam("sessionId") String sessionId);
	
	//注销crm的账号
	@RequestMapping(value="/crm/cancellation ",method=RequestMethod.POST)
	String cancellation();
}
