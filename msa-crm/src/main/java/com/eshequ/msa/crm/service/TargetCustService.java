package com.eshequ.msa.crm.service;

import java.util.List;

import com.eshequ.msa.crm.model.targetcustmodel.CrmMarketingCust;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;

public interface TargetCustService {

	 List<CrmMarketingCust> targetcustQuery(TargetCustVo vo);
	 List<CrmMarketingCust> targetcustQueryByExample(TargetCustVo vo);
	 List<CrmMarketingCust> targetcustQueryAll();
	 void targetcustAdd(TargetCustVo vo);
	 void targetcustEdit(TargetCustVo vo);
	 void targetcustDel(TargetCustVo vo);
	 void targetcustDelById(Long id);

}
