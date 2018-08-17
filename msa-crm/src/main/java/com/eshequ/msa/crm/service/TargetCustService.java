package com.eshequ.msa.crm.service;

import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;

public interface TargetCustService {

	 String targetcustQuery(String num);
	 void targetcustAdd(TargetCustVo vo);
	 void targetcustEdit(TargetCustVo vo);
	 void targetcustDel(String custId);

}
