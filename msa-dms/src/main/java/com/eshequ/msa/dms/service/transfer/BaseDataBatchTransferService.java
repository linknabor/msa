package com.eshequ.msa.dms.service.transfer;

import com.eshequ.msa.common.BaseResult;

public interface BaseDataBatchTransferService {

	/**
	 * 批量迁移省份
	 * @return
	 */
	public BaseResult<String> migrateProvinceBatch();
	
	/**
	 * 批量迁移城市
	 * @return
	 */
	public BaseResult<String> migrateCityBatch();
		
	/**
	 * 批量迁移区县
	 * @return
	 */
	public BaseResult<String> migrateRegionBatch();
		
	/**
	 * 批量迁移物业公司
	 * @return
	 */
	public BaseResult<?> migrateEnterpriseBatch();
		
	
}
