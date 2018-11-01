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
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustCarFeeStartDateMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustCarMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseHouseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseSectMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseShopsMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseHouseMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseCell;
import com.eshequ.msa.dms.model.msa.MsaBaseCust;
import com.eshequ.msa.dms.model.msa.MsaBaseCustCar;
import com.eshequ.msa.dms.model.msa.MsaBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.msa.MsaBaseHouse;
import com.eshequ.msa.dms.model.msa.MsaBaseSect;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.service.transfer.DataTransferService;
import com.eshequ.msa.dms.vo.basedata.CarInfoVO;
import com.eshequ.msa.exception.BusinessException;
@Service
public class DataTransferServiceImpl implements DataTransferService{
	
	@Autowired
	private MsaBaseSectMapper msaBaseSectMapper;
	
	@Autowired
	private MsaBaseHouseMapper msaBaseHouseMapper;
	
	@Autowired
	private MsaBaseCustMapper msaBaseCustMapper;
	
	@Autowired
	private MsaBaseCustCarMapper msaBaseCustCarMapper;
	
	@Autowired
	private MsaBaseCellMapper msaBaseCellMapper;
	
	@Autowired
	private MsaBaseCustCarFeeStartDateMapper msaBaseCustCarFeeStartDateMapper;

	@Override
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

	//新增小区
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateSect(SpBaseSect spBaseSect) {
		MsaBaseSect msaBaseSect = new MsaBaseSect();
		BeanUtils.copyProperties(spBaseSect, msaBaseSect);
		msaBaseSect.setRemark(spBaseSect.getSectId().toString());
		msaBaseSect.setStatus(spBaseSect.getSectStatus());
		msaBaseSect.setSectName(spBaseSect.getSectNameFrst());
		msaBaseSect.setSectAddr(spBaseSect.getSectAddrFrst());
		msaBaseSect.setOriginalId(spBaseSect.getSectId()+"");
		msaBaseSectMapper.insertSelective(msaBaseSect);
	}
	
	//新增房子
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateHouse(SpBaseHouse spBaseHouse) {
		MsaBaseHouse msaBaseHouse = new MsaBaseHouse();
		BeanUtils.copyProperties(spBaseHouse, msaBaseHouse);
		msaBaseHouseMapper.insertSelective(msaBaseHouse);
	}
	
	//新增业主
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateCust(SpBaseCust spBaseCust) {
		MsaBaseCust msaBaseCust = new MsaBaseCust();
		BeanUtils.copyProperties(spBaseCust, msaBaseCust);
		msaBaseCust.setOriginalId(spBaseCust.getCustId()+"");
		msaBaseCustMapper.insertSelective(msaBaseCust);
	}
	
	//新增车辆
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateCar(SpBaseCustCar spBaseCustCar) {
		MsaBaseCustCar msaBaseCustCar = new MsaBaseCustCar();
		BeanUtils.copyProperties(spBaseCustCar, msaBaseCustCar);
		msaBaseCustCar.setOriginalId(spBaseCustCar.getCarId()+"");
		msaBaseCustCarMapper.insertSelective(msaBaseCustCar);
	}
	
	//新增室
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateCell(SpBaseMngCell spBaseMngCell) {
		MsaBaseCell msaBaseCell = new MsaBaseCell();
		BeanUtils.copyProperties(spBaseMngCell, msaBaseCell);
		msaBaseCell.setOriginalId(spBaseMngCell.getMngCellId()+"");
		msaBaseCellMapper.insertSelective(msaBaseCell);
	}
	
	//编辑车辆
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateEditCar(SpBaseCustCar spBaseCustCar) {
		MsaBaseCustCar msaBaseCustCar = new MsaBaseCustCar();
		BeanUtils.copyProperties(spBaseCustCar, msaBaseCustCar);
		msaBaseCustCarMapper.updateByPrimaryKeySelective(msaBaseCustCar);
	}
	
	//编辑车辆
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateEditCarFeeStartDate(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate) {
		MsaBaseCustCarFeeStartDate msaBaseCustCarFeeStartDate = new MsaBaseCustCarFeeStartDate();
		BeanUtils.copyProperties(spBaseCustCarFeeStartDate, msaBaseCustCarFeeStartDate);
		msaBaseCustCarFeeStartDateMapper.updateByPrimaryKeySelective(msaBaseCustCarFeeStartDate);
	}
	

