package com.eshequ.msa.dms.service.transfer.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.MsaBaseEnterpriseMapper;
import com.eshequ.msa.dms.mapper.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.MsaBaseRegionMapper;
import com.eshequ.msa.dms.model.MsaBaseCity;
import com.eshequ.msa.dms.model.MsaBaseProvince;
import com.eshequ.msa.dms.model.MsaBaseRegion;
import com.eshequ.msa.dms.service.transfer.BaseDataTransferService;
import com.eshequ.msa.dms.vo.basedata.CspVO;
import com.eshequ.msa.dms.vo.basedata.ProvinceVO;
import com.eshequ.msa.util.SnowFlake;

@Service
public class BaseDataTransferServiceImpl implements BaseDataTransferService {

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
	
	/**
	 * 保存省份
	 * @param provinceList
	 * @return
	 */
	@Transactional
	public BaseResult<String> addProvinceBatch(List<ProvinceVO> provinceList) {
		
		for (ProvinceVO provinceVO : provinceList) {
			provinceVO.setProvinceId(snowFlake.nextId());
			MsaBaseProvince msaBaseProvince = new MsaBaseProvince();
			BeanUtils.copyProperties(provinceVO, msaBaseProvince);
			msaBaseProvinceMapper.insertSelective(msaBaseProvince);
		}
		
		return new BaseResult<String>();
	}
	
	public BaseResult<?> addCityBatch(List<MsaBaseCity> cityList) {
		
		return null;
	}
	
	public BaseResult<?> addRegionBatch(List<MsaBaseRegion> regionList) {
		
		return null;
	}
	
	
	public BaseResult<?> addEnterprise(CspVO cspVO) {
		
		return null;
	}
	
	public BaseResult<?> updateEnterpriseBatch(CspVO cspVO) {
		
		return null;
	}
	
	public BaseResult<?> deleteEnterprise(CspVO cspVO) {
		
		return null;
	}
	
	public BaseResult<?> addEnterpriseBatch(CspVO cspVO) {
		
		return null;
	}
	
}
