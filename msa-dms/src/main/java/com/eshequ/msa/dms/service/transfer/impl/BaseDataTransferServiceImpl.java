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
import com.eshequ.msa.dms.mapper.servplat.SpBaseCityMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCspMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseRegionMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseCity;
import com.eshequ.msa.dms.model.msa.MsaBaseEnterprise;
import com.eshequ.msa.dms.model.msa.MsaBaseProvince;
import com.eshequ.msa.dms.model.msa.MsaBaseRegion;
import com.eshequ.msa.dms.model.servplat.SpBaseCity;
import com.eshequ.msa.dms.model.servplat.SpBaseCsp;
import com.eshequ.msa.dms.model.servplat.SpBaseProvince;
import com.eshequ.msa.dms.model.servplat.SpBaseRegion;
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
	private SpBaseCityMapper spBaseCityMapper;
	
	@Autowired
	private SpBaseRegionMapper spBaseRegionMapper;
	
	@Autowired
	private SpBaseCspMapper spBaseCspMapper; 
	

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
		List<SpBaseCity> list = spBaseCityMapper.selectAll();
		
		for(SpBaseCity spBaseCity : list) {
			MsaBaseCity city = new MsaBaseCity();
			BeanUtils.copyProperties(spBaseCity, city);
			city.setRemark(spBaseCity.getCityId().toString());
			city.setCityId(snowFlake.nextId());
			msaBaseCityMapper.insert(city);
		}

		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}



	@Override
	public BaseResult<String> migrateRegionBatch() {
		List<SpBaseRegion> list = spBaseRegionMapper.selectAll();
		
		for(SpBaseRegion spBaseRegion : list) {
			MsaBaseRegion region = new MsaBaseRegion();
			BeanUtils.copyProperties(spBaseRegion, region);
			region.setRemark(spBaseRegion.getRegionId().toString());
			region.setRegionId(snowFlake.nextId());
			msaBaseRegionMapper.insert(region);
		}
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}



	@Override
	public BaseResult<String> migrateEnterpriseBatch() {
		List<SpBaseCsp> list = spBaseCspMapper.selectAll();
		
		for(SpBaseCsp spBaseCsp : list) {
			MsaBaseEnterprise enterprise = new MsaBaseEnterprise();
			BeanUtils.copyProperties(enterprise, list);
			enterprise.setRemark(spBaseCsp.getCspId().toString());
			enterprise.setEnterpriseId(snowFlake.nextId()+"");
			msaBaseEnterpriseMapper.insert(enterprise);
			
		}
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}
	
}
