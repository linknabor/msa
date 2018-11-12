package com.eshequ.msa.dms.service.transfer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCellMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseEnterpriseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseRegionMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseSectMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCityMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCspMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseMngCellMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseRegionMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseSectMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseCell;
import com.eshequ.msa.dms.model.msa.MsaBaseCity;
import com.eshequ.msa.dms.model.msa.MsaBaseEnterprise;
import com.eshequ.msa.dms.model.msa.MsaBaseProvince;
import com.eshequ.msa.dms.model.msa.MsaBaseRegion;
import com.eshequ.msa.dms.model.msa.MsaBaseSect;
import com.eshequ.msa.dms.model.servplat.SpBaseCity;
import com.eshequ.msa.dms.model.servplat.SpBaseCsp;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseProvince;
import com.eshequ.msa.dms.model.servplat.SpBaseRegion;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.service.transfer.BaseDataBatchTransferService;
import com.eshequ.msa.exception.BusinessException;
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
	
	@Autowired
	private SpBaseCspMapper spBaseCspMapper;
	
	@Autowired
	private MsaBaseEnterpriseMapper msaBaseEnterpriseMapper;
	
	@Autowired
	private MsaBaseSectMapper msaBaseSectMapper;
	
	@Autowired
	private SpBaseSectMapper spBaseSectMapper;
	
	@Autowired
	private MsaBaseCellMapper msaBaseCellMapper;
	
	@Autowired
	private SpBaseMngCellMapper spBaseMngCellMapper;
	
	/**
	 * 基础数据迁移
	 */
	@Override
	public BaseResult<String> migrateBaseData() {

		migrateProvince();
		migrateCity();
		migrateRegion();
		migrateEnterprise();
		migrateSect();
		
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
	
	@Transactional
	public void migrateEnterprise() {
		
		List<MsaBaseEnterprise> enterpriseList = msaBaseEnterpriseMapper.selectAll();
		Map<String,String> enterpriseMap = new HashMap<String, String>();
		for (MsaBaseEnterprise msaBaseEnterprise : enterpriseList) {
			enterpriseMap.put(msaBaseEnterprise.getRemark(), msaBaseEnterprise.getOriginId());
		}
		
		List<SpBaseCsp> cspList = spBaseCspMapper.selectAll();
		for (SpBaseCsp spBaseCsp : cspList) {
			MsaBaseEnterprise msaBaseEnterprise = new MsaBaseEnterprise();
			BeanUtils.copyProperties(spBaseCsp, msaBaseEnterprise);
			msaBaseEnterprise.setRemark(spBaseCsp.getCspId().toString());
			msaBaseEnterprise.setEnterpriseId(snowFlake.nextId()+"");
			msaBaseEnterpriseMapper.insertSelective(msaBaseEnterprise);
		}
	}

	@Transactional
	public void migrateSect() {
		List<MsaBaseSect> sectList = msaBaseSectMapper.selectAll();
		Map<String,String> sectMap = new HashMap<String, String>();
		for (MsaBaseSect msaBaseSect :sectList) {
			sectMap.put(msaBaseSect.getRemark(), msaBaseSect.getRelatedSectNo());
		}
		
		List<SpBaseSect>spsectList = spBaseSectMapper.selectAll();
		for (SpBaseSect spBaseSect : spsectList) {
			MsaBaseSect msaBaseSect = new MsaBaseSect();
			BeanUtils.copyProperties(spBaseSect, msaBaseSect);
			msaBaseSect.setRemark(spBaseSect.getSectId().toString());
			msaBaseSect.setSectId(snowFlake.nextId());
			msaBaseSectMapper.insertSelective(msaBaseSect);
		}
	}

	
	public void migrateCell() {
		List<MsaBaseCell> cellList = msaBaseCellMapper.selectAll();
		Map<String,Long>cellMap = new HashMap<String, Long>();
		for (MsaBaseCell msaBaseCell :cellList) {
			cellMap.put(msaBaseCell.getRemark(), msaBaseCell.getMngCellId());
		}
		
		List<SpBaseMngCell>spcellList = spBaseMngCellMapper.selectAll();
		for (SpBaseMngCell spBaseCell : spcellList) {
			MsaBaseCell msaBaseCell = new MsaBaseCell();
			BeanUtils.copyProperties(spBaseCell, msaBaseCell);
			msaBaseCell.setRemark(spBaseCell.getSectId().toString());
			msaBaseCell.setMngCellId(snowFlake.nextId());
			msaBaseCellMapper.insertSelective(msaBaseCell);
		}
	}



}
