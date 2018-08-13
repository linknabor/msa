package com.eshequ.msa.crm.mapper;

import java.util.List;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.SpServeBillPayTrade;

public interface SpServeBillPayTradeMapper extends CommonMapper<SpServeBillPayTrade> {
 
	List<SpServeBillPayTrade> getBillTradeByCsp(String cspId);
		
	
}	