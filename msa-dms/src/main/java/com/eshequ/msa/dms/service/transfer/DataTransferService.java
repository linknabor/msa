package com.eshequ.msa.dms.service.transfer;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.vo.basedata.CarInfoVO;

public interface DataTransferService{

	//小区
	BaseResult<String> migrateSectData(SpBaseSect spBaseSect);
	BaseResult<String> migrateEditSectData(SpBaseSect spBaseSect);
	BaseResult<String> migrateDelSectData(String sectId);
	
	//房子
	BaseResult<String> migrateHouseData(SpBaseHouse spBaseHouse);
	BaseResult<String> migrateEditHouseData(SpBaseHouse spBaseHouse);
	BaseResult<String> migrateDelHouseData(String houseId);
	
	//业主
	BaseResult<String> migrateCustData(SpBaseCust spBaseCust);
	BaseResult<String> migrateEditCustData(SpBaseCust spBaseCust);
	BaseResult<String> migrateDelCustData(String custId);
	
	//汽车
	BaseResult<String> migrateCarData(CarInfoVO carvo);
	BaseResult<String> migrateEditCarData(CarInfoVO carvo);
	BaseResult<String> migrateDelCarData(String carId);
	
	//房间门牌
	BaseResult<String> migrateCellData(SpBaseMngCell spBaseMngCell);
	BaseResult<String> migrateEditCellData(SpBaseMngCell spBaseMngCell);
	BaseResult<String> migrateDelCellData(String cellId);
	
}
