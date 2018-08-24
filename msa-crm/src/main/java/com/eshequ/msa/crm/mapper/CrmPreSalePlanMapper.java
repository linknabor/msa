package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmPreSalePlan;

public interface CrmPreSalePlanMapper extends CommonMapper<CrmPreSalePlan> {
    int deleteByPrimaryKey(String planId);

    int insert(CrmPreSalePlan record);

    int insertSelective(CrmPreSalePlan record);

    CrmPreSalePlan selectByPrimaryKey(String planId);

    int updateByPrimaryKeySelective(CrmPreSalePlan record);

    int updateByPrimaryKey(CrmPreSalePlan record);
}