	@Override
	public BaseResult<String> migrateCustData(SpBaseCust spBaseCust) {
		migrateCust(spBaseCust);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateCarData(CarInfoVO carVo) {
		SpBaseCustCar spBaseCustCar = carVo.getSpBaseCustCar();
		migrateCar(spBaseCustCar);
		SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate = carVo.getSpBaseCustCarFeeStartDate();
		migrateCarStartDate(spBaseCustCarFeeStartDate);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateCellData(SpBaseMngCell spBaseMngCell) {
		migrateCell(spBaseMngCell);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Transactional(rollbackFor={BusinessException.class})
	private void migrateCarStartDate(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate) {
		MsaBaseCustCarFeeStartDate msaBaseCustCarFeeStartDate = new MsaBaseCustCarFeeStartDate();
		BeanUtils.copyProperties(spBaseCustCarFeeStartDate, msaBaseCustCarFeeStartDate);
		msaBaseCustCarFeeStartDateMapper.insertSelective(msaBaseCustCarFeeStartDate);
	}

	@Override
	public BaseResult<String> migrateEditCarData(CarInfoVO carVo) {
		SpBaseCustCar spBaseCustCar = carVo.getSpBaseCustCar();
		SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate = carVo.getSpBaseCustCarFeeStartDate();
		migrateEditCar(spBaseCustCar);
		migrateEditCarFeeStartDate(spBaseCustCarFeeStartDate);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateEditSectData(SpBaseSect spBaseSect) {
		migrateEditSect(spBaseSect);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	//编辑小区
	@Transactional(rollbackFor={BusinessException.class})
	private void migrateEditSect(SpBaseSect spBaseSect) {
		MsaBaseSect msaBaseSect = new MsaBaseSect();
		BeanUtils.copyProperties(spBaseSect, msaBaseSect);
		msaBaseSect.setRemark(spBaseSect.getSectId().toString());
		msaBaseSect.setStatus(spBaseSect.getSectStatus());
		msaBaseSect.setSectName(spBaseSect.getSectNameFrst());
		msaBaseSect.setSectAddr(spBaseSect.getSectAddrFrst());
		msaBaseSect.setOriginalId(spBaseSect.getSectId()+"");
		msaBaseSectMapper.updateByPrimaryKeySelective(msaBaseSect);
	}

	@Override
	public BaseResult<String> migrateEditHouseData(SpBaseHouse spBaseHouse) {
		migrateEditHouse(spBaseHouse);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}
	
	//编辑房子
	@Transactional(rollbackFor={BusinessException.class})
	private void migrateEditHouse(SpBaseHouse spBaseHouse) {
		MsaBaseHouse msaBaseHouse = new MsaBaseHouse();
		BeanUtils.copyProperties(spBaseHouse, msaBaseHouse);
		msaBaseHouseMapper.updateByPrimaryKeySelective(msaBaseHouse);
	}

	@Override
	public BaseResult<String> migrateEditCustData(SpBaseCust spBaseCust) {
		migrateEditCust(spBaseCust);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	//编辑业主
	@Transactional(rollbackFor={BusinessException.class})
	private void migrateEditCust(SpBaseCust spBaseCust) {
		MsaBaseCust msaBaseCust = new MsaBaseCust();
		BeanUtils.copyProperties(spBaseCust, msaBaseCust);
		msaBaseCust.setOriginalId(spBaseCust.getCustId()+"");
		msaBaseCustMapper.updateByPrimaryKeySelective(msaBaseCust);
	}

	@Override
	public BaseResult<String> migrateEditCellData(SpBaseMngCell spBaseMngCell) {
		migrateEditCell(spBaseMngCell);
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	//编辑室
	@Transactional(rollbackFor={BusinessException.class})
	private void migrateEditCell(SpBaseMngCell spBaseMngCell) {
		MsaBaseCell msaBaseCell = new MsaBaseCell();
		BeanUtils.copyProperties(spBaseMngCell, msaBaseCell);
		msaBaseCell.setOriginalId(spBaseMngCell.getMngCellId()+"");
		msaBaseCellMapper.updateByPrimaryKeySelective(msaBaseCell);
	}

	@Override
	public BaseResult<String> migrateDelSectData(String sectId) {
		msaBaseSectMapper.deleteByPrimaryKey(Long.valueOf(sectId));
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateDelHouseData(String houseId) {
		msaBaseHouseMapper.deleteByPrimaryKey(Long.valueOf(houseId));
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateDelCustData(String custId) {
		msaBaseCustMapper.deleteByPrimaryKey(Long.valueOf(custId));
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateDelCarData(String carId) {
		msaBaseCustCarMapper.deleteByPrimaryKey(Long.valueOf(carId));
		msaBaseCustCarFeeStartDateMapper.deleteByPrimaryKey(Long.valueOf(carId));
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Override
	public BaseResult<String> migrateDelCellData(String cellId) {
		msaBaseCellMapper.deleteByPrimaryKey(Long.valueOf(cellId));
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

}
