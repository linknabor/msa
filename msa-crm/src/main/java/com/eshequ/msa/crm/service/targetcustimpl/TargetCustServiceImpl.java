package com.eshequ.msa.crm.service.targetcustimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.crm.mapper.CrmMarketingCustMapper;
import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.service.TargetCustService;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;
import com.eshequ.msa.util.SnowFlake;

@Service
public class TargetCustServiceImpl implements TargetCustService{

	@Autowired
	private CrmMarketingCustMapper mapper;
	
	@Autowired
	private SnowFlake snowFlake;
	
	//查询目标客户
	@Override
	public List<CrmMarketingCust> targetcustQuery(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		List<CrmMarketingCust> list = mapper.select(record);
		return list;
	}

	//新增目标客户
	@Override
	@Transactional
	public void targetcustAdd(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		record.setCustId(snowFlake.nextId());
		mapper.insertSelective(record);
	}

	//编辑目标客户
	@Override
	@Transactional
	public void targetcustEdit(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		mapper.updateByPrimaryKey(record);
	}

	//删除目标客户
	@Override
	@Transactional
	public void targetcustDel(TargetCustVo vo) {
		CrmMarketingCust record = new CrmMarketingCust();
		BeanUtils.copyProperties(vo, record);
		mapper.delete(record);
	}

	@Override
	@Transactional
	public void targetcustDelById(long id) {
		mapper.deleteByPrimaryKey(id);
	}

}
