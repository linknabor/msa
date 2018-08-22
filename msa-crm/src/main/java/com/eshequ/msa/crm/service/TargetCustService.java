package com.eshequ.msa.crm.service;

import java.util.List;

import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;

public interface TargetCustService {

	 List<CrmMarketingCust> targetcustQuery(TargetCustVo vo);
	 void targetcustAdd(TargetCustVo vo);
	 void targetcustEdit(TargetCustVo vo);
	 void targetcustDel(String custId);

}