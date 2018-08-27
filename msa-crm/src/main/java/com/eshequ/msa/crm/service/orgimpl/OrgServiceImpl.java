package com.eshequ.msa.crm.service.orgimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.crm.mapper.orgmapper.CrmSysOrgInfoMapper;
import com.eshequ.msa.crm.model.orgmodel.CrmSysOrgInfo;
import com.eshequ.msa.crm.service.OrgService;
import com.eshequ.msa.crm.vo.org.OrgVo;
import com.eshequ.msa.util.SnowFlake;

@Service
public class OrgServiceImpl implements OrgService{

	@Autowired
	private CrmSysOrgInfoMapper mapper;
	
	@Autowired
	private SnowFlake snowFlake;
	
	@Override
	@Transactional
	public void orgAdd(OrgVo vo) {

		CrmSysOrgInfo record = new CrmSysOrgInfo();
		BeanUtils.copyProperties(vo, record);
		record.setOrgId(snowFlake.nextId());
		mapper.insert(record);
	}

	@Override
	@Transactional
	public void orgEdit(OrgVo vo) {
		CrmSysOrgInfo record = new CrmSysOrgInfo();
		BeanUtils.copyProperties(vo, record);
		mapper.updateByPrimaryKey(record);
	}

	@Override
	@Transactional
	public void orgDel(OrgVo vo) {
		CrmSysOrgInfo record = new CrmSysOrgInfo();
		BeanUtils.copyProperties(vo, record);
		mapper.delete(record);
	}

	@Override
	@Transactional
	public void orgDelById(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<CrmSysOrgInfo> orgQuery(OrgVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrmSysOrgInfo> orgQueryByExample(OrgVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrmSysOrgInfo> orgQueryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
