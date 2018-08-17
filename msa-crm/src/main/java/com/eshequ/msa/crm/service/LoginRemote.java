package com.eshequ.msa.crm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("msa-sso")
public interface LoginRemote {
	//项目名/controller/接口名
	@RequestMapping(value="/sso/test",method=RequestMethod.GET)
	String testRemote(@RequestParam("name") String name);
}
