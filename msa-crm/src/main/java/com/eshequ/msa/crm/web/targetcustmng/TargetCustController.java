package com.eshequ.msa.crm.web.targetcustmng;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.service.TargetCustService;
import com.eshequ.msa.crm.service.targetcustimpl.TargetCustServiceImpl;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;
import com.eshequ.msa.crm.web.BaseController;
import com.eshequ.msa.util.SnowFlake;

public class TargetCustController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(TargetCustController.class);
	
	@Autowired
	private TargetCustService targetCustService;
	
	@Autowired
	private SnowFlake snowFlake;
	@RequestMapping(value = "/targetcustQuery/{num}", method = RequestMethod.GET)
	public List<CrmMarketingCust> targetcustQuery(@PathVariable String num){
		return targetCustService.targetcustQuery(num);
	}
	
	@RequestMapping(value = "/targetcustAdd/{vo}", method = RequestMethod.GET)
	public void targetcustAdd(@PathVariable TargetCustVo vo){
		 targetCustService.targetcustAdd(vo);
	}
	
	@RequestMapping(value = "/targetcustEdit/{vo}", method = RequestMethod.GET)
	public void targetcustEdit(@PathVariable TargetCustVo vo){
		 targetCustService.targetcustEdit(vo);
	}
	
	@RequestMapping(value = "/targetcustDel/{custId}", method = RequestMethod.GET)
	public void targetcustDel(@PathVariable String custId){
		 targetCustService.targetcustDel(custId);
	}
	
	public static void main(String[] args) {
		new TargetCustController().test(); 
	}
	private void test(){
//		TargetCustVo vo = new TargetCustVo();
//		vo.setCust_id("1111111111");
//		vo.setCust_name("测试客户1");
//		vo.setCust_addr("三林路158号1401室");
//		vo.setCity_id("1111111111");
//		vo.setIndustry_id("1111111111");
//		vo.setProvince_id("1111111111");
//		vo.setRegoin_id("1111111111");
//		vo.setRemark("备注");
//		new TargetCustServiceImpl().targetcustAdd(vo);
	}
}
