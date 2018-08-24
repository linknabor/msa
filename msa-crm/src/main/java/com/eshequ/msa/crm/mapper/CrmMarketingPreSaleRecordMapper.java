package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmMarketingPreSaleRecord;

public interface CrmMarketingPreSaleRecordMapper extends CommonMapper<CrmMarketingPreSaleRecord> {
    int deleteByPrimaryKey(String recordId);

    int insert(CrmMarketingPreSaleRecord record);

    int insertSelective(CrmMarketingPreSaleRecord record);

    CrmMarketingPreSaleRecord selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(CrmMarketingPreSaleRecord record);

    int updateByPrimaryKey(CrmMarketingPreSaleRecord record);
}