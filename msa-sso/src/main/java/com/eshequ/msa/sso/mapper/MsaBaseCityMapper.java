package com.eshequ.msa.sso.mapper;

import java.util.List;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.MsaBaseCity;

public interface MsaBaseCityMapper extends CommonMapper<MsaBaseCity>{
	
	List<MsaBaseCity>  getCityList();

}
