package com.eshequ.msa.crm.web.targetcustmng;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.service.TargetCustService;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;
import com.eshequ.msa.crm.web.BaseController;
import com.eshequ.msa.util.SnowFlake;
@RestController
public class TargetCustController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(TargetCustController.class);
	
	@Autowired
	private TargetCustService targetCustService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SnowFlake snowFlake;
	@RequestMapping(value = "/targetcustQuery", method = RequestMethod.POST)
	public List<CrmMarketingCust> targetcustQuery(@RequestBody TargetCustVo vo){
		return targetCustService.targetcustQuery(vo);
	}
	
	@RequestMapping(value = "/targetcustAdd", method = RequestMethod.POST)
	public void targetcustAdd(@RequestBody TargetCustVo vo){
		 targetCustService.targetcustAdd(vo);
	}
	
	@RequestMapping(value = "/targetcustEdit", method = RequestMethod.POST)
	public void targetcustEdit(@RequestBody TargetCustVo vo){
		 targetCustService.targetcustEdit(vo);
	}
	
	@RequestMapping(value = "/targetcustDel/{custId}", method = RequestMethod.POST)
	public void targetcustDel(@PathVariable String custId){
		 targetCustService.targetcustDel(custId);
	}
	
	
	
}
