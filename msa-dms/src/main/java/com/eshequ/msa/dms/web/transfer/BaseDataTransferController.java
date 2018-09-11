package com.eshequ.msa.dms.web.transfer;



import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.model.msa.MsaBaseCity;
import com.eshequ.msa.dms.model.msa.MsaBaseRegion;
import com.eshequ.msa.dms.vo.basedata.CspVO;
import com.eshequ.msa.dms.vo.basedata.ProvinceVO;

@RestController
public class BaseDataTransferController extends DataTransferController {
	
	@RequestMapping(value = "/addProvinceBatch", method = RequestMethod.POST)
	public BaseResult<?> addProvinceBatch(List<ProvinceVO> provinceList) {
		
		return null;
	}
	
	@RequestMapping(value = "/addCityBatch", method = RequestMethod.POST)
	public BaseResult<?> addCityBatch(List<MsaBaseCity> cityList) {
		
		return null;
	}
	
	@RequestMapping(value = "/addRegionBatch", method = RequestMethod.POST)
	public BaseResult<?> addRegionBatch(List<MsaBaseRegion> region) {
		
		return null;
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
	
	@RequestMapping(value = "/addCspBatch", method = RequestMethod.POST)
	public BaseResult<?> addEnterpriseBatch(CspVO cspVO) {
		
		return null;
	}

}
