package com.eshequ.msa.dms.service.transfer;

import com.eshequ.msa.common.BaseResult;

public interface DataTransferService {

	BaseResult<String> migrateSect();
	BaseResult<String> migrateHouse();
}
