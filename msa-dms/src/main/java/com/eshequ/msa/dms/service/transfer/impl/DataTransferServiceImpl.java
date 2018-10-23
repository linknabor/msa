package com.eshequ.msa.dms.service.transfer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustCarMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseHouseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseSectMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseShopsMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseHouseMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseCust;
import com.eshequ.msa.dms.model.msa.MsaBaseCustCar;
import com.eshequ.msa.dms.model.msa.MsaBaseHouse;
import com.eshequ.msa.dms.model.msa.MsaBaseSect;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.service.transfer.DataTransferService;
import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.util.SnowFlake;
@Service
public class DataTransferServiceImpl implements DataTransferService{
	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private MsaBaseSectMapper msaBaseSectMapper;
	
	@Autowired
	private MsaBaseHouseMapper msaBaseHouseMapper;
	
	@Autowired
	private MsaBaseCustMapper msaBaseCustMapper;
	
	@Autowired
	private MsaBaseCustCarMapper msaBaseCustCarMapper;

	@Override
	@Transactional(rollbackFor={BusinessException.class})
	public BaseResult<String> migrateSectData(SpBaseSect spBaseSect) {
		migrateSect(spBaseSect);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateHouseData(SpBaseHouse spBaseHouse) {
		migrateHouse(spBaseHouse);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Transactional(rollbackFor={BusinessException.class})
	public void migrateSect(SpBaseSect spBaseSect) {
		MsaBaseSect msaBaseSect = new MsaBaseSect();
		BeanUtils.copyProperties(spBaseSect, msaBaseSect);
		msaBaseSect.setRemark(spBaseSect.getSectId().toString());
		msaBaseSect.setStatus(spBaseSect.getSectStatus());
		msaBaseSect.setSectName(spBaseSect.getSectNameFrst());
		msaBaseSect.setSectAddr(spBaseSect.getSectAddrFrst());
		msaBaseSect.setOriginalId(spBaseSect.getSectId()+"");
		msaBaseSect.setSectId(snowFlake.nextId());
		msaBaseSectMapper.insertSelective(msaBaseSect);
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateHouse(SpBaseHouse spBaseHouse) {
		MsaBaseHouse msaBaseHouse = new MsaBaseHouse();
		BeanUtils.copyProperties(spBaseHouse, msaBaseHouse);
		msaBaseHouseMapper.insertSelective(msaBaseHouse);
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateCust(SpBaseCust spBaseCust) {
		MsaBaseCust msaBaseCust = new MsaBaseCust();
		BeanUtils.copyProperties(spBaseCust, msaBaseCust);
		msaBaseCust.setOriginalId(spBaseCust.getCustId()+"");
		msaBaseCust.setCustId(snowFlake.nextId());
		msaBaseCustMapper.insertSelective(msaBaseCust);
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateCar(SpBaseCustCar spBaseCustCar) {
		MsaBaseCustCar msaBaseCustCar = new MsaBaseCustCar();
		BeanUtils.copyProperties(spBaseCustCar, msaBaseCustCar);
		msaBaseCustCar.setOriginalId(spBaseCustCar.getCarId()+"");
		msaBaseCustCar.setCarId(snowFlake.nextId());
		msaBaseCustCarMapper.insertSelective(msaBaseCustCar);
	}

	@Override
	public BaseResult<String> migrateCustData(SpBaseCust spBaseCust) {
		migrateCust(spBaseCust);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateCarData(SpBaseCustCar spBaseCustCar) {
		migrateCar(spBaseCustCar);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}
}
