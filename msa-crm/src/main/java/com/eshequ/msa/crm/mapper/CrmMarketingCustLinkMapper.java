package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmMarketingCustLink;

public interface CrmMarketingCustLinkMapper extends CommonMapper<CrmMarketingCustLink> {
    int deleteByPrimaryKey(String linkId);

    int insert(CrmMarketingCustLink record);

    int insertSelective(CrmMarketingCustLink record);

    CrmMarketingCustLink selectByPrimaryKey(String linkId);

    int updateByPrimaryKeySelective(CrmMarketingCustLink record);

    int updateByPrimaryKey(CrmMarketingCustLink record);
}