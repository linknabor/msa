package com.eshequ.crm.mapper;

import java.util.List;

import com.eshequ.crm.common.CommonMapper;
import com.eshequ.crm.model.SpServeBillPayTrade;

public interface SpServeBillPayTradeMapper extends CommonMapper<SpServeBillPayTrade> {
 
	List<SpServeBillPayTrade> getBillTradeByCsp(String cspId);
		
	
}	