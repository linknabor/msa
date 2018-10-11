package com.eshequ.msa.dms.web.transfer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.service.transfer.BaseDataBatchTransferService;
import com.eshequ.msa.dms.vo.basedata.CspVO;

@RestController
public class BaseDataTransferController extends DataTransferController {
	
	@Autowired
	private BaseDataBatchTransferService baseDataBatchTransferService;
	
	@RequestMapping(value = "/migrateBaseDataBatch", method = RequestMethod.POST)
	public BaseResult<?> addProvinceBatch() {
		
		return baseDataBatchTransferService.migrateBaseData();
	}
	
	@RequestMapping(value = "/migrateCellDataBatch", method = RequestMethod.POST)
	public BaseResult<?> addCellBatch() {
		
		return baseDataBatchTransferService.migrateCellData();
	}
	
	@RequestMapping(value = "/addCsp", method = RequestMethod.POST)
	public BaseResult<?> addEnterprise(CspVO cspVO) {
		
		return null;
	}
	
	@RequestMapping(value = "/updateCsp", method = RequestMethod.POST)
	public BaseResult<?> updateEnterpriseBatch(CspVO cspVO) {
		
		return null;
	}
	
	@RequestMapping(value = "/deleteCsp", method = RequestMethod.POST)
	public BaseResult<?> deleteEnterprise(CspVO cspVO) {
		
		return null;
	}
	

}
