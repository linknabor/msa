package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmMarketingCustCall;

public interface CrmMarketingCustCallMapper extends CommonMapper<CrmMarketingCustCall> {
    int deleteByPrimaryKey(String callId);

    int insert(CrmMarketingCustCall record);

    int insertSelective(CrmMarketingCustCall record);

    CrmMarketingCustCall selectByPrimaryKey(String callId);

    int updateByPrimaryKeySelective(CrmMarketingCustCall record);

    int updateByPrimaryKey(CrmMarketingCustCall record);
}