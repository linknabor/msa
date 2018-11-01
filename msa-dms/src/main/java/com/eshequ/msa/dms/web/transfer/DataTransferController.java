package com.eshequ.msa.dms.web.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.service.transfer.DataTransferService;
import com.eshequ.msa.dms.vo.basedata.CarInfoVO;
import com.eshequ.msa.dms.web.BaseController;

public class DataTransferController extends BaseController {
	
	//TODO 检验签名函数

	@Autowired
	private DataTransferService dataTransferService;
	
	@RequestMapping(value = "/migrateSectData", method = RequestMethod.POST)
	public BaseResult<?> addSect(@RequestBody SpBaseSect spBaseSect) {
		
		return dataTransferService.migrateSectData(spBaseSect);
	}
	
	@RequestMapping(value = "/migrateEditSectData", method = RequestMethod.POST)
	public BaseResult<?> editSect(@RequestBody SpBaseSect spBaseSect) {
		
		return dataTransferService.migrateEditSectData(spBaseSect);
	}
	
	@RequestMapping(value = "/migrateHouseData", method = RequestMethod.POST)
	public BaseResult<?> addHouse(@RequestBody SpBaseHouse spBaseHouse){
		return dataTransferService.migrateHouseData(spBaseHouse);
	}
	
	@RequestMapping(value = "/migrateEditHouseData", method = RequestMethod.POST)
	public BaseResult<?> editHouse(@RequestBody SpBaseHouse spBaseHouse){
		return dataTransferService.migrateEditHouseData(spBaseHouse);
	}
	
	@RequestMapping(value = "/migrateCustData", method = RequestMethod.POST)
	public BaseResult<?> addCust(@RequestBody SpBaseCust spBaseCust){
		return dataTransferService.migrateCustData(spBaseCust);
	}
	
	@RequestMapping(value = "/migrateEditCustData", method = RequestMethod.POST)
	public BaseResult<?>editCust(@RequestBody SpBaseCust spBaseCust){
		return dataTransferService.migrateEditCustData(spBaseCust);
	}
	
	@RequestMapping(value = "/migrateCarData", method = RequestMethod.POST)
	public BaseResult<?> addCar(@RequestBody CarInfoVO carVo){
		return dataTransferService.migrateCarData(carVo);
	}
	
	@RequestMapping(value = "/migrateEditCarData", method = RequestMethod.POST)
	public BaseResult<?> editCar(@RequestBody CarInfoVO carVo){
		return dataTransferService.migrateEditCarData(carVo);
	}
	
	@RequestMapping(value = "/migrateCellData", method = RequestMethod.POST)
	public BaseResult<?> addCell(@RequestBody SpBaseMngCell spBaseMngCell){
		return dataTransferService.migrateCellData(spBaseMngCell);
	}
	
	@RequestMapping(value = "/migrateEditCellData", method = RequestMethod.POST)
	public BaseResult<?> editCell(@RequestBody SpBaseMngCell spBaseMngCell){
		return dataTransferService.migrateEditCellData(spBaseMngCell);
	}
}
