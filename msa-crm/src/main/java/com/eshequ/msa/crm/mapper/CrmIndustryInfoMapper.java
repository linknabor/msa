package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.model.CrmIndustryInfo;

public interface CrmIndustryInfoMapper {
    int deleteByPrimaryKey(Long industryId);

    int insert(CrmIndustryInfo record);

    int insertSelective(CrmIndustryInfo record);

    CrmIndustryInfo selectByPrimaryKey(Long industryId);

    int updateByPrimaryKeySelective(CrmIndustryInfo record);

    int updateByPrimaryKey(CrmIndustryInfo record);
}