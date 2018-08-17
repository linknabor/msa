package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.model.CrmAftersaleService;

public interface CrmAftersaleServiceMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(CrmAftersaleService record);

    int insertSelective(CrmAftersaleService record);

    CrmAftersaleService selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(CrmAftersaleService record);

    int updateByPrimaryKey(CrmAftersaleService record);
}