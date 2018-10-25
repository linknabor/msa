package com.eshequ.msa.dms.service.transfer;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;

public interface DataTransferService{

	BaseResult<String> migrateSectData(SpBaseSect spBaseSect);
	BaseResult<String> migrateHouseData(SpBaseHouse spBaseHouse);
	BaseResult<String> migrateCustData(SpBaseCust spBaseCust);
	BaseResult<String> migrateCarData(SpBaseCustCar spBaseCustCar);
	BaseResult<String> migrateCarStartDateData(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate);
	BaseResult<String> migrateCellData(SpBaseMngCell spBaseMngCell);
}
