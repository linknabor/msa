package com.eshequ.msa.crm.mapper;

import java.util.List;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;

public interface CrmMarketingCustMapper extends CommonMapper<CrmMarketingCust> {
    public List<CrmMarketingCust> queryCustByExample(TargetCustVo vo);
}