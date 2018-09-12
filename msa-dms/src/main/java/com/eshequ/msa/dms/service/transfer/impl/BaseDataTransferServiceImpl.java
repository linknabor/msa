package com.eshequ.msa.dms.service.transfer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseEnterpriseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseRegionMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
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
	

	@Override
	public BaseResult<String> migrateProvinceBatch() {

		spBaseProvinceMapper.selectAll();
		
		
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
