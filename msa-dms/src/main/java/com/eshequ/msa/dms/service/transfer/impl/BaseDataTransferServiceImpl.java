package com.eshequ.msa.dms.service.transfer.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseEnterpriseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseRegionMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseProvince;
import com.eshequ.msa.dms.model.servplat.SpBaseProvince;
import com.eshequ.msa.dms.service.transfer.BaseDataBatchTransferService;
import com.eshequ.msa.dms.vo.basedata.CspVO;
import com.eshequ.msa.util.SnowFlake;

@Service
public class BaseDataTransferServiceImpl implements BaseDataBatchTransferService {

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private MsaBaseProvinceMapper msaBaseProvinceMapper;
	
	@Autowired
	private MsaBaseCityMapper msaBaseCityMapper;
	
	@Autowired
	private MsaBaseRegionMapper msaBaseRegionMapper;
	
	@Autowired
	private MsaBaseEnterpriseMapper msaBaseEnterpriseMapper;
	
	@Autowired
	private SpBaseProvinceMapper spBaseProvinceMapper;
	
	@Autowired
	private SnowFlake SnowFlake;
	

	@Override
	@Transactional
	public BaseResult<String> migrateProvinceBatch() {

		
		List<SpBaseProvince> list = spBaseProvinceMapper.selectAll();
		
		for (SpBaseProvince spBaseProvince : list) {
			
			MsaBaseProvince province = new MsaBaseProvince();
			BeanUtils.copyProperties(spBaseProvince, province);
			province.setRemark(spBaseProvince.getProvinceId().toString());
			province.setProvinceId(snowFlake.nextId());
			msaBaseProvinceMapper.insert(province);
		}
		
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
		
		
	}



	@Override
	public BaseResult<String> migrateCityBatch() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BaseResult<String> migrateRegionBatch() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BaseResult<?> migrateEnterpriseBatch() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
