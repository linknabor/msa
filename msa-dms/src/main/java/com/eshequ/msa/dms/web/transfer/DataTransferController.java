package com.eshequ.msa.dms.web.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.service.transfer.DataTransferService;
import com.eshequ.msa.dms.web.BaseController;

public class DataTransferController extends BaseController {
	
	//TODO 检验签名函数

	@Autowired
	private DataTransferService dataTransferService;
	
	@RequestMapping(value = "/migrateSectData", method = RequestMethod.POST)
	public BaseResult<?> addSect(SpBaseSect spBaseSect) {
		
		return dataTransferService.migrateSectData(spBaseSect);
	}
	
	@RequestMapping(value = "/migrateHouseData", method = RequestMethod.POST)
	public BaseResult<?> addHouse(SpBaseHouse spBaseHouse){
		return dataTransferService.migrateHouseData(spBaseHouse);
	}
	
	@RequestMapping(value = "/migrateCustData", method = RequestMethod.POST)
	public BaseResult<?> addCust(SpBaseCust spBaseCust){
		return dataTransferService.migrateCustData(spBaseCust);
	}
	
	@RequestMapping(value = "/migrateCarData", method = RequestMethod.POST)
	public BaseResult<?> addCar(SpBaseCustCar spBaseCustCar){
		return dataTransferService.migrateCarData(spBaseCustCar);
	}
	
	@RequestMapping(value = "/migrateCellData", method = RequestMethod.POST)
	public BaseResult<?> addCell(SpBaseMngCell spBaseMngCell){
		return dataTransferService.migrateCellData(spBaseMngCell);
	}
	
	@RequestMapping(value = "/migrateCarStartDateData", method = RequestMethod.POST)
	public BaseResult<?> addCarStartDate(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate){
		return dataTransferService.migrateCarStartDateData(spBaseCustCarFeeStartDate);
	}
}
