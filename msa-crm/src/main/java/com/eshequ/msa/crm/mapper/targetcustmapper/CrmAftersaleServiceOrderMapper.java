package com.eshequ.msa.crm.mapper.targetcustmapper;

import com.eshequ.msa.crm.model.targetcustmodel.CrmAftersaleServiceOrder;

public interface CrmAftersaleServiceOrderMapper {
    int deleteByPrimaryKey(String serviceOrderId);

    int insert(CrmAftersaleServiceOrder record);

    int insertSelective(CrmAftersaleServiceOrder record);

    CrmAftersaleServiceOrder selectByPrimaryKey(String serviceOrderId);

    int updateByPrimaryKeySelective(CrmAftersaleServiceOrder record);

    int updateByPrimaryKey(CrmAftersaleServiceOrder record);
}