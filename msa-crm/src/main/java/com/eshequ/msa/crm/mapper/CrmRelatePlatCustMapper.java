package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmRelatePlatCust;

public interface CrmRelatePlatCustMapper extends CommonMapper<CrmRelatePlatCust> {
    int deleteByPrimaryKey(Long custId);

    int insert(CrmRelatePlatCust record);

    int insertSelective(CrmRelatePlatCust record);

    CrmRelatePlatCust selectByPrimaryKey(Long custId);

    int updateByPrimaryKeySelective(CrmRelatePlatCust record);

    int updateByPrimaryKey(CrmRelatePlatCust record);
}