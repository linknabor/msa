package com.eshequ.msa.crm.service.targetcustimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.crm.mapper.CrmMarketingCustMapper;
import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.service.TargetCustService;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;

@Service
public class TargetCustServiceImpl implements TargetCustService{

	@Autowired
	private CrmMarketingCustMapper mapper;
	@Override
	public String targetcustQuery(String num) {
		return null;
	}

	@Override
	@Transactional
	public void targetcustAdd(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		mapper.insert(record);
	}

	@Override
	public void targetcustEdit(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		mapper.updateByPrimaryKey(record);
	}

	@Override
	public void targetcustDel(String custId) {
		mapper.deleteByPrimaryKey(custId);
	}

}
