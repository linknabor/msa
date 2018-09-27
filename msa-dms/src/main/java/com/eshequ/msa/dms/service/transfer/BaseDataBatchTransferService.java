package com.eshequ.msa.dms.service.transfer;

import com.eshequ.msa.common.BaseResult;

public interface BaseDataBatchTransferService {
	
	BaseResult<String> migrateBaseData();

}
