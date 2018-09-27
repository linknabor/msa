package com.eshequ.msa.dms.service.transfer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseRegionMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCityMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseRegionMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseCity;
import com.eshequ.msa.dms.model.msa.MsaBaseProvince;
import com.eshequ.msa.dms.model.msa.MsaBaseRegion;
import com.eshequ.msa.dms.model.servplat.SpBaseCity;
import com.eshequ.msa.dms.model.servplat.SpBaseProvince;
import com.eshequ.msa.dms.model.servplat.SpBaseRegion;
import com.eshequ.msa.dms.service.transfer.BaseDataBatchTransferService;
import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.exception.NotFoundException;
import com.eshequ.msa.util.SnowFlake;

@Service
public class BaseDataTransferServiceImpl implements BaseDataBatchTransferService {

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private SpBaseProvinceMapper spBaseProvinceMapper;
	
	@Autowired
	private MsaBaseProvinceMapper msaBaseProvinceMapper;
	
	@Autowired
	private SpBaseCityMapper spBaseCityMapper;
	
	@Autowired
	private MsaBaseCityMapper msaBaseCityMapper;
	
	@Autowired
	private SpBaseRegionMapper spBaseRegionMapper;
	
	@Autowired
	private MsaBaseRegionMapper msaBaseRegionMapper;
	
	
	/**
	 * 基础数据迁移
	 */
	@Override
	public BaseResult<String> migrateBaseData() {

		migrateProvince();
		migrateCity();
		migrateRegion();
		
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	
	}
	

	@Transactional
	public void migrateProvince() {
		
		
		List<SpBaseProvince> list = spBaseProvinceMapper.selectAll();
		
		for (SpBaseProvince spBaseProvince : list) {
			
			MsaBaseProvince province = new MsaBaseProvince();
			BeanUtils.copyProperties(spBaseProvince, province);
			province.setRemark(spBaseProvince.getProvinceId().toString());
			province.setProvinceId(snowFlake.nextId());
			msaBaseProvinceMapper.insertSelective(province);
		}
		
		
	}
	
	/**
	 * must have data in msa_base_province
	 */
	@Transactional
	public void migrateCity() {
		
		List<MsaBaseProvince> proList = msaBaseProvinceMapper.selectAll();
		Map<String, Long> proMap = new HashMap<String, Long>();
		
		for (MsaBaseProvince msaBaseProvince : proList) {
			proMap.put(msaBaseProvince.getRemark(), msaBaseProvince.getProvinceId());
		}
		
		List<SpBaseCity> cityList = spBaseCityMapper.selectAll();
		for (SpBaseCity spBaseCity : cityList) {
			MsaBaseCity msaBaseCity = new MsaBaseCity();
			BeanUtils.copyProperties(spBaseCity, msaBaseCity);
			msaBaseCity.setRemark(spBaseCity.getCityId().toString());
			msaBaseCity.setProvinceId(proMap.get(spBaseCity.getProvinceId().toString()));
			msaBaseCity.setCityId(snowFlake.nextId());
			msaBaseCityMapper.insertSelective(msaBaseCity);
		}
		
	}

	/**
	 * must have data in msa_base_city
	 * @return
	 */
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateRegion() {

		List<MsaBaseCity> cityList = msaBaseCityMapper.selectAll();
		Map<String, Long> cityMap = new HashMap<String, Long>();
		for (MsaBaseCity msaBaseCity : cityList) {
			cityMap.put(msaBaseCity.getRemark(), msaBaseCity.getCityId());
		}
		
		List<SpBaseRegion> regionList = spBaseRegionMapper.selectAll();
		for (SpBaseRegion spBaseRegion : regionList) {
			MsaBaseRegion msaBaseRegion = new MsaBaseRegion();
			BeanUtils.copyProperties(spBaseRegion, msaBaseRegion);
			msaBaseRegion.setRemark(spBaseRegion.getRegionId().toString());
			msaBaseRegion.setCityId(cityMap.get(spBaseRegion.getCityId().toString()));
			msaBaseRegion.setRegionId(snowFlake.nextId());
			msaBaseRegionMapper.insertSelective(msaBaseRegion);
		}
		
		if(true) {
			throw new BusinessException("test transaction rollback !");
		}
		
	}

	public BaseResult<String> migrateEnterprise() {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResult<String> migrateSect() {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResult<String> migrateCell() {
		// TODO Auto-generated method stub
		return null;
	}



}